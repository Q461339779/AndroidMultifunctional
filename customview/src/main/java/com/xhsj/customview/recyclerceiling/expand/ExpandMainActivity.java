package com.xhsj.customview.recyclerceiling.expand;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.xhsj.customview.R;
import com.xhsj.customview.recyclerceiling.grid.GridRecyclerActivity;
import com.xhsj.customview.recyclerceiling.pinnedheader.PinnedHeaderItemDecoration;
import com.xhsj.customview.recyclerceiling.pinnedheader.PinnedHeaderRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ExpandMainActivity extends AppCompatActivity {

	private Context mContext;
	private PinnedHeaderRecyclerView mRecyclerView;
	private LinearLayoutManager mLayoutManager;
	private PatrolGroupAdapter       mAdapter;

	public static void startUp(Context context) {
		context.startActivity(new Intent(context, ExpandMainActivity.class));
	}


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_expand);
		mContext = this;
		initView();
		initEvent();
		initData();
	}

	private void initView() {
		mRecyclerView = findViewById(R.id.recycler_order_list);
		mRecyclerView.setLayoutManager(mLayoutManager = new LinearLayoutManager(mContext));
		mRecyclerView.addItemDecoration(new PinnedHeaderItemDecoration());
	}

	private void initEvent() {
		/**
		 * 当标题栏被悬浮的时候的点击功能
		 */
		mRecyclerView.setOnPinnedHeaderClickListener(new PinnedHeaderRecyclerView.OnPinnedHeaderClickListener() {
			@Override
			public void onPinnedHeaderClick(int adapterPosition) {
				mAdapter.switchExpand(adapterPosition);
				//标题栏被点击之后，滑动到指定位置
				mLayoutManager.scrollToPositionWithOffset(adapterPosition, 0);
			}
		});
	}

	private void initData() {
		mAdapter = new PatrolGroupAdapter();
		mAdapter.setData(obtainDataList());
		mRecyclerView.setAdapter(mAdapter);
	}

	private List<ExpandGroupItemEntity<String, PatrolItem>> obtainDataList() {
		List<ExpandGroupItemEntity<String, PatrolItem>> dataList = new ArrayList<>();

		for (int group = 0; group < 10; group++) {
			ExpandGroupItemEntity<String, PatrolItem> groupItem = new ExpandGroupItemEntity<>();
			groupItem.setExpand(true);
			groupItem.setParent("分组 " + group);
			List<PatrolItem> childList = new ArrayList<>();
			for (int child = 0; child < group + 1; child++) {
				PatrolItem childItem = new PatrolItem();
				childItem.setTime("2018-04-20 15:00");
				childItem.setFactoryName((2000 + child) + " 项目");
				childItem.setUser("电工 " + child);
				childItem.setState(child % 5);
				childList.add(childItem);
			}
			groupItem.setChildList(childList);
			dataList.add(groupItem);
		}

		return dataList;
	}
}
