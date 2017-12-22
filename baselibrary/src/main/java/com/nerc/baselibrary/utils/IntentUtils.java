package com.nerc.baselibrary.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;

import com.orhanobut.logger.Logger;

import java.io.File;

/**
 * Created by nercdevAndroid on 2017/3/9.
 */

public class IntentUtils {


    public static void openHtml(Context context, String url) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        context.startActivity(intent);
    }

    public static void openPDF(Context context, File file) {
        Intent target = new Intent(Intent.ACTION_VIEW);

        Uri contentUri;
        if (Build.VERSION.SDK_INT >= 24) {
            target.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            String packageName = context.getApplicationContext().getPackageName();
            contentUri = FileProvider.getUriForFile(context,
                    packageName + ".provider",
                    file);
        } else {
            contentUri = Uri.fromFile(file);
        }

        target.setDataAndType(contentUri, "application/pdf");
        target.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        context.startActivity(target);
    }

    public static void openFile(Context context, File file) {
        Intent target = getOpenFileIntent(context, file, file.getName());
        context.startActivity(target);
    }


    public static Intent getOpenFileIntent(Context context, File file, String fileName) {
        Intent target = new Intent(Intent.ACTION_VIEW);

        Uri contentUri;
        if (Build.VERSION.SDK_INT >= 24) {
            target.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            String packageName = context.getApplicationContext().getPackageName();
            contentUri = FileProvider.getUriForFile(context,
                    packageName + ".provider",
                    file);
        } else {
            contentUri = Uri.fromFile(file);
        }

        String suf = getSuf(fileName);
        target.setDataAndType(contentUri, "application/" + suf);
//        LoggerUtils.d("open file: fileName" + fileName + "   suf:" + suf);
        target.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        return target;
    }

    private static String getSuf(String fileName) {
        if (TextUtils.isEmpty(fileName)) {
            return "";
        }
        String[] split = fileName.split("\\.");
        return split.length > 0 ? split[split.length - 1] : "";
    }

