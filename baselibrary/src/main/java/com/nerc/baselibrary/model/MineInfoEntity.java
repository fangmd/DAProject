package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * MineInfoEntity
 * Created by nercdevAndroid on 2017/3/24.
 */

public class MineInfoEntity {

    /**
     * workId : 445
     * userName : student
     * trueName : 小李学机
     * sex : 男
     * schoolName : 正街
     * mobile : 15366655552
     * email :
     * UserImage : http://202.205.161.103:8035/jquery_upload_New/uploadAvatar/upload/472d895d-17de-46dd-9965-8c8dd19bd6fd.jpg
     * BirthDate : 1991-08-05T00:00:00
     * Nation : null
     * EducationLevel : null
     * specialty :
     * Phone :
     * email1 :
     *
     * CreditAll: 0,
        CreditReal: 0,
        UserGrade: 0
     */

    @SerializedName("workId")
    public String id;
    @SerializedName("userName")
    public String userName;
    @SerializedName("trueName")
    public String trueName;
    @SerializedName("sex")
    public String sex;
    @SerializedName("schoolName")
    public String schoolName;
    @SerializedName("mobile")
    public String mobile;
    @SerializedName("email")
    public String email;
    @SerializedName("UserImage")
    public String img;
    @SerializedName("BirthDate")
    public String birthDate;
    @SerializedName("Nation")
    public String nation;
    @SerializedName("EducationLevel")
    public String educationLevel;
    @SerializedName("specialty")
    public String specialty;
    @SerializedName("Phone")
    public String phone;
    @SerializedName("email1")
    public String email1;
    @SerializedName("CreditAll")
    public String creditAll;
    @SerializedName("CreditReal")
    public String creditReal;
    @SerializedName("UserGrade")
    public String userGrade;
}
