package com.qq.e.comm.plugin;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.core.location.LocationRequestCompat;
import com.qq.e.comm.plugin.adview.video.VideoCallback;
import com.qq.e.comm.plugin.callback.biz.LifecycleCallback;
import com.qq.e.comm.plugin.e50;
import com.qq.e.comm.plugin.fs.FSCallback;
import com.qq.e.comm.plugin.hg;
import com.qq.e.comm.plugin.me;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ee implements kk, em, os {
    private static final String I = "ee";
    private boolean A;
    private o8 B;
    private volatile int D;
    private e20 E;
    private long G;
    private final h4 b;
    private final Cif c;
    private final mh d;
    private e50 f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean m;
    private boolean n;
    private final int o;
    private final FSCallback p;
    private final VideoCallback q;
    private final sd r;
    private boolean s;
    private final int u;
    private boolean v;
    private boolean w;
    private int y;
    private boolean z;
    private final ns a = new ns();
    private final m8 e = new m8();
    private boolean t = false;
    private boolean x = false;
    private final ArrayList<String> C = new ArrayList<>();
    private boolean F = false;
    private final yg H = new g();

    /* compiled from: A */
    class g extends yx {
        g() {
        }

        @Override // com.qq.e.comm.plugin.yx, com.qq.e.comm.plugin.yg
        public void onVideoReady() throws JSONException {
            super.onVideoReady();
            ee.this.s = true;
            ee.this.o();
            ee.this.q.b().b(Integer.valueOf(ee.this.d == null ? 0 : ee.this.d.getDuration()));
        }

        @Override // com.qq.e.comm.plugin.yx, com.qq.e.comm.plugin.yg
        public void onVideoStart() {
            super.onVideoStart();
            ee.this.g = true;
            ee.this.q.a().a();
            me.a().f(ee.this.b);
        }

        @Override // com.qq.e.comm.plugin.yx, com.qq.e.comm.plugin.yg
        public void onVideoPause() {
            super.onVideoPause();
            ee.this.q.onPause().a();
        }

        @Override // com.qq.e.comm.plugin.yx, com.qq.e.comm.plugin.yg
        public void onVideoResume() {
            super.onVideoResume();
            ee.this.q.onResume().a();
            ee.this.h = true;
        }

        @Override // com.qq.e.comm.plugin.yx, com.qq.e.comm.plugin.yg
        public void a() throws JSONException {
            super.a();
            ee.this.a(true);
        }

        @Override // com.qq.e.comm.plugin.yx, com.qq.e.comm.plugin.yg
        public void onVideoStop() {
            super.onVideoStop();
            ee.this.q.onStop().a();
        }

        @Override // com.qq.e.comm.plugin.yx, com.qq.e.comm.plugin.yg
        public void a(int i, Exception exc) {
            super.a(i, exc);
            ee.this.q.K().b(new e40(true, i, exc, 5003));
            me.a().e(ee.this.b);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ee(Context context, h4 h4Var, sd sdVar) throws JSONException {
        boolean z = false;
        this.b = h4Var;
        this.r = sdVar;
        yq yqVarP0 = h4Var.p0();
        if (yqVarP0 != null) {
            this.y = yqVarP0.e();
        }
        b(sdVar.j());
        if ((h4Var instanceof lk) && ((lk) h4Var).b()) {
            this.u = dx.c(h4Var) * 1000;
        } else {
            this.u = -1;
        }
        this.v = this.u >= 0;
        this.o = dx.a(h4Var);
        FSCallback fSCallback = (FSCallback) x5.b(h4Var.s0(), FSCallback.class);
        this.p = fSCallback;
        VideoCallback videoCallback = (VideoCallback) x5.b(h4Var.s0(), VideoCallback.class);
        this.q = videoCallback;
        boolean zA = r1.d().c().A();
        yq yqVarP02 = h4Var.p0();
        int i2 = zA ? 2 : 1;
        if (yqVarP02 != null && (i2 == yqVarP02.p() || (!p8.a && yqVarP02.p() == 0))) {
            z = true;
        }
        Cif cifA = q8.a().a(context, h4Var, z);
        this.c = cifA;
        if (cifA == null) {
            this.d = null;
            return;
        }
        cifA.a((hg.c) null);
        mh mhVarJ = cifA.j();
        this.d = mhVarJ;
        if (mhVarJ == null) {
            return;
        }
        o8 o8Var = new o8(h4Var, cifA, this);
        this.B = o8Var;
        o8Var.c();
        this.z = cifA.q();
        mhVarJ.r().addOnAttachStateChangeListener(new h());
        mhVarJ.a(new i(h4Var, me.a().d(h4Var)));
        this.i = sdVar.l();
        h();
        cifA.a(new j(cifA, h4Var));
        n();
        qg.b.submit(new k());
        m();
        fSCallback.f().a(new l(this));
        fSCallback.R().a(new m(this));
        fSCallback.p().a(new n(this));
        fSCallback.X().a(new o(this));
        fSCallback.H().a(new a(this));
        videoCallback.K().a(new b(this));
        ((LifecycleCallback) x5.b(h4Var.s0(), LifecycleCallback.class)).I().a(new c(this));
    }

    /* compiled from: A */
    class h implements View.OnAttachStateChangeListener {
        h() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            if (ee.this.f != null) {
                ee.this.f.a(view.getContext());
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (ee.this.f != null) {
                ee.this.f.b(view.getContext());
            }
        }
    }

    /* compiled from: A */
    class i extends bh {
        i(h4 h4Var, boolean z) {
            super(h4Var, z);
        }

        @Override // com.qq.e.comm.plugin.bh
        public void a() throws JSONException {
            ee.this.a(false);
            if (!ee.this.c.s()) {
                ee.this.p.T().a();
            }
            ee.this.d.I();
        }

        @Override // com.qq.e.comm.plugin.bh, com.qq.e.comm.plugin.ah
        public boolean a(int i, j40 j40Var, float f) {
            if (!super.a(i, j40Var, f)) {
                return false;
            }
            me.a().a(ee.this.b, i, j40Var);
            return true;
        }

        @Override // com.qq.e.comm.plugin.bh, com.qq.e.comm.plugin.ah
        public void a(int i, int i2, int i3) {
            super.a(i, i2, i3);
            me.a().a(ee.this.b, i, i2, ee.this.D);
        }
    }

    /* compiled from: A */
    class j extends gf {
        j(f9 f9Var, h4 h4Var) {
            super(f9Var, h4Var);
        }

        @Override // com.qq.e.comm.plugin.gf
        public void a(i6 i6Var, h8 h8Var) {
            super.a(i6Var, h8Var);
            ee.this.p.Y().b(i6Var);
        }

        @Override // com.qq.e.comm.plugin.gf
        public void c(h8 h8Var) {
            super.c(h8Var);
            String unused = ee.I;
            ee.this.p.w().a();
        }

        @Override // com.qq.e.comm.plugin.gf
        public void f(h8 h8Var) {
            super.f(h8Var);
            String unused = ee.I;
            ee.this.p.Q().a();
        }

        @Override // com.qq.e.comm.plugin.gf
        public void d(h8 h8Var) {
            String unused = ee.I;
            ee.this.p.z().a();
        }

        @Override // com.qq.e.comm.plugin.gf
        public void g(h8 h8Var) {
            le.a(ee.this.b, 0);
            ee.this.p.B().a();
        }

        @Override // com.qq.e.comm.plugin.gf
        public void e(h8 h8Var) {
            String unused = ee.I;
            ee.this.p.Q().a();
        }

        @Override // com.qq.e.comm.plugin.gf
        public void l(h8 h8Var) throws JSONException {
            if (ee.this.B != null) {
                ee.this.B.a();
            }
        }

        @Override // com.qq.e.comm.plugin.gf
        public void m(h8 h8Var) throws JSONException {
            if (ee.this.B != null) {
                ee.this.B.b();
            }
        }

        @Override // com.qq.e.comm.plugin.gf
        public void c() throws JSONException {
            super.c();
            String unused = ee.I;
            ee.this.i = !r0.i;
            ee.this.o();
        }
    }

    /* compiled from: A */
    class k implements Runnable {
        k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            File fileA = f40.a(ee.this.b);
            String strA = null;
            String absolutePath = fileA != null ? fileA.getAbsolutePath() : null;
            if (TextUtils.isEmpty(absolutePath)) {
                if (!me.a().d(ee.this.b)) {
                    strA = ui.a().a(ee.this.b.V0());
                } else {
                    strA = ui.a().c(ee.this.b.V0(), ee.this.b.k().c);
                }
            }
            xo.a((Runnable) new a(absolutePath, strA));
        }

        /* compiled from: A */
        class a implements Runnable {
            final /* synthetic */ String a;
            final /* synthetic */ String b;

            a(String str, String str2) {
                this.a = str;
                this.b = str2;
            }

            @Override // java.lang.Runnable
            public void run() throws JSONException {
                if (!TextUtils.isEmpty(this.a)) {
                    ee.this.b(this.a);
                    return;
                }
                me.a().a(ee.this.b.V0(), this.b, new C0708a(), ee.this.b, false);
                if (TextUtils.isEmpty(this.b)) {
                    return;
                }
                ee.this.b(this.b);
            }

            /* compiled from: A */
            /* renamed from: com.qq.e.comm.plugin.ee$k$a$a, reason: collision with other inner class name */
            class C0708a extends me.d {
                C0708a() {
                }

                @Override // com.qq.e.comm.plugin.me.d, com.qq.e.comm.plugin.me.c
                public void a(String str) throws JSONException {
                    super.a(str);
                    if ((TextUtils.isEmpty(a.this.b) || !ee.this.g) && !TextUtils.isEmpty(str)) {
                        ee.this.b(str);
                    }
                }

                @Override // com.qq.e.comm.plugin.me.c
                public void onCancel() {
                    String unused = ee.I;
                    ee.this.q.K().b(new e40(false, -1, null, 5002));
                }

                @Override // com.qq.e.comm.plugin.me.c
                public void b() {
                    String unused = ee.I;
                    ee.this.q.K().b(new e40(false, -2, null, 5002));
                }

                @Override // com.qq.e.comm.plugin.me.c
                public void a(db dbVar) {
                    String unused = ee.I;
                    ee.this.q.K().b(new e40(false, dbVar.a(), dbVar, 5002));
                }

                @Override // com.qq.e.comm.plugin.me.d, com.qq.e.comm.plugin.me.c
                public void a(int i, long j, long j2) {
                    super.a(i, j, j2);
                    ee.this.D = i;
                }

                @Override // com.qq.e.comm.plugin.me.d, com.qq.e.comm.plugin.me.c
                public void a() {
                    super.a();
                    ee.this.q.S().a();
                }
            }
        }
    }

    /* compiled from: A */
    class l extends ms<Boolean> {
        l(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Boolean bool) {
            if (bool != null) {
                ee.this.v = !bool.booleanValue();
            }
        }
    }

    /* compiled from: A */
    class m extends ms<Void> {
        m(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r2) {
            if (ee.this.t) {
                ee.this.p.Q().a();
            } else {
                ee.this.a("closeVideo");
            }
        }
    }

    /* compiled from: A */
    class n extends ms<Void> {
        n(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r3) throws JSONException {
            if (ee.this.w) {
                return;
            }
            ee.this.c.a(new m8().e(false).f());
            ee.this.c.v();
        }
    }

    /* compiled from: A */
    class o extends ms<Void> {
        o(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r1) throws JSONException {
            ee.this.p();
        }
    }

    /* compiled from: A */
    class a extends ms<Void> {
        a(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r1) {
            ee.this.E.b();
        }
    }

    /* compiled from: A */
    class b extends ms<e40> {
        b(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(e40 e40Var) throws JSONException {
            ee.this.a("closeVideoAuto");
            ee.this.l();
        }
    }

    /* compiled from: A */
    class c extends ms<LifecycleCallback.a> {
        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(LifecycleCallback.a aVar) {
            if (LifecycleCallback.a.DESTROYED == aVar) {
                ee.this.j();
            }
        }

        c(os osVar) {
            super(osVar);
        }
    }

    /* compiled from: A */
    class d implements tl {
        d() {
        }

        @Override // com.qq.e.comm.plugin.tl
        public void a(w40 w40Var, z8 z8Var) {
            h4 h4VarA;
            if (w40Var == null || w40Var.A() == null || z8Var == null) {
                return;
            }
            String unused = ee.I;
            String strOptString = z8Var.c.optString("tid");
            if (z8Var.a != 1 || TextUtils.isEmpty(strOptString) || strOptString.equals(ee.this.b.S0()) || ee.this.C.contains(strOptString) || (h4VarA = ee.this.b.a(strOptString)) == null) {
                return;
            }
            ee.this.C.add(strOptString);
            View viewA = w40Var.A();
            viewA.post(new a(viewA, h4VarA));
        }

        /* compiled from: A */
        class a implements Runnable {
            final /* synthetic */ View a;
            final /* synthetic */ h4 b;

            @Override // java.lang.Runnable
            public void run() {
                u2.a().a(this.a, this.b);
                r5 r5VarD = u2.a().d(this.a);
                if (r5VarD != null) {
                    r5VarD.a(this.b.f0());
                }
                ee.this.p.k().a();
                pd.a(this.b, this.a, 3);
            }

            a(View view, h4 h4Var) {
                this.a = view;
                this.b = h4Var;
            }
        }
    }

    private void n() {
        this.c.a(new d());
    }

    /* compiled from: A */
    class e implements e50.a {
        e() {
        }

        @Override // com.qq.e.comm.plugin.e50.a
        public void a(float f) throws JSONException {
            ee.this.i = f > 0.0f;
            ee.this.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() throws JSONException {
        if (this.x) {
            return;
        }
        this.x = true;
        this.c.a(new m8().e().h(false).e(true).f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() throws JSONException {
        if (this.w) {
            return;
        }
        this.w = true;
        this.j = true;
        this.v = false;
        this.x = true;
        this.c.a(new m8().e(false).f());
        this.c.v();
    }

    private void h() throws JSONException {
        this.x = this.r.k();
        this.c.a(new m8().a(this.H).e(this.x).b(false).g(this.i).h(this.s).a(new zd(this.c, this.b, this.p)).d(this.b.i0()).f());
    }

    @Override // com.qq.e.comm.plugin.fj
    public void onReward(int i2) {
        Cif cif = this.c;
        if (cif != null) {
            cif.a(i2);
        }
    }

    private void m() {
        this.f = new e50(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() throws JSONException {
        this.c.a(new m8().g(this.i).h(this.s).f());
    }

    /* compiled from: A */
    class f implements xl {
        final /* synthetic */ boolean a;

        f(boolean z) {
            this.a = z;
        }

        @Override // com.qq.e.comm.plugin.xl
        public void b(long j) {
            if (ee.this.b.q1()) {
                ee.this.p.A().b(Long.valueOf(j));
            }
        }

        @Override // com.qq.e.comm.plugin.xl
        public void a(long j) throws JSONException {
            if (ee.this.c == null) {
                return;
            }
            ee eeVar = ee.this;
            eeVar.a(j, eeVar.G);
        }

        @Override // com.qq.e.comm.plugin.xl
        public long c() {
            return this.a ? ke.b() : LocationRequestCompat.PASSIVE_INTERVAL;
        }
    }

    @Override // com.qq.e.comm.plugin.kk
    public boolean d() {
        return this.h;
    }

    @Override // com.qq.e.comm.plugin.dm
    public mh b() {
        return this.d;
    }

    public void j() {
        Cif cif = this.c;
        if (cif != null) {
            cif.c();
        }
        mh mhVar = this.d;
        if (mhVar != null) {
            mhVar.free();
        }
        this.B = null;
        me.a().a(this.b, this.d);
        this.F = true;
    }

    @Override // com.qq.e.comm.plugin.os
    public ns i() {
        return this.a;
    }

    @Override // com.qq.e.comm.plugin.os
    public boolean k() {
        return this.F;
    }

    @Override // com.qq.e.comm.plugin.fj
    public Cif f() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2, long j3) throws JSONException {
        this.q.F().b(Long.valueOf(j2));
        long jA = rd.a(j3, this.r);
        if (this.z && !this.w && jA - j2 <= this.y * 1000) {
            p();
        }
        this.e.a(j2, jA).a(j2);
        long jMin = Math.min(jA, this.r.b() * 1000);
        if (!this.j && j2 - jMin >= 0) {
            this.c.c("showBottomCard");
            this.j = true;
        }
        long jE = this.r.e() * 1000;
        if (!this.n && j2 >= jE) {
            this.e.a(false);
            this.n = true;
        }
        if (!this.m && j2 >= this.o * 1000) {
            this.e.b(true);
            this.m = true;
        }
        if (this.v && this.s && j2 >= this.u) {
            this.v = false;
            this.c.c("showGameEntry");
        }
        if (!this.x && j2 >= ke.a()) {
            this.e.e(true);
            this.x = true;
        }
        if (!this.A && rd.a(j2, jA, this.r)) {
            if (this.d != null) {
                a(true);
                this.d.I();
            }
            this.A = true;
        }
        this.c.a(j2);
        this.c.a(this.e.f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) throws JSONException {
        if (this.d == null) {
            return;
        }
        this.q.Z().a();
        this.c.a(new m8().g(str).f());
    }

    private void b(boolean z) {
        e20 e20Var = new e20(this.b);
        this.E = e20Var;
        e20Var.a(new f(z));
    }

    @Override // com.qq.e.comm.plugin.dm
    public void a(g40 g40Var) {
        g40Var.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        this.t = true;
        if (this.d == null) {
            return;
        }
        this.c.a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) throws JSONException {
        if (z) {
            this.q.q().a();
        }
        l();
        a("closeVideoAuto");
    }

    @Override // com.qq.e.comm.plugin.fj
    public View a() {
        Cif cif = this.c;
        if (cif == null) {
            return null;
        }
        return cif.l();
    }

    @Override // com.qq.e.comm.plugin.em
    public boolean a(j40 j40Var, long j2, long j3) {
        if (j2 <= 0) {
            return true;
        }
        this.G = j2;
        this.E.a(j3);
        return true;
    }
}
