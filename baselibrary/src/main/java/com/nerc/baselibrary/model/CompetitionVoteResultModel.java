package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * CompetitionVoteResultModel
 * Created by nerc on 2017/10/18.
 */

public class CompetitionVoteResultModel {

    /**
     * Id : 4
     * Name : 小视频
     * Number :
     * Author: "江小白",
     * TotalVoteCount : 7
     * UpdateTime : 2017-10-11T17:17:03
     * VoteCount_Day : 1
     */

    @SerializedName("Id")
    public String id;
    @SerializedName("Name")
    public String name;
    @SerializedName("Number")
    public String number;
    @SerializedName("Author")
    public String author;
    @SerializedName("TotalVoteCount")
    public int totalVoteCount;
    @SerializedName("UpdateTime")
    public String updateTime;
    @SerializedName("VoteCount_Day")
    public int voteCount_Day;
}
