package com.qq.e.comm.plugin;

import android.content.Context;
import com.qq.e.comm.plugin.callback.biz.LifecycleCallback;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class de extends ce {
    private static final String p = "de";
    private boolean n;
    private boolean o;

    private void p() {
        wd.a().a(this.b.S0(), 10012);
    }

    public de(Context context, h4 h4Var, sd sdVar) {
        super(context, h4Var, sdVar);
        this.n = false;
        this.o = false;
    }

    /* compiled from: A */
    class a extends ms<Void> {
        a(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r2) throws JSONException {
            String unused = de.p;
            de.this.c.v();
            de.this.n = true;
        }
    }

    @Override // com.qq.e.comm.plugin.ce
    protected void n() {
        this.e.D().a(new a(this));
        this.e.m().a(new b(this));
        this.e.p().a(new c(this));
        ((LifecycleCallback) x5.b(this.b.s0(), LifecycleCallback.class)).I().a(new d(this));
    }

    /* compiled from: A */
    class b extends ms<Float> {
        b(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Float f) throws JSONException {
            de.this.c.a(new m8().a(f).f());
        }
    }

    /* compiled from: A */
    class c extends ms<Void> {
        c(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r2) throws JSONException {
            de.this.c.v();
            de.this.n = true;
        }
    }

    /* compiled from: A */
    class d extends ms<LifecycleCallback.a> {
        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(LifecycleCallback.a aVar) {
            if (LifecycleCallback.a.DESTROYED == aVar) {
                de.this.h();
            }
        }

        d(os osVar) {
            super(osVar);
        }
    }

    /* compiled from: A */
    class e extends gf {
        e(f9 f9Var, h4 h4Var) {
            super(f9Var, h4Var);
        }

        @Override // com.qq.e.comm.plugin.gf
        public void c(h8 h8Var) {
            super.c(h8Var);
            String unused = de.p;
            if (de.this.n && de.this.o) {
                de.this.e.Q().a();
            } else {
                de.this.e.w().a();
            }
        }

        @Override // com.qq.e.comm.plugin.gf
        public void a(i6 i6Var, h8 h8Var) {
            super.a(i6Var, h8Var);
            de.this.e.Y().b(i6Var);
        }

        @Override // com.qq.e.comm.plugin.gf
        public void e(h8 h8Var) {
            String unused = de.p;
            de.this.e.Q().a();
        }

        @Override // com.qq.e.comm.plugin.gf
        public void d(h8 h8Var) {
            String unused = de.p;
            de.this.e.z().a();
        }
    }

    @Override // com.qq.e.comm.plugin.ce
    protected void l() {
        this.c.a(new e(this.c, this.b));
    }

    @Override // com.qq.e.comm.plugin.ce, com.qq.e.comm.plugin.xl
    public void b(long j) {
        if (this.b.q1()) {
            this.o = true;
            this.e.A().b(Long.valueOf(j));
            p();
        }
    }
}
