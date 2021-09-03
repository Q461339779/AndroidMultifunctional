package com.qushaobo.jetpack;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

public class MyObserver implements LifecycleObserver {

    private String TAG = "Lifecycle_test";

    @OnLifecycleEvent(value = Lifecycle.Event.ON_RESUME)
    public void connect(){
        Log.i(TAG,"connect");
    }

    @OnLifecycleEvent(value = Lifecycle.Event.ON_PAUSE)
    public void disConnect(){
        Log.i(TAG,"disConnect");
    }
}
