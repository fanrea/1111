package com.qq.e.comm.plugin;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class t5<T> extends l4<T> {
    private final AtomicInteger d;
    private final Map<Integer, tr> e;
    private final List<uk> f;
    private final List<tr> g;
    private final int h;
    private volatile boolean i;
    private volatile T j;
    private volatile tr k;
    private int l;
    private int m;
    private int n;
    private T o;

    public t5(List<tr> list, int i, no<T> noVar) {
        super(noVar);
        this.d = new AtomicInteger(0);
        this.e = new HashMap();
        this.f = new ArrayList();
        this.l = -1;
        this.m = -1;
        this.n = -1;
        this.g = list;
        this.h = i;
    }

    public void e() {
        this.i = true;
        List<tr> list = this.g;
        if (list != null && list.size() > 0) {
            int i = 0;
            for (tr trVar : this.g) {
                trVar.w();
                T tA = this.c.a(trVar);
                if (tA != null) {
                    if (tA instanceof uk) {
                        this.f.add((uk) tA);
                        yv.a(trVar.p(), trVar.i());
                    }
                    trVar.c(2);
                    this.e.put(Integer.valueOf(tA.hashCode()), trVar);
                    if (tA instanceof op) {
                        ((op) tA).setMediationId(trVar.n());
                    }
                    if (trVar.a() == 100 && this.o == null) {
                        this.o = tA;
                        qm$h$$ExternalSyntheticBackport0.m(tA);
                        qm$h$$ExternalSyntheticBackport0.m(trVar);
                    }
                    this.c.a(tA, trVar.a());
                    i++;
                }
            }
            if (i == 0) {
                a();
                return;
            } else {
                this.d.set(i);
                f();
                return;
            }
        }
        a();
    }

    public List<tr> d() {
        return this.g;
    }

    private void c() {
        int i = this.d.get();
        if (i <= 0 && i >= 0) {
            a();
        }
    }

    public void b(int i, int i2) {
        Iterator<uk> it = this.f.iterator();
        while (it.hasNext() && (r1 = it.next().getCompetitionWinUrls()) != null) {
            for (String str : r1) {
                b5.a(str, i, i2);
            }
        }
    }

    /* compiled from: A */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean unused = t5.this.i;
            if (t5.this.i) {
                t5.this.d.set(0);
                t5.this.a();
            }
        }
    }

    private void f() {
        this.a.postAtTime(new a(), this.b, SystemClock.uptimeMillis() + this.h);
    }

    @Override // com.qq.e.comm.plugin.l4
    protected void a() {
        if (this.i) {
            this.a.removeCallbacksAndMessages(this.b);
            this.i = false;
            List<tr> list = this.g;
            if (list != null && list.size() > 0) {
                for (tr trVar : this.g) {
                    trVar.e(this.n);
                    trVar.a((trVar.f() - this.n) - 2);
                    qm$h$$ExternalSyntheticBackport0.m(trVar);
                    trVar.f();
                }
            }
            this.c.a(this, (t5<T>) this.j, this.k);
        }
    }

    public void a(lo<T> loVar) {
        T tA = loVar.a();
        int iB = loVar.b();
        int iF = loVar.f();
        qm$h$$ExternalSyntheticBackport0.m(tA);
        tr trVar = this.e.get(Integer.valueOf(tA.hashCode()));
        if (trVar != null) {
            qm$h$$ExternalSyntheticBackport0.m(trVar);
            if (this.i) {
                trVar.c(iF);
            }
            trVar.b(iB);
            trVar.b(loVar.g());
            trVar.b(loVar.c());
            trVar.a(loVar.d());
            trVar.a(loVar.e());
            if (this.o == tA) {
                this.n = iB;
                qm$h$$ExternalSyntheticBackport0.m(trVar);
            }
            if (iF == 3) {
                if (this.j == null) {
                    this.j = tA;
                    this.l = iB;
                    this.k = trVar;
                } else if (iB > this.l) {
                    this.j = tA;
                    this.m = this.l;
                    this.l = iB;
                    this.k = trVar;
                }
            }
            this.d.decrementAndGet();
            c();
        }
    }

    public void a(int i, int i2) {
        Iterator<uk> it = this.f.iterator();
        while (it.hasNext() && (r1 = it.next().getCompetitionFailureUrls()) != null) {
            for (String str : r1) {
                b5.a(str, String.valueOf(i2), i, 1);
            }
        }
    }

    public void a(tr trVar) {
        if (this.k != null) {
            this.k.q();
        }
        if (qp.a(trVar)) {
            b(trVar.u() ? trVar.f() : trVar.q(), this.m);
        } else {
            a(trVar.u() ? trVar.f() : trVar.q(), trVar.a());
        }
    }
}
