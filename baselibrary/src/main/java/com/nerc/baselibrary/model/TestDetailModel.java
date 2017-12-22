package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nerc on 2017/8/14.
 */

public class TestDetailModel {


    /**
     * ItemID : 4
     * ItemPaperID : 78a35ba5-6e6d-415f-822a-a9d1384c4384
     * ItemPaperTitle : 日本旅游防骗
     * ItemEndTime : 2017-05-22T23:59:59
     * ItemExamState : 2
     * ItemFillExamNum : 0
     * IsExpired : 1
     * ExamTime : 5
     * ActiveScore : 60
     */

    @SerializedName("ItemID")
    public String id;
    @SerializedName("ItemPaperID")
    public String paperId;
    @SerializedName("ItemPaperTitle")
    public String paperTitle;
    @SerializedName("ItemEndTime")
    public String endTime;
    @SerializedName("ItemExamState")
    public int examState;
    @SerializedName("ItemFillExamNum")
    public int ƒillExamNum;
    @SerializedName("IsExpired")
    public int isExpired;
    @SerializedName("ExamTime")
    public int examTime;
    @SerializedName("ActiveScore")
    public String activeScore;
}
