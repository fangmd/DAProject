package com.adouble.dagger2demo.module.simple;

import com.adouble.dagger2demo.base.BasePresenter;
import com.adouble.dagger2demo.base.BaseView;

public interface SimpleContract {

    interface View extends BaseView<Presenter> {

        void showData(String fromNet); //(List<TeachNotiEntity> , boolean clear);

        void showLoading(boolean show);

    }

    interface Presenter extends BasePresenter {
        void loadData();
    }
}