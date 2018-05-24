package com.njfea.baselibrary.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.njfea.baselibrary.R;
import com.njfea.baselibrary.manager.ActivityManager;
import com.njfea.baselibrary.utils.ToastUtils;
import com.njfea.baselibrary.utils.qmui.QMUIStatusBarHelper;
import com.njfea.baselibrary.widgets.LoadingDialog;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;


/**
 * Author: Created by fangmingdong on -下午3:48
 * Description:
 */
public abstract class BaseActivity<T> extends RxAppCompatActivity {

    protected final String TAG = getClass().getSimpleName();

    protected T mPresenter;

    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        mPresenter = getPresenter();
        setUpStatusBarColor();

        loadingDialog = new LoadingDialog(this);

        // activity manager
//        TinkerAppLike.getInstance().mActivities.add(this);

        // push
//        PushAgent.getInstance(this).onAppStart();


        ActivityManager.getInstance().add(this);

        init();
    }

    protected T getPresenter() {
        return null;
    }

    protected abstract @LayoutRes
    int getLayoutId();

    protected abstract void init();


    private void setUpStatusBarColor() {
        QMUIStatusBarHelper.setStatusBarLightMode(this);
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


    public void showLoadFail() {
        ToastUtils.showToast(this, getString(R.string.error_load_data_fail));
    }

}
