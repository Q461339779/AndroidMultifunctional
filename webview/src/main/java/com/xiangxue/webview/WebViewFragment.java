package com.xiangxue.webview;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.kingja.loadsir.callback.Callback;
import com.kingja.loadsir.core.LoadService;
import com.kingja.loadsir.core.LoadSir;

import com.xiangxue.base.loadsir.ErrorCallback;
import com.xiangxue.base.loadsir.LoadingCallback;
import com.xiangxue.webview.databinding.FragmentWebviewBinding;
import com.xiangxue.webview.utils.Constants;
import com.xiangxue.webview.webchromeclient.XiangxueWebChromeClient;
import com.xiangxue.webview.webviewclient.XiangxueWebViewClient;

public class WebViewFragment extends Fragment implements WebViewCallBack, SwipeRefreshLayout.OnRefreshListener {
    private String mUrl;
    private FragmentWebviewBinding mBinding;
    private LoadService mLoadService;
    private boolean mCanNativeRefresh;
    private boolean mIsError = false;
    private static final String TAG = "WebViewFragment";

    public static WebViewFragment newInstance(String url, boolean canNativeRefresh) {
        WebViewFragment fragment = new WebViewFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.URL, url);
        bundle.putBoolean(Constants.CAN_NATIVE_REFRESH, canNativeRefresh);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            mUrl = bundle.getString(Constants.URL);
            mCanNativeRefresh = bundle.getBoolean(Constants.CAN_NATIVE_REFRESH);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_webview, container, false);
        mBinding.webview.getSettings().setJavaScriptEnabled(true);
        mBinding.webview.loadUrl(mUrl);
        mLoadService = LoadSir.getDefault().register(mBinding.smartrefreshlayout, new Callback.OnReloadListener() {
            @Override
            public void onReload(View v) {
                mLoadService.showCallback(LoadingCallback.class);
                mBinding.webview.reload();
            }
        });
        mBinding.webview.setWebViewClient(new XiangxueWebViewClient(this));
        mBinding.webview.setWebChromeClient(new XiangxueWebChromeClient(this));
        mBinding.smartrefreshlayout.setOnRefreshListener(this);


        return mLoadService.getLoadLayout();
    }

    @Override
    public void pageStarted(String url) {
        if (mLoadService != null) {
            mLoadService.showCallback(LoadingCallback.class);
        }
    }

    @Override
    public void pageFinished(String url) {

        if (mLoadService != null) {
            if(mIsError){
                mLoadService.showCallback(ErrorCallback.class);
            }   else {
                mLoadService.showSuccess();
            }
        }
        mIsError = false;
    }

    @Override
    public void onError() {
        Log.e(TAG, "onError");
        mIsError = true;

    }

    @Override
    public void updateTitle(String title) {
        if (getActivity() instanceof WebViewActivity) {
            ((WebViewActivity)getActivity()).updateTitle(title);
        }
    }


    @Override
    public void onRefresh() {
        mBinding.webview.reload();
    }
}
