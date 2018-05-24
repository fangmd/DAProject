package com.adouble.dagger2demo.module.layout.homeone.invest;

import com.nerc.baselibrary.base.BasePresenter;
import com.nerc.baselibrary.base.BaseView;

/**
 * Author: Created by fangmingdong on 2018/5/24-上午10:33
 * Description:
 */
public class InvestContract {

    interface View extends BaseView {

        void showData(int data);
    }

    interface Presenter extends BasePresenter {

        void getData();
    }
}
