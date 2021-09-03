package com.xhsj.customview.recyclerceiling;

import android.content.Context;
import android.os.Bundle;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.xhsj.customview.R;
import com.xhsj.customview.recyclerceiling.expand.ExpandMainActivity;
import com.xhsj.customview.recyclerceiling.grid.GridRecyclerActivity;
import com.xhsj.customview.recyclerceiling.linear.LinearRecyclerActivity;


public class MainActivity extends AppCompatActivity {


	private Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_ceil);
		mContext = this;
		findViewById(R.id.layout_pinned_header_linear).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				LinearRecyclerActivity.startUp(mContext);
			}
		});
		findViewById(R.id.layout_pinned_header_grid).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				GridRecyclerActivity.startUp(mContext);
			}
		});

		findViewById(R.id.layout_pinned_header_expand).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ExpandMainActivity.startUp(mContext);
			}
		});
	}
}
