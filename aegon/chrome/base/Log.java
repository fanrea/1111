package aegon.chrome.base;

import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class Log {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static final String sDeprecatedTagPrefix = "cr.";
    private static final String sTagPrefix = "cr_";

    private Log() {
    }

    private static String formatLog(String str, Object... objArr) {
        return (objArr == null || objArr.length == 0) ? str : String.format(Locale.US, str, objArr);
    }

    public static String normalizeTag(String str) {
        if (str.startsWith(sTagPrefix)) {
            return str;
        }
        return sTagPrefix + str.substring(str.startsWith(sDeprecatedTagPrefix) ? 3 : 0, str.length());
    }

    private static String formatLogWithStack(String str, Object... objArr) {
        return "[" + getCallOrigin() + "] " + formatLog(str, objArr);
    }

    public static boolean isLoggable(String str, int i) {
        return android.util.Log.isLoggable(str, i);
    }

    private static void verbose(String str, String str2, Object... objArr) {
        String logWithStack = formatLogWithStack(str2, objArr);
        Throwable throwableToLog = getThrowableToLog(objArr);
        if (throwableToLog != null) {
            android.util.Log.v(normalizeTag(str), logWithStack, throwableToLog);
        } else {
            android.util.Log.v(normalizeTag(str), logWithStack);
        }
    }

    public static void v(String str, String str2) {
        verbose(str, str2, new Object[0]);
    }

    public static void v(String str, String str2, Object obj) {
        verbose(str, str2, obj);
    }

    public static void v(String str, String str2, Object obj, Object obj2) {
        verbose(str, str2, obj, obj2);
    }

    public static void v(String str, String str2, Object obj, Object obj2, Object obj3) {
        verbose(str, str2, obj, obj2, obj3);
    }

    public static void v(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        verbose(str, str2, obj, obj2, obj3, obj4);
    }

    public static void v(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        verbose(str, str2, obj, obj2, obj3, obj4, obj5);
    }

    public static void v(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        verbose(str, str2, obj, obj2, obj3, obj4, obj5, obj6);
    }

    public static void v(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        verbose(str, str2, obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    private static void debug(String str, String str2, Object... objArr) {
        String logWithStack = formatLogWithStack(str2, objArr);
        Throwable throwableToLog = getThrowableToLog(objArr);
        if (throwableToLog != null) {
            android.util.Log.d(normalizeTag(str), logWithStack, throwableToLog);
        } else {
            android.util.Log.d(normalizeTag(str), logWithStack);
        }
    }

    public static void d(String str, String str2) {
        debug(str, str2, new Object[0]);
    }

    public static void d(String str, String str2, Object obj) {
        debug(str, str2, obj);
    }

    public static void d(String str, String str2, Object obj, Object obj2) {
        debug(str, str2, obj, obj2);
    }

    public static void d(String str, String str2, Object obj, Object obj2, Object obj3) {
        debug(str, str2, obj, obj2, obj3);
    }

    public static void d(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        debug(str, str2, obj, obj2, obj3, obj4);
    }

    public static void d(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        debug(str, str2, obj, obj2, obj3, obj4, obj5);
    }

    public static void d(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        debug(str, str2, obj, obj2, obj3, obj4, obj5, obj6);
    }

    public static void d(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        debug(str, str2, obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    public static void i(String str, String str2, Object... objArr) {
        String log = formatLog(str2, objArr);
        Throwable throwableToLog = getThrowableToLog(objArr);
        if (throwableToLog != null) {
            android.util.Log.i(normalizeTag(str), log, throwableToLog);
        } else {
            android.util.Log.i(normalizeTag(str), log);
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        String log = formatLog(str2, objArr);
        Throwable throwableToLog = getThrowableToLog(objArr);
        if (throwableToLog != null) {
            android.util.Log.w(normalizeTag(str), log, throwableToLog);
        } else {
            android.util.Log.w(normalizeTag(str), log);
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        String log = formatLog(str2, objArr);
        Throwable throwableToLog = getThrowableToLog(objArr);
        if (throwableToLog != null) {
            android.util.Log.e(normalizeTag(str), log, throwableToLog);
        } else {
            android.util.Log.e(normalizeTag(str), log);
        }
    }

    public static void wtf(String str, String str2, Object... objArr) {
        String log = formatLog(str2, objArr);
        Throwable throwableToLog = getThrowableToLog(objArr);
        if (throwableToLog != null) {
            android.util.Log.wtf(normalizeTag(str), log, throwableToLog);
        } else {
            android.util.Log.wtf(normalizeTag(str), log);
        }
    }

    public static String getStackTraceString(Throwable th) {
        return android.util.Log.getStackTraceString(th);
    }

    private static Throwable getThrowableToLog(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        Object obj = objArr[objArr.length - 1];
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        return null;
    }

    private static String getCallOrigin() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = Log.class.getName();
        int i = 0;
        while (true) {
            if (i >= stackTrace.length) {
                break;
            }
            if (stackTrace[i].getClassName().equals(name)) {
                i += 4;
                break;
            }
            i++;
        }
        return stackTrace[i].getFileName() + ":" + stackTrace[i].getLineNumber();
    }
}
