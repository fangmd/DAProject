package com.adouble.dagger2demo.dagger.simple;

import com.adouble.dagger2demo.module.simple.SimpleContract;
import com.adouble.dagger2demo.module.simple.SimpleFragment;
import com.adouble.dagger2demo.module.simple.SimplePresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by nerc on 2017/11/20.
 */

@Module
public class SimplePresenterModule {

    private SimpleContract.View mView;

    public SimplePresenterModule(SimpleContract.View view) {
        mView = view;
    }

    @Provides
    SimpleContract.Presenter presenter(){
        return new SimplePresenter(mView);
    }

    @Provides
    SimpleFragment fragment(){
        return SimpleFragment.newInstance();
    }


}
