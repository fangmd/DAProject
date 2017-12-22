package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nerc on 2017/9/1.
 */

public class SearchCourseModel {


    /**
     * ItemID : 369
     * ItemName : 2中国传统文化
     * ItemImgURL : http://202.205.161.103:8035/UploadFile/a32bd341-3854-4569-953a-21a4becdd9d3.jpg
     * ItemSource : 巴南区
     * ItemStyle : 家庭生活
     */

    @SerializedName("ItemID")
    public String id;
    @SerializedName("ItemName")
    public String name;
    @SerializedName("ItemImgURL")
    public String imgUrl;
    @SerializedName("ItemSource")
    public String source;
    @SerializedName("ItemStyle")
    public String style;
}
