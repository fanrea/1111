package com.style.widget.e;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.container.nativecpu.AbstractData;
import com.baidu.mobads.container.util.ab;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class z extends com.style.widget.j {
    public z(Context context, AbstractData abstractData) {
        super(context, abstractData);
        q();
        r();
        e();
        h();
        s();
        if (x()) {
            n();
        } else {
            j();
            l();
            f();
        }
        a();
    }

    @Override // com.style.widget.j
    public void r() {
        if (this.x == null) {
            return;
        }
        this.ah = new TextView(this.w);
        this.ah.setId(10001);
        this.ah.setMaxLines(1);
        this.ah.setEllipsize(TextUtils.TruncateAt.END);
        this.ah.setTextColor(this.aX);
        this.ah.setText(this.x.getTitle());
        this.as = new a(this.w);
        a(this.as, 10007);
        this.aw = 42;
        if (x()) {
            this.aw = 0;
        }
    }

    @Override // com.style.widget.j
    public void s() {
        super.s();
        this.I = ab.b(this.w);
        addView(this.ah, B());
        this.at = this.I - ab.a(this.w, this.ay + this.az);
        int mainPicHeight = this.x.getMainPicHeight();
        int mainPicWidth = this.x.getMainPicWidth();
        if (mainPicHeight == 0 || mainPicWidth == 0) {
            mainPicHeight = 9;
            mainPicWidth = 16;
        }
        this.au = ((this.at * mainPicHeight) / mainPicWidth) + (a((View) this.aO)[1] / 4);
        addView(this.as, A());
        z();
    }

    @Override // com.style.widget.j
    public void a(Object obj) {
        super.a(obj);
        t();
        if (!this.ax && !x()) {
            this.aw = 42;
        }
        this.ah.setLayoutParams(B());
        this.as.setLayoutParams(A());
        b(this.as);
        super.g();
        super.p();
        z();
        w();
        super.k();
        b();
        if (this.as != null) {
            this.as.c(this.L);
            this.as.h(this.M);
        }
    }

    private RelativeLayout.LayoutParams A() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.at, this.au);
        layoutParams.setMargins(ab.a(this.w, this.ay), ab.a(this.w, this.av), ab.a(this.w, this.az), ab.a(this.w, this.aw));
        layoutParams.addRule(3, 10001);
        this.F = this.az;
        return layoutParams;
    }

    private RelativeLayout.LayoutParams B() {
        u();
        this.ai = this.I - ab.a(this.w, this.aj + this.ak);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.ai, -2);
        layoutParams.setMargins(ab.a(this.w, this.aj), ab.a(this.w, this.al), ab.a(this.w, this.ak), ab.a(this.w, this.am));
        return layoutParams;
    }

    public void z() {
        this.J = this.au + a((View) this.ah)[1] + ab.a(this.w, this.av + this.aw + this.al + this.am) + (a((View) this.aO)[1] / 4);
        if (x()) {
            this.J += ab.a(this.w, this.R + this.V + this.U + this.D);
        }
        setLayoutParams(new RelativeLayout.LayoutParams(this.I, this.J));
    }
}
