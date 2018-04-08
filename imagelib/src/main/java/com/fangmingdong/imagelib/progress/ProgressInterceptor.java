package com.fangmingdong.imagelib.progress;

import android.text.TextUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Glide OkHttp 网络请求拦截器
 * Created by double on 2018/4/8.
 */

public class ProgressInterceptor implements Interceptor {

    public static final Map<String, ProgressListener> LISTENER_MAP = new HashMap<>();

    /**
     * 注册加载监听
     */
    public static void addListener(String url, ProgressListener listener) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        LISTENER_MAP.put(url, listener);
    }

    /**
     * 取消注册监听
     */
    public static void removeListener(String url) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        LISTENER_MAP.remove(url);
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);
        String url = request.url().toString();
        ResponseBody body = response.body();
        Response newResponse = response.newBuilder().body(new ProgressResponseBody(url, body)).build();
        return newResponse;
    }
}
