package com.xhsj.customview.materialdesign.tab;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.xhsj.customview.databinding.ActivityTabBinding;

public class TabActivity extends AppCompatActivity {

    private ActivityTabBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTabBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}