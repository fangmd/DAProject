package com.nerc.baselibrary.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.nerc.baselibrary.R;
import com.nerc.baselibrary.manager.ActivityManager;
import com.nerc.baselibrary.utils.ToastUtils;
import com.nerc.baselibrary.widgets.LoadingDialog;


/**
 * Created by xinghongfei on 16/8/12.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected final String TAG = getClass().getSimpleName();

    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        setUpStatusBarColor();

        loadingDialog = new LoadingDialog(this);

        // activity manager
//        App.getInstance().mActivities.add(this);

        // push
//        PushAgent.getInstance(this).onAppStart();


        ActivityManager.getInstance().add(this);

        init();
    }

    protected abstract @LayoutRes
    int getLayoutId();

    protected abstract void init();


    private void setUpStatusBarColor() {


    }


    public void removeWindowBackground() {
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
        ActivityManager.getInstance().remove(this);
    }

    public void showNetError() {
//        ToastUtils.showToast(this, getString(R.string.str_error_msg_network_status_error));
    }

    public void showLoadDataError() {
        ToastUtils.showToast(this, getString(R.string.error_load_data_fail));
    }

    public void showServerError() {
//        ToastUtils.showToast(this, getString(R.string.str_error_msg_service_error));
    }

    public void showLoadFail() {
        ToastUtils.showToast(this, getString(R.string.error_load_data_fail));
    }

}
