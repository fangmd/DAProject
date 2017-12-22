package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * CircleCreateModel
 * Created by nerc on 2017/10/25.
 */

public class CircleCreateModel {


    /**
     * Title : 圈子名称
     * Introduction : 简介
     * CreateUserId : 创建人ID
     * Logo : 缩略图路径
     */

    @SerializedName("Title")
    public String title;
    @SerializedName("Introduction")
    public String introduction;
    @SerializedName("CreateUserId")
    public String userId;
    @SerializedName("Logo")
    public String img;

}
