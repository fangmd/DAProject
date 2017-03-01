package com.adouble.dagger2demo.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by double on 2017/1/8.
 */

public class HttpResponse<T extends Object> {
    @SerializedName("code")
    public int code;
    @SerializedName("message")
    public String message;
    @SerializedName("data")
    public T t;
}
