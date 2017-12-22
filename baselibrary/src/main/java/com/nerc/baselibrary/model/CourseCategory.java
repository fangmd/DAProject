package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by nerc on 2017/8/7.
 */

public class CourseCategory {


    /**
     * ItemID : 47
     * ItemName : 实用技能
     * ItemNum : 15
     * CourseList : [{"CourseID":364,"CourseName":"人工智能会抢走我们的工作吗？","ItemImgURL":"http: //202.205.161.103: 8035/UploadFile/10f769eb-10c5-4a90-9ee8-eeb9d69f8da9.jpg"},{"CourseID":362,"CourseName":"观赏植物的栽培管理","ItemImgURL":"http: //202.205.161.103: 8035/UploadFile/fd67d100-0c06-4f33-9c56-9e23801ccacd.jpg"},{"CourseID":359,"CourseName":"玩转Excel2013：财务管理专题","ItemImgURL":"http: //202.205.161.103: 8035/UploadFile/4018fb2e-cc61-4e8c-8e69-6d55e5bacff5.jpg"},{"CourseID":358,"CourseName":"玩转Excel2013：行政人事专题","ItemImgURL":"http: //202.205.161.103: 8035/UploadFile/774f8a4e-1ff5-42d4-8000-936689f1e904.jpg"},{"CourseID":357,"CourseName":"玩转Excel2013：图表应用篇","ItemImgURL":"http: //202.205.161.103: 8035/UploadFile/b635c47d-9819-4f2d-a121-11a5c35c5c63.jpg"}]
     */

    @SerializedName("ItemID")
    public String id;
    @SerializedName("ItemName")
    public String name;
    @SerializedName("ItemNum")
    public int number;
    @SerializedName("CourseList")
    public List<CourseCategoryListBean> courseList;

    public static class CourseCategoryListBean {
        /**
         * CourseID : 364
         * CourseName : 人工智能会抢走我们的工作吗？
         * ItemImgURL : http: //202.205.161.103: 8035/UploadFile/10f769eb-10c5-4a90-9ee8-eeb9d69f8da9.jpg
         */

        @SerializedName("CourseID")
        public String id;
        @SerializedName("CourseName")
        public String name;
        @SerializedName("ItemImgURL")
        public String imgUrl;
    }
}
