package com.bytedance.embedapplog;

import android.content.Context;
import com.bytedance.embedapplog.ic;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
final class mk implements ic {
    private static Method b;
    private static Object d;
    private static Class<?> hc;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            hc = cls;
            d = cls.newInstance();
            b = hc.getMethod("getOAID", Context.class);
        } catch (Exception e) {
            um.d("Api#static reflect exception! " + e.getMessage());
        }
    }

    mk() {
    }

    static boolean d() {
        return (hc == null || d == null || b == null) ? false : true;
    }

    @Override // com.bytedance.embedapplog.ic
    public boolean d(Context context) {
        return d();
    }

    @Override // com.bytedance.embedapplog.ic
    public ic.d hc(Context context) {
        try {
            ic.d dVar = new ic.d();
            dVar.hc = d(context, b);
            return dVar;
        } catch (Exception e) {
            um.d(e);
            return null;
        }
    }

    private static String d(Context context, Method method) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object obj = d;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object objInvoke = method.invoke(obj, context);
            if (objInvoke != null) {
                return (String) objInvoke;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
