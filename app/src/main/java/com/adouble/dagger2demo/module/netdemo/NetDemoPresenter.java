package com.adouble.dagger2demo.module.netdemo;

import com.njfea.baselibrary.network.ErrorHandlerDO;
import com.njfea.baselibrary.network.RxService;
import com.njfea.baselibrary.utils.RxUtils;

import java.io.IOException;

import okhttp3.ResponseBody;

/**
 * Author: Created by fangmingdong on 2018/5/21-下午3:16
 * Description:
 */
public class NetDemoPresenter implements NetDemoContract.Presenter {

    private final NetDemoContract.View mView;

    public NetDemoPresenter(NetDemoContract.View view) {
        mView = view;
    }

    @Override
    public void getData() {
        mView.showLoadingDialog();
        RxService.createApi(NetDemoApi.class)
                .getBlog()
                .compose(RxUtils.applySchedulers(mView))
                .subscribe(new ErrorHandlerDO<ResponseBody>() {
                    @Override
                    protected void onNetFail(int code, String msg) {
                        // 网络请求失败，
                        // 网络原因 / 服务器错误
                        mView.hideLoadingDialog();
                    }

                    @Override
                    protected void onNetSuccess(ResponseBody data) {
                        // 网络请求成功
                        try {
                            mView.showData(data.string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        mView.hideLoadingDialog();
                    }
                });
    }
}
