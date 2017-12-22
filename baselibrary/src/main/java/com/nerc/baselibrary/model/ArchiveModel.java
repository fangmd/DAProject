package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * ArchiveModel
 * Created by nerc on 2017/10/31.
 */

public class ArchiveModel {

    /**
     * LeanTime : 2017/1/23
     * CourseCount : 20
     * PassCourseCount : 0
     * studyTime : 16
     * Credit : 15
     */

    @SerializedName("LeanTime")
    public String leanTime;
    @SerializedName("CourseCount")
    public String courseCount;
    @SerializedName("PassCourseCount")
    public String passCourseCount;
    @SerializedName("studyTime")
    public String studyTime;
    @SerializedName("Credit")
    public String credit;
}
