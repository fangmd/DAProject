package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * TopicReplyModel
 * Created by nerc on 2017/10/27.
 */

public class TopicReplyModel {

    /**
     * RowIndex : 1
     * Id : 4
     * Content : 4444444
     * CreateUserId : 445
     * CreateDate : 2017-12-19T00:00:00
     * Pid : 2
     * Topicid : 2
     * userName : student
     * trueName : 小李
     * UserImage : http://202.205.161.103:8040/jquery_upload_New/uploadAvatar/upload/472d895d-17de-46dd-9965-8c8dd19bd6fd.jpg
     * CreateTime : 2017-12-19 00:00
     * ShowName
     */

    @SerializedName("RowIndex")
    public int index;
    @SerializedName("Id")
    public String id;
    @SerializedName("Content")
    public String content;
    @SerializedName("CreateUserId")
    public String createUserId;
    @SerializedName("CreateDate")
    public String createDate;
    @SerializedName("Pid")
    public String pId;
    @SerializedName("Topicid")
    public String topicid;
    @SerializedName("userName")
    public String userName;
    @SerializedName("trueName")
    public String trueName;
    @SerializedName("UserImage")
    public String userImage;
    @SerializedName("CreateTime")
    public String createTime;
    @SerializedName("ShowName")
    public String showName;
}
