package com.adouble.dagger2demo.module.layout.homeone.home;

/**
 * Author: Created by fangmingdong on 2018/5/24-上午10:34
 * Description:
 */
public class HomePresenter implements HomeContract.Presenter {

    private final HomeContract.View mView;

    public HomePresenter(HomeContract.View view) {
        mView = view;
    }
}

