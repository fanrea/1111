package com.luck.picture.lib.utils;

import android.content.Context;
import com.luck.picture.lib.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class DateUtils {
    private static final SimpleDateFormat SF = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM");
    private static final SimpleDateFormat SDF_YEAR = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static long getCurrentTimeMillis() {
        String string = ValueOf.toString(Long.valueOf(System.currentTimeMillis()));
        if (string.length() > 10) {
            string = string.substring(0, 10);
        }
        return ValueOf.toLong(string);
    }

    public static String getDataFormat(Context context, long j) {
        if (String.valueOf(j).length() <= 10) {
            j *= 1000;
        }
        if (isThisWeek(j)) {
            return context.getString(R.string.ps_current_week);
        }
        if (isThisMonth(j)) {
            return context.getString(R.string.ps_current_month);
        }
        return SDF.format(Long.valueOf(j));
    }

    public static String getYearDataFormat(long j) {
        if (String.valueOf(j).length() <= 10) {
            j *= 1000;
        }
        return SDF_YEAR.format(Long.valueOf(j));
    }

    private static boolean isThisWeek(long j) {
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(3);
        calendar.setTime(new Date(j));
        return calendar.get(3) == i;
    }

    public static boolean isThisMonth(long j) {
        Date date = new Date(j);
        SimpleDateFormat simpleDateFormat = SDF;
        return simpleDateFormat.format(date).equals(simpleDateFormat.format(new Date()));
    }

    public static long millisecondToSecond(long j) {
        return (j / 1000) * 1000;
    }

    public static int dateDiffer(long j) {
        try {
            return (int) Math.abs(getCurrentTimeMillis() - j);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static String formatDurationTime(long j) {
        String str = j < 0 ? "-" : "";
        long jAbs = Math.abs(j) / 1000;
        long j2 = jAbs % 60;
        long j3 = (jAbs / 60) % 60;
        long j4 = jAbs / 3600;
        return j4 > 0 ? String.format(Locale.getDefault(), "%s%d:%02d:%02d", str, Long.valueOf(j4), Long.valueOf(j3), Long.valueOf(j2)) : String.format(Locale.getDefault(), "%s%02d:%02d", str, Long.valueOf(j3), Long.valueOf(j2));
    }

    public static String getCreateFileName(String str) {
        return str + SF.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static String getCreateFileName() {
        return SF.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static String cdTime(long j, long j2) {
        StringBuilder sbAppend;
        String str;
        long j3 = j2 - j;
        if (j3 > 1000) {
            sbAppend = new StringBuilder().append(j3 / 1000);
            str = "秒";
        } else {
            sbAppend = new StringBuilder().append(j3);
            str = "毫秒";
        }
        return sbAppend.append(str).toString();
    }
}
