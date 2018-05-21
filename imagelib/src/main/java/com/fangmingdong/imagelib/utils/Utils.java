package com.fangmingdong.imagelib.utils;

import android.content.Context;
import android.content.pm.PackageManager;

/**
 * Author: Created by fangmingdong on 2018/5/9-上午9:12
 * Description:
 */
public class Utils {

    /**
     * 检查是否有外部读写权限
     *
     * @param context Context
     * @return 返回
     */
    public static boolean checkWriteExternalPermission(Context context) {
        String permission = android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
        int res = context.checkCallingOrSelfPermission(permission);
        return (res == PackageManager.PERMISSION_GRANTED);
    }
}
