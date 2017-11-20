package com.adouble.dagger2demo.dagger.base;

import android.app.Application;
import android.content.Context;
import android.location.LocationManager;

import com.adouble.dagger2demo.App;
import com.adouble.dagger2demo.net.NetWorks;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by double on 2017/1/5.
 */
@Module
public class AppModule {
    private final App mApplication;

    public AppModule(App application) {
        mApplication = application;
    }


    @Provides
    @Singleton
    public Context provideContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    Application provideApplication(){
        return mApplication;
    }


    @Provides
    @Singleton
    LocationManager provideLocationManager() {
        return ((LocationManager) mApplication.getSystemService(Context.LOCATION_SERVICE));
    }



    @Provides
    @Singleton
    NetWorks provideNetworks(){
        return NetWorks.getInstance();
    }



//    @Provides
//    @Singleton
//    DBManager provideDBManager(){
//        return new DBManager(mApplication);
//    }
//
//    @Provides
//    @Singleton
//    SPUtils provideSpfManager(){
//        return new SPUtils(mApplication);
//    }
//
//    @Provides
//    @Singleton
//    ThreadExecutor provideThreadExecutor(){
//        return new ThreadExecutor();
//    }




}
