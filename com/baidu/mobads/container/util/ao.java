package com.baidu.mobads.container.util;

import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class ao {
    public static Integer a(String str) {
        try {
            Class<?> cls = Class.forName("com.baidu.mobads.sdk.api.DrawableUtil");
            if (cls == null) {
                return 0;
            }
            Method declaredMethod = cls.getDeclaredMethod("getDrawableId", String.class);
            declaredMethod.setAccessible(true);
            return (Integer) declaredMethod.invoke(null, str);
        } catch (Throwable th) {
            return null;
        }
    }
}
