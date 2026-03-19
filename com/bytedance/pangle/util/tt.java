package com.bytedance.pangle.util;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.common.utility.DeviceUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class tt {
    public static boolean d() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public static boolean hc() {
        return Build.VERSION.SDK_INT > 22;
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT < 21;
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT <= 28;
    }

    public static boolean u() {
        return Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT <= 23;
    }

    public static boolean an() {
        return Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT < 23;
    }

    public static boolean h() {
        return Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT <= 25;
    }

    public static boolean gb() {
        return Build.VERSION.SDK_INT >= 26 && Build.VERSION.SDK_INT <= 28;
    }

    public static boolean tt() {
        return Build.VERSION.SDK_INT >= 29 && Build.VERSION.SDK_INT <= 30;
    }

    public static boolean tc() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean mk() {
        return Build.VERSION.SDK_INT > 23;
    }

    public static boolean mq() {
        return Build.VERSION.SDK_INT >= 24 && Build.VERSION.SDK_INT <= 25;
    }

    public static boolean uo() {
        return Build.VERSION.SDK_INT >= 24 && Build.VERSION.SDK_INT <= 28;
    }

    public static boolean k() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean e() {
        if (Build.VERSION.SDK_INT < 28) {
            return Build.VERSION.SDK_INT == 27 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }

    public static boolean cb() {
        if (Build.VERSION.SDK_INT < 29) {
            return Build.VERSION.SDK_INT == 28 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }

    public static boolean w() {
        return Build.VERSION.SDK_INT == 29;
    }

    public static boolean yo() {
        if (Build.VERSION.SDK_INT < 30) {
            return Build.VERSION.SDK_INT == 29 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }

    public static boolean rf() {
        if (Build.VERSION.SDK_INT < 31) {
            return Build.VERSION.SDK_INT == 30 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }

    public static boolean jh() {
        return TextUtils.equals(Build.BRAND.toLowerCase(), "huawei");
    }

    public static boolean sy() {
        return TextUtils.equals(Build.BRAND.toLowerCase(), DeviceUtils.ROM_SAMSUNG);
    }
}
