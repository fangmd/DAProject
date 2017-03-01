package com.adouble.dagger2demo.dagger.base;

import android.app.Activity;
import android.content.Context;

import com.adouble.dagger2demo.dagger.ForActivity;
import com.adouble.dagger2demo.dagger.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by double on 2017/1/6.
 */

@Module
public class ActivityModule {

    private final Activity activity;

    public ActivityModule(Activity activity){
        this.activity = activity;
    }

    @Provides
    @PerActivity
    public Activity provideActivity(){
        return activity;
    }


    @Provides
    @ForActivity
    Context provideContext(){
        return activity;
    }

}