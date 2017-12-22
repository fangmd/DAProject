package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nerc on 2017/10/30.
 */

public class TopicCreateModel {

    /**
     * GroupId : 圈子ID
     * Title : 话题标题
     * CreateUserId : 作者
     * Describtion : 话题内容
     * imgurls : 图片.jpg|图片.jpg...
     */

    @SerializedName("GroupId")
    public String circleId;
    @SerializedName("Title")
    public String title;
    @SerializedName("CreateUserId")
    public String createUserId;
    @SerializedName("Describtion")
    public String describtion;
    /**
     * img url 地址， 使用 | 拼接
     */
    @SerializedName("imgurls")
    public String imgurls;
}
