package com.nerc.baselibrary.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by nercdev on 2017/1/12.
 * 所有 Fragment 的基类
 */
public abstract class RxBaseFragment extends BaseFragment {

    // deal RxJava leak memory
    CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public void subscribe(Disposable disposable) {
        mCompositeDisposable.add(disposable);
    }

    public void unSubscribe() {
        mCompositeDisposable.clear();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unSubscribe();
    }
}
