package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * ActivityModel
 *
 * 我的活动
 *
 * Created by nerc on 2017/11/1.
 */

public class ActivityModel {

    /**
     * Id : 6
     * Title : 练习2
     * ActiveType : 大赛投票
     * Image : http://202.205.161.103:8035/UploadFile/324e669e-5366-4734-94ad-5bea08aa8084.jpg
     * SEtime : 2017.10.10--2017.11.05
     * createtime : 2017-10-09T13:35:25
     */


    @SerializedName("Id")
    public String id;
    @SerializedName("Title")
    public String title;
    @SerializedName("ActiveType")
    public String activeType;
    @SerializedName("Image")
    public String img;
    @SerializedName("SEtime")
    public String sEtime;
    @SerializedName("createtime")
    public String createtime;

}
