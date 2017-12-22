package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nerc on 2017/8/8.
 */

public class StudyStatisticsModel {


    /**
     * CourseStepName : 总计
     * StudyTime : 0/25
     * Note : 0
     */

    @SerializedName("CourseStepName")
    public String name;
    @SerializedName("StudyTime")
    public String time;
    @SerializedName("Note")
    public int note;
}
