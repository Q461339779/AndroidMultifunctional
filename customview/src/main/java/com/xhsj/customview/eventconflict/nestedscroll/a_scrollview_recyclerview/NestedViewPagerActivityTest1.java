package com.xhsj.customview.eventconflict.nestedscroll.a_scrollview_recyclerview;

import android.os.Bundle;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.xhsj.customview.R;
import com.xhsj.customview.databinding.ActivityNestedscrollScrollviewRecyclerviewBinding;
import com.xhsj.customview.eventconflict.fragment.RecyclerViewFragment;
import com.xhsj.customview.eventconflict.viewpager.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class NestedViewPagerActivityTest1 extends AppCompatActivity {
    ActivityNestedscrollScrollviewRecyclerviewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_nestedscroll_scrollview_recyclerview);
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(this, getPageFragments());
        binding.viewpagerView.setAdapter(pagerAdapter);
        final String[] labels = new String[]{"linear", "scroll", "recycler"};
        new TabLayoutMediator(binding.tablayout, binding.viewpagerView, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(labels[position]);
            }
        }).attach();
        binding.swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                binding.getRoot().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        binding.swipeRefreshLayout.setRefreshing(false);
                    }
                },1000);
            }
        });
    }

    private List<Fragment> getPageFragments() {
        List<Fragment> data = new ArrayList<>();
        data.add(new RecyclerViewFragment());
        data.add(new RecyclerViewFragment());
        data.add(new RecyclerViewFragment());
        return data;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }
}


