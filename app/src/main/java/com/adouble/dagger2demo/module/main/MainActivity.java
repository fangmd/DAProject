package com.adouble.dagger2demo.module.main;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.adouble.dagger2demo.R;
import com.adouble.dagger2demo.module.netdemo.NetDemoActivity;
import com.nerc.baselibrary.base.BaseActivity;

import butterknife.OnClick;

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

    @OnClick({R.id.btn_first, R.id.btn_net_demo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_first:
                break;
            case R.id.btn_net_demo:
                NetDemoActivity.start(this);
                break;
        }
    }
}
