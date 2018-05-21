package com.nerc.baselibrary.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.nerc.baselibrary.App;
import com.nerc.baselibrary.R;
import com.nerc.baselibrary.utils.ToastUtils;
import com.nerc.baselibrary.widgets.LoadingDialog;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;


/**
 * Created by xinghongfei on 16/8/12.
 */
public class BaseActivity extends AppCompatActivity {

    protected final String TAG = getClass().getSimpleName();
    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUpStatusBarColor();

        loadingDialog = new LoadingDialog(this);

        // activity manager
//        App.getInstance().mActivities.add(this);

        // push
//        PushAgent.getInstance(this).onAppStart();


        App.getInstance().mActivities.add(this);
    }

    private void setUpStatusBarColor() {


    }


    public void removeWindowBackground(){
        getWindow().setBackgroundDrawable(null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        resumeData();
//        MobclickAgent.onResume(this);
    }

    /**
     * load data in onResume method
     */
    protected void resumeData() {

    }

    @Override
    protected void onPause() {
        super.onPause();
//        MobclickAgent.onPause(this);
    }

    /**
     * 显示加载对话框
     */
    public void showLoadingDialog() {
        if (loadingDialog != null && !loadingDialog.isShowing()) {
            loadingDialog.show();
        }
    }

    /**
     * 隐藏加载对话框
     */
    public void hideLoadingDialog() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unSubscribe();
        App.getInstance().mActivities.remove(this);
    }


    public void showNetError() {
//        ToastUtils.showToast(this, getString(R.string.str_error_msg_network_status_error));
    }

    public void showLoadDataError(){
        ToastUtils.showToast(this, getString(R.string.error_load_data_fail));
    }

    public void showServerError() {
//        ToastUtils.showToast(this, getString(R.string.str_error_msg_service_error));
    }

    public void showLoadFail() {
        ToastUtils.showToast(this, getString(R.string.error_load_data_fail));
    }

    // deal RxJava leak memory
    CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public void unSubscribe() {
        mCompositeDisposable.clear();
    }


    public void register(Disposable disposable) {
        mCompositeDisposable.add(disposable);
    }





}
