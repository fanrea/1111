package com.android.gdt.qone.ae;

import android.content.pm.ApplicationInfo;
import java.lang.reflect.Field;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class g {
    public static Object a(String str, ApplicationInfo applicationInfo, String str2) throws NoSuchFieldException, SecurityException {
        try {
            Field declaredField = Class.forName(str).getDeclaredField(str2);
            declaredField.setAccessible(true);
            return declaredField.get(applicationInfo);
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException unused) {
            return null;
        }
    }
}
