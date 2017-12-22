package com.nerc.baselibrary.network;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nerc.baselibrary.App;
import com.nerc.baselibrary.AppConstants;
import com.nerc.baselibrary.model.ActivityCollectionBodyModel;
import com.nerc.baselibrary.model.ActivityMemberModel;
import com.nerc.baselibrary.model.ActivityModel;
import com.nerc.baselibrary.model.ActivitySignUpModel;
import com.nerc.baselibrary.model.ArchiveModel;
import com.nerc.baselibrary.model.ArchivesCourseListModel;
import com.nerc.baselibrary.model.AvatarEditBody;
import com.nerc.baselibrary.model.BannerModel;
import com.nerc.baselibrary.model.BaseResponse;
import com.nerc.baselibrary.model.CircleChildModel;
import com.nerc.baselibrary.model.CircleCreateModel;
import com.nerc.baselibrary.model.CircleDetailModel;
import com.nerc.baselibrary.model.CircleEditModel;
import com.nerc.baselibrary.model.CircleJoinExitModel;
import com.nerc.baselibrary.model.CircleMemberModel;
import com.nerc.baselibrary.model.CircleModel;
import com.nerc.baselibrary.model.CircleSearchResultModel;
import com.nerc.baselibrary.model.CircleTotalCntModel;
import com.nerc.baselibrary.model.CollectionModel;
import com.nerc.baselibrary.model.CommunityEduDetailModel;
import com.nerc.baselibrary.model.CommunityEduNetAllModel;
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
import com.nerc.baselibrary.model.FilePostResponse;
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
import com.nerc.baselibrary.model.ProjectTrainSignUpModel;
import com.nerc.baselibrary.model.QuestionnaireModel;
import com.nerc.baselibrary.model.RecommendActivityModel;
import com.nerc.baselibrary.model.ResCategoryModel;
import com.nerc.baselibrary.model.SpeakingHallDetailModel;
import com.nerc.baselibrary.model.SpeakingHallModel;
import com.nerc.baselibrary.model.StudyStatisticsModel;
import com.nerc.baselibrary.model.SurveyDetailModel;
import com.nerc.baselibrary.model.SurveyModel;
import com.nerc.baselibrary.model.TeacherModel;
import com.nerc.baselibrary.model.TestDetailModel;
import com.nerc.baselibrary.model.TestStatisticsModel;
import com.nerc.baselibrary.model.ThemeActivityModel;
import com.nerc.baselibrary.model.TopicCreateModel;
import com.nerc.baselibrary.model.TopicImageModel;
import com.nerc.baselibrary.model.TopicLikeModel;
import com.nerc.baselibrary.model.TopicModel;
import com.nerc.baselibrary.model.TopicReplyBodyModel;
import com.nerc.baselibrary.model.TopicReplyModel;
import com.nerc.baselibrary.model.TrainDetailCourseModel;
import com.nerc.baselibrary.model.TrainDetailModel;
import com.nerc.baselibrary.model.TrainModel;
import com.nerc.baselibrary.model.VoteUploadModel;
import com.nerc.baselibrary.model.WrapResCategory;
import com.nerc.baselibrary.network.api.BaseApi;
import com.nerc.baselibrary.network.api.FileUploadApi;
import com.nerc.baselibrary.utils.NetUtils;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * ApiManager
 * Created by nercdevAndroid on 2017/3/13.
 */

public class ApiManager {

    private BaseApi mBaseApi;
    private FileUploadApi mFileUploadApi;

    // singleton
    private ApiManager() {
        initRetrofit();
    }

    public static ApiManager getInstance() {
        return Holder.sInstance;
    }

    private static class Holder {
        private static final ApiManager sInstance = new ApiManager();
    }
    //----

    /**
     * if net is enable: use net
     * if net is disable: use cache
     */
    private final Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = chain -> {
        Request request = chain.request();
        if (!NetUtils.isNetworkConnected(App.getInstance())) {
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build();
        }
        Response originalResponse = chain.proceed(request);
        if (NetUtils.isNetworkConnected(App.getInstance())) {
            return originalResponse.newBuilder()
                    .header("Cache-Control", "public, max-age=" + 0)
                    .removeHeader("Pragma")
                    .build();
        } else {
            return originalResponse.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=2419200")
                    .removeHeader("Pragma")
                    .build();
        }
    };


