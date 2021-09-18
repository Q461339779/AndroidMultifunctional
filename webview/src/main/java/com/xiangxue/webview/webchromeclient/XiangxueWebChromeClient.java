package com.xiangxue.webview.webchromeclient;

import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import com.xiangxue.webview.WebViewCallBack;

public class XiangxueWebChromeClient extends WebChromeClient {
    private WebViewCallBack mWebViewCallBack;
    private static final String TAG = "XiangxueWebChromeClient";

    public XiangxueWebChromeClient(WebViewCallBack webViewCallBack) {
        this.mWebViewCallBack = webViewCallBack;
    }

    @Override
    public void onReceivedTitle(WebView view, String title) {
        if(mWebViewCallBack != null) {
            mWebViewCallBack.updateTitle(title);
        } else {
            Log.e(TAG, "WebViewCallBack is null.");
        }
    }

}
