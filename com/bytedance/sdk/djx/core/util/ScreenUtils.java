package com.bytedance.sdk.djx.core.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.common.utility.DeviceUtils;
import com.bytedance.sdk.djx.utils.StatusBarUtil;
import com.bytedance.sdk.djx.utils.UIUtil;
import java.lang.reflect.InvocationTargetException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ScreenUtils {
    public static final int VIVO_FILLET = 8;
    public static final int VIVO_NOTCH = 32;

    public static boolean hasNotchScreen(Activity activity) {
        return getInt("ro.miui.notch", activity) == 1 || hasNotchAtHuawei(activity) || hasNotchAtOPPO(activity) || hasNotchAtVivo(activity) || isAndroidPHasNotch(activity);
    }

    public static int getNotchHeight(Context context) {
        if (context == null) {
            return 0;
        }
        if (RomUtils.isHuaweiDevice()) {
            return getNotchSizeAtHuawei(context)[1];
        }
        if (RomUtils.isColorOS()) {
            return getNotchSizeAtOppo(context)[1];
        }
        if (RomUtils.isFunTouchOS()) {
            return getNotchSizeAtVivo(context)[1];
        }
        return StatusBarUtil.getStatusBarHeight(context);
    }

    public static boolean isAndroidPHasNotch(Activity activity) throws ClassNotFoundException {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        try {
            Class<?> cls = Class.forName("android.view.WindowInsets");
            return cls.getMethod("getDisplayCutout", new Class[0]).invoke(cls, new Object[0]) != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int getInt(String str, Activity activity) throws ClassNotFoundException {
        if (!RomUtils.isMiui()) {
            return 0;
        }
        try {
            Class<?> clsLoadClass = activity.getClassLoader().loadClass("android.os.SystemProperties");
            return ((Integer) clsLoadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(clsLoadClass, str, new Integer(0))).intValue();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return 0;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return 0;
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return 0;
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
            return 0;
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            return 0;
        }
    }

    public static boolean hasNotchAtHuawei(Context context) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) clsLoadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(clsLoadClass, new Object[0])).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int[] getNotchSizeAtHuawei(Context context) {
        int[] iArr = {0, 0};
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return (int[]) clsLoadClass.getMethod("getNotchSize", new Class[0]).invoke(clsLoadClass, new Object[0]);
        } catch (Throwable unused) {
            return iArr;
        }
    }

    public static boolean hasNotchAtVivo(Context context) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) clsLoadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(clsLoadClass, 32)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int[] getNotchSizeAtVivo(Context context) {
        int[] iArr = {0, 0};
        iArr[0] = UIUtil.dp2px(100.0f);
        iArr[1] = UIUtil.dp2px(27.0f);
        return iArr;
    }

    public static boolean hasNotchAtOPPO(Context context) {
        return context.getPackageManager().hasSystemFeature(getKllkDecryptString("com.kllk.feature.screen.heteromorphism"));
    }

    public static int[] getNotchSizeAtOppo(Context context) {
        int[] iArr = {0, 0};
        iArr[0] = 324;
        iArr[1] = 80;
        return iArr;
    }

    public static String getKllkDecryptString(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.contains("KLLK")) {
            return str.replace("KLLK", DeviceUtils.ROM_OPPO);
        }
        return str.contains("kllk") ? str.replace("kllk", "oppo") : "";
    }
}
