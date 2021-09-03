package com.xhsj.customview;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;

public class PropertyActivity extends AppCompatActivity {

    private MoveView moveView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);

        moveView = findViewById(R.id.move_view);

        @SuppressLint("ObjectAnimatorBinding")
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(moveView,"translationX",800);
        objectAnimator.setDuration(10000);
        objectAnimator.start();
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

            }
        });
    }
}