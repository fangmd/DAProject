package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * 社教咨询，活动公告
 * 资讯公告
 * Created by nerc on 2017/8/3.
 */

public class LearnNewsModel {

    /**
     * Id : 197
     * Title : 采他山之玉为我所用 纳百家之长助我教学
     * Abstract :
     * AbstractImg : http://202.205.161.103:8035/NewsAbstractImg/Admin/2017_5_24/1495588255437/12.jpg
     * PostDate : 2017-03-10T13:10:04
     * LastModifiedDate : 2017-05-24T09:11:51
     * ViewCount : 13
     * RowIndex : 1
     * PostTime : 17-3-10
     */

    @SerializedName("Id")
    public String id;
    @SerializedName("Title")
    public String title;
    @SerializedName("Abstract")
    public String abstractC;
    @SerializedName("AbstractImg")
    public String abstractImg;
    @SerializedName("PostDate")
    public String postDate;
    @SerializedName("LastModifiedDate")
    public String lastModifiedDate;
    @SerializedName("ViewCount")
    public int viewCount;
    @SerializedName("RowIndex")
    public int rowIndex;
    @SerializedName("PostTime")
    public String postTime;
}
