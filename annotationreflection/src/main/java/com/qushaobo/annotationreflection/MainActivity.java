package com.qushaobo.annotationreflection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    @InjectView(R.id.tv)
    private TextView textView;
    @InjectView(R.id.button)
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InjectUtils.injectView(this);
        InjectUtils.injectEvent(this);
        textView.setText("初始化控件成功");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(MainActivity.this,SecondActivity.class)
                                .putExtra("name","qushaobo"));
            }
        });




    }
    @OnClick({R.id.btn1,R.id.btn2})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                Log.i(TAG,"click:按钮1");
                break;
            case R.id.btn2:
                Log.i(TAG,"click:按钮2");
                break;
        }
    }

    @OnLongClick({R.id.btn1,R.id.btn2})
    public boolean longClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                Log.i(TAG,"longClick:按钮1");
                break;
            case R.id.btn2:
                Log.i(TAG,"longClick:按钮2");
                break;
        }
        return true;//true 表示时间拦截不会再传递到 onclick当中
    }


 }
