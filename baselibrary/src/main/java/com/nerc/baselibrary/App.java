package com.nerc.baselibrary;

import android.app.Activity;
import android.content.IntentFilter;
import android.support.multidex.MultiDexApplication;

import com.alibaba.android.arouter.launcher.ARouter;
import com.github.moduth.blockcanary.BlockCanary;
import com.nerc.baselibrary.br.NetWorkStateReceiver;
import com.nerc.baselibrary.download.ResourceSqliteActor;
import com.nerc.baselibrary.utils.LoggerUtils;
import com.nerc.baselibrary.utils.SPUtils;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.umeng.analytics.MobclickAgent;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import java.util.ArrayList;
import java.util.List;

import zlc.season.rxdownload3.core.DownloadConfig;


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

    public List<Activity> mActivities = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;
        // leakCanary
//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            // This process is dedicated to LeakCanary for heap analysis.
//            // You should not init your app in this process.
//            return;
//        }
//        LeakCanary.install(this);

        // log
        initDebug();

        mUserId = SPUtils.getString(this, AppConstants.Key.USER_ID);

        // umeng
        String channel = initUMeng();
        initShare();
        //MobclickAgent.setDebugMode( true );


        // push ----------------------------------
        initPush(channel);

        // init DBFlow
        FlowManager.init(new FlowConfig.Builder(this).build());

        // BlockCanary
        if (BuildConfig.LOG_DEBUG) {
            BlockCanary.install(this, new AppBlockCanaryContext()).start();
        }


        initARouter();
        initRxDownload();

        // for vector compat
//        VectorUtils.useCompatVectorIfNeeded();

        startNetMonitor();
    }


    private void initShare() {
        UMShareAPI.get(this);
        PlatformConfig.setWeixin("wx47cea9b12d44e530", "47697a128cc6e3dc3b2be4b7c8cd5f50");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
    }

    private void startNetMonitor() {
        LoggerUtils.d(AppConstants.Tag.DOWNLOAD, "start net br");
        NetWorkStateReceiver netWorkStateReceiver = new NetWorkStateReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        filter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        registerReceiver(netWorkStateReceiver, filter);
    }

    private void initRxDownload() {
        DownloadConfig.Builder builder = DownloadConfig.Builder.Companion.create(this)
                .enableDb(true)
                .setDbActor(new ResourceSqliteActor(this))
                .enableService(true)
                .enableNotification(true);
//                .addExtension(ApkInstallExtension.class);

        DownloadConfig.INSTANCE.init(builder);
    }

    private void initDebug() {
//        if (BuildConfig.LOG_DEBUG) {
//            com.facebook.stetho.Stetho.initializeWithDefaults(this);
//        }
    }

    private void initPush(String channel) {
        PushAgent mPushAgent = PushAgent.getInstance(this);
//        mPushAgent.setDebugMode(true);
//        mPushAgent.setMessageChannel(channel);
        mPushAgent.register(new IUmengRegisterCallback() {
            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回device token
                LoggerUtils.d(AppConstants.Tag.UMENG, "推送服务 device token:" + deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {
                LoggerUtils.e(AppConstants.Tag.UMENG, "推送服务 onFailure s:" + s + " s1:" + s1);
            }
        });
    }

    private String initUMeng() {
        String channel = "official";
        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);

        // 多渠道打包使用
//        String channel = WalleChannelReader.getChannel(this.getApplicationContext());
        //--

        String umengAppkey = "558a0cc667e58ec2ba006c29";
        MobclickAgent.UMAnalyticsConfig umAnalyticsConfig = new MobclickAgent.UMAnalyticsConfig(this,
                umengAppkey,
                channel,
                MobclickAgent.EScenarioType.E_UM_NORMAL,
                true);
        MobclickAgent.startWithConfigure(umAnalyticsConfig);
        if (BuildConfig.LOG_DEBUG) {
            MobclickAgent.setDebugMode(true);
        }
        return channel;
    }


//    public boolean startMyService() {
//        boolean myServiceRunning = isMyServiceRunning(MyService.class);
//        if (!myServiceRunning) {
//            Intent service = new Intent(this, MyService.class);
//            startService(service);
//        }
//        return myServiceRunning;
//    }
//
//    private boolean isMyServiceRunning(Class<?> serviceClass) {
//        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
//        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
//            if (serviceClass.getName().equals(service.service.getClassName())) {
//                return true;
//            }
//        }
//        return false;
//    }


    private void initARouter() {
        if (BuildConfig.LOG_DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }


    public void exit() {
        for (Activity activity : mActivities) {
            activity.finish();
        }
    }



}
