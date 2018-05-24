package com.adouble.dagger2demo.module.layout;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.adouble.dagger2demo.R;
import com.adouble.dagger2demo.module.layout.homeone.HomeOneActivity;
import com.adouble.dagger2demo.module.layout.mine.YoudaoActivity;
import com.nerc.baselibrary.base.BaseActivity;

import butterknife.OnClick;

public class LayoutActivity extends BaseActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, LayoutActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_activity;
    }

    @Override
    protected void init() {

    }

    @OnClick({R.id.btn_mine_youdao, R.id.btn_mine_temp, R.id.btn_home_one})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_mine_youdao:
                YoudaoActivity.start(this);
                break;
            case R.id.btn_mine_temp:
                break;
            case R.id.btn_home_one:
                HomeOneActivity.start(this);
                break;
        }
    }
}
