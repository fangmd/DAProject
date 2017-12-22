package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * CompetitionWorkModel
 * Created by nerc on 2017/10/17.
 */

public class CompetitionWorkModel {

    /**
     * RowIndex : 1
     * Id : 3
     * Name : 林中鸟
     * ImgPath : http://202.205.161.103:8035/UploadFile/0dd6444b-dc32-4d9f-bf7f-bdbeb208b172.jpg
     * Author : 小李学机
     * WorkTypeId : 16
     * WorkTypeName : 娱乐
     * TotalVoteCount : 2
     */

    @SerializedName("RowIndex")
    public int index;
    @SerializedName("Id")
    public String id;
    @SerializedName("Name")
    public String name;
    @SerializedName("ImgPath")
    public String img;
    @SerializedName("Author")
    public String author;
    @SerializedName("WorkTypeId")
    public int workTypeId;
    @SerializedName("WorkTypeName")
    public String workTypeName;
    @SerializedName("TotalVoteCount")
    public int totalVoteCount;
}
