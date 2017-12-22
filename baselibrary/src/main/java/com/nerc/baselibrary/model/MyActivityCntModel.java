package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * MyActivityCntModel
 * Created by nerc on 2017/11/10.
 */

public class MyActivityCntModel {


    /**
     * CountThemeActiveApply : 5
     * <p>
     * CountActivityInfo
     * CountSyclass
     */

    @SerializedName(value = "CountThemeActiveApply", alternate = {"CountActivityInfo", "CountSyclass", "CountSurvey"})
    public int countThemeActiveApply;
}
