package com.qushaobo.annotationreflection;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class InjectUtils {
    public static void injectView(Activity activity) {

        Class<? extends Activity> cls = activity.getClass();

        //获取当前类的所有的成员
        Field[] fields = cls.getDeclaredFields();
        //获取自己和父类的所有public 成员
        Field[] fields1 = cls.getFields();

        for (Field field : fields) {
           //判断是否被InjectView 申明
            if (field.isAnnotationPresent(InjectView.class)){
                InjectView injectView = field.getAnnotation(InjectView.class);
                //获取注解中设置的id
                int id = injectView.value();
                View view = activity.findViewById(id);
                //设置访问权限 允许操作private属性
                field.setAccessible(true);
                //赋值
                try {
                    field.set(activity,view);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void injectAutowired(Activity activity){
        Class <? extends Activity> cls = activity.getClass();
        //获取数据
        Intent intent = activity.getIntent();
        Bundle extras = intent.getExtras();
        if (extras == null){
            return;
        }

        Field[] fields = cls.getDeclaredFields();
        for (Field field:fields){
            if (field.isAnnotationPresent(Autowired.class)){
                Autowired autowired = field.getAnnotation(Autowired.class);
                String key = TextUtils.isEmpty(autowired.value())?field.getName():autowired.value();
                if (extras.containsKey(key)){
                    Object obj = extras.get(key);
                    Class<?> componentType = field.getType().getComponentType();
                    //当前属性是数组并且Parcelable(子类)数组
                    if (field.getType().isArray() &&
                            Parcelable.class.isAssignableFrom(componentType)) {
                        Object[] objs = (Object[]) obj;
                        //创建对应类型的数组并由objs拷贝
                        Object[] objects = Arrays.copyOf(objs, objs.length, (Class<? extends Object[]>) field.getType());
                        obj = objects;
                    }

                    field.setAccessible(true);
                    try {
                        field.set(activity,obj);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
            }
        }

    }

    public static void injectEvent(Activity activity) {
        Class<? extends Activity> activityClass = activity.getClass();
        Method[] declaredMethods = activityClass.getDeclaredMethods();


        for (Method method : declaredMethods) {
            //获得方法上所有注解
            Annotation[] annotations = method.getAnnotations();

            for (Annotation annotation : annotations) {
                //注解类型
                Class<? extends Annotation> annotationType = annotation.annotationType();
                if (annotationType.isAnnotationPresent(EventType.class)) {
                    EventType eventType = annotationType.getAnnotation(EventType.class);
                    // OnClickListener.class
                    Class listenerType = eventType.listenerType();
                    //setOnClickListener
                    String listenerSetter = eventType.listenerSetter();

                    try {
                        // 不需要关心到底是OnClick 还是 OnLongClick
                        Method valueMethod = annotationType.getDeclaredMethod("value");
                        int[] viewIds = (int[]) valueMethod.invoke(annotation);

                        method.setAccessible(true);
                        ListenerInvocationHandler<Activity> handler = new ListenerInvocationHandler(activity, method);
                        Object listenerProxy = Proxy.newProxyInstance(listenerType.getClassLoader(),
                                new Class[]{listenerType}, handler);
                        // 遍历注解的值
                        for (int viewId : viewIds) {
                            // 获得当前activity的view（赋值）
                            View view = activity.findViewById(viewId);
                            // 获取指定的方法(不需要判断是Click还是LongClick)
                            // 如获得：setOnClickLisnter方法，参数为OnClickListener
                            // 获得 setOnLongClickLisnter，则参数为OnLongClickLisnter
                            Method setter = view.getClass().getMethod(listenerSetter, listenerType);
                            // 执行方法
                            setter.invoke(view, listenerProxy); //执行setOnclickListener里面的回调 onclick方法
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    /**
     * 还可能在自定义view注入，所以是泛型： T = Activity/View
     *
     * @param <T>
     */
    static class ListenerInvocationHandler<T> implements InvocationHandler {

        private Method method;
        private T target;

        public ListenerInvocationHandler(T target, Method method) {
            this.target = target;
            this.method = method;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return this.method.invoke(target, args);
        }
    }

}
