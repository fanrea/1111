package com.qq.e.comm.plugin;

import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class x8 extends s0 implements ql, ss {
    private int q;
    private uy r;
    private int s;

    @Override // com.qq.e.comm.plugin.ss
    public void a() {
    }

    @Override // com.qq.e.comm.plugin.s0
    protected void h() {
        super.h();
        int iC = this.s;
        if (iC <= 0) {
            iC = aq.c(this.a, this.f);
        }
        boolean zG = aq.g(this.a, this.f);
        int iJ = aq.j(this.a, this.f);
        int i = aq.i(this.a, this.f);
        int[] iArrH = aq.h(this.a, this.f);
        boolean zA = a(iJ, i, iArrH);
        if (zA) {
            this.q = aq.b(this.a, this.f);
        } else {
            this.q = aq.a(this.a, this.f);
        }
        uy uyVar = new uy(iC, this.q);
        uyVar.a(this);
        if (zA) {
            uyVar.a(zG);
            uyVar.f(iJ);
            uyVar.e(i);
            uyVar.a(iArrH);
            uyVar.b(true);
        }
        this.b = uyVar;
        this.r = uyVar;
        this.o = aq.b();
    }

    @Override // com.qq.e.comm.plugin.ql
    public void c(int i) {
        uy uyVar = this.r;
        if (uyVar != null) {
            uyVar.d(i);
        }
        this.s = i;
    }

    private boolean a(int i, int i2, int[] iArr) {
        int i3 = aq.i(this.a);
        if (aq.a(i3)) {
            return i3 == 1;
        }
        return (i > 0 && i2 > i) || (iArr != null && iArr.length > 0);
    }

    @Override // com.qq.e.comm.plugin.ss
    public void a(float[] fArr) throws JSONException {
        gk gkVar = this.g.get();
        if (gkVar != null && i()) {
            try {
                h8 h8VarG = g();
                h8VarG.a("motionDuration", Long.valueOf(System.currentTimeMillis() - this.n));
                h8VarG.c.put("shakeMaxAcceleration", fArr);
                gkVar.b(this.e, h8VarG);
            } catch (JSONException unused) {
            }
        }
    }

    @Override // com.qq.e.comm.plugin.ss
    public void a(float f) {
        if (f < this.o) {
            this.p = false;
        } else {
            if (this.p) {
                return;
            }
            this.p = true;
            this.n = System.currentTimeMillis();
            long j = this.n;
        }
    }
}
