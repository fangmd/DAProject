package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * CircleJoinExitModel
 *
 * 使用场景：
 *
 * 加入圈子
 * 退出圈子
 * 删除圈子成员
 *
 * Created by nerc on 2017/10/25.
 */

public class CircleJoinExitModel {

    /**
     * GroupId : 圈子ID
     * userId : 用户ID
     */

    @SerializedName("GroupId")
    public String groupId;
    @SerializedName("userId")
    public String userId;

}
