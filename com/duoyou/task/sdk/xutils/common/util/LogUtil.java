package com.duoyou.task.sdk.xutils.common.util;

import android.text.TextUtils;
import android.util.Log;
import com.duoyou.task.sdk.xutils.x;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class LogUtil {
    public static String customTagPrefix = "x_log";

    private LogUtil() {
    }

    private static String generateTag() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        String className = stackTraceElement.getClassName();
        String str = String.format(Locale.getDefault(), "%s.%s(L:%d)", className.substring(className.lastIndexOf(".") + 1), stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber()));
        return TextUtils.isEmpty(customTagPrefix) ? str : customTagPrefix + ":" + str;
    }

    public static void d(String str) {
        if (!x.isDebug() || TextUtils.isEmpty(str)) {
            return;
        }
        Log.d(generateTag(), str);
    }

    public static void d(String str, Throwable th) {
        if (!x.isDebug() || TextUtils.isEmpty(str)) {
            return;
        }
        Log.d(generateTag(), str, th);
    }

    public static void e(String str) {
        if (!x.isDebug() || TextUtils.isEmpty(str)) {
            return;
        }
        Log.e(generateTag(), str);
    }

    public static void e(String str, Throwable th) {
        if (!x.isDebug() || TextUtils.isEmpty(str)) {
            return;
        }
        Log.e(generateTag(), str, th);
    }

    public static void i(String str) {
        if (!x.isDebug() || TextUtils.isEmpty(str)) {
            return;
        }
        Log.i(generateTag(), str);
    }

    public static void i(String str, Throwable th) {
        if (!x.isDebug() || TextUtils.isEmpty(str)) {
            return;
        }
        Log.i(generateTag(), str, th);
    }

    public static void v(String str) {
        if (!x.isDebug() || TextUtils.isEmpty(str)) {
            return;
        }
        Log.v(generateTag(), str);
    }

    public static void v(String str, Throwable th) {
        if (!x.isDebug() || TextUtils.isEmpty(str)) {
            return;
        }
        Log.v(generateTag(), str, th);
    }

    public static void w(String str) {
        if (!x.isDebug() || TextUtils.isEmpty(str)) {
            return;
        }
        Log.w(generateTag(), str);
    }

    public static void w(String str, Throwable th) {
        if (!x.isDebug() || TextUtils.isEmpty(str)) {
            return;
        }
        Log.w(generateTag(), str, th);
    }

    public static void w(Throwable th) {
        if (x.isDebug()) {
            Log.w(generateTag(), th);
        }
    }

    public static void wtf(String str) {
        if (!x.isDebug() || TextUtils.isEmpty(str)) {
            return;
        }
        Log.wtf(generateTag(), str);
    }

    public static void wtf(String str, Throwable th) {
        if (!x.isDebug() || TextUtils.isEmpty(str)) {
            return;
        }
        Log.wtf(generateTag(), str, th);
    }

    public static void wtf(Throwable th) {
        if (x.isDebug()) {
            Log.wtf(generateTag(), th);
        }
    }
}
