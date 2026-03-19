package com.style.widget.c;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.a.d;
import com.baidu.mobads.container.util.ab;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class c extends a {
    public c(Context context, d dVar) {
        super(context, dVar);
    }

    @Override // com.style.widget.c.a, com.style.widget.j
    public void r() {
        super.r();
    }

    @Override // com.style.widget.j
    public void s() {
        super.s();
        this.I = ab.b(this.w);
        this.at = (this.I - ab.a(this.w, ((((this.ay + this.az) + this.aF) + this.aG) + this.aM) + this.aN)) / 3;
        this.au = (this.at * this.x.getMainPicHeight()) / this.x.getMainPicWidth();
        this.aB = this.at;
        this.aC = this.au;
        this.aI = this.at;
        this.aJ = this.au;
        addView(this.ah, z());
        addView(this.ar, A());
        addView(this.aA, B());
        addView(this.aH, C());
        D();
    }

    @Override // com.style.widget.j
    public void a(Object obj) {
        super.a(obj);
        t();
        if (!this.ax && !x()) {
            this.aw = 42;
        }
        this.ah.setLayoutParams(z());
        this.ar.setLayoutParams(A());
        b(this.ar);
        this.aA.setLayoutParams(B());
        b(this.aA);
        this.aH.setLayoutParams(C());
        b(this.aH);
        super.g();
        super.p();
        D();
        w();
        super.k();
        b();
    }

    private RelativeLayout.LayoutParams z() {
        this.ai = this.I - ab.a(this.w, this.aj + this.ak);
        u();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.ai, -2);
        layoutParams.setMargins(ab.a(this.w, this.aj), ab.a(this.w, this.al), ab.a(this.w, this.ak), ab.a(this.w, this.am));
        return layoutParams;
    }

    private RelativeLayout.LayoutParams A() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.at, this.au);
        layoutParams.setMargins(ab.a(this.w, this.ay), ab.a(this.w, this.av), ab.a(this.w, this.az), ab.a(this.w, this.aw));
        layoutParams.addRule(3, 10001);
        return layoutParams;
    }

    private RelativeLayout.LayoutParams B() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.aB, this.aC);
        layoutParams.setMargins(ab.a(this.w, this.aF), ab.a(this.w, this.aD), ab.a(this.w, this.aG), ab.a(this.w, this.aE));
        layoutParams.addRule(1, 10002);
        layoutParams.addRule(3, 10001);
        return layoutParams;
    }

    private RelativeLayout.LayoutParams C() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.aI, this.aJ);
        layoutParams.setMargins(ab.a(this.w, this.aM), ab.a(this.w, this.aK), ab.a(this.w, this.aN), ab.a(this.w, this.aL));
        layoutParams.addRule(1, 10003);
        layoutParams.addRule(3, 10001);
        this.F = this.aN;
        return layoutParams;
    }

    private void D() {
        this.I = ab.b(this.w);
        int iMax = Math.max(Math.max(this.au, this.aC), this.aJ);
        int iA = a((View) this.ah)[1] + ab.a(this.w, this.al + this.am);
        if (iMax == this.au) {
            this.J = this.au + iA + ab.a(this.w, this.av + this.aw) + (a((View) this.aO)[1] / 4);
        } else if (iMax == this.aC) {
            this.J = this.aC + iA + ab.a(this.w, this.aD + this.aE) + (a((View) this.aO)[1] / 4);
        } else if (iMax == this.aJ) {
            this.J = this.aJ + iA + ab.a(this.w, this.aK + this.aL) + (a((View) this.aO)[1] / 4);
        }
        if (x()) {
            this.J += ab.a(this.w, this.R + this.V + this.U + this.D);
        }
        setLayoutParams(new RelativeLayout.LayoutParams(this.I, this.J));
    }
}
