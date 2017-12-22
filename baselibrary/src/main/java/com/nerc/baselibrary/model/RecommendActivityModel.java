package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nerc on 2017/10/16.
 */

public class RecommendActivityModel {
    /**
     * Id : 49
     * Title : 111111111111
     * ActiveType : 培训项目
     * Image :
     * BeginTime : 2017-12-25T00:00:00
     * EndTime : 2017-12-27T23:59:59
     * SEtime : 2017.12.25--2017.12.27
     * Address :
     */

    @SerializedName("Id")
    public String id;
    @SerializedName("Title")
    public String title;
    @SerializedName("ActiveType")
    public String activeType;
    @SerializedName("Image")
    public String img;
    @SerializedName("BeginTime")
    public String beginTime;
    @SerializedName("EndTime")
    public String endTime;
    @SerializedName("SEtime")
    public String sEtime;
    @SerializedName("Address")
    public String address;
}