//    public static void openDir(Context context, String path) {
//        Intent intent = new Intent();
//        intent.setAction(android.content.Intent.ACTION_GET_CONTENT);
//        File file = new File(path);
//        intent.setDataAndType(Uri.fromFile(file), "*/*");
//        context.startActivity(intent);
//    }

    public static Intent getPhotoIntent() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        return intent;
    }

    public static Intent getTakePhotoIntent(Context context, String filePath) {
        Intent openCameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File file = new File(filePath);

        Uri imageUri;
        if (Build.VERSION.SDK_INT >= 24) {
            imageUri = FileProvider.getUriForFile(context,
                    context.getApplicationContext().getPackageName() + ".provider",
                    file);//通过FileProvider创建一个content类型的Uri
        } else {
            imageUri = Uri.fromFile(file);
        }
        Logger.d("图片文件存储在：" + filePath);

        openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        return openCameraIntent;
    }

    public static Intent getPickFileIntent() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        return intent;
    }

    public static Intent openFileIntent(Context context, String filePath) {

        File file = new File(filePath);
        if (!file.exists()) return null;
        /* 取得扩展名 */
        String end = file.getName().substring(file.getName().lastIndexOf(".") + 1, file.getName().length()).toLowerCase();
        /* 依扩展名的类型决定MimeType */
        if (end.equals("m4a") || end.equals("mp3") || end.equals("mid") ||
                end.equals("xmf") || end.equals("ogg") || end.equals("wav")) {
            return getAudioFileIntent(filePath);
        } else if (end.equals("3gp") || end.equals("mp4")) {
            return getAudioFileIntent(filePath);
        } else if (end.equals("jpg") || end.equals("gif") || end.equals("png") ||
                end.equals("jpeg") || end.equals("bmp")) {
            return getImageFileIntent(context, filePath);
        } else if (end.equals("apk")) {
            return getApkFileIntent(context, filePath);
        } else if (end.equals("ppt")) {
            return getPptFileIntent(context, filePath);
        } else if (end.equals("xls")) {
            return getExcelFileIntent(context, filePath);
        } else if (end.equals("doc") || end.equals("docx")) {
            return getWordFileIntent(context, filePath);
        } else if (end.equals("pdf")) {
            return getPdfFileIntent(context, filePath);
        } else if (end.equals("chm")) {
            return getChmFileIntent(context, filePath);
        } else if (end.equals("txt")) {
            return getTextFileIntent(context, filePath, false);
        } else {
            return getAllIntent(context, filePath);
        }
    }

    public static Intent openFileIntentNew(Context context, String filePath) {

        File temp_file = new File(filePath);
        Intent intent = new Intent();
        intent.setAction(android.content.Intent.ACTION_VIEW);
        intent.setDataAndType(getUri(context, temp_file), getMimeType(temp_file.getAbsolutePath()));
        return intent;
    }

    private static String getMimeType(String url) {
        String parts[] = url.split("\\.");
        String extension = parts[parts.length - 1];
        String type = null;
        if (extension != null) {
            MimeTypeMap mime = MimeTypeMap.getSingleton();
            type = mime.getMimeTypeFromExtension(extension);
        }
        return type;
    }

    //Android获取打开文件地址
    public static Intent getAllIntent(Context context, String param) {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(Intent.ACTION_VIEW);

        String folder = param.substring(0, param.lastIndexOf("/") + 1);
        File file = new File(folder);
        Uri uri = getUri(context, file);

        intent.setDataAndType(uri, "*/*");

        return intent;
    }

    //Android获取一个用于打开APK文件的intent
    public static Intent getApkFileIntent(Context context, String param) {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(Intent.ACTION_VIEW);
        File file = new File(param);
        Uri uri = getUri(context, file);
        intent.setDataAndType(uri, "application/vnd.android.package-archive");
        return intent;
    }

    //Android获取一个用于打开VIDEO文件的intent
    public static Intent getVideoFileIntent(String param) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("oneshot", 0);
        intent.putExtra("configchange", 0);
        Uri uri = Uri.fromFile(new File(param));
        intent.setDataAndType(uri, "video/*");
        return intent;
    }

    //Android获取一个用于打开AUDIO文件的intent
    public static Intent getAudioFileIntent(String param) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("oneshot", 0);
        intent.putExtra("configchange", 0);
        Uri uri = Uri.fromFile(new File(param));
        intent.setDataAndType(uri, "audio/*");
        return intent;
    }

    //Android获取一个用于打开Html文件的intent
    public static Intent getHtmlFileIntent(String param) {
        Uri uri = Uri.parse(param).buildUpon().encodedAuthority("com.android.htmlfileprovider").scheme("content").encodedPath(param).build();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(uri, "text/html");
        return intent;
    }

    //Android获取一个用于打开图片文件的intent
    public static Intent getImageFileIntent(Context context, String param) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        File file = new File(param);
        Uri uri = getUri(context, file);
        intent.setDataAndType(uri, "image/*");
        return intent;
    }

    private static Uri getUri(Context context, File file) {
        Uri uri;
        if (Build.VERSION.SDK_INT >= 24) {
            String packageName = context.getApplicationContext().getPackageName();
            uri = FileProvider.getUriForFile(context,
                    packageName + ".provider",
                    file);
        } else {
            uri = Uri.fromFile(file);
        }
        return uri;
    }

    //Android获取一个用于打开PPT文件的intent
    public static Intent getPptFileIntent(Context context, String param) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        File file = new File(param);
        Uri uri = getUri(context, file);
        intent.setDataAndType(uri, "application/vnd.ms-powerpoint");
        return intent;
    }

    //Android获取一个用于打开Excel文件的intent
    public static Intent getExcelFileIntent(Context context, String param) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        File file = new File(param);
        Uri uri = getUri(context, file);
        intent.setDataAndType(uri, "application/vnd.ms-excel");
        return intent;
    }

    //Android获取一个用于打开Word文件的intent
    public static Intent getWordFileIntent(Context context, String param) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        File file = new File(param);
        Uri uri = getUri(context, file);
        intent.setDataAndType(uri, "application/msword");
        return intent;
    }

    //Android获取一个用于打开CHM文件的intent
    public static Intent getChmFileIntent(Context context, String param) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        File file = new File(param);
        Uri uri = getUri(context, file);
        intent.setDataAndType(uri, "application/x-chm");
        return intent;
    }

    //Android获取一个用于打开文本文件的intent
    public static Intent getTextFileIntent(Context context, String param, boolean paramBoolean) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        File file = new File(param);

        if (paramBoolean) {
            Uri uri1 = Uri.parse(param);
            intent.setDataAndType(uri1, "text/plain");
        } else {
            Uri uri2 = getUri(context, file);
            intent.setDataAndType(uri2, "text/plain");
        }
        return intent;
    }

    //Android获取一个用于打开PDF文件的intentparam
    public static Intent getPdfFileIntent(Context context, String param) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        File file = new File(param);
        Uri uri;
        if (Build.VERSION.SDK_INT >= 24) {
            uri = FileProvider.getUriForFile(context,
                    context.getApplicationContext().getPackageName() + ".provider",
                    file);
        } else {
            uri = Uri.fromFile(file);
        }
        intent.setDataAndType(uri, "application/pdf");
        return intent;
    }

    public static Intent openFolder(Context context, String path) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        String folder = path.substring(0, path.lastIndexOf("/") + 1);
        File file = new File(path);
        Uri uri = getUri(context, file);

        intent.setDataAndType(uri, "resource/folder");




        return intent;
    }
}
