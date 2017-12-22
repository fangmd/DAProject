package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nerc on 2017/8/8.
 */

public class TestStatisticsModel {

    /**
     * PartName : 作业：暂无
     * PartScore : --
     * PartActiveScore : --
     * PartScale : --
     * PartActualScore : --
     * PartStatus : --
     */

    @SerializedName("PartName")
    public String name;
    @SerializedName("PartScore")
    public String score;
    @SerializedName("PartActiveScore")
    public String activeScore;
    @SerializedName("PartScale")
    public String scale;
    @SerializedName("PartActualScore")
    public String actualScore;
    @SerializedName("PartStatus")
    public String status;
}
