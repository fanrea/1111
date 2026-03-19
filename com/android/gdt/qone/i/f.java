package com.android.gdt.qone.i;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class f implements Runnable {
    public final c a;
    public final h b;

    public f(c cVar, h hVar) {
        this.a = cVar;
        this.b = hVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x006c  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() throws java.lang.InterruptedException {
        /*
            r7 = this;
            com.android.gdt.qone.i.c r0 = r7.a
            if (r0 != 0) goto L5
            return
        L5:
            r0 = 0
            r1 = 0
            r2 = 0
        L8:
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MICROSECONDS     // Catch: java.lang.Exception -> L20
            r4 = 10
            r3.sleep(r4)     // Catch: java.lang.Exception -> L20
            com.android.gdt.qone.i.c r3 = r7.a     // Catch: java.lang.Exception -> L20
            com.android.gdt.qone.i.a r3 = (com.android.gdt.qone.i.a) r3     // Catch: java.lang.Exception -> L20
            boolean r2 = r3.a()     // Catch: java.lang.Exception -> L20
            int r1 = r1 + 1
            if (r2 != 0) goto L21
            r3 = 30
            if (r1 < r3) goto L8
            goto L21
        L20:
        L21:
            if (r2 == 0) goto L70
            com.android.gdt.qone.i.h r1 = r7.b
            if (r1 == 0) goto L70
            com.android.gdt.oaid2.VendorManager r2 = r1.c
            if (r2 == 0) goto L70
            boolean r3 = r1.e()
            boolean r4 = r1.e()
            java.lang.String r5 = ""
            if (r4 == 0) goto L4c
            com.android.gdt.qone.i.e r4 = r1.a
            r4.getClass()
            com.android.gdt.qone.i.c r4 = r4.d     // Catch: java.lang.Exception -> L48
            if (r4 != 0) goto L41
            goto L49
        L41:
            com.android.gdt.qone.i.a r4 = (com.android.gdt.qone.i.a) r4     // Catch: java.lang.Exception -> L48
            java.lang.String r4 = r4.b()     // Catch: java.lang.Exception -> L48
            goto L4a
        L48:
        L49:
            r4 = r5
        L4a:
            if (r4 != 0) goto L4d
        L4c:
            r4 = r5
        L4d:
            boolean r6 = r1.e()
            if (r6 == 0) goto L6d
            com.android.gdt.qone.i.e r1 = r1.a
            r1.getClass()
            com.android.gdt.qone.i.c r1 = r1.d     // Catch: java.lang.Exception -> L64
            if (r1 != 0) goto L5d
            goto L68
        L5d:
            com.android.gdt.qone.i.a r1 = (com.android.gdt.qone.i.a) r1     // Catch: java.lang.Exception -> L64
            java.lang.String r1 = r1.c()     // Catch: java.lang.Exception -> L64
            goto L69
        L64:
            r1 = move-exception
            r1.printStackTrace()
        L68:
            r1 = r5
        L69:
            if (r1 != 0) goto L6c
            goto L6d
        L6c:
            r5 = r1
        L6d:
            r2.callbackOaid(r3, r4, r5, r0)
        L70:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.gdt.qone.i.f.run():void");
    }
}
