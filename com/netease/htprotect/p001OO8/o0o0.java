package com.netease.htprotect.p001OO8;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.view.Display;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.sdk.djx.core.log.ILogConst;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.netease.htprotect.OO〇8.〇o0〇o0, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class o0o0 {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static final int f42O8oO888 = 1;

    /* renamed from: 〇O8, reason: contains not printable characters */
    private static final int f43O8 = 3;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static final int f44Ooo = 2;

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static String m493O8oO888() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        ArrayMap arrayMap;
        try {
            if (Build.VERSION.SDK_INT < 23) {
                return "";
            }
            Field declaredField = Class.forName("android.app.ActivityThread$ActivityClientRecord").getDeclaredField("referrer");
            declaredField.setAccessible(true);
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            Field declaredField2 = cls.getDeclaredField("mActivities");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(objInvoke);
            if (!(obj instanceof ArrayMap) || (arrayMap = (ArrayMap) obj) == null || arrayMap.size() <= 0) {
                return "";
            }
            ArraySet arraySet = new ArraySet();
            int i = 0;
            for (Object obj2 : arrayMap.values().toArray()) {
                if (i > 50 || arraySet.size() > 10) {
                    break;
                }
                if (obj2 != null) {
                    String str = (String) declaredField.get(obj2);
                    if (!TextUtils.isEmpty(str)) {
                        arraySet.add(str);
                    }
                    i++;
                }
            }
            return TextUtils.join(",", arraySet);
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static String m494O8oO888(int i, Context context) {
        return i != 1 ? i != 2 ? i != 3 ? "" : m498Ooo(context) : m496O8oO888(context) : m493O8oO888();
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static String m495O8oO888(Activity activity) throws NoSuchFieldException {
        try {
            Field declaredField = Activity.class.getDeclaredField("mReferrer");
            declaredField.setAccessible(true);
            return (String) declaredField.get(activity);
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static String m496O8oO888(Context context) {
        if (context == null) {
            return "";
        }
        try {
            List<ComponentName> activeAdmins = ((DevicePolicyManager) context.getSystemService("device_policy")).getActiveAdmins();
            if (activeAdmins != null && activeAdmins.size() > 0) {
                int i = 0;
                ArrayList arrayList = new ArrayList();
                for (ComponentName componentName : activeAdmins) {
                    if (i > 10) {
                        break;
                    }
                    if (componentName != null) {
                        arrayList.add(componentName.getPackageName());
                        i++;
                    }
                }
                return TextUtils.join(",", arrayList);
            }
        } catch (Exception unused) {
        }
        return "";
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static String m497O8oO888(Display display) throws NoSuchMethodException, SecurityException {
        try {
            Method declaredMethod = Display.class.getDeclaredMethod("getOwnerPackageName", new Class[0]);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(display, new Object[0]);
        } catch (Exception unused) {
            return ILogConst.CACHE_PLAY_REASON_NULL;
        }
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static String m498Ooo(Context context) {
        if (context == null) {
            return "";
        }
        if (Build.VERSION.SDK_INT < 20) {
            return "internal-display";
        }
        try {
            Display[] displays = ((DisplayManager) context.getApplicationContext().getSystemService("display")).getDisplays();
            if (displays.length > 1) {
                for (Display display : displays) {
                    if (display.getDisplayId() != 0 && display.getState() == 2 && (display.getFlags() & 8) != 0) {
                        return display.getName() + "-" + m497O8oO888(display) + Config.replace + display.getDisplayId();
                    }
                }
            }
            int iM489O8oO888 = Ooo.m489O8oO888();
            return iM489O8oO888 > 0 ? "unknown-display_".concat(String.valueOf(iM489O8oO888)) : "internal-display";
        } catch (Throwable unused) {
            return "internal-display";
        }
    }
}
