package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * TopicImageModel
 * Created by nerc on 2017/10/26.
 */

public class TopicImageModel {

    /**
     * Id : 1
     * Imgurl : http://202.205.161.103:8035/UploadFile/c1961367-dbd0-4b58-a96f-4491b1e3f1d3.jpg
     * TopicId : 2
     * CreateTime : 2017-10-25T10:04:37
     */

    @SerializedName("Id")
    public String id;
    @SerializedName("Imgurl")
    public String img;
    @SerializedName("TopicId")
    public String topicId;
    @SerializedName("CreateTime")
    public String createTime;
}
