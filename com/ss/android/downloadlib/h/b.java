package com.ss.android.downloadlib.h;

import java.lang.ref.SoftReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b<P, R> implements Runnable {
    private b<R, ?> an;
    private int b;
    private SoftReference<d<P, R>> c;
    private P d;
    private R hc;
    private b<?, P> u;

    public interface d<PARAM, RESULT> {
        RESULT d(PARAM param);
    }

    private b(int i, d<P, R> dVar, P p) {
        this.b = i;
        this.c = new SoftReference<>(dVar);
        this.d = p;
    }

    public static <P, R> b<P, R> d(d<P, R> dVar, P p) {
        return new b<>(2, dVar, p);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <NR> b<R, NR> d(int i, d<R, NR> dVar) {
        b bVar = (b<R, ?>) new b(i, dVar, null);
        this.an = bVar;
        bVar.u = this;
        return bVar;
    }

    public <NR> b<R, NR> d(d<R, NR> dVar) {
        return d(0, dVar);
    }

    public void d() {
        b<?, P> bVar = this.u;
        if (bVar != null) {
            bVar.d();
        } else {
            run();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        b<?, P> bVar;
        if (this.b == 0 && !uo.hc()) {
            com.ss.android.downloadlib.gb.d().hc().post(this);
            return;
        }
        if (this.b == 1 && uo.hc()) {
            com.ss.android.downloadlib.u.d().d(this);
            return;
        }
        if (this.b == 2 && uo.hc()) {
            com.ss.android.downloadlib.u.d().hc(this);
            return;
        }
        if (this.d == null && (bVar = this.u) != null) {
            this.d = bVar.hc();
        }
        d<P, R> dVar = this.c.get();
        if (dVar == null) {
            return;
        }
        this.hc = dVar.d(this.d);
        b<R, ?> bVar2 = this.an;
        if (bVar2 != null) {
            bVar2.run();
        }
    }

    private R hc() {
        return this.hc;
    }
}
