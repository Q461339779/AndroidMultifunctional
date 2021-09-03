package com.xhsj.customview.viewpagerlazyload.vp2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.xhsj.customview.R;
import com.xhsj.customview.viewpagerlazyload.FragmentDelegater;
import com.xhsj.customview.viewpagerlazyload.base.LazyFragment5;


// 同学们：这是T2  嵌套了一层 ViewPager的Fragment2_vp_1
public class Fragment2_vp_1 extends LazyFragment5 {

    private static final String TAG = "Fragment2_vp_1";

    public static Fragment newIntance() {
        Fragment2_vp_1 fragment = new Fragment2_vp_1();
        fragment.setFragmentDelegater(new FragmentDelegater(fragment));
        return fragment;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_vp_1_lazyload;
    }

    @Override
    protected void initView(View view) {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onFragmentLoadStop() {
        super.onFragmentLoadStop();
        Log.d(TAG, "onFragmentLoadStop" + " 停止一切更新");
    }

    @Override
    public void onFragmentLoad() {
        super.onFragmentLoad();
        Log.d(TAG, "onFragmentLoad" + " 真正更新数据");
    }
}
