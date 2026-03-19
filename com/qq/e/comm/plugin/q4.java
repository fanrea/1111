package com.qq.e.comm.plugin;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class q4<T> implements no<T> {
    private int A;
    protected int B;
    protected int C;
    private boolean D;
    protected List<tr> a;
    protected List<tr> b;
    protected List<tr> c;
    protected int d;
    protected int e;
    protected int f;
    protected int g;
    protected int h;
    protected k10<T> i;
    private volatile boolean j;
    protected final t5<T> m;
    protected final j50<T> n;
    protected final jx<T> o;
    protected T q;
    protected tr r;
    protected T s;
    protected tr t;
    protected T u;
    protected tr v;
    protected boolean w;
    protected boolean x;
    private int y;
    private int z;
    protected Handler k = new Handler(Looper.getMainLooper());
    private final Object l = new Object();
    protected final List<tr> p = new ArrayList();

    public q4(yn ynVar, k10<T> k10Var) {
        this.a = ynVar.j();
        this.b = ynVar.b();
        this.c = ynVar.g();
        this.d = ynVar.i();
        this.e = ynVar.a();
        this.f = ynVar.h();
        this.g = ynVar.d();
        this.h = ynVar.f();
        this.i = k10Var;
        this.m = new t5<>(this.b, this.e, this);
        this.n = new j50<>(this.a, this.g, this.h, this);
        this.o = new jx<>(this.c, this.e, this.f, ynVar.e(), this);
    }

    public void a() {
        this.j = true;
        e();
    }

    public boolean c() {
        return this.j;
    }

    /* compiled from: A */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (q4.this.c()) {
                q4.this.m.b();
                q4.this.o.b();
                q4.this.n.b();
            }
        }
    }

    private void e() {
        Handler handler = this.k;
        a aVar = new a();
        Object obj = this.l;
        long jUptimeMillis = SystemClock.uptimeMillis();
        int i = this.d;
        if (i <= 0) {
            i = 5000;
        }
        handler.postAtTime(aVar, obj, jUptimeMillis + i);
    }

    protected final void b() {
        this.j = false;
        this.p.addAll(this.m.d());
        this.p.addAll(this.n.e());
        this.p.addAll(this.o.c());
        tr trVar = this.r;
        this.y = trVar != null ? trVar.f() : -1;
        tr trVar2 = this.t;
        this.A = trVar2 != null ? trVar2.q() : -1;
        tr trVar3 = this.v;
        int iF = trVar3 != null ? trVar3.f() : -1;
        this.z = iF;
        if (iF >= this.y && iF >= this.A && this.v != null) {
            this.D = true;
            this.o.f();
            b(false);
            this.m.a(this.v.q(), this.v.a());
            return;
        }
        d();
    }

    private void d() {
        this.D = false;
        b(false);
        if (this.A > this.y) {
            tr trVar = this.t;
            if (trVar != null) {
                this.m.a(trVar.q(), this.t.a());
            }
            a(this.s, this.t, this.p, null);
            b10.a(1231007, null, 2);
            return;
        }
        tr trVar2 = this.r;
        if (trVar2 != null) {
            this.m.a(trVar2);
            b5.a(this.r.p(), this.r.f());
            b10.a(1231007, null, 1);
        } else {
            b10.a(1231008, (f5) null);
        }
        a(this.q, this.r, this.p, this.n.d());
    }

    private void a(T t, tr trVar, List<tr> list, tr trVar2) {
        qm$h$$ExternalSyntheticBackport0.m(t);
        qm$h$$ExternalSyntheticBackport0.m(trVar);
        qm$h$$ExternalSyntheticBackport0.m(trVar2);
        qm$h$$ExternalSyntheticBackport0.m(list);
        this.k.removeCallbacksAndMessages(this.l);
        this.i.a(t, trVar, list, trVar2);
    }

    public void b(boolean z) {
        int iMax;
        if (this.D) {
            iMax = this.z;
        } else {
            iMax = Math.max(this.A, this.y);
        }
        kx.a(this.o.d(), this.v, this.D, z, String.valueOf(iMax));
    }

    @Override // com.qq.e.comm.plugin.no
    public T a(tr trVar) {
        return this.i.a(trVar);
    }

    @Override // com.qq.e.comm.plugin.no
    public void a(T t, int i) {
        this.i.a(t, i);
    }

    @Override // com.qq.e.comm.plugin.no
    public void a(T t, int i, String str) {
        this.i.a(t, i, str);
    }

    @Override // com.qq.e.comm.plugin.no
    public void a(boolean z) {
        tr trVar = this.v;
        if (trVar != null) {
            trVar.a(true);
        }
        if (z) {
            a(this.u, this.v, this.p, null);
        } else {
            a(null, null, this.p, null);
        }
    }

    public void a(lo<T> loVar) {
        qm$h$$ExternalSyntheticBackport0.m(loVar.a());
        loVar.f();
        loVar.b();
        this.m.a(loVar);
        this.n.a(loVar);
        this.o.a(loVar);
    }
}
