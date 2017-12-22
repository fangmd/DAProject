package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * 1. 我的收藏 课程
 * 2. 课程列表
 * Created by nerc on 2017/8/2.
 */

public class CourseModel {


    /**
     * ItemID : 26
     * ItemName : 了解社会工作
     * ItemImgURL : http://202.205.161.103:8035/UploadFile/e47d4193-8ce5-46b5-b836-43f26574001b.jpg
     * ItemSource : 巴南区
     *
     * {
     ItemID: 26,
     ItemName: "了解社会工作",
     ItemImgURL: "http://202.205.161.103:8035/UploadFile/e47d4193-8ce5-46b5-b836-43f26574001b.jpg",
     ItemSource: "巴南区",
     ClickCount: 96,
     ItemStyle: "社工培训",
     IteamStudengCount: 6
     }

     首页 我的课程 json：
     {
     "ItemID": 369,
     "ItemName": "2中国传统文化",
     "ItemImgURL": "http://202.205.161.103:8035/UploadFile/a32bd341-3854-4569-953a-21a4becdd9d3.jpg",
     "ItemSource": "巴南区",
     "ClickCount": 12,
     "ItemStyle": "家庭生活",
     "IteamStudengCount": 1,
     "operDate": "2017-09-27T14:52:22.38"
     }

     课程类型 json
     {
     RowIndex: 1,
     Id: 366,
     CourseName: "犯错的价值",
     CreationDate: "2017-05-15T13:33:44",
     FirstCourseType: 102,
     Price: 0,
     countid: 1,
     CourseImage: "http://202.205.161.103:8040/UploadFile/3757f662-c0d6-4a62-b37c-f3f0ca60cf5b.jpg",
     ClickCount: 8,
     IsOldAgeCourse: 0,
     ItemStyle: "公民修养"
     }
     */

    /**
     *
     * 我的收藏
     *  {
     "CollectionInfoId": 3,
     "CourseId": 371,
     "CourseName": "4四季煲汤",
     "CourseType": "实用技能",
     "CourseImage": "http://202.205.161.103:8035/UploadFile/b3447f6a-23b4-4765-bad6-8119f6529a48.jpg"
     }
     */

    @SerializedName(value = "ItemID",alternate = {"Id", "CourseId"})
    public String id;
    @SerializedName(value = "ItemName", alternate = "CourseName")
    public String name;
    @SerializedName(value = "ItemImgURL",alternate = "CourseImage")
    public String imageUrl;
    @SerializedName("ItemSource")
    public String source;
    @SerializedName("ClickCount")
    public int ClickCount;
    @SerializedName(value = "ItemStyle", alternate = "CourseType")
    public String style;
    @SerializedName("IteamStudengCount")
    public int studentCount;
    @SerializedName(value = "operDate",alternate = "CreationDate")
    public String date;
    @SerializedName("CourseAttribute")
    public int courseAttribute; // 0: 自由课程，1：项目课程

    /**
     * 用于首页 我的课程 的加入课程添加表示符号， -1：表示 加入课程，0：表示正常显示
     */
    public int type = 0;

    // collections:
    @SerializedName("CollectionInfoId")
    public String collectionInfoId;

}
