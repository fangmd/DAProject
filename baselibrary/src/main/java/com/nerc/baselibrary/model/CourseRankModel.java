package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * CourseRankModel
 * Created by nerc on 2017/10/19.
 */

public class CourseRankModel {

    /**
     {
     workId: 61,
     courseName: "幸福的能力",
     TypeName: "家庭生活",
     coursecount: 5,
     CourseImage: "http://202.205.161.103:8035/UploadFile/703c132c-080f-4c93-b397-68bb01abb4e4.jpg"
     }
     *
     *
     */

    @SerializedName("workId")
    public String id;
    @SerializedName("courseName")
    public String name;
    @SerializedName("TypeName")
    public String type;
    @SerializedName("CourseImage")
    public String img;
    @SerializedName("coursecount")
    public int count;
}