    private void initRetrofit() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        // add log
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(httpLoggingInterceptor);
        // add net
        builder.addInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR);
        builder.addNetworkInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR);

        //setup cache
        File httpCacheDirectory = new File(App.getInstance().getCacheDir(), "responses");
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(httpCacheDirectory, cacheSize);
        builder.cache(cache);

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(AppConstants.Api.getApi())
                .client(builder.build())
                .build();


        mBaseApi = retrofit.create(BaseApi.class);
    }

    public BaseApi getBaseApi() {
        return mBaseApi;
    }

    public FileUploadApi getFileUploadApi() {
        if (mFileUploadApi == null) {
            synchronized (ApiManager.this) {
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                // add log
                HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                builder.addInterceptor(httpLoggingInterceptor);
                // add net
                builder.addInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR);

                if (mFileUploadApi == null) {
                    mFileUploadApi = new Retrofit.Builder().baseUrl(AppConstants.Api.getFileApi())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(builder.build())
                            .build()
                            .create(FileUploadApi.class);
                }
            }
        }
        return mFileUploadApi;
    }


    // api

    public static void login(Observer<LoginModel> observer, String userName,
                             String password) {
        Observable<LoginModel> observable = ApiManager.getInstance().getBaseApi()
                .login(userName, password);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getBanner(Observer<List<BannerModel>> observer) {
        Observable<List<BannerModel>> observable = ApiManager.getInstance().getBaseApi()
                .getBanner();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getCourses(Observer<List<CourseModel>> observer, String userId,
                                  int learnStatus) {
        Observable<List<CourseModel>> observable = ApiManager.getInstance().getBaseApi()
                .getCourses(userId, learnStatus);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getHomeMyCourse(Observer<List<CourseModel>> observer, String userId) {
        Observable<List<CourseModel>> observable = ApiManager.getInstance().getBaseApi()
                .getHomeMyCourse(userId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    //    public static void getNewCourses(Observer<List<NewCourseModel>> observer, int pageIndex) {
//        Observable<List<NewCourseModel>> observable = ApiManager.getInstance().getBaseApi()
//                .getNewCourses(pageIndex);
//        observable.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer);
//    }
//
//    public static void getNewCourses30(Observer<List<NewCourseModel>> observer, int pageIndex) {
//        Observable<List<NewCourseModel>> observable = ApiManager.getInstance().getBaseApi()
//                .getNewCourses30(pageIndex);
//        observable.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer);
//    }

    public static void getHomeNews(Observer<List<LearnNewsModel>> observer) {
        Observable<List<LearnNewsModel>> observable = ApiManager.getInstance().getBaseApi()
                .getLearnNewss(AppConstants.NewsType.ACTIVITY_NOTI, 1);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getLearnNews(Observer<List<LearnNewsModel>> observer, int pageIndex) {
        Observable<List<LearnNewsModel>> observable = ApiManager.getInstance().getBaseApi()
                .getLearnNewss(AppConstants.NewsType.LEARN_NEWS, pageIndex);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getActivityNoti(Observer<List<LearnNewsModel>> observer, int pageIndex) {
        Observable<List<LearnNewsModel>> observable = ApiManager.getInstance().getBaseApi()
                .getLearnNewss(AppConstants.NewsType.ACTIVITY_NOTI, pageIndex);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getLearnStar(Observer<List<LearnStarModel>> observer) {
        Observable<List<LearnStarModel>> observable = ApiManager.getInstance().getBaseApi()
                .getLearnStar();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getQuestionnaires(Observer<List<QuestionnaireModel>> observer, String userId,
                                         int pageIndex) {
        Observable<List<QuestionnaireModel>> observable = ApiManager.getInstance().getBaseApi()
                .getQuestionnaires(userId, pageIndex);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getCourseDetail(Observer<CourseDetailModel> observer,
                                       String userId,
                                       String courseId) {
        Observable<CourseDetailModel> observable = ApiManager.getInstance().getBaseApi()
                .getCourseDetail(userId, courseId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getNewsDetail(Observer<NewsDetailModel> observer, String id) {
        Observable<List<NewsDetailModel>> observable = ApiManager.getInstance().getBaseApi()
                .getNewsDetail(id);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(response -> {
                    if (response.size() > 0) {
                        return response.get(0);
                    }
                    return new NewsDetailModel();
                })
                .subscribe(observer);
    }

    public static void getExamDetail(Observer<TestDetailModel> observer, String userId,
                                     String classId, String courseId, String chapterId) {
        Observable<List<TestDetailModel>> observable = ApiManager.getInstance().getBaseApi()
                .getExamDetail(userId, classId, courseId, chapterId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(response -> {
                    if (response.size() > 0) {
                        return response.get(0);
                    }
                    return new TestDetailModel();
                })
                .subscribe(observer);
    }


    public static void getSurvey(Observer<List<SurveyModel>> observer, String id) {
        Observable<List<SurveyModel>> observable = ApiManager.getInstance().getBaseApi()
                .getSurvey(id);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getTeachers(Observer<List<TeacherModel>> observer, String courseId) {
        Observable<List<TeacherModel>> observable = ApiManager.getInstance().getBaseApi()
                .getTeachers(courseId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }


    public static void getSurveyDetail(Observer<SurveyDetailModel> observer, String id) {
        Observable<MsgTypeResponse> observable = ApiManager.getInstance().getBaseApi()
                .getSurveyDetail(id);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(msgTypeResponse -> {
                    // 防止 NullException
                    SurveyDetailModel surveyDetailModel = new SurveyDetailModel();
                    surveyDetailModel.surveyNodeList = new ArrayList<>();

                    if (!TextUtils.isEmpty(msgTypeResponse.msg)) {
                        surveyDetailModel = new Gson().fromJson(msgTypeResponse.msg, SurveyDetailModel.class);
                    }
                    return surveyDetailModel;
                })
                .subscribe(observer);
    }

    public static void getSurveyResult(Observer<SurveyDetailModel> observer, String id) {
        Observable<MsgTypeResponse> observable = ApiManager.getInstance().getBaseApi()
                .getSurveyResult(id);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(msgTypeResponse -> {
                    // 防止 NullException
                    SurveyDetailModel surveyDetailModel = new SurveyDetailModel();
                    surveyDetailModel.surveyNodeList = new ArrayList<>();

                    if (!TextUtils.isEmpty(msgTypeResponse.msg)) {
                        surveyDetailModel = new Gson().fromJson(msgTypeResponse.msg, SurveyDetailModel.class);
                    }
                    return surveyDetailModel;
                })
                .subscribe(observer);
    }
//
//    public static void getCourseCategory(Observer<List<CourseCategory>> observer, int pageIndex) {
//        Observable<MsgTypeResponse> observable = ApiManager.getInstance().getBaseApi()
//                .getCourseCategory(pageIndex);
//        observable.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .map(msgTypeResponse -> {
//                    // 防止 NullException
//                    List<CourseCategory> courseCategorys = new ArrayList<>();
//
//                    if (!TextUtils.isEmpty(msgTypeResponse.msg)) {
//                        WrapCourseCategory wrapCourseCategory = new Gson().fromJson(msgTypeResponse.msg, WrapCourseCategory.class);
//                        courseCategorys = wrapCourseCategory.courseCategories;
//                    }
//                    return courseCategorys;
//                })
//                .subscribe(observer);
//    }

    public static void getCourseRes(Observer<List<ResCategoryModel>> observer, String userId,
                                    String courseId) {
        Observable<MsgTypeResponse> observable = ApiManager.getInstance().getBaseApi()
                .getCourseRes(userId, courseId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(msgTypeResponse -> {
                    // 防止 NullException
                    List<ResCategoryModel> resCategoryModels = new ArrayList<>();

                    if (!TextUtils.isEmpty(msgTypeResponse.msg)) {
                        WrapResCategory wrapCourseCategory = new Gson().fromJson(msgTypeResponse.msg, WrapResCategory.class);
                        resCategoryModels = wrapCourseCategory.zhanglist;
                    }
                    return resCategoryModels;
                })
                .subscribe(observer);
    }

    public static void postAnswer(Observer<BaseResponse> observer, String userId, String surveyId,
                                  String answer) {
        Observable<BaseResponse> observable = ApiManager.getInstance().getBaseApi()
                .postAnswer(userId, surveyId, answer);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void postScore(Observer<BaseResponse> observer, String userId, String courseId,
                                 int score) {
        Observable<BaseResponse> observable = ApiManager.getInstance().getBaseApi()
                .postScore(courseId, userId, score);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void joinCourse(Observer<BaseResponse> observer, String userId, String courseId,
                                  String classId) {
        Observable<BaseResponse> observable = ApiManager.getInstance().getBaseApi()
                .joinCourse(userId, courseId, classId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getNewCourseByType(Observer<List<CourseModel>> observer, String categoryId,
                                          int isOld, int pageIndex) {
        if (TextUtils.isEmpty(categoryId)) {
            Observable<List<CourseModel>> observable = ApiManager.getInstance().getBaseApi()
                    .getCoursesNewAll(isOld, pageIndex);
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(observer);
        } else {
            Observable<List<CourseModel>> observable = ApiManager.getInstance().getBaseApi()
                    .getCoursesNew(categoryId, isOld, pageIndex);
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(observer);
        }
    }

    public static void getHotCourseByType(Observer<List<CourseModel>> observer, String categoryId,
                                          int isOld, int pageIndex) {
        if (TextUtils.isEmpty(categoryId)) {
            Observable<List<CourseModel>> observable = ApiManager.getInstance().getBaseApi()
                    .getCoursesHotAll(isOld, pageIndex);
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(observer);
        } else {
            Observable<List<CourseModel>> observable = ApiManager.getInstance().getBaseApi()
                    .getCoursesHot(categoryId, isOld, pageIndex);
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(observer);
        }
    }

    public static void getCourseTypes(Observer<List<CourseTypeModel>> observer) {
        Observable<List<CourseTypeModel>> observable = ApiManager.getInstance().getBaseApi()
                .getCourseTypes();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getCompetitionModels(Observer<List<CompetitionModel>> observer, int pageIndex) {
        Observable<List<CompetitionModel>> observable = ApiManager.getInstance().getBaseApi()
                .getCompetitionModels(pageIndex);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getCompetitionDetail(Observer<List<CompetitionDetailModel>> observer, String userId,
                                            String id) {
        Observable<List<CompetitionDetailModel>> observable = ApiManager.getInstance().getBaseApi()
                .getCompetitionDetail(userId, id);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getCompetitionWorkTypeModels(Observer<List<CompetitionWorkTypeModel>> observer,
                                                    String competitionId) {
        Observable<List<CompetitionWorkTypeModel>> observable = ApiManager.getInstance().getBaseApi()
                .getCompetitionWorkTypeModels(competitionId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getCompetitionWorkCnt(Observer<List<CompetitionWorkCnt>> observer,
                                             String competitionId, String workTypeId) {
        Observable<List<CompetitionWorkCnt>> observable = ApiManager.getInstance().getBaseApi()
                .getCompetitionWorkCnt(competitionId, workTypeId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getCompetitionWorkList(Observer<List<CompetitionWorkModel>> observer,
                                              String competitionId, String orderBy, String workTypeId,
                                              int pageIndex) {
        Observable<List<CompetitionWorkModel>> observable = ApiManager.getInstance().getBaseApi()
                .getCompetitionWorkList(competitionId, orderBy, workTypeId, pageIndex);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getCompetitionWorkDetail(Observer<List<CompetitionWorkDetailModel>> observer,
                                                String userId, String workId) {
        Observable<List<CompetitionWorkDetailModel>> observable = ApiManager.getInstance().getBaseApi()
                .getCompetitionWorkDetail(userId, workId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void postVote(Observer<BaseResponse> observer, VoteUploadModel voteUploadModel) {
        String s = new Gson().toJson(voteUploadModel);
        Observable<BaseResponse> observable = ApiManager.getInstance().getBaseApi()
                .postVote(s);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getVoteResult(Observer<List<CompetitionVoteResultModel>> observer,
                                     String competitionId, int orderBy, int pageIndex) {
        Observable<List<CompetitionVoteResultModel>> observable = ApiManager.getInstance().getBaseApi()
                .getVoteResult(competitionId, orderBy, pageIndex);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getCourseRank(Observer<List<CourseRankModel>> observer) {
        Observable<List<CourseRankModel>> observable = ApiManager.getInstance().getBaseApi()
                .getCourseRank();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

//    public static void getChoiceCourses(Observer<List<NewCourseModel>> observer, int pageIndex) {
//        Observable<List<NewCourseModel>> observable = ApiManager.getInstance().getBaseApi()
//                .getChoiceCourses(pageIndex);
//        observable.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer);
//    }
//
//    public static void search(Observer<List<SearchCourseModel>> observer, String searchStr, int pageIndex) {
//        Observable<List<SearchCourseModel>> observable = ApiManager.getInstance().getBaseApi()
//                .search(searchStr, pageIndex);
//        observable.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer);
//    }

    public static void getCourseNotiCnt(Observer<CountModel> observer, String courseId, String classId) {
        Observable<CountModel> observable = ApiManager.getInstance().getBaseApi()
                .getCourseNotiCnt(courseId, classId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getCourseNotiModels(Observer<List<CourseNotiModel>> observer, String courseId,
                                           String classId, int pageIndex) {
        Observable<List<CourseNotiModel>> observable = ApiManager.getInstance().getBaseApi()
                .getCourseNotiModels(courseId, classId, pageIndex);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getStudyStatistics(Observer<List<StudyStatisticsModel>> observer, String userId,
                                          String courseId,
                                          String classId) {
        Observable<List<StudyStatisticsModel>> observable = ApiManager.getInstance().getBaseApi()
                .getStudyStatistics(userId, classId, courseId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getTestStatistics(Observer<List<TestStatisticsModel>> observer, String userId,
                                         String courseId,
                                         String classId) {
        Observable<List<TestStatisticsModel>> observable = ApiManager.getInstance().getBaseApi()
                .getTestStatistics(userId, classId, courseId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getCommunityEduNet(Observer<List<CommunityEduNetModel>> observer) {
        Observable<List<CommunityEduNetModel>> observable = ApiManager.getInstance().getBaseApi()
                .getCommunityEduNet();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getCommunityEduNetAll(Observer<List<CommunityEduNetAllModel>> observer) {
        Observable<MsgTypeResponse> observable = ApiManager.getInstance().getBaseApi()
                .getCommunityEduNetAll();
        observable.subscribeOn(Schedulers.io())
                .map(msgTypeResponse -> {
                    String msg = msgTypeResponse.msg;
                    List<CommunityEduNetAllModel> ret = new ArrayList<>();
                    if (!TextUtils.isEmpty(msg)) {

                        Type listType = new TypeToken<ArrayList<CommunityEduNetAllModel>>() {
                        }.getType();
                        ret = new Gson().fromJson(msg, listType);
                    }
                    return ret;
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }


    public static void modifyPwd(Observer<BaseResponse> observer, String userId,
                                 String newPwd,
                                 String oldPwd) {
        Observable<BaseResponse> observable = ApiManager.getInstance().getBaseApi()
                .modifyPwd(userId, oldPwd, newPwd);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

//
////    public static void uploadFile(Observer<FileUploadResponse> observer, MultipartBody.Part file) {
////
////        MultipartBody.Part allows = MultipartBody.Part.createFormData("allows", "");
////
////        Observable<FileUploadResponse> observable = ApiManager.getInstance().getFileUploadApi()
////                .uploadFile(file, allows);
////        observable.subscribeOn(Schedulers.io())
////                .observeOn(AndroidSchedulers.mainThread())
////                .subscribe(observer);
////    }
//
//
//    public static void postMineInfo(Observer<BaseResponse> observer, MineInfoBody mineInfoBody) {
//        String s = new Gson().toJson(mineInfoBody);
//        Observable<BaseResponse> observable = ApiManager.getInstance().getBaseApi()
//                .postMineInfo(s);
//        observable.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer);
//    }
//
//
//    public static void getNationList(Observer<List<NationEntity>> observer) {
//        Observable<List<NationEntity>> observable = ApiManager.getInstance().getBaseApi()
//                .getNationList();
//        observable.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer);
//    }
//
//    public static void getMineInfo(Observer<List<MineInfoEntity>> observer, String userId) {
//        Observable<List<MineInfoEntity>> observable = ApiManager.getInstance().getBaseApi()
//                .getMineInfo(userId);
//        observable.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer);
//    }

    public static void updateStudentScore(Observer<ResponseBody> observer, String userId, String courseId) {
        Observable<ResponseBody> observable = ApiManager.getInstance().getBaseApi()
                .updateStudentScore(userId, courseId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void uploadVideoPlayTime(Observer<BaseResponse> observer, String userId, String courseId,
                                           String resourceId, int learnTime) {
        Observable<BaseResponse> observable = ApiManager.getInstance().getBaseApi()
                .uploadVideoPlayTime(userId, courseId, resourceId, 0, learnTime);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getCourseNotifications(Observer<List<CourseNotiModel>> observer, String courseId,
                                              int pageIndex) {
        Observable<List<CourseNotiModel>> observable = ApiManager.getInstance().getBaseApi()
                .getCourseNotifications(courseId, "0", pageIndex);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getSpeakingHallNoti3(Observer<List<SpeakingHallModel>> observer) {
        Observable<List<SpeakingHallModel>> observable = ApiManager.getInstance().getBaseApi()
                .getSpeakingHalls(AppConstants.SpeakingHallType.UNSTART, 1, 3);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getSpeakingHall(Observer<List<SpeakingHallModel>> observer,
                                       String type, int pageIndex) {
        Observable<List<SpeakingHallModel>> observable = ApiManager.getInstance().getBaseApi()
                .getSpeakingHalls(type, pageIndex, 30);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getSpeakingHallDetail(Observer<List<SpeakingHallDetailModel>> observer,
                                             String userId, String id) {
        Observable<List<SpeakingHallDetailModel>> observable = ApiManager.getInstance().getBaseApi()
                .getSpeakingHallDetail(userId, id);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getHallDetails(Observer<List<HallDetailModel>> observer,
                                      String id) {
        Observable<List<HallDetailModel>> observable = ApiManager.getInstance().getBaseApi()
                .getHallDetails(id);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getTrains(Observer<List<TrainModel>> observer,
                                 int state, int type, int pageIndex) {
        Observable<List<TrainModel>> observable = ApiManager.getInstance().getBaseApi()
                .getTrains(state, type, pageIndex);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }


    public static void getTrainDetial(Observer<List<TrainDetailModel>> observer,
                                      String id, String userId) {
        Observable<List<TrainDetailModel>> observable = ApiManager.getInstance().getBaseApi()
                .getTrainDetial(id, userId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getTrainDetailCourse(Observer<List<TrainDetailCourseModel>> observer,
                                            String id) {
        Observable<List<TrainDetailCourseModel>> observable = ApiManager.getInstance().getBaseApi()
                .getTrainDetailCourse(id, Integer.MAX_VALUE, 1);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getMineInfo(Observer<List<MineInfoEntity>> observer, String userId) {
        Observable<List<MineInfoEntity>> observable = ApiManager.getInstance().getBaseApi()
                .getMineInfo(userId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void submitPaperByPaperId(Observer<BaseResponse> observer, String userId,
                                            String courseClassId, String courseId, String chapterId,
                                            String paperId) {
        Observable<BaseResponse> observable = ApiManager.getInstance().getBaseApi()
                .submitPaperByPaperId(userId, courseClassId, courseId, chapterId, paperId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void uploadAnswer(Observer<BaseResponse> observer, String userId,
                                    String courseClassId, String courseId, String chapterId,
                                    String paperId, String questionId, String answer) {
        Observable<BaseResponse> observable = ApiManager.getInstance().getBaseApi()
                .uploadAnswer(userId, courseId, courseClassId, chapterId, paperId, questionId, answer);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void uploadShortAnswer(Observer<BaseResponse> observer, String userId,
                                         String courseClassId, String courseId, String chapterId,
                                         String paperId, String questionId, String answer) {
        Observable<BaseResponse> observable = ApiManager.getInstance().getBaseApi()
                .uploadShortAnswer(userId, courseId, courseClassId, chapterId, paperId, questionId, answer);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getExamWithAnswer(Observer<List<ExamQuestionModel>> observer, String userId,
                                         String courseClassId, String courseId, String chapterId,
                                         String paperId) {
        // 获取 单选，多选，判断
        Observable<List<ExamQuestionModel>> observable = ApiManager.getInstance().getBaseApi()
                .getExamWithAnswer(userId, courseClassId, courseId, chapterId, paperId);

        // 获取简答题
        Observable<List<ExamQuestionModel>> observable2 = ApiManager.getInstance().getBaseApi()
                .getExamWithAnswerShortAnswer(userId, courseClassId, courseId, chapterId, paperId)
                .map(examQuestionModels -> {
                    for (ExamQuestionModel examQuestionModel : examQuestionModels) {
                        examQuestionModel.type = AppConstants.ExamQuestionType.SHORT_ANSWER;
                    }
                    return examQuestionModels;
                });

        Observable.combineLatest(observable, observable2, (examQuestionModels, examQuestionModels2) -> {
            examQuestionModels.addAll(examQuestionModels2);
            return examQuestionModels;
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getExamQuestion(Observer<List<ExamQuestionModel>> observer, String paperId) {
        // 获取 单选，多选，判断
        Observable<List<ExamQuestionModel>> observable = ApiManager.getInstance().getBaseApi()
                .getExamQuestion(paperId);

        // 获取简答题
        Observable<List<ExamQuestionModel>> observable2 = ApiManager.getInstance().getBaseApi()
                .getExamQuestionShortAnswer(paperId)
                .map(examQuestionModels -> {
                    for (ExamQuestionModel examQuestionModel : examQuestionModels) {
                        examQuestionModel.type = AppConstants.ExamQuestionType.SHORT_ANSWER;
                    }
                    return examQuestionModels;
                });

        Observable.combineLatest(observable, observable2, (examQuestionModels, examQuestionModels2) -> {
            examQuestionModels.addAll(examQuestionModels2);
            return examQuestionModels;
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getCircleHot(Observer<List<CircleModel>> observer) {
        Observable<List<CircleModel>> observable = ApiManager.getInstance().getBaseApi()
                .getCircleHot();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getMyCircle(Observer<List<CircleModel>> observer, String userId, int pageIndex) {
        Observable<List<CircleModel>> observable = ApiManager.getInstance().getBaseApi()
                .getMyCircle(userId, pageIndex);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getCircle(Observer<List<CircleChildModel>> observer, String userId, int pageIndex) {
        Observable<List<CircleChildModel>> listObservable;
        if (pageIndex == 1) {
            Observable<List<CircleModel>> observable = ApiManager.getInstance().getBaseApi()
                    .getCircleHot();

            Observable<List<CircleModel>> observable1 = ApiManager.getInstance().getBaseApi()
                    .getMyCircle(userId, pageIndex);

            listObservable = Observable.combineLatest(observable, observable1, (circleModelList, circleModelList2) -> {
                ArrayList<CircleChildModel> circleChildModels = new ArrayList<>();
                CircleChildModel circleChildModel = new CircleChildModel();
                circleChildModel.circleModelList = circleModelList;
                circleChildModels.add(circleChildModel);

                for (CircleModel circleModel : circleModelList2) {
                    CircleChildModel e = new CircleChildModel();
                    e.circleModel = circleModel;
                    circleChildModels.add(e);
                }
                return circleChildModels;
            });
        } else {
            listObservable = ApiManager.getInstance().getBaseApi()
                    .getMyCircle(userId, pageIndex).map(circleModelList -> {
                        ArrayList<CircleChildModel> circleChildModels = new ArrayList<>();
                        for (CircleModel circleModel : circleModelList) {
                            CircleChildModel e = new CircleChildModel();
                            e.circleModel = circleModel;
                            circleChildModels.add(e);
                        }
                        return circleChildModels;
                    });
        }

        listObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }


    public static void getAllCircle(Observer<List<CircleModel>> observer, String orderBy, int pageIndex) {
        Observable<List<CircleModel>> observable = ApiManager.getInstance().getBaseApi()
                .getAllCircle(orderBy, pageIndex);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getCircleTotalCnt(Observer<CircleTotalCntModel> observer) {
        Observable<CircleTotalCntModel> observable = ApiManager.getInstance().getBaseApi()
                .getCircleTotalCnt();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void createCircle(Observer<BaseResponse> observer, CircleCreateModel circleCreateModel) {
        Observable<BaseResponse> observable = ApiManager.getInstance().getBaseApi()
                .createCircle(new Gson().toJson(circleCreateModel));
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getCircleDetailModel(Observer<List<CircleDetailModel>> observer,
                                            String userId, String cirlceId) {
        Observable<List<CircleDetailModel>> observable = ApiManager.getInstance().getBaseApi()
                .getCircleDetailModel(userId, cirlceId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getCircleMembers(Observer<List<CircleMemberModel>> observer,
                                        String groupId, int pageIndex) {
        Observable<List<CircleMemberModel>> observable = ApiManager.getInstance().getBaseApi()
                .getCircleMembers(groupId, pageIndex);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getCircleMemberAll(Observer<List<CircleMemberModel>> observer,
                                          String groupId) {
        Observable<List<CircleMemberModel>> observable = ApiManager.getInstance().getBaseApi()
                .getCircleMemberAll(groupId, Integer.MAX_VALUE);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }


    public static void deleteCircleMember(Observer<BaseResponse> observer,
                                          CircleJoinExitModel circleJoinExitModel) {
        Observable<BaseResponse> observable = ApiManager.getInstance().getBaseApi()
                .deleteCircleMember(new Gson().toJson(circleJoinExitModel));
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void joinCircle(Observer<BaseResponse> observer, CircleJoinExitModel circleJoinModel) {
        Observable<BaseResponse> observable = ApiManager.getInstance().getBaseApi()
                .joinCircle(new Gson().toJson(circleJoinModel));
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void exitCircle(Observer<BaseResponse> observer, CircleJoinExitModel circleJoinModel) {
        Observable<BaseResponse> observable = ApiManager.getInstance().getBaseApi()
                .exitCircle(new Gson().toJson(circleJoinModel));
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void editCircle(Observer<BaseResponse> observer, CircleEditModel circleEditModel) {
        String circleEditJson = new Gson().toJson(circleEditModel);
        Observable<BaseResponse> observable = ApiManager.getInstance().getBaseApi()
                .editCircle(circleEditJson);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getTopicModel(Observer<List<TopicModel>> observer, int pageIndex) {
        Observable<List<TopicModel>> observable = ApiManager.getInstance().getBaseApi()
                .getTopicModel(pageIndex);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getTopicDetail(Observer<List<TopicModel>> observer, String userId, String topicId) {
        Observable<List<TopicModel>> observable = ApiManager.getInstance().getBaseApi()
                .getTopicDetail(userId, topicId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getTopicDetailImgs(Observer<List<TopicImageModel>> observer, String topicId) {
        Observable<List<TopicImageModel>> observable = ApiManager.getInstance().getBaseApi()
                .getTopicDetailImgs(topicId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getTopicDetailReplys(Observer<List<TopicReplyModel>> observer, String topicId,
                                            int pageIndex) {
        Observable<List<TopicReplyModel>> observable = ApiManager.getInstance().getBaseApi()
                .getTopicDetailReplys(topicId, pageIndex);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void replyTopic(Observer<BaseResponse> observer, TopicReplyBodyModel topicReplyModel) {
        Observable<BaseResponse> observable = ApiManager.getInstance().getBaseApi()
                .replyTopic(new Gson().toJson(topicReplyModel));
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void likeTopic(Observer<BaseResponse> observer, TopicLikeModel topicLikeModel) {
        Observable<BaseResponse> observable = ApiManager.getInstance().getBaseApi()
                .likeTopic(new Gson().toJson(topicLikeModel));
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void unlikeTopic(Observer<BaseResponse> observer, TopicLikeModel topicLikeModel) {
        Observable<BaseResponse> observable = ApiManager.getInstance().getBaseApi()
                .unlikeTopic(new Gson().toJson(topicLikeModel));
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void createTopic(Observer<BaseResponse> observer, TopicCreateModel topicCreateModel) {
        Observable<BaseResponse> observable = ApiManager.getInstance().getBaseApi()
                .createTopic(new Gson().toJson(topicCreateModel));
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void searchCircle(Observer<List<CircleSearchResultModel>> observer, String keyword, int pageIndex) {
        Observable<List<CircleSearchResultModel>> observable = ApiManager.getInstance().getBaseApi()
                .searchCircle(keyword, pageIndex);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void searchCircleTopic(Observer<List<CircleSearchResultModel>> observer, String keyword, int pageIndex) {
        Observable<List<CircleSearchResultModel>> observable = ApiManager.getInstance().getBaseApi()
                .searchCircleTopic(keyword, pageIndex);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }


    public static void getMineModel(Observer<List<MineModel>> observer, String userId) {
        Observable<List<MineModel>> observable = ApiManager.getInstance().getBaseApi()
                .getMineModel(userId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getArchiveModel(Observer<List<ArchiveModel>> observer, String userId) {
        Observable<List<ArchiveModel>> observable = ApiManager.getInstance().getBaseApi()
                .getArchiveModel(userId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getArchiveCourseListModel(Observer<List<ArchivesCourseListModel>> observer, String userId,
                                                 String year) {
        Observable<List<ArchivesCourseListModel>> observable = ApiManager.getInstance().getBaseApi()
                .getArchiveCourseListModel(userId, year);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }


    public static void getCollectionsCourse(Observer<List<CourseModel>> observer, String userId,
                                            int pageIndex) {
        Observable<List<CourseModel>> observable = ApiManager.getInstance().getBaseApi()
                .getCollections(userId, AppConstants.CollectionType.COURSE, pageIndex);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getCollectionsActivity(Observer<List<CollectionModel>> observer, String userId,
                                              int pageIndex) {
        Observable<List<CollectionModel>> observable = ApiManager.getInstance().getBaseApi()
                .getActivityCollections(userId, AppConstants.CollectionType.ACTIVITIES, pageIndex);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void collectionCourse(Observer<BaseResponse> observer, String userId,
                                        String courseId) {
        Observable<BaseResponse> observable = ApiManager.getInstance().getBaseApi()
                .collectionCourse(userId, courseId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void deleteCollection(Observer<BaseResponse> observer, String collectionId) {
        Observable<BaseResponse> observable = ApiManager.getInstance().getBaseApi()
                .deleteCollection(collectionId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getMyActivity5(Observer<List<ActivityModel>> observer, String userId) {
        Observable<List<ActivityModel>> observable = ApiManager.getInstance().getBaseApi()
                .getMyActivity5(userId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }


    public static void getThemeActivity(Observer<List<ThemeActivityModel>> observer, String type,
                                        String orderBy, int pageIndex) {
        Observable<List<ThemeActivityModel>> observable = ApiManager.getInstance().getBaseApi()
                .getThemeActivity(type, orderBy, pageIndex);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getThemeActivityDetail(Observer<List<ThemeActivityModel>> observer, String activityId,
                                              String userId) {
        Observable<List<ThemeActivityModel>> observable = ApiManager.getInstance().getBaseApi()
                .getThemeActivityDetail(activityId, userId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void signUpActivity(Observer<BaseResponse> observer, ActivitySignUpModel activitySignUpModel) {
        Observable<BaseResponse> observable = ApiManager.getInstance().getBaseApi()
                .signUpActivity(new Gson().toJson(activitySignUpModel));
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getActivityMember(Observer<List<ActivityMemberModel>> observer, String activityId,
                                         int pageIndex) {
        Observable<List<ActivityMemberModel>> observable = ApiManager.getInstance().getBaseApi()
                .getActivityMember(activityId, pageIndex);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getRelativeAct(Observer<List<ThemeActivityModel>> observer, String activityId) {
        Observable<List<ThemeActivityModel>> observable = ApiManager.getInstance().getBaseApi()
                .getRelativeAct(activityId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getMyThemeActivitys(Observer<List<ThemeActivityModel>> observer, String userId,
                                           String dateType, int pageIndex) {
        Observable<List<ThemeActivityModel>> observable = ApiManager.getInstance().getBaseApi()
                .getMyThemeActivitys(userId, dateType, pageIndex);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getMyCompetitionModels(Observer<List<MyCompetitionModel>> observer, String userId,
                                              String dateType, int pageIndex) {
        Observable<List<MyCompetitionModel>> observable = ApiManager.getInstance().getBaseApi()
                .getMyCompetitionModels(userId, dateType, pageIndex);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getMyTrainModels(Observer<List<MyTrainModel>> observer, String userId,
                                        String userState, int pageIndex) {
        Observable<List<MyTrainModel>> observable = ApiManager.getInstance().getBaseApi()
                .getMyTrainModels(userId, userState, pageIndex);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getMyQuestionnaireModels(Observer<List<MyQuestionnaireModel>> observer, String userId,
                                                String userState, int pageIndex) {
        Observable<List<MyQuestionnaireModel>> observable = ApiManager.getInstance().getBaseApi()
                .getMyQuestionnaireModels(userId, userState, pageIndex);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getMyActivityCnt(Observer<List<MyActivityCntModel>> observer, String userId,
                                        String dateType) {
        Observable<List<MyActivityCntModel>> observable = ApiManager.getInstance().getBaseApi()
                .getMyActivityCnt(userId, dateType);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getMyCompetitionCnt(Observer<List<MyActivityCntModel>> observer, String userId,
                                           String dateType) {
        Observable<List<MyActivityCntModel>> observable = ApiManager.getInstance().getBaseApi()
                .getMyCompetitionCnt(userId, dateType);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getMyTrainCnt(Observer<List<MyActivityCntModel>> observer, String userId,
                                     String userState) {
        Observable<List<MyActivityCntModel>> observable = ApiManager.getInstance().getBaseApi()
                .getMyTrainCnt(userId, userState);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getMyQuestionnaireCnt(Observer<List<MyActivityCntModel>> observer, String userId,
                                             String years) {
        Observable<List<MyActivityCntModel>> observable = ApiManager.getInstance().getBaseApi()
                .getMyQuestionnaireCnt(userId, years);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void collectionActivity(Observer<BaseResponse> observer, ActivityCollectionBodyModel model) {
        Observable<BaseResponse> observable = ApiManager.getInstance().getBaseApi()
                .collectionActivity(new Gson().toJson(model));
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void signUpTrain(Observer<BaseResponse> observer, ProjectTrainSignUpModel trainSignUpModel) {
        Observable<BaseResponse> observable = ApiManager.getInstance().getBaseApi()
                .signUpTrain(new Gson().toJson(trainSignUpModel));
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getCircleTopicModels(Observer<List<TopicModel>> observer, String groupId, int pageIndex) {
        Observable<List<TopicModel>> observable = ApiManager.getInstance().getBaseApi()
                .getCircleTopicModels(groupId, pageIndex);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getCommunityEduDetail(Observer<List<CommunityEduDetailModel>> observer, String id) {
        Observable<List<CommunityEduDetailModel>> observable = ApiManager.getInstance().getBaseApi()
                .getCommunityEduDetail(id);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getCommunityActivity(Observer<List<ThemeActivityModel>> observer, String id,
                                            int pageIndex) {
        Observable<List<ThemeActivityModel>> observable = ApiManager.getInstance().getBaseApi()
                .getCommunityActivity(id, pageIndex);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getIntegralHistory(Observer<List<IntegralModel>> observer, String userId,
                                          int pageIndex, String time) {
        Observable<List<IntegralModel>> observable = ApiManager.getInstance().getBaseApi()
                .getIntegralHistory(userId, pageIndex, time);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getIntegralRule(Observer<List<IntegralRuleModel>> observer) {
        Observable<List<IntegralRuleModel>> observable = ApiManager.getInstance().getBaseApi()
                .getIntegralRule();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }


    public static void getIntegralLevelRule(Observer<List<IntegralLevelModel>> observer) {
        Observable<List<IntegralLevelModel>> observable = ApiManager.getInstance().getBaseApi()
                .getIntegralLevelRule();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void searchActivity(Observer<List<CircleSearchResultModel>> observer, String keyword, int pageIndex) {
        Observable<List<CircleSearchResultModel>> observable = ApiManager.getInstance().getBaseApi()
                .searchActivity(keyword, pageIndex);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void checkSignInState(Observer<BaseResponse> observer, String userId) {
        Observable<BaseResponse> observable = ApiManager.getInstance().getBaseApi()
                .checkSignInState(userId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void signIn(Observer<BaseResponse> observer, String userId) {
        Observable<BaseResponse> observable = ApiManager.getInstance().getBaseApi()
                .signIn(userId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getRecommandActivity(Observer<List<RecommendActivityModel>> observer) {
        Observable<List<RecommendActivityModel>> observable = ApiManager.getInstance().getBaseApi()
                .getRecommandActivity();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void editAvatar(Observer<BaseResponse> observer, AvatarEditBody avatarEditBody) {
        String s = new Gson().toJson(avatarEditBody);
        Observable<BaseResponse> observable = ApiManager.getInstance().getBaseApi()
                .editAvatar(s);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    /**
     * @param uploadType 0: 头像  1：作业 {@link AppConstants.FileUploadType}
     */
    public static void uploadFile(Observer<FilePostResponse> observer, MultipartBody.Part file, int uploadType) {

        MultipartBody.Part allows = MultipartBody.Part.createFormData("uploadtype", uploadType + "");

        Observable<FilePostResponse> observable = ApiManager.getInstance().getFileUploadApi()
                .uploadFile(file, allows);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }


}
