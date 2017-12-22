package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * AvatarEditBody
 * Created by nercdevAndroid on 2017/6/22.
 */

public class AvatarEditBody {


    /**
     * userId : 学生ID
     * UserImage : 头像路径
     */

    @SerializedName("userId")
    public String userId;
    @SerializedName("UserImage")
    public String userImage;
}
