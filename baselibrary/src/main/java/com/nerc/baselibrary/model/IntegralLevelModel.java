package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * IntegralLevelModel
 *
 * Created by nerc on 2017/11/21.
 */

public class IntegralLevelModel {


    /**
     * name : 第一档
     * id : 1
     * reachpoint : 1000
     * point : 50
     */

    @SerializedName("name")
    public String name;
    @SerializedName("id")
    public String id;
    @SerializedName("reachpoint")
    public int reachpoint;
    @SerializedName("point")
    public int point;
}
