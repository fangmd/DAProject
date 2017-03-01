package com.adouble.dagger2demo.module.main;

import android.util.Log;

import com.adouble.dagger2demo.AppConstants;
import com.adouble.dagger2demo.dagger.PerActivity;
import com.adouble.dagger2demo.entities.Article;
import com.adouble.dagger2demo.entities.HttpResponse;
import com.adouble.dagger2demo.net.NetWorks;
import com.fang.common.base.utils.over.LoggerUtils;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import static android.content.ContentValues.TAG;

/**
 * Created by double on 2017/1/6.
 */
@PerActivity
public class MainPresenter implements MainContract.Presenter {

    private final MainContract.View mView;
    private final NetWorks mNetWorks;


    @Inject
    public MainPresenter(MainContract.View view, NetWorks netWorks) {
        mNetWorks = netWorks;
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void getMessage() {
        mNetWorks.getArticles(new Observer<HttpResponse<Article>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(HttpResponse<Article> httpResponse) {
                if (httpResponse != null && httpResponse.code == AppConstants.HTTPCODE.OK) {
                    Article t = httpResponse.t;

                    LoggerUtils.d(t.toString());
                }
            }

            @Override
            public void onError(Throwable e) {
                mView.showLoadError();
            }

            @Override
            public void onComplete() {

            }
        });

        Log.d(TAG, "getMessage: " + mNetWorks.toString());
        mView.showMessage();
//        NetWorks.getInstance()
    }

    @Override
    public void subscribe(Disposable disposable) {
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void unsubscribe() {
        mCompositeDisposable.clear();
    }
}
