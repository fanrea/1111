package com.apm.insight.o;

import android.util.Log;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class q {
    public static void a(Object obj) {
        if (com.apm.insight.g.h().isDebugMode()) {
            Log.i("npth", String.valueOf(obj));
        }
    }

    public static void a(String str) {
        if (com.apm.insight.g.h().isDebugMode()) {
            Log.w("npth", str);
        }
    }

    public static void a(String str, Object obj) {
        if (com.apm.insight.g.h().isDebugMode()) {
            Log.i("npth", str + " " + obj);
        }
    }

    public static void a(String str, Object obj, Throwable th) {
        if (com.apm.insight.g.h().isDebugMode()) {
            Log.e("npth", str + " " + obj, th);
        }
    }

    public static void a(String str, Throwable th) {
        if (com.apm.insight.g.h().isDebugMode()) {
            Log.e("npth", str + " NPTH Catch Error", th);
        }
    }

    public static void a(Throwable th) {
        if (com.apm.insight.g.h().isDebugMode()) {
            Log.e("npth", "NPTH Catch Error", th);
        }
    }

    public static void b(Object obj) {
        if (com.apm.insight.g.h().isDebugMode()) {
            Log.d("npth", String.valueOf(obj));
        }
    }

    public static void b(Throwable th) {
        if (com.apm.insight.g.h().isDebugMode()) {
            Log.w("npth", "NPTH Catch Error", th);
        }
    }
}
