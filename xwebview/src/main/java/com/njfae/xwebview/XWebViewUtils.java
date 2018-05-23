package com.njfae.xwebview;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;

import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;

/**
 * Author: Created by fangmingdong on 2018/5/23-上午9:30
 * Description:
 */
public class XWebViewUtils {

    public static void init(Context context) {
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {

            @Override
            public void onViewInitFinished(boolean arg0) {
                Log.d("WebView", "X5WebView onViewInitFinished init finished:" + arg0);
            }

            @Override
            public void onCoreInitFinished() {

            }
        };
        QbSdk.initX5Environment(context.getApplicationContext(), cb);
    }

    public static void destroyWebView(WebView webView){
        if (webView != null) {
            webView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            webView.clearHistory();

            ((ViewGroup) webView.getParent()).removeView(webView);
            webView.destroy();
            webView = null;
        }
    }

}
