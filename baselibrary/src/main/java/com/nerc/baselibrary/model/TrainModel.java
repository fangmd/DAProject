package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nerc on 2017/10/12.
 */

public class TrainModel {


    /**
     * RowIndex : 1
     * Id : 40
     * ClassName : 即将开启的项目
     * classdatetype : 1
     * ThumbnailFullPath : http://202.205.161.103:8035/UploadFile/Project/3ec89737-1f29-476d-8c2b-73e2e07ff5b3.jpg
     * Intro : 快来报名啊，仅限3天，只有三天
     * ProjectTypeName : 线上项目
     * FreeTypeTitle : 免费
     * ItemStartDate : 2017-10-08
     * ItemEndDate : 2017-11-08
     * ItemBaoMingJieZhiDate : 2016-10-06
     */

    @SerializedName("RowIndex")
    public int index;
    @SerializedName("Id")
    public String id;
    @SerializedName("ClassName")
    public String name;
    @SerializedName("classdatetype")
    public int sate;
    @SerializedName("ThumbnailFullPath")
    public String thumbnailFullPath;
    @SerializedName("Intro")
    public String intro;
    @SerializedName("ProjectTypeName")
    public String typeName;
    @SerializedName("FreeTypeTitle")
    public String freeTypeTitle;
    @SerializedName("ItemStartDate")
    public String startDate;
    @SerializedName("ItemEndDate")
    public String endDate;
    @SerializedName("ItemBaoMingJieZhiDate")
    public String ItemBaoMingJieZhiDate;
}
