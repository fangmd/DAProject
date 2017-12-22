package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * ActivitySignUpModel
 * Created by nerc on 2017/11/9.
 */

public class ActivitySignUpModel {


    /**
     * ThemeActiveId : 活动ID
     * userId : 用户ID
     */

    @SerializedName("ThemeActiveId")
    public String activityid;
    @SerializedName("userId")
    public String userId;
}
