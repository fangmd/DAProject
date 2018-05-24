package com.adouble.dagger2demo.module.webview;

import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;

import com.adouble.dagger2demo.R;
import com.njfea.baselibrary.base.BaseActivity;
import com.njfae.xwebview.ErrorView;
import com.njfae.xwebview.MyWebView;
import com.njfae.xwebview.MyWebViewListener;
import com.njfae.xwebview.XWebViewUtils;

public class WebActivity extends BaseActivity implements MyWebViewListener {

    private MyWebView mWebView;
    private FrameLayout mFLWeb;
    private ErrorView mErrorView;
    /**
     * 是否正在显示错误页面
     */
    private boolean mErrorPageIsShow;

    public static void start(Context context) {
        Intent starter = new Intent(context, WebActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.web_activity;
    }

    @Override
    protected void init() {
        mFLWeb = (FrameLayout) findViewById(R.id.fl_web);
        addWebView();
        mWebView.loadUrl("https://baidu.com");
    }

    private void addWebView() {
        mWebView = new MyWebView(this);
        mWebView.setMyWebViewListener(this);
        mFLWeb.addView(mWebView);
        mFLWeb.post(() -> {
            FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) mWebView.getLayoutParams();
            lp.width = FrameLayout.LayoutParams.MATCH_PARENT;
            lp.height = FrameLayout.LayoutParams.MATCH_PARENT;
            mWebView.setLayoutParams(lp);
        });
    }

    @Override
    protected void onDestroy() {
        XWebViewUtils.destroyWebView(mWebView);
        super.onDestroy();
    }

    @Override
    public void showErrorPage() {
        if (mErrorView == null) {
            mErrorView = new ErrorView(this);
            mErrorView.setErrorViewListener(() -> refreshPage());
            mFLWeb.addView(mErrorView);
            mFLWeb.post(() -> {
                FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) mWebView.getLayoutParams();
                lp.width = mFLWeb.getMeasuredWidth();
                lp.height = mFLWeb.getMeasuredHeight();
                mErrorView.setLayoutParams(lp);
            });
        }
        mErrorView.setVisibility(View.VISIBLE);
        mErrorPageIsShow = true;
    }

    @Override
    public void showPageLoadFinish() {

    }

    private void hideErrorPage() {
        if (mErrorView != null) {
            mErrorView.setVisibility(View.GONE);
        }
        mErrorPageIsShow = false;
    }

    private void refreshPage() {
        hideErrorPage();
        mWebView.reload();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mErrorPageIsShow) {
                hideErrorPage();
                if (mWebView.canGoBack()) {
                    mWebView.goBack();
                }
                return true;
            } else {
                if (mWebView.canGoBack()) {
                    mWebView.goBack();
                    return true;
                }
            }
        }
        return super.onKeyDown(keyCode, event);
    }


}
