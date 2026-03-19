package com.android.gdt.qone.h;

import android.content.Context;
import com.android.gdt.oaid2.VendorManager;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class e implements com.android.gdt.qone.b.a {
    public g a;
    public VendorManager b;
    public final d c = new d(this);

    @Override // com.android.gdt.qone.b.a
    public final void a() {
    }

    @Override // com.android.gdt.qone.b.a
    public final void b() {
        com.android.gdt.qone.c.e.c.a(this.c);
    }

    @Override // com.android.gdt.qone.b.a
    public final boolean c() {
        return false;
    }

    @Override // com.android.gdt.qone.b.a
    public final void d() {
        g gVar = this.a;
        if (gVar != null) {
            try {
                gVar.a.unbindService(gVar.c);
                g.a("unBind Service successful");
            } catch (IllegalArgumentException unused) {
                com.android.gdt.qone.af.b.a("LXOP ".concat("unBind Service exception"));
            }
            gVar.b = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String e() {
        /*
            r5 = this;
            boolean r0 = r5.g()
            java.lang.String r1 = ""
            if (r0 != 0) goto L9
            return r1
        L9:
            com.android.gdt.qone.h.g r0 = r5.a
            android.content.Context r2 = r0.a
            if (r2 == 0) goto L4f
            java.lang.String r2 = r2.getPackageName()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "liufeng, getAAID package："
            r3.<init>(r4)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            com.android.gdt.qone.h.g.a(r3)
            if (r2 == 0) goto L44
            boolean r3 = r2.equals(r1)
            if (r3 == 0) goto L2d
            goto L44
        L2d:
            com.android.gdt.qone.h.c r0 = r0.b     // Catch: java.lang.Exception -> L38
            if (r0 == 0) goto L49
            com.android.gdt.qone.h.a r0 = (com.android.gdt.qone.h.a) r0     // Catch: java.lang.Exception -> L38
            java.lang.String r0 = r0.a(r2)     // Catch: java.lang.Exception -> L38
            goto L4a
        L38:
            java.lang.String r0 = "LXOP "
            java.lang.String r2 = "getAAID error, RemoteException!"
            java.lang.String r0 = r0.concat(r2)
            com.android.gdt.qone.af.b.a(r0)
            goto L49
        L44:
            java.lang.String r0 = "input package is null!"
            com.android.gdt.qone.h.g.a(r0)
        L49:
            r0 = 0
        L4a:
            if (r0 != 0) goto L4d
            goto L4e
        L4d:
            r1 = r0
        L4e:
            return r1
        L4f:
            java.lang.String r0 = "Context is null."
            com.android.gdt.qone.h.g.a(r0)
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Context is null, must be new OpenDeviceId first"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.gdt.qone.h.e.e():java.lang.String");
    }

    public final String f() {
        c cVar;
        if (!g()) {
            return "";
        }
        g gVar = this.a;
        if (gVar.a == null) {
            com.android.gdt.qone.af.b.a("LXOP ".concat("Context is null."));
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            cVar = gVar.b;
        } catch (Exception e) {
            com.android.gdt.qone.af.b.a("LXOP ".concat("getOAID error, RemoteException!"));
            e.printStackTrace();
        }
        String strA = cVar != null ? ((a) cVar).a() : null;
        return strA == null ? "" : strA;
    }

    public final boolean g() {
        g gVar = this.a;
        if (gVar == null) {
            return false;
        }
        try {
            if (gVar.b == null) {
                return false;
            }
            g.a("Device support opendeviceid");
            return ((a) gVar.b).b();
        } catch (Exception unused) {
            com.android.gdt.qone.af.b.a("LXOP ".concat("isSupport error, RemoteException!"));
            return false;
        }
    }

    public final void h() {
        try {
            VendorManager vendorManager = this.b;
            if (vendorManager != null) {
                vendorManager.callbackOaid(g(), e(), f(), false);
            }
        } catch (Throwable unused) {
            VendorManager vendorManager2 = this.b;
            if (vendorManager2 != null) {
                vendorManager2.callbackOaid(false, "", "", false);
            }
        }
    }

    @Override // com.android.gdt.qone.b.a
    public final void a(Context context, VendorManager vendorManager) {
        this.b = vendorManager;
        this.a = new g(context, this);
    }
}
