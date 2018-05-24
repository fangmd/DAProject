package com.adouble.dagger2demo.module.layout.homeone.home;


import android.os.Bundle;

import com.adouble.dagger2demo.R;
import com.njfea.baselibrary.base.BaseFragment;

/**
 * Author: Created by fangmingdong on -上午10:20
 * Description:
 */
public class HomeFragment extends BaseFragment<HomePresenter> implements HomeContract.View {


    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        Bundle args = new Bundle();

        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.home_fragment;
    }


    @Override
    protected HomePresenter getPresenter() {
        return new HomePresenter(this);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

}
