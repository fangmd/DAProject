package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nerc on 2017/8/2.
 */

public class LoginModel {

    /**
     * uid : 445
     * userImageURL : http://202.205.161.103:8035/UploadFile/images/unknown.jpg
     * userName : student
     * userEmail :
     * status : 1
     * message : 登录成功
     */

    @SerializedName("uid")
    public String uid;
    @SerializedName("userImageURL")
    public String imageUrl;
    @SerializedName("userName")
    public String name;
    @SerializedName("userEmail")
    public String email;
    @SerializedName("status")
    public int status;
    @SerializedName("message")
    public String message;
    @SerializedName("trueName")
    public String trueName;
    @SerializedName("schoolname")
    public String source;
}
