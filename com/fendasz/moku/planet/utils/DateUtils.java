package com.fendasz.moku.planet.utils;

import android.text.TextUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class DateUtils {
    public static Date getDate(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
        if (str == null) {
            return null;
        }
        try {
            return simpleDateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getFormatDate(long j, String str) {
        if (str == null || str.isEmpty()) {
            str = "yyyy-MM-dd HH:mm:ss";
        }
        return new SimpleDateFormat(str).format(new Date(j));
    }

    public static String getFormatDate(long j) {
        return getFormatDate(j, ":", ":", "");
    }

    public static String getFormatDate(long j, String str, String str2, String str3) {
        long j2 = j / 1000;
        long j3 = j2 % 60;
        long j4 = j2 / 60;
        long j5 = j4 % 60;
        long j6 = j4 / 60;
        StringBuilder sb = new StringBuilder();
        if (String.valueOf(j6).length() < 2) {
            sb.append("0");
        }
        sb.append(j6);
        if (TextUtils.isEmpty(str)) {
            sb.append(":");
        } else {
            sb.append(str);
        }
        if (String.valueOf(j5).length() < 2) {
            sb.append("0");
        }
        sb.append(j5);
        if (TextUtils.isEmpty(str2)) {
            sb.append(":");
        } else {
            sb.append(str2);
        }
        if (String.valueOf(j3).length() < 2) {
            sb.append("0");
        }
        sb.append(j3);
        if (!TextUtils.isEmpty(str3)) {
            sb.append(str3);
        }
        return sb.toString();
    }
}
