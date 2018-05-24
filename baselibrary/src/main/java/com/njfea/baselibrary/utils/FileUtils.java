package com.njfea.baselibrary.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.support.annotation.NonNull;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.util.Log;

import com.njfea.baselibrary.AppConstants;

import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;

/**
 * FileUtils
 * Created by nercdevAndroid on 2017/3/9.
 */

public class FileUtils {


    public static Uri getUri(Context context, File file) {
        if (file == null) {
            return null;
        }

        String packageName = context.getApplicationContext().getPackageName();
        Uri uriForFile = FileProvider.getUriForFile(context, packageName + ".provider",
                file);

        return uriForFile;
    }


    public static boolean isFileExist(File file) {
        return file.exists();
    }

    /**
     * 获取文件后缀名
     *
     * @param fileName 文件全名
     * @return 后缀
     */
    public static String getSuf(String fileName) {
        if (TextUtils.isEmpty(fileName)) {
            return "";
        }
        String[] split = fileName.split("\\.");
        return split.length > 0 ? split[split.length - 1] : "";
    }

    public static boolean isApk(String fileName) {
        boolean ret = false;
        String suf = getSuf(fileName);
        ret = suf.equals("apk");
        return ret;
    }

    //---custom-=========================================

    public static String getDonwloadFile(String fileName) {
        return Environment.getExternalStorageDirectory() + "/download/" + fileName;
    }

    /**
     * 获取 app 的缓存文件路径
     *
     * @return .../.MyOUC
     */
    public static String getCachePath() {
        return getDirPath(AppConstants.FilePath.CACHE_PATH);
    }

    /**
     * 获取 app 的录音文件夹路径
     *
     * @return .../.MyOUC/record
     */
    public static String getRecordPath() {
        // 先创建父目录
        getDirPath(AppConstants.FilePath.CACHE_PATH);
        return getDirPath(AppConstants.FilePath.RECORD_PATH);
    }

    /**
     * 获取 app 课程资源下载路径
     *
     * @return .../MyOUC/课程名/
     */
//    public static String getCourseResourceDirPath(String courseName) {
//        // 先创建父目录
//        getDirPath(AppConstants.FilePath.COURSE_RESOURCE_PATH);
//        // /MyOUC/课程名/
//        String path = getDirPath(AppConstants.FilePath.COURSE_RESOURCE_PATH + "/" + courseName);
//        return path;
//    }
    /**
     * 获取 app 课程资源下载路径
     *
     * @return .../MyOUC/
     */
    public static String getCourseResourceDirPath() {
        // 先创建父目录
        getDirPath(AppConstants.FilePath.COURSE_RESOURCE_PATH);
        // /MyOUC/课程名/
        String path = getDirPath(AppConstants.FilePath.COURSE_RESOURCE_PATH);
        return path;
    }

    /**
     * 获取 app 课程资源下载路径
     *
     * @return .../MyOUC/课程名/资源名
     */
    public static String getCourseResourcePath(String courseName, String resourceName) {
        // 先创建父目录
        getDirPath(AppConstants.FilePath.COURSE_RESOURCE_PATH);
        // /MyOUC/课程名/
        String path = getDirPath(AppConstants.FilePath.COURSE_RESOURCE_PATH + "/" + courseName);
        String s = path + resourceName;
        return s;
    }

    /**
     * 获取文件夹路径 不存在就创建
     *
     * @param child 格式 /MyOUC
     * @return 绝对路径  /MyOUC/
     */
    @NonNull
    private static String getDirPath(String child) {
        String s = Environment.getExternalStorageDirectory() + child + "/";
        File file = new File(s);
        if (!file.exists()) {
            LoggerUtils.d(AppConstants.Tag.FILE, " cache path do not exists , create:" + s);
            boolean mkdir = file.mkdir();
        }
        return s;
    }

    /**
     * 获取文件夹路径 不存在就创建
     *
     * @param child 格式 /MyOUC
     * @return 绝对路径  /MyOUC/
     */
    @NonNull
    public static String createDirPath(String child) {
        String s = Environment.getExternalStorageDirectory() + child + "/";
        File file = new File(s);
        if (!file.exists()) {
            LoggerUtils.d(AppConstants.Tag.FILE, " cache path do not exists , create:" + s);
            boolean mkdir = file.mkdir();
        }
        return s;
    }

    public static String getImgDirPath() {
        // 创建父文件夹  /MyOUC
        getDirPath(AppConstants.FilePath.COURSE_RESOURCE_PATH);
        return getDirPath(AppConstants.FilePath.IMG_PATH);
    }

