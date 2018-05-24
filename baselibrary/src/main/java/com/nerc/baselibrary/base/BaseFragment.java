package com.nerc.baselibrary.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nerc.baselibrary.R;
import com.nerc.baselibrary.utils.ToastUtils;
import com.nerc.baselibrary.widgets.LoadingDialog;
import com.trello.rxlifecycle2.components.support.RxFragment;

import butterknife.ButterKnife;

/**
 * Author: Created by fangmingdong on -下午3:48
 * Description: Fragment 的基类
 */
public abstract class BaseFragment<T extends BasePresenter> extends RxFragment {

    protected T mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayout(), container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    protected abstract @LayoutRes
    int getLayout();


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = getPresenter();
        mLoadingDialog = new LoadingDialog(getActivity());
        initView();
        initData();
    }

    protected T getPresenter() {
        return null;
    }

    protected abstract void initView();

    protected abstract void initData();

    @Override
    public void onResume() {
        super.onResume();

        resumeData();
    }

    /**
     * load data in onResume
     */
    protected void resumeData() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    // loading dialog
    private LoadingDialog mLoadingDialog;

    /**
     * 显示加载对话框
     */
    public void showLoadingDialog() {
        if (mLoadingDialog != null && !mLoadingDialog.isShowing()) {
            mLoadingDialog.show();
        }
    }

    /**
     * 隐藏加载对话框
     */
    public void hideLoadingDialog() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
            mLoadingDialog.dismiss();
        }
    }

    public void showLoadFail() {
        ToastUtils.showToast(getActivity(), getString(R.string.error_load_data_fail));
    }

}
