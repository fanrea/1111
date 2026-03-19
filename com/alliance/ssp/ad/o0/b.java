package com.alliance.ssp.ad.o0;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/* compiled from: ActivityUtil.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class b {
    static {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            cls.getMethod("currentActivityThread", new Class[0]);
            cls.getDeclaredField("mActivities").setAccessible(true);
        } catch (Exception unused) {
        }
        try {
            Class<?> cls2 = Class.forName("android.app.ActivityThread$ActivityClientRecord");
            cls2.getDeclaredField("paused").setAccessible(true);
            cls2.getDeclaredField("activity").setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Context a() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object objInvoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mInitialApplication");
            declaredField.setAccessible(true);
            Application application = (Application) declaredField.get(objInvoke);
            if (application != null) {
                return application.getApplicationContext();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Activity b() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object objInvoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            for (Object obj : ((Map) declaredField.get(objInvoke)).values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField("paused");
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls2.getDeclaredField("activity");
                    declaredField3.setAccessible(true);
                    return (Activity) declaredField3.get(obj);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Context a(WeakReference<Activity> weakReference) {
        if (weakReference != null) {
            try {
                if (weakReference.get() != null) {
                    return weakReference.get();
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        Context contextA = a();
        if (contextA != null) {
            return contextA;
        }
        return null;
    }
}
