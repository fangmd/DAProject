package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * ArchivesCourseModel
 * Created by nerc on 2017/10/23.
 */

public class ArchivesCourseModel {

    /**
     * CourseName : 16自己学日语 生活词汇
     * StudyTime : 4
     * LeanTime : 4
     * TimePercent : 50
     * TestFinish : 2
     * TestCount : 2
     * TestPercent : 50
     * CourseScort : 82.5
     * PassState : 通过
     */

    @SerializedName("CourseName")
    public String courseName;
    @SerializedName("StudyTime")
    public String studyTime;
    @SerializedName("LeanTime")
    public String recommandLeanTime; // 要求学习时长
    @SerializedName("TimePercent")
    public String timePercent;
    @SerializedName("TestFinish")
    public String testFinish;
    @SerializedName("TestCount")
    public String testCount;
    @SerializedName("TestPercent")
    public String testPercent;
    @SerializedName("CourseScort")
    public String courseScort;
    @SerializedName("PassState")
    public String passState;
}
