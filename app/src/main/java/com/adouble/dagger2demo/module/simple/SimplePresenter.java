package com.adouble.dagger2demo.module.simple;

import android.support.annotation.NonNull;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;

public class SimplePresenter implements SimpleContract.Presenter {

    @NonNull
    private final SimpleContract.View mView;

    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public SimplePresenter(@NonNull SimpleContract.View view) {
        mView = view;
    }

    @Override
    public void loadData() {
        mView.showData("from net");
    }

    @Override
    public void subscribe(DisposableObserver disposableObserver) {
        mCompositeDisposable.add(disposableObserver);
    }

    @Override
    public void unsubscribe() {
        mCompositeDisposable.clear();
    }
}
