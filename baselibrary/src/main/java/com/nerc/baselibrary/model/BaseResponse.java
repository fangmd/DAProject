package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * BaseResponse
 * Created by nerc on 2017/8/4.
 */

public class BaseResponse {

    /**
     * result : 0
     * message : 创建失败！
     *
     * {
     "status": "1",
     "message": "加入课程成功!"
     }
     */

    /**
     * 提交评分
     * {
     "message": "评分成功！",
     "newscore": "1"
     }
     */

    /**
     * {"message":"收藏成功！","favorites":"1"}
     */

    @SerializedName(value = "result", alternate = {"status", "newscore", "favorites"})
    public int result;
    @SerializedName("message")
    public String message;
}
