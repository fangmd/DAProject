package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * CollectionModel
 * 我的收藏
 *
 * 活动
 * Created by nerc on 2017/11/13.
 */

public class CollectionModel {

    /**
     * RowIndex : 1
     * Id : 14
     * CourseID : 218
     * CourseName : null
     * CollectionType : 4
     * CourseType : 市民讲堂
     * CourseImage :
     */

    @SerializedName("RowIndex")
    public int index;
    @SerializedName("Id")
    public String id;
    @SerializedName("CourseID")
    public String courseID;
    @SerializedName("CourseName")
    public String courseName;
    @SerializedName("CollectionType")
    public String collectionType;
    @SerializedName("CourseType")
    public String courseType;
    @SerializedName("CourseImage")
    public String courseImage;

}
