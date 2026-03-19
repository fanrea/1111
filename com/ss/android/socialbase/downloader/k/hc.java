package com.ss.android.socialbase.downloader.k;

import com.ss.android.socialbase.downloader.downloader.mq;
import com.ss.android.socialbase.downloader.tt.tt;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class hc implements Runnable {
    private static final String d = "hc";
    private com.ss.android.socialbase.downloader.h.b an;
    private com.ss.android.socialbase.downloader.h.hc b;
    private com.ss.android.socialbase.downloader.downloader.u c;
    private tt gb;
    private final an h;
    private com.ss.android.socialbase.downloader.h.hc hc;
    private volatile boolean mk;
    private boolean mq;
    private volatile boolean tc;
    private mq tt;
    private final com.ss.android.socialbase.downloader.h.c u;

    public hc(com.ss.android.socialbase.downloader.h.hc hcVar, com.ss.android.socialbase.downloader.h.c cVar, an anVar) {
        this.mq = false;
        this.b = hcVar;
        this.u = cVar;
        if (cVar != null) {
            this.an = cVar.d();
        }
        this.h = anVar;
        this.tt = com.ss.android.socialbase.downloader.downloader.b.np();
        this.b.d(this);
    }

    public hc(com.ss.android.socialbase.downloader.h.hc hcVar, com.ss.android.socialbase.downloader.h.c cVar, tt ttVar, an anVar) {
        this(hcVar, cVar, anVar);
        this.gb = ttVar;
    }

    private String b() {
        return this.an.y();
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0017, code lost:
    
        r3.hc.d(false);
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() throws java.lang.SecurityException, java.lang.IllegalArgumentException {
        /*
            r3 = this;
            r0 = 10
            android.os.Process.setThreadPriority(r0)
            com.ss.android.socialbase.downloader.h.hc r0 = r3.b
            r3.hc = r0
        L9:
            r0 = 0
            com.ss.android.socialbase.downloader.h.hc r1 = r3.hc     // Catch: java.lang.Throwable -> L5b
            r1.d(r3)     // Catch: java.lang.Throwable -> L5b
            com.ss.android.socialbase.downloader.h.hc r1 = r3.hc     // Catch: java.lang.Throwable -> L5b
            boolean r1 = r3.d(r1)     // Catch: java.lang.Throwable -> L5b
            if (r1 != 0) goto L1d
            com.ss.android.socialbase.downloader.h.hc r1 = r3.hc     // Catch: java.lang.Throwable -> L5b
            r1.d(r0)     // Catch: java.lang.Throwable -> L5b
            goto L4b
        L1d:
            com.ss.android.socialbase.downloader.h.hc r1 = r3.hc     // Catch: java.lang.Throwable -> L5b
            r1.d(r0)     // Catch: java.lang.Throwable -> L5b
            boolean r1 = r3.u()     // Catch: java.lang.Throwable -> L5b
            if (r1 != 0) goto L4b
            com.ss.android.socialbase.downloader.k.an r1 = r3.h     // Catch: java.lang.Throwable -> L5b
            com.ss.android.socialbase.downloader.h.hc r2 = r3.hc     // Catch: java.lang.Throwable -> L5b
            int r2 = r2.rf()     // Catch: java.lang.Throwable -> L5b
            com.ss.android.socialbase.downloader.h.hc r1 = r1.d(r2)     // Catch: java.lang.Throwable -> L5b
            r3.hc = r1     // Catch: java.lang.Throwable -> L5b
            boolean r1 = r3.u()     // Catch: java.lang.Throwable -> L5b
            if (r1 != 0) goto L4b
            com.ss.android.socialbase.downloader.h.hc r1 = r3.hc     // Catch: java.lang.Throwable -> L5b
            if (r1 == 0) goto L4b
            r1 = 50
            java.lang.Thread.sleep(r1)     // Catch: java.lang.Throwable -> L46
            goto L9
        L46:
            r1 = move-exception
            com.bytedance.sdk.component.utils.mq.d(r1)     // Catch: java.lang.Throwable -> L5b
            goto L9
        L4b:
            com.ss.android.socialbase.downloader.h.hc r1 = r3.hc
            if (r1 == 0) goto L52
            r1.d(r0)
        L52:
            r3.c()
            com.ss.android.socialbase.downloader.k.an r0 = r3.h
            r0.d(r3)
            return
        L5b:
            r1 = move-exception
            com.ss.android.socialbase.downloader.h.hc r2 = r3.hc
            if (r2 == 0) goto L63
            r2.d(r0)
        L63:
            r3.c()
            com.ss.android.socialbase.downloader.k.an r0 = r3.h
            r0.d(r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.k.hc.run():void");
    }

    public void d(long j, long j2) {
        com.ss.android.socialbase.downloader.downloader.u uVar = this.c;
        if (uVar == null) {
            return;
        }
        uVar.d(j, j2);
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x01b7 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01d8 A[Catch: all -> 0x029b, TRY_ENTER, TryCatch #12 {all -> 0x029b, blocks: (B:132:0x01ce, B:136:0x01d8, B:138:0x01de, B:141:0x01e7, B:143:0x01ef, B:145:0x01f5, B:149:0x0200, B:151:0x0204, B:153:0x020c, B:155:0x021d, B:164:0x0243, B:166:0x0249, B:168:0x0256, B:172:0x025e, B:167:0x0250, B:158:0x022a, B:159:0x0236, B:174:0x0269, B:176:0x0271, B:178:0x0279, B:180:0x0281, B:182:0x0289, B:185:0x0292, B:120:0x01b1, B:124:0x01bb, B:127:0x01c2), top: B:204:0x01ce, inners: #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x01bb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:215:0x00f6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:220:0x01d4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00fa A[Catch: all -> 0x01af, d -> 0x01cb, TRY_ENTER, TryCatch #15 {d -> 0x01cb, all -> 0x01af, blocks: (B:22:0x004f, B:26:0x0059, B:30:0x0064, B:35:0x00b3, B:37:0x00b7, B:45:0x00cc, B:60:0x00f0, B:64:0x00fa, B:66:0x00fe, B:77:0x012c, B:74:0x0124, B:76:0x012b, B:49:0x00d6, B:51:0x00da, B:68:0x0102, B:71:0x010d, B:72:0x0122, B:32:0x006d, B:34:0x0071), top: B:210:0x004f, inners: #16, #14 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean d(com.ss.android.socialbase.downloader.h.hc r31) {
        /*
            Method dump skipped, instructions count: 672
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.k.hc.d(com.ss.android.socialbase.downloader.h.hc):boolean");
    }

    private void d(com.ss.android.socialbase.downloader.h.hc hcVar, long j) {
        com.ss.android.socialbase.downloader.h.hc hcVarU = hcVar.c() ? hcVar.u() : hcVar;
        if (hcVarU != null) {
            if (hcVarU.gb()) {
                this.tt.d(hcVarU.mk(), hcVarU.hc(), j);
            }
            hcVarU.hc(j);
            this.tt.d(hcVarU.mk(), hcVarU.rf(), hcVarU.hc(), j);
            return;
        }
        if (hcVar.c()) {
            this.tt.d(hcVar.mk(), hcVar.rf(), j);
        }
    }

    private void c() {
        tt ttVar = this.gb;
        if (ttVar != null) {
            ttVar.c();
            this.gb = null;
        }
    }

    private boolean u() {
        return this.tc || this.mk;
    }

    public void d() {
        this.tc = true;
        com.ss.android.socialbase.downloader.downloader.u uVar = this.c;
        if (uVar != null) {
            uVar.hc();
        }
    }

    public void hc() {
        this.mk = true;
        com.ss.android.socialbase.downloader.downloader.u uVar = this.c;
        if (uVar != null) {
            uVar.b();
        }
    }
}
