package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * CommunityEduNetAllModel
 * Created by nerc on 2017/10/30.
 */

public class CommunityEduNetAllModel {

    /**
     * ID : 5515
     * schoolName : 南泉街道
     * jielist : [{"ID":5562,"schoolName":"正街"},{"ID":5563,"schoolName":"长南桥"}]
     */

    @SerializedName("ID")
    public String id;
    @SerializedName("schoolName")
    public String schoolName;
    @SerializedName("jielist")
    public List<CommunityEduNetAllModel> jielist;

    public boolean isHead;

//    public static class JielistBean {
//
//        /**
//         * ID : 5562
//         * schoolName : 正街
//         */
//
//        @SerializedName("ID")
//        public String workId;
//        @SerializedName("schoolName")
//        public String schoolName;
//    }
}
