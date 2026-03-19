package com.bytedance.sdk.component.d;

import android.util.Log;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class tt {
    private static boolean d;

    static void d(boolean z) {
        d = z;
    }

    static void d(String str) {
        if (d) {
            com.bytedance.sdk.component.utils.mq.d("JsBridge2", str);
        }
    }

    static void hc(String str) {
        if (d) {
            com.bytedance.sdk.component.utils.mq.hc("JsBridge2", str);
        }
    }

    static void d(String str, Throwable th) {
        if (d) {
            com.bytedance.sdk.component.utils.mq.hc("JsBridge2", str, th);
            com.bytedance.sdk.component.utils.mq.hc("JsBridge2", "Stacktrace: " + Log.getStackTraceString(th));
        }
    }

    static void hc(String str, Throwable th) {
        if (d) {
            com.bytedance.sdk.component.utils.mq.b("JsBridge2", str, th);
            com.bytedance.sdk.component.utils.mq.c("JsBridge2", "Stacktrace: " + Log.getStackTraceString(th));
        }
    }

    static void d(RuntimeException runtimeException) {
        if (d) {
            throw runtimeException;
        }
    }
}
