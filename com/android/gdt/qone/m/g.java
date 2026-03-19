package com.android.gdt.qone.m;

import android.content.Context;
import com.android.gdt.oaid2.VendorManager;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class g implements com.android.gdt.qone.b.a {
    public VendorManager a;
    public e b;
    public final f c = new f(this);

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
        e eVar = this.b;
        if (eVar == null || eVar.c == null || !eVar.d) {
            return;
        }
        try {
            eVar.c.unbindService(eVar.b);
            com.android.gdt.qone.af.b.b("SI unBind Service successful");
        } catch (IllegalArgumentException unused) {
            com.android.gdt.qone.af.b.b("SI unBind Service exception");
        } finally {
            eVar.e = null;
            eVar.d = false;
        }
    }

    public final boolean e() {
        e eVar = this.b;
        boolean z = false;
        if (eVar != null) {
            try {
                if (eVar.e == null) {
                    com.android.gdt.qone.af.b.b("SI Device not support opendeviceid");
                } else {
                    com.android.gdt.qone.af.b.b("SI Device support opendeviceid");
                    z = true;
                }
            } catch (Exception unused) {
                com.android.gdt.qone.af.b.b("SI isSupport error, RemoteException!");
            }
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void f() {
        /*
            r11 = this;
            com.android.gdt.oaid2.VendorManager r0 = r11.a
            if (r0 == 0) goto La0
            boolean r1 = r11.e()
            boolean r2 = r11.e()
            r3 = 0
            java.lang.String r4 = "Context is null, must be new SxCore first"
            java.lang.String r5 = "SI Context is null."
            java.lang.String r6 = ""
            if (r2 != 0) goto L17
        L15:
            r2 = r6
            goto L5e
        L17:
            com.android.gdt.qone.m.e r2 = r11.b
            java.lang.String r7 = "SI getAAID Package: "
            android.content.Context r8 = r2.c
            if (r8 == 0) goto L97
            java.lang.String r8 = r8.getPackageName()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "SIapackage："
            r9.<init>(r10)
            r9.append(r8)
            java.lang.String r9 = r9.toString()
            com.android.gdt.qone.af.b.c(r9)
            if (r8 == 0) goto L55
            boolean r9 = r8.equals(r6)
            if (r9 == 0) goto L3d
            goto L55
        L3d:
            com.android.gdt.qone.m.c r2 = r2.e     // Catch: java.lang.Exception -> L4f
            if (r2 == 0) goto L5a
            com.android.gdt.qone.m.a r2 = (com.android.gdt.qone.m.a) r2     // Catch: java.lang.Exception -> L4f
            java.lang.String r2 = r2.a(r8)     // Catch: java.lang.Exception -> L4f
            java.lang.String r7 = r7.concat(r8)     // Catch: java.lang.Exception -> L4f
            com.android.gdt.qone.af.b.c(r7)     // Catch: java.lang.Exception -> L4f
            goto L5b
        L4f:
            java.lang.String r2 = "SI geta error, RemoteException!"
            com.android.gdt.qone.af.b.b(r2)
            goto L5a
        L55:
            java.lang.String r2 = "SI input package is null!"
            com.android.gdt.qone.af.b.b(r2)
        L5a:
            r2 = r3
        L5b:
            if (r2 != 0) goto L5e
            goto L15
        L5e:
            boolean r7 = r11.e()
            if (r7 != 0) goto L65
            goto L89
        L65:
            com.android.gdt.qone.m.e r7 = r11.b
            android.content.Context r8 = r7.c
            if (r8 == 0) goto L8e
            com.android.gdt.qone.m.c r4 = r7.e     // Catch: java.lang.Exception -> L7c
            if (r4 == 0) goto L85
            com.android.gdt.qone.m.a r4 = (com.android.gdt.qone.m.a) r4     // Catch: java.lang.Exception -> L7c
            java.lang.String r4 = r4.a()     // Catch: java.lang.Exception -> L7c
            java.lang.String r5 = "SDI geto call"
            com.android.gdt.qone.af.b.b(r5)     // Catch: java.lang.Exception -> L7c
            r3 = r4
            goto L85
        L7c:
            r4 = move-exception
            java.lang.String r5 = "SI geto error, RemoteException!"
            com.android.gdt.qone.af.b.b(r5)
            r4.printStackTrace()
        L85:
            if (r3 != 0) goto L88
            goto L89
        L88:
            r6 = r3
        L89:
            r3 = 0
            r0.callbackOaid(r1, r2, r6, r3)
            goto La0
        L8e:
            com.android.gdt.qone.af.b.b(r5)
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r4)
            throw r0
        L97:
            com.android.gdt.qone.af.b.b(r5)
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r4)
            throw r0
        La0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.gdt.qone.m.g.f():void");
    }

    @Override // com.android.gdt.qone.b.a
    public final void a(Context context, VendorManager vendorManager) {
        this.a = vendorManager;
        this.b = new e(context, this);
    }
}
