package com.pandora.ttlicense2.utils;

import android.util.Log;
import com.bytedance.sdk.djx.core.log.ILogConst;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class L {
    public static boolean ENABLE_LOG = false;
    private static final String TAG = "TTLicense";

    private L() {
    }

    public static void v(Object o, String method, Object... messages) {
        if (ENABLE_LOG) {
            Log.v(TAG, createLog(o, method, messages));
        }
    }

    public static void v(Object o, String method, Throwable throwable, Object... messages) {
        if (ENABLE_LOG) {
            Log.v(TAG, createLog(o, method, messages), throwable);
        }
    }

    public static void d(Object o, String method, Object... messages) {
        if (ENABLE_LOG) {
            Log.d(TAG, createLog(o, method, messages));
        }
    }

    public static void d(Object o, String method, Throwable throwable, Object... messages) {
        if (ENABLE_LOG) {
            Log.d(TAG, createLog(o, method, messages), throwable);
        }
    }

    public static void i(Object o, String method, Object... messages) {
        if (ENABLE_LOG) {
            Log.i(TAG, createLog(o, method, messages));
        }
    }

    public static void i(Object o, String method, Throwable throwable, Object... messages) {
        if (ENABLE_LOG) {
            Log.i(TAG, createLog(o, method, messages), throwable);
        }
    }

    public static void e(Object o, String method, Object... messages) {
        if (ENABLE_LOG) {
            Log.e(TAG, createLog(o, method, messages));
        }
    }

    public static void e(Object o, String method, Throwable throwable, Object... messages) {
        if (ENABLE_LOG) {
            Log.e(TAG, createLog(o, method, messages), throwable);
        }
    }

    public static void w(Object o, String method, Object... messages) {
        if (ENABLE_LOG) {
            Log.w(TAG, createLog(o, method, messages));
        }
    }

    public static void w(Object o, String method, Throwable throwable, Object... messages) {
        if (ENABLE_LOG) {
            Log.w(TAG, createLog(o, method, messages), throwable);
        }
    }

    private static String createLog(Object o, String method, Object... messages) {
        StringBuilder sbAppend = new StringBuilder(obj2String(o)).append(" -> ").append(method);
        if (messages != null) {
            for (Object obj : messages) {
                sbAppend.append(" -> ").append(obj2String(obj));
            }
        }
        return sbAppend.toString();
    }

    public static String string(Object o) {
        return o == null ? ILogConst.CACHE_PLAY_REASON_NULL : ENABLE_LOG ? o.toString() : "";
    }

    public static String obj2String(Object o) {
        if (o == null) {
            return ILogConst.CACHE_PLAY_REASON_NULL;
        }
        if (o instanceof String) {
            return (String) o;
        }
        if (o instanceof Boolean) {
            return String.valueOf(o);
        }
        if (o instanceof Number) {
            return String.valueOf(o);
        }
        if (o.getClass().isAnonymousClass()) {
            String string = o.toString();
            return string.substring(string.lastIndexOf(46));
        }
        return o.getClass().getSimpleName() + '@' + Integer.toHexString(o.hashCode());
    }
}
