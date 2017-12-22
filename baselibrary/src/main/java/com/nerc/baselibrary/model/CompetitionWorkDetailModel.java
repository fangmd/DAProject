package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * CompetitionWorkDetailModel
 * Created by nerc on 2017/10/18.
 */

public class CompetitionWorkDetailModel {

    /**
     * Id : 10
     * Name : 3333333333
     * ImgPath : http://202.205.161.103:8035/UploadFile/785bad5c-de94-4331-81fd-a405973898cd.jpg
     * FilePath : http://202.205.161.103:8035/UploadFile/43d34062-9a8a-4a21-8c37-1795613a0ff7.mp3
     * Author : 222222222222
     * WorkTypeId : 1
     * WorkTypeName : 请求
     * TotalVoteCount : 1
     * Source : null
     * CreaterTime : 2017-10-13T16:37:16
     * Details : <p>1212</p>
     * <p>
     * PV : 4
     */

    @SerializedName("Id")
    public String id;
    @SerializedName("Name")
    public String name;
    @SerializedName("ImgPath")
    public String img;
    @SerializedName("FilePath")
    public String filePath;
    @SerializedName("Author")
    public String author;
    @SerializedName("WorkTypeId")
    public String workTypeId;
    @SerializedName("WorkTypeName")
    public String workTypeName;
    @SerializedName("TotalVoteCount")
    public int totalVoteCount;
    @SerializedName("Source")
    public String source;
    @SerializedName("CreaterTime")
    public String createrTime;
    @SerializedName("Details")
    public String details;
    @SerializedName("PV")
    public int pv;


    @SerializedName("ItemCollectionInfoId")
    public String collectionId;
    @SerializedName("ItemFavorites")
    public String collectioned;
}
