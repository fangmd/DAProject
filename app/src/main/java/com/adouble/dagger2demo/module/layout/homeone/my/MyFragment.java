package com.adouble.dagger2demo.module.layout.homeone.my;


import android.os.Bundle;

import com.adouble.dagger2demo.R;
import com.njfea.baselibrary.base.LazyBaseFragment;

/**
 * Author: Created by fangmingdong on -上午10:20
 * Description:
 */
public class MyFragment extends LazyBaseFragment<MyPresenter> implements MyContract.View {


    public MyFragment() {
        // Required empty public constructor
    }

    public static MyFragment newInstance() {
        Bundle args = new Bundle();

        MyFragment fragment = new MyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.my_fragment;
    }

    @Override
    protected MyPresenter getPresenter() {
        return new MyPresenter(this);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void lazyLoad() {

    }
}
