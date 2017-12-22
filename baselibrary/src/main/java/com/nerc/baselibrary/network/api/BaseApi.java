package com.nerc.baselibrary.network.api;


import com.nerc.baselibrary.AppConstants;
import com.nerc.baselibrary.model.ActivityMemberModel;
import com.nerc.baselibrary.model.ActivityModel;
import com.nerc.baselibrary.model.ArchiveModel;
import com.nerc.baselibrary.model.ArchivesCourseListModel;
import com.nerc.baselibrary.model.BannerModel;
import com.nerc.baselibrary.model.BaseResponse;
import com.nerc.baselibrary.model.CircleDetailModel;
import com.nerc.baselibrary.model.CircleMemberModel;
import com.nerc.baselibrary.model.CircleModel;
import com.nerc.baselibrary.model.CircleSearchResultModel;
import com.nerc.baselibrary.model.CircleTotalCntModel;
import com.nerc.baselibrary.model.CollectionModel;
import com.nerc.baselibrary.model.CommunityEduDetailModel;
import com.nerc.baselibrary.model.CommunityEduNetModel;
import com.nerc.baselibrary.model.CompetitionDetailModel;
import com.nerc.baselibrary.model.CompetitionModel;
import com.nerc.baselibrary.model.CompetitionVoteResultModel;
import com.nerc.baselibrary.model.CompetitionWorkCnt;
import com.nerc.baselibrary.model.CompetitionWorkDetailModel;
import com.nerc.baselibrary.model.CompetitionWorkModel;
import com.nerc.baselibrary.model.CompetitionWorkTypeModel;
import com.nerc.baselibrary.model.CountModel;
import com.nerc.baselibrary.model.CourseDetailModel;
import com.nerc.baselibrary.model.CourseModel;
import com.nerc.baselibrary.model.CourseNotiModel;
import com.nerc.baselibrary.model.CourseRankModel;
import com.nerc.baselibrary.model.CourseTypeModel;
import com.nerc.baselibrary.model.ExamQuestionModel;
import com.nerc.baselibrary.model.HallDetailModel;
import com.nerc.baselibrary.model.IntegralLevelModel;
import com.nerc.baselibrary.model.IntegralModel;
import com.nerc.baselibrary.model.IntegralRuleModel;
import com.nerc.baselibrary.model.LearnNewsModel;
import com.nerc.baselibrary.model.LearnStarModel;
import com.nerc.baselibrary.model.LoginModel;
import com.nerc.baselibrary.model.MineInfoEntity;
import com.nerc.baselibrary.model.MineModel;
import com.nerc.baselibrary.model.MsgTypeResponse;
import com.nerc.baselibrary.model.MyActivityCntModel;
import com.nerc.baselibrary.model.MyCompetitionModel;
import com.nerc.baselibrary.model.MyQuestionnaireModel;
import com.nerc.baselibrary.model.MyTrainModel;
import com.nerc.baselibrary.model.NewsDetailModel;
import com.nerc.baselibrary.model.QuestionnaireModel;
import com.nerc.baselibrary.model.RecommendActivityModel;
import com.nerc.baselibrary.model.SpeakingHallDetailModel;
import com.nerc.baselibrary.model.SpeakingHallModel;
import com.nerc.baselibrary.model.StudyStatisticsModel;
import com.nerc.baselibrary.model.SurveyModel;
import com.nerc.baselibrary.model.TeacherModel;
import com.nerc.baselibrary.model.TestDetailModel;
import com.nerc.baselibrary.model.TestStatisticsModel;
import com.nerc.baselibrary.model.ThemeActivityModel;
import com.nerc.baselibrary.model.TopicImageModel;
import com.nerc.baselibrary.model.TopicModel;
import com.nerc.baselibrary.model.TopicReplyModel;
import com.nerc.baselibrary.model.TrainDetailCourseModel;
import com.nerc.baselibrary.model.TrainDetailModel;
import com.nerc.baselibrary.model.TrainModel;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Api
 * Created by nercdevAndroid on 2017/3/13.
 */

public interface BaseApi {

    /***
     * 登入
     * @param name 用户名
     * @param password 密码
     * @return LoginModel
     */
    @GET("api/M_User/Login?accessKey=1&secretKey=1")
    Observable<LoginModel> login(@Query("username") String name,
                                 @Query("password") String password);


    /**
     * 首页 banner
     */
    @GET("api/M_Professional/GetRecommendedXwdtPageImg?accessKey=1&secretKey=1")
    Observable<List<BannerModel>> getBanner();


    /**
     * 获取课程列表
     *
     * @param userId      用户id
     * @param learnStatus 课程的类型 {@link com.nerc.communityedu.AppConstants.LearnStatus}
     * @return 课程列表
     */
    @GET("api/M_Learn/CourseListByStatusNew?accessKey=1&secretKey=1")
    Observable<List<CourseModel>> getCourses(@Query("uid") String userId,
                                             @Query("learnStatus") int learnStatus);


//    /**
//     * 获取最新课程
//     *
//     * @param pageIndex 页码 从 1 开始
//     * @return List<NewCourseModel>
//     */
//    @GET("api/M_Course/NewestCourse?accessKey=1&secretKey=1&pageSize=20")
//    Observable<List<NewCourseModel>> getNewCourses(@Query("pageIndex") int pageIndex);
//


    /**
     * 基础版本获取 社教咨询，活动公告
     * 专业版本：获取 资讯公告
     *
     * @param newsCategoryId 32：活动公告； 33：社教资讯 {@link com.nerc.baselibrary.AppConstants.NewsType}
     * @param pageIndex      页码 从 1 开始
     * @return List<LearnNewsModel>
     */
    @GET("api/M_Org/GetNewsPostList?pageSize=20&accessKey=1&secretKey=1")
    Observable<List<LearnNewsModel>> getLearnNewss(@Query("newsCategoryId") int newsCategoryId,
                                                   @Query("pageIndex") int pageIndex);

