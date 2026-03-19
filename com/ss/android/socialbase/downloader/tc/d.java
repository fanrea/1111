package com.ss.android.socialbase.downloader.tc;

import android.os.Process;
import com.bytedance.sdk.component.utils.mq;
import com.ss.android.socialbase.downloader.e.an;
import com.ss.android.socialbase.downloader.mk.cb;
import java.io.InputStream;
import java.util.concurrent.Future;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d implements hc {
    private com.ss.android.socialbase.downloader.mk.d an;
    private final int b;
    private int cb;
    private final InputStream d;
    private volatile Future e;
    private com.ss.android.socialbase.downloader.mk.d gb;
    private com.ss.android.socialbase.downloader.mk.d h;
    private final int hc;
    private volatile Throwable k;
    private com.ss.android.socialbase.downloader.mk.d mk;
    private volatile boolean mq;
    private com.ss.android.socialbase.downloader.mk.d tc;
    private com.ss.android.socialbase.downloader.mk.d tt;
    private volatile boolean uo;
    private final Object c = new Object();
    private final Object u = new Object();
    private final Runnable w = new Runnable() { // from class: com.ss.android.socialbase.downloader.tc.d.1
        @Override // java.lang.Runnable
        public void run() throws SecurityException, IllegalArgumentException {
            com.ss.android.socialbase.downloader.mk.d dVarC;
            Process.setThreadPriority(10);
            do {
                try {
                    dVarC = d.this.c();
                    dVarC.b = d.this.d.read(dVarC.d);
                    d.this.b(dVarC);
                } catch (Throwable th) {
                    try {
                        d.this.k = th;
                        mq.d(th);
                        synchronized (d.this.u) {
                            d.this.uo = true;
                            d.this.u.notify();
                            an.d(d.this.d);
                            return;
                        }
                    } catch (Throwable th2) {
                        synchronized (d.this.u) {
                            d.this.uo = true;
                            d.this.u.notify();
                            an.d(d.this.d);
                            throw th2;
                        }
                    }
                }
            } while (dVarC.b != -1);
            synchronized (d.this.u) {
                d.this.uo = true;
                d.this.u.notify();
            }
            an.d(d.this.d);
        }
    };

    public d(InputStream inputStream, int i, int i2) throws Throwable {
        this.d = inputStream;
        this.hc = i;
        if (i2 <= 0) {
            i2 = 1;
        } else if (i2 > 64) {
            i2 = 64;
        }
        this.b = i2;
        b();
    }

    @Override // com.ss.android.socialbase.downloader.tc.hc
    public com.ss.android.socialbase.downloader.mk.d d() throws com.ss.android.socialbase.downloader.u.d, InterruptedException {
        return u();
    }

    @Override // com.ss.android.socialbase.downloader.tc.hc
    public void d(com.ss.android.socialbase.downloader.mk.d dVar) {
        hc(dVar);
    }

    @Override // com.ss.android.socialbase.downloader.tc.hc
    public void hc() {
        synchronized (this.c) {
            this.mq = true;
            this.c.notify();
        }
        Future future = this.e;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable unused) {
            }
            this.e = null;
        }
    }

    private void b() throws Throwable {
        this.e = com.ss.android.socialbase.downloader.downloader.b.cb().submit(this.w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ss.android.socialbase.downloader.mk.d c() throws cb, InterruptedException {
        int i;
        com.ss.android.socialbase.downloader.mk.d dVar = this.gb;
        if (dVar != null) {
            if (this.mq) {
                throw new cb("");
            }
            this.gb = dVar.c;
            dVar.c = null;
            return dVar;
        }
        synchronized (this.c) {
            if (this.mq) {
                throw new cb("");
            }
            com.ss.android.socialbase.downloader.mk.d dVar2 = this.an;
            if (dVar2 == null && (i = this.cb) < this.b) {
                this.cb = i + 1;
                return new com.ss.android.socialbase.downloader.mk.d(this.hc);
            }
            while (dVar2 == null) {
                this.c.wait();
                if (this.mq) {
                    throw new cb("");
                }
                dVar2 = this.an;
            }
            this.gb = dVar2.c;
            this.h = null;
            this.an = null;
            dVar2.c = null;
            return dVar2;
        }
    }

    private void hc(com.ss.android.socialbase.downloader.mk.d dVar) {
        synchronized (this.c) {
            com.ss.android.socialbase.downloader.mk.d dVar2 = this.h;
            if (dVar2 == null) {
                this.h = dVar;
                this.an = dVar;
                this.c.notify();
            } else {
                dVar2.c = dVar;
                this.h = dVar;
            }
        }
    }

    private com.ss.android.socialbase.downloader.mk.d u() throws com.ss.android.socialbase.downloader.u.d, InterruptedException {
        com.ss.android.socialbase.downloader.mk.d dVar;
        com.ss.android.socialbase.downloader.mk.d dVar2 = this.mk;
        if (dVar2 != null) {
            this.mk = dVar2.c;
            dVar2.c = null;
            return dVar2;
        }
        synchronized (this.u) {
            dVar = this.tt;
            if (dVar == null) {
                do {
                    if (this.uo) {
                        an();
                    }
                    this.u.wait();
                    dVar = this.tt;
                } while (dVar == null);
            }
            this.mk = dVar.c;
            this.tc = null;
            this.tt = null;
            dVar.c = null;
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.ss.android.socialbase.downloader.mk.d dVar) {
        synchronized (this.u) {
            com.ss.android.socialbase.downloader.mk.d dVar2 = this.tc;
            if (dVar2 == null) {
                this.tc = dVar;
                this.tt = dVar;
                this.u.notify();
            } else {
                dVar2.c = dVar;
                this.tc = dVar;
            }
        }
    }

    private void an() throws com.ss.android.socialbase.downloader.u.d {
        Throwable th = this.k;
        if (th != null) {
            if (th instanceof cb) {
                throw new com.ss.android.socialbase.downloader.u.d(1068, "async reader closed!");
            }
            an.d(th, "async_read");
        }
        throw new com.ss.android.socialbase.downloader.u.d(1069, "async reader terminated!");
    }
}
