package com.lingku.xuanshang.xutils.common.util;

import android.text.TextUtils;
import android.util.Log;
import com.lingku.xuanshang.xutils.x;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class LogUtil {
    public static String customTagPrefix = "x_log";

    public static String a() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        String className = stackTraceElement.getClassName();
        String str = String.format(Locale.getDefault(), "%s.%s(L:%d)", className.substring(className.lastIndexOf(".") + 1), stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber()));
        return TextUtils.isEmpty(customTagPrefix) ? str : customTagPrefix + ":" + str;
    }

    public static void d(String str) {
        if (!x.isDebug() || TextUtils.isEmpty(str)) {
            return;
        }
        Log.d(a(), str);
    }

    public static void d(String str, Throwable th) {
        if (!x.isDebug() || TextUtils.isEmpty(str)) {
            return;
        }
        Log.d(a(), str, th);
    }

    public static void e(String str) {
        if (!x.isDebug() || TextUtils.isEmpty(str)) {
            return;
        }
        Log.e(a(), str);
    }

    public static void e(String str, Throwable th) {
        if (!x.isDebug() || TextUtils.isEmpty(str)) {
            return;
        }
        Log.e(a(), str, th);
    }

    public static void i(String str) {
        if (!x.isDebug() || TextUtils.isEmpty(str)) {
            return;
        }
        Log.i(a(), str);
    }

    public static void i(String str, Throwable th) {
        if (!x.isDebug() || TextUtils.isEmpty(str)) {
            return;
        }
        Log.i(a(), str, th);
    }

    public static void v(String str) {
        if (!x.isDebug() || TextUtils.isEmpty(str)) {
            return;
        }
        Log.v(a(), str);
    }

    public static void v(String str, Throwable th) {
        if (!x.isDebug() || TextUtils.isEmpty(str)) {
            return;
        }
        Log.v(a(), str, th);
    }

    public static void w(String str) {
        if (!x.isDebug() || TextUtils.isEmpty(str)) {
            return;
        }
        Log.w(a(), str);
    }

    public static void w(String str, Throwable th) {
        if (!x.isDebug() || TextUtils.isEmpty(str)) {
            return;
        }
        Log.w(a(), str, th);
    }

    public static void w(Throwable th) {
        if (x.isDebug()) {
            Log.w(a(), th);
        }
    }

    public static void wtf(String str) {
        if (!x.isDebug() || TextUtils.isEmpty(str)) {
            return;
        }
        Log.wtf(a(), str);
    }

    public static void wtf(String str, Throwable th) {
        if (!x.isDebug() || TextUtils.isEmpty(str)) {
            return;
        }
        Log.wtf(a(), str, th);
    }

    public static void wtf(Throwable th) {
        if (x.isDebug()) {
            Log.wtf(a(), th);
        }
    }
}
