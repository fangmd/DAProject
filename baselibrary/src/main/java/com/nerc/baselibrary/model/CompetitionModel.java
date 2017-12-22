package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nerc on 2017/10/9.
 */

public class CompetitionModel {

    /**
     * RowIndex : 1
     * Id : 7
     * Name : 练习2222222
     * Organizer : 国家教育网
     * Endorsor : 北京泛在时代
     * StartTime : 2017-10-16T00:00:00
     * EndTime : 2017-11-30T23:59:59
     * ApplyDeadLine : 2017-10-25T00:00:00
     * VoteDeadLine : 2017-10-28T00:00:00
     * ImgPath : http://202.205.161.103:8035/UploadFile/d18e8240-1484-48eb-a49b-4b328ed321ea.jpg
     * BannerImgPath : http://202.205.161.103:8035/UploadFile/3aead50e-c416-415f-988a-1f1d5ed417b0.jpg
     * WorkInfoCount : 1
     * TotalVoteCount : 1
     */

    @SerializedName("RowIndex")
    public int index;
    @SerializedName("Id")
    public String id;
    @SerializedName("Name")
    public String name;
    @SerializedName("Organizer")
    public String organizer;    // 主办单位
    @SerializedName("Endorsor")
    public String endorsor; // 承办单位
    @SerializedName("StartTime")
    public String startTime;
    @SerializedName("EndTime")
    public String endTime;
    @SerializedName("ApplyDeadLine")
    public String applyDeadLine;
    @SerializedName("VoteDeadLine")
    public String voteDeadLine;
    @SerializedName("ImgPath")
    public String img;
    @SerializedName("BannerImgPath")
    public String bannerImgPath;
    @SerializedName("WorkInfoCount")
    public int workInfoCount;   // 报名人数
    @SerializedName("TotalVoteCount")
    public int totalVoteCount;  // 投票人数

}
