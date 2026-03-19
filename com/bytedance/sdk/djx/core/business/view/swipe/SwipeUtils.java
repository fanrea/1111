package com.bytedance.sdk.djx.core.business.view.swipe;

import android.app.Activity;
import android.app.ActivityOptions;
import android.os.Build;
import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class SwipeUtils {
    private SwipeUtils() {
    }

    public static void invokeConvertFromTranslucent(Activity activity) {
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(activity, new Object[0]);
        } catch (Throwable unused) {
        }
    }

    public static void invokeConvertToTranslucent(Activity activity) {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
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
                return;
            }
            Class<?> cls3 = null;
            for (Class<?> cls4 : Activity.class.getDeclaredClasses()) {
                if (cls4.getSimpleName().contains("TranslucentConversionListener")) {
                    cls3 = cls4;
                }
            }
            Method declaredMethod3 = Activity.class.getDeclaredMethod("convertToTranslucent", cls3);
            declaredMethod3.setAccessible(true);
            declaredMethod3.invoke(activity, null);
        } catch (Throwable unused) {
        }
    }
}
