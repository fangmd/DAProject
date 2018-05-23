//package com.nerc.baselibrary;
//
//import android.annotation.TargetApi;
//import android.app.Application;
//import android.content.Context;
//import android.content.Intent;
//import android.os.Build;
//import android.support.multidex.MultiDex;
//
//import com.nerc.baselibrary.utils.LoggerUtils;
//import com.njfae.tinker.log.MyLogImp;
//import com.njfae.tinker.utils.TinkerManager;
//import com.tencent.tinker.anno.DefaultLifeCycle;
//import com.tencent.tinker.lib.tinker.Tinker;
//import com.tencent.tinker.lib.tinker.TinkerInstaller;
//import com.tencent.tinker.loader.app.DefaultApplicationLike;
//import com.tencent.tinker.loader.shareutil.ShareConstants;
//
//
///**
// * Created by nercdev on 2017/1/11.
// */
//@DefaultLifeCycle(
//        application = ".TinkerApp",             //application name to generate
//        flags = ShareConstants.TINKER_ENABLE_ALL)                                //tinkerFlags above
//public class TinkerAppLike extends DefaultApplicationLike {
//
//    private static Application sApp;
//
//    public TinkerAppLike(Application application, int tinkerFlags, boolean tinkerLoadVerifyFlag, long applicationStartElapsedTime, long applicationStartMillisTime, Intent tinkerResultIntent) {
//        super(application, tinkerFlags, tinkerLoadVerifyFlag, applicationStartElapsedTime, applicationStartMillisTime, tinkerResultIntent);
//    }
//
//    /**
//     * install multiDex before install tinker
//     * so we don't need to put the tinker lib classes in the main dex
//     */
//    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
//    @Override
//    public void onBaseContextAttached(Context base) {
//        super.onBaseContextAttached(base);
//        //you must install multiDex whatever tinker is installed!
//        MultiDex.install(base);
//
//        TinkerManager.setTinkerApplicationLike(this);
//
//        //should set before tinker is installed
//        TinkerManager.setUpgradeRetryEnable(true);
//
//        //optional set logIml, or you can use default debug log
//        TinkerInstaller.setLogIml(new MyLogImp());
//
//        //installTinker after load multiDex
//        //or you can put com.tencent.tinker.** to main dex
//        TinkerManager.installTinker(this);
//        Tinker tinker = Tinker.with(getApplication());
//
//        init(base);
//    }
//
//    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
//    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks callback) {
//        getApplication().registerActivityLifecycleCallbacks(callback);
//    }
//
//
//    //
//
//    private void init(Context base) {
//        // custom -- --- --
//        sApp = getApplication();
//
//        // log
//        initDebug();
//
//        // init DBFlow
////        FlowManager.init(new FlowConfig.Builder(this).build());
//
////        startNetMonitor();
//    }
//
//    private void initDebug() {
//        LoggerUtils.init();
////        if (BuildConfig.LOG_DEBUG) {
////            com.facebook.stetho.Stetho.initializeWithDefaults(this);
////        }
//
//        // BlockCanary
////        if (BuildConfig.LOG_DEBUG) {
////            BlockCanary.install(this, new AppBlockCanaryContext()).start();
////        }
//
//        // leakCanary
////        if (LeakCanary.isInAnalyzerProcess(this)) {
////            // This process is dedicated to LeakCanary for heap analysis.
////            // You should not init your app in this process.
////            return;
////        }
////        LeakCanary.install(this);
//    }
//
//    public static Application getApplication2() {
//        return sApp;
//    }
//}
