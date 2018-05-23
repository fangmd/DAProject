package com.nerc.baselibrary;

import android.support.multidex.MultiDexApplication;

import com.nerc.baselibrary.utils.LoggerUtils;
import com.nerc.baselibrary.utils.SPUtils;
import com.njfae.xwebview.XWebViewUtils;


/**
 * Created by nercdev on 2017/1/11.
 */
public class App extends MultiDexApplication {

    private static App sApp;
    public boolean mAutoStart;

    public static App getInstance() {
        return sApp;
    }

    public String mUserId;


    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;

        XWebViewUtils.init(this);
        // log
        initDebug();

        mUserId = SPUtils.getString(this, AppConstants.Key.USER_ID);

        // init DBFlow
//        FlowManager.init(new FlowConfig.Builder(this).build());

//        startNetMonitor();
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