    @GET("api/M_Org/GetNewsPostOne/{workId}?accessKey=1&secretKey=1")
    Observable<List<NewsDetailModel>> getNewsDetail(@Path("workId") String id);


    /**
     * 获取 学习之星 列表
     */
    @GET("api/M_Org/GetLearningStar?accessKey=1&secretKey=1")
    Observable<List<LearnStarModel>> getLearnStar();

    /**
     * 获取问卷调查
     *
     * @param userId    用户 workId
     * @param pageIndex 页码 从 1 开始
     * @return List<QuestionnaireModel>
     */
    @GET("api/M_Org/GetSurveyList?pageSize=30&accessKey=1&secretKey=1")
    Observable<List<QuestionnaireModel>> getQuestionnaires(@Query("userId") String userId,
                                                           @Query("pageIndex") int pageIndex);


    /**
     * 获取 问卷调查 基本信息
     *
     * @param id 问卷 workId
     * @return SurveyModel
     */
    @GET("api/M_Org/GetSurveyOne/{workId}?accessKey=1&secretKey=1")
    Observable<List<SurveyModel>> getSurvey(@Path("workId") String id);


    /**
     * 获取调查问卷的题目
     *
     * @param surveyId 问卷 workId
     * @return 题目
     */
    @GET("api/M_Org/GetSurveyNodelist?accessKey=1&secretKey=1")
    Observable<MsgTypeResponse> getSurveyDetail(@Query("surveyId") String surveyId);


    /**
     * 提交答案
     *
     * @param userId   用户 workId
     * @param surveyId 问卷 workId
     * @param answer   答案
     * @return BaseResponse
     */
    @POST("api/M_Org/CreateSurveyAnswer?accessKey=1&secretKey=1")
    Observable<BaseResponse> postAnswer(@Query("userId") String userId,
                                        @Query("SurveyId") String surveyId,
                                        @Query("surveyContent") String answer);


    /**
     * 调查问卷 的结果
     *
     * @param surveyId 问卷 workId
     * @return MsgTypeResponse
     */
    @GET("api/M_Org/GetSurveyResult?accessKey=1&secretKey=1")
    Observable<MsgTypeResponse> getSurveyResult(@Query("surveyId") String surveyId);

//
//    /**
//     * 课程 分类
//     *
//     * @param pageIndex 页码
//     * @return 课程 分类
//     */
//    @GET("api/M_Course/GetCourseTypeCourse?accessKey=1&secretKey=1&pageSize=20")
//    Observable<MsgTypeResponse> getCourseCategory(@Query("pageIndex") int pageIndex);
//

    /**
     * 课程详情页
     *
     * @param courseId 课程 workId
     * @return 课程详情
     */
    @GET("api/M_Course/CourseBaseInfo?accessKey=1&secretKey=1")
    Observable<CourseDetailModel> getCourseDetail(
            @Query("userId") String userId,
            @Query("courseId") String courseId);

    /**
     * 课程详情页 获取教师列表
     *
     * @param courseId 课程 workId
     * @return 教师列表
     */
    @GET("api/M_Course/GetCourseTeacher?accessKey=1&secretKey=1")
    Observable<List<TeacherModel>> getTeachers(@Query("courseId") String courseId);


    /**
     * 课程详情页 评分提交
     */
    @GET("/api/M_Course/MarkForCourse?accessKey=1&secretKey=1&pageSize=15")
    Observable<BaseResponse> postScore(@Query("courseId") String courseId,
                                       @Query("uid") String uid,
                                       @Query("score") int score);

    /**
     * 课程详情页 加入课程
     *
     * @return 添加结果
     */
    @GET("api/M_Course/JoinCourse?accessKey=1&secretKey=1")
    Observable<BaseResponse> joinCourse(@Query("uid") String uid, @Query("courseId") String courseId,
                                        @Query("classId") String classId);

    /**
     * 课程列表
     *
     * @param categoryId 类别
     * @param pageIndex  页码
     * @return 课程列表
     */
    @GET("api/M_Course/CourseByType?accessKey=1&secretKey=1&pageSize=20")
    Observable<List<CourseModel>> getCourseByType(@Query("typeId") String categoryId,
                                                  @Query("pageIndex") int pageIndex);


    /**
     * 课程详情页 获取课程通知公告 数量
     *
     * @return 数量
     */
    @GET("api/M_Course/GetCourseNoticeCount?accessKey=1&secretKey=1")
    Observable<CountModel> getCourseNotiCnt(@Query("courseId") String courseId,
                                            @Query("courseClassId") String classId);

    /**
     * 课程通知列表获取
     *
     * @param courseId  课程 workId
     * @param classId   class workId
     * @param pageIndex 页码
     * @return 课程通知列表
     */
    @GET("api/M_Course/GetCourseNotices?accessKey=1&secretKey=1&pageSize=20")
    Observable<List<CourseNotiModel>> getCourseNotiModels(@Query("courseId") String courseId,
                                                          @Query("courseClassId") String classId,
                                                          @Query("pageIndex") int pageIndex);


    //    course learn

    /**
     * 获取课程资源列表 包括 作业 试卷
     *
     * @param userId   user workId
     * @param courseId course workId
     * @return result
     */
    @GET("api/M_Org/GetCourseSPZT?accessKey=1&secretKey=1")
    Observable<MsgTypeResponse> getCourseRes(@Query("userId") String userId,
                                             @Query("courseId") String courseId);


    //-- statistics

    /**
     * 课程统计 学习统计
     */
    @GET("api/M_Statistics/GetCourseClassStudyDetailList?accessKey=1&secretKey=1")
    Observable<List<StudyStatisticsModel>> getStudyStatistics(@Query("userId") String userId,
                                                              @Query("courseClassId") String classId,
                                                              @Query("courseId") String courseId);

