package com.baidu.mobstat.forbes;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public final class as {
    public static HashMap<String, String> a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        return new HashMap<>(map);
    }

    public static boolean a(Class<?> cls, String str) {
        Class<?> cls2;
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            String methodName = stackTraceElement.getMethodName();
            if (!TextUtils.isEmpty(methodName) && cls != null && methodName.equals(str)) {
                try {
                    cls2 = Class.forName(stackTraceElement.getClassName());
                } catch (Throwable th) {
                    cls2 = null;
                }
                if (cls2 != null && cls.isAssignableFrom(cls2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (str.length() > i) {
            return str.substring(0, i);
        }
        return str;
    }
}
