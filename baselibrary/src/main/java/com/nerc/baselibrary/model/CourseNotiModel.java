package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nerc on 2017/8/8.
 */

public class CourseNotiModel {

    /**
     * RowIndex : 1
     * ItemID : 20
     * ItemTitle : 社区教育工作纪实
     * ItemContent : asdfasdfasdfasdfasdfsdfsdafasd社区教育工作纪实社区教育工作纪实社区教育工作纪实社区教育工作纪实
     * ItemIsUp : 0
     * ItemCreatorName :
     * ItemCreateTime : 2017-07-27
     */

    @SerializedName("RowIndex")
    public int rowIndex;
    @SerializedName("ItemID")
    public String id;
    @SerializedName("ItemTitle")
    public String title;
    @SerializedName("ItemContent")
    public String content;
    @SerializedName("ItemIsUp")
    public int isUp;
    @SerializedName("ItemCreatorName")
    public String creatorName;
    @SerializedName("ItemCreateTime")
    public String createTime;
}
