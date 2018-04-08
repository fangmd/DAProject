package com.nerc.baselibrary.utils;

import io.reactivex.disposables.Disposable;

/**
 * Created by nerc on 2017/10/31.
 */

public class RxUtils {

    public static void unSubscribe(Disposable disposable){
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }



//    /**
//     * 将rxJava与Activity,Fragment的生命周期方法绑定
//     * @param view
//     * @param <T>
//     * @return
//     */
//    public static <T> LifecycleTransformer<T> bindToLifecycle(IView view) {
//        if (view instanceof LifecycleProvider) {
//            return ((LifecycleProvider) view).bindToLifecycle();
//        } else {
//            throw new IllegalArgumentException("view isn't activity or fragment");
//        }
//    }
//
//
//    /**
//     *
//     * @param view
//     * @param <T>
//     * @return
//     */
//    public static <T> ObservableTransformer<T, T> applySchedulers(final IView view) {
//        return new ObservableTransformer<T, T>() {
//            @Override
//            public Observable<T> apply(Observable<T> observable) {
//                return observable.subscribeOn(Schedulers.io())
//                        .retryWhen(new RetryWithDelay(2, 3))
//                        .doOnSubscribe(new Consumer<Disposable>() {
//                            @Override
//                            public void accept(@NonNull Disposable disposable) throws Exception {
//                            }
//                        })
//                        .subscribeOn(AndroidSchedulers.mainThread())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .doAfterTerminate(new Action() {
//                            @Override
//                            public void run() throws Exception {
//                            }
//                        })
//                        .compose(RxUtils.bindToLifecycle(view));
//            }
//        };
//    }
}
