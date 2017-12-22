package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * TopicReplyBodyModel
 * Created by nerc on 2017/10/27.
 */

public class TopicReplyBodyModel {

    /**
     * Topicid : 话题ID
     * CreateUserId : 作者
     * Pid : 回复话题传0；回复回复，传回复ID
     * Content : 回复内容
     */

    @SerializedName("Topicid")
    public String topicid;
    @SerializedName("CreateUserId")
    public String createUserId;
    @SerializedName("Pid")
    public String pid;
    @SerializedName("Content")
    public String content;
}
