package com.adouble.dagger2demo.dagger.main;

import com.adouble.dagger2demo.module.main.MainContract;
import com.adouble.dagger2demo.module.main.MainPresenter;
import com.adouble.dagger2demo.net.NetWorks;

import dagger.Module;
import dagger.Provides;

/**
 * 用于为 MainPresenter 提供 View
 * Created by double on 2017/1/6.
 */
@Module
public class MainPresenterModule {
    private final MainContract.View mView;

    public MainPresenterModule(MainContract.View view) {
        mView = view;
    }

    @Provides
    MainContract.View provideView() {
        return mView;
    }

    @Provides
    MainContract.Presenter providePresenter(NetWorks netWorks) {
        return new MainPresenter(mView, netWorks);
    }


}
