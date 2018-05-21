package com.nerc.baselibrary.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by double on 16/8/12.
 */
public abstract class RxBaseActivity extends BaseActivity {

    CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public void addDisposable(Disposable d) {
        mCompositeDisposable.add(d);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCompositeDisposable.clear();
    }
}
