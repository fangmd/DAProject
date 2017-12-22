package com.nerc.baselibrary;

import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by nerc on 2017/8/7.
 */

public class RouterUtils {


    public static void toLogin() {
        ARouter.getInstance().build(AppConstants.Router.LOGIN).navigation();
    }

    public static void toMain(){
        ARouter.getInstance().build(AppConstants.Router.MAIN).navigation();
    }


    public static Fragment getFragment(String path){
        return (Fragment) ARouter.getInstance().build(path).navigation();
    }


}
