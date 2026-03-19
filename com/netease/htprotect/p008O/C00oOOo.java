package com.netease.htprotect.p008O;

import android.app.KeyguardManager;
import android.content.Context;
import java.lang.reflect.Method;

/* renamed from: com.netease.htprotect.〇O.〇00oOOo, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class C00oOOo {
    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static String m679O8oO888(Context context) throws NoSuchMethodException, SecurityException {
        try {
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (keyguardManager == null) {
                return null;
            }
            Method declaredMethod = keyguardManager.getClass().getDeclaredMethod("obtainOaid", new Class[0]);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(keyguardManager, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
