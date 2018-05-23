package com.nerc.baselibrary;

import android.app.Application;

import com.njfae.xwebview.XWebViewUtils;

/**
 * Author: Created by fangmingdong on 2018/5/23-下午2:37
 * Description:
 */
public class App extends Application {

    private static Application sApp;

    public static Application getInstance(){
        return sApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;

        XWebViewUtils.init(this);
    }
}
