package com.adouble.dagger2demo.service;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;
import android.os.PersistableBundle;
import android.support.annotation.RequiresApi;

import com.njfea.baselibrary.utils.LoggerUtils;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static com.adouble.dagger2demo.AppConstants.Tag.JOBSERVICE;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class DownloadJobService extends JobService {

    private Observable<String> mObservable;
    private Disposable mD;

    @Override
    public boolean onStartJob(JobParameters params) {
        LoggerUtils.d(JOBSERVICE, "JobService OnStartJob");

        PersistableBundle extras = params.getExtras();
        String strFromOut = extras.getString("key", "default");

        mObservable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext(strFromOut);
            }
        });

        mObservable.observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {

                    @Override
                    public void onSubscribe(Disposable d) {
                        mD = d;
                    }

                    @Override
                    public void onNext(String s) {
                        LoggerUtils.d("receive " + s);
                        jobFinished(params, false); // 主动结束任务
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        return false; // return true: 如果有异步任务， false：如果没有异步任务
    }

    /**
     * 任务被动结束的时候调用
     */
    @Override
    public boolean onStopJob(JobParameters params) {
        LoggerUtils.d(JOBSERVICE, "JobService onStopJob");
        if (!mD.isDisposed()) {
            mD.dispose();
        }

        return true; // 返回true表示你希望对该任务重新进行调度，同样需要遵守退避策略；返回false表示你希望放弃该任务
    }

}
