package com.nerc.baselibrary.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Author: Created by fangmingdong on -下午3:48
 * Description: LazyFragment 的基类
 */
public abstract class LazyBaseFragment<T> extends BaseFragment {

    /**
     * 是否是第一次加载
     */
    private boolean isFirst = true;
    /**
     * View 初始化状态，true: 已经初始化, false: 没有初始化
     */
    private boolean isViewInit;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        isViewInit = true;
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && isViewInit) {
            onFragmentVisibleChange(true);
        } else {
            onFragmentVisibleChange(false);
        }
    }

    protected void onFragmentVisibleChange(boolean visible) {
        if (visible && isFirst) {
            lazyLoad();
            isFirst = false;
        }
    }

    @Override
    protected void initData() {

    }

    protected abstract void lazyLoad();


}
