package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nerc on 2017/10/18.
 */

public class CompetitionSignUpModel {

    /**
     * Name : 作品名称
     * Author : 作者
     * Creater : 创建人ID
     * ImgPath : 缩略图路径
     * FilePath : 作品路径
     * Details : 作品简介
     * WorkTypeId : 作品分类ID
     * ActivityId : 所属大赛ID
     */

    @SerializedName("Name")
    public String name;
    @SerializedName("Author")
    public String author;
    @SerializedName("Creater")
    public String creater;
    @SerializedName("ImgPath")
    public String img;
    @SerializedName("FilePath")
    public String filePath;
    @SerializedName("Details")
    public String details;
    @SerializedName("WorkTypeId")
    public String workTypeId;
    @SerializedName("ActivityId")
    public String activityId;
}
