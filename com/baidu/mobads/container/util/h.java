package com.baidu.mobads.container.util;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class h {
    public static void a(Activity activity) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (x.a(null).a() >= 26) {
            try {
                Method declaredMethod = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(activity, new Object[0]);
            } catch (Exception e) {
            }
        }
    }

    public static void b(Activity activity) {
        if (x.a(null).a() >= 26) {
            try {
                activity.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                activity.getWindow().getDecorView().setBackground(null);
                Method declaredMethod = Activity.class.getDeclaredMethod("getActivityOptions", new Class[0]);
                declaredMethod.setAccessible(true);
                Object objInvoke = declaredMethod.invoke(activity, new Object[0]);
                Class<?> cls = null;
                for (Class<?> cls2 : Activity.class.getDeclaredClasses()) {
                    if (cls2.getSimpleName().contains("TranslucentConversionListener")) {
                        cls = cls2;
                    }
                }
                Method declaredMethod2 = Activity.class.getDeclaredMethod("convertToTranslucent", cls, ActivityOptions.class);
                declaredMethod2.setAccessible(true);
                declaredMethod2.invoke(activity, null, objInvoke);
            } catch (Throwable th) {
            }
        }
    }

    public static Boolean c(Activity activity) {
        try {
            if (activity != null) {
                return Boolean.valueOf((activity.getWindow().getAttributes().flags & 1024) == 1024);
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
            } else {
                new Handler(Looper.getMainLooper()).post(new i(runnable));
            }
        } catch (Throwable th) {
            bq.a().a(th);
        }
    }

    public static void a(Context context, Intent intent) {
        Class<?> clsE = t.e();
        intent.putExtra("activityImplName", ay.f);
        intent.addFlags(268435456);
        intent.setClass(context, clsE);
        context.startActivity(intent);
    }

    public static void b(Context context, Intent intent) {
        Class<?> clsE = t.e();
        intent.putExtra("activityImplName", ay.h);
        intent.putExtra(com.baidu.mobads.container.adrequest.a.a, "Dialog");
        intent.addFlags(268435456);
        intent.setClass(context, clsE);
        context.startActivity(intent);
    }

    public static void c(Context context, Intent intent) {
        Class<?> clsE = t.e();
        intent.putExtra("activityImplName", ay.l);
        intent.putExtra(com.baidu.mobads.container.adrequest.a.a, "Dialog");
        intent.addFlags(268435456);
        intent.setClass(context, clsE);
        context.startActivity(intent);
    }

    public static void d(Context context, Intent intent) {
        Class<?> clsE = t.e();
        intent.putExtra("activityImplName", ay.i);
        intent.addFlags(268435456);
        intent.setClass(context, clsE);
        context.startActivity(intent);
    }

    public static void e(Context context, Intent intent) {
        Class<?> clsE = t.e();
        intent.putExtra("activityImplName", ay.k);
        intent.addFlags(268435456);
        intent.setClass(context, clsE);
        context.startActivity(intent);
    }

    public static void f(Context context, Intent intent) {
        Class<?> clsE = t.e();
        intent.putExtra("activityImplName", ay.j);
        intent.putExtra(com.baidu.mobads.container.adrequest.a.a, "Dialog");
        intent.addFlags(268435456);
        intent.setClass(context, clsE);
        context.startActivity(intent);
    }
}
