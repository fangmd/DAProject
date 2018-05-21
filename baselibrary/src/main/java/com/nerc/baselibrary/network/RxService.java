package com.nerc.baselibrary.network;

import com.nerc.baselibrary.App;
import com.nerc.baselibrary.AppConstants;
import com.nerc.baselibrary.BuildConfig;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 构建OkHttpClient
 */
public class RxService {

    private static final int TIMEOUT_READ = 20;
    private static final int TIMEOUT_CONNECTION = 10;

    private static RequestInterceptor requestInterceptor = new RequestInterceptor();
    private static HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
    private static CacheInterceptor cacheInterceptor = new CacheInterceptor();

    /**
     * retrofit service缓存
     */
    private static Map<String, Object> retrofitServices = new HashMap<>();
    private static Retrofit sRetrofit;

    /**
     * 获取OkHttp
     *
     * @return OkHttpClient
     */
    private static OkHttpClient getOkHttpClient() {
        return getOkHttpBuilder().build(); // TODO: 2018/4/4 添加证书验证 by zs
    }

    private static OkHttpClient.Builder getOkHttpBuilder() {
        // add log
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        //setup cache
        File httpCacheDirectory = new File(App.getInstance().getCacheDir(), "responses");
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(httpCacheDirectory, cacheSize);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (BuildConfig.LOG_DEBUG) {
            builder.addInterceptor(httpLoggingInterceptor);
        }

        return builder
                .addNetworkInterceptor(cacheInterceptor)//缓存拦截器
                .addInterceptor(requestInterceptor)//请求拦截器
                .addInterceptor(loggingInterceptor)//日志拦截器
                .connectTimeout(TIMEOUT_CONNECTION, TimeUnit.SECONDS)//time out
                .readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)//读超时
                .writeTimeout(TIMEOUT_READ, TimeUnit.SECONDS)//写超时
                .cache(cache)
                .retryOnConnectionFailure(true);//失败重连
    }

    public static <T> T createApi(Class<T> clazz) {
        return createApi(clazz, AppConstants.Api.BASE_URL_RELEASE);
    }

    public synchronized static <T> T createApi(Class<T> clazz, String url) {

        T retrofitService;
        Object serviceObj = retrofitServices.get(clazz.getName() + url);
        if (serviceObj != null) {
            retrofitService = (T) serviceObj;
            return retrofitService;
        }
        retrofitService = getRetrofit(url).create(clazz);
        retrofitServices.put(clazz.getName() + url, retrofitService);
        return retrofitService;
    }

    /**
     * 获取Retrofit单例
     */
    private static Retrofit getRetrofit(String url) {
        if (sRetrofit != null && AppConstants.Api.BASE_URL_RELEASE.equals(url)) {
            return sRetrofit;
        }
        return sRetrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(getOkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//使用rxjava
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * 文件上传捕获上传进度的时候使用
     *
     * @param filePath 文件路径
     * @param listener 监听
     * @return okhttp
     */
    public static OkHttpClient.Builder getOkHttpBuilderWithListener(String filePath, UploadProgressInterceptor.ProgressListener listener) {
        return new OkHttpClient.Builder()
                .addNetworkInterceptor(cacheInterceptor)//缓存拦截器
                .addInterceptor(requestInterceptor)//请求拦截器
                .addInterceptor(loggingInterceptor)//日志拦截器
                .addInterceptor(new UploadProgressInterceptor(filePath, listener))
                .connectTimeout(TIMEOUT_CONNECTION, TimeUnit.SECONDS)//time out
                .readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)//读超时
                .writeTimeout(TIMEOUT_READ, TimeUnit.SECONDS)//写超时
                .retryOnConnectionFailure(true);//失败重连
    }

    public static Retrofit getRetrofit(OkHttpClient client) {
        return sRetrofit = new Retrofit.Builder()
                .baseUrl(AppConstants.Api.BASE_URL_RELEASE)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//使用rxjava
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}

