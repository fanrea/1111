package com.ss.android.socialbase.downloader.mk;

import android.text.TextUtils;
import androidx.core.location.LocationRequestCompat;
import com.alipay.sdk.m.l.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
class uo implements Runnable {
    volatile long an;
    final int b;
    private boolean ba;
    private com.ss.android.socialbase.downloader.e.u bc;
    volatile long c;
    private com.ss.android.socialbase.downloader.h.an cb;
    volatile tt d;
    private volatile long de;
    private com.ss.android.socialbase.downloader.tt.tt e;
    private int fs;
    String gb;
    volatile long h;
    w hc;
    private volatile boolean he;
    private boolean hv;
    private int j;
    private volatile long jh;
    private final com.ss.android.socialbase.downloader.uo.d k;
    private final an mk;
    private final b mq;
    private com.ss.android.socialbase.downloader.u.d mt;
    private volatile boolean np;
    private boolean r;
    private volatile long rf;
    private int s;
    String tc;
    String tt;
    volatile long u;
    private final com.ss.android.socialbase.downloader.h.b uo;
    private int us;
    private Future v;
    private Thread vv;
    private volatile boolean yi;
    private long yo;
    private long z;
    private volatile boolean zw;
    private final List<tt> w = new ArrayList();
    private volatile long sy = -1;

    uo(com.ss.android.socialbase.downloader.h.b bVar, mk mkVar, b bVar2, w wVar, int i) {
        this.uo = bVar;
        this.mk = mkVar;
        this.mq = bVar2;
        this.k = com.ss.android.socialbase.downloader.uo.d.d(bVar.h());
        this.hc = wVar;
        this.b = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x007b, code lost:
    
        r5.d = null;
        r2 = r5.mk;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() throws java.lang.SecurityException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.mk.uo.run():void");
    }

    private boolean d(tt ttVar) throws com.ss.android.socialbase.downloader.u.d {
        mk();
        while (true) {
            try {
                hc(ttVar);
                c(ttVar);
                tt();
                return true;
            } catch (tc e) {
                this.mt = e;
                throw e;
            } catch (Throwable th) {
                try {
                    com.ss.android.socialbase.downloader.an.d.u("SegmentReader", "download: e = " + th + ", threadIndex = " + this.b + ", reconnect = " + this.yi + ", closed = " + this.np);
                    if (this.np) {
                        return false;
                    }
                    if (this.yi) {
                        this.yi = false;
                        try {
                            Thread.interrupted();
                        } catch (Throwable th2) {
                            com.bytedance.sdk.component.utils.mq.d(th2);
                        }
                        if (this.he) {
                            this.he = false;
                            throw new tc(5, "download");
                        }
                    } else {
                        com.bytedance.sdk.component.utils.mq.d(th);
                        com.ss.android.socialbase.downloader.u.d e2 = null;
                        if (th instanceof com.ss.android.socialbase.downloader.u.d) {
                            e2 = th;
                        } else {
                            try {
                                com.ss.android.socialbase.downloader.e.an.d((Throwable) th, "download");
                            } catch (com.ss.android.socialbase.downloader.u.d e3) {
                                e2 = e3;
                            }
                        }
                        if (e2 == null || !d(ttVar, e2)) {
                            return false;
                        }
                    }
                } finally {
                    tt();
                }
            }
        }
        return false;
    }

    private void tt() {
        this.z = this.c;
        this.c = -1L;
        this.u = -1L;
        this.an = -1L;
        this.h = -1L;
        tc();
    }

    private void tc() {
        com.ss.android.socialbase.downloader.tt.tt ttVar = this.e;
        if (ttVar != null) {
            try {
                com.ss.android.socialbase.downloader.an.d.b("SegmentReader", "closeConnection: thread = " + this.b);
                ttVar.c();
                ttVar.b();
            } catch (Throwable unused) {
            }
        }
    }

    private void mk() {
        this.ba = false;
        mq();
    }

    private void mq() {
        this.s = this.hc.c ? this.uo.hv() : this.uo.bc();
        this.us = 0;
    }

    boolean d(w wVar) {
        int i = this.fs;
        if (i >= 30) {
            return false;
        }
        this.fs = i + 1;
        w wVar2 = this.hc;
        if (wVar2 != null) {
            wVar2.hc(this);
        }
        wVar.d(this);
        this.hc = wVar;
        mq();
        return true;
    }

