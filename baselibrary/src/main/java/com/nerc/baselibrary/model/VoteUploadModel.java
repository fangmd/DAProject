package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * VoteUploadModel
 * Created by nerc on 2017/10/18.
 */

public class VoteUploadModel {

    /**
     * WorkInfoId : 作品ID
     * MacAdress : 投票手机MaxAdress
     */

    @SerializedName("WorkInfoId")
    public String workId;
    @SerializedName("MacAdress")
    public String macAdress;
}
