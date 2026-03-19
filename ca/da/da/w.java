package ca.da.da;

import android.content.Context;
import java.lang.reflect.Method;

/* compiled from: XiaomiOppoImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class w implements n {
    public static Object a;
    public static Class<?> b;
    public static Method c;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            b = cls;
            a = cls.newInstance();
            c = b.getMethod("getOAID", Context.class);
        } catch (Exception e) {
            String str = m.j;
            ca.ca.ca.ca.a.a("Api#static reflect exception! ").append(e.getMessage()).toString();
        }
    }

    public static boolean a() {
        return (b == null || a == null || c == null) ? false : true;
    }

    @Override // ca.da.da.n
    public boolean b(Context context) {
        return a();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001d  */
    @Override // ca.da.da.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ca.da.da.n.a a(android.content.Context r7) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r6 = this;
            r0 = 0
            ca.da.da.n$a r1 = new ca.da.da.n$a     // Catch: java.lang.Exception -> L21
            r1.<init>()     // Catch: java.lang.Exception -> L21
            java.lang.reflect.Method r2 = ca.da.da.w.c     // Catch: java.lang.Exception -> L21
            java.lang.Object r3 = ca.da.da.w.a     // Catch: java.lang.Exception -> L21
            if (r3 == 0) goto L1d
            if (r2 == 0) goto L1d
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Exception -> L1d
            r5 = 0
            r4[r5] = r7     // Catch: java.lang.Exception -> L1d
            java.lang.Object r7 = r2.invoke(r3, r4)     // Catch: java.lang.Exception -> L1d
            if (r7 == 0) goto L1d
            java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Exception -> L1d
            goto L1e
        L1d:
            r7 = r0
        L1e:
            r1.a = r7     // Catch: java.lang.Exception -> L21
            return r1
        L21:
            r7 = move-exception
            r7.printStackTrace()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ca.da.da.w.a(android.content.Context):ca.da.da.n$a");
    }
}
