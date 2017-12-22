package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * CompetitionDetailModel
 * Created by nerc on 2017/10/17.
 */

public class CompetitionDetailModel {

    /**
     * Id : 2
     * Name : 11111
     * Organizer : 111
     * Endorsor : 2222222222
     * StartTime : 2017-09-29T00:00:00
     * EndTime : 2017-11-29T23:59:59
     * ApplyDeadLine : 2017-10-29T00:00:00
     * VoteDeadLine : 2017-12-21T00:00:00
     * ImgPath : http://202.205.161.103:8035/UploadFile/538b08e5-7ce4-4144-a92b-29ce150e2b44.jpg
     * BannerImgPath : http://202.205.161.103:8035/UploadFile/f36b4850-3d84-47af-a676-866081244819.jpg
     * WorkInfoCount : 9
     * TotalVoteCount : 16
     * Rules : <p>放到沙发斯蒂芬</p>
     * wid: // 作品
     */

    @SerializedName("Id")
    public String id;
    @SerializedName("Name")
    public String name;
    @SerializedName("Organizer")
    public String organizer;
    @SerializedName("Endorsor")
    public String endorsor;
    @SerializedName("StartTime")
    public String startTime;
    @SerializedName("EndTime")
    public String endTime;
    @SerializedName("ApplyDeadLine")
    public String applyDeadLine;
    @SerializedName("IVoteDeadLined")
    public String voteDeadLine;
    @SerializedName("ImgPath")
    public String img;
    @SerializedName("BannerImgPath")
    public String bannerImgPath;
    @SerializedName("WorkInfoCoun")
    public int workInfoCoun;
    @SerializedName("TotalVoteCount")
    public int totalVoteCount;
    @SerializedName("Rules")
    public String rules;

    /**
     * 用户作品id，如果用户没有参加就为 null
     */
    @SerializedName("wid")
    public String wid;

}
