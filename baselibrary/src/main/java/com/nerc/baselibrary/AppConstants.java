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


//        public static final String BASE_URL_RELEASE = "http://10.191.196.69:8011/"; // local
//        public static final String WEB_URL = "http://202.205.161.103:8040/";
//        public static final String API_FILE_RUL_RELEASE = "http://10.191.196.69:8011/";


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
        public static final String LOGIN_NAME = "login_name";
        public static final String PHOTO_URL = "photo_url";
        public static final String EMAIL = "email";
        public static final String USER_TRUE_NAME = "user_true_name";
        public static final String USER_SOURCE = "user_source";


        public static final String COURSE_TYPE = "course_type";
        public static final String COURSE_CATEGORY = "course_category";


        public static final String LEARN_STATUS = "learn_status";
        public static final String NEWS_TYPE = "news_type";
        public static final String SURVEY_ID = "survey_id";
        public static final String COURSE_ID = "course_id";
        public static final String IMG_URL = "img_url";
        public static final String COURSE_NAME = "course_name";
        public static final String VIDEO_URL = "video_url";
        public static final String VIDEO_NAME = "video_name";
        public static final String RESOURCE_ID = "resource_id";
        public static final String OLD_MODE = "old_mode";
        public static final String COMPETITION_ID = "compeition_id";
        public static final String TYPE = "type";
        public static final String ID = "workId";
        public static final String TIME = "time";
        public static final String TITLE = "title";
        public static final String DESCRIBE = "describe";
        public static final String HOME_ITEM_ORDER = "home_item_order";
        public static final String NEWS_ID = "news_id";
        public static final String COMPETITION_NAME = "competition_name";
        public static final String ACCOUNT_ITEM_TYPE = "account_item_type";
        public static final String PRIVACY_STATE = "privacy_state";
        public static final String CIRCLE_ID = "circle_id";
        public static final String CREATE = "create";
        public static final String INTRODUCTION = "introduction";
        public static final String ALL_CIRCLE_DEFAULT_TYPE = "all_circle_default_type";
        public static final String REPLY_TYPE = "reply_type";
        public static final String TOPIC_ID = "topic_id";
        public static final String PID = "pid";
        public static final String ARCHIVES_TYPE = "archives_type";
        public static final String TOPIC_MODEL = "topic_model";
        public static final String WORK_CNT = "work_id";
        public static final String VOTE_CNT = "vote_id";
        public static final String INTEGRAL = "integral";
        public static final String MANAGER = "manager";
        public static final String IS_DISCOVERY = "is_discovery";
    }

    public class Tag {

        public static final String DB = "db";
        public static final String FILE = "file";
        public static final String UMENG = "umeng";
        public static final String DOWNLOAD = "Download";
    }

    /**
     * 调用 getCourses 接口的时候会使用到：STUDYING，STUDIED
     * {@link com.nerc.baselibrary.network.ApiManager}
     */
    public static class LearnStatus {
        // 0：未开始的课程；1：学习中的课程；2：已学完的课程
        public static final int UNSTARTED = 0;
        public static final int STUDYING = 1;
        public static final int STUDIED = 2;

        // 我的收藏 课程 活动
        public static final int COLLECTIONs_COURSE = 3;
        public static final int COLLECTIONS_ACTIVITY = 4;
    }


    /**
     * 问卷调查 题目 类型
     */
    public static class QuestionType {
        // 1为单选题  2为多选题
        public static final int SINGLE_CHOICE = 1;
        public static final int MULTIPLE_CHOICE = 2;
        public static final int SHORT_ANSWER = 3;
    }

    /**
     * 讲堂列表获取 类型定义
     */
    public static class SpeakingHallType {

        //type：全部:all、预告:unstart、已结束:over

        public static final String ALL = "all";
        public static final String UNSTART = "unstart";
        public static final String OVER = "over";
        public static final String STARTED = "over";
    }

    /**
     * 培训项目 列表获取，培训状态
     */
    public static class TrainState {
        //    Classdatetype ： 0全部；1进行中；2已结束（状态） ALL default
        public static final int ALL = 0;
        public static final int STARTED = 1;
        public static final int OVER = 2;
    }

    /**
     * 培训项目 列表获取 培训类型
     */
    public static class TrainType {
        //    ProjectType：线上1、线下2 ALL default
        public static final int ALL = 0;
        public static final int ONLINE = 1;
        public static final int OFFLINE = 2;
    }

    /**
     * 4 中情况：已结束，已报名，报名审核中，立刻报名（只有 立刻报名 状态下按钮可以点击）
     * {@link com.nerc.baselibrary.model.TrainDetailModel}
     */
    public static class TrainDetailState {
        public static final String OVER = "已结束";
        public static final String REGISTERED = "已报名";
        public static final String UNDER_REVIEW = "报名审核中";
        public static final String SIGN_UP = "立刻报名";
    }

    /**
     * {@link com.nerc.baselibrary.network.api.BaseApi#getLearnNewss(int, int)}
     * 调用 getLearnNewss 接口的时候使用
     */
    public static class NewsType {
        // 32：活动公告； 33：社教资讯
        public static final int ACTIVITY_NOTI = 32;
        public static final int LEARN_NEWS = 33;
    }

    /**
     * 用于首页项目 排序
     */
    public static class HomeItemOrder {
        public static final int COURSE = 0;
        public static final int OLD_COURSE = 1;
        public static final int LIVE = 2;
        public static final int COMPETITION = 3;
        public static final int SURVEY = 4;
        public static final int COMMUNITY_EDU = 5;
        public static final int RANKING = 6;
        public static final int MORE = 7;
    }

    public class Router {
        public static final String LOGIN = "/login/login";
        public static final String MAIN = "/app/main";
        public static final String MINE_FRAGMENT = "/mine/minefragment";
    }

    /**
     * 大赛作品排序方式
     * <p>
     * 圈子排序方式
     * <p>
     * 主题活动排序方式
     */
    public static class NHOrderType {
        public static final String NEWEST = "0";
        public static final String HOTTEST = "1";
    }

    /**
     * 大赛作品投票排序方式
     */
    public static class CompetitionVoteResultOrderType {
        /**
         * 日得票数
         */
        public static final int DAY = 0;
        /**
         * 总得票数
         */
        public static final int SUM = 1;
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

    /**
     * 修改 账号隐私
     */
    public class AccountItemType {
        public static final int NAME = 1;
        public static final int SEX = 2;
        public static final int BIRTHDAY = 3;
        public static final int EMAIL = 4;
        public static final int PHONE = 5;
        public static final int NATIVE = 6;
    }

    /**
     * 账号隐私 设置 状态
     */
    public class AccountPrivacyState {
        public static final int ALL = 0;
        public static final int ONLYSELF = 1;
    }


    /**
     * 问卷调查 题目 类型
     */
    public static class ExamQuestionType {
        // 1为单选题  2为多选题 6 判断题
        public static final String SINGLE_CHOICE = "1";
        public static final String MULTIPLE_CHOICE = "2";
        public static final String SHORT_ANSWER = "3";
        public static final String JUDGMENT = "6";
    }

    /**
     * 我的 档案， 课程学习 列表 类型
     */
    public static class ArchivesType {
        public static final int PASS = 1;
        public static final int UNPASS = 2;

        public static final int TRAIN = 3;
        public static final int COURSE_LEARN = 4;
    }

    /**
     * 1: 新闻
     * 2：课程
     * 3：活动
     */
    public static class BannerType {
        public static final String NEWS = "1";
        public static final String COURSE = "2";
        public static final String ACTIVITY = "3";
    }

    /**
     * 0: 头像
     * 1：作业
     * 3：
     */
    public static class FileUploadType {
        public static final int AVATAR = 0;
        public static final int HOMEWORK = 1;
        public static final int OTHER = 3;
    }

    /**
     * 1表示当前用户已经加入该圈子并审核通过；
     * 0表示当前用户已申请加入圈子，等待审核中…；
     * NULL表示当前用户未加入圈子（加入按钮可根据该字段判断该进行何种操作）
     */
    public static class CircleUserState {
        public static final String REVIEWING = "0";
        public static final String JOINED = "1";
        public static final String NULL = "";

    }

    public static class CircleCreateMode {
        public static final int CREATE = 0;
    }

    /**
     * 圈子搜索 类型
     * <p>
     * 首页-》 活动搜索 课程搜索
     */
    public static class SearchType {
        public static final int TOPIC = 1;
        public static final int CIRCLE = 2;

        public static final int ACTIVITY = 3;
        public static final int COURSE = 4;
    }

    public static class ReplyType {

        /**
         * 话题回复
         */
        public static final int TOPIC = 0;

    }

    /**
     * 我的收藏，收藏类型
     */
    public static class CollectionType {

        public static final String COURSE = "0";

        public static final String ACTIVITIES = "-1";

        // 收藏活动 活动分类
        public static final String THEME_ACTIVITY = "1";
        public static final String COMPETITION_WORK = "2";
        public static final String TRAIN = "3";
        public static final String HALL = "4";

    }

    /**
     * 我的活动-主题活动, 大赛
     */
    public static class ActivityType {
        public static final String ALL = "0";
        public static final String UNSTARTED = "1";
        public static final String STARTED = "2";
        public static final String OVER = "3";
    }

    /**
     * 我的活动-培训
     */
    public static class MyActivityUserState {
        public static final String ALL = "-1";
        public static final String UNREVIEW = "0";
        public static final String PASSED = "1";
        public static final String UNPASSED = "2";
    }

    public static class IntegralModel {

        /**
         * creditStyle : Plus 增加 cut：减少
         */
        public static final String PLUS = "1";
        public static final String CUT = "2";


        /**
         * Style：0为主动获取 1为被动(等级提升)
         */
        public static final String INITIATIVE = "0";
        public static final String PASSIVE = "1";

    }

}
