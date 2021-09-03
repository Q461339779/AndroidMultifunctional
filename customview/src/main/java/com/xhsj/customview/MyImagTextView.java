package com.xhsj.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class MyImagTextView extends LinearLayout {

    private ImageView imageView = null;
    private TextView textView = null;

    private int imageId,pressImageId;

    private int textId,textColorId,textTopId,pressTextColorId;



    public MyImagTextView(Context context) {
        this(context,null);

    }

    public MyImagTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyImagTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setOrientation(LinearLayout.VERTICAL);
        this.setGravity(Gravity.CENTER);
        if (imageView == null){
            imageView = new ImageView(context);
        }
        if (textView==null){
            textView = new TextView(context);
        }

        if (attrs == null){
            return;
        }

        int count = attrs.getAttributeCount();
        for (int i = 0; i <count; i++) {
            String attrName = attrs.getAttributeName(i);
            switch (attrName) {
                //显示的图片
                case "image":
                    imageId = attrs.getAttributeResourceValue(i, 0);
                    break;
                //按下时显示的图片
                case "pressImage":
                    pressImageId = attrs.getAttributeResourceValue(i, 0);
                    break;
                //显示的文字
                case "text":
                    textId = attrs.getAttributeResourceValue(i, 0);
                    break;
                //设置文字颜色
                case "textColor":
                    textColorId = attrs.getAttributeResourceValue(i, 0);
                    break;
                //设置文字距离上面图片的距离
                case "textTop":
                    textTopId = attrs.getAttributeResourceValue(i, 0);
                    break;
                //按下时显示的文字颜色
                case "pressTextColor":
                    pressTextColorId = attrs.getAttributeResourceValue(i, 0);
                    break;

            }
        }
        }
    }

