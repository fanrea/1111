package com.pandora.common.utils;

import android.util.Log;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class TTVideoLog {
    public static final String FORMAT = "<%s>%s";
    public static final int LOG_DEBUG = 1;
    public static final int LOG_ERROR = 6;
    public static final int LOG_INFO = 2;
    public static final int LOG_KILL = 4;
    public static final int LOG_TRACK = 3;
    public static final int LOG_VERBOSE = 0;
    public static final int LOG_WARN = 5;
    public static int LogTurnOn = 112;
    private static final String TAG = "TTVideoLog";

    public static final void turnOn(int level, int isTurnOn) {
        LogTurnOn = (isTurnOn << level) | ((~(1 << level)) & LogTurnOn);
    }

    public static final void i(String tag, String msg) {
        if (((LogTurnOn >> 2) & 1) == 1) {
            Log.i(TAG, String.format("<%s>%s", tag, msg));
        }
    }

    public static final void v(String tag, String msg) {
        if (((LogTurnOn >> 0) & 1) == 1) {
            Log.v(TAG, String.format("<%s>%s", tag, msg));
        }
    }

    public static void v(String tag, String msg, Throwable throwable) {
        if (((LogTurnOn >> 0) & 1) == 1) {
            Log.v(TAG, String.format("<%s>%s", tag, msg), throwable);
        }
    }

    public static final void d(String tag, String msg) {
        if (((LogTurnOn >> 1) & 1) == 1) {
            Log.d(TAG, String.format("<%s>%s", tag, msg));
        }
    }

    public static void d(String tag, String msg, Throwable throwable) {
        if (((LogTurnOn >> 1) & 1) == 1) {
            Log.d(TAG, String.format("<%s>%s", tag, msg), throwable);
        }
    }

    public static void d(Throwable throwable) {
        if (((LogTurnOn >> 1) & 1) == 1) {
            throwable.printStackTrace();
        }
    }

    public static final void w(String tag, String msg) {
        if (((LogTurnOn >> 5) & 1) == 1) {
            Log.w(TAG, String.format("<%s>%s", tag, msg));
        }
    }

    public static final void t(String tag, String msg) {
        if (((LogTurnOn >> 3) & 1) == 1) {
            Log.i(TAG, String.format("<%s>%s", tag, msg));
        }
    }

    public static final void k(String tag, String msg) {
        if (((LogTurnOn >> 4) & 1) == 1) {
            Log.i(TAG, String.format("<%s>%s", tag, msg));
        }
    }

    public static void e(String tag, String msg) {
        if (((LogTurnOn >> 6) & 1) == 1) {
            Log.e(TAG, String.format("<%s>%s", tag, msg));
        }
    }
}
