package com.njfea.baselibrary.network;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 网络请求拦截器
 */
public class RequestInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        request = onHttpRequestBefore(request);
        Response originalResponse;
        try {
            originalResponse = chain.proceed(request);
//            saveCookie(originalResponse);
        } catch (Exception e) {
            throw e;
        }

        return originalResponse;
    }

    private void saveCookie(Response originalResponse) {
        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
            List<String> cookies = originalResponse.headers("Set-Cookie");
            for (String cookie : cookies) {
                if (cookie.contains("SESSION")) {
                    String sessionId = cookie.split(";")[0];

                }
            }
        }
    }


    /**
     * 发起请求之前
     * 在这里做一些请求服务器前的一些操作, 比如添加统一的参数和header,或者对参数进行签名
     *
     * @param request
     * @return
     */
    private Request onHttpRequestBefore(Request request) {
        return processParams(request);
    }


    /**
     * 处理请求参数 比如对请求参数进行签名，添加公用的参数
     *
     * @param originRequest 请求
     */
    private Request processParams(Request originRequest) {

        Request.Builder newRequest = originRequest.newBuilder();

        // Header
        Headers.Builder newHeaderBuilder = originRequest.headers().newBuilder();
        Map<String, String> headerMap = getHeaderMap();
        if (headerMap != null && !headerMap.isEmpty()) {
            for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                newHeaderBuilder.add(entry.getKey(), entry.getValue());
            }
            newRequest.headers(newHeaderBuilder.build());
        }

        // Query Param
        if ("GET".equals(originRequest.method())) {
            HttpUrl.Builder newUrlBuilder = originRequest.url().newBuilder();
            Map<String, String> queryParamMap = getQueryParamMap();
            if (queryParamMap != null && !queryParamMap.isEmpty()) {
                for (Map.Entry<String, String> entry : queryParamMap.entrySet()) {
                    newUrlBuilder.addQueryParameter(entry.getKey(), entry.getValue());
                }
                newRequest.url(newUrlBuilder.build());
            }
        } else if ("POST".equals(originRequest.method())) {
            RequestBody body = originRequest.body();
            if (body != null && body instanceof FormBody) {
                // POST Param x-www-form-urlencoded
                FormBody formBody = (FormBody) body;
                Map<String, String> formBodyParamMap = new HashMap<>();
                int bodySize = formBody.size();
                for (int i = 0; i < bodySize; i++) {
                    formBodyParamMap.put(formBody.name(i), formBody.value(i));
                }

                Map<String, String> newFormBodyParamMap = getFormBodyParamMap();
                if (newFormBodyParamMap != null) {
                    formBodyParamMap.putAll(newFormBodyParamMap);
                    FormBody.Builder bodyBuilder = new FormBody.Builder();
                    for (Map.Entry<String, String> entry : formBodyParamMap.entrySet()) {
                        bodyBuilder.add(entry.getKey(), entry.getValue());
                    }
                    newRequest.method(originRequest.method(), bodyBuilder.build());
                }
            } else if (body != null && body instanceof MultipartBody) {
                // POST Param form-data
                MultipartBody multipartBody = (MultipartBody) body;
                MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
                Map<String, String> extraFormBodyParamMap = getFormBodyParamMap();
                for (Map.Entry<String, String> entry : extraFormBodyParamMap.entrySet()) {
                    builder.addFormDataPart(entry.getKey(), entry.getValue());
                }
                List<MultipartBody.Part> parts = multipartBody.parts();
                for (MultipartBody.Part part : parts) {
                    builder.addPart(part);
                }
                newRequest.post(builder.build());
            }
        }
        return newRequest.build();
    }


    /**
     * 添加公共header
     */
    private Map<String, String> getHeaderMap() {
        Map<String, String> headers = new HashMap<>();

        return headers;
    }


    /**
     * get请求添加通过参数
     */
    private Map<String, String> getQueryParamMap() {
        Map<String, String> params = new HashMap<>();

        return params;
    }

    /**
     * post请求添加公共参数
     *
     * @return
     */
    private Map<String, String> getFormBodyParamMap() {
        Map<String, String> postParams = new HashMap<>();

        return postParams;
    }

}
