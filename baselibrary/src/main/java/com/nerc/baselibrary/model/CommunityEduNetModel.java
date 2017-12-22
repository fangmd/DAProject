package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * CommunityEduNetModel
 * Created by nerc on 2017/10/10.
 */

public class CommunityEduNetModel {

    /**
     * workId : 5515
     * schoolName : 南泉街道
     * CourseCount : 0
     * usercount : 23
     * ThemeActivecount
     */

    @SerializedName("workId")
    public String id;
    @SerializedName("schoolName")
    public String schoolName;
    @SerializedName("CourseCount")
    public int courseCount;
    @SerializedName("usercount")
    public String userCnt;
    @SerializedName("ThemeActivecount")
    public int themeActivecount;

}
