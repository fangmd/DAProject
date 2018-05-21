package com.nerc.baselibrary;

import static com.nerc.baselibrary.BuildConfig.API_DEBUG;

/**
 * Created by nerc on 2017/8/8.
 */

public class AppConstants {

    public static final String WEIXIN_APP_ID = "";

    public static class Api {
        public static final int ACCESS_KEY = 1;
        public static final int SECRET_KEY = 1;

        // 演示版本
        public static final String BASE_URL_RELEASE = "http://202.205.161.103:8044/";
        public static final String WEB_URL = "http://202.205.161.103:8040/";
        public static final String API_FILE_RUL_RELEASE = "http://202.205.161.103:8044/";


        // 测试服务器地址
        public static final String BASE_URL_DEBUG = "http://202.205.161.103:8025/";
        public static final String API_FILE_RUL_DEBUG = "http://202.205.161.103:9188/";


        public static String getApi() {
            if (API_DEBUG) {
                return BASE_URL_DEBUG;
            } else {
                return BASE_URL_RELEASE;
            }
        }

        public static String getFileApi() {
            if (API_DEBUG) {
                return API_FILE_RUL_DEBUG;
            } else {
                return API_FILE_RUL_RELEASE;
            }
        }
    }


    public class Key {
        public static final String USER_ID = "user_id";
    }

    public class Tag {

        public static final String DB = "db";
        public static final String FILE = "file";
        public static final String UMENG = "umeng";
        public static final String DOWNLOAD = "Download";
    }
    
    public class FilePath {

        // DownloadManager.Request 使用
        public static final String RES_DOWNLOAD_PATH = "communityEduPro/file";


        public static final String CACHE_PATH = "/.CommunityEduPro";

        public static final String RECORD_PATH = "/.CommunityEduPro/record";

        public static final String COURSE_RESOURCE_PATH = "/CommunityEduPro";
        public static final String EXAM_PATH = "/CommunityEduPro/exam";
        public static final String IMG_PATH = "/CommunityEduPro/img";
    }

    public class RequestCode {

        public static final int TAKE_PHOTO = 100;
        public static final int PICK_PHOTO = 200;
        public static final int PICK_FILE = 300;
    }


}
