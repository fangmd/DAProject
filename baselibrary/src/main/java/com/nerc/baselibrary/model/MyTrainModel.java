package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nerc on 2017/10/23.
 */

public class MyTrainModel {


    /**
     * RowIndex : 1
     * Id : 46
     * ClassName : 老年人学日常生活英语
     * ThumbnailFullPath : http://202.205.161.103:8035/UploadFile/Project/ac8e7c6b-3e28-44fa-97b8-3db0bb7ac5b3.jpg
     * CourseCount : 2
     * State : 1
     * ItemSEDate : 2017.02.26--2017.07.06
     */

    @SerializedName("RowIndex")
    public int index;
    @SerializedName("Id")
    public String id;
    @SerializedName("ClassName")
    public String className;
    @SerializedName("ThumbnailFullPath")
    public String img;
    @SerializedName("CourseCount")
    public int courseCount;
    @SerializedName("State")
    public String state;
    @SerializedName("ItemSEDate")
    public String sEDate;
}
