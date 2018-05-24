package com.adouble.dagger2demo.module.netdemo;

import com.njfea.baselibrary.base.BasePresenter;
import com.njfea.baselibrary.base.BaseView;

/**
 * Author: Created by fangmingdong on 2018/5/21-下午3:16
 * Description:
 */
public class NetDemoContract {

    interface View extends BaseView{

        void showData(String data);

    }

    interface Presenter extends BasePresenter {

        void getData();
    }
}
