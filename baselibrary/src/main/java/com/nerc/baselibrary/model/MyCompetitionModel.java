package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * MyCompetitionModel
 * Created by nerc on 2017/10/23.
 */

public class MyCompetitionModel {

    /**
     * RowIndex : 1
     * Id : 6
     * Name : 练习2
     * StartTime : 2017-10-10T00:00:00
     * ImgPath : http://202.205.161.103:8035/UploadFile/324e669e-5366-4734-94ad-5bea08aa8084.jpg
     * ItemJoinTime : 2017.10.12
     * ItemEndTime : 2017.11.05
     *
     * StartTime: "2017-10-10T00:00:00",
     EndTime: "2017-11-05T23:59:59",

     wid
     */

    @SerializedName("RowIndex")
    public int index;
    @SerializedName("Id")
    public String competitionId;
    @SerializedName("wid")
    public String workId;
    @SerializedName("Name")
    public String name;
    @SerializedName("StartTime")
    public String startTime;
    @SerializedName("EndTime")
    public String endTime;
    @SerializedName("ImgPath")
    public String img;
    @SerializedName("ItemJoinTime")
    public String itemJoinTime;
    @SerializedName("ItemEndTime")
    public String itemEndTime;
}