    /**
     * 课程统计 练习统计
     */
    @GET("api/M_Statistics/GetCourseClassExamTestDetailList?accessKey=1&secretKey=1")
    Observable<List<TestStatisticsModel>> getTestStatistics(@Query("userId") String userId,
                                                            @Query("courseClassId") String classId,
                                                            @Query("courseId") String courseId);


    /**
     * modify password
     */
    @GET("api/M_User/ChangePwd?accessKey=1&secretKey=1")
    Observable<BaseResponse> modifyPwd(@Query("uid") String uid, @Query("oldPwd") String oldPwd,
                                       @Query("newPwd") String newPwd);


    /**
     * 获取试卷详细信息
     */
    @GET("api/M_Course/GetChapterTestInfo?accessKey=1&secretKey=1")
    Observable<List<TestDetailModel>> getExamDetail(@Query("userId") String userId,
                                                    @Query("courseClassId") String classId,
                                                    @Query("courseId") String courseId,
                                                    @Query("chapterId") String chapterId);

//    /**
//     * 我的 个人信息
//     *
//     * @param userId 学生 workId
//     * @return 个人信息
//     */
//    @GET("/api/M_User/GetUserInfoOne?accessKey=1&secretKey=1")
//    Observable<List<MineInfoEntity>> getMineInfo(@Query("userId") String userId);
//
//
//    /**
//     * 个人信息 修改 提交
//     * @param obj 提交 body 	{ userId:"学生ID", trueName:"真实姓名",gender:"性别男1，女0",mobile:"手机",BirthDate:"出生日期",Nation:"民族"}
//     * @return result
//     */
//    @POST("/api/M_User/UpdateUserInfo?accessKey=1&secretKey=1")
//    Observable<BaseResponse> postMineInfo(@Query("obj") String obj);
//
//    /**
//     * 获取 民族列表
//     */
//    @GET("/api/M_User/GetNationList?accessKey=1&secretKey=1")
//    Observable<List<NationEntity>> getNationList();
//

    /**
     * 个人消息 修改 头像
     */
    @POST("/api/M_User/UpdateUserImage?accessKey=1&secretKey=1")
    Observable<BaseResponse> editAvatar(@Query("obj") String obj);

//    /**
//     * 个人消息 修改 头像
//     */
//    @Multipart
//    @POST("/api/M_User/UpdateUserImage?accessKey=1&secretKey=1")
//    Observable<BaseResponse> editAvatar2(@Query("obj") String obj,
//                                         @Part MultipartBody.Part file,
//                                         @Part MultipartBody.Part allows);
//
//
//    /**
//     * 获取 精选课程 课程列表
//     * @param pageIndex index 从 1 开始
//     */
//    @GET("api/M_Course/RecommendCourse?accessKey=1&secretKey=1&pageSize=20")
//    Observable<List<NewCourseModel>> getChoiceCourses(@Query("pageIndex") int pageIndex);
//
//    /**
//     * 搜索
//     * @param searchStr 搜索内容
//     * @param pageIndex 从 1 开始
//     */
//    @GET("api/M_Course/Search?accessKey=1&secretKey=1&pageSize=20")
//    Observable<List<SearchCourseModel>> search(@Query("searchText") String searchStr,
//                                               @Query("pageIndex") int pageIndex);
//

    /**
     * 更新学生的成绩
     * <p>
     * 用于让平台更新学生的学分状态，返回的结果不用处理
     */
    @GET("api/M_Course/UpdateStudentScore?accessKey=1&secretKey=1")
    Observable<ResponseBody> updateStudentScore(@Query("userId") String userId,
                                                @Query("courseId") String courseId);


    /**
     * 上传视频学习时间
     *
     * @param userId        user workId
     * @param courseId      course workId
     * @param resourceId    resource workId
     * @param courseClassId class workId 默认传 0
     * @param learnTime     时间
     */
    @GET("api/M_Learn/UploadLearnProgress?accessKey=1&secretKey=1")
    Observable<BaseResponse> uploadVideoPlayTime(@Query("uid") String userId,
                                                 @Query("courseId") String courseId,
                                                 @Query("resourceId") String resourceId,
                                                 @Query("courseClassId") int courseClassId,
                                                 @Query("learnTime") int learnTime);

    /**
     * 获取 课程通知
     *
     * @param courseId      课程 workId
     * @param courseClassId 班级号 默认 0
     * @param pageIndex     页码
     */
    @GET("api/M_Course/GetCourseNotices?accessKey=1&secretKey=1&pageSize=30")
    Observable<List<CourseNotiModel>> getCourseNotifications(@Query("courseId") String courseId,
                                                             @Query("courseClassId") String courseClassId,
                                                             @Query("pageIndex") int pageIndex);


    /**
     * 获取 讲堂 列表
     *
     * @param type      {@link com.nerc.baselibrary.AppConstants.SpeakingHallType} 类型
     * @param pageIndex index
     * @param pageSize  30
     */
    @GET("api/M_Professional/GetBigLecture?accessKey=1&secretKey=1")
    Observable<List<SpeakingHallModel>> getSpeakingHalls(@Query("type") String type,
                                                         @Query("pageIndex") int pageIndex,
                                                         @Query("pageSize") int pageSize);

    /**
     * 获取 讲堂详情页
     *
     * @param id workId
     */
    @GET("/api/M_Professional/GetBigLectureOne?accessKey=1&secretKey=1")
    Observable<List<SpeakingHallDetailModel>> getSpeakingHallDetail(@Query("userId") String userId,
                                                                    @Query("Id") String id);

    /**
     * 获取 讲堂详情页 视频列表
     *
     * @param id workId
     */
    @GET("/api/M_Professional/GetBigLectureVideo?accessKey=1&secretKey=1")
    Observable<List<HallDetailModel>> getHallDetails(@Query("BigLectureId") String id);


