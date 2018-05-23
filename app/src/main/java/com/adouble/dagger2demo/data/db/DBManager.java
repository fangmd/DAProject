package com.adouble.dagger2demo.data.db;


import android.app.Application;

/**
 * Created by double on 2017/1/7.
 */
public class DBManager {
    private final Application mApplication;

    public DBManager(Application application) {
        mApplication = application;
    }
}
