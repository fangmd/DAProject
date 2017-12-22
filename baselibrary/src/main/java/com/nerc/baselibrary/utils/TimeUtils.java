package com.nerc.baselibrary.utils;

import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by nercdevAndroid on 2017/3/8.
 */

public class TimeUtils {

    // "yyyy-MM-dd HH:mm:ss"
    public static String convert(String from, String patternFrom, String patternTo) {
        if (TextUtils.isEmpty(from)) {
            return "";
        }
        String ret = "";
        //2017-03-02 14:27:26
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patternFrom);
        try {
            Date date = simpleDateFormat.parse(from);
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(patternTo);
            ret = simpleDateFormat1.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return ret;
    }

    public static String friendlyTime(String time, String pattern, String resultPattern) {
        if (time == null) {
            return "";
        }
        String ret = "";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.CHINA);
        SimpleDateFormat resultSDF = new SimpleDateFormat(resultPattern, Locale.CHINA);
        try {
            Date parse = simpleDateFormat.parse(time);
            long l = System.currentTimeMillis();
            long time1 = parse.getTime();
            long ct = (l - time1) / 1000;

            if (ct == 0) {
                ret = "刚刚";
            }

            if (ct > 0 && ct < 60) {
                ret = ct + "秒前";
            }

            if (ct >= 60 && ct < 3600) {
                ret = Math.max(ct / 60, 1) + "分钟前";
            }

            if (ct >= 3600 && ct < 86400)
                ret = ct / 3600 + "小时前";

            if (ct >= 86400) { //86400 * 30
                long day = ct / 86400;
                ret = resultSDF.format(parse);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ret;
    }


    public static String friendlyTime(Date time) {
        //获取time距离当前的秒数
        int ct = (int) ((System.currentTimeMillis() - time.getTime()) / 1000);

        if (ct == 0) {
            return "刚刚";
        }

        if (ct > 0 && ct < 60) {
            return ct + "秒前";
        }

        if (ct >= 60 && ct < 3600) {
            return Math.max(ct / 60, 1) + "分钟前";
        }
        if (ct >= 3600 && ct < 86400)
            return ct / 3600 + "小时前";
        if (ct >= 86400 && ct < 2592000) { //86400 * 30
            int day = ct / 86400;
            return day + "天前";
        }
        if (ct >= 2592000 && ct < 31104000) { //86400 * 30
            return ct / 2592000 + "月前";
        }
        return ct / 31104000 + "年前";
    }

    /**
     * 根据年 月 获取对应的月份 天数
     */
    public static int getDaysByYearMonth(int year, int month) {

        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, year);
        a.set(Calendar.MONTH, month - 1);
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        return a.get(Calendar.DATE);
    }

    /**
     * get today day
     *
     * @return day
     */
    public static int getCurrentDay() {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(System.currentTimeMillis());
        return instance.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * get current month
     *
     * @return month
     */
    public static int getCurrentMonth() {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(System.currentTimeMillis());
        return instance.get(Calendar.MONTH) + 1;
    }

    /**
     * get current year
     *
     * @return year
     */
    public static int getCurrentYear() {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(System.currentTimeMillis());
        return instance.get(Calendar.YEAR);
    }

    /**
     * 根据日期 找到对应日期的 星期
     */
    public static String getWeek(String date) {
        String dayOfweek = "-1";
        try {
            SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
            Date myDate = myFormatter.parse(date);
            SimpleDateFormat formatter = new SimpleDateFormat("E");
            String str = formatter.format(myDate);
            dayOfweek = str;

        } catch (Exception e) {
            System.out.println("错误!");
        }
        return dayOfweek;
    }

    /**
     * date2 比 date1 多的天数
     */
    public static int differentDays(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1 = cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if (year1 != year2)   //同一年
        {
            int timeDistance = 0;
            for (int i = year1; i < year2; i++) {
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0)    //闰年
                {
                    timeDistance += 366;
                } else    //不是闰年
                {
                    timeDistance += 365;
                }
            }

            return timeDistance + (day2 - day1);
        } else    //不同年
        {
            System.out.println("判断day2 - day1 : " + (day2 - day1));
            return day2 - day1;
        }
    }

    public static Date parseDate(String pattern, String timeStr) {
        if (TextUtils.isEmpty(timeStr) || TextUtils.isEmpty(pattern)) {
            return null;
        }
        //2017-03-02 14:27:26
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            return simpleDateFormat.parse(timeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