    public static String getExamDirPath() {
        getDirPath(AppConstants.FilePath.COURSE_RESOURCE_PATH);
        return getDirPath(AppConstants.FilePath.EXAM_PATH);
    }


    public static String getSufByType(int resType) {
        String ret = "";
        switch (resType) {
            case 0:  // mp4
                ret = "mp4";
                break;
            case 1: // pdf
                ret = "pdf";
                break;
            case 2: // html
                ret = "html";
                break;
            case 3: // zip
                ret = "zip";
                break;
            default:
                break;
        }
        return ret;
    }

    /**
     * 获取指定文件夹
     *
     * @param f
     * @return
     * @throws Exception
     */
    public static long getFileSizes(File f) throws Exception {
        long size = 0;
        File flist[] = f.listFiles();
        for (int i = 0; i < flist.length; i++) {
            if (flist[i].isDirectory()) {
                size = size + getFileSizes(flist[i]);
            } else {
                size = size + getFileSize(flist[i]);
            }
        }
        return size;
    }


    /**
     * 获取指定文件大小
     *
     * @param file
     * @return
     * @throws Exception
     */
    private static long getFileSize(File file) throws Exception {
        long size = 0;
        if (file.exists()) {
            FileInputStream fis = null;
            fis = new FileInputStream(file);
            size = fis.available();
        } else {
            Log.e("获取文件大小", "文件不存在!");
        }
        return size;
    }

    private static DecimalFormat fileIntegerFormat = new DecimalFormat("#0");
    private static DecimalFormat fileDecimalFormat = new DecimalFormat("#0.##");

    /**
     * 单位换算
     *
     * @param size      单位为B
     * @param isInteger 是否返回取整的单位
     * @return 转换后的单位
     */
    public static String formatFileSize(long size, boolean isInteger) {
        DecimalFormat df = isInteger ? fileIntegerFormat : fileDecimalFormat;
        String fileSizeString = "0M";
        if (size < 1024 && size > 0) {
            fileSizeString = df.format((double) size) + "B";
        } else if (size < 1024 * 1024) {
            fileSizeString = df.format((double) size / 1024) + "K";
        } else if (size < 1024 * 1024 * 1024) {
            fileSizeString = df.format((double) size / (1024 * 1024)) + "M";
        } else {
            fileSizeString = df.format((double) size / (1024 * 1024 * 1024)) + "G";
        }
        return fileSizeString;
    }

    /**
     * SDCARD是否存
     */
    public static boolean externalMemoryAvailable() {
        return Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED);
    }

    /**
     * 获取手机内部剩余存储空间
     *
     * @return
     */
    public static long getAvailableInternalMemorySize() {
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long availableBlocks = stat.getAvailableBlocks();
        return availableBlocks * blockSize;
    }

    /**
     * 获取手机内部总的存储空间
     *
     * @return
     */
    public static long getTotalInternalMemorySize() {
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long totalBlocks = stat.getBlockCount();
        return totalBlocks * blockSize;
    }


    public static int getChildFileCnt(String courseDirPath) {
        int ret = 0;
        File file = new File(courseDirPath);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            ret = files.length;
        }
        return ret;
    }


    public static String getFilePath(Context context, Uri uri) {
        if ("content".equalsIgnoreCase(uri.getScheme())) {
            String[] projection = {"_data"};
            Cursor cursor = null;

            try {
                cursor = context.getContentResolver().query(uri, projection, null, null, null);
                int column_index = cursor.getColumnIndexOrThrow("_data");
                if (cursor.moveToFirst()) {
                    return cursor.getString(column_index);
                }
            } catch (Exception e) {
                // Eat it
            }
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }

        return null;
    }

    public static String getFileName(String filePath) {
        // /MyOUC/文件名.xxx
        if (TextUtils.isEmpty(filePath)) {
            return "";
        }
        int i = filePath.lastIndexOf("/");
        return filePath.substring(i + 1, filePath.length());
    }


    /**
     * 删除课程下载的所有文件
     *
     * @param courseName 课程名
     */
    public static void removeCourse(String courseName) {
        String dirPath = getDirPath(AppConstants.FilePath.COURSE_RESOURCE_PATH + "/" + courseName);
        File file = new File(dirPath);
        deleteFile(file);
    }

    public static void deleteFile(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File file1 : files) {
                deleteFile(file1);
            }
        } else {
            file.delete();
        }
    }
}