    private boolean d(tt ttVar, com.ss.android.socialbase.downloader.u.d dVar) {
        com.ss.android.socialbase.downloader.an.d.u("SegmentReader", "handleDownloadFailed:  e = " + dVar + ", curRetryCount = " + this.us + ", retryCount = " + this.s);
        this.mt = dVar;
        this.hc.hc();
        this.mk.d(this, this.hc, ttVar, dVar, this.us, this.s);
        int i = this.us;
        if (i < this.s) {
            this.us = i + 1;
            return true;
        }
        if (d(dVar)) {
            return true;
        }
        this.mk.d(this, this.hc, ttVar, dVar);
        return false;
    }

    private boolean d(com.ss.android.socialbase.downloader.u.d dVar) {
        if (!com.ss.android.socialbase.downloader.e.an.b(dVar)) {
            return false;
        }
        String str = this.hc.d;
        if (TextUtils.isEmpty(str) || !str.startsWith("https") || !this.uo.gu() || this.ba) {
            return false;
        }
        this.ba = true;
        mq();
        return true;
    }

    private void hc(tt ttVar) throws com.ss.android.socialbase.downloader.u.tc, com.ss.android.socialbase.downloader.u.d {
        b(ttVar);
        this.mk.d(this, ttVar, this.hc, this.cb);
        this.hc.b();
    }

