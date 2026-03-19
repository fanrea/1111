package com.pandora.common.utils;

import android.text.TextUtils;
import android.text.format.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class TimeUtil {
    public static long getAndroidMillis(final long seconds) {
        return seconds * 1000;
    }

    private TimeUtil() {
    }

    public static Calendar getCalendar(final long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar;
    }

    public static long getUtcMillis(final long millis) {
        return millis - getCalendar(millis).get(15);
    }

    public static long getMillis(final long millis) {
        return getUtcMillis(millis) + Times.UTC_8_OFFSET;
    }

    public static long getPhpSeconds(final long millis) {
        return millis / 1000;
    }

    public static long getCurMillis() {
        return getMillis(System.currentTimeMillis());
    }

    public static int getCurSeconds() {
        return (int) (getCurMillis() / 1000);
    }

    public static String getCurDateText() {
        return format(getCurMillis(), Times.YYYY_MM_DD);
    }

    public static String getCurDateTimeText() {
        return format(getCurMillis(), Times.YYYY_MM_DD_KK_MM_SS);
    }

    public static long parseMillis(final String dateText, final String fmt) throws ParseException {
        if (TextUtils.isEmpty(dateText)) {
            throw new NullPointerException("dateText不能为空");
        }
        if (TextUtils.isEmpty(fmt)) {
            throw new NullPointerException("fmt不能为空");
        }
        return new SimpleDateFormat(fmt, Locale.getDefault()).parse(dateText).getTime();
    }

    public static String format(final long millis, final String fmt) {
        if (TextUtils.isEmpty(fmt)) {
            throw new NullPointerException("fmt不能为空");
        }
        return (String) DateFormat.format(fmt, millis);
    }

    public static String format(final String inDateText, final String inFmt, final String outFmt) throws ParseException {
        if (TextUtils.isEmpty(inDateText)) {
            throw new NullPointerException("inDateText不能为空");
        }
        if (TextUtils.isEmpty(inFmt)) {
            throw new NullPointerException("inFmt不能为空");
        }
        if (TextUtils.isEmpty(outFmt)) {
            throw new NullPointerException("outFmt不能为空");
        }
        return format(parseMillis(inDateText, inFmt), outFmt);
    }

    public static String modDays(final String timeText, final String format, final int days) throws ParseException {
        if (TextUtils.isEmpty(timeText)) {
            throw new NullPointerException("timeText不能为空");
        }
        if (TextUtils.isEmpty(format)) {
            throw new NullPointerException("format不能为空");
        }
        Calendar calendar = getCalendar(parseMillis(timeText, format));
        calendar.set(5, calendar.get(5) + days);
        return format(calendar.getTimeInMillis(), format);
    }

    public static boolean isThisYear(final String timeText, final String format) throws ParseException {
        if (TextUtils.isEmpty(timeText)) {
            throw new NullPointerException("timeText不能为空");
        }
        if (TextUtils.isEmpty(format)) {
            throw new NullPointerException("format不能为空");
        }
        return getCalendar(parseMillis(timeText, format)).get(1) == Calendar.getInstance().get(1);
    }

    public static long getRelativeDays(long lastMillis) {
        return (getCurMillis() - getAndroidMillis(lastMillis)) / 86400000;
    }
}
