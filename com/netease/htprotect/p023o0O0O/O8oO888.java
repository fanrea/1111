package com.netease.htprotect.p023o0O0O;

import android.app.Activity;
import android.os.Build;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.netease.htprotect.〇o〇0O〇0O.O8〇oO8〇88, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class O8oO888 {
    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static Activity m1142O8oO888() {
        for (Activity activity : m1145Ooo()) {
            if ((activity == null || activity.isFinishing() || (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed())) ? false : true) {
                return activity;
            }
        }
        return null;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static boolean m1143O8oO888(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return false;
        }
        return Build.VERSION.SDK_INT < 17 || !activity.isDestroyed();
    }

    private static List Oo0() {
        return m1145Ooo();
    }

    /* renamed from: 〇O8, reason: contains not printable characters */
    private static Object m1144O8() throws NoSuchFieldException {
        Object objM1146o0o0 = m1146o0o0();
        return objM1146o0o0 != null ? objM1146o0o0 : m1147oO();
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static List m1145Ooo() throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        Object objM1146o0o0;
        LinkedList linkedList = new LinkedList();
        Activity activity = null;
        try {
            objM1146o0o0 = m1146o0o0();
            if (objM1146o0o0 == null) {
                objM1146o0o0 = m1147oO();
            }
        } catch (Exception unused) {
        }
        if (objM1146o0o0 == null) {
            return linkedList;
        }
        Field declaredField = objM1146o0o0.getClass().getDeclaredField("mActivities");
        declaredField.setAccessible(true);
        Object obj = declaredField.get(objM1146o0o0);
        if (!(obj instanceof Map)) {
            return linkedList;
        }
        for (Object obj2 : ((Map) obj).values()) {
            Class<?> cls = obj2.getClass();
            Field declaredField2 = cls.getDeclaredField("activity");
            declaredField2.setAccessible(true);
            Activity activity2 = (Activity) declaredField2.get(obj2);
            if (activity == null) {
                Field declaredField3 = cls.getDeclaredField("paused");
                declaredField3.setAccessible(true);
                if (!declaredField3.getBoolean(obj2)) {
                    activity = activity2;
                }
            }
            linkedList.addFirst(activity2);
        }
        if (activity != null) {
            linkedList.addFirst(activity);
        }
        return linkedList;
    }

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private static Object m1146o0o0() throws NoSuchFieldException {
        try {
            Field declaredField = Class.forName("android.app.ActivityThread").getDeclaredField("sCurrentActivityThread");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: 〇oO, reason: contains not printable characters */
    private static Object m1147oO() {
        try {
            return Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
