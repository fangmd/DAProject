package com.nerc.baselibrary.model;

/**
 * Created by nerc on 2017/6/29.
 */

public class FilePostResponse {


    /**
     * StatusCode : 0
     * StatusMsg : Success
     * Body : {"fileName":"E:\\Workspace\\020.code\\WZ_MOOC\\trunk\\src\\api\\MyMoocAPI\\FanZaiLearning\\UploadFile\\Avatar\\2.png"}
     */

    public int StatusCode;
    public String StatusMsg;
    public BodyBean Body;

    public static class BodyBean {
        /**
         * fileName : E:\Workspace\020.code\WZ_MOOC\trunk\src\api\MyMoocAPI\FanZaiLearning\UploadFile\Avatar\2.png
         */

        public String fileName;
    }
}
