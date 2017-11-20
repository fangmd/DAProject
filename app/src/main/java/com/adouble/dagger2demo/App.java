package com.adouble.dagger2demo;

import android.location.LocationManager;
import android.support.multidex.MultiDexApplication;

import com.adouble.dagger2demo.dagger.base.AppModule;
import com.adouble.dagger2demo.dagger.base.ApplicationComponent;
import com.adouble.dagger2demo.dagger.base.DaggerApplicationComponent;
import com.fang.common.base.utils.Utils;
import com.squareup.leakcanary.LeakCanary;

import javax.inject.Inject;

/**
 * Created by duble on 2017/1/5.
 */

public class App extends MultiDexApplication {

    private static App sApplication;

    public static App getInstance() {
        return sApplication;
    }


    private ApplicationComponent mApplicationComponent;

    public ApplicationComponent component() {
        return mApplicationComponent;
    }


    @Inject
    LocationManager mLocationManager;

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;


        Utils.init(this);

        mApplicationComponent = DaggerApplicationComponent.builder()
                .appModule(new AppModule(this))
                .build();

        // leakcanary
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);

    }


}
