package com.qq.e.comm.plugin;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.plugin.adview.video.VideoCallback;
import com.qq.e.comm.plugin.fs.FSCallback;
import com.qq.e.comm.plugin.l6;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class fe implements bc, os {
    protected final h4 a;
    protected final f5 b;
    protected Activity c;
    protected sd d;
    protected ViewGroup e;
    protected ae f;
    protected fk g;
    protected dm h;
    protected mh i;
    protected g40 j;
    protected boolean m;
    protected boolean n;
    protected cz o;
    private boolean p = false;
    private final ns q = new ns();
    protected int r = -1;
    private long s;
    protected long t;
    protected boolean u;
    protected boolean v;

    public abstract void m();

    public abstract void n();

    public fe(Activity activity, h4 h4Var, sd sdVar) {
        this.c = activity;
        this.a = h4Var;
        this.b = f5.a(h4Var);
        this.d = sdVar;
        this.n = !h4Var.C1();
        this.m = sdVar.j();
        r();
    }

    @Override // com.qq.e.comm.plugin.os
    public ns i() {
        return this.q;
    }

    @Override // com.qq.e.comm.plugin.os
    public boolean k() {
        return this.p;
    }

    protected void l() {
        g40 g40Var = new g40();
        this.j = g40Var;
        g40Var.a(this.i);
        this.f.a(this.j);
    }

    protected void j() {
        this.g.a(this);
        g40 g40Var = this.j;
        if (g40Var != null) {
            g40Var.a(this.g);
        }
    }

    /* compiled from: A */
    class b extends cz {
        final /* synthetic */ FSCallback f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Context context, FSCallback fSCallback) {
            super(context);
            this.f = fSCallback;
        }

        @Override // com.qq.e.comm.plugin.cz, com.qq.e.comm.plugin.qs
        public void a(boolean z) {
            super.a(z);
            if (z) {
                this.f.c().a();
            }
        }

        @Override // com.qq.e.comm.plugin.cz, com.qq.e.comm.plugin.qs
        public boolean b(String str, h4 h4Var) {
            return fe.this.a(str) || super.b(str, h4Var);
        }
    }

    protected void r() {
        FSCallback fSCallbackD = d();
        this.o = new b(this.c, fSCallbackD);
        fSCallbackD.Q().a(new c(this));
        fSCallbackD.s().a(new d(this));
        fSCallbackD.T().a(new e(this));
        fSCallbackD.G().a(new f(this));
        e().K().a(new g(this));
        e().a().a(new h(this));
        e().q().a(new i(this, fSCallbackD));
        e().onPause().a(new j(this));
        e().onResume().a(new a(this));
    }

    /* compiled from: A */
    class c extends ms<Void> {
        c(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r1) throws JSONException {
            fe.this.b();
        }
    }

    /* compiled from: A */
    class d extends ms<i6> {
        d(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(i6 i6Var) {
            fe.this.a(i6Var);
        }
    }

    /* compiled from: A */
    class e extends ms<Boolean> {
        e(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Boolean bool) {
            fk fkVar = fe.this.g;
            if (fkVar != null) {
                fkVar.show();
            }
        }
    }

    /* compiled from: A */
    class f extends ms<Void> {
        f(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r1) {
            fe.this.m();
        }
    }

    /* compiled from: A */
    class g extends ms<e40> {
        g(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(e40 e40Var) throws JSONException {
            if (fe.this.i != null) {
                int iA = e40Var.a();
                fe feVar = fe.this;
                ax.a(iA, feVar.b, feVar.a.V0(), e40Var.c(), fe.this.i.getDuration(), fe.this.i.getCurrentPosition(), ke.b());
            } else {
                int iA2 = e40Var.a();
                fe feVar2 = fe.this;
                ax.a(iA2, feVar2.b, feVar2.a.V0(), e40Var.c(), -1L, -1L, ke.b());
            }
            g40 g40Var = fe.this.j;
            if (g40Var != null) {
                g40Var.a(!e40Var.d());
            }
        }
    }

    public void a(ViewGroup viewGroup, ae aeVar, fk fkVar) {
        this.s = System.currentTimeMillis();
        this.e = viewGroup;
        this.f = aeVar;
        this.g = fkVar;
        if (!this.n && !this.a.p0().F()) {
            dm dmVarB = this.f.b();
            this.h = dmVarB;
            this.i = dmVarB == null ? null : dmVarB.b();
            l();
        }
        if (this.g != null) {
            j();
        }
    }

    /* compiled from: A */
    class h extends ms<Void> {
        h(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r14) {
            fe.this.a.i(System.currentTimeMillis());
            fe feVar = fe.this;
            if (feVar.i != null) {
                ax.a(feVar.b, r0.getDuration(), fe.this.i.getCurrentPosition(), ke.b());
            } else {
                ax.a(feVar.b, -1L, -1L, ke.b());
            }
        }
    }

    /* compiled from: A */
    class i extends ms<Void> {
        final /* synthetic */ FSCallback b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(os osVar, FSCallback fSCallback) {
            super(osVar);
            this.b = fSCallback;
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r20) throws JSONException {
            fe feVar = fe.this;
            if (feVar.i != null) {
                le.a(j40.END, feVar.a, r2.getDuration(), fe.this.i.getCurrentPosition(), ke.b());
            } else {
                le.a(j40.END, feVar.a, -1L, -1L, ke.b());
            }
            fe feVar2 = fe.this;
            feVar2.r = 1;
            if (feVar2.m && feVar2.a.q1()) {
                long jW0 = fe.this.a.W0() * 1000;
                mh mhVar = fe.this.i;
                if (mhVar != null) {
                    jW0 = mhVar.getCurrentPosition();
                }
                this.b.A().b(Long.valueOf(jW0));
            }
        }
    }

    /* compiled from: A */
    class j extends ms<Void> {
        j(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r20) throws JSONException {
            fe feVar = fe.this;
            if (feVar.i != null) {
                le.a(j40.PAUSE, feVar.a, r2.getDuration(), fe.this.i.getCurrentPosition(), ke.b());
            } else {
                le.a(j40.PAUSE, feVar.a, -1L, -1L, ke.b());
            }
        }
    }

    /* compiled from: A */
    class a extends ms<Boolean> {
        a(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Boolean bool) throws JSONException {
            fe feVar = fe.this;
            if (feVar.i != null) {
                le.a(j40.PLAY, feVar.a, r2.getDuration(), fe.this.i.getCurrentPosition(), ke.b());
            } else {
                le.a(j40.PLAY, feVar.a, -1L, -1L, ke.b());
            }
        }
    }

    public void b() throws JSONException {
        if (this.i != null) {
            ax.a(this.b, r1.getDuration(), this.i.getCurrentPosition(), ke.b(), this.i.getVideoState(), this.s, this.t);
        } else {
            ax.a(this.b, -1L, -1L, ke.b(), (j40) null, this.s, this.t);
        }
        Activity activity = this.c;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        this.c.finish();
    }

    public void o() {
        this.p = true;
        g40 g40Var = this.j;
        if (g40Var != null) {
            g40Var.a();
            this.j = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        Cif cifA;
        ae aeVar = this.f;
        if (aeVar == null || (cifA = aeVar.a()) == null) {
            return false;
        }
        return cifA.e(str);
    }

    protected void q() {
        mh mhVar = this.i;
        if (mhVar != null) {
            mhVar.play();
        }
    }

    protected boolean p() {
        mh mhVar = this.i;
        if (mhVar == null) {
            return false;
        }
        mhVar.pause();
        return true;
    }

    protected FSCallback d() {
        return (FSCallback) x5.b(this.d.g(), FSCallback.class);
    }

    protected VideoCallback e() {
        return (VideoCallback) x5.b(this.d.g(), VideoCallback.class);
    }

    protected int c() {
        yq yqVarP0 = this.a.p0();
        int i2 = -1;
        if (yqVarP0 == null) {
            return -1;
        }
        if (yqVarP0.s() != 1 && (yqVarP0.D() ? this.u : !this.v)) {
            i2 = 1;
        }
        this.u = false;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i6 i6Var) {
        h4 h4VarA = i6Var.a();
        if (h4VarA == null) {
            return;
        }
        u2 u2VarA = u2.a();
        if (!TextUtils.isEmpty(i6Var.b)) {
            u2VarA.a(this.e, h4VarA, i6Var.b);
        }
        int iC = c();
        r5 r5VarD = u2VarA.d(this.e);
        if (r5VarD != null) {
            r5VarD.b(iC);
            r5VarD.a(i6Var);
        }
        String strA = u2VarA.a(this.e);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        j6.a(new l6.b(h4VarA).a(strA).a(TextUtils.isEmpty(h4VarA.i0())).b(h4VarA.k1()).c(iC).a(i6Var).a(), this.o);
        zv.a(this.e, h4VarA, strA);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qq.e.comm.plugin.bc
    public void a(i6 i6Var, boolean z) throws JSONException {
        h4 h4VarA = i6Var.a();
        if (h4VarA == 0) {
            return;
        }
        if (z || ((h4VarA instanceof lk) && ((lk) h4VarA).b())) {
            i6Var.g = true;
        }
        u2 u2VarA = u2.a();
        u2VarA.a(this.e, h4VarA, i6Var.b);
        r5 r5VarD = u2VarA.d(this.e);
        if (r5VarD != null) {
            r5VarD.a(i6Var);
        }
        i6Var.b = u2VarA.a(this.e);
        pd.a(this.o, i6Var, false, (View) this.e);
        d().u().a();
    }
}
