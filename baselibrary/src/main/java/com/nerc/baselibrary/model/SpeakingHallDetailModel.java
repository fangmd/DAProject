package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * SpeakingHallDetailModel
 * Created by nerc on 2017/10/11.
 */

public class SpeakingHallDetailModel {

    /**
     * workId : 23
     * Title : 送教进社区系列活动之“老年人养生保健”专题讲座
     * BeginTime : 2017-11-01T09:46:00
     * EndTime : 2017-12-30T09:46:00
     * Address : 白沙马腾社区
     * Teacher : 黄红毅
     * ImageURL : http://202.205.161.103:8035/UploadFile/c28f91f2-4b7e-4e72-b48c-c9b4056c195e.jpg
     * Description : 一、活动目的及意义
     * 怎样让老人健康长寿，怎样将养生和养老结合起来，如何科学养生，这其中还是有很多科学依据的。为普及健康养生知识，提高中老年朋友身体素质，江门社区大学联合市人民医院和潮连街道芝山居委会，通过组织社区居民开展老年人养生保健专题讲座。通过此次讲座给老年朋友提供一个了解更多养生知识的平台。
     * 二、活动时间及地点
     * 活动时间:2015年10月29日下午3:00-4:30
     * 活动地点: 白沙马腾社区
     * 特邀嘉宾：黄红毅护师
     * 主持：赵海玲
     * 三、前期准备
     * 1、横幅：
     * 送教进社区系列活动之“老年人养生保健”专题讲座
     * 江门社区大学、白沙马腾社区
     * 白沙马腾社区工作人员电话或上门通知社区老人。派发宣传单（见附件），印制50份。
     * 2、准备采购纪念品
     * 四、活动流程
     * 1、流程一：3:00-3:05
     * 主持人作开场介绍和讲解当天活动讲座的主要内容和单位。
     * 2、流程二：3:05-3：40
     * 黄红毅护师主讲：“老年人养生保健”专题讲座
     * 3、流程三：3：40-3：55
     * 黄红毅护师就“老年人养生保健”相关知识问题，有奖问答，（讲座期间，学生义工带动老年人积极参与竞答和现场派发礼品）；
     * 3、流程四：3：55-4：00
     * （1）护师义诊及解答问题
     * 5、流程五：4：00-4：10
     * （1）学生义工组织老人参加“养生知识抛圈圈游戏”（游戏规则：选择三名观众，每人三个圈，抛中三个健康瓶送洗洁精一瓶，抛中两个健康瓶送牙膏一支，抛中一个健康瓶送洗头水一支，抛不中健康瓶送抽纸一包）
     * 6、流程六：4：10-4：15 发放纪念品。
     * 五、人员分工
     * 白沙马腾社区工作人员组织老人参加讲座；
     * 学生义工表演节目，现场服务，组织老人参加游戏。
     * TeacherDescription : 黄红毅护师
     */

    @SerializedName("workId")
    public String id;
    @SerializedName("Title")
    public String title;
    @SerializedName("iBeginTimed")
    public String beginTime;
    @SerializedName("EndTime")
    public String endTime;
    @SerializedName("Address")
    public String address;
    @SerializedName("Teacher")
    public String teacher;
    @SerializedName("ImageURL")
    public String imageURL;
    @SerializedName("Description")
    public String description;
    @SerializedName("TeacherDescription")
    public String teacherDescription;

    @SerializedName("ItemCollectionInfoId")
    public String collectionId;
    @SerializedName("ItemFavorites")
    public String collectioned;
}
