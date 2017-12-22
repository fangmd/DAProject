package com.nerc.baselibrary.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * TopicModel
 * Created by nerc on 2017/10/9.
 */

public class TopicModel implements Parcelable {



    /**
     * RowIndex : 1
     * Id : 2
     * CreateUserId : 218
     * userName : admin
     * trueName : 管理员
     * UserImage : http://202.205.161.103:8035/UploadFile/images/unknown.jpg
     * Title : 生活
     * Describtion : <p>有兴趣的同学一起来学习发的所发生的放松的发斯蒂芬斯蒂芬</p>
     * CreateDate : 2015-05-29T09:49:23
     * GroupTitle : 动态图片制作
     * agreeCount : 0
     * AnswerCount : 2
     * Imgurl : http://202.205.161.103:8035/UploadFile/c1961367-dbd0-4b58-a96f-4491b1e3f1d3.jpg
     * CreateTime : 2015-05-29 09:49
     *
     * IsTopicPraise: "1",
     TopicPraiseId: "2"

     GroupId
     */

    @SerializedName("RowIndex")
    public int index;
    @SerializedName("Id")
    public String id;
    @SerializedName("CreateUserId")
    public String createUserId;
    @SerializedName("userName")
    public String userName;
    @SerializedName("trueName")
    public String trueName;
    @SerializedName("UserImage")
    public String userImg;
    @SerializedName("Title")
    public String title;
    @SerializedName("Describtion")
    public String describtion;
    @SerializedName("CreateDate")
    public String createDate;
    @SerializedName("GroupTitle")
    public String groupTitle;
    @SerializedName("agreeCount")
    public int agreeCount;
    @SerializedName("AnswerCount")
    public int answerCount;
    @SerializedName("Imgurl")
    public String imgUrl;
    @SerializedName("CreateTime")
    public String createTime;
    @SerializedName("IsTopicPraise")
    public String likeed;
    @SerializedName("TopicPraiseId")
    public String likeId;

    @SerializedName("GroupId")
    public String circleId;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.index);
        dest.writeString(this.id);
        dest.writeString(this.createUserId);
        dest.writeString(this.userName);
        dest.writeString(this.trueName);
        dest.writeString(this.userImg);
        dest.writeString(this.title);
        dest.writeString(this.describtion);
        dest.writeString(this.createDate);
        dest.writeString(this.groupTitle);
        dest.writeInt(this.agreeCount);
        dest.writeInt(this.answerCount);
        dest.writeString(this.imgUrl);
        dest.writeString(this.createTime);
        dest.writeString(this.likeed);
        dest.writeString(this.likeId);
        dest.writeString(this.circleId);
    }

    public TopicModel() {
    }

    protected TopicModel(Parcel in) {
        this.index = in.readInt();
        this.id = in.readString();
        this.createUserId = in.readString();
        this.userName = in.readString();
        this.trueName = in.readString();
        this.userImg = in.readString();
        this.title = in.readString();
        this.describtion = in.readString();
        this.createDate = in.readString();
        this.groupTitle = in.readString();
        this.agreeCount = in.readInt();
        this.answerCount = in.readInt();
        this.imgUrl = in.readString();
        this.createTime = in.readString();
        this.likeed = in.readString();
        this.likeId = in.readString();
        this.circleId = in.readString();
    }

    public static final Creator<TopicModel> CREATOR = new Creator<TopicModel>() {
        @Override
        public TopicModel createFromParcel(Parcel source) {
            return new TopicModel(source);
        }

        @Override
        public TopicModel[] newArray(int size) {
            return new TopicModel[size];
        }
    };
}
