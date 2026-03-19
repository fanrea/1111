package com.fendasz.moku.planet.utils;

import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.m.c.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class HarmonyUtils {
    private static final String TAG = "HarmonyUtils==>";

    public static boolean isHarmonyOs() {
        return OSUtil.isHarmonyOS();
    }

    public static String getHarmonyVersion() {
        return getProp(a.b, "");
    }

    public static String getHarmonyVersion(String str) {
        return getProp(a.b, str);
    }

    public static String getHarmonyDisplayVersion() {
        return Build.DISPLAY;
    }

    private static String getProp(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str3 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
            return TextUtils.isEmpty(str3) ? str2 : str3;
        } catch (Throwable th) {
            th.printStackTrace();
            LogUtils.logD(TAG, "getProp exception");
            return str2;
        }
    }
}
