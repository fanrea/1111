package com.bytedance.dr.impl;

import android.content.Context;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.dr.OaidApi;
import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class m implements OaidApi {
    public static Object a;
    public static Class<?> b;
    public static Method c;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            b = cls;
            a = cls.newInstance();
            c = b.getMethod("getOAID", Context.class);
        } catch (Throwable th) {
            LoggerImpl.global().error(1, "Api#static reflect exception! ", th, new Object[0]);
        }
    }

    @Override // com.bytedance.dr.OaidApi
    public String getName() {
        return "Xiaomi";
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001d  */
    @Override // com.bytedance.dr.OaidApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.bytedance.dr.OaidApi.a getOaid(android.content.Context r8) {
        /*
            r7 = this;
            r0 = 0
            r1 = 1
            r2 = 0
            com.bytedance.dr.OaidApi$a r3 = new com.bytedance.dr.OaidApi$a     // Catch: java.lang.Throwable -> L21
            r3.<init>()     // Catch: java.lang.Throwable -> L21
            java.lang.reflect.Method r4 = com.bytedance.dr.impl.m.c     // Catch: java.lang.Throwable -> L21
            java.lang.Object r5 = com.bytedance.dr.impl.m.a     // Catch: java.lang.Throwable -> L21
            if (r5 == 0) goto L1d
            if (r4 == 0) goto L1d
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L1d
            r6[r2] = r8     // Catch: java.lang.Throwable -> L1d
            java.lang.Object r8 = r4.invoke(r5, r6)     // Catch: java.lang.Throwable -> L1d
            if (r8 == 0) goto L1d
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.lang.Throwable -> L1d
            goto L1e
        L1d:
            r8 = r0
        L1e:
            r3.a = r8     // Catch: java.lang.Throwable -> L21
            return r3
        L21:
            r8 = move-exception
            com.bytedance.applog.log.IAppLogLogger r3 = com.bytedance.applog.log.LoggerImpl.global()
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r4 = "invokeMethod get oaid failed"
            r3.error(r1, r4, r8, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.dr.impl.m.getOaid(android.content.Context):com.bytedance.dr.OaidApi$a");
    }

    @Override // com.bytedance.dr.OaidApi
    public boolean support(Context context) {
        return (b == null || a == null || c == null) ? false : true;
    }
}
