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
}
