package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nerc on 2017/8/9.
 */

public class HomeworkModel {


    /**
     * zuoyeID : 8
     * zuoyename : 我要飞翔1-10页
     * endtime : 2017/5/30 23:59:59
     */

    @SerializedName("zuoyeID")
    public String id;
    @SerializedName("zuoyename")
    public String name;
    @SerializedName("endtime")
    public String endTime;
}
