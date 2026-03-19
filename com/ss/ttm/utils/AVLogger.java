package com.ss.ttm.utils;

import android.util.Log;
import androidx.core.internal.view.SupportMenu;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class AVLogger {
    public static final boolean DEBUG = false;
    public static final String FORMAT = "<%s,%x>%s";
    public static final int LEVEL_LOG_ALL = 0;
    public static final int LEVEL_LOG_DEBUG = 16777216;
    public static final int LEVEL_LOG_ERROR = 67108864;
    public static final int LEVEL_LOG_FATAL = 83886080;
    public static final int LEVEL_LOG_INFO = 33554432;
    public static final int LEVEL_LOG_INFO_KILL = 34603008;
    public static final int LEVEL_LOG_INFO_TRACK_FUNC = 42860544;
    public static final int LEVEL_LOG_INFO_TRACK_LIFE = 42926080;
    public static final int LEVEL_LOG_SILENT = 100663296;
    public static final int LEVEL_LOG_VERBOSE = 0;
    public static final int LEVEL_LOG_WARN = 50331648;
    private static final String TAG = "ttmj";
    private static final String TTVideoEngineLog = "com.ss.ttvideoengine.utils.TTVideoEngineLog";
    private static int gLogLevel = 33554432;
    private static Method methodLogD;
    private static Method methodLogE;
    private static Method methodLogI;
    private static Method methodLogW;
    private static Class<?> objectTTVideoEngineLog;

    public static void Debug(String str, Object obj, String str2) {
    }

    public static void Verbose(String str, Object obj, String str2) {
    }

    public static void setLogLevel(int i) {
        gLogLevel = i;
    }

    public static void v(String str, String str2) {
        Verbose(str, null, str2);
    }

    public static void d(String str, String str2) {
        Debug(str, null, str2);
    }

    public static void i(String str, String str2) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        Info(str, null, str2);
    }

    public static void k(String str, String str2) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        InfoKill(str, null, str2);
    }

    public static void w(String str, String str2) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        Warn(str, null, str2);
    }

    public static void e(String str, String str2) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        Error(str, null, str2);
    }

    public static void Info(String str, Object obj, String str2) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        log(LEVEL_LOG_INFO, str, obj, str2);
    }

    public static void InfoKill(String str, Object obj, String str2) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        log(LEVEL_LOG_INFO_KILL, str, obj, str2);
    }

    public static void InfoTrackFunc(String str, Object obj, String str2) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        log(LEVEL_LOG_INFO_TRACK_FUNC, str, obj, str2);
    }

    public static void InfoTrackLife(String str, Object obj, String str2) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        log(LEVEL_LOG_INFO_TRACK_LIFE, str, obj, str2);
    }

    public static void Warn(String str, Object obj, String str2) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        log(LEVEL_LOG_WARN, str, obj, str2);
    }

    public static void Error(String str, Object obj, String str2) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        log(67108864, str, obj, str2);
    }

    private static void log(int i, String str, Object obj, String str2) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (i < (gLogLevel & SupportMenu.CATEGORY_MASK)) {
            return;
        }
        if (objectTTVideoEngineLog == null) {
            try {
                Class<?> cls = Class.forName(TTVideoEngineLog);
                objectTTVideoEngineLog = cls;
                if (cls != null) {
                    methodLogD = cls.getMethod("d", String.class, String.class);
                    methodLogI = objectTTVideoEngineLog.getMethod("i", String.class, String.class);
                    methodLogW = objectTTVideoEngineLog.getMethod("w", String.class, String.class);
                    methodLogE = objectTTVideoEngineLog.getMethod("e", String.class, String.class);
                }
            } catch (Exception e) {
                objectTTVideoEngineLog = null;
                Log.e(TAG, "reflect failed! e:" + e);
                return;
            }
        }
        Locale locale = Locale.US;
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = Integer.valueOf(obj == null ? 0 : obj.hashCode());
        objArr[2] = str2;
        String str3 = String.format(locale, FORMAT, objArr);
        try {
            if (i == 0 || i == 16777216) {
                methodLogD.invoke(objectTTVideoEngineLog, TAG, str3);
            } else if (i == 33554432 || i == 34603008 || i == 42860544 || i == 42926080) {
                methodLogI.invoke(objectTTVideoEngineLog, TAG, str3);
            } else if (i == 50331648) {
                methodLogW.invoke(objectTTVideoEngineLog, TAG, str3);
            } else if (i != 67108864) {
            } else {
                methodLogE.invoke(objectTTVideoEngineLog, TAG, str3);
            }
        } catch (Exception e2) {
            Log.e(TAG, "invoke failed! e:" + e2);
        }
    }
}
