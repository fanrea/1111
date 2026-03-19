package com.android.gdt.qone.o;

import android.content.Context;
import com.android.gdt.oaid2.VendorManager;
import com.android.gdt.qone.af.b;
import java.lang.reflect.Method;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class a implements com.android.gdt.qone.b.a {
    public static Class c;
    public static Object d;
    public static Method e;
    public static Method f;
    public Context a;
    public VendorManager b;

    public a() throws ClassNotFoundException {
        try {
            b.b("xm start");
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            c = cls;
            d = cls.newInstance();
            e = c.getMethod("getOAID", Context.class);
            f = c.getMethod("getAAID", Context.class);
        } catch (Exception e2) {
            b.c("xm reflect exception!" + e2);
        }
    }

    @Override // com.android.gdt.qone.b.a
    public final void a(Context context, VendorManager vendorManager) {
        this.a = context;
        this.b = vendorManager;
    }

    @Override // com.android.gdt.qone.b.a
    public final void b() {
    }

    @Override // com.android.gdt.qone.b.a
    public final boolean c() {
        return true;
    }

    @Override // com.android.gdt.qone.b.a
    public final void d() {
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x002a  */
    @Override // com.android.gdt.qone.b.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a() throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r9 = this;
            com.android.gdt.oaid2.VendorManager r0 = r9.b
            if (r0 == 0) goto L45
            java.lang.Class r1 = com.android.gdt.qone.o.a.c
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L10
            java.lang.Object r1 = com.android.gdt.qone.o.a.d
            if (r1 == 0) goto L10
            r1 = 1
            goto L11
        L10:
            r1 = 0
        L11:
            java.lang.Object r4 = com.android.gdt.qone.o.a.d
            r5 = 0
            if (r4 == 0) goto L2a
            java.lang.reflect.Method r6 = com.android.gdt.qone.o.a.f
            if (r6 == 0) goto L2a
            android.content.Context r7 = r9.a
            java.lang.Object[] r8 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L29
            r8[r3] = r7     // Catch: java.lang.Exception -> L29
            java.lang.Object r4 = r6.invoke(r4, r8)     // Catch: java.lang.Exception -> L29
            if (r4 == 0) goto L2a
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Exception -> L29
            goto L2b
        L29:
        L2a:
            r4 = r5
        L2b:
            java.lang.Object r6 = com.android.gdt.qone.o.a.d
            if (r6 == 0) goto L42
            java.lang.reflect.Method r7 = com.android.gdt.qone.o.a.e
            if (r7 == 0) goto L42
            android.content.Context r8 = r9.a
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L42
            r2[r3] = r8     // Catch: java.lang.Exception -> L42
            java.lang.Object r2 = r7.invoke(r6, r2)     // Catch: java.lang.Exception -> L42
            if (r2 == 0) goto L42
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Exception -> L42
            r5 = r2
        L42:
            r0.callbackOaid(r1, r4, r5, r3)
        L45:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.gdt.qone.o.a.a():void");
    }
}
