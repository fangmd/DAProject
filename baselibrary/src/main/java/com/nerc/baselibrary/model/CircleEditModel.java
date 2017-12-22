package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * CircleEditModel
 * Created by nerc on 2017/10/26.
 */

public class CircleEditModel {

    /**
     * Id : 圈子ID
     * Title : 圈子名称
     * Introduction : 简介
     * CreateUserId : 创建人ID
     * Logo : 缩略图路径
     */

    @SerializedName("Id")
    public String Id;
    @SerializedName("Title")
    public String title;
    @SerializedName("Introduction")
    public String introduction;
    @SerializedName("CreateUserId")
    public String createUserId;
    @SerializedName("Logo")
    public String img;
}
