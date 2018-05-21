package com.adouble.dagger2demo.module.netdemo;

import com.adouble.dagger2demo.entities.Article;
import com.adouble.dagger2demo.entities.HttpResponse;
import com.nerc.baselibrary.network.ErrorHandlerDO;
import com.nerc.baselibrary.network.RxService;

import io.reactivex.observers.DisposableObserver;

/**
 * Author: Created by fangmingdong on 2018/5/21-下午3:16
 * Description:
 */
public class NetDemoPresenter implements NetDemoContract.Presenter {

    private final NetDemoContract.View mView;

    public NetDemoPresenter(NetDemoContract.View view) {
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void subscribe(DisposableObserver disposable) {

    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void getData() {
        RxService.createApi(NetDemoApi.class)
                .getBlogs()
                .subscribe(new ErrorHandlerDO<HttpResponse<Article>>() {
                    @Override
                    protected void onNetFail(int code, String msg) {
                        // 网络请求失败，
                        // 网络原因，服务错误
                    }

                    @Override
                    protected void onNetSuccess(HttpResponse<Article> data) {
                        // 网络请求成功

                    }
                });
    }
}
