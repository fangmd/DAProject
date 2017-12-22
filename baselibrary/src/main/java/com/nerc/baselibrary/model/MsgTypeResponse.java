package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nerc on 2017/8/4.
 */

public class MsgTypeResponse {

    /**
     * {
     * "message":"json..."
     * }
     */

    @SerializedName("message")
    public String msg;

}
