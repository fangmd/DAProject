package com.adouble.dagger2demo.module.splash;

import com.adouble.dagger2demo.R;
import com.adouble.dagger2demo.module.main.MainActivity;
import com.nerc.baselibrary.base.RxBaseActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;


public class SplashActivity extends RxBaseActivity {

    //TODO: permission get fangmingdong 2018/5/21-上午11:04


    @Override
    protected int getLayoutId() {
        return R.layout.splash_activity;
    }

    @Override
    protected void init() {
        Disposable subscribe = Observable.timer(2, TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        MainActivity.start(SplashActivity.this);
                    }
                });
        addDisposable(subscribe);
    }


}
