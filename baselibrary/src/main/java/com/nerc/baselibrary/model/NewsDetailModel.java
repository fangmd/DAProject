package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nerc on 2017/8/14.
 */

public class NewsDetailModel {


    /**
     * workId : 234
     * Title : 附件新闻
     * Body : 附件新闻
     * author : admin
     * AbstractImg : http://202.205.161.103:8035/NewsAbstractImg/Admin/2017_7_25/1500959511524/u=919736089,2390835959&fm=72.jpg
     * ViewCount : 2
     * contentFrom : 附件新闻
     * PostDate : 2017-07-25T13:14:34
     * FileAddress : http://202.205.161.103:8035/UC/UploadFile/timg.rar
     * PostTime : 17-7-25
     */

    @SerializedName("workId")
    public String id;
    @SerializedName("Title")
    public String title;
    @SerializedName("Body")
    public String body;
    @SerializedName("author")
    public String author;
    @SerializedName("AbstractImg")
    public String abstractImg;
    @SerializedName("ViewCount")
    public int viewCount;
    @SerializedName("contentFrom")
    public String contentFrom;
    @SerializedName("PostDate")
    public String postDate;
    @SerializedName("FileAddress")
    public String fileAddress;
    @SerializedName("PostTime")
    public String postTime;
}
