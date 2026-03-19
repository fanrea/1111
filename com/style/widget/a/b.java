package com.style.widget.a;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.util.ab;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class b extends a {
    public b(Context context, com.baidu.mobads.container.a.d dVar) {
        super(context, dVar);
    }

    @Override // com.style.widget.a.a, com.style.widget.j
    public void r() {
        super.r();
        this.al = 4;
        this.am = 42;
        this.aw = 0;
        if (x()) {
            this.am = 0;
        }
    }

    @Override // com.style.widget.j
    public void s() {
        super.s();
        this.I = ab.b(this.w);
        this.at = this.I - ab.a(this.w, this.ay + this.az);
        this.au = (this.at * this.x.getMainPicHeight()) / this.x.getMainPicWidth();
        addView(this.ar, A());
        addView(this.ah, B());
        z();
    }

    @Override // com.style.widget.j
    public void a(Object obj) {
        super.a(obj);
        t();
        if (!this.an && !x()) {
            this.am = 42;
        }
        this.ar.setLayoutParams(A());
        b(this.ar);
        this.ah.setLayoutParams(B());
        super.g();
        super.p();
        z();
        w();
        super.k();
        b();
    }

    private void z() {
        if (!x()) {
            this.J = this.au + a((View) this.ah)[1] + ab.a(this.w, this.av + this.aw + this.al + this.am) + (a((View) this.aO)[1] / 4);
        } else {
            this.J = this.au + a((View) this.ah)[1] + ab.a(this.w, this.av + this.aw + this.al + this.am) + (a((View) this.aO)[1] / 4) + ab.a(this.w, this.R + this.V + this.U + this.D);
        }
        setLayoutParams(new RelativeLayout.LayoutParams(this.I, this.J));
    }

    private RelativeLayout.LayoutParams A() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.at, this.au);
        layoutParams.setMargins(ab.a(this.w, this.ay), ab.a(this.w, this.av), ab.a(this.w, this.az), ab.a(this.w, this.aw));
        this.F = this.az;
        return layoutParams;
    }

    private RelativeLayout.LayoutParams B() {
        u();
        this.ai = this.I - ab.a(this.w, this.aj + this.ak);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.ai, -2);
        layoutParams.setMargins(ab.a(this.w, this.aj), ab.a(this.w, this.al), ab.a(this.w, this.ak), ab.a(this.w, this.am));
        layoutParams.addRule(3, 10002);
        return layoutParams;
    }
}
