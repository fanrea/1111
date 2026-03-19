package com.style.widget.d;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.nativecpu.AbstractData;
import com.baidu.mobads.container.util.ab;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a extends c {
    private static final String bw = "LeftPicView";

    public a(Context context, AbstractData abstractData) {
        super(context, abstractData);
        if (x()) {
            n();
        } else {
            this.bd = 0;
            j();
            l();
            f();
        }
        a();
    }

    @Override // com.style.widget.d.c, com.style.widget.j
    public void r() {
        super.r();
        this.az = 0;
        if (x()) {
            this.aw = 0;
        }
    }

    @Override // com.style.widget.j
    public void s() {
        this.I = ab.b(this.w);
        double d = this.I;
        double d2 = this.a;
        Double.isNaN(d);
        this.J = (int) (d / d2);
        if (x()) {
            this.J += ab.a(this.w, this.R + this.V + this.U + this.D);
        }
        setLayoutParams(new RelativeLayout.LayoutParams(this.I, this.J));
        this.au = this.J - ab.a(this.w, this.av + this.aw);
        this.at = (this.au * this.x.getMainPicWidth()) / this.x.getMainPicHeight();
        if (x()) {
            this.au -= ab.a(this.w, ((this.R + this.D) + this.V) + this.U);
            this.at = (this.au * this.x.getMainPicWidth()) / this.x.getMainPicHeight();
        }
        addView(this.ar, z());
        addView(this.ah, A());
    }

    @Override // com.style.widget.j
    public void a(Object obj) {
        super.a(obj);
        t();
        if (!this.ax && !x()) {
            this.aw = 12;
        }
        this.ar.setLayoutParams(z());
        b(this.ar);
        this.ah.setLayoutParams(A());
        int iA = a((View) this.ah)[1] + ab.a(this.w, this.al + this.am);
        int iA2 = this.au + ab.a(this.w, this.av + this.aw);
        if (iA2 >= iA) {
            iA = iA2;
        }
        this.J = iA;
        if (x()) {
            this.J += ab.a(this.w, this.R + this.V + this.U + this.D);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.I, this.J);
        super.g();
        super.p();
        setLayoutParams(layoutParams);
        w();
        super.k();
        b();
    }

    public RelativeLayout.LayoutParams z() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.at, this.au);
        layoutParams.setMargins(ab.a(this.w, this.ay), ab.a(this.w, this.av), ab.a(this.w, this.az), ab.a(this.w, this.aw));
        return layoutParams;
    }

    public RelativeLayout.LayoutParams A() {
        this.ai = (this.I - this.at) - ab.a(this.w, ((this.ay + this.az) + this.aj) + this.ak);
        u();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.ai, -2);
        layoutParams.setMargins(ab.a(this.w, this.aj), ab.a(this.w, this.al), ab.a(this.w, this.ak), ab.a(this.w, this.am));
        layoutParams.addRule(1, 10002);
        this.F = this.ak;
        return layoutParams;
    }

    public void B() {
        this.J = this.au + a((View) this.ah)[1] + ab.a(this.w, this.av + this.aw + this.al + this.am) + (a((View) this.aO)[1] / 4);
        if (x()) {
            this.J += ab.a(this.w, this.R + this.V + this.U + this.D);
        }
        setLayoutParams(new RelativeLayout.LayoutParams(this.I, this.J));
    }
}
