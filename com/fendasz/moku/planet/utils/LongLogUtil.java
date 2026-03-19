package com.fendasz.moku.planet.utils;

import android.util.Log;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class LongLogUtil {
    private static final int MAX_STR_LENGTH = 1024;

    public static void i(String str, String str2) {
        int length = 1024 - str.length();
        while (str2.length() > length) {
            Log.i(str, str2.substring(0, length));
            str2 = str2.substring(length);
        }
        Log.i(str, str2);
    }

    public static void d(String str, String str2) {
        int length = 1024 - str.length();
        while (str2.length() > length) {
            Log.d(str, str2.substring(0, length));
            str2 = str2.substring(length);
        }
        Log.d(str, str2);
    }
}
