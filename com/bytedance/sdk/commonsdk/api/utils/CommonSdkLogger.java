package com.bytedance.sdk.commonsdk.api.utils;

import android.text.TextUtils;
import android.util.Log;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class CommonSdkLogger {
    public static boolean DEBUG = false;
    private static final String ROOT = "DJXSdk";
    private static final String TAG = "DJXSdk";

    private CommonSdkLogger() {
    }

    public static void v(String str) {
        v("DJXSdk", str);
    }

    public static void v(String str, String str2) {
        v(str, str2, null);
    }

    public static void v(String str, String str2, Throwable th) {
        if (DEBUG) {
            Log.v(tag(str), str2, th);
        }
    }

    public static void d(String str) {
        d("DJXSdk", str);
    }

    public static void d(String str, String str2) {
        d(str, str2, null);
    }

    public static void d(String str, String str2, Throwable th) {
        if (DEBUG) {
            Log.d(tag(str), str2, th);
        }
    }

    public static void i(String str) {
        i("DJXSdk", str);
    }

    public static void i(String str, String str2) {
        i(str, str2, null);
    }

    public static void i(String str, String str2, Throwable th) {
        if (DEBUG) {
            Log.i(tag(str), str2, th);
        }
    }

    public static void w(String str) {
        w("DJXSdk", str);
    }

    public static void w(String str, String str2) {
        w(str, str2, null);
    }

    public static void w(String str, String str2, Throwable th) {
        if (DEBUG) {
            Log.w(tag(str), str2, th);
        }
    }

    public static void e(String str) {
        e("DJXSdk", str);
    }

    public static void e(String str, String str2) {
        e(str, str2, null);
    }

    public static void e(String str, String str2, Throwable th) {
        if (DEBUG) {
            Log.e(tag(str), str2, th);
        }
    }

    private static String tag(String str) {
        StringBuilder sbAppend = new StringBuilder().append("DJXSdk-");
        if (TextUtils.isEmpty(str)) {
            str = "DJXSdk";
        }
        return sbAppend.append(str).toString();
    }
}
