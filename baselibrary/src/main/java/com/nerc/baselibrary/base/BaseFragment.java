package com.nerc.baselibrary.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.nerc.baselibrary.R;
import com.nerc.baselibrary.utils.ToastUtils;
import com.nerc.baselibrary.widgets.LoadingDialog;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by nercdev on 2017/1/12.
 * 所有 Fragment 的基类
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mLoadingDialog = new LoadingDialog(getActivity());
        initView();
        initData();
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

    public void showNetError() {
//        ToastUtils.showToast(getActivity(), getString(R.string.str_error_msg_network_status_error));
    }

    public void showServerError() {
//        ToastUtils.showToast(getActivity(), getString(R.string.str_error_msg_service_error));
    }


    // deal RxJava leak memory
    CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public void unSubscribe() {
        mCompositeDisposable.clear();
    }


    public void subscribe(Disposable disposable) {
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unSubscribe();
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

    public String[] getQuestionUserAnswer() {
        return null;
    }

}
