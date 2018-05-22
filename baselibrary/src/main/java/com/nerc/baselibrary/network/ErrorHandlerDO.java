package com.nerc.baselibrary.network;

import android.net.ParseException;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.nerc.baselibrary.App;
import com.nerc.baselibrary.AppConstants;
import com.nerc.baselibrary.network.constants.ErrorConstant;
import com.nerc.baselibrary.network.model.HttpResponse;
import com.nerc.baselibrary.utils.LoggerUtils;
import com.nerc.baselibrary.utils.ToastUtils;

import org.json.JSONException;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.observers.DisposableObserver;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.HttpException;

/**
 * Author: Created by fangmingdong on 2018/5/21-下午3:29
 * Description:
 */
public abstract class ErrorHandlerDO<T> extends DisposableObserver<T> {

    protected abstract void onNetFail(int code, String msg);

    protected abstract void onNetSuccess(T data);

    @Override
    public void onNext(T t) {
        if (t instanceof HttpResponse) {
            HttpResponse response = (HttpResponse) t;
            if (response.code == 0) {
                onNetSuccess(t);
            } else {
                onNetFail(((HttpResponse) t).code, ((HttpResponse) t).message);
            }
        }else {
            onNetSuccess(t);
        }
    }

    @Override
    public void onError(Throwable e) {
        try {
            dealError(e);
        } catch (Exception e2) {
            LoggerUtils.e(e2);
        }
    }

    @Override
    public void onComplete() {

    }


    private void dealError(Throwable e) {

        LoggerUtils.e(AppConstants.Tag.NET, e);

        int code = -1;
        String msg = "未知错误";
        if (e instanceof UnknownHostException) {
            msg = ErrorConstant.ERROR_NETWORK;
        } else if (e instanceof SocketTimeoutException) {
            msg = ErrorConstant.ERROR_NETWORK;
        } else if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            HttpResponse errorResponse = parseHttpException(httpException);
            code = errorResponse.code;
            msg = "网络异常";
        } else if (e instanceof JsonParseException || e instanceof
                ParseException || e instanceof
                JSONException) {
            msg = "数据解析错误";
        }
        onNetFail(code, msg);
        ToastUtils.showCToast(App.getInstance(), msg);
    }

    /**
     * 解析httpException
     *
     * @param httpException 异常
     * @return ResponseData
     */
    private HttpResponse parseHttpException(HttpException httpException) {
        ResponseBody responseBody = httpException.response().errorBody();
        MediaType type = responseBody.contentType();
        HttpResponse errorResponse = null;
        // 如果是application/json类型数据,则解析返回内容
        if (type.type().equals("application") && type.subtype().equals("json")) {
            try {
                errorResponse = new Gson().fromJson(
                        responseBody.string(), HttpResponse.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return errorResponse;
    }

}
