package com.netease.htprotect.p00700oOOo;

import android.os.Handler;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* renamed from: com.netease.htprotect.〇00oOOo.O8〇oO8〇88, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class O8oO888 {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static Method f205O8oO888;

    /* renamed from: 〇O8, reason: contains not printable characters */
    private static Field f206O8;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static Method f207Ooo;

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private static Field f208o0o0;

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static Object m627O8oO888(View view) {
        try {
            if (f205O8oO888 == null) {
                Method declaredMethod = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                declaredMethod.setAccessible(true);
                f205O8oO888 = declaredMethod;
            }
            return f205O8oO888.invoke(view, new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static Object m628O8oO888(Object obj) {
        try {
            if (f207Ooo == null) {
                Method declaredMethod = obj.getClass().getDeclaredMethod("getAccessibilityInteractionController", new Class[0]);
                declaredMethod.setAccessible(true);
                f207Ooo = declaredMethod;
            }
            return f207Ooo.invoke(obj, new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static void m629O8oO888(View view, o0o0 o0o0Var, String str) {
        Object objM628O8oO888;
        Object objM632Ooo;
        try {
            Object objM627O8oO888 = m627O8oO888(view);
            if (objM627O8oO888 == null || (objM628O8oO888 = m628O8oO888(objM627O8oO888)) == null || (objM632Ooo = m632Ooo(objM628O8oO888)) == null) {
                return;
            }
            Handler.Callback callback = (Handler.Callback) m631O8(objM632Ooo);
            if (callback instanceof Ooo) {
                return;
            }
            Ooo ooo = new Ooo(callback, o0o0Var, str);
            Field field = f208o0o0;
            if (field != null) {
                field.set(objM632Ooo, ooo);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static void m630O8oO888(Object obj, Object obj2) {
        Field field = f208o0o0;
        if (field != null) {
            try {
                field.set(obj, obj2);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: 〇O8, reason: contains not printable characters */
    private static Object m631O8(Object obj) {
        try {
            if (f208o0o0 == null) {
                Field declaredField = Handler.class.getDeclaredField("mCallback");
                declaredField.setAccessible(true);
                f208o0o0 = declaredField;
            }
            return f208o0o0.get(obj);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static Object m632Ooo(Object obj) {
        try {
            if (f206O8 == null) {
                Field declaredField = obj.getClass().getDeclaredField("mHandler");
                declaredField.setAccessible(true);
                f206O8 = declaredField;
            }
            return f206O8.get(obj);
        } catch (Throwable unused) {
            return null;
        }
    }
}
