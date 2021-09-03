package com.xhsj.customview.webviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.xhsj.customview.R;
import com.xiangxue.base.autoservice.XiangxueServiceLoader;
import com.xiangxue.common.autoservice.IWebViewService;

public class WebMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_main);

        findViewById(R.id.open_webviewactivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IWebViewService webviewService = XiangxueServiceLoader.load(IWebViewService.class);
                if(webviewService != null) {
                    webviewService.startWebViewActivity(WebMainActivity.this, "https://www.baidu.com", "百度", false);
                }
            }
        });
    }
}