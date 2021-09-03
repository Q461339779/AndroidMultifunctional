package com.xhsj.customview.viewpagerlazyload.vp2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.xhsj.customview.R;
import com.xhsj.customview.viewpagerlazyload.FragmentDelegater;
import com.xhsj.customview.viewpagerlazyload.base.LazyFragment5;


public class Fragment2_vp_2 extends LazyFragment5 {

    public static Fragment newIntance() {
        Fragment2_vp_2 fragment = new Fragment2_vp_2();
        fragment.setFragmentDelegater(new FragmentDelegater(fragment));
        return fragment;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_vp_2_lazyload;
    }

    @Override
    protected void initView(View view) { }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
