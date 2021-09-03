package com.xhsj.startup_mode;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TestFragment extends Fragment {

    public static final String TAG = "TAG_com.xhsj.startup_mode.MainActivity_Fragment1";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        logMessage("onCreateView");
        return inflater.inflate(R.layout.test_frgment, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        logMessage("onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        logMessage("onCreate");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        logMessage("onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        logMessage("onStart");

    }

    @Override
    public void onResume() {
        super.onResume();
        logMessage("onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        logMessage("onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        logMessage("onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        logMessage("onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        logMessage("onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        logMessage("onDetach");
    }


    public void logMessage(String msg){
        Log.i(TAG,msg);
        //logMessage("onCreateView");
    }
}
