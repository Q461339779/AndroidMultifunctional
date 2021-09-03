package com.qushaobo.annotationreflection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Autowired("name")
    String name;

    @InjectView(R.id.tv)
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        InjectUtils.injectView(this);
        InjectUtils.injectAutowired(this);

        textView.setText(name);

    }
}