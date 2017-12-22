package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nerc on 2017/10/11.
 */

public class SpeakingHallModel {


    /**
     * RowIndex : 1
     * workId : 23
     * Title : 送教进社区系列活动之“老年人养生保健”专题讲座
     * BeginTime : 2017-11-01T09:46:00
     * EndTime : 2017-12-30T09:46:00
     * Address : 白沙马腾社区
     * Teacher : 黄红毅
     * ImageURL : http://202.205.161.103:8035/UploadFile/c28f91f2-4b7e-4e72-b48c-c9b4056c195e.jpg
     * CreateDatetime : 2015-11-08T13:56:42
     */

    @SerializedName("RowIndex")
    public int index;
    @SerializedName("workId")
    public String id;
    @SerializedName("Title")
    public String title;
    @SerializedName("BeginTime")
    public String beginTime;
    @SerializedName("EndTime")
    public String endTime;
    @SerializedName("Address")
    public String address;
    @SerializedName("Teacher")
    public String teacher;
    @SerializedName("ImageURL")
    public String img;
    @SerializedName("CreateDatetime")
    public String createDatetime;
}
