package com.nerc.baselibrary.utils;

import com.nerc.baselibrary.base.BaseView;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.LifecycleTransformer;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by nerc on 2017/10/31.
 */

public class RxUtils {

    public static void unSubscribe(Disposable disposable) {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }


    /**
     * 将rxJava与Activity,Fragment的生命周期方法绑定
     *
     * @param view
     * @param <T>
     * @return
     */
    public static <T> LifecycleTransformer<T> bindToLifecycle(BaseView view) {
        if (view instanceof LifecycleProvider) {
            return ((LifecycleProvider) view).bindToLifecycle();
        } else {
            throw new IllegalArgumentException("view isn't activity or fragment");
        }
    }

    public static <T> LifecycleTransformer<T> bindToLifecycle(LifecycleProvider view) {
        return ((LifecycleProvider) view).bindToLifecycle();
    }


    public static <T> ObservableTransformer<T, T> applySchedulers(final BaseView view) {
        return new ObservableTransformer<T, T>() {
            @Override
            public Observable<T> apply(Observable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .compose(RxUtils.bindToLifecycle(view));
            }
        };
    }

}
