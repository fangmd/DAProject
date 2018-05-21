package com.adouble.dagger2demo.module.netdemo;

import com.nerc.baselibrary.base.BasePresenter;
import com.nerc.baselibrary.base.BaseView;

/**
 * Author: Created by fangmingdong on 2018/5/21-下午3:16
 * Description:
 */
public class NetDemoContract {

    interface View extends BaseView<Presenter> {


    }

    interface Presenter extends BasePresenter {

        void getData();
    }
}
