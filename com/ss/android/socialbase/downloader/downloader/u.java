package com.ss.android.socialbase.downloader.downloader;

import android.os.SystemClock;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class u {
    private static String hc = "ResponseHandler";
    private final com.ss.android.socialbase.downloader.tt.tt an;
    private final com.ss.android.socialbase.downloader.h.b b;
    private final String c;
    private long cb;
    private final boolean de;
    private long e;
    private com.ss.android.socialbase.downloader.impls.mk gb;
    private mq h;
    private boolean he;
    private long j;
    private final com.ss.android.socialbase.downloader.uo.d jh;
    private final com.ss.android.socialbase.downloader.k.an k;
    private com.ss.android.socialbase.downloader.u.d mk;
    private volatile boolean mq;
    private final long np;
    private final boolean rf;
    private long s;
    private final com.ss.android.socialbase.downloader.d.d sy;
    private com.ss.android.socialbase.downloader.h.h tc;
    private sy tt;
    private final com.ss.android.socialbase.downloader.h.hc u;
    private volatile boolean uo;
    private final long v;
    private long vv;
    private volatile long w;
    private final boolean yi;
    private volatile long yo;
    private long zw;
    boolean d = false;
    private volatile long us = 0;
    private volatile long z = 0;

    private boolean hc(long j, long j2) {
        return j > 65536 && j2 > 500;
    }

    public u(com.ss.android.socialbase.downloader.h.b bVar, String str, com.ss.android.socialbase.downloader.tt.tt ttVar, com.ss.android.socialbase.downloader.h.hc hcVar, com.ss.android.socialbase.downloader.k.an anVar) {
        this.b = bVar;
        this.c = str;
        mq mqVarNp = b.np();
        this.h = mqVarNp;
        if (mqVarNp instanceof com.ss.android.socialbase.downloader.impls.c) {
            com.ss.android.socialbase.downloader.impls.c cVar = (com.ss.android.socialbase.downloader.impls.c) mqVarNp;
            this.gb = cVar.d();
            this.tt = cVar.an();
        }
        this.an = ttVar;
        this.u = hcVar;
        this.k = anVar;
        long jK = hcVar.k();
        this.e = jK;
        this.cb = jK;
        if (hcVar.c()) {
            this.yo = hcVar.w();
        } else {
            this.yo = hcVar.b(false);
        }
        this.w = hcVar.cb();
        this.sy = com.ss.android.socialbase.downloader.d.d.d();
        com.ss.android.socialbase.downloader.uo.d dVarD = com.ss.android.socialbase.downloader.uo.d.d(bVar.h());
        this.jh = dVarD;
        boolean z = dVarD.d("sync_strategy", 0) == 1;
        this.de = z;
        if (z) {
            long jD = dVarD.d("sync_interval_ms_fg", 5000);
            long jD2 = dVarD.d("sync_interval_ms_bg", 1000);
            this.v = Math.max(jD, 500L);
            this.np = Math.max(jD2, 500L);
        } else {
            this.v = 0L;
            this.np = 0L;
        }
        this.yi = dVarD.hc("monitor_rw") == 1;
        this.rf = com.ss.android.socialbase.downloader.e.d.d(65536);
    }

    public long d() {
        return this.e;
    }

    private boolean an() {
        return this.mq || this.uo;
    }

    public void hc() {
        if (this.mq) {
            return;
        }
        this.mq = true;
        h();
    }

    public void b() {
        if (this.uo) {
            return;
        }
        synchronized (this.k) {
            this.uo = true;
        }
        h();
    }

    private void h() {
        ExecutorService executorServiceMk;
        if (this.an == null || (executorServiceMk = b.mk()) == null) {
            return;
        }
        executorServiceMk.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.u.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    u.this.an.c();
                } catch (Throwable unused) {
                }
            }
        });
    }

    public void d(long j, long j2, long j3) {
        this.e = j;
        this.cb = j;
        this.w = j2;
        this.yo = j3;
    }

    public void d(long j, long j2) {
        this.w = j;
        this.yo = j2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0244 A[Catch: all -> 0x0295, TryCatch #26 {all -> 0x0295, blocks: (B:149:0x0240, B:151:0x0244, B:152:0x0246, B:162:0x025b, B:163:0x025c, B:165:0x0265, B:153:0x0247, B:155:0x024b, B:157:0x0254, B:158:0x0257), top: B:351:0x0240, inners: #31 }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x025c A[Catch: all -> 0x0295, TryCatch #26 {all -> 0x0295, blocks: (B:149:0x0240, B:151:0x0244, B:152:0x0246, B:162:0x025b, B:163:0x025c, B:165:0x0265, B:153:0x0247, B:155:0x024b, B:157:0x0254, B:158:0x0257), top: B:351:0x0240, inners: #31 }] */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0363 A[Catch: all -> 0x04e0, TRY_ENTER, TryCatch #1 {all -> 0x04e0, blocks: (B:191:0x02ec, B:220:0x0363, B:222:0x0369, B:223:0x036c, B:264:0x045f, B:265:0x0461, B:269:0x0467, B:271:0x0480, B:299:0x04d4, B:301:0x04da, B:302:0x04dd, B:303:0x04df), top: B:335:0x0028, inners: #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:249:0x03ed A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:250:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0480 A[Catch: all -> 0x04e0, TRY_LEAVE, TryCatch #1 {all -> 0x04e0, blocks: (B:191:0x02ec, B:220:0x0363, B:222:0x0369, B:223:0x036c, B:264:0x045f, B:265:0x0461, B:269:0x0467, B:271:0x0480, B:299:0x04d4, B:301:0x04da, B:302:0x04dd, B:303:0x04df), top: B:335:0x0028, inners: #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:301:0x04da A[Catch: all -> 0x04e0, TryCatch #1 {all -> 0x04e0, blocks: (B:191:0x02ec, B:220:0x0363, B:222:0x0369, B:223:0x036c, B:264:0x045f, B:265:0x0461, B:269:0x0467, B:271:0x0480, B:299:0x04d4, B:301:0x04da, B:302:0x04dd, B:303:0x04df), top: B:335:0x0028, inners: #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:379:0x022f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0119 A[Catch: all -> 0x0107, d -> 0x010e, TRY_ENTER, TRY_LEAVE, TryCatch #29 {d -> 0x010e, all -> 0x0107, blocks: (B:48:0x0102, B:56:0x0119), top: B:374:0x0102 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0129 A[Catch: all -> 0x02a2, d -> 0x02a9, TRY_LEAVE, TryCatch #35 {d -> 0x02a9, all -> 0x02a2, blocks: (B:54:0x0113, B:57:0x0125, B:59:0x0129), top: B:363:0x0113 }] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v19, types: [int] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v39 */
    /* JADX WARN: Type inference failed for: r4v40 */
    /* JADX WARN: Type inference failed for: r4v41 */
    /* JADX WARN: Type inference failed for: r4v42 */
    /* JADX WARN: Type inference failed for: r4v43 */
    /* JADX WARN: Type inference failed for: r4v44 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c() throws com.ss.android.socialbase.downloader.u.d {
        /*
            Method dump skipped, instructions count: 1391
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.downloader.u.c():void");
    }

    private com.ss.android.socialbase.downloader.tc.hc d(InputStream inputStream) {
        int iBa = b.ba();
        if (this.jh.d("rw_concurrent", 0) == 1 && this.b.fj() == 1 && this.b.mb() > 20971520) {
            try {
                com.ss.android.socialbase.downloader.tc.d dVar = new com.ss.android.socialbase.downloader.tc.d(inputStream, iBa, this.jh.d("rw_concurrent_max_buffer_count", 4));
                this.he = true;
                return dVar;
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.mq.d(th);
            }
        }
        com.ss.android.socialbase.downloader.tc.b bVar = new com.ss.android.socialbase.downloader.tc.b(inputStream, iBa);
        this.he = false;
        return bVar;
    }

    private void d(boolean z) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j = jUptimeMillis - this.z;
        if (this.de) {
            if (j <= (this.sy.hc() ? this.v : this.np)) {
                return;
            }
        } else {
            long j2 = this.e - this.us;
            if (!z && !hc(j2, j)) {
                return;
            }
        }
        gb();
        this.z = jUptimeMillis;
    }

    public long u() {
        return this.us;
    }

    private void gb() {
        boolean z;
        long jNanoTime = this.yi ? System.nanoTime() : 0L;
        try {
            this.tc.d();
            z = true;
        } catch (Exception unused) {
            z = false;
        }
        if (z) {
            this.b.h(true);
            boolean z2 = this.b.fj() > 1;
            e eVarD = com.ss.android.socialbase.downloader.impls.mq.d(com.ss.android.socialbase.downloader.e.an.hc());
            if (z2) {
                d(this.tt);
                if (eVarD != null) {
                    eVarD.b(this.b);
                } else {
                    this.tt.d(this.b.h(), this.b.js());
                }
            } else if (eVarD != null) {
                eVarD.b(this.b);
            } else {
                this.tt.d(this.u.mk(), this.e);
            }
            this.us = this.e;
        }
        if (this.yi) {
            this.j += System.nanoTime() - jNanoTime;
        }
    }

    private void d(mq mqVar) {
        com.ss.android.socialbase.downloader.h.hc hcVarU;
        com.ss.android.socialbase.downloader.h.hc hcVar;
        if (mqVar == null) {
            return;
        }
        e eVarD = null;
        boolean z = mqVar instanceof com.ss.android.socialbase.downloader.b.u;
        if (z && (eVarD = com.ss.android.socialbase.downloader.impls.mq.d(com.ss.android.socialbase.downloader.e.an.hc())) == null) {
            return;
        }
        e eVar = eVarD;
        if (this.u.c()) {
            hcVarU = this.u.u();
        } else {
            hcVarU = this.u;
        }
        com.ss.android.socialbase.downloader.h.hc hcVar2 = hcVarU;
        if (hcVar2 != null) {
            hcVar2.hc(this.e);
            if (z && eVar != null) {
                eVar.d(hcVar2.mk(), hcVar2.rf(), hcVar2.hc(), this.e);
                hcVar = hcVar2;
            } else {
                hcVar = hcVar2;
                mqVar.d(hcVar2.mk(), hcVar2.rf(), hcVar2.hc(), this.e);
            }
            if (hcVar.gb()) {
                boolean z2 = false;
                if (hcVar.tt()) {
                    long jTc = hcVar.tc();
                    if (jTc > this.e) {
                        if (z && eVar != null) {
                            eVar.d(hcVar.mk(), hcVar.hc(), jTc);
                        } else {
                            mqVar.d(hcVar.mk(), hcVar.hc(), jTc);
                        }
                        z2 = true;
                    }
                }
                if (z2) {
                    return;
                }
                if (z && eVar != null) {
                    eVar.d(hcVar.mk(), hcVar.hc(), this.e);
                    return;
                } else {
                    mqVar.d(hcVar.mk(), hcVar.hc(), this.e);
                    return;
                }
            }
            return;
        }
        if (this.u.c()) {
            if (z && eVar != null) {
                eVar.d(this.u.mk(), this.u.rf(), this.e);
            } else {
                mqVar.d(this.u.mk(), this.u.rf(), this.e);
            }
        }
    }
}