    /**
     * 培训项目 列表获取
     *
     * @param state     {@link com.nerc.baselibrary.AppConstants.TrainState}
     * @param type      {@link com.nerc.baselibrary.AppConstants.TrainType}
     * @param pageIndex pageIndex
     */
    @GET("/api/M_Professional/GetProjectList?accessKey=1&secretKey=1&pageSize=30")
    Observable<List<TrainModel>> getTrains(@Query("classdatetype") int state,
                                           @Query("ProjectType") int type,
                                           @Query("pageIndex") int pageIndex);

    /**
     * 培训项目 项目详情
     *
     * @param id     workId
     * @param userId 用户 workId
     */
    @GET("/api/M_Professional/GetProjectOne?accessKey=1&secretKey=1")
    Observable<List<TrainDetailModel>> getTrainDetial(@Query("workId") String id,
                                                      @Query("userid") String userId);

    /**
     * 培训项目 课程列表
     *
     * @param id        workId
     * @param pageSize  设置成 Integer.MAX
     * @param pageIndex 1
     */
    @GET("/api/M_Professional/GetProjectCourse?accessKey=1&secretKey=1")
    Observable<List<TrainDetailCourseModel>> getTrainDetailCourse(@Query("workId") String id,
                                                                  @Query("pageSize") int pageSize,
                                                                  @Query("pageIndex") int pageIndex);

    /**
     * 首页 获取我的课程
     *
     * @param userId 用户 workId
     */
    @GET("/api/M_Professional/GetMyCourse4?accessKey=1&secretKey=1")
    Observable<List<CourseModel>> getHomeMyCourse(@Query("studentid") String userId);

    /**
     * coursetype=47&IsOldAgeCourse=0&
     * 最新课程 获取
     *
     * @param courseType     课程分类
     * @param IsOldAgeCourse 是否是老年 0普通课程；1老年课程
     */
    @GET("/api/M_Professional/GetCourseNew?pageSize=30&accessKey=1&secretKey=1")
    Observable<List<CourseModel>> getCoursesNew(@Query("coursetype") String courseType,
                                                @Query("IsOldAgeCourse") int IsOldAgeCourse,
                                                @Query("pageIndex") int pageIndex);

    @GET("/api/M_Professional/GetCourseNew?coursetype=&pageSize=30&accessKey=1&secretKey=1")
    Observable<List<CourseModel>> getCoursesNewAll(@Query("IsOldAgeCourse") int IsOldAgeCourse,
                                                   @Query("pageIndex") int pageIndex);

    /**
     * coursetype=47&IsOldAgeCourse=0&
     * 最热课程 获取
     *
     * @param courseType     课程分类
     * @param IsOldAgeCourse 是否是老年 0普通课程；1老年课程
     */
    @GET("/api/M_Professional/GetCourseHot?pageSize=30&accessKey=1&secretKey=1")
    Observable<List<CourseModel>> getCoursesHot(@Query("coursetype") String courseType,
                                                @Query("IsOldAgeCourse") int IsOldAgeCourse,
                                                @Query("pageIndex") int pageIndex);

    @GET("/api/M_Professional/GetCourseHot?coursetype=&pageSize=30&accessKey=1&secretKey=1")
    Observable<List<CourseModel>> getCoursesHotAll(@Query("IsOldAgeCourse") int IsOldAgeCourse,
                                                   @Query("pageIndex") int pageIndex);

    /**
     * 获取课程分类
     */
    @GET("/api/M_Professional/GetCourseType?accessKey=1&secretKey=1")
    Observable<List<CourseTypeModel>> getCourseTypes();

    /**
     * 获取大赛列表
     *
     * @param pageIndex 页码
     */
    @GET("/api/M_Professional/GetActivityInfoList?accessKey=1&secretKey=1&pageSize=30")
    Observable<List<CompetitionModel>> getCompetitionModels(@Query("pageIndex") int pageIndex);

    /**
     * 大赛详情页
     *
     * @param id 大赛 workId
     */
    @GET("/api/M_Professional/GetActivityInfoOne?accessKey=1&secretKey=1")
    Observable<List<CompetitionDetailModel>> getCompetitionDetail(@Query("userId") String userId,
                                                                  @Query("id") String id);

    /**
     * 大赛 作品类别列表 获取
     *
     * @param competitionId 大赛id
     */
    @GET("/api/M_Professional/GetWorkType?accessKey=1&secretKey=1")
    Observable<List<CompetitionWorkTypeModel>> getCompetitionWorkTypeModels(@Query("ActivityId") String competitionId);

    /**
     * 大赛 作品
     *
     * @param competitionId 大赛 workId
     * @param workTypeId    作品类别， -1 表示全部
     */
    @GET("/api/M_Professional/GetWorkInfoByPageWithOrderByCount?accessKey=1&secretKey=1")
    Observable<List<CompetitionWorkCnt>> getCompetitionWorkCnt(@Query("ActivityId") String competitionId,
                                                               @Query("WorkTypeId") String workTypeId);

    /**
     * 大赛 作品列表 获取
     *
     * @param competitionId 大赛 workId
     * @param orderBy       排序方式 0：时间排序，1 投票数排序 {@link AppConstants.NHOrderType}
     * @param workTypeId    作品类别，全部 -1
     * @param pageIndex     页码
     */
    @GET("/api/M_Professional/GetWorkInfoByPageWithOrderBy?accessKey=1&secretKey=1&pageSize=30")
    Observable<List<CompetitionWorkModel>> getCompetitionWorkList(@Query("ActivityId") String competitionId,
                                                                  @Query("OrderBy") String orderBy,
                                                                  @Query("WorkTypeId") String workTypeId,
                                                                  @Query("pageIndex") int pageIndex);

