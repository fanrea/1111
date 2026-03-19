package com.ss.android.socialbase.downloader.mk;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
class hc implements b, c, u {
    private d an;
    private final Object b = new Object();
    private final Object c = new Object();
    private final int d;
    private d gb;
    private d h;
    private final int hc;
    private int mk;
    private volatile boolean tc;
    private d tt;
    private d u;

    hc(int i, int i2) {
        i = i < 64 ? 64 : i;
        i2 = i2 < 8192 ? 8192 : i2;
        this.d = i;
        this.hc = i2;
    }

    @Override // com.ss.android.socialbase.downloader.mk.c
    public d d() throws cb, InterruptedException {
        d dVar;
        d dVar2 = this.tt;
        if (dVar2 != null) {
            this.tt = dVar2.c;
            dVar2.c = null;
            return dVar2;
        }
        synchronized (this.c) {
            dVar = this.h;
            while (dVar == null) {
                if (this.tc) {
                    throw new cb("read");
                }
                this.c.wait();
                dVar = this.h;
            }
            this.tt = dVar.c;
            this.gb = null;
            this.h = null;
            dVar.c = null;
        }
        return dVar;
    }

    @Override // com.ss.android.socialbase.downloader.mk.b
    public void d(d dVar) {
        synchronized (this.b) {
            d dVar2 = this.an;
            if (dVar2 == null) {
                this.an = dVar;
                this.u = dVar;
            } else {
                dVar2.c = dVar;
                this.an = dVar;
            }
            this.b.notify();
        }
    }

    @Override // com.ss.android.socialbase.downloader.mk.b
    public d hc() throws cb, InterruptedException {
        synchronized (this.b) {
            if (this.tc) {
                throw new cb("obtain");
            }
            d dVar = this.u;
            if (dVar == null) {
                int i = this.mk;
                if (i < this.d) {
                    this.mk = i + 1;
                    return new d(this.hc);
                }
                do {
                    this.b.wait();
                    if (this.tc) {
                        throw new cb("obtain");
                    }
                    dVar = this.u;
                } while (dVar == null);
            }
            this.u = dVar.c;
            if (dVar == this.an) {
                this.an = null;
            }
            dVar.c = null;
            return dVar;
        }
    }

    @Override // com.ss.android.socialbase.downloader.mk.u
    public void hc(d dVar) {
        synchronized (this.c) {
            d dVar2 = this.gb;
            if (dVar2 == null) {
                this.gb = dVar;
                this.h = dVar;
                this.c.notify();
            } else {
                dVar2.c = dVar;
                this.gb = dVar;
            }
        }
    }

    public void b() {
        this.tc = true;
        synchronized (this.b) {
            this.b.notifyAll();
        }
        synchronized (this.c) {
            this.c.notifyAll();
        }
    }
}
