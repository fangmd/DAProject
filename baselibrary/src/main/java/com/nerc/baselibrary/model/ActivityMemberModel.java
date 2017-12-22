package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * ActivityMemberModel
 * Created by nerc on 2017/11/9.
 */

public class ActivityMemberModel {
    /**
     * Id : 13
     * ActiveTitle : 1111
     * ActiveImgurl : http://202.205.161.103:8035/UploadFile/9817dcb3-2929-4d72-8090-082794dce76c.jpg
     */

    @SerializedName("Id")
    public int id;
    @SerializedName("ActiveTitle")
    public String title;
    @SerializedName("ActiveImgurl")
    public String img;
}
