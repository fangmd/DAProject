package com.adouble.dagger2demo.data.db;

import com.adouble.dagger2demo.App;

/**
 * Created by double on 2017/1/7.
 */

public class DBManager {
    private final App mApplication;

    public DBManager(App application) {
        mApplication = application;
    }
}
