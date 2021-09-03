package com.xhsj.customview.materialdesign.nestedscroll.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.xhsj.customview.databinding.ActivityNestScrollBinding;


public class NestScrollActivity extends AppCompatActivity {

    private ActivityNestScrollBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNestScrollBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}