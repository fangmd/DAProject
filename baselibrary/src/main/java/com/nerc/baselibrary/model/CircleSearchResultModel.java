package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * CircleSearchResultModel
 * <p>
 * Circle 搜索
 * 首页搜索 - 活动搜索
 * Created by nerc on 2017/10/30.
 */

public class CircleSearchResultModel {

    /**
     * RowIndex : 1
     * Id : 2
     * Title : 动态图片制作
     * Introduction : 旨在邀有相近兴趣同学在一起相互学习，交流，创做喜欢的作品，以提高自己，服务大家！
     * Logo : http://202.205.161.103:8040/UploadFile/a32ff924-9aa0-4105-ab15-fd75ba285cc0.gif
     * IsLeader : 1
     * CreateDate : 2015-04-12T12:15:27
     * menber : 2
     */


    @SerializedName("RowIndex")
    public int index;
    @SerializedName("Id")
    public String id;
    @SerializedName(value = "Title", alternate = "ActiveTitle")
    public String title;
    @SerializedName(value = "Introduction", alternate = "Describtion")
    public String introduction;
    @SerializedName(value = "Logo", alternate = {"Imgurl", "ActiveImgurl"})
    public String img;
    @SerializedName("IsLeader")
    public int isLeaderC;
    @SerializedName(value = "CreateDate", alternate = "CreateTime")
    public String createDate; // 2015-04-12T12:15:27, "2015-05-29 09:49" 有两种可能
    @SerializedName("menber")
    public int memberCntC;


    /**
     * {
     * "RowIndex": 1,
     * "Id": 2,
     * "CreateUserId": 218,
     * "userName": "admin",
     * "trueName": "管理员",
     * "UserImage": "http://202.205.161.103:8040/UploadFile/images/unknown.jpg",
     * "Title": "生活",
     * "Describtion": "<p>有兴趣的同学一起来学习发的所发生的放松的发斯蒂芬斯蒂芬</p>  ",
     * "CreateDate": "2015-05-29T09:49:23",
     * "GroupTitle": "动态图片制作",
     * "agreeCount": 0,
     * "AnswerCount": 2,
     * "Imgurl": "http://202.205.161.103:8040/UploadFile/c1961367-dbd0-4b58-a96f-4491b1e3f1d3.jpg",
     * "CreateTime": "2015-05-29 09:49"
     * }
     */

    @SerializedName("CreateUserId")
    public int userIdT;
    @SerializedName("userName")
    public String userNameT;
    @SerializedName("trueName")
    public String trueNameT;
    @SerializedName("UserImage")
    public String userImgT;
    @SerializedName("agreeCount")
    public int agreeCountT;
    @SerializedName("AnswerCount")
    public int answerCountT;
    @SerializedName("GroupTitle")
    public String groupTitleT;

    /**
     * 首页-》 活动搜索
     * {
     * "RowIndex": 1,      ok
     * "Id": 7,   ok
     * "ActiveTitle": "去问问",
     * "ActiveImgurl": "http://202.205.161.103:8035/UploadFile/55a4e3ee-859d-47ec-ace9-6eb9dde619fa.jpg",
     * "studentcount": 0,
     * "address": null,
     * "ItemPrice": "￥1000.00",
     * "ItemSEDate": "2017.11.02--2017.11.11",
     * "ItemBaoMingJieZhiDate": "2017.11.08"
     * }
     */

    @SerializedName("studentcount")
    public int studentCntAct;
    @SerializedName("address")
    public String addressAct;
    @SerializedName("ItemPrice")
    private String proceAct;
    @SerializedName("ItemSEDate")
    public String sEDateAct;
    @SerializedName("ItemBaoMingJieZhiDate")
    public String deadlineAct;

}
