package com.ss.android.socialbase.downloader.k;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.kuaishou.weapon.p0.g;
import com.ss.android.socialbase.downloader.c.rf;
import com.ss.android.socialbase.downloader.c.yi;
import com.ss.android.socialbase.downloader.c.zw;
import com.ss.android.socialbase.downloader.downloader.jh;
import com.ss.android.socialbase.downloader.downloader.mq;
import com.ss.android.socialbase.downloader.downloader.tc;
import com.ss.android.socialbase.downloader.downloader.tt;
import com.ss.android.socialbase.downloader.h.hc;
import com.ss.android.socialbase.downloader.impls.w;
import com.ss.android.socialbase.downloader.impls.yo;
import com.ss.android.socialbase.downloader.mk.k;
import com.ss.android.socialbase.downloader.mk.mk;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLHandshakeException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b implements an, Runnable {
    private static final String d = "b";
    private final com.ss.android.socialbase.downloader.h.c b;
    private long ba;
    private com.ss.android.socialbase.downloader.h.b cb;
    private final com.ss.android.socialbase.downloader.downloader.an de;
    private final mq e;
    private long fs;
    private boolean gb;
    private volatile com.ss.android.socialbase.downloader.downloader.u h;
    private Future hc;
    private yi he;
    private final tt jh;
    private boolean mk;
    private boolean mq;
    private final com.ss.android.socialbase.downloader.uo.d mt;
    private com.ss.android.socialbase.downloader.tt.tt np;
    private tt rf;
    private jh sy;
    private boolean tc;
    private boolean tt;
    private AtomicInteger u;
    private final AtomicBoolean uo;
    private String us;
    private volatile com.ss.android.socialbase.downloader.u.d v;
    private rf vv;
    private tc w;
    private com.ss.android.socialbase.downloader.tt.h yi;
    private final tc yo;
    private volatile boolean c = false;
    private final ArrayList<hc> an = new ArrayList<>();
    private volatile com.ss.android.socialbase.downloader.hc.tc k = com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_NONE;
    private volatile int zw = 5;
    private boolean j = false;
    private boolean s = false;
    private boolean z = false;
    private int r = 0;
    private volatile mk hv = null;

    private boolean hv() {
        return false;
    }

    public b(com.ss.android.socialbase.downloader.h.c cVar, Handler handler) {
        this.b = cVar;
        if (cVar != null) {
            this.cb = cVar.d();
            this.w = cVar.an();
            this.rf = cVar.jh();
            this.he = cVar.gb();
            this.vv = cVar.tt();
            this.sy = d(cVar);
            this.mt = com.ss.android.socialbase.downloader.uo.d.d(this.cb.h());
        } else {
            this.mt = com.ss.android.socialbase.downloader.uo.d.b();
        }
        gb();
        this.e = com.ss.android.socialbase.downloader.downloader.b.np();
        this.yo = com.ss.android.socialbase.downloader.downloader.b.mt();
        this.jh = com.ss.android.socialbase.downloader.downloader.b.hv();
        this.de = new com.ss.android.socialbase.downloader.downloader.an(cVar, handler);
        this.uo = new AtomicBoolean(true);
    }

    private void gb() {
        com.ss.android.socialbase.downloader.h.b bVar = this.cb;
        if (bVar == null) {
            return;
        }
        int iHv = bVar.hv() - this.cb.ec();
        if (iHv < 0) {
            iHv = 0;
        }
        AtomicInteger atomicInteger = this.u;
        if (atomicInteger == null) {
            this.u = new AtomicInteger(iHv);
        } else {
            atomicInteger.set(iHv);
        }
    }

    public void d() {
        this.k = com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_PAUSE;
        if (this.hv != null) {
            this.hv.hc();
        }
        if (this.h != null) {
            this.h.hc();
        }
        if (this.hv == null && this.h == null) {
            rf();
            this.k = com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_PAUSE;
            cb();
        }
        try {
            Iterator it = ((ArrayList) this.an.clone()).iterator();
            while (it.hasNext()) {
                hc hcVar = (hc) it.next();
                if (hcVar != null) {
                    hcVar.d();
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
        }
    }

    public void hc() {
        this.k = com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_CANCELED;
        if (this.hv != null) {
            this.hv.d();
        }
        if (this.h != null) {
            this.h.b();
        }
        if (this.hv == null && this.h == null) {
            rf();
            this.k = com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_CANCELED;
            cb();
        }
        mt();
    }

    public com.ss.android.socialbase.downloader.h.c b() {
        return this.b;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int d(long r7, java.util.List<com.ss.android.socialbase.downloader.h.hc> r9) {
        /*
            r6 = this;
            boolean r0 = r6.j()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L5e
            boolean r0 = r6.tt
            if (r0 == 0) goto L1a
            if (r9 == 0) goto L13
            int r9 = r9.size()
            goto L5c
        L13:
            com.ss.android.socialbase.downloader.h.b r9 = r6.cb
            int r9 = r9.fj()
            goto L5c
        L1a:
            com.ss.android.socialbase.downloader.downloader.tc r9 = r6.w
            if (r9 == 0) goto L23
            int r9 = r9.d(r7)
            goto L29
        L23:
            com.ss.android.socialbase.downloader.downloader.tc r9 = r6.yo
            int r9 = r9.d(r7)
        L29:
            com.ss.android.socialbase.downloader.tt.mq r0 = com.ss.android.socialbase.downloader.tt.mq.d()
            com.ss.android.socialbase.downloader.tt.uo r0 = r0.hc()
            java.lang.String r3 = com.ss.android.socialbase.downloader.k.b.d
            java.lang.Object[] r4 = new java.lang.Object[r2]
            java.lang.String r5 = r0.name()
            r4[r1] = r5
            java.lang.String r5 = "NetworkQuality is : %s"
            java.lang.String r4 = java.lang.String.format(r5, r4)
            com.ss.android.socialbase.downloader.an.d.hc(r3, r4)
            com.ss.android.socialbase.downloader.h.b r3 = r6.cb
            java.lang.String r4 = r0.name()
            r3.gb(r4)
            com.ss.android.socialbase.downloader.downloader.tt r3 = r6.rf
            if (r3 == 0) goto L56
            int r9 = r3.d(r9, r0)
            goto L5c
        L56:
            com.ss.android.socialbase.downloader.downloader.tt r3 = r6.jh
            int r9 = r3.d(r9, r0)
        L5c:
            if (r9 > 0) goto L5f
        L5e:
            r9 = r2
        L5f:
            boolean r0 = com.ss.android.socialbase.downloader.an.d.d()
            if (r0 == 0) goto L88
            java.lang.String r0 = com.ss.android.socialbase.downloader.k.b.d
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = java.lang.String.valueOf(r9)
            r3[r1] = r4
            com.ss.android.socialbase.downloader.h.b r1 = r6.cb
            java.lang.String r1 = r1.gb()
            r3[r2] = r1
            r1 = 2
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r3[r1] = r7
            java.lang.String r7 = "chunk count : %s for %s contentLen:%s"
            java.lang.String r7 = java.lang.String.format(r7, r3)
            com.ss.android.socialbase.downloader.an.d.hc(r0, r7)
        L88:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.k.b.d(long, java.util.List):int");
    }

    private boolean tt() {
        int iW = this.cb.w();
        if (iW == 1 || this.cb.xi()) {
            return true;
        }
        if (iW == -2 || iW == -4) {
            return false;
        }
        hc(new com.ss.android.socialbase.downloader.u.d(1000, "The download Task can't start, because its status is not prepare:" + iW));
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d6 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00fe A[Catch: SQLiteException -> 0x0106, FINALLY_INSNS, TRY_LEAVE, TryCatch #10 {SQLiteException -> 0x0106, blocks: (B:80:0x00f6, B:82:0x00fe), top: B:94:0x00f6 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void tc() throws com.ss.android.socialbase.downloader.u.hc {
        /*
            Method dump skipped, instructions count: 267
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.k.b.tc():void");
    }

    @Override // java.lang.Runnable
    public void run() {
        com.ss.android.socialbase.downloader.downloader.b.d(this.b, 3);
        try {
            com.ss.android.socialbase.downloader.tt.hc.d().hc();
            mk();
            com.ss.android.socialbase.downloader.tt.hc.d().b();
            com.ss.android.socialbase.downloader.downloader.b.hc(this.b, 3);
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.tt.hc.d().b();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0059 A[LOOP:0: B:24:0x0059->B:56:0x0059, LOOP_START] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void mk() throws java.lang.SecurityException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.k.b.mk():void");
    }

    private void mq() {
        boolean z;
        List<com.ss.android.socialbase.downloader.h.hc> listB;
        try {
            this.k = com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_NONE;
            this.cb.q();
            this.cb.gv();
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.cb.d(-1L);
            try {
                tc();
                z = false;
            } catch (com.ss.android.socialbase.downloader.u.hc e) {
                com.ss.android.socialbase.downloader.an.d.hc(d, "file exist " + e.c());
                this.us = e.c();
                z = true;
            }
            if (!this.j) {
                this.de.hc();
            }
            this.j = false;
            if (de()) {
                return;
            }
            if (!TextUtils.isEmpty(this.us) && z) {
                if (this.cb.pq()) {
                    this.z = com.ss.android.socialbase.downloader.e.an.c(this.cb);
                }
                if (!this.z) {
                    uo();
                    return;
                }
            }
            while (!de()) {
                try {
                    try {
                        try {
                            z();
                            zw();
                            us();
                            listB = this.e.b(this.cb.h());
                            fs();
                        } catch (com.ss.android.socialbase.downloader.u.hc unused) {
                            uo();
                        } catch (com.ss.android.socialbase.downloader.u.d e2) {
                            com.ss.android.socialbase.downloader.an.d.c(d, "downloadInner: baseException = " + e2);
                            if (this.k != com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_PAUSE) {
                                if (e2.d() != 1025 && e2.d() != 1009) {
                                    if (d(e2)) {
                                        if (com.ss.android.socialbase.downloader.e.an.d(e2)) {
                                            ba();
                                        }
                                        if (d(e2, 0L) == com.ss.android.socialbase.downloader.u.tt.RETURN) {
                                            rf();
                                            return;
                                        }
                                        rf();
                                    } else {
                                        hc(e2);
                                    }
                                }
                                this.k = com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_END_RIGHT_NOW;
                                rf();
                                return;
                            }
                        }
                    } catch (Throwable th) {
                        com.ss.android.socialbase.downloader.an.d.c(d, "downloadInner: throwable =  " + th);
                        if (this.k != com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_PAUSE) {
                            hc(new com.ss.android.socialbase.downloader.u.d(1045, th));
                        }
                    }
                } catch (com.ss.android.socialbase.downloader.u.tc e3) {
                    try {
                        com.ss.android.socialbase.downloader.an.d.c(d, "downloadInner: retry throwable for " + e3.d());
                        if (this.k != com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_PAUSE) {
                            AtomicInteger atomicInteger = this.u;
                            if (atomicInteger != null && atomicInteger.get() > 0) {
                                this.cb.tt(this.u.decrementAndGet());
                                this.cb.c(5);
                            } else if (this.u == null) {
                                hc(new com.ss.android.socialbase.downloader.u.d(1043, "retry for Throwable, but retain retry time is NULL, last error is" + e3.d()));
                            } else if (this.cb.xq()) {
                                this.cb.c(5);
                                this.u.set(this.cb.hv());
                                this.cb.tt(this.u.get());
                            } else {
                                hc(new com.ss.android.socialbase.downloader.u.d(1018, String.format("retry for Throwable, but retry Time %s all used, last error is %s", String.valueOf(this.cb.hv()), e3.d())));
                            }
                            rf();
                        }
                    } catch (Throwable th2) {
                        rf();
                        throw th2;
                    }
                }
                if (k()) {
                    com.ss.android.socialbase.downloader.an.d.b(d, "downloadSegments return");
                    rf();
                    return;
                }
                String strY = this.cb.y();
                if (de()) {
                    rf();
                    return;
                }
                long jU = this.tt ? com.ss.android.socialbase.downloader.e.an.u(this.cb) : 0L;
                com.ss.android.socialbase.downloader.h.hc hcVarD = d(this.cb, jU);
                List<com.ss.android.socialbase.downloader.h.u> listD = d(hcVarD);
                com.ss.android.socialbase.downloader.e.an.d(listD, this.cb);
                com.ss.android.socialbase.downloader.e.an.hc(listD, this.cb);
                this.cb.e(0);
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                try {
                    d(strY, listD, jU);
                    this.cb.hc(System.currentTimeMillis() - jCurrentTimeMillis2);
                    if (de()) {
                        rf();
                        return;
                    }
                    long jMb = this.cb.mb();
                    d(jMb);
                    int iD = d(jMb, listB);
                    if (de()) {
                        rf();
                        return;
                    }
                    if (iD <= 0) {
                        throw new com.ss.android.socialbase.downloader.u.d(1032, "chunkCount is 0");
                    }
                    boolean z2 = iD == 1;
                    this.gb = z2;
                    if (z2) {
                        if (this.np == null) {
                            try {
                                jCurrentTimeMillis2 = System.currentTimeMillis();
                                d(strY, listD);
                                this.cb.hc(System.currentTimeMillis() - jCurrentTimeMillis2);
                            } finally {
                            }
                        }
                        if (de()) {
                            rf();
                            return;
                        } else {
                            this.cb.d(System.currentTimeMillis() - jCurrentTimeMillis);
                            e();
                            d(hcVarD, strY, this.np);
                        }
                    } else {
                        if (!this.cb.qy()) {
                            yo();
                        }
                        if (de()) {
                            rf();
                            return;
                        }
                        e();
                        this.cb.d(System.currentTimeMillis() - jCurrentTimeMillis);
                        if (this.tt) {
                            d(iD, listB);
                        } else {
                            d(jMb, iD);
                        }
                    }
                    rf();
                    return;
                } finally {
                }
            }
        } finally {
            cb();
        }
    }

    private void uo() {
        com.ss.android.socialbase.downloader.an.d.hc(d, "finishWithFileExist");
        if (com.ss.android.socialbase.downloader.uo.d.b().hc("fix_end_for_file_exist_error", true)) {
            if (this.us.equals(this.cb.gb())) {
                this.k = com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_END_RIGHT_NOW;
                return;
            } else {
                this.k = com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_END_FOR_FILE_EXIST;
                return;
            }
        }
        if (this.us.equals(this.cb.k())) {
            this.k = com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_END_RIGHT_NOW;
        } else {
            this.k = com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_END_FOR_FILE_EXIST;
        }
    }

    private boolean k() throws com.ss.android.socialbase.downloader.u.d, InterruptedException {
        if (this.cb.pq() || this.cb.fj() != 1 || this.cb.ii() > 0) {
            return false;
        }
        JSONObject jSONObjectC = com.ss.android.socialbase.downloader.uo.d.d(this.cb.h()).c("segment_config");
        List<com.ss.android.socialbase.downloader.mk.tt> listK = this.e.k(this.cb.h());
        if (this.cb.js() > 0) {
            if (listK == null || listK.isEmpty()) {
                return false;
            }
            if (jSONObjectC == null) {
                jSONObjectC = new JSONObject();
            }
        }
        if (jSONObjectC == null) {
            return false;
        }
        this.hv = new mk(this.cb, k.d(jSONObjectC), this);
        if (de()) {
            com.ss.android.socialbase.downloader.an.d.b(d, "downloadSegments: is stopped by user");
            if (this.k == com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_CANCELED) {
                this.hv.d();
            } else {
                this.hv.hc();
            }
            return true;
        }
        return this.hv.d(listK);
    }

    private void e() {
        if (com.ss.android.socialbase.downloader.uo.d.d(this.cb.h()).d("reset_retain_retry_times", 0) != 1 || this.r >= 3) {
            return;
        }
        this.u.set(this.cb.wl() ? this.cb.bc() : this.cb.hv());
        this.r++;
    }

    private void d(String str, List<com.ss.android.socialbase.downloader.h.u> list, long j) throws com.ss.android.socialbase.downloader.u.tc, com.ss.android.socialbase.downloader.u.d {
        hc(str, list, j);
        com.ss.android.socialbase.downloader.tt.h hVar = this.yi;
        if (hVar != null) {
            try {
                d(str, hVar, j);
            } catch (Throwable unused) {
                this.s = true;
            }
        }
        if (this.yi == null || this.s) {
            d(str, list);
            d(str, this.np, j);
        }
    }

    private void cb() {
        boolean zV;
        boolean z;
        com.ss.android.socialbase.downloader.an.d.hc(d, "endDownloadRunnable::runStatus=" + this.k);
        boolean z2 = (this.k == com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_PAUSE || this.k == com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_CANCELED) ? false : true;
        try {
            zV = v();
            z = false;
        } catch (Exception e) {
            if (e instanceof com.ss.android.socialbase.downloader.u.d) {
                this.de.d((com.ss.android.socialbase.downloader.u.d) e);
            } else {
                this.de.d(new com.ss.android.socialbase.downloader.u.d(1046, e));
            }
            zV = true;
            z = true;
        }
        if (zV || z) {
            this.uo.set(false);
            if (z2) {
                try {
                    com.ss.android.socialbase.downloader.impls.d dVarJ = com.ss.android.socialbase.downloader.downloader.b.j();
                    if (dVarJ != null) {
                        dVarJ.d(this);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.mq.d(th);
                    zw zwVarU = this.b.u();
                    com.ss.android.socialbase.downloader.h.b bVar = this.cb;
                    com.ss.android.socialbase.downloader.u.d dVar = new com.ss.android.socialbase.downloader.u.d(1014, com.ss.android.socialbase.downloader.e.an.hc(th, "removeDownloadRunnable"));
                    com.ss.android.socialbase.downloader.h.b bVar2 = this.cb;
                    com.ss.android.socialbase.downloader.gb.d.d(zwVarU, bVar, dVar, bVar2 != null ? bVar2.w() : 0);
                    return;
                }
            }
            return;
        }
        this.j = true;
        com.ss.android.socialbase.downloader.an.d.hc(d, "jump to restart");
    }

    private void hc(String str, List<com.ss.android.socialbase.downloader.h.u> list, long j) throws com.ss.android.socialbase.downloader.u.tc, com.ss.android.socialbase.downloader.u.d {
        com.ss.android.socialbase.downloader.tt.d.b bVarD;
        boolean z = true;
        if (this.cb.fj() == 1 && (bVarD = com.ss.android.socialbase.downloader.tt.d.d.d().d(str, list)) != null) {
            this.yi = bVarD;
            this.cb.e(1);
        }
        if (this.yi == null && !this.s && this.cb.fy()) {
            try {
                int iHc = this.mt.hc("net_lib_strategy");
                if (this.mt.d("monitor_download_connect", 0) <= 0) {
                    z = false;
                }
                this.yi = com.ss.android.socialbase.downloader.downloader.b.d(str, list, iHc, z, this.cb);
            } catch (Throwable th) {
                this.cb.d(com.ss.android.socialbase.downloader.e.an.tc(th));
            }
        }
    }

    private void d(String str, List<com.ss.android.socialbase.downloader.h.u> list) throws com.ss.android.socialbase.downloader.u.tc, com.ss.android.socialbase.downloader.u.d {
        com.ss.android.socialbase.downloader.tt.tt ttVarD;
        if (this.np != null) {
            return;
        }
        com.ss.android.socialbase.downloader.tt.d.c cVarHc = this.cb.fj() == 1 ? com.ss.android.socialbase.downloader.tt.d.d.d().hc(str, list) : null;
        try {
            if (cVarHc != null) {
                d(this.np);
                this.cb.e(2);
                this.np = cVarHc;
            } else {
                try {
                    ttVarD = com.ss.android.socialbase.downloader.downloader.b.d(this.cb.e(), this.cb.r(), str, null, list, this.mt.hc("net_lib_strategy"), this.mt.d("monitor_download_connect", 0) > 0, this.cb);
                    this.np = ttVarD;
                } catch (com.ss.android.socialbase.downloader.u.d e) {
                    throw e;
                } catch (Throwable th) {
                    if (this.cb.pq() && com.ss.android.socialbase.downloader.e.an.h(th) && com.ss.android.socialbase.downloader.e.an.b(list)) {
                        com.ss.android.socialbase.downloader.an.d.hc(d, "dcache=execepiton responseCode=304 lastModified not changed, use local file.. old cacheControl=" + this.cb.dz());
                        long jTt = com.ss.android.socialbase.downloader.e.an.tt(this.cb.dz());
                        if (jTt <= 0) {
                            jTt = com.ss.android.socialbase.downloader.uo.d.d(this.cb.h()).d("default_304_max_age", 300);
                        }
                        this.cb.c(System.currentTimeMillis() + (jTt * 1000));
                        throw new com.ss.android.socialbase.downloader.u.hc(this.us);
                    }
                    if (com.ss.android.socialbase.downloader.e.an.an(th)) {
                        d("", "http code 416");
                    } else if (com.ss.android.socialbase.downloader.e.an.u(th)) {
                        d("", "http code 412");
                    } else {
                        com.ss.android.socialbase.downloader.e.an.d(th, "CreateFirstConnection");
                    }
                    ttVarD = this.np;
                }
                d(ttVarD);
            }
            if (this.np == null) {
                throw new com.ss.android.socialbase.downloader.u.d(1022, new IOException("download can't continue, firstConnection is null"));
            }
        } catch (Throwable th2) {
            d(this.np);
            throw th2;
        }
    }

    private void w() {
        com.ss.android.socialbase.downloader.tt.h hVar = this.yi;
        if (hVar != null) {
            hVar.b();
            this.yi = null;
        }
    }

    private void yo() {
        com.ss.android.socialbase.downloader.tt.tt ttVar = this.np;
        if (ttVar != null) {
            ttVar.c();
            this.np = null;
        }
    }

    private void rf() {
        w();
        yo();
    }

    public static com.ss.android.socialbase.downloader.h.hc d(com.ss.android.socialbase.downloader.h.b bVar, long j) {
        return new hc.d(bVar.h()).d(-1).d(0L).u(j).hc(j).b(0L).c(bVar.mb() - j).d();
    }

    private List<com.ss.android.socialbase.downloader.h.u> d(com.ss.android.socialbase.downloader.h.hc hcVar) {
        List<com.ss.android.socialbase.downloader.h.u> listD = com.ss.android.socialbase.downloader.e.an.d(this.cb.mt(), this.cb.o(), hcVar);
        if (this.cb.pq() && this.z && this.cb.nr() != null) {
            listD.add(new com.ss.android.socialbase.downloader.h.u("if-modified-since", this.cb.nr()));
            listD.add(new com.ss.android.socialbase.downloader.h.u("download-tc21-1-15", "download-tc21-1-15"));
            com.ss.android.socialbase.downloader.an.d.hc(d, "dcache::add head IF_MODIFIED_SINCE=" + this.cb.nr());
        }
        return listD;
    }

    private void jh() throws com.ss.android.socialbase.downloader.u.d {
        if (this.h != null) {
            if (this.k == com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_CANCELED) {
                this.cb.c(-4);
                this.h.b();
            } else if (this.k == com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_PAUSE) {
                this.cb.c(-2);
                this.h.hc();
            } else {
                this.h.c();
            }
        }
    }

    private boolean sy() {
        return this.k == com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_CANCELED || this.k == com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_PAUSE;
    }

    private boolean de() {
        if (!sy() && this.cb.w() != -2) {
            return false;
        }
        if (sy()) {
            return true;
        }
        if (this.cb.w() == -2) {
            this.k = com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_PAUSE;
            return true;
        }
        if (this.cb.w() != -4) {
            return true;
        }
        this.k = com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_CANCELED;
        return true;
    }

    private boolean v() {
        if (this.k == com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_ERROR) {
            this.de.d(this.v);
        } else if (this.k == com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_CANCELED) {
            this.de.b();
        } else if (this.k == com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_PAUSE) {
            this.de.c();
        } else if (this.k == com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_END_RIGHT_NOW) {
            try {
                this.de.h();
            } catch (com.ss.android.socialbase.downloader.u.d e) {
                this.de.d(e);
            }
        } else if (this.k == com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_END_FOR_FILE_EXIST) {
            try {
                this.de.d(this.us);
            } catch (com.ss.android.socialbase.downloader.u.d e2) {
                this.de.d(e2);
            }
        } else {
            if (this.k == com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET) {
                this.de.d(this.v, false);
                return false;
            }
            if (this.k == com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                return true;
            }
            if (this.k == com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_RETRY_DELAY && !np()) {
                com.ss.android.socialbase.downloader.an.d.hc(d, "doTaskStatusHandle retryDelay");
                he();
                return this.k == com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_RETRY_DELAY;
            }
            try {
                if (!yi()) {
                    return false;
                }
                this.de.an();
                yo.d().c();
            } catch (Throwable th) {
                hc(new com.ss.android.socialbase.downloader.u.d(1008, com.ss.android.socialbase.downloader.e.an.hc(th, "doTaskStatusHandle onComplete")));
            }
        }
        return true;
    }

    private boolean np() {
        if (this.cb.fj() <= 1) {
            return this.cb.js() > 0 && this.cb.js() == this.cb.mb();
        }
        List<com.ss.android.socialbase.downloader.h.hc> listB = this.e.b(this.cb.h());
        if (listB == null || listB.size() <= 1) {
            return false;
        }
        for (com.ss.android.socialbase.downloader.h.hc hcVar : listB) {
            if (hcVar == null || !hcVar.tt()) {
                return false;
            }
        }
        return true;
    }

    private boolean yi() {
        if (this.cb.n()) {
            com.ss.android.socialbase.downloader.h.b bVar = this.cb;
            bVar.h(bVar.js());
        }
        com.ss.android.socialbase.downloader.an.d.b(d, "checkCompletedByteValid: downloadInfo.getCurBytes() = " + this.cb.js() + ",  downloadInfo.getTotalBytes() = " + this.cb.mb());
        if (this.cb.js() > 0) {
            if (this.cb.zv()) {
                return true;
            }
            if (this.cb.mb() > 0 && this.cb.js() == this.cb.mb()) {
                return true;
            }
        }
        this.cb.d(com.ss.android.socialbase.downloader.hc.hc.BYTE_INVALID_RETRY_STATUS_RESTART);
        this.cb.eh();
        this.e.d(this.cb);
        this.e.c(this.cb.h());
        this.e.uo(this.cb.h());
        com.ss.android.socialbase.downloader.e.an.d(this.cb);
        return false;
    }

    private void he() {
        this.k = com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_NONE;
    }

    private long vv() {
        return this.sy.d(this.cb.tr(), this.cb.dc());
    }

    private void zw() throws com.ss.android.socialbase.downloader.u.tc, com.ss.android.socialbase.downloader.u.d {
        com.ss.android.socialbase.downloader.impls.d dVarJ;
        int iH = this.cb.h();
        int iD = com.ss.android.socialbase.downloader.downloader.b.d(this.cb);
        if (this.cb.g() && !this.cb.pq() && !this.z) {
            throw new com.ss.android.socialbase.downloader.u.d(1009, "file has downloaded");
        }
        com.ss.android.socialbase.downloader.h.b bVarHc = this.e.hc(iD);
        if (bVarHc == null || (dVarJ = com.ss.android.socialbase.downloader.downloader.b.j()) == null || bVarHc.h() == iH || !bVarHc.hc(this.cb)) {
            return;
        }
        if (dVarJ.d(bVarHc.h())) {
            this.e.an(iH);
            throw new com.ss.android.socialbase.downloader.u.d(1025, "another same task is downloading");
        }
        List<com.ss.android.socialbase.downloader.h.hc> listB = this.e.b(iD);
        com.ss.android.socialbase.downloader.e.an.d(this.cb);
        this.e.an(iD);
        if (bVarHc == null || !bVarHc.ij()) {
            return;
        }
        this.cb.d(bVarHc, false);
        this.e.d(this.cb);
        if (listB != null) {
            for (com.ss.android.socialbase.downloader.h.hc hcVar : listB) {
                hcVar.hc(iH);
                this.e.d(hcVar);
            }
        }
        throw new com.ss.android.socialbase.downloader.u.tc("retry task because id generator changed");
    }

    private void d(int i, List<com.ss.android.socialbase.downloader.h.hc> list) throws com.ss.android.socialbase.downloader.u.d {
        if (list.size() != i) {
            throw new com.ss.android.socialbase.downloader.u.d(1033, new IllegalArgumentException());
        }
        d(list, this.cb.mb());
    }

    private void d(long j, int i) throws com.ss.android.socialbase.downloader.u.d {
        long j2 = j / i;
        int iH = this.cb.h();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        long j3 = 0;
        while (i2 < i) {
            com.ss.android.socialbase.downloader.h.hc hcVarD = new hc.d(iH).d(i2).d(j3).u(j3).hc(j3).b(i2 == i + (-1) ? 0L : (j3 + j2) - 1).d();
            arrayList.add(hcVarD);
            this.e.d(hcVarD);
            j3 += j2;
            i2++;
        }
        this.cb.u(i);
        this.e.d(iH, i);
        d(arrayList, j);
    }

    private void d(List<com.ss.android.socialbase.downloader.h.hc> list, long j) throws com.ss.android.socialbase.downloader.u.d {
        long jCb;
        for (com.ss.android.socialbase.downloader.h.hc hcVar : list) {
            if (hcVar != null) {
                if (hcVar.cb() == 0) {
                    jCb = j - hcVar.k();
                } else {
                    jCb = (hcVar.cb() - hcVar.k()) + 1;
                }
                if (jCb > 0) {
                    hcVar.d(jCb);
                    if (this.cb.qy() && this.np != null && (!this.cb.fy() || this.s)) {
                        if (hcVar.rf() == 0) {
                            this.an.add(new hc(hcVar, this.b, this.np, this));
                        } else if (hcVar.rf() > 0) {
                            this.an.add(new hc(hcVar, this.b, this));
                        }
                    } else {
                        this.an.add(new hc(hcVar, this.b, this));
                    }
                }
            }
        }
        if (com.ss.android.socialbase.downloader.e.d.d(64)) {
            ArrayList arrayList = new ArrayList(this.an.size());
            Iterator<hc> it = this.an.iterator();
            while (it.hasNext()) {
                hc next = it.next();
                if (this.k == com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_CANCELED) {
                    next.hc();
                } else if (this.k == com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_PAUSE) {
                    next.d();
                } else {
                    arrayList.add(next);
                }
            }
            try {
                List<Future> listC = com.ss.android.socialbase.downloader.impls.u.c(arrayList);
                for (Runnable runnableU = (Runnable) arrayList.remove(0); runnableU != null; runnableU = com.ss.android.socialbase.downloader.impls.u.u(listC)) {
                    if (de()) {
                        return;
                    }
                    try {
                        runnableU.run();
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.mq.d(th);
                    }
                }
                if (listC == null || listC.isEmpty()) {
                    return;
                }
                for (Future future : listC) {
                    if (future != null && !future.isDone()) {
                        try {
                            future.get();
                        } catch (Throwable unused) {
                        }
                    }
                }
                return;
            } catch (Throwable unused2) {
                return;
            }
        }
        ArrayList arrayList2 = new ArrayList(this.an.size());
        Iterator<hc> it2 = this.an.iterator();
        while (it2.hasNext()) {
            hc next2 = it2.next();
            if (this.k == com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_CANCELED) {
                next2.hc();
            } else if (this.k == com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_PAUSE) {
                next2.d();
            } else {
                arrayList2.add(Executors.callable(next2));
            }
        }
        if (de()) {
            return;
        }
        try {
            com.ss.android.socialbase.downloader.impls.u.b(arrayList2);
        } catch (InterruptedException e) {
            throw new com.ss.android.socialbase.downloader.u.d(1020, e);
        }
    }

    private void d(com.ss.android.socialbase.downloader.h.hc hcVar, String str, com.ss.android.socialbase.downloader.tt.tt ttVar) throws com.ss.android.socialbase.downloader.u.d {
        hcVar.d(this.cb.mb() - hcVar.k());
        this.cb.u(1);
        this.e.d(this.cb.h(), 1);
        this.h = new com.ss.android.socialbase.downloader.downloader.u(this.cb, str, ttVar, hcVar, this);
        jh();
    }

    private boolean j() {
        com.ss.android.socialbase.downloader.h.b bVar = this.cb;
        return (bVar == null || bVar.pq() || (this.tt && this.cb.fj() <= 1) || this.cb.om() || !this.tc || this.mq) ? false : true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:91|(4:9|(1:11)|12|(4:14|15|16|(9:18|(2:20|(1:22)(2:23|24))(1:25)|26|(3:28|(1:30)|54)|89|55|56|77|78)(2:31|(6:33|89|55|56|77|78)(4:34|(1:36)(1:37)|38|39)))(1:40))(2:41|(4:43|(1:45)(1:46)|47|48)(2:51|(2:81|82)))|53|54|89|55|56|77|78) */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x017c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x017e, code lost:
    
        com.ss.android.socialbase.downloader.an.d.u(com.ss.android.socialbase.downloader.k.b.d, "checkSpaceOverflow: setLength1 e = " + r0 + ", mustSetLength = " + r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01a0, code lost:
    
        if (r7 >= r24) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01ac, code lost:
    
        r5.hc(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01b0, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01b2, code lost:
    
        com.ss.android.socialbase.downloader.an.d.u(com.ss.android.socialbase.downloader.k.b.d, "checkSpaceOverflow: setLength2 ex = " + r0 + ", mustSetLength = " + r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01ce, code lost:
    
        if (r4 == false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01d6, code lost:
    
        throw new com.ss.android.socialbase.downloader.u.d(1040, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01d7, code lost:
    
        if (r4 != false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01e8, code lost:
    
        throw new com.ss.android.socialbase.downloader.u.d(1040, r0);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [long] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v8, types: [com.ss.android.socialbase.downloader.h.h] */
    @Override // com.ss.android.socialbase.downloader.k.an
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d(long r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 507
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.k.b.d(long):void");
    }

    private void s() throws com.ss.android.socialbase.downloader.u.d {
        long jC;
        int iD;
        try {
            jC = com.ss.android.socialbase.downloader.e.an.c(this.cb.mq());
        } catch (com.ss.android.socialbase.downloader.u.d unused) {
            jC = 0;
        }
        String str = d;
        com.ss.android.socialbase.downloader.an.d.b(str, "checkSpaceOverflowInProgress: available = " + com.ss.android.socialbase.downloader.e.an.d(jC) + "MB");
        if (jC > 0) {
            long jMb = this.cb.mb() - this.cb.js();
            if (jC < jMb && (iD = com.ss.android.socialbase.downloader.uo.d.d(this.cb.h()).d("space_fill_min_keep_mb", 100)) > 0) {
                long j = jC - (iD * 1048576);
                com.ss.android.socialbase.downloader.an.d.b(str, "checkSpaceOverflowInProgress: minKeep  = " + iD + "MB, canDownload = " + com.ss.android.socialbase.downloader.e.an.d(j) + "MB");
                if (j <= 0) {
                    this.fs = 0L;
                    throw new com.ss.android.socialbase.downloader.u.u(jC, jMb);
                }
                this.fs = this.cb.js() + j + 1048576;
                return;
            }
        }
        this.fs = 0L;
    }

    private void us() throws com.ss.android.socialbase.downloader.u.h {
        if (this.cb.np() && !com.ss.android.socialbase.downloader.e.an.d(com.ss.android.socialbase.downloader.downloader.b.tr(), g.b)) {
            throw new com.ss.android.socialbase.downloader.u.h(1019, String.format("download task need permission:%s", g.b));
        }
        if (!this.cb.wz()) {
            throw new com.ss.android.socialbase.downloader.u.c();
        }
        if (!this.cb.vg()) {
            throw new com.ss.android.socialbase.downloader.u.an();
        }
    }

    private void z() throws InterruptedException, com.ss.android.socialbase.downloader.u.d {
        if (TextUtils.isEmpty(this.cb.mk())) {
            throw new com.ss.android.socialbase.downloader.u.d(1028, "download savePath can not be empty");
        }
        if (TextUtils.isEmpty(this.cb.gb())) {
            throw new com.ss.android.socialbase.downloader.u.d(1029, "download name can not be empty");
        }
        File file = new File(this.cb.mk());
        if (!file.exists()) {
            boolean zMkdirs = file.mkdirs();
            if (zMkdirs || file.exists()) {
                return;
            }
            int i = 0;
            if (com.ss.android.socialbase.downloader.uo.d.d(this.cb.h()).d("opt_mkdir_failed", 0) == 1) {
                while (!zMkdirs) {
                    int i2 = i + 1;
                    if (i >= 3) {
                        break;
                    }
                    try {
                        Thread.sleep(10L);
                        zMkdirs = file.mkdirs();
                        i = i2;
                    } catch (InterruptedException unused) {
                    }
                }
                if (zMkdirs || file.exists()) {
                    return;
                }
                if (com.ss.android.socialbase.downloader.e.an.c(this.cb.mk()) < 16384) {
                    throw new com.ss.android.socialbase.downloader.u.d(1006, "download savePath directory can not created:" + this.cb.mk());
                }
                throw new com.ss.android.socialbase.downloader.u.d(1030, "download savePath directory can not created:" + this.cb.mk());
            }
            throw new com.ss.android.socialbase.downloader.u.d(1030, "download savePath directory can not created:" + this.cb.mk());
        }
        if (file.isDirectory()) {
            return;
        }
        if (com.ss.android.socialbase.downloader.e.c.hc(this.cb)) {
            file.delete();
            if (!file.mkdirs() && !file.exists()) {
                throw new com.ss.android.socialbase.downloader.u.d(1031, "download savePath is not directory:path=" + this.cb.mk());
            }
            return;
        }
        throw new com.ss.android.socialbase.downloader.u.d(1031, "download savePath is not a directory:" + this.cb.mk());
    }

    private boolean d(int i, String str, String str2) {
        if (i == 412) {
            return true;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.equals(str2) || !(this.mk || this.tc)) {
            return (i == 201 || i == 416) && this.cb.js() > 0;
        }
        return true;
    }

    private void d(String str, String str2) throws com.ss.android.socialbase.downloader.u.tc {
        this.e.c(this.cb.h());
        this.e.uo(this.cb.h());
        com.ss.android.socialbase.downloader.e.an.d(this.cb);
        this.tt = false;
        this.cb.mq(str);
        this.e.d(this.cb);
        throw new com.ss.android.socialbase.downloader.u.tc(str2);
    }

    @Override // com.ss.android.socialbase.downloader.k.an
    public void d(String str, com.ss.android.socialbase.downloader.tt.h hVar, long j) throws com.ss.android.socialbase.downloader.u.tc, com.ss.android.socialbase.downloader.u.d {
        com.ss.android.socialbase.downloader.tt.h hVar2;
        String str2;
        long jHc;
        if (hVar == null) {
            return;
        }
        try {
            com.ss.android.socialbase.downloader.h.an anVar = new com.ss.android.socialbase.downloader.h.an(str, hVar);
            int i = anVar.b;
            String strC = anVar.c();
            if (TextUtils.isEmpty(this.cb.hg()) && !TextUtils.isEmpty(strC)) {
                this.cb.tc(strC);
            }
            boolean zHc = anVar.hc();
            this.tc = zHc;
            this.cb.mk(zHc);
            this.mk = anVar.d();
            String strO = this.cb.o();
            String strB = anVar.b();
            String strAn = anVar.an();
            String strH = anVar.h();
            String str3 = d;
            com.ss.android.socialbase.downloader.an.d.hc(str3, "dcache=responseCode=" + i + " last_modified=" + strAn + " CACHE_CONTROL=" + strH + " max-age=" + anVar.mk() + " isDeleteCacheIfCheckFailed=" + this.cb.gw());
            com.ss.android.socialbase.downloader.an.d.hc(str3, "dcache=firstOffset=" + j + " cur=" + strAn + " before=" + this.cb.nr() + " cur=" + anVar.tc() + " before=" + this.cb.mb());
            if (!TextUtils.isEmpty(strH)) {
                this.cb.b(strH);
                if (anVar.mk() > 0) {
                    this.cb.c(System.currentTimeMillis() + (anVar.mk() * 1000));
                }
            }
            if (this.cb.pq() && this.z && !TextUtils.isEmpty(this.us)) {
                boolean z = false;
                if (i == 304 || ((!TextUtils.isEmpty(this.cb.nr()) || !this.cb.gw()) && TextUtils.equals(strAn, this.cb.nr()))) {
                    z = true;
                }
                if (z) {
                    com.ss.android.socialbase.downloader.an.d.hc(str3, "dcache=responseCode=" + i + " lastModified not changed, use local file  " + strAn);
                    throw new com.ss.android.socialbase.downloader.u.hc(this.us);
                }
                com.ss.android.socialbase.downloader.e.an.d(this.cb);
            }
            if (j > 0 && this.cb.pq() && !TextUtils.equals(strAn, this.cb.nr())) {
                com.ss.android.socialbase.downloader.an.d.hc(str3, "dcache cdn file change, so retry");
                d("", "cdn file changed");
            }
            if (!TextUtils.isEmpty(strAn)) {
                this.cb.c(strAn);
            }
            if (d(i, strO, strB)) {
                hVar2 = hVar;
                if (hVar2 instanceof com.ss.android.socialbase.downloader.tt.tt) {
                    str2 = (TextUtils.isEmpty(strO) || !strO.equals(strB)) ? strB : "";
                    d(str2, "eTag of server file changed");
                } else {
                    throw new com.ss.android.socialbase.downloader.u.b(1002, i, "");
                }
            } else {
                hVar2 = hVar;
                str2 = strB;
            }
            if (!this.tc && !this.mk) {
                if (i == 403) {
                    throw new com.ss.android.socialbase.downloader.u.d(1047, "response code error : 403");
                }
                throw new com.ss.android.socialbase.downloader.u.b(1004, i, "response code error : " + i);
            }
            if (this.mk && j > 0) {
                if (hVar2 instanceof com.ss.android.socialbase.downloader.tt.tt) {
                    d("", "http head request not support");
                } else {
                    throw new com.ss.android.socialbase.downloader.u.d(1004, "isResponseFromBegin but firstOffset > 0");
                }
            }
            long jGb = anVar.gb();
            if (!(hVar2 instanceof com.ss.android.socialbase.downloader.tt.tt) && jGb < 0 && com.ss.android.socialbase.downloader.e.c.d(this.cb)) {
                throw new com.ss.android.socialbase.downloader.u.d(1004, "");
            }
            String strD = TextUtils.isEmpty(this.cb.gb()) ? com.ss.android.socialbase.downloader.e.an.d(hVar2, this.cb.tc()) : "";
            boolean zTt = anVar.tt();
            this.mq = zTt;
            if (!zTt && jGb == 0 && !(hVar2 instanceof com.ss.android.socialbase.downloader.tt.tt)) {
                throw new com.ss.android.socialbase.downloader.u.d(1004, "");
            }
            if (zTt) {
                jHc = -1;
            } else {
                String strHc = com.ss.android.socialbase.downloader.e.an.hc(hVar2, "Content-Range");
                com.ss.android.socialbase.downloader.an.d.b(str3, "firstConnection: contentRange = " + strHc);
                if (!TextUtils.isEmpty(strHc) && this.mt.hc("fix_get_total_bytes", true)) {
                    jHc = com.ss.android.socialbase.downloader.e.an.hc(strHc);
                    com.ss.android.socialbase.downloader.an.d.b(str3, "firstConnection: 1 totalLength = " + jHc);
                } else {
                    jHc = j + jGb;
                    com.ss.android.socialbase.downloader.an.d.u(str3, "firstConnection: 2 totalLength = " + jHc + ", contentLength = " + jGb);
                }
            }
            if (!TextUtils.isEmpty(this.cb.he()) && this.cb.mb() > 0 && jHc != this.cb.mb()) {
                if (hVar2 instanceof com.ss.android.socialbase.downloader.tt.tt) {
                    d("", "file totalLength changed");
                } else {
                    throw new com.ss.android.socialbase.downloader.u.b(1002, i, "");
                }
            }
            if (de()) {
                return;
            }
            if (this.cb.ba() > 0 && com.ss.android.socialbase.downloader.uo.d.d(this.cb.h()).hc("force_check_file_length") == 1 && this.cb.ba() != jHc) {
                throw new com.ss.android.socialbase.downloader.u.d(1070, "expectFileLength = " + this.cb.ba() + " , totalLength = " + jHc);
            }
            this.de.d(jHc, str2, strD);
        } catch (com.ss.android.socialbase.downloader.u.d e) {
            throw e;
        } catch (com.ss.android.socialbase.downloader.u.tc e2) {
            throw e2;
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.e.an.d(th, "HandleFirstConnection");
        }
    }

    public boolean c() {
        return this.uo.get();
    }

    public int u() {
        com.ss.android.socialbase.downloader.h.b bVar = this.cb;
        if (bVar != null) {
            return bVar.h();
        }
        return 0;
    }

    public void an() {
        this.ba = System.currentTimeMillis();
        this.de.d();
    }

    private void fs() {
        long jAn = com.ss.android.socialbase.downloader.e.an.an(this.cb);
        long jJs = this.cb.js();
        if (jAn != jJs) {
            com.ss.android.socialbase.downloader.an.d.c(d, "checkTaskCanResume: offset = " + jAn + ", curBytes = " + jJs);
        }
        this.cb.u(jAn);
        boolean z = jAn > 0;
        this.tt = z;
        if (z || this.z) {
            return;
        }
        com.ss.android.socialbase.downloader.an.d.b(d, "checkTaskCanResume: deleteAllDownloadFiles");
        this.e.c(this.cb.h());
        this.e.uo(this.cb.h());
        com.ss.android.socialbase.downloader.e.an.d(this.cb);
    }

    @Override // com.ss.android.socialbase.downloader.k.an
    public boolean hc(long j) throws com.ss.android.socialbase.downloader.u.d {
        if (this.fs > 0 && this.cb.js() > this.fs) {
            s();
        }
        return this.de.d(j);
    }

    @Override // com.ss.android.socialbase.downloader.k.an
    public void d(hc hcVar) {
        if (this.gb) {
            return;
        }
        synchronized (this) {
            this.an.remove(hcVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.k.an
    public boolean d(com.ss.android.socialbase.downloader.u.d dVar) {
        if (this.hv != null && com.ss.android.socialbase.downloader.e.an.tt(dVar) && this.u.get() < this.cb.hv()) {
            return false;
        }
        if (com.ss.android.socialbase.downloader.e.an.hc(dVar)) {
            if (this.gb && !this.c) {
                com.ss.android.socialbase.downloader.e.an.d(this.cb);
                this.c = true;
            }
            return true;
        }
        AtomicInteger atomicInteger = this.u;
        return ((atomicInteger != null && atomicInteger.get() > 0) || this.cb.yl() || (dVar != null && ((dVar.d() == 1011 || (dVar.getCause() != null && (dVar.getCause() instanceof SSLHandshakeException))) && this.cb.nz()))) && !(dVar instanceof com.ss.android.socialbase.downloader.u.h);
    }

    @Override // com.ss.android.socialbase.downloader.k.an
    public void hc(com.ss.android.socialbase.downloader.u.d dVar) {
        com.ss.android.socialbase.downloader.an.d.hc(d, "onError:" + dVar.getMessage());
        this.k = com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_ERROR;
        this.v = dVar;
        mt();
    }

    private void ba() {
        com.ss.android.socialbase.downloader.an.d.c(d, "clearCurrentDownloadData::" + Log.getStackTraceString(new Throwable()));
        try {
            this.e.c(this.cb.h());
            this.e.uo(this.cb.h());
            com.ss.android.socialbase.downloader.e.an.d(this.cb);
            this.tt = false;
            this.cb.mq("");
            this.e.d(this.cb);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.k.an
    public void b(com.ss.android.socialbase.downloader.u.d dVar) {
        com.ss.android.socialbase.downloader.h.b bVar = this.cb;
        if (bVar != null) {
            bVar.k(true);
        }
        d(dVar, false);
    }

    @Override // com.ss.android.socialbase.downloader.k.an
    public void d(com.ss.android.socialbase.downloader.u.d dVar, boolean z) {
        com.ss.android.socialbase.downloader.an.d.hc(d, "onAllChunkRetryWithReset");
        this.k = com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET;
        this.v = dVar;
        mt();
        if (z ? c(dVar) : false) {
            return;
        }
        ba();
    }

    private void mt() {
        try {
            Iterator it = ((ArrayList) this.an.clone()).iterator();
            while (it.hasNext()) {
                hc hcVar = (hc) it.next();
                if (hcVar != null) {
                    hcVar.hc();
                }
            }
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.an.d.b(d, "cancelAllChunkRunnable: " + th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.cb.d(list, this.k == com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_WAITING_ASYNC_HANDLER);
        com.ss.android.socialbase.downloader.impls.d dVarJ = com.ss.android.socialbase.downloader.downloader.b.j();
        if (dVarJ != null) {
            dVarJ.mq(this.cb.h());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        com.ss.android.socialbase.downloader.impls.d dVarJ;
        if (de() || (dVarJ = com.ss.android.socialbase.downloader.downloader.b.j()) == null) {
            return;
        }
        dVarJ.mq(this.cb.h());
    }

    @Override // com.ss.android.socialbase.downloader.k.an
    public com.ss.android.socialbase.downloader.u.tt d(com.ss.android.socialbase.downloader.h.hc hcVar, com.ss.android.socialbase.downloader.u.d dVar, long j) {
        if (sy()) {
            return com.ss.android.socialbase.downloader.u.tt.RETURN;
        }
        if (dVar != null && (dVar.d() == 1047 || com.ss.android.socialbase.downloader.e.an.gb(dVar))) {
            return d(dVar, j);
        }
        this.v = dVar;
        this.cb.an(-j);
        this.e.d(this.cb);
        if (c(dVar)) {
            return com.ss.android.socialbase.downloader.u.tt.RETURN;
        }
        this.de.d(hcVar, dVar, this.k == com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_RETRY_DELAY);
        if (this.k != com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_RETRY_DELAY && this.cb.ho()) {
            long jVv = vv();
            if (jVv > 0) {
                com.ss.android.socialbase.downloader.an.d.b(d, "onSingleChunkRetry with delay time " + jVv);
                try {
                    Thread.sleep(jVv);
                } catch (Throwable th) {
                    com.ss.android.socialbase.downloader.an.d.c(d, "onSingleChunkRetry:" + th.getMessage());
                }
            }
        }
        return com.ss.android.socialbase.downloader.u.tt.CONTINUE;
    }

    @Override // com.ss.android.socialbase.downloader.k.an
    public com.ss.android.socialbase.downloader.u.tt d(com.ss.android.socialbase.downloader.u.d dVar, long j) {
        long jMb;
        long jC;
        boolean z;
        this.v = dVar;
        this.cb.an(-j);
        this.e.d(this.cb);
        if (sy()) {
            return com.ss.android.socialbase.downloader.u.tt.RETURN;
        }
        if (dVar != null && dVar.d() == 1047) {
            if (this.he == null || this.cb.jm()) {
                if (c(dVar)) {
                    return com.ss.android.socialbase.downloader.u.tt.RETURN;
                }
            } else {
                com.ss.android.socialbase.downloader.c.hc hcVar = new com.ss.android.socialbase.downloader.c.hc() { // from class: com.ss.android.socialbase.downloader.k.b.1
                    @Override // com.ss.android.socialbase.downloader.c.hc, com.ss.android.socialbase.downloader.c.np
                    public void d(List<String> list) {
                        super.d(list);
                        b.this.d(list);
                    }
                };
                boolean zD = this.he.d(hcVar);
                this.cb.cj();
                if (zD) {
                    if (!hcVar.d()) {
                        mt();
                        this.de.gb();
                        this.k = com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_WAITING_ASYNC_HANDLER;
                        return com.ss.android.socialbase.downloader.u.tt.RETURN;
                    }
                    z = true;
                }
            }
            z = false;
        } else if (com.ss.android.socialbase.downloader.e.an.gb(dVar)) {
            if (this.vv == null) {
                hc(dVar);
                return com.ss.android.socialbase.downloader.u.tt.RETURN;
            }
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            com.ss.android.socialbase.downloader.c.yo yoVar = new com.ss.android.socialbase.downloader.c.yo() { // from class: com.ss.android.socialbase.downloader.k.b.2
                @Override // com.ss.android.socialbase.downloader.c.yo
                public void d() {
                    synchronized (b.this) {
                        atomicBoolean.set(true);
                        b.this.r();
                    }
                }
            };
            if (dVar instanceof com.ss.android.socialbase.downloader.u.u) {
                com.ss.android.socialbase.downloader.u.u uVar = (com.ss.android.socialbase.downloader.u.u) dVar;
                jC = uVar.c();
                jMb = uVar.u();
            } else {
                jMb = this.cb.mb();
                jC = -1;
            }
            synchronized (this) {
                if (this.vv.d(jC, jMb, yoVar)) {
                    if (!com.ss.android.socialbase.downloader.uo.d.d(this.cb.h()).hc("not_delete_when_clean_space", false)) {
                        yi();
                    }
                    if (!atomicBoolean.get()) {
                        if (this.k != com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                            this.k = com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_WAITING_ASYNC_HANDLER;
                            mt();
                            this.de.gb();
                        }
                        return com.ss.android.socialbase.downloader.u.tt.RETURN;
                    }
                    if (c(dVar)) {
                        return com.ss.android.socialbase.downloader.u.tt.RETURN;
                    }
                    z = true;
                } else {
                    if (this.k == com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                        return com.ss.android.socialbase.downloader.u.tt.RETURN;
                    }
                    hc(dVar);
                    return com.ss.android.socialbase.downloader.u.tt.RETURN;
                }
            }
        } else {
            if (c(dVar)) {
                return com.ss.android.socialbase.downloader.u.tt.RETURN;
            }
            z = false;
        }
        if (!z && hv()) {
            mt();
        }
        this.de.d(dVar, this.k == com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_RETRY_DELAY);
        return this.k == com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_RETRY_DELAY ? com.ss.android.socialbase.downloader.u.tt.RETURN : com.ss.android.socialbase.downloader.u.tt.CONTINUE;
    }

    private boolean c(com.ss.android.socialbase.downloader.u.d dVar) {
        AtomicInteger atomicInteger = this.u;
        boolean z = true;
        if (atomicInteger != null) {
            if (atomicInteger.get() <= 0 || (dVar != null && dVar.d() == 1070)) {
                if (this.cb.xq()) {
                    this.u.set(this.cb.bc());
                    this.cb.tt(this.u.get());
                } else if (dVar != null && ((dVar.d() == 1011 || (dVar.getCause() != null && (dVar.getCause() instanceof SSLHandshakeException))) && this.cb.nz())) {
                    this.u.set(this.cb.hv());
                    this.cb.tt(this.u.get());
                    this.cb.uo(true);
                } else {
                    hc(new com.ss.android.socialbase.downloader.u.d(dVar.d(), String.format("retry for exception, but current retry time : %s , retry Time %s all used, last error is %s", String.valueOf(this.u), String.valueOf(this.cb.hv()), dVar.hc())));
                    return true;
                }
                z = false;
            }
            if (this.k != com.ss.android.socialbase.downloader.hc.tc.RUN_STATUS_RETRY_DELAY && z) {
                this.cb.tt(this.u.decrementAndGet());
            }
            return false;
        }
        hc(new com.ss.android.socialbase.downloader.u.d(1043, "retry for exception, but retain retry time is null, last error is :" + dVar.hc()));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.k.an
    public synchronized com.ss.android.socialbase.downloader.h.hc d(int i) {
        com.ss.android.socialbase.downloader.h.hc hcVarD;
        if (this.cb.fj() < 2) {
            return null;
        }
        List<com.ss.android.socialbase.downloader.h.hc> listB = this.e.b(this.cb.h());
        if (listB != null && !listB.isEmpty()) {
            for (int i2 = 0; i2 < listB.size(); i2++) {
                com.ss.android.socialbase.downloader.h.hc hcVar = listB.get(i2);
                if (hcVar != null && (hcVarD = d(hcVar, i)) != null) {
                    return hcVarD;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.k.an
    public void d(com.ss.android.socialbase.downloader.tt.h hVar) {
        boolean z;
        if (hVar != null) {
            try {
                int iHc = hVar.hc();
                this.cb.h(iHc);
                this.cb.tt(com.ss.android.socialbase.downloader.e.hc.d(iHc));
                z = true;
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.mq.d(th);
            }
        } else {
            z = false;
        }
        if (z) {
            return;
        }
        this.cb.h(-1);
        this.cb.tt("");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.ss.android.socialbase.downloader.h.hc d(com.ss.android.socialbase.downloader.h.hc r9, int r10) {
        /*
            Method dump skipped, instructions count: 320
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.k.b.d(com.ss.android.socialbase.downloader.h.hc, int):com.ss.android.socialbase.downloader.h.hc");
    }

    private jh d(com.ss.android.socialbase.downloader.h.c cVar) {
        jh jhVarH = cVar.h();
        if (jhVarH != null) {
            return jhVarH;
        }
        com.ss.android.socialbase.downloader.h.b bVarD = cVar.d();
        if (bVarD != null) {
            String strIc = bVarD.ic();
            if (!TextUtils.isEmpty(strIc)) {
                return new w(strIc);
            }
        }
        return com.ss.android.socialbase.downloader.downloader.b.bc();
    }

    public Future h() {
        return this.hc;
    }

    public void d(Future future) {
        this.hc = future;
    }
}
