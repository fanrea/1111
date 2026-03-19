package com.netease.htprotect.p008O;

import android.content.Context;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* renamed from: com.netease.htprotect.〇O.〇o08o, reason: invalid class name and case insensitive filesystem */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class C0962o08o {
    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static String m699O8oO888(Context context) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        try {
            Class<?> cls = Class.forName("android.app.ZteDeviceIdentifyManager");
            Constructor<?> declaredConstructor = cls.getDeclaredConstructor(Context.class);
            declaredConstructor.setAccessible(true);
            Method declaredMethod = cls.getDeclaredMethod("getOAID", Context.class);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(declaredConstructor.newInstance(context), context);
        } catch (Exception unused) {
            return null;
        }
    }
}
