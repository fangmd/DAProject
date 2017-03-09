package com.adouble.dagger2demo.module.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.adouble.dagger2demo.R;
import com.adouble.dagger2demo.base.BaseFragment;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFrag extends BaseFragment implements MainContract.View {


    private MainContract.Presenter mPresenter;

    @BindView(R.id.tv_main_frag)
    TextView mTitle;


    public static MainFrag newInstance() {

        Bundle args = new Bundle();

        MainFrag fragment = new MainFrag();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.main_frag;
    }

    @Override
    protected void initEventAndData() {
        mPresenter.getMessage();
    }

    @Override
    public void showMessage() {

        mTitle.setText("A Message From MainPresenter");
    }

    @Override
    public void showLoadError() {
        mTitle.setText("Load error");
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.unsubscribe();
    }
}
