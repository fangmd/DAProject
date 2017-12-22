package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nerc on 2017/10/13.
 */

public class TrainDetailCourseModel {


    /**
     * RowIndex : 1
     * workId : 184
     * courseName : 教你如何识破旅游“陷阱”
     * state : 1
     * CourseImage : http://202.205.161.103:8035/UploadFile/3e8a35a0-a3b4-42e1-80ad-db7f7635ba19.jpg
     * ClassId : 40
     * CreateTime : 2016-09-22T13:55:30
     */

    @SerializedName("RowIndex")
    public int index;
    @SerializedName("workId")
    public String id;
    @SerializedName("courseName")
    public String courseName;
    @SerializedName("state")
    public int state;
    @SerializedName("CourseImage")
    public String img;
    @SerializedName("ClassId")
    public String classId;
    @SerializedName("CreateTime")
    public String createTime;
}
