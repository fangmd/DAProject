package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nerc on 2017/10/13.
 */

public class TrainDetailModel {

    /**
     * Id : 46
     * ClassName : 老年人学日常生活英语
     * classdatetype : 2
     * ThumbnailFullPath : http://202.205.161.103:8035/UploadFile/Project/ac8e7c6b-3e28-44fa-97b8-3db0bb7ac5b3.jpg
     * Intro : 本书是以美国小学生Jack的生活和学习为主线进行口语练习的实用英语口语读物，其内容包括日常对话，常用词汇及训练扩展，涉及了美国人的日常生活，待人接物等各方面的情景。本书选用目前最流行的美式发音，以现代流行美语为蓝本，既可作为小学生学习口语的教材，又可供英语自学者练习口语使用。
     * ProjectTypeName : 线下项目
     * FreeTypeTitle : ￥120.00
     * ItemStartDate : 2017-02-26
     * ItemEndDate : 2017-07-06
     * ItemBaoMingJieZhiDate : 2017-05-31
     * ButtenState : 已结束
     */

    @SerializedName("Id")
    public String id;
    @SerializedName("ClassName")
    public String name;
    @SerializedName("classdatetype")
    public int classdatetype;
    @SerializedName("ThumbnailFullPath")
    public String thumbnailFullPath;
    @SerializedName("Intro")
    public String intro;
    @SerializedName("ProjectTypeName")
    public String typeName;
    @SerializedName("FreeTypeTitle")
    public String freeTypeTitle;
    @SerializedName("ItemStartDate")
    public String startDate;
    @SerializedName("ItemEndDate")
    public String endDate;
    @SerializedName("ItemBaoMingJieZhiDate")
    public String itemBaoMingJieZhiDate;
    /**
     * {@link com.nerc.baselibrary.AppConstants.TrainDetailState}
     */
    @SerializedName("ButtenState")
    public String buttenState; // 4 中情况：已结束，已报名，报名审核中，立刻报名（只有 立刻报名 状态下按钮可以点击）

    @SerializedName("ItemCollectionInfoId")
    public String collectionId;
    @SerializedName("ItemFavorites")
    public String collecioned;

}