    /**
     * 大赛 作品详情
     *
     * @param workId 作品 workId
     */
    @GET("/api/M_Professional/GetWorkInfoOne?accessKey=1&secretKey=1")
    Observable<List<CompetitionWorkDetailModel>> getCompetitionWorkDetail(
            @Query("userId") String userId,
            @Query("WorkInfoId") String workId);


    /**
     * 大赛 作品投票
     *
     * @param obj {@link com.nerc.baselibrary.model.VoteUploadModel}
     */
    @GET("/api/M_Professional/SetVote?accessKey=1&secretKey=1")
    Observable<BaseResponse> postVote(@Query("obj") String obj);


    /**
     * 大赛 投票结果 统计页面
     *
     * @param competitionId 大赛 workId
     * @param OrderBy       排序方式 {@link com.nerc.baselibrary.AppConstants.CompetitionVoteResultOrderType}
     * @param pageIndex
     * @return
     */
    @GET("/api/M_Professional/GetActivityResultTotal?accessKey=1&secretKey=1&pageSize=30")
    Observable<List<CompetitionVoteResultModel>> getVoteResult(@Query("ActivityId") String competitionId,
                                                               @Query("OrderBy") int OrderBy,
                                                               @Query("pageIndex") int pageIndex);

    /**
     * 课程 排行榜
     */
    @GET("/api/M_Professional/GetCourseRank?accessKey=1&secretKey=1")
    Observable<List<CourseRankModel>> getCourseRank();

    /**
     * 社教网络
     */
    @GET("/api/M_Professional/GetSchoolRank?topcount=10&accessKey=1&secretKey=1")
    Observable<List<CommunityEduNetModel>> getCommunityEduNet();

    /**
     * 社教网络 全部地区
     */
    @GET("/api/M_Professional/GetSchoolList?accessKey=1&secretKey=1")
    Observable<MsgTypeResponse> getCommunityEduNetAll();

    /**
     * 我的 个人信息
     *
     * @param userId 学生 workId
     * @return 个人信息
     */
    @GET("/api/M_User/GetUserInfoOne?accessKey=1&secretKey=1")
    Observable<List<MineInfoEntity>> getMineInfo(@Query("userId") String userId);

    //api/M_Course/SubmitPaper?userId=" + userId + "&courseClassId=" + "0"
//                + "&courseId=" + courseId + "&chapterId=" + chapterId + "&paperId=" + paperId


//    exam-----------

    /**
     * 提交试卷，结束答题
     *
     * @param userId        用户Id
     * @param courseClassId 班级Id
     * @param courseId      课程Id
     * @param chapterId     章节Id
     * @param paperId       试卷Id
     * @return
     */
    @GET("/api/M_Course/SubmitPaper?accessKey=1&secretKey=1")
    Observable<BaseResponse> submitPaperByPaperId(@Query("userId") String userId,
                                                  @Query("courseClassId") String courseClassId,
                                                  @Query("courseId") String courseId,
                                                  @Query("chapterId") String chapterId,
                                                  @Query("paperId") String paperId);

    /**
     * 获取试卷 问题包含用户回答
     */
    @GET("/api/M_Course/GetAnswerRecord2?accessKey=1&secretKey=1")
    Observable<List<ExamQuestionModel>> getExamWithAnswer(@Query("userId") String userId,
                                                          @Query("courseClassId") String classId,
                                                          @Query("courseId") String courseId,
                                                          @Query("chapterId") String chapterId,
                                                          @Query("paperId") String paperId);

    @GET("/api/M_Course/GetPaperShortAnswerQuestionsAnswerRecord?accessKey=1&secretKey=1")
    Observable<List<ExamQuestionModel>> getExamWithAnswerShortAnswer(@Query("userId") String userId,
                                                                     @Query("courseClassId") String classId,
                                                                     @Query("courseId") String courseId,
                                                                     @Query("chapterId") String chapterId,
                                                                     @Query("paperId") String paperId);


    /**
     * 获取试卷 问题
     *
     * @param paperId 试卷id
     * @return
     */
    @GET("/api/M_Course/GetPaperQuestions3?accessKey=1&secretKey=1")
    Observable<List<ExamQuestionModel>> getExamQuestion(@Query("paperId") String paperId);

    @GET("/api/M_Course/GetPaperShortAnswerQuestions?accessKey=1&secretKey=1")
    Observable<List<ExamQuestionModel>> getExamQuestionShortAnswer(@Query("paperId") String paperId);

    //api/M_Course/SubmitQuestionAnswer2?userId=" + userId + "&courseClassId="
//                + "0" + "&courseId=" + courseId + "&chapterId=" + chapterId + "&paperId=" + paperId + "&questionId="
//            + questionId + "&userAnswers=" + answerId + "&
    @GET("/api/M_Course/SubmitQuestionAnswer2?accessKey=1&secretKey=1")
    Observable<BaseResponse> uploadAnswer(@Query("userId") String userId,
                                          @Query("courseId") String courseId,
                                          @Query("courseClassId") String courseClassId,
                                          @Query("chapterId") String chapterId,
                                          @Query("paperId") String paperId,
                                          @Query("questionId") String questionId,
                                          @Query("userAnswers") String userAnswers);


    @GET("/api/M_Course/SubmitShortAnswerQuestionAnswer?")
    Observable<BaseResponse> uploadShortAnswer(@Query("userId") String userId,
                                               @Query("courseId") String courseId,
                                               @Query("courseClassId") String courseClassId,
                                               @Query("chapterId") String chapterId,
                                               @Query("paperId") String paperId,
                                               @Query("questionId") String questionId,
                                               @Query("userAnswers") String userAnswers);

    // ---- exam-----------


    /**
     * 热门圈子
     */
    @GET("/api/M_Professional/GetGrroupHot?accessKey=1&secretKey=1")
    Observable<List<CircleModel>> getCircleHot();

