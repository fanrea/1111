package com.qq.e.comm.plugin;

import android.app.Activity;
import android.content.DialogInterface;
import com.qq.e.comm.plugin.callback.biz.DialogStateCallback;
import com.qq.e.comm.plugin.callback.biz.LifecycleCallback;
import com.qq.e.comm.plugin.so;
import com.qq.e.comm.plugin.vd;
import java.util.Locale;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class be extends fe {
    public int A;
    protected vd w;
    private boolean x;
    private boolean y;
    private boolean z;

    /* compiled from: A */
    static /* synthetic */ class m {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[LifecycleCallback.a.values().length];
            a = iArr;
            try {
                iArr[LifecycleCallback.a.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[LifecycleCallback.a.PAUSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        so soVar = new so(this.c, this.a);
        soVar.a(new j());
        soVar.a(new l());
        x().j().b(1);
        soVar.j();
    }

    public be(Activity activity, h4 h4Var, sd sdVar) {
        super(activity, h4Var, sdVar);
        this.y = false;
        this.z = false;
        if (h4Var.C1()) {
            this.A = 1;
        } else {
            this.A = 2;
        }
    }

    @Override // com.qq.e.comm.plugin.bc
    public void h() {
        if (this.A == 4) {
            return;
        }
        if (!this.n) {
            xo.a((Runnable) new k());
        }
        d().n().a();
        g40 g40Var = this.j;
        if (g40Var != null) {
            g40Var.a();
        }
        this.A = 3;
    }

    /* compiled from: A */
    class k implements Runnable {
        k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            be beVar = be.this;
            beVar.e.removeView(beVar.f);
        }
    }

    @Override // com.qq.e.comm.plugin.bc
    public void g() {
        if (this.n) {
            return;
        }
        p();
        this.A = 4;
    }

    @Override // com.qq.e.comm.plugin.bc
    public void f() {
        this.x = true;
        d().f().b(Boolean.TRUE);
    }

    @Override // com.qq.e.comm.plugin.fe
    public void n() {
        if (pd.a(this.a)) {
            int i2 = this.A;
            if (i2 == 3) {
                a();
                return;
            }
            if (i2 == 4) {
                t();
                return;
            }
            if (this.i == null || r0.getCurrentPosition() >= this.d.f()) {
                p();
                if (this.d.p()) {
                    E();
                }
            }
        }
    }

    @Override // com.qq.e.comm.plugin.fe
    protected void j() {
        if (D() || B()) {
            return;
        }
        this.d.a(this.c);
        super.j();
    }

    /* compiled from: A */
    class n implements Runnable {
        n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            be.this.d().k().a();
            be beVar = be.this;
            pd.a(beVar.a, beVar.e, 3);
            be beVar2 = be.this;
            zv.a(beVar2.e, beVar2.a);
        }
    }

    @Override // com.qq.e.comm.plugin.fe
    public void m() {
        this.e.post(new n());
        this.d.r();
    }

    @Override // com.qq.e.comm.plugin.fe
    public void o() {
        super.o();
        h4 h4Var = this.a;
        if (h4Var != null) {
            h4Var.e(System.currentTimeMillis());
            le.c(this.a);
        }
    }

    private void t() {
        q();
        fk fkVar = this.g;
        if (fkVar != null) {
            fkVar.c();
        }
        h4 h4Var = this.a;
        if (h4Var != null) {
            if (h4Var.C1()) {
                this.A = 1;
            } else {
                this.A = 2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        if (this.d.j()) {
            v();
        } else {
            w();
        }
        g40 g40Var = this.j;
        if (g40Var != null) {
            g40Var.b();
        }
    }

    private void w() {
        if (this.d.n()) {
            d().Q().a();
        } else {
            A();
        }
    }

    private void v() {
        this.a.a(System.currentTimeMillis());
        if (this.m && !this.z) {
            p();
            if (this.d.m()) {
                d().Q().a();
                return;
            }
            int iA = (int) rd.a(this.a.W0() * 1000, this.d);
            int iB = ke.b();
            a((!this.a.C1() || ((long) iB) + 1000 < ((long) iA)) ? String.format(Locale.getDefault(), "观看满 %d 秒即可获得奖励\n确认要离开吗？", Integer.valueOf(iB / 1000)) : "完整观看即可获得奖励\n确认要离开吗？", "抓住奖励机会", "放弃奖励离开");
            return;
        }
        vd vdVar = this.w;
        if (vdVar != null && vdVar.isShowing()) {
            this.w.cancel();
        }
        if (D()) {
            p();
            d().R().a();
        } else if (this.d.o()) {
            p();
            d().Q().a();
        } else {
            A();
        }
    }

    private void A() {
        if (B()) {
            if (u()) {
                d().X().a();
                return;
            } else {
                p();
                d().p().a();
                return;
            }
        }
        if (this.g != null) {
            p();
            this.g.show();
        } else {
            p();
            d().Q().a();
        }
    }

    /* compiled from: A */
    class o implements vd.c {
        o() {
        }

        @Override // com.qq.e.comm.plugin.vd.c
        public void a() {
            be.this.x().i().b(2);
        }

        @Override // com.qq.e.comm.plugin.vd.c
        public void b() {
            be.this.d().Q().a();
        }
    }

    @Override // com.qq.e.comm.plugin.fe
    protected void q() {
        if (this.A == 3) {
            return;
        }
        super.q();
    }

    @Override // com.qq.e.comm.plugin.fe
    protected void r() {
        super.r();
        this.o.a(this.a);
        ((LifecycleCallback) x5.b(this.d.g(), LifecycleCallback.class)).I().a(new p(this));
        d().w().a(new q(this));
        d().Y().a(new r(this));
        d().V().a(new s(this));
        d().B().a(new t(this));
        d().A().a(new u(this));
        d().c0().a(new a(this));
        e().onPause().a(new b(this));
        e().K().a(new c(this));
        e().onStop().a(new d(this));
        e().q().a(new e(this));
        d().p().a(new f(this));
        d().z().a(new g(this));
        x().j().a(new h(this));
        x().i().a(new i(this));
    }

    /* compiled from: A */
    class p extends ms<LifecycleCallback.a> {
        p(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(LifecycleCallback.a aVar) {
            if (aVar == null) {
                return;
            }
            int i = m.a[aVar.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                be beVar = be.this;
                if (beVar.A == 1) {
                    beVar.p();
                    return;
                }
                return;
            }
            if (be.this.C()) {
                return;
            }
            be beVar2 = be.this;
            if (beVar2.A != 4) {
                beVar2.q();
            }
        }
    }

    /* compiled from: A */
    class q extends ms<Void> {
        q(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r1) {
            be.this.E();
        }
    }

    /* compiled from: A */
    class r extends ms<i6> {
        r(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(i6 i6Var) throws JSONException {
            int iC = be.this.c();
            r5 r5VarD = u2.a().d(be.this.e);
            if (r5VarD != null) {
                r5VarD.b(iC);
                r5VarD.a(i6Var);
            }
            i6Var.b = u2.a().a(be.this.e);
            i6Var.r = iC;
            be.this.b(i6Var);
            be.this.v = true;
        }
    }

    /* compiled from: A */
    class s extends ms<i6> {
        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(i6 i6Var) throws JSONException {
            r5 r5VarD = u2.a().d(be.this.e);
            if (r5VarD != null) {
                r5VarD.a(i6Var);
            }
            i6Var.b = u2.a().a(be.this.e);
            be.this.b(i6Var);
        }

        s(os osVar) {
            super(osVar);
        }
    }

    /* compiled from: A */
    class t extends ms<Void> {
        t(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r1) {
            if (be.this.x) {
                return;
            }
            be.this.g.e();
        }
    }

    /* compiled from: A */
    class u extends ms<Long> {
        u(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Long l) throws JSONException {
            Cif cifA;
            be beVar = be.this;
            if (!beVar.m || l == null) {
                return;
            }
            beVar.t = System.currentTimeMillis();
            rw rwVar = rw.MEDIA;
            be beVar2 = be.this;
            h4 h4Var = beVar2.a;
            long duration = beVar2.i == null ? -1L : r2.getDuration();
            long jLongValue = l.longValue();
            int iB = ke.b();
            mh mhVar = be.this.i;
            ax.b(rwVar, h4Var, duration, jLongValue, iB, mhVar == null ? null : mhVar.getVideoState(), false, false);
            boolean zP1 = be.this.a.p1();
            zw zwVar = new zw(l.longValue(), zP1 ? 1 : 0);
            zwVar.a(ke.b());
            zwVar.b(be.this.d.h());
            zwVar.a(be.this.r);
            be.this.d().P().b(zwVar);
            ae aeVar = be.this.f;
            if (aeVar != null && (cifA = aeVar.a()) != null) {
                cifA.a(zP1 ? 1 : 0);
            }
            be beVar3 = be.this;
            beVar3.m = false;
            h4 h4Var2 = beVar3.a;
            long duration2 = beVar3.i == null ? -1L : r2.getDuration();
            long jLongValue2 = l.longValue();
            int iB2 = ke.b();
            mh mhVar2 = be.this.i;
            ax.a(rwVar, h4Var2, duration2, jLongValue2, iB2, mhVar2 == null ? null : mhVar2.getVideoState(), false, false);
            me.a().g(be.this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(i6 i6Var) throws JSONException {
        this.d.q();
        pd.a(this.o, i6Var, D(), this.e);
        if (this.A == 1 && i6Var.a() != null) {
            pd.a(i6Var.a(), y(), this.d.i(), 3);
        }
        d().u().a();
    }

    /* compiled from: A */
    class a extends ms<zw> {
        a(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(zw zwVar) {
            zwVar.a(ke.b());
            zwVar.b(be.this.d.h());
            zwVar.a(be.this.r);
            be beVar = be.this;
            beVar.u = true;
            beVar.d().P().b(zwVar);
            kk kkVarY = be.this.y();
            if (kkVarY != null) {
                kkVarY.onReward(zwVar.a());
            }
        }
    }

    /* compiled from: A */
    class b extends ms<Void> {
        b(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r4) {
            be beVar = be.this;
            pd.a(beVar.a, beVar.y(), be.this.d.i(), 0);
        }
    }

    /* compiled from: A */
    class c extends ms<e40> {
        c(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(e40 e40Var) {
            if (be.this.z) {
                return;
            }
            be.this.z = true;
            be beVar = be.this;
            pd.a(beVar.a, beVar.y(), be.this.d.i(), 2);
            be.this.a(j40.ERROR);
        }
    }

    /* compiled from: A */
    class d extends ms<Void> {
        d(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r2) {
            be.this.a(j40.STOP);
        }
    }

    /* compiled from: A */
    class e extends ms<Void> {
        e(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r4) {
            be beVar = be.this;
            pd.a(beVar.a, beVar.y(), be.this.d.i(), 0);
            be.this.a(j40.END);
        }
    }

    /* compiled from: A */
    class f extends ms<Void> {
        f(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r2) {
            be.this.A = 3;
        }
    }

    /* compiled from: A */
    class g extends ms<Void> {
        g(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r1) {
            be.this.z();
        }
    }

    /* compiled from: A */
    class h extends ms<Integer> {
        h(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Integer num) {
            be.this.y = true;
            be.this.p();
        }
    }

    /* compiled from: A */
    class i extends ms<Integer> {
        i(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Integer num) {
            be.this.y = false;
            be.this.q();
        }
    }

    private boolean s() {
        ae aeVar = this.f;
        return (aeVar == null || aeVar.a() == null || !this.f.a().n()) ? false : true;
    }

    /* compiled from: A */
    class j implements so.f {
        j() {
        }

        @Override // com.qq.e.comm.plugin.so.f
        public void onComplainSuccess() {
            be.this.d().onComplainSuccess().a();
        }
    }

    /* compiled from: A */
    class l implements DialogInterface.OnDismissListener {
        l() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            be.this.x().i().b(1);
        }
    }

    kk y() {
        dm dmVar = this.h;
        if (dmVar instanceof kk) {
            return (kk) dmVar;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean C() {
        return this.y;
    }

    private boolean D() {
        h4 h4Var;
        return (this.f == null || (h4Var = this.a) == null || h4Var.p0() == null || !this.a.p0().C()) ? false : true;
    }

    private boolean B() {
        ae aeVar = this.f;
        return (aeVar == null || aeVar.a() == null || !this.f.a().s()) ? false : true;
    }

    private boolean u() {
        ae aeVar = this.f;
        return (aeVar == null || aeVar.a() == null || !this.f.a().q()) ? false : true;
    }

    protected DialogStateCallback x() {
        return (DialogStateCallback) x5.b(this.d.g(), DialogStateCallback.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j40 j40Var) {
        if ((j40Var == j40.STOP || j40Var == j40.END) && this.d.a()) {
            d().Q().a();
            return;
        }
        if (j40Var == j40.END && s()) {
            this.f.c().play();
        } else if (B()) {
            d().p().a();
        }
    }

    @Override // com.qq.e.comm.plugin.fe, com.qq.e.comm.plugin.bc
    public void a(i6 i6Var, boolean z) throws JSONException {
        Cif cifA;
        super.a(i6Var, z);
        h4 h4VarA = i6Var.a();
        if (h4VarA == null) {
            return;
        }
        if (z && (cifA = this.f.a()) != null) {
            cifA.u();
        }
        le.a(h4VarA, false);
    }

    @Override // com.qq.e.comm.plugin.bc
    public void a() {
        if (this.A == 4) {
            t();
        } else {
            le.a(this.a, true);
            d().Q().a();
        }
    }

    private void a(String str, String str2, String str3) {
        if (this.A == 3) {
            return;
        }
        if (this.w == null) {
            this.w = new vd(this.c);
        }
        this.w.a(this.c, this.a, this.d, str, str2, str3, new o());
        x().j().b(2);
    }
}
