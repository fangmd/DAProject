package com.nerc.baselibrary.db;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 *
 * DBFlow 数据库 创建
 * Created by nercdevAndroid on 2017/5/4.
 */

@Database(name = AppDatabase.NAME, version = AppDatabase.VERSION)
public class AppDatabase {

    public static final String NAME = "AppDatabase"; // we will add the .db extension

    public static final int VERSION = 1;
}
