package com.baidu.mobads.container.util;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowInsets;
import androidx.constraintlayout.core.motion.utils.TypedValues;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class bg {
    private static final String a = "ONEPLUS A6000";
    private static final String b = "Hisense";

    public static boolean a(Context context) {
        if (x.a(context).a() < 24) {
            return false;
        }
        String strE = x.a(context).e();
        if ("HUAWEI".equalsIgnoreCase(strE) || "HONOR".equalsIgnoreCase(strE)) {
            return e(context);
        }
        if ("XIAOMI".equalsIgnoreCase(strE) || "REDMI".equalsIgnoreCase(strE)) {
            return d(context);
        }
        if (com.bytedance.common.utility.DeviceUtils.ROM_OPPO.equalsIgnoreCase(strE)) {
            return g(context);
        }
        if (com.bytedance.common.utility.DeviceUtils.ROM_VIVO.equalsIgnoreCase(strE)) {
            return f(context);
        }
        if (a.equalsIgnoreCase(x.a(context).d()) || b.equalsIgnoreCase(strE)) {
            return true;
        }
        return "SAMSUNG".equalsIgnoreCase(strE) && c(context);
    }

    public static boolean a(View view) {
        WindowInsets rootWindowInsets;
        return (x.a(null).a() < 28 || view == null || (rootWindowInsets = view.getRootWindowInsets()) == null || rootWindowInsets.getDisplayCutout() == null) ? false : true;
    }

    public static boolean a(Context context, View view) {
        return a(view) || a(context);
    }

    public static boolean b(Context context) {
        boolean z = x.a(context).a() >= 17 && Settings.Global.getInt(context.getContentResolver(), "force_black", 0) == 1;
        return z || (Settings.Secure.getInt(context.getContentResolver(), "dtsplay_notch_status", 0) == 1);
    }

    private static boolean c(Context context) {
        try {
            if (x.a(context).a() != 26) {
                return false;
            }
            return !TextUtils.isEmpty(context.getResources().getIdentifier("config_mainBuiltInDisplayCutout", TypedValues.Custom.S_STRING, "android") > 0 ? r4.getString(r1) : null);
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean d(Context context) throws ClassNotFoundException {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return ((Integer) clsLoadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(clsLoadClass, "ro.miui.notch", 0)).intValue() == 1;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean e(Context context) throws ClassNotFoundException {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) clsLoadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(clsLoadClass, new Object[0])).booleanValue();
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean f(Context context) throws ClassNotFoundException {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) clsLoadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(clsLoadClass, 32)).booleanValue();
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean g(Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }
}
