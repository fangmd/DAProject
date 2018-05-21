package com.adouble.dagger2demo.module.netdemo;

import com.adouble.dagger2demo.R;
import com.nerc.baselibrary.base.BaseActivity;

public class NetDemoActivity extends BaseActivity implements NetDemoContract.View {

    private NetDemoContract.Presenter mPresenter;

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

    }

    @Override
    public void setPresenter(NetDemoContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
