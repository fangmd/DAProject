package com.nerc.baselibrary.utils;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;

/**
 * StringUtils
 * Created by nerc on 2017/10/31.
 */

public class StringUtils {

    /**
     * 搜索的时候使用
     */
    public static SpannableString getSpannableStringForSearch(String keyword, String content) {
        if (TextUtils.isEmpty(keyword)) {
            return new SpannableString(content);
        }

        if (TextUtils.isEmpty(content)) {
            return new SpannableString("");
        }

        SpannableString ret = new SpannableString(content);
        for (int i = 0; i < keyword.length(); i++) {
            char c = keyword.charAt(i);

            int position = 0;
            for (; ; ) {
                position = content.indexOf(c, position);
                if (position == -1) {
                    break;
                }
                setRedOnChar(ret, position);
                position++;
            }
        }
        LoggerUtils.d(ret.toString());
        return ret;
    }

    private static void setRedOnChar(SpannableString ret, int position) {
        ret.setSpan(new ForegroundColorSpan(Color.parseColor("#ff4c48")), position,
                position + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    }


    /**
     * 来自#生活小技巧#
     */
    public static SpannableString getSpannableStringFrom(String str) {
        if (TextUtils.isEmpty(str)) {
            return new SpannableString("来自##");
        }
        SpannableString ret = new SpannableString("来自#" + str + "#");
        ret.setSpan(new ForegroundColorSpan(Color.parseColor("#1ac1a0")), 2,
                2 + str.length() + 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return ret;
    }
}