    /**
     * 我的圈子
     */
    @GET("/api/M_Professional/GetGroupByUserId?accessKey=1&secretKey=1&pageSize=30")
    Observable<List<CircleModel>> getMyCircle(@Query("userid") String userid,
                                              @Query("pageIndex") int pageIndex);

    /**
     * 所有圈子 列表
     *
     * @param orderBy   {@link AppConstants.NHOrderType}
     * @param pageIndex 页码
     */
    @GET("/api/M_Professional/GetGroupListByOrder?accessKey=1&secretKey=1&pageSize=30")
    Observable<List<CircleModel>> getAllCircle(@Query("OrderBy") String orderBy,
                                               @Query("pageIndex") int pageIndex);

    /**
     * 获取 圈子 总数
     */
    @GET("/api/M_Professional/GetGroupCount?accessKey=1&secretKey=1")
    Observable<CircleTotalCntModel> getCircleTotalCnt();

    /**
     * 创建圈子
     */
    @POST("/api/M_Professional/CreaterGroup?accessKey=1&secretKey=1")
    Observable<BaseResponse> createCircle(@Query("obj") String circleCreateModelJson);

    /**
     * 圈子详情
     */
    @GET("/api/M_Professional/GetGroupOne?accessKey=1&secretKey=1")
    Observable<List<CircleDetailModel>> getCircleDetailModel(@Query("userId") String userId,
                                                             @Query("Id") String circleId);


    /**
     * 圈子 成员列表
     */
    @GET("/api/M_Professional/GetGroupMemberList?accessKey=1&secretKey=1&pageSize=30")
    Observable<List<CircleMemberModel>> getCircleMembers(@Query("GroupId") String groupId,
                                                         @Query("pageIndex") int pageIndex);

    /**
     * 圈子 成员 获取所有
     *
     * @param groupId  圈子 workId
     * @param pageSize Integer.MAX_VALUE
     */
    @GET("/api/M_Professional/GetGroupMemberList?accessKey=1&secretKey=1&pageIndex=1")
    Observable<List<CircleMemberModel>> getCircleMemberAll(@Query("GroupId") String groupId,
                                                           @Query("pageSize") int pageSize);

    /**
     * 删除 圈子成员
     *
     * @param deleteMemberJson
     * @return
     */
    @GET("/api/M_Professional/DeleteGroupMemberAll?accessKey=1&secretKey=1")
    Observable<BaseResponse> deleteCircleMember(@Query("obj") String deleteMemberJson);

    /**
     * 加入圈子
     *
     * @param circleJoinModelJson 加入请求
     * @return {
     * "status": "1",1表示成功;0，表示失败
     * "message": "加入成功，待管理员审核！"  失败：“参数错误”；“已加入；”； “加入失败”
     * }
     */
    @GET("/api/M_Professional/JoinGroup?accessKey=1&secretKey=1")
    Observable<BaseResponse> joinCircle(@Query("obj") String circleJoinModelJson);

    /**
     * 退出圈子
     *
     * @param obj
     * @return
     */
    @GET("/api/M_Professional/DeleteGroupMember?accessKey=1&secretKey=1")
    Observable<BaseResponse> exitCircle(@Query("obj") String obj);

    /**
     * 编辑 圈子
     */
    @POST("/api/M_Professional/UpdateGroup?accessKey=1&secretKey=1")
    Observable<BaseResponse> editCircle(@Query("obj") String circleEditJson);

    /**
     * 话题列表
     */
    @GET("/api/M_Professional/GetTopicList?accessKey=1&secretKey=1&pageSize=30")
    Observable<List<TopicModel>> getTopicModel(@Query("pageIndex") int pageIndex);

    /**
     * 话题详情获取
     */
    @GET("/api/M_Professional/GetTopicOne?accessKey=1&secretKey=1")
    Observable<List<TopicModel>> getTopicDetail(@Query("userId") String userId,
                                                @Query("TopicId") String topicId);

    /**
     * 话题详情页 图片获取
     */
    @GET("/api/M_Professional/GetTopicImgUrl?accessKey=1&secretKey=1")
    Observable<List<TopicImageModel>> getTopicDetailImgs(@Query("TopicId") String topicId);

    /**
     * 话题详情页 图片获取
     */
    @GET("/api/M_Professional/GetPostAnswerList?accessKey=1&secretKey=1&pageSize=30")
    Observable<List<TopicReplyModel>> getTopicDetailReplys(@Query("TopicId") String topicId,
                                                           @Query("pageIndex") int pageIndex);

    /**
     * 话题详情页 回复话题
     */
    @POST("/api/M_Professional/CreaterPostAnswer?accessKey=1&secretKey=1")
    Observable<BaseResponse> replyTopic(@Query("obj") String topicReplyJson);

    /**
     * 话题 点赞
     *
     * @param topicLikeJson {@link com.nerc.baselibrary.model.TopicLikeModel}
     */
    @GET("/api/M_Professional/JoinTopicPraise?accessKey=1&secretKey=1")
    Observable<BaseResponse> likeTopic(@Query("obj") String topicLikeJson);

    /**
     * 话题 取消点赞
     *
     * @param topicLikeJson 。。
     */
    @GET("/api/M_Professional/DeleteTopicPraise?accessKey=1&secretKey=1")
    Observable<BaseResponse> unlikeTopic(@Query("obj") String topicLikeJson);

    /**
     * 创建 话题
     *
     * @param topicJson {@link com.nerc.baselibrary.model.TopicCreateModel}
     */
    @POST("/api/M_Professional/CreaterTopic?&accessKey=1&secretKey=1")
    Observable<BaseResponse> createTopic(@Query("obj") String topicJson);


    /**
     * 圈子搜索 圈子结果
     */
    @GET("/api/M_Professional/GetSeachGroup?accessKey=1&secretKey=1&pageSize=15")
    Observable<List<CircleSearchResultModel>> searchCircle(@Query("keyword") String keyword,
                                                           @Query("pageIndex") int pageIndex);

