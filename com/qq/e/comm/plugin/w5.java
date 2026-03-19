package com.qq.e.comm.plugin;

import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class w5 implements lj {
    private static final AtomicInteger z = new AtomicInteger(0);
    private final h4 a;
    private final String b;
    private final f5 c;
    private final ja d;
    private final int e;
    private int f;
    private int g;
    private int h;
    private double i;
    private int j;
    private int k;
    private int l;
    private boolean m;
    private i40 n;
    private volatile int o;
    private int q;
    private int r;
    private int s;
    private double w;
    private boolean x;
    private boolean y;
    private String p = "";
    private int t = 0;
    private int u = 0;
    private int v = Integer.MIN_VALUE;

    private boolean l() {
        if (TextUtils.isEmpty(r1.d().c().j)) {
            return true;
        }
        if (TextUtils.isEmpty(r1.d().f().c("vdisde", ""))) {
            return true;
        }
        return !r1.contains(r0.toLowerCase());
    }

    public w5(h4 h4Var, i40 i40Var) throws JSONException {
        this.a = h4Var;
        this.n = i40Var;
        this.e = h4Var.W0() * 1000;
        this.b = h4Var.V0();
        this.c = f5.a(h4Var);
        ja jaVar = new ja();
        this.d = jaVar;
        jaVar.a("du", Integer.valueOf(h4Var.W0()));
        k();
    }

    private void k() {
        int i;
        int i2;
        this.g = a("sptime", 20000);
        boolean z2 = false;
        int iA = a("mptime", 0);
        this.h = iA;
        if (iA < this.g) {
            this.h = 0;
        }
        int i3 = this.h;
        if (i3 > 0 && (i2 = this.e) > 0) {
            double d = i3;
            double d2 = i2;
            Double.isNaN(d);
            Double.isNaN(d2);
            this.i = d / d2;
        }
        this.j = a("lbtime", 10000);
        this.k = a("btime", 10000);
        this.l = a("dnbtime", 2000);
        int iA2 = a("minvdu", 20000);
        int iA3 = a("delimit", 5);
        boolean zM = m();
        boolean zL = l();
        AtomicInteger atomicInteger = z;
        boolean z3 = iA3 <= atomicInteger.get();
        this.y = z3;
        if (zM && (i = this.e) > iA2 && !z3 && i > 0 && zL && v5.b(this.a)) {
            z2 = true;
        }
        this.m = z2;
        atomicInteger.get();
    }

    private boolean m() {
        int iA = a("vbufferAdType", 0);
        this.q = iA;
        if (iA <= 10000) {
            return iA == 1;
        }
        int iA2 = b.c().a(this.a.x0(), String.valueOf(this.q), 0);
        this.q = iA2;
        if (iA2 == 2) {
            this.p = "BASE";
            return false;
        }
        if (iA2 == 3) {
            this.p = "AA";
            return false;
        }
        if (iA2 != 4) {
            return false;
        }
        this.p = "AB";
        return true;
    }

    private void j() {
        if (this.o <= 0) {
            this.o = Math.min(this.g, this.e);
        }
    }

    private void a(double d) {
        this.w = d;
        if (d > 0.95d) {
            this.w = 1.0d;
        }
        this.n.a(this, this.w);
    }

    @Override // com.qq.e.comm.plugin.lj
    public double c() {
        if (this.m) {
            double d = this.g;
            double d2 = this.e;
            Double.isNaN(d);
            Double.isNaN(d2);
            this.w = Math.min(d / d2, 1.0d);
        } else {
            this.w = 1.0d;
        }
        return this.w;
    }

    @Override // com.qq.e.comm.plugin.lj
    public boolean f() {
        return this.m;
    }

    public void h() {
        this.m = false;
    }

    @Override // com.qq.e.comm.plugin.lj
    public void g() {
        if (n()) {
            b10.a(1406006, this.c, Integer.valueOf(this.q), Integer.valueOf(i()), this.d);
            if (this.y) {
                b10.a(1406012, this.c, Integer.valueOf(this.q), Integer.valueOf(i()), this.d);
            }
        }
    }

    @Override // com.qq.e.comm.plugin.lj
    public void e() {
        if (n()) {
            ja jaVar = new ja(this.d.a());
            jaVar.a("msg", this.e + "-" + this.g + "-" + this.j + "-" + this.k + "-" + this.l + "-" + this.o + "-" + this.f + "-" + this.v + "-" + this.r + "-" + this.s + "-" + this.u + "-" + this.t + "-" + this.m);
            b10.a(1406005, this.c, Integer.valueOf(this.q), Integer.valueOf(i()), jaVar);
            if (this.m) {
                b10.a(1406014, this.c, Integer.valueOf(this.f / 1000), Integer.valueOf(this.e / 1000), jaVar);
            }
        }
        if (!this.m || this.x) {
            return;
        }
        this.x = true;
        z.incrementAndGet();
    }

    @Override // com.qq.e.comm.plugin.lj
    public void d() {
        if (n()) {
            b10.a(1406013, this.c, Integer.valueOf(this.q), Integer.valueOf(i()), this.d);
        }
    }

    private int i() {
        return this.m ? 1 : 2;
    }

    private boolean n() {
        int i = this.q;
        return i > 1 && i <= 4;
    }

    private void q() {
        if (this.o > 0) {
            wt wtVarB = new wt(2020008).b((this.o * 100) / this.e).b(this.e);
            wtVarB.a(this.c);
            b10.a(wtVarB);
        }
    }

    private void o() {
        if (this.r > 0 || this.s > 0) {
            wt wtVarB = new wt(2020007).b(this.r).b(this.e);
            wtVarB.a(this.c);
            b10.a(wtVarB);
        }
    }

    private void r() {
        if (this.f > 0) {
            wt wtVarB = new wt(2020006).b((this.f * 100) / this.e).b(this.e);
            wtVarB.a(this.c);
            b10.a(wtVarB);
        }
    }

    private void p() {
        b10.a(1406009, this.c, Integer.valueOf(this.u), Integer.valueOf(this.a.Z0()), this.d);
        b10.a(1406015, this.c, Integer.valueOf(this.t), Integer.valueOf(this.a.Z0()), this.d);
    }

    private void b(mh mhVar) {
        if (this.o > 0) {
            ui.a().b(this.a.V0(), this.a.k().c, mhVar != null ? String.valueOf(mhVar.r().hashCode()) : "12345567");
        }
    }

    @Override // com.qq.e.comm.plugin.lj
    public void a(mh mhVar) {
        q();
        r();
        o();
        p();
        b(mhVar);
        this.m = false;
        this.n = null;
    }

    @Override // com.qq.e.comm.plugin.lj
    public String b() {
        String strValueOf;
        if (TextUtils.isEmpty(this.p)) {
            strValueOf = String.valueOf(this.m);
        } else {
            strValueOf = this.p + Config.replace + this.m;
        }
        return v5.a(strValueOf, this.a.k());
    }

    private double b(double d) {
        double dMin = Math.min(d, this.e);
        int i = this.h;
        return i > 0 ? Math.min(dMin, i) : dMin;
    }

    @Override // com.qq.e.comm.plugin.lj
    public h4 a() {
        return this.a;
    }

    @Override // com.qq.e.comm.plugin.lj
    public void a(int i, j40 j40Var) {
        if (this.n == null || !this.m) {
            return;
        }
        j();
        boolean z2 = j40Var == j40.UNINITIALIZED;
        if (z2) {
            this.s = Math.max(i, this.s);
        } else {
            this.r = Math.max(i, this.r);
        }
        double d = this.w;
        if (d < 1.0d) {
            if (this.h <= 0 || d < this.i) {
                int i2 = this.l;
                if (z2) {
                    i2 += 1000;
                }
                if (i <= i2 || fb.a().f(this.b)) {
                    return;
                }
                double dB = b(this.o + this.k);
                double d2 = this.e;
                Double.isNaN(d2);
                a(dB / d2);
                this.o = (int) dB;
                if (z2) {
                    this.t++;
                } else {
                    this.u++;
                }
            }
        }
    }

    @Override // com.qq.e.comm.plugin.lj
    public void a(int i, int i2, int i3) {
        if (this.n == null || !this.m || this.w >= this.i) {
            return;
        }
        j();
        this.f = i;
        if (this.o - i > this.j || this.w >= 1.0d) {
            return;
        }
        double dB = b(Math.max(this.o, i) + this.k);
        double d = this.e;
        Double.isNaN(d);
        a(dB / d);
        this.o = (int) dB;
    }

    private int a(String str, int i) {
        return r1.d().f().a(this.a, str, i);
    }
}
