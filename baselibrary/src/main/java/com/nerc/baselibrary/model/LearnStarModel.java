package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nerc on 2017/8/3.
 */

public class LearnStarModel {

    /**
     * studentId : 449
     * UserImage : http://202.205.161.103:8035/jquery_upload_New/uploadAvatar/upload/8fd4e04e-91eb-44ca-8c9d-f3517d5ffe5d.png
     * userName : lei_student
     * TrueName : 李明
     * sumcredit : 40
     * state : 1
     */

    @SerializedName("studentId")
    public String id;
    @SerializedName("UserImage")
    public String imageUrl;
    @SerializedName("userName")
    public String name;
    @SerializedName("TrueName")
    public String trueName;
    @SerializedName("sumcredit")
    public int sumcredit;
    @SerializedName("state")
    public int state;
}
