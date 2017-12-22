package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nerc on 2017/10/16.
 */

public class CourseTypeModel {

    /**
     * workId : 41
     * TypeName : 社工培训
     * pId : -1
     * Deep : 1
     * IsRecommend : 0
     */

    @SerializedName("workId")
    public String id;
    @SerializedName("TypeName")
    public String name;
    @SerializedName("pId")
    public String pId;
    @SerializedName("Deep")
    public String deep;
    @SerializedName("IsRecommend")
    public int isRecommend;
}
