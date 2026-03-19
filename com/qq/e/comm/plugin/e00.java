package com.qq.e.comm.plugin;

import com.qq.e.comm.plugin.f20;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class e00 {
    private xz a;
    private b b;
    private a c;
    private a d;
    private Future e;
    private Future f;
    private f20.c g;

    /* compiled from: A */
    interface b extends f20.b {
        void g();

        void h();
    }

    e00() {
    }

    void f() {
        if (b()) {
            return;
        }
        b(this.a);
        xz xzVar = this.a;
        if (xzVar == null || xzVar.C) {
            return;
        }
        a(xzVar);
    }

    void e() {
        xz xzVar = this.a;
        if (b()) {
            return;
        }
        f20.c cVar = new f20.c(xzVar.d(), 500L);
        this.g = cVar;
        xzVar.A = cVar;
        cVar.a(this.b);
        this.g.g();
    }

    void c() {
        f20.c cVar = this.g;
        if (cVar != null) {
            cVar.e();
        }
    }

    void d() {
        f20.c cVar = this.g;
        if (cVar != null) {
            cVar.f();
        }
    }

    void g() {
        f20.c cVar = this.g;
        if (cVar != null) {
            cVar.h();
        }
    }

    public void a() {
        Future future = this.e;
        if (future != null) {
            future.cancel(false);
            this.e = null;
        }
        Future future2 = this.f;
        if (future2 != null) {
            future2.cancel(false);
            this.f = null;
        }
        a aVar = this.c;
        if (aVar != null) {
            aVar.b = null;
            this.c = null;
        }
        a aVar2 = this.d;
        if (aVar2 != null) {
            aVar2.b = null;
            this.d = null;
        }
        f20.c cVar = this.g;
        if (cVar != null) {
            cVar.a((f20.b) null);
            this.g.h();
            this.g = null;
        }
        this.b = null;
        this.a = null;
    }

    public boolean b() {
        return this.a == null || this.b == null;
    }

    /* compiled from: A */
    private static class a implements Runnable {
        final boolean a;
        b b;

        a(b bVar, boolean z) {
            this.b = bVar;
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a) {
                b bVar = this.b;
                if (bVar != null) {
                    bVar.h();
                    return;
                }
                return;
            }
            b bVar2 = this.b;
            if (bVar2 != null) {
                bVar2.g();
            }
        }
    }

    private void b(xz xzVar) {
        if (xzVar == null) {
            return;
        }
        a aVar = new a(this.b, true);
        this.d = aVar;
        this.f = qg.f.schedule(aVar, xzVar.o, TimeUnit.MILLISECONDS);
    }

    public void a(xz xzVar, b bVar) {
        a();
        this.a = xzVar;
        this.b = bVar;
    }

    private void a(xz xzVar) {
        if (xzVar == null) {
            return;
        }
        int i = xzVar.s;
        if (i == 0) {
            f00.b(xzVar.c());
        }
        long j = i;
        pu.a().a(j);
        if (i < 0 || i >= xzVar.o) {
            return;
        }
        a aVar = new a(this.b, false);
        this.c = aVar;
        this.e = qg.f.schedule(aVar, j, TimeUnit.MILLISECONDS);
    }
}
