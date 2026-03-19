package com.qq.e.comm.plugin;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.material.timepicker.TimeModel;
import com.qq.e.comm.plugin.hg;
import com.qq.e.comm.plugin.rl;
import com.qq.e.comm.plugin.wp;
import java.io.File;
import java.util.Locale;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class d00 implements rl, wp.b {
    private static final boolean j;
    private final xz a;
    private final rl.a b;
    private final rl.b c;
    private final Cif d;
    private mh e;
    private final m8 f = new m8();
    private long g;
    private boolean h;
    private boolean i;

    static {
        j = r1.d().f().a("sscdtoe", 1) == 1;
    }

    d00(xz xzVar, rl.b bVar, boolean z) {
        this.a = xzVar;
        this.c = bVar;
        this.b = new rl.a(xzVar);
        mu muVarB = xzVar.b();
        boolean zA = r1.d().c().A();
        yq yqVarP0 = muVarB != null ? muVarB.p0() : null;
        this.d = q8.a().a(xzVar.a, muVarB, yqVarP0 != null && zA == yqVarP0.B(), z);
    }

    @Override // com.qq.e.comm.plugin.rl
    public mh b() {
        return this.e;
    }

    @Override // com.qq.e.comm.plugin.rl
    public void e() {
        mu muVarB = this.a.b();
        if (muVarB == null || this.d == null) {
            return;
        }
        if (this.e != null) {
            this.b.setAlpha(1.0f);
        }
        this.d.a(new a(this.d, muVarB, this));
    }

    /* compiled from: A */
    class a extends gf {
        a(f9 f9Var, h4 h4Var, wp.b bVar) {
            super(f9Var, h4Var, bVar);
        }

        @Override // com.qq.e.comm.plugin.gf
        public void a(i6 i6Var, h8 h8Var) {
            super.a(i6Var, h8Var);
            d00.this.c.b(new qj(i6Var));
        }

        @Override // com.qq.e.comm.plugin.gf
        public void c(h8 h8Var) {
            d00.this.c.a(2, 0);
        }

        @Override // com.qq.e.comm.plugin.gf
        public void f(h8 h8Var) {
            d00.this.c.a(2, 0);
        }

        @Override // com.qq.e.comm.plugin.gf
        public void e(h8 h8Var) {
            d00.this.c.a(2, 0);
        }
    }

    @Override // com.qq.e.comm.plugin.rl
    public void g() {
        View viewR;
        ViewGroup viewGroupA = a();
        viewGroupA.removeAllViews();
        viewGroupA.setBackgroundColor(-16777216);
        mh mhVar = this.e;
        if (mhVar == null || (viewR = mhVar.r()) == null) {
            return;
        }
        b50.a(viewR);
        this.e.a(dy.DEFAULT);
        if (viewGroupA instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            viewGroupA.addView(viewR, layoutParams);
            return;
        }
        viewGroupA.addView(viewR, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.qq.e.comm.plugin.rl
    public boolean c() {
        Cif cif = this.d;
        return cif != null && cif.n();
    }

    @Override // com.qq.e.comm.plugin.rl
    public void f() {
        this.b.removeAllViews();
    }

    @Override // com.qq.e.comm.plugin.wp.b
    public void d() {
        this.c.d();
    }

    @Override // com.qq.e.comm.plugin.wp.b
    public void k() {
        this.c.k();
    }

    @Override // com.qq.e.comm.plugin.rl
    public void a(boolean z) {
        Cif cif = this.d;
        if (cif != null) {
            cif.c();
        }
        mh mhVar = this.e;
        if (mhVar != null) {
            if (!z) {
                mhVar.pause();
                this.e.a((yg) null);
                this.e.free();
            }
            this.e = null;
        }
        this.b.a();
    }

    @Override // com.qq.e.comm.plugin.rl
    public ViewGroup a() {
        if (this.d == null) {
            return null;
        }
        return this.b;
    }

    private void a(m8 m8Var, long j2) throws JSONException {
        long jMax = Math.max(j2 - 1, 0L);
        float fFloor = jMax / 1000.0f;
        if (this.h) {
            fFloor = (float) Math.floor(fFloor);
        }
        m8Var.e(String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(Math.round(fFloor))));
        this.d.a(this.g - jMax);
        this.d.a(m8Var.f());
    }

    @Override // com.qq.e.comm.plugin.rl
    public void a(long j2) throws JSONException {
        int iR;
        Cif cif = this.d;
        if (cif != null) {
            if (cif.s() && (iR = this.d.r()) > 0) {
                if (!this.i && j2 <= iR) {
                    this.i = true;
                    this.d.v();
                }
                long j3 = iR;
                if (j2 > j3) {
                    j2 -= j3;
                }
            }
            a(this.f, j2);
        }
    }

    @Override // com.qq.e.comm.plugin.rl
    public void a(File file) throws JSONException {
        Cif cif = this.d;
        if (cif == null) {
            return;
        }
        View viewL = cif.l();
        mu muVarB = this.a.b();
        m8 m8Var = new m8();
        m8Var.b(muVarB.c0());
        a(m8Var, viewL, muVarB);
    }

    @Override // com.qq.e.comm.plugin.rl
    public void a(String str, yg ygVar) throws JSONException {
        Cif cif = this.d;
        if (cif == null) {
            return;
        }
        cif.a((hg.c) null);
        mh mhVarJ = this.d.j();
        this.e = mhVarJ;
        if (mhVarJ == null) {
            return;
        }
        this.b.b = mhVarJ;
        mu muVarB = this.a.b();
        if (!hg.I) {
            this.e.a(new bh(muVarB, false));
        }
        hg.b bVarF = this.d.f();
        if (bVarF != null && !bVarF.c() && muVarB.X0() > muVarB.b1()) {
            this.e.a(dy.CENTER_CROP);
        }
        m8 m8VarG = new m8().a(ygVar).g(str);
        this.b.setAlpha(0.0f);
        a(m8VarG, this.d.l(), muVarB);
        this.e.a(new bh(muVarB, false));
    }

    private void a(m8 m8Var, View view, mu muVar) throws JSONException {
        Bitmap bitmapA;
        long jD = this.a.d();
        this.g = jD;
        this.h = jD > 5000 && j;
        xz xzVar = this.a;
        if (xzVar.p && ((bitmapA = e5.a(xzVar.a, xzVar.l)) != null || (bitmapA = e5.a(this.a.m)) != null)) {
            m8Var.a(bitmapA);
        }
        a(m8Var, this.g);
        this.b.addView(view, rl.k);
    }
}
