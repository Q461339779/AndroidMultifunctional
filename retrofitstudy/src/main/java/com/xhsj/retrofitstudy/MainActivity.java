package com.xhsj.retrofitstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        request();
    }

    private void request() {
//        OkHttpClient okHttpClient = new OkHttpClient;
//        Request request = new Request.Builder()
//                .url("https://wanandroid.com/")
//                .get()
//                .build();
//
//        okhttp3.Call call1 = okHttpClient.newCall(request);
//
//        call1.enqueue(new okhttp3.Callback() {
//            @Override
//            public void onFailure(okhttp3.Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
//
//            }
//        });
        //创建retrofit
        Retrofit retrofit =
                new Retrofit
                        .Builder()
                        //.baseUrl("https://wanandroid.com/")
                        //设置使用Gson解析
                        .addConverterFactory(GsonConverterFactory.create())

                        .build();

        //创建网络请求接口  获取到代理对象
        GetRequest_Interface request_interface = retrofit.create(GetRequest_Interface.class);
        //对发送请求进行封装  执行动态代理的invoke方法
        Call<Translation> call = request_interface.getCall();

        //发送异步网络请求
        call.enqueue(new Callback<Translation>() {
            @Override
            public void onResponse(Call<Translation> call, Response<Translation> response) {
                Log.i("MainActivity_LOG", response.body().getData().get(0).getName());
            }

            @Override
            public void onFailure(Call<Translation> call, Throwable t) {
                Log.i("MainActivity_LOG", t.toString());
            }
        });
    }
}
