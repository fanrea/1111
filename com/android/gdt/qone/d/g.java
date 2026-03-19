package com.android.gdt.qone.d;

import android.content.Context;
import com.android.gdt.oaid2.VendorManager;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class g implements com.android.gdt.qone.b.a {
    public VendorManager a;
    public b b;
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
        b bVar = this.b;
        if (bVar == null || bVar.a == null || !bVar.e) {
            return;
        }
        try {
            bVar.a.unbindService(bVar.c);
        } catch (Exception unused) {
        } finally {
            bVar.e = false;
            bVar.d = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void e() {
        /*
            r9 = this;
            com.android.gdt.oaid2.VendorManager r0 = r9.a
            if (r0 == 0) goto L70
            com.android.gdt.qone.d.b r1 = r9.b
            r2 = 0
            if (r1 == 0) goto Lf
            com.android.gdt.qone.d.e r3 = r1.d
            if (r3 == 0) goto Lf
            r3 = 1
            goto L10
        Lf:
            r3 = 0
        L10:
            r4 = 0
            java.lang.String r5 = "Context is null, must be new SxCore first"
            java.lang.String r6 = ""
            if (r1 == 0) goto L3f
            com.android.gdt.qone.d.e r7 = r1.d
            if (r7 == 0) goto L3f
            android.content.Context r7 = r1.a
            if (r7 == 0) goto L39
            java.lang.String r7 = r7.getPackageName()
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            if (r8 != 0) goto L35
            com.android.gdt.qone.d.e r1 = r1.d     // Catch: java.lang.Exception -> L34
            if (r1 == 0) goto L35
            com.android.gdt.qone.d.c r1 = (com.android.gdt.qone.d.c) r1     // Catch: java.lang.Exception -> L34
            java.lang.String r1 = r1.a(r7)     // Catch: java.lang.Exception -> L34
            goto L36
        L34:
        L35:
            r1 = r4
        L36:
            if (r1 != 0) goto L40
            goto L3f
        L39:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r5)
            throw r0
        L3f:
            r1 = r6
        L40:
            com.android.gdt.qone.d.b r7 = r9.b
            if (r7 == 0) goto L6d
            com.android.gdt.qone.d.e r8 = r7.d
            if (r8 == 0) goto L6d
            android.content.Context r8 = r7.a
            if (r8 == 0) goto L67
            java.lang.String r5 = r8.getPackageName()
            boolean r8 = android.text.TextUtils.isEmpty(r5)
            if (r8 != 0) goto L62
            com.android.gdt.qone.d.e r7 = r7.d     // Catch: java.lang.Exception -> L61
            if (r7 == 0) goto L62
            com.android.gdt.qone.d.c r7 = (com.android.gdt.qone.d.c) r7     // Catch: java.lang.Exception -> L61
            java.lang.String r4 = r7.b(r5)     // Catch: java.lang.Exception -> L61
            goto L62
        L61:
        L62:
            if (r4 != 0) goto L65
            goto L6d
        L65:
            r6 = r4
            goto L6d
        L67:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r5)
            throw r0
        L6d:
            r0.callbackOaid(r3, r1, r6, r2)
        L70:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.gdt.qone.d.g.e():void");
    }

    @Override // com.android.gdt.qone.b.a
    public final void a(Context context, VendorManager vendorManager) {
        this.a = vendorManager;
        this.b = new b(context, this);
    }
}
