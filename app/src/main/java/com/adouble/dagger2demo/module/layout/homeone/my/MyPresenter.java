package com.adouble.dagger2demo.module.layout.homeone.my;

/**
 * Author: Created by fangmingdong on 2018/5/24-上午10:34
 * Description:
 */
public class MyPresenter implements MyContract.Presenter {

    private final MyContract.View mView;

    public MyPresenter(MyContract.View view) {
        mView = view;
    }
}
