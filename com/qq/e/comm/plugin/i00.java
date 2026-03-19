package com.qq.e.comm.plugin;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.plugin.g00;
import com.qq.e.comm.plugin.k00;
import com.qq.e.comm.plugin.rl;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class i00 implements Runnable, rl.b, k00.d, g00.b {
    private static final FrameLayout.LayoutParams r = new FrameLayout.LayoutParams(-1, -1, 17);
    private xz a;
    private rl c;
    private b d;
    private k00 e;
    private boolean f;
    private boolean g;
    private h00 h;
    private int i;
    private String j;
    private boolean m;
    private long p;
    private long q;
    private final hm b = new hm();
    private int n = -1;
    private int o = 0;

    i00() {
    }

    public boolean f() {
        return this.a == null || this.b.a == null;
    }

    private void b() {
        if (this.c != null) {
            h00 h00Var = this.h;
            if (h00Var != null) {
                h00Var.a(0, this.i, this.g);
            }
            this.c.a(this.f);
            if (this.e != null) {
                b50.a(this.c.a());
            }
            this.c = null;
        }
    }

    private int c() {
        mu muVarB;
        xz xzVar = this.a;
        if (xzVar == null || (muVarB = xzVar.b()) == null) {
            return 0;
        }
        if (this.n < 0) {
            this.n = xc.a("spsirc", this.a.c, 7, muVarB.x0());
        }
        return this.n;
    }

    @Override // java.lang.Runnable
    public void run() throws JSONException {
        Boolean bool;
        xz xzVar = this.a;
        if (f() || (bool = xzVar.v.get()) == null) {
            return;
        }
        this.o++;
        if (a(xzVar)) {
            b();
            ViewGroup viewGroup = xzVar.r;
            if (viewGroup.getChildCount() > 0) {
                viewGroup.removeAllViews();
            }
            rl rlVarA = j00.a(xzVar, this, bool.booleanValue());
            this.c = rlVarA;
            if (bool.booleanValue()) {
                String strO = this.b.o();
                this.j = strO;
                rlVarA.a(strO, new c());
                if (!this.m) {
                    a(rlVarA);
                }
            } else {
                rlVarA.a(this.b.i());
                a(rlVarA);
            }
            b(rlVarA);
            viewGroup.addView(rlVarA.a(), r);
            g00.a(viewGroup, xzVar.p, this, xzVar.c(), xzVar);
        }
    }

    public void h() {
        xz xzVar = this.a;
        if (xzVar == null || xzVar == null || TextUtils.isEmpty(this.j) || TextUtils.equals(this.j, this.b.o()) || !qm$h$$ExternalSyntheticBackport0.m(xzVar.v, Boolean.TRUE, null)) {
            return;
        }
        l();
        f00.d(xzVar.c());
    }

    public void l() {
        xz xzVar = this.a;
        if (f()) {
            return;
        }
        this.o = 0;
        this.p = SystemClock.elapsedRealtime();
        this.q = System.currentTimeMillis();
        boolean zC1 = TextUtils.isEmpty(this.b.o()) ? false : xzVar.b().C1();
        mu muVarB = this.a.b();
        if (muVarB != null) {
            this.m = xc.a("svrsavs", muVarB.y0(), 0, muVarB.x0()) == 1;
        }
        if (qm$h$$ExternalSyntheticBackport0.m(xzVar.v, null, Boolean.valueOf(zC1))) {
            xo.d(this);
        }
    }

    public void a() {
        b();
        b bVar = this.d;
        if (bVar != null) {
            bVar.b = null;
            this.d = null;
        }
        this.b.a = null;
        this.e = null;
    }

    public void j() {
        rl rlVar = this.c;
        mh mhVarB = rlVar == null ? null : rlVar.b();
        if (mhVarB == null || mhVarB.getVideoState() != j40.PAUSE) {
            return;
        }
        mhVarB.play();
    }

    public void r() {
        rl rlVar;
        ViewGroup viewGroupA;
        if (f() || (rlVar = this.c) == null || (viewGroupA = rlVar.a()) == null) {
            return;
        }
        mh mhVarB = this.c.b();
        j40 videoState = mhVarB != null ? mhVarB.getVideoState() : null;
        mh mhVar = (videoState == null || videoState == j40.PAUSE || videoState == j40.PLAY) ? mhVarB : null;
        this.c.g();
        k00 k00Var = new k00(viewGroupA, mhVar, this.a.b().c0(), this.a.c(), this);
        this.e = k00Var;
        k00Var.i();
    }

    public void t() {
        k00 k00Var = this.e;
        if (k00Var != null) {
            k00Var.j();
        }
    }

    public void g() {
        rl rlVar = this.c;
        mh mhVarB = rlVar == null ? null : rlVar.b();
        if (mhVarB == null || mhVarB.getVideoState() != j40.PLAY) {
            return;
        }
        mhVarB.pause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() throws JSONException {
        xz xzVar = this.a;
        if (f()) {
            return;
        }
        if (this.e != null && xzVar.b() != null) {
            this.e.e();
        }
        if (xzVar.j != null) {
            this.a.j.onADEvent(new ADEvent(114, new Object[0]));
        }
    }

    @Override // com.qq.e.comm.plugin.k00.d
    public void m() {
        g();
        rl rlVar = this.c;
        if (rlVar != null) {
            rlVar.f();
        }
        this.b.m();
    }

    @Override // com.qq.e.comm.plugin.k00.d
    public void s() {
        mu muVarB;
        xz xzVar = this.a;
        if (xzVar == null || (muVarB = xzVar.b()) == null) {
            return;
        }
        i6 i6Var = new i6(muVarB);
        i6Var.c = 10071;
        qj qjVar = new qj(i6Var);
        qjVar.a.h = 0;
        b(qjVar);
    }

    public void a(xz xzVar, gm gmVar) {
        this.a = xzVar;
        this.b.a = gmVar;
        this.i = 1;
        this.g = false;
        this.f = false;
    }

    public Bitmap e() {
        k00 k00Var = this.e;
        if (k00Var != null) {
            return k00Var.c();
        }
        return null;
    }

    public void p() {
        xz xzVar = this.a;
        if (f()) {
            return;
        }
        AtomicReference<Boolean> atomicReference = xzVar.v;
        Boolean bool = Boolean.FALSE;
        if (qm$h$$ExternalSyntheticBackport0.m(atomicReference, null, bool) || qm$h$$ExternalSyntheticBackport0.m(xzVar.v, Boolean.TRUE, bool)) {
            xo.d(this);
        }
    }

    @Override // com.qq.e.comm.plugin.wp.b
    public void k() {
        xz xzVar = this.a;
        if (xzVar == null || xzVar.v.get() == null) {
            return;
        }
        this.b.k();
    }

    @Override // com.qq.e.comm.plugin.wp.b
    public void d() {
        xz xzVar = this.a;
        if (xzVar == null || xzVar.v.get() == null) {
            return;
        }
        this.b.d();
    }

    /* compiled from: A */
    private static class b implements Runnable {
        long a;
        rl b;

        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            rl rlVar = this.b;
            if (rlVar != null) {
                rlVar.a(this.a);
            }
        }
    }

    /* compiled from: A */
    private class c implements yg {
        final long a;

        @Override // com.qq.e.comm.plugin.yg
        public void b() {
        }

        @Override // com.qq.e.comm.plugin.yg
        public void c() {
        }

        @Override // com.qq.e.comm.plugin.yg
        public void d() {
        }

        @Override // com.qq.e.comm.plugin.yg
        public void onVideoPause() {
        }

        @Override // com.qq.e.comm.plugin.yg
        public void onVideoReady() {
        }

        @Override // com.qq.e.comm.plugin.yg
        public void onVideoResume() {
        }

        @Override // com.qq.e.comm.plugin.yg
        public void onVideoStop() {
        }

        private c() {
            this.a = System.currentTimeMillis();
        }

        private boolean e() {
            xz xzVar = i00.this.a;
            return i00.this.f() || i00.this.c == null || i00.this.c.b() == null || xzVar.v.get() == null || !xzVar.v.get().booleanValue();
        }

        @Override // com.qq.e.comm.plugin.yg
        public void onVideoStart() {
            xz xzVar = i00.this.a;
            if (e()) {
                return;
            }
            if (xzVar.g() && i00.this.g) {
                return;
            }
            i00.this.h = new h00(xzVar, i00.this.c == null ? null : i00.this.c.b());
            if (i00.this.m) {
                i00 i00Var = i00.this;
                i00Var.a(i00Var.c);
            }
            f00.a(xzVar, this.a);
        }

        @Override // com.qq.e.comm.plugin.yg
        public void a() throws JSONException {
            mh mhVarB;
            xz xzVar = i00.this.a;
            if (e() || i00.this.c == null || (mhVarB = i00.this.c.b()) == null) {
                return;
            }
            if (i00.this.c.c()) {
                a(mhVarB);
                return;
            }
            if (xzVar.g()) {
                if (mhVarB.getDuration() >= 15000 || i00.this.g || i00.this.e == null || !i00.this.e.d()) {
                    i00.this.u();
                    return;
                }
                mhVarB.getDuration();
                i00.this.g = true;
                a(mhVarB);
            }
        }

        @Override // com.qq.e.comm.plugin.yg
        public void a(int i, Exception exc) {
            xz unused = i00.this.a;
            if (e()) {
                return;
            }
            if (i00.this.h != null) {
                i00.this.h.a(2, i00.this.i, i00.this.g);
                i00.this.h = null;
            }
            i00.this.p();
        }

        private void a(mh mhVar) {
            i00.this.i = 3;
            mhVar.play();
        }
    }

    private boolean a(xz xzVar) throws JSONException {
        int i;
        ViewGroup viewGroup = xzVar.r;
        if (viewGroup == null) {
            this.b.a(new nc(4004));
            f00.a(1013026, this.o, 0, f00.a, xzVar.c(), null);
            return false;
        }
        int i2 = 1;
        boolean z = viewGroup.getVisibility() == 0 && viewGroup.isShown();
        boolean z2 = viewGroup.getWindowVisibility() == 0;
        if (z && z2) {
            f00.a(1013027, this.o, 0, 0, xzVar.c(), null);
            return true;
        }
        int iC = c();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int i3 = viewGroup.getWindowToken() != null ? 1 : 0;
        if (i3 != 0 && (((iC & 1) != 0 && jElapsedRealtime - xzVar.B < xzVar.o) || (((iC & 2) != 0 && z && !z2 && jElapsedRealtime - this.p < zz.b()) || ((iC & 4) != 0 && !s3.b().c() && jElapsedRealtime - this.p < zz.a())))) {
            xo.a(this, 200L);
            return false;
        }
        Activity activityA = c1.a((View) viewGroup);
        this.b.a(new nc(4004));
        if (z) {
            i = f00.c;
        } else {
            i = f00.b;
        }
        int i4 = i;
        if (activityA != null) {
            i2 = c1.a(activityA) ? 2 : 3;
        }
        int i5 = (i2 * 100) + (i3 * 10) + (s3.b().c() ? 1 : 0);
        ja jaVar = new ja();
        Activity activityA2 = s3.b().a();
        jaVar.a("msg", activityA2 == null ? ILogConst.CACHE_PLAY_REASON_NULL : activityA2.toString());
        mu muVarB = this.a.b();
        if (muVarB != null) {
            jaVar.a("du", Long.valueOf(muVarB.X() - muVarB.L0()));
            jaVar.a("data2", Long.valueOf(this.q - muVarB.X()));
        }
        jaVar.a("data3", Long.valueOf(jElapsedRealtime - this.p));
        f00.a(1013026, this.o, i5, i4, xzVar.c(), jaVar);
        return false;
    }

    @Override // com.qq.e.comm.plugin.rl.b
    public void b(qj qjVar) {
        xz xzVar;
        Boolean bool;
        h00 h00Var;
        if (qjVar == null || (xzVar = this.a) == null || (bool = xzVar.v.get()) == null) {
            return;
        }
        if (bool.booleanValue() && (h00Var = this.h) != null) {
            h00Var.a(3, this.i, this.g);
        }
        this.b.a(qjVar);
    }

    private void b(rl rlVar) {
        xz xzVar = this.a;
        if (rlVar == null || f() || xzVar.v.get() == null) {
            return;
        }
        xzVar.x = System.currentTimeMillis();
        xzVar.w = rlVar.a();
        this.b.n();
    }

    @Override // com.qq.e.comm.plugin.g00.b
    public void a(boolean z, int i) {
        xz xzVar = this.a;
        if (xzVar == null || xzVar.v.get() == null) {
            return;
        }
        if (z) {
            this.b.q();
        } else {
            this.b.a(new nc(i));
        }
    }

    @Override // com.qq.e.comm.plugin.rl.b
    public void a(int i, int i2) {
        mu muVarB;
        xz xzVar = this.a;
        if (xzVar == null || (muVarB = xzVar.b()) == null) {
            return;
        }
        qj qjVar = new qj(new i6(muVarB));
        qjVar.b = i;
        qjVar.a.h = i2;
        b(qjVar);
    }

    void a(long j) {
        if (this.d == null) {
            b bVar = new b();
            this.d = bVar;
            bVar.b = this.c;
        }
        b bVar2 = this.d;
        bVar2.a = j;
        xo.d(bVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(rl rlVar) {
        xz xzVar = this.a;
        if (rlVar == null || f() || xzVar.v.get() == null) {
            return;
        }
        rlVar.e();
    }
}
