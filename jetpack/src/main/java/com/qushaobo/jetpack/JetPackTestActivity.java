package com.qushaobo.jetpack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class JetPackTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jet_pack_test);

        getLifecycle().addObserver(new MyObserver());
    }
}
