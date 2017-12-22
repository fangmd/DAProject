package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;
import com.nerc.baselibrary.db.AppDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.Date;

/**
 * ResourceModel
 * Created by nerc on 2017/8/9.
 */
@Table(database = AppDatabase.class)
public class ResourceModel extends BaseModel{

    /**
     * resID : 3246
     * resname : 青少年课程
     * categoryId : 2385
     * itemurl : http://202.205.161.103:8035/UploadFile/3560be4b-23b8-48be-a1ad-9abc9fd89f89.mp4
     */

    @Column
    @PrimaryKey
    @SerializedName("resID")
    public String id;
    @Column
    @SerializedName("resname")
    public String name;
    @Column
    @SerializedName("categoryId")
    public String categoryId;
    @Column
    @SerializedName("itemurl")
    public String resUrl;


    // 记录资源所在的章节
    public String zhangId;
    // 记录资源所在的课程
    public String courseId;

    // 记录 时间用于 排序
    @Column
    public Date updateAt = new Date();


    // 是否是最近学习的
    public boolean isRecent;


}
