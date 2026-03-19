package com.fendasz.moku.planet.utils;

import android.util.Log;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class LogUtils {
    private static boolean isPrintLog = false;

    public static void log(String str, String str2) {
        if (isPrintLog) {
            Log.e(str, "Moku >> " + str2);
        }
    }

    public static void logT(String str) {
        if (isPrintLog) {
            System.out.println("Trailwalker >> " + str);
        }
    }

    public static void logT(String str, String str2) {
        if (isPrintLog) {
            Log.e(str, "Trailwalker >> " + str2);
        }
    }

    public static void logE(String str, String str2) {
        if (isPrintLog) {
            Log.e(str, str2);
        }
    }

    public static void logW(String str, String str2) {
        if (isPrintLog) {
            Log.w(str, str2);
        }
    }

    public static void logI(String str, String str2) {
        if (isPrintLog) {
            Log.i(str, str2);
        }
    }

    public static void logD(String str, String str2) {
        if (isPrintLog) {
            Log.d(str, str2);
        }
    }

    public static void logV(String str, String str2) {
        if (isPrintLog) {
            Log.v(str, str2);
        }
    }

    public static void longLogD(String str, String str2) {
        int length = 2001 - str.length();
        while (str2.length() > length) {
            Log.d(str, str2.substring(0, length));
            str2 = str2.substring(length);
        }
        Log.d(str, str2);
    }

    public static void longLogD(String str, String str2, String str3) {
        int length = 2001 - str.length();
        while (str2.length() > length) {
            Log.d(str, str2.substring(0, length).concat(str3));
            str2 = str2.substring(length);
        }
        Log.d(str, str2);
    }

    public static void main(String[] strArr) {
        longLogD("MAIN==>", new StringBuilder("12345").toString());
    }
}
