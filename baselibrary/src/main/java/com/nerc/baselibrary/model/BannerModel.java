package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * BannerModel
 * Created by nerc on 2017/8/2.
 */

public class BannerModel {

    /**
     * Id : 197
     * Title : 采他山之玉为我所用 纳百家之长助我教学
     * AbstractImg : http://202.205.161.103:8035/NewsAbstractImg/Admin/2017_5_24/1495588255437/12.jpg
     * PostDate : 2017-03-10T13:10:04
     * Type: 2
     */

    @SerializedName("Id")
    public String id;
    @SerializedName("Title")
    public String title;
    @SerializedName("AbstractImg")
    public String imagePath;
    @SerializedName("PostDate")
    public String postDate;
    /**
     * 1: 新闻
     * 2：课程
     * 3：活动
     * {@link com.nerc.baselibrary.AppConstants.BannerType}
     */
    @SerializedName("Type")
    public String type;

}
