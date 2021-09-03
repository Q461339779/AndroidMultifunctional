package com.xhsj.customview.fish;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.xhsj.customview.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fish);
//        ImageView iv = findViewById(R.id.iv_fish);
//        iv.setImageDrawable(new FishDrawable());
    }
}