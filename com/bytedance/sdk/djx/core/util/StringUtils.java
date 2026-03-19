package com.bytedance.sdk.djx.core.util;

import android.text.TextUtils;
import java.util.Locale;
import java.util.regex.Pattern;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class StringUtils {
    private static final Pattern IMG_URL = Pattern.compile(".*?(gif|jpeg|png|jpg|bmp)");
    private static final Pattern URL = Pattern.compile("^(https|http)://.*?$(net|com|.com.cn|org|)");

    public static boolean isEmpty(String str) {
        if (str != null && !"".equals(str)) {
            for (int i = 0; i < str.length(); i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt != ' ' && cCharAt != '\t' && cCharAt != '\r' && cCharAt != '\n') {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isImgUrl(String str) {
        return (str == null || str.trim().length() == 0 || !IMG_URL.matcher(str).matches()) ? false : true;
    }

    public static boolean isUrl(String str) {
        return (str == null || str.trim().length() == 0 || !URL.matcher(str).matches()) ? false : true;
    }

    public static String format(String str, Object... objArr) {
        return String.format(Locale.getDefault(), str, objArr);
    }

    public static String reverse(String str) {
        return TextUtils.isEmpty(str) ? "" : new StringBuilder(str).reverse().toString();
    }

    public static boolean equals(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str == null || str2 == null || str.length() != str2.length()) {
            return false;
        }
        return str.equals(str2);
    }
}
