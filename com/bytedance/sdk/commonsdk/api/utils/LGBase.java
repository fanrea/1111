package com.bytedance.sdk.commonsdk.api.utils;

import android.text.TextUtils;
import android.util.Log;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class LGBase {
    private static final String ROOT = "LGBase";
    private static final String TAG = "LGBase";
    private static boolean sIsDebugMode = false;

    private LGBase() {
    }

    public static void v(String str) {
        v("LGBase", str);
    }

    public static void v(String str, String str2) {
        v(str, str2, null);
    }

    public static void v(String str, String str2, Throwable th) {
        if (isDebugMode()) {
            Log.v(tag(str), str2, th);
        }
    }

    public static void d(String str) {
        d("LGBase", str);
    }

    public static void d(String str, String str2) {
        d(str, str2, null);
    }

    public static void d(String str, String str2, Throwable th) {
        if (isDebugMode()) {
            Log.d(tag(str), str2, th);
        }
        AdCLogHelper.d(tag(str), str2, th);
    }

    public static void i(String str) {
        i("LGBase", str);
    }

    public static void i(String str, String str2) {
        i(str, str2, null);
    }

    public static void i(String str, String str2, Throwable th) {
        if (isDebugMode()) {
            Log.i(tag(str), str2, th);
        }
        AdCLogHelper.i(tag(str), str2, th);
    }

    public static void w(String str) {
        w("LGBase", str);
    }

    public static void w(String str, String str2) {
        w(str, str2, null);
    }

    public static void w(String str, String str2, Throwable th) {
        if (isDebugMode()) {
            Log.w(tag(str), str2, th);
        }
        AdCLogHelper.w(tag(str), str2, th);
    }

    public static void e(String str) {
        e("LGBase", str);
    }

    public static void e(String str, String str2) {
        e(str, str2, null);
    }

    public static void e(String str, String str2, Throwable th) {
        if (isDebugMode()) {
            Log.e(tag(str), str2, th);
        }
        AdCLogHelper.e(tag(str), str2, th);
    }

    private static String tag(String str) {
        StringBuilder sbAppend = new StringBuilder().append("LGBase-");
        if (TextUtils.isEmpty(str)) {
            str = "LGBase";
        }
        return sbAppend.append(str).toString();
    }

    private static boolean isDebugMode() {
        return sIsDebugMode;
    }

    public static void init(boolean z) {
        sIsDebugMode = z;
    }
}
