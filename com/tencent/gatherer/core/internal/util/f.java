package com.tencent.gatherer.core.internal.util;

import java.lang.reflect.Method;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class f {
    public static Object a(String str, String str2, Class<?>[] clsArr, Object... objArr) throws NoSuchMethodException, SecurityException {
        try {
            Method declaredMethod = Class.forName(str).getDeclaredMethod(str2, clsArr);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                return declaredMethod.invoke(null, objArr);
            }
        } catch (Exception e) {
            d.a("invokeStaticMethod got Exception:", e);
        }
        return null;
    }
}
