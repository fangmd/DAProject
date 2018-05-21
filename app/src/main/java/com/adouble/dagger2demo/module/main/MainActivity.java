package com.adouble.dagger2demo.module.main;

import android.content.Context;
import android.content.Intent;

import com.adouble.dagger2demo.R;
import com.nerc.baselibrary.base.BaseActivity;

public class MainActivity extends BaseActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, MainActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.main_activity;
    }

    @Override
    protected void init() {

    }
}
