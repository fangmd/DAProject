package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * MineModel
 * Created by nerc on 2017/10/31.
 */

public class MineModel {

    /**
     * title : 时长
     * countall : 16
     */

    @SerializedName("title")
    public String title;
    @SerializedName("countall")
    public int countall;
}
