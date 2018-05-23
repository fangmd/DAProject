package com.nerc.baselibrary;

import android.app.Application;

import com.nerc.baselibrary.utils.LoggerUtils;
import com.njfae.xwebview.XWebViewUtils;

/**
 * Author: Created by fangmingdong on 2018/5/23-下午2:37
 * Description:
 */
public class App extends Application {

    private static Application sApp;

    public static Application getInstance() {
        return sApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;

        XWebViewUtils.init(this);

        // log
        initDebug();
    }


    private void initDebug() {
        LoggerUtils.init();
//        if (BuildConfig.LOG_DEBUG) {
//            com.facebook.stetho.Stetho.initializeWithDefaults(this);
//        }

        // BlockCanary
//        if (BuildConfig.LOG_DEBUG) {
//            BlockCanary.install(this, new AppBlockCanaryContext()).start();
//        }

        // leakCanary
//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            // This process is dedicated to LeakCanary for heap analysis.
//            // You should not init your app in this process.
//            return;
//        }
//        LeakCanary.install(this);
    }
}
