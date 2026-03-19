package com.kwad.sdk.live.audience.test;

import com.bytedance.sdk.djx.core.log.ILogConst;
import com.kwad.sdk.live.audience.KSLiveInitModule;
import com.kwad.sdk.live.audience.KSLiveLog;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KSLiveLogger {
    private static final String LOG_TAG = "KSLiveSDK";
    private static final String SPACE = "   ";
    private static final KSLiveLog sLog = KSLiveInitModule.getInstance().getLog();

    public static void i(String str) {
        KSLiveLog kSLiveLog = sLog;
        if (kSLiveLog != null) {
            kSLiveLog.i(LOG_TAG, str);
        }
    }

    public static void i(String str, String str2, Object obj) {
        KSLiveLog kSLiveLog = sLog;
        if (kSLiveLog != null) {
            kSLiveLog.i(LOG_TAG, str + SPACE + str2 + "=" + string(obj));
        }
    }

    public static void i(String str, String str2, Object obj, String str3, Object obj2) {
        KSLiveLog kSLiveLog = sLog;
        if (kSLiveLog != null) {
            kSLiveLog.i(LOG_TAG, str + SPACE + str2 + "=" + string(obj) + SPACE + str3 + "=" + string(obj2));
        }
    }

    public static void i(String str, String str2, Object obj, String str3, Object obj2, String str4, Object obj3) {
        KSLiveLog kSLiveLog = sLog;
        if (kSLiveLog != null) {
            kSLiveLog.i(LOG_TAG, str + SPACE + str2 + "=" + string(obj) + SPACE + str3 + "=" + string(obj2) + SPACE + str4 + "=" + string(obj3));
        }
    }

    public static void e(String str, Throwable th) {
        KSLiveLog kSLiveLog = sLog;
        if (kSLiveLog != null) {
            kSLiveLog.e(LOG_TAG, str, th);
        }
    }

    public static void e(String str, String str2, Object obj, Throwable th) {
        KSLiveLog kSLiveLog = sLog;
        if (kSLiveLog != null) {
            kSLiveLog.e(LOG_TAG, str + SPACE + str2 + "=" + string(obj), th);
        }
    }

    public static void e(String str, String str2, Object obj, String str3, Object obj2, Throwable th) {
        KSLiveLog kSLiveLog = sLog;
        if (kSLiveLog != null) {
            kSLiveLog.e(LOG_TAG, str + SPACE + str2 + "=" + string(obj) + SPACE + str3 + "=" + string(obj2), th);
        }
    }

    public static void e(String str, String str2, Object obj, String str3, Object obj2, String str4, Object obj3, Throwable th) {
        KSLiveLog kSLiveLog = sLog;
        if (kSLiveLog != null) {
            kSLiveLog.e(LOG_TAG, str + SPACE + str2 + "=" + string(obj) + SPACE + str3 + "=" + string(obj2) + SPACE + str4 + "=" + string(obj3), th);
        }
    }

    private static String string(Object obj) {
        return obj == null ? ILogConst.CACHE_PLAY_REASON_NULL : obj.toString();
    }
}
