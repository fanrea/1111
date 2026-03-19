package com.bytedance.pangle.log;

import android.text.TextUtils;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.sdk.openadsdk.api.an;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ZeusLogger {
    public static final String TAG = "Zeus_pangle";
    public static final String TAG_ACTIVITY = "Zeus/activity_pangle";
    public static final String TAG_DOWNLOAD = "Zeus/download_pangle";
    public static final String TAG_INIT = "Zeus/init_pangle";
    public static final String TAG_INSTALL = "Zeus/install_pangle";
    public static final String TAG_LOAD = "Zeus/load_pangle";
    public static final String TAG_PAM = "Zeus/pam_pangle";
    public static final String TAG_PPM = "Zeus/ppm_pangle";
    public static final String TAG_PROVIDER = "Zeus/provider_pangle";
    public static final String TAG_RECEIVER = "Zeus/receiver_pangle";
    public static final String TAG_REPORTER = "Zeus/reporter_pangle";
    public static final String TAG_RESOURCES = "Zeus/resources_pangle";
    public static final String TAG_SERVER = "Zeus/server_pangle";
    public static final String TAG_SERVICE = "Zeus/service_pangle";
    public static final String TAG_SO = "Zeus/so_pangle";
    private static boolean sDebug = true;
    private static boolean sEnableTrace = false;

    public static void setDebug(boolean z) {
        sDebug = z;
    }

    public static boolean isDebug() {
        return sDebug;
    }

    public static void setEnableTrace(boolean z) {
        sEnableTrace = z;
    }

    public static boolean isEnableTrace() {
        return sEnableTrace;
    }

    public static void v(String str) {
        v(null, str);
    }

    public static void v(String str, String str2) {
        String strPrefixTraceInfo = prefixTraceInfo(str2);
        GlobalParam.getInstance().getReporter().saveRecord(str, strPrefixTraceInfo);
        if (sDebug) {
            an.d(str, strPrefixTraceInfo);
        } else if (GlobalParam.getInstance().getLogger() != null) {
            GlobalParam.getInstance().getLogger().v(str, strPrefixTraceInfo);
        }
    }

    public static void d(String str) {
        d(null, str);
    }

    public static void d(String str, String str2) {
        i(str, str2);
    }

    public static void i(String str) {
        i(null, str);
    }

    public static void i(String str, String str2) {
        String strPrefixTraceInfo = prefixTraceInfo(str2);
        GlobalParam.getInstance().getReporter().saveRecord(str, strPrefixTraceInfo);
        if (sDebug) {
            an.b(str, strPrefixTraceInfo);
        } else if (GlobalParam.getInstance().getLogger() != null) {
            GlobalParam.getInstance().getLogger().i(str, strPrefixTraceInfo);
        }
    }

    public static void w(String str) {
        w(null, str);
    }

    public static void w(String str, String str2) {
        String strPrefixTraceInfo = prefixTraceInfo(str2);
        GlobalParam.getInstance().getReporter().saveRecord(str, strPrefixTraceInfo);
        if (sDebug) {
            an.c(str, strPrefixTraceInfo);
        } else if (GlobalParam.getInstance().getLogger() != null) {
            GlobalParam.getInstance().getLogger().w(str, strPrefixTraceInfo);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        String strPrefixTraceInfo = prefixTraceInfo(str2);
        GlobalParam.getInstance().getReporter().saveRecord(str, strPrefixTraceInfo + " ; " + th);
        if (sDebug) {
            an.c(str, strPrefixTraceInfo, th);
        } else if (GlobalParam.getInstance().getLogger() != null) {
            GlobalParam.getInstance().getLogger().w(str, strPrefixTraceInfo, th);
        }
    }

    public static void errReport(String str, String str2) {
        RuntimeException runtimeException = new RuntimeException();
        StackTraceElement[] stackTrace = runtimeException.getStackTrace();
        runtimeException.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, 1, stackTrace.length - 1));
        errReport(str, str2, runtimeException, false);
    }

    public static void errReport(String str, String str2, Throwable th) {
        errReport(str, str2, th, true);
    }

    private static void errReport(String str, String str2, Throwable th, boolean z) {
        GlobalParam.getInstance().getReporter().saveRecord(str, str2 + " ; " + th);
        if (sDebug) {
            if (!z) {
                th = null;
            }
            an.u(str, str2, th);
        } else if (GlobalParam.getInstance().getLogger() != null) {
            IZeusLogger logger = GlobalParam.getInstance().getLogger();
            if (!z) {
                th = null;
            }
            logger.e(str, str2, th);
        }
    }

    private static String prefixTraceInfo(String str) {
        return sEnableTrace ? str + getTraceInfo() : str;
    }

    private static String getTraceInfo() {
        try {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            StackTraceElement stackTraceElement = null;
            int i = 1;
            while (true) {
                if (i >= stackTrace.length) {
                    break;
                }
                if (!TextUtils.equals(stackTrace[i].getClassName(), ZeusLogger.class.getName())) {
                    stackTraceElement = stackTrace[i];
                    break;
                }
                i++;
            }
            return stackTraceElement != null ? "\t\t[" + stackTraceElement.toString() + "]" : "\t\t[No Trace Info]";
        } catch (Exception e) {
            an.d(e);
            return "\t\t[No Trace Info]";
        }
    }
}
