package com.luck.picture.lib.utils;

import android.os.Build;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class SdkVersionUtils {
    public static final int R = 30;
    public static final int TIRAMISU = 33;

    public static boolean isMinM() {
        return Build.VERSION.SDK_INT < 23;
    }

    public static boolean isO() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean isMaxN() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean isN() {
        return Build.VERSION.SDK_INT == 24;
    }

    public static boolean isP() {
        return Build.VERSION.SDK_INT >= 28;
    }

    public static boolean isQ() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public static boolean isR() {
        return Build.VERSION.SDK_INT >= 30;
    }

    public static boolean isTIRAMISU() {
        return Build.VERSION.SDK_INT >= 33;
    }
}
