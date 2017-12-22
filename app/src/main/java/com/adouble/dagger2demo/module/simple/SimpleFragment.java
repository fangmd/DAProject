package com.adouble.dagger2demo.module.simple;

import android.os.Bundle;

import com.adouble.dagger2demo.R;
import com.adouble.dagger2demo.base.BaseFragment;
import com.adouble.dagger2demo.dagger.simple.SimpleComponent;
import com.nerc.baselibrary.utils.ToastUtils;

import javax.inject.Inject;

import butterknife.Unbinder;

public class SimpleFragment extends BaseFragment implements SimpleContract.View {

    Unbinder unbinder;

    @Inject
    SimpleContract.Presenter mPresenter;

    private SimpleComponent mComponent;

    public SimpleFragment() {
        // Required empty public constructor
    }

    public static SimpleFragment newInstance() {

        Bundle args = new Bundle();

        SimpleFragment fragment = new SimpleFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void inject() {

    }

    @Override
    public void onResume() {
        super.onResume();

        mPresenter.loadData();
    }

    @Override
    public void showData(String net) {
        ToastUtils.showCLToast(getContext(), net);

    }

    @Override
    public void showLoading(boolean show) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.simple_frag;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.unsubscribe();
    }

}
