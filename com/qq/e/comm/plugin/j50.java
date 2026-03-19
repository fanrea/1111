package com.qq.e.comm.plugin;

import android.os.SystemClock;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class j50<T> extends l4<T> {
    private final List<tr> d;
    private final AtomicInteger e;
    private final AtomicInteger f;
    private final int g;
    private final Map<Integer, tr> h;
    private final CopyOnWriteArrayList<tr> i;
    private final int j;
    private volatile tr k;
    private volatile T l;
    private volatile tr m;
    private volatile int n;
    private boolean o;
    private boolean p;

    public j50(List<tr> list, int i, int i2, no<T> noVar) {
        super(noVar);
        this.e = new AtomicInteger(-1);
        this.f = new AtomicInteger(0);
        this.h = new ConcurrentHashMap();
        this.i = new CopyOnWriteArrayList<>();
        this.n = -1;
        this.d = d5.a(list);
        this.g = i;
        this.j = i2;
    }

    public void f() {
        this.p = true;
        g();
    }

    private void g() {
        h();
        int size = this.d.size();
        int i = this.e.get();
        int i2 = (size - i) - 1;
        qm$h$$ExternalSyntheticBackport0.m(this.k);
        if (i2 > 0 && this.k == null) {
            int i3 = i + 1;
            int iMin = Math.min(this.j, i2) + i3;
            int i4 = 0;
            while (true) {
                int i5 = i3;
                int i6 = i;
                i = i5;
                if (i >= iMin) {
                    i = i6;
                    break;
                }
                tr trVar = this.d.get(i);
                trVar.w();
                qm$h$$ExternalSyntheticBackport0.m(trVar);
                if (trVar.q() <= this.n) {
                    qm$h$$ExternalSyntheticBackport0.m(trVar);
                    this.k = trVar;
                    break;
                }
                T tA = this.c.a(trVar);
                if (tA != null) {
                    i4++;
                    this.h.put(Integer.valueOf(tA.hashCode()), trVar);
                    this.i.add(trVar);
                    trVar.c(2);
                    if (tA instanceof op) {
                        ((op) tA).setMediationId(trVar.n());
                    }
                    this.c.a(tA, trVar.a());
                } else {
                    qm$h$$ExternalSyntheticBackport0.m(trVar);
                }
                i3 = i + 1;
            }
            this.f.set(i4);
            this.e.set(i);
            if (i4 > 0) {
                a(i);
                return;
            } else {
                g();
                return;
            }
        }
        a();
    }

    public List<tr> e() {
        return this.i;
    }

    public tr d() {
        c();
        return this.k;
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean unused = j50.this.p;
            if (j50.this.p) {
                j50.this.f.set(0);
                j50.this.b(this.a);
            }
        }
    }

    private void a(int i, int i2) {
        this.f.get();
        if (i <= 0 && i >= 0) {
            b(i2);
        }
    }

    private void h() {
        this.a.removeCallbacksAndMessages(this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        this.e.get();
        qm$h$$ExternalSyntheticBackport0.m(this.l);
        if (this.p && i / this.j == this.e.get() / this.j) {
            if (this.l != null) {
                a();
            } else {
                g();
            }
        }
    }

    private void c() {
        if (this.k == null || !this.o) {
            int i = this.o ? this.e.get() + 1 : 0;
            int size = this.d.size();
            if (i >= size) {
                return;
            }
            while (i < size) {
                tr trVar = this.d.get(i);
                trVar.q();
                if (trVar.q() <= this.n) {
                    qm$h$$ExternalSyntheticBackport0.m(trVar);
                    this.k = trVar;
                    return;
                }
                i++;
            }
        }
    }

    @Override // com.qq.e.comm.plugin.l4
    protected void a() {
        if (this.p) {
            h();
            this.p = false;
            this.c.a(this, (j50<T>) this.l, this.m);
        }
    }

    public void a(lo<T> loVar) {
        tr trVar;
        tr trVar2;
        T tA = loVar.a();
        int iF = loVar.f();
        qm$h$$ExternalSyntheticBackport0.m(tA);
        loVar.b();
        if (this.p && (trVar = this.h.get(Integer.valueOf(tA.hashCode()))) != null) {
            trVar.b(loVar.c());
            trVar.a(loVar.d());
            trVar.a(loVar.e());
            qm$h$$ExternalSyntheticBackport0.m(trVar);
            trVar.c(iF);
            trVar.b(loVar.g());
            if (iF == 3 && (this.l == null || (trVar2 = this.h.get(Integer.valueOf(this.l.hashCode()))) == null || trVar.q() > trVar2.q())) {
                this.l = tA;
                this.m = trVar;
            }
            qm$h$$ExternalSyntheticBackport0.m(this.l);
            qm$h$$ExternalSyntheticBackport0.m(this.m);
            a(this.f.decrementAndGet(), this.d.indexOf(trVar));
        }
    }

    public void a(int i, boolean z) {
        this.n = i;
        this.o = z;
    }

    private void a(int i) {
        this.a.postAtTime(new a(i), this.b, SystemClock.uptimeMillis() + this.g);
    }
}
