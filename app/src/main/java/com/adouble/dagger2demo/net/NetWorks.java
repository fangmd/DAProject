package com.adouble.dagger2demo.net;

import android.text.TextUtils;
import android.util.Log;

import com.adouble.dagger2demo.App;
import com.adouble.dagger2demo.AppConstants;
import com.adouble.dagger2demo.entities.Article;
import com.adouble.dagger2demo.entities.HttpResponse;
import com.adouble.dagger2demo.net.api.BlogService;
import com.nerc.baselibrary.utils.NetUtils;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;

/**
 * Created by double on 2017/1/8.
 */

public class NetWorks {

    private Retrofit mRetrofit;

    private NetWorks() {
        initRetrofit();
    }

    public static NetWorks getInstance(){
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final NetWorks INSTANCE = new NetWorks();
    }

    /**
     * if net is enable: use cache in 30s
     * if net is disable: use cache
     */
    Interceptor mCacheInterceptor = chain -> {
        Request request = chain.request();
        Response response = chain.proceed(request);

        String cacheControl = request.cacheControl().toString();
        if (TextUtils.isEmpty(cacheControl)) {
            cacheControl = "public, max-age=30";
        }
        return response.newBuilder()
                .header("Cache-Control", cacheControl)
                .removeHeader("Pragma")
                .build();
    };

    /**
     * if net is enable: use net
     * if net is disable: use cache
     */
    private final Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = chain -> {
        Request request = chain.request();
        if(!NetUtils.isNetworkConnected(App.getInstance())){
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build();
            Log.d(TAG, "no network");
        }
        Response originalResponse = chain.proceed(request);
        if(NetUtils.isNetworkConnected(App.getInstance())){
            String cacheControl = request.cacheControl().toString();
            return originalResponse.newBuilder()
                    .header("Cache-Control", cacheControl)
                    .removeHeader("Pragma")
                    .build();
        }else{
            return originalResponse.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=2419200")
                    .removeHeader("Pragma")
                    .build();
        }
    };

    private void initRetrofit() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        //TODO: if debug
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(loggingInterceptor);

        builder.addInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR);
//        builder.addNetworkInterceptor(mCacheInterceptor);

        mRetrofit = new Retrofit.Builder()
                .baseUrl(AppConstants.Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build())
                .build();

    }


    public void getArticles(Observer<HttpResponse<Article>> observer){

        BlogService blogService = mRetrofit.create(BlogService.class);
        Observable<HttpResponse<Article>> blogs = blogService.getBlogs();

        blogs.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }

}
