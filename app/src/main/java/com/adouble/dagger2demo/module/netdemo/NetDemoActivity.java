package com.adouble.dagger2demo.module.netdemo;

import android.content.Context;
import android.content.Intent;

import com.adouble.dagger2demo.R;
import com.njfea.baselibrary.base.BaseActivity;
import com.njfea.baselibrary.utils.ToastUtils;

/**
 * Author: Created by fangmingdong on -下午3:49
 * Description:
 */
public class NetDemoActivity extends BaseActivity<NetDemoContract.Presenter> implements NetDemoContract.View {


    public static void start(Context context) {
        Intent starter = new Intent(context, NetDemoActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected NetDemoContract.Presenter getPresenter() {
        return new NetDemoPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.net_demo_activity;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void resumeData() {
        super.resumeData();
        mPresenter.getData();
    }


    @Override
    public void showData(String data) {
        ToastUtils.showCToast(this, data);
    }
}

