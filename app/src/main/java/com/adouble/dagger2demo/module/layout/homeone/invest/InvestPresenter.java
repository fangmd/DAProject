package com.adouble.dagger2demo.module.layout.homeone.invest;

import com.nerc.baselibrary.utils.RxUtils;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Author: Created by fangmingdong on 2018/5/24-上午10:34
 * Description:
 */
public class InvestPresenter implements InvestContract.Presenter {

    private final InvestContract.View mView;

    public InvestPresenter(InvestContract.View view) {
        mView = view;
    }

    @Override
    public void getData() {
        Disposable subscribe = Observable.timer(1, TimeUnit.SECONDS)
                .compose(RxUtils.bindToLifecycle(mView))
                .subscribe(aLong -> {
                    mView.showData(1);
                });
    }
}
