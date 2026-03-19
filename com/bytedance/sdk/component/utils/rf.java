package com.bytedance.sdk.component.utils;

import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class rf {
    private static Object d;
    private static Method hc;

    static {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            Class cls = (Class) declaredMethod.invoke(null, "dalvik.system.VMRuntime");
            Method method = (Method) declaredMethod2.invoke(cls, "getRuntime", null);
            hc = (Method) declaredMethod2.invoke(cls, "setHiddenApiExemptions", new Class[]{String[].class});
            d = method.invoke(null, new Object[0]);
        } catch (Throwable th) {
            mq.hc("Reflection", "reflect bootstrap failed:", th);
        }
    }

    public static boolean d(String... strArr) {
        Method method;
        Object obj = d;
        if (obj != null && (method = hc) != null) {
            try {
                method.invoke(obj, strArr);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean d() {
        return d("L");
    }
}
