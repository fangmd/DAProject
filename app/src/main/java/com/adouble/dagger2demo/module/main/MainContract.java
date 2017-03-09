package com.adouble.dagger2demo.module.main;

import com.adouble.dagger2demo.base.BasePresenter;
import com.adouble.dagger2demo.base.BaseView;

/**
 * Created by double on 2017/1/6.
 */

public class MainContract {

    public interface View extends BaseView<Presenter>{

        void showMessage();

        void showLoadError();
    }

    public interface Presenter extends BasePresenter {

        void getMessage();
    }
}
