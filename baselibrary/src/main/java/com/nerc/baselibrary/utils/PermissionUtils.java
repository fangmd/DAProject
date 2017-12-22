package com.nerc.baselibrary.utils;

import android.app.Activity;

import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.functions.Consumer;

/**
 * Created by nercdevAndroid on 2017/3/9.
 */

public class PermissionUtils {


    public static void permission(Activity activity, Consumer<Boolean> consumer, String... permissions){
        RxPermissions rxPermissions = new RxPermissions(activity);
        rxPermissions
                .request(permissions)
                .subscribe(consumer);
    }
}
