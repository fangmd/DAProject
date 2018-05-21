package com.nerc.baselibrary.network;

import com.nerc.baselibrary.App;
import com.nerc.baselibrary.AppConstants;
import com.nerc.baselibrary.network.api.BaseApi;
import com.nerc.baselibrary.network.api.FileUploadApi;
import com.nerc.baselibrary.utils.NetUtils;

import java.io.File;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * ApiManager
 * Created by nercdevAndroid on 2017/3/13.
 */

public class ApiManager {

    private BaseApi mBaseApi;
    private FileUploadApi mFileUploadApi;

    // singleton
    private ApiManager() {
        initRetrofit();
    }

    public static ApiManager getInstance() {
        return Holder.sInstance;
    }

    private static class Holder {
        private static final ApiManager sInstance = new ApiManager();
    }
    //----

    /**
     * if net is enable: use net
     * if net is disable: use cache
     */
    private final Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = chain -> {
        Request request = chain.request();
        if (!NetUtils.isNetworkConnected(App.getInstance())) {
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build();
        }
        Response originalResponse = chain.proceed(request);
        if (NetUtils.isNetworkConnected(App.getInstance())) {
            return originalResponse.newBuilder()
                    .header("Cache-Control", "public, max-age=" + 0)
                    .removeHeader("Pragma")
                    .build();
        } else {
            return originalResponse.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=2419200")
                    .removeHeader("Pragma")
                    .build();
        }
    };


    private void initRetrofit() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        // add log
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(httpLoggingInterceptor);
        // add net
        builder.addInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR);
        builder.addNetworkInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR);

        //setup cache
        File httpCacheDirectory = new File(App.getInstance().getCacheDir(), "responses");
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(httpCacheDirectory, cacheSize);
        builder.cache(cache);

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(AppConstants.Api.getApi())
                .client(builder.build())
                .build();


        mBaseApi = retrofit.create(BaseApi.class);
    }

    public BaseApi getBaseApi() {
        return mBaseApi;
    }

    public FileUploadApi getFileUploadApi() {
        if (mFileUploadApi == null) {
            synchronized (ApiManager.this) {
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                // add log
                HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                builder.addInterceptor(httpLoggingInterceptor);
                // add net
                builder.addInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR);

                if (mFileUploadApi == null) {
                    mFileUploadApi = new Retrofit.Builder().baseUrl(AppConstants.Api.getFileApi())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(builder.build())
                            .build()
                            .create(FileUploadApi.class);
                }
            }
        }
        return mFileUploadApi;
    }


}