    /**
     * 圈子搜索 话题结果
     */
    @GET("api/M_Professional/GetSeachTopicList?accessKey=1&secretKey=1&pageSize=15")
    Observable<List<CircleSearchResultModel>> searchCircleTopic(@Query("keyword") String keyword,
                                                                @Query("pageIndex") int pageIndex);


    /**
     * 我的界面
     */
    @GET("/api/M_Professional/GetMyMessage?accessKey=1&secretKey=1")
    Observable<List<MineModel>> getMineModel(@Query("userid") String userId);

    /**
     * 社区 教育档案 课程学习
     */
    @GET("/api/M_Professional/GetMyLeanAll?accessKey=1&secretKey=1")
    Observable<List<ArchiveModel>> getArchiveModel(@Query("userid") String userId);

    /**
     * 社区 教育档案 课程学习 课程列表
     */
    @GET("/api/M_Professional/GetCourseListByYear?accessKey=1&secretKey=1")
    Observable<List<ArchivesCourseListModel>> getArchiveCourseListModel(@Query("userid") String userId,
                                                                        @Query("Year") String year);


    /**
     * 我的收藏 课程
     *
     * @param userId         用户 workId
     * @param CollectionType 收藏类型
     * @param pageIndex      index
     */
    @GET("/api/M_Statistics/GetCollectionInfoList?accessKey=1&secretKey=1&pageSize=30")
    Observable<List<CourseModel>> getCollections(@Query("userId") String userId,
                                                 @Query("CollectionType") String CollectionType,
                                                 @Query("pageIndex") int pageIndex);

    /**
     * 我的收藏 活动
     *
     * @param userId         user workId
     * @param CollectionType {@link AppConstants.CollectionType}
     * @param pageIndex      page index
     */
    @GET("/api/M_Professional/GetCollectionInfoList?accessKey=1&secretKey=1&pageSize=30")
    Observable<List<CollectionModel>> getActivityCollections(@Query("userId") String userId,
                                                             @Query("CollectionType") String CollectionType,
                                                             @Query("pageIndex") int pageIndex);

    /**
     * 收藏课程
     *
     * @param userId   用户 workId
     * @param courseId 课程 workId
     */
    @GET("/api/M_Course/CollectingCourse?accessKey=1&secretKey=1")
    Observable<BaseResponse> collectionCourse(@Query("uid") String userId,
                                              @Query("courseId") String courseId);

    @GET("/api/M_Statistics/DeleteCollectionInfo?accessKey=1&secretKey=1")
    Observable<BaseResponse> deleteCollection(@Query("collectionInfoId") String collectionInfoId);

    /**
     * 首页 我的活动
     */
    @GET("/api/M_Professional/GetMyIndexActive5?accessKey=1&secretKey=1")
    Observable<List<ActivityModel>> getMyActivity5(@Query("studentid") String userId);

    /**
     * 主题活动 列表
     *
     * @param type      类型
     * @param orderBy   排序方式 {@link AppConstants.NHOrderType}
     * @param pageIndex
     * @return
     */
    @GET("/api/M_Professional/GetThemeActivelist?accessKey=1&secretKey=1&pageSize=30")
    Observable<List<ThemeActivityModel>> getThemeActivity(@Query("datetype") String type,
                                                          @Query("strorderby") String orderBy,
                                                          @Query("pageIndex") int pageIndex);

    /**
     * 主题活动 详情页
     */
    @GET("/api/M_Professional/GetThemeActiveOneByUserId?accessKey=1&secretKey=1")
    Observable<List<ThemeActivityModel>> getThemeActivityDetail(@Query("Id") String activityId,
                                                                @Query("userId") String userId);

    /**
     * 活动报名
     */
    @GET("/api/M_Professional/JoinThemeActiveApply?accessKey=1&secretKey=1")
    Observable<BaseResponse> signUpActivity(@Query("obj") String obj);

    /**
     * 活动中伙伴
     */
    @GET("/api/M_Professional/GetThemeActiveApplyByAId?accessKey=1&secretKey=1&pageSize=30")
    Observable<List<ActivityMemberModel>> getActivityMember(@Query("Id") String activityId,
                                                            @Query("pageIndex") int pageIndex);

    /**
     * 相似活动
     */
    @GET("/api/M_Professional/GetThemeActiveByAId?accessKey=1&secretKey=1")
    Observable<List<ThemeActivityModel>> getRelativeAct(@Query("Id") String activityId);

    /**
     * 我的活动-主题活动 列表
     *
     * @param userId    user workId
     * @param dateType  {@link AppConstants.ActivityType}
     * @param pageIndex 页码
     * @return Activities
     */
    @GET("/api/M_Professional/GetThemeActiveByUserId?accessKey=1&secretKey=1&pageSize=30")
    Observable<List<ThemeActivityModel>> getMyThemeActivitys(@Query("userid") String userId,
                                                             @Query("datetype") String dateType,
                                                             @Query("pageIndex") int pageIndex);

    /**
     * 我的活动-主题活动 列表个数
     *
     * @param userId   用户 workId
     * @param dateType {@link AppConstants.ActivityType}
     * @return 个数
     */
    @GET("/api/M_Professional/GetThemeActiveByUserIdCount?accessKey=1&secretKey=1")
    Observable<List<MyActivityCntModel>> getMyActivityCnt(@Query("userid") String userId,
                                                          @Query("datetype") String dateType);

    /**
     * 我的活动-大赛列表
     *
     * @param userId    用户 workId
     * @param dateType  {@link AppConstants.ActivityType}
     * @param pageIndex 页码
     * @return 个数
     */
    @GET("/api/M_Professional/GetActivityInfoByUserId?accessKey=1&secretKey=1&pageSize=30")
    Observable<List<MyCompetitionModel>> getMyCompetitionModels(@Query("userid") String userId,
                                                                @Query("datetype") String dateType,
                                                                @Query("pageIndex") int pageIndex);


