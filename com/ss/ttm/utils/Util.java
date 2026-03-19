package com.ss.ttm.utils;

import android.os.Build;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class Util {
    public static final String BARND;
    public static final String DEVICE;
    public static final String DEVICE_DEBUG_INFO;
    public static final String HARDWARE;
    public static final String MANUFACTURER;
    public static final String MODEL;
    public static final int SDK_INT;

    static {
        int i = Build.VERSION.SDK_INT;
        SDK_INT = i;
        String str = Build.DEVICE;
        DEVICE = str;
        String str2 = Build.MANUFACTURER;
        MANUFACTURER = str2;
        String str3 = Build.MODEL;
        MODEL = str3;
        HARDWARE = Build.HARDWARE;
        BARND = Build.BRAND;
        DEVICE_DEBUG_INFO = str + ", " + str3 + ", " + str2 + ", " + i;
    }
}
