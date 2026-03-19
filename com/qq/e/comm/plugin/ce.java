package com.qq.e.comm.plugin;

import android.content.Context;
import android.view.View;
import com.qq.e.comm.plugin.callback.biz.LifecycleCallback;
import com.qq.e.comm.plugin.e50;
import com.qq.e.comm.plugin.fs.FSCallback;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ce implements fj, xl, os {
    private static final String m = "ce";
    protected final h4 b;
    protected Cif c;
    private boolean d;
    protected final FSCallback e;
    private final e20 f;
    private final sd g;
    private e50 h;
    private final ns a = new ns();
    private boolean i = false;
    private final m8 j = new m8();

    @Override // com.qq.e.comm.plugin.xl
    public long c() {
        return ke.b();
    }

    public ce(Context context, h4 h4Var, sd sdVar) throws JSONException {
        this.b = h4Var;
        this.g = sdVar;
        e20 e20Var = new e20(h4Var);
        this.f = e20Var;
        e20Var.a(this, true);
        this.e = (FSCallback) x5.b(h4Var.s0(), FSCallback.class);
        a(context);
    }

    private void g() throws JSONException {
        this.d = this.g.l();
        this.c.a(new m8().g(this.d).e(ke.a() <= 0).a(new zd(this.c, this.b, this.e)).d(this.b.i0()).f());
    }

    private void j() {
        View viewA = a();
        if (viewA == null) {
            return;
        }
        this.h = new e50(new a());
        viewA.addOnAttachStateChangeListener(new b());
    }

    /* compiled from: A */
    class a implements e50.a {
        a() {
        }

        @Override // com.qq.e.comm.plugin.e50.a
        public void a(float f) throws JSONException {
            ce.this.d = f > 0.0f;
            ce.this.m();
        }
    }

    /* compiled from: A */
    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            if (ce.this.h != null) {
                ce.this.h.a(view.getContext());
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (ce.this.h != null) {
                ce.this.h.b(view.getContext());
            }
        }
    }

    /* compiled from: A */
    class c extends ms<Void> {
        c(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r1) throws JSONException {
            ce.this.c.v();
        }
    }

    protected void n() {
        this.e.p().a(new c(this));
        this.e.H().a(new d(this));
        ((LifecycleCallback) x5.b(this.b.s0(), LifecycleCallback.class)).I().a(new e(this));
    }

    /* compiled from: A */
    class d extends ms<Void> {
        d(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r1) {
            ce.this.f.b();
        }
    }

    /* compiled from: A */
    class e extends ms<LifecycleCallback.a> {
        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(LifecycleCallback.a aVar) {
            if (LifecycleCallback.a.DESTROYED == aVar) {
                ce.this.h();
            }
        }

        e(os osVar) {
            super(osVar);
        }
    }

    /* compiled from: A */
    class f extends gf {
        f(f9 f9Var, h4 h4Var) {
            super(f9Var, h4Var);
        }

        @Override // com.qq.e.comm.plugin.gf
        public void f(h8 h8Var) {
            super.f(h8Var);
            String unused = ce.m;
            ce.this.e.Q().a();
        }

        @Override // com.qq.e.comm.plugin.gf
        public void c(h8 h8Var) {
            super.c(h8Var);
            String unused = ce.m;
            ce.this.e.w().a();
        }

        @Override // com.qq.e.comm.plugin.gf
        public void a(i6 i6Var, h8 h8Var) {
            super.a(i6Var, h8Var);
            ce.this.e.Y().b(i6Var);
        }

        @Override // com.qq.e.comm.plugin.gf
        public void e(h8 h8Var) {
            String unused = ce.m;
            ce.this.e.Q().a();
        }

        @Override // com.qq.e.comm.plugin.gf
        public void d(h8 h8Var) {
            String unused = ce.m;
            ce.this.e.z().a();
        }

        @Override // com.qq.e.comm.plugin.gf
        public void c() throws JSONException {
            super.c();
            String unused = ce.m;
            ce.this.d = !r0.d;
            ce.this.m();
        }
    }

    protected void l() {
        this.c.a(new f(this.c, this.b));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() throws JSONException {
        this.c.a(new m8().g(this.d).f());
    }

    @Override // com.qq.e.comm.plugin.fj
    public Cif f() {
        return this.c;
    }

    public void h() {
        e20 e20Var = this.f;
        if (e20Var != null) {
            e20Var.a();
        }
        Cif cif = this.c;
        if (cif != null) {
            cif.c();
        }
        this.i = true;
    }

    @Override // com.qq.e.comm.plugin.xl
    public void b(long j) throws JSONException {
        if (this.b.k().h()) {
            return;
        }
        if (this.b.q1()) {
            this.e.A().b(Long.valueOf(j));
        }
        if (this.g.a()) {
            this.e.Q().a();
        } else if (xc.a("fsrieas", this.b.y0(), 0, this.b.x0()) == 1) {
            if (this.c.s()) {
                this.c.v();
            } else {
                this.e.T().a();
            }
        }
    }

    @Override // com.qq.e.comm.plugin.os
    public ns i() {
        return this.a;
    }

    @Override // com.qq.e.comm.plugin.os
    public boolean k() {
        return this.i;
    }

    @Override // com.qq.e.comm.plugin.fj
    public View a() {
        Cif cif = this.c;
        if (cif == null) {
            return null;
        }
        return cif.l();
    }

    @Override // com.qq.e.comm.plugin.xl
    public void a(long j) throws JSONException {
        if (this.c == null) {
            return;
        }
        if (ke.a() <= j) {
            this.j.e(true);
        }
        this.j.a(j);
        this.c.a(this.j.f());
        this.c.a(j);
    }

    private void a(Context context) throws JSONException {
        boolean zA = r1.d().c().A();
        yq yqVarP0 = this.b.p0();
        boolean z = true;
        int i = zA ? 2 : 1;
        if (yqVarP0 == null || (i != yqVarP0.p() && (p8.a || yqVarP0.p() != 0))) {
            z = false;
        }
        Cif cifA = q8.a().a(context, this.b, z);
        this.c = cifA;
        if (cifA == null) {
            return;
        }
        l();
        n();
        g();
        j();
    }
}