    /**
     * 我的活动-大赛列表 列表个数
     *
     * @param userId   用户 workId
     * @param dateType {@link AppConstants.ActivityType}
     * @return 个数
     */
    @GET("/api/M_Professional/GetActivityInfoByUserIdCount?accessKey=1&secretKey=1")
    Observable<List<MyActivityCntModel>> getMyCompetitionCnt(@Query("userid") String userId,
                                                             @Query("datetype") String dateType);

    /**
     * 我的活动-大赛列表
     *
     * @param userId    用户 workId
     * @param userState {@link AppConstants.MyActivityUserState}
     * @param pageIndex 页码
     * @return 个数
     */
    @GET("/api/M_Professional/GetProjectListByUserId?accessKey=1&secretKey=1&pageSize=30")
    Observable<List<MyTrainModel>> getMyTrainModels(@Query("userid") String userId,
                                                    @Query("userstate") String userState,
                                                    @Query("pageIndex") int pageIndex);

    /**
     * 我的活动-大赛列表 列表个数
     *
     * @param userId    用户 workId
     * @param userState {@link AppConstants.MyActivityUserState}
     * @return 个数
     */
    @GET("/api/M_Professional/GetProjectListByUserIdCount?accessKey=1&secretKey=1")
    Observable<List<MyActivityCntModel>> getMyTrainCnt(@Query("userid") String userId,
                                                       @Query("userstate") String userState);


    /**
     * 我的活动-大赛列表
     *
     * @param userId    用户 workId
     * @param years     年份
     * @param pageIndex 页码
     * @return 个数
     */
    @GET("/api/M_Professional/GetSurveyByUserId?accessKey=1&secretKey=1&pageSize=30")
    Observable<List<MyQuestionnaireModel>> getMyQuestionnaireModels(@Query("userid") String userId,
                                                                    @Query("years") String years,
                                                                    @Query("pageIndex") int pageIndex);

    /**
     * 我的活动-大赛列表 列表个数
     *
     * @param userId 用户 workId
     * @param years  year
     * @return 个数
     */
    @GET("/api/M_Professional/GetSurveyByUserIdCount?accessKey=1&secretKey=1")
    Observable<List<MyActivityCntModel>> getMyQuestionnaireCnt(@Query("userid") String userId,
                                                               @Query("years") String years);

    /**
     * 收藏活动
     *
     * @param obj {@link com.nerc.baselibrary.model.ActivityCollectionBodyModel}
     */
    @GET("/api/M_Professional/JoinCollectionInfo?accessKey=1&secretKey=1")
    Observable<BaseResponse> collectionActivity(@Query("obj") String obj);

    /**
     * 项目培训 报名
     *
     * @param obj {@link com.nerc.baselibrary.model.ProjectTrainSignUpModel}
     */
    @GET("/api/M_Professional/JoinProject?accessKey=1&secretKey=1")
    Observable<BaseResponse> signUpTrain(@Query("obj") String obj);

    /**
     * 圈子详情页 话题列表
     *
     * @param groupId   圈子 workId
     * @param pageIndex 页码
     */
    @GET("/api/M_Professional/GetTopicListByGroupId?accessKey=1&secretKey=1&pageSize=30")
    Observable<List<TopicModel>> getCircleTopicModels(@Query("GroupId") String groupId,
                                                      @Query("pageIndex") int pageIndex);

    /**
     * 社区教育 街道 详情
     */
    @GET("/api/M_Professional/GetSchoolOne?accessKey=1&secretKey=1")
    Observable<List<CommunityEduDetailModel>> getCommunityEduDetail(@Query("id") String id);

    /**
     * 社区教育 街道详情页 活动列表
     */
    @GET("/api/M_Professional/GetThemeActivelistBySchool?accessKey=1&secretKey=1&pageSize=30")
    Observable<List<ThemeActivityModel>> getCommunityActivity(@Query("schoolId") String id,
                                                              @Query("pageIndex") int pageIndex);

    /**
     * 用户 积分 历史记录
     *
     * @param userId    user id
     * @param pageIndex page
     * @param time      ex: 2017-09
     */
    @GET("/api/M_User/GetUserCreditDetail?accessKey=1&secretKey=1")
    Observable<List<IntegralModel>> getIntegralHistory(@Query("userId") String userId,
                                                       @Query("pageIndex") int pageIndex,
                                                       @Query("cycle") String time);

    /**
     * 积分 规则
     */
    @GET("/api/M_User/GetCreditRule?accessKey=1&secretKey=1")
    Observable<List<IntegralRuleModel>> getIntegralRule();


    @GET("/api/M_User/GetCreditGrade?accessKey=1&secretKey=1")
    Observable<List<IntegralLevelModel>> getIntegralLevelRule();


    /**
     * 活动 搜索
     */
    @GET("/api/M_Professional/SearchThemeActiveBykey?accessKey=1&secretKey=1&pageSize=30")
    Observable<List<CircleSearchResultModel>> searchActivity(@Query("keyword") String keyword,
                                                             @Query("pageIndex") int pageIndex);


    /**
     * 我的 签到状态查看
     */
    @GET("/api/M_User/CheckQianDao?accessKey=1&secretKey=1")
    Observable<BaseResponse> checkSignInState(@Query("userId") String userId);

    /**
     * 签到
     */
    @GET("/api/M_User/GetQianDao?accessKey=1&secretKey=1")
    Observable<BaseResponse> signIn(@Query("userId") String userId);


    @GET("/api/M_Professional/GetRecommendAll?accessKey=1&secretKey=1")
    Observable<List<RecommendActivityModel>> getRecommandActivity();
}
