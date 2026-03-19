package com.qq.e.comm.plugin;

import com.sigmob.sdk.base.mta.PointCategory;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class s0 implements yk {
    protected h4 a;
    protected zp b;
    protected boolean d;
    protected w40 e;
    protected h8 f;
    protected WeakReference<gk> g;
    protected long h;
    protected long i;
    protected int j;
    protected int m;
    protected final Map<w40, h8> c = new HashMap();
    protected long n = 0;
    protected float o = 0.0f;
    protected boolean p = false;

    private void f() {
        xo.a(new b(), this.i);
    }

    protected h8 g() {
        h8 h8Var = this.c.get(this.e);
        return h8Var == null ? this.f : h8Var;
    }

    @Override // com.qq.e.comm.plugin.yk
    public void start() {
        WeakReference<gk> weakReference;
        if (this.b != null || this.c.isEmpty() || (weakReference = this.g) == null || weakReference.get() == null || this.f == null) {
            return;
        }
        h();
        zp zpVar = this.b;
        if (zpVar != null) {
            zpVar.start();
            e();
        }
    }

    @Override // com.qq.e.comm.plugin.yk
    public void a(w40 w40Var, h8 h8Var, gk gkVar) {
        if (w40Var == null || h8Var == null || gkVar == null) {
            return;
        }
        aq.a(this.a, (zp) null, PointCategory.INIT);
        this.c.put(w40Var, h8Var);
        if (h8Var.h) {
            this.d = true;
        }
        if (this.f == null) {
            this.f = h8Var;
        }
        if (this.g == null) {
            this.g = new WeakReference<>(gkVar);
        }
    }

    protected void h() {
        this.h = aq.a(this.a);
        this.i = aq.j(this.a);
        this.j = aq.d(this.a);
        this.m = aq.m(this.a);
    }

    public void j() {
        zp zpVar = this.b;
        if (zpVar != null) {
            aq.b(this.a, zpVar, "try pauseAndReset");
            if (this.b.pause()) {
                this.b.reset();
                aq.a(this.a, this.b, "pauseAndReset success");
            }
        }
    }

    public void k() {
        zp zpVar = this.b;
        if (zpVar != null) {
            aq.b(this.a, zpVar, "try resume");
            if (this.b.resume()) {
                aq.a(this.a, this.b, "resume success");
            }
        }
    }

    @Override // com.qq.e.comm.plugin.yk
    public void stop() {
        zp zpVar = this.b;
        if (zpVar != null) {
            aq.a(this.a, zpVar, com.component.feed.a.e);
            this.b.stop();
            this.b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (aq.a(this.c.keySet(), this.m, this.j) != null) {
            k();
        } else {
            j();
        }
        if (this.b == null) {
            return;
        }
        xo.a(new a(), this.h);
    }

    public void a(h4 h4Var) {
        this.a = h4Var;
    }

    /* compiled from: A */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            s0.this.e();
        }
    }

    protected boolean i() {
        if (aq.a(this.i)) {
            aq.a(this.a, this.b, "摇一摇/扭一扭过于频繁被拦截");
            return false;
        }
        w40 w40VarA = aq.a(this.c.keySet(), this.m, this.j);
        this.e = w40VarA;
        if (w40VarA == null) {
            aq.a(this.a, this.b, "摇一摇/扭一扭不可见被拦截");
            j();
            return false;
        }
        aq.a(this.a, this.b, "摇一摇/扭一扭完成");
        aq.d();
        f();
        return true;
    }

    /* compiled from: A */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            zp zpVar = s0.this.b;
            if (zpVar == null || !zpVar.a()) {
                return;
            }
            s0 s0Var = s0.this;
            aq.a(s0Var.a, s0Var.b, "延迟重置");
            s0.this.b.reset();
        }
    }
}