    private void b(tt ttVar) throws com.ss.android.socialbase.downloader.u.d {
        String strReplaceFirst;
        String str;
        com.ss.android.socialbase.downloader.tt.tt ttVarD;
        try {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.u = 0L;
                this.c = jCurrentTimeMillis;
                this.yo = ttVar.u();
                this.jh = ttVar.an();
                if (this.jh > 0 && this.yo > this.jh) {
                    throw new tc(6, "createConn, ".concat(String.valueOf(ttVar)));
                }
                this.bc = new com.ss.android.socialbase.downloader.e.u();
                List<com.ss.android.socialbase.downloader.h.u> listD = com.ss.android.socialbase.downloader.e.an.d(this.uo.mt(), this.uo.o(), this.yo, this.jh);
                listD.add(new com.ss.android.socialbase.downloader.h.u("Segment-Index", String.valueOf(ttVar.h())));
                listD.add(new com.ss.android.socialbase.downloader.h.u("Thread-Index", String.valueOf(this.b)));
                com.ss.android.socialbase.downloader.e.an.d(listD, this.uo);
                com.ss.android.socialbase.downloader.e.an.hc(listD, this.uo);
                strReplaceFirst = this.hc.d;
                if (this.ba && !TextUtils.isEmpty(strReplaceFirst) && strReplaceFirst.startsWith("https")) {
                    strReplaceFirst = strReplaceFirst.replaceFirst("https", a.r);
                }
                str = this.hc.hc;
                com.ss.android.socialbase.downloader.an.d.b("SegmentReader", "createConnectionBegin: url = " + strReplaceFirst + ", ip = " + str + ", segment = " + ttVar + ", threadIndex = " + this.b);
                this.gb = strReplaceFirst;
                this.tt = str;
                ttVarD = com.ss.android.socialbase.downloader.downloader.b.d(this.uo.e(), this.uo.r(), strReplaceFirst, str, listD, 0, jCurrentTimeMillis - this.z > com.alipay.sdk.m.u.b.a && this.k.hc("monitor_download_connect") > 0, this.uo);
            } catch (com.ss.android.socialbase.downloader.u.d e) {
                throw e;
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.e.an.d(th, "createConn");
            }
            if (ttVarD == null) {
                throw new com.ss.android.socialbase.downloader.u.d(1022, new IOException("download can't continue, chunk connection is null"));
            }
            this.e = ttVarD;
            this.cb = new com.ss.android.socialbase.downloader.h.an(strReplaceFirst, ttVarD);
            if (this.np) {
                throw new cb("createConn");
            }
            if (ttVarD instanceof com.ss.android.socialbase.downloader.tt.d) {
                this.tc = ((com.ss.android.socialbase.downloader.tt.d) ttVarD).u();
            }
            com.bytedance.sdk.component.utils.mq.d("SegmentReader", "createConnectionSuccess: url = " + strReplaceFirst + ", ip = " + str + ", hostRealIp = " + this.tc + ", threadIndex = " + this.b);
        } finally {
            this.u = System.currentTimeMillis();
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:79:0x015a
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1178)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0177 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x017e A[Catch: all -> 0x0272, d -> 0x0274, TryCatch #21 {d -> 0x0274, all -> 0x0272, blocks: (B:27:0x006e, B:28:0x0072, B:50:0x00da, B:88:0x016c, B:90:0x0177, B:91:0x017e, B:93:0x0184, B:95:0x018a, B:98:0x0193, B:99:0x0197, B:132:0x0263), top: B:240:0x005d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(com.ss.android.socialbase.downloader.mk.tt r32) throws com.ss.android.socialbase.downloader.u.d {
        /*
            Method dump skipped, instructions count: 929
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.mk.uo.c(com.ss.android.socialbase.downloader.mk.tt):void");
    }

    private d d(b bVar, InputStream inputStream) throws Throwable {
        int i;
        d dVarHc = bVar.hc();
        try {
            i = inputStream.read(dVarHc.d);
            try {
                if (i == -1) {
                    throw new com.ss.android.socialbase.downloader.u.d(1073, "probe");
                }
                dVarHc.b = i;
                if (i == -1) {
                    bVar.d(dVarHc);
                }
                return dVarHc;
            } catch (Throwable th) {
                th = th;
                if (i == -1) {
                    bVar.d(dVarHc);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            i = -1;
        }
    }

    private long uo() {
        long j = this.rf;
        this.rf = 0L;
        return j <= 0 ? LocationRequestCompat.PASSIVE_INTERVAL : j;
    }

    public boolean d(long j) {
        long j2 = this.jh;
        if (j <= 0 && j2 > 0) {
            return false;
        }
        if (j > j2 && j2 > 0) {
            return false;
        }
        this.rf = j;
        this.zw = true;
        return true;
    }

    void d() {
        w wVar = this.hc;
        try {
            synchronized (this.mk) {
                long jB = b();
                if (jB > 0) {
                    this.de += jB;
                    wVar.d(jB);
                }
                this.sy = -1L;
            }
        } catch (Throwable unused) {
        }
    }

    public long hc() {
        long jB;
        synchronized (this.mk) {
            jB = this.de + b();
        }
        return jB;
    }

    public long b() {
        synchronized (this.mk) {
            long j = this.sy;
            long j2 = this.yo;
            if (j2 < 0 || j <= j2) {
                return 0L;
            }
            return j - j2;
        }
    }

    public long c() {
        return this.sy;
    }

    public void u() {
        com.ss.android.socialbase.downloader.an.d.b("SegmentReader", "close: threadIndex = " + this.b);
        synchronized (this) {
            this.np = true;
            this.zw = true;
        }
        tc();
        Future future = this.v;
        if (future != null) {
            this.v = null;
            try {
                future.cancel(true);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.mq.d(th);
            }
        }
    }

    public void an() {
        d(false);
    }

    public void d(boolean z) {
        com.ss.android.socialbase.downloader.an.d.b("SegmentReader", "reconnect: threadIndex = " + this.b);
        synchronized (this) {
            this.he = z;
            this.yi = true;
            this.zw = true;
        }
        tc();
        Thread thread = this.vv;
        if (thread != null) {
            try {
                com.bytedance.sdk.component.utils.mq.d("SegmentReader", "reconnect: t.interrupt threadIndex = " + this.b);
                thread.interrupt();
            } catch (Throwable unused) {
            }
        }
    }

    void d(Future future) {
        this.v = future;
    }

    void hc(boolean z) {
        this.r = z;
    }

    boolean h() {
        return this.r;
    }

    public void b(boolean z) {
        this.hv = z;
    }

    void hc(long j) {
        long j2 = this.sy;
        com.ss.android.socialbase.downloader.e.u uVar = this.bc;
        if (j2 < 0 || uVar == null) {
            return;
        }
        com.bytedance.sdk.component.utils.mq.d("SegmentReader", "markProgress: curSegmentReadOffset = " + j2 + ", threadIndex = " + this.b);
        uVar.d(j2, j);
    }

    long d(long j, long j2) {
        com.ss.android.socialbase.downloader.e.u uVar = this.bc;
        if (uVar == null) {
            return -1L;
        }
        return uVar.hc(j, j2);
    }

    long gb() {
        return this.yo;
    }
}
