package com.qq.e.comm.plugin;

import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class bh implements ah {
    private final h4 a;
    private int b;
    private boolean c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private final boolean i;
    private final StringBuilder j = new StringBuilder();
    private final StringBuilder m = new StringBuilder();
    private final int n = a(false);
    private final int o = a(true);

    public void a() {
    }

    public bh(h4 h4Var, boolean z) {
        this.a = h4Var;
        this.i = z;
    }

    private int a(boolean z) {
        int iA = xc.a(vx.a(z ? "evpbdw" : "evpbd", this.a.k()), this.a.y0(), -1, this.a.x0());
        if (iA == -1) {
            return xc.a(z ? "evpbdw" : "evpbd", this.a.y0(), -1, this.a.x0());
        }
        return iA;
    }

    private int a(int i) {
        if (i <= 0) {
            int i2 = this.d;
            if (i2 <= 8) {
                return i2;
            }
            return 100;
        }
        int i3 = i * 10;
        int i4 = this.d;
        if (i4 > 4) {
            i4 = 5;
        }
        return i3 + i4;
    }

    @Override // com.qq.e.comm.plugin.ah
    public boolean a(int i, j40 j40Var, float f) {
        this.h = this.b;
        if (!this.c) {
            this.d++;
            if (this.j.length() < 1) {
                this.j.append(r1.d().c().p().b());
            }
            if (this.m.length() < 1) {
                this.m.append(f);
                this.m.append("-");
            }
            if (f > 1.0f) {
                this.e++;
            }
            this.f = Math.max(this.f, i);
            this.g += i;
        }
        this.c = true;
        int i2 = this.b == 0 ? this.n : this.o;
        if (i2 == -1 || i < i2 * 1000) {
            return true;
        }
        a();
        return false;
    }

    @Override // com.qq.e.comm.plugin.ah
    public void a(int i, int i2, int i3) {
        if (this.b == 0) {
            a40.a(this.f, this.a.V0(), f5.a(this.a), i3);
        }
        this.b = i;
        this.c = false;
    }

    @Override // com.qq.e.comm.plugin.ah
    public void a(int i, int i2) throws JSONException {
        ja jaVar = new ja();
        int i3 = this.d;
        if (i3 > 0) {
            jaVar.a("bts", Integer.valueOf(i3));
            jaVar.a("spbt", Integer.valueOf(this.e));
            jaVar.a("bmd", Integer.valueOf(this.f));
            jaVar.a("btd", Integer.valueOf(this.g));
            jaVar.a("lbt", Integer.valueOf(this.h));
            jaVar.a("ilv", Integer.valueOf(i));
            jaVar.a("url", a30.c(this.a.V0()));
            jaVar.a("nets", this.j);
            jaVar.a("rate", this.m);
            jaVar.a("mdd", Integer.valueOf(this.i ? 1 : 0));
        }
        jaVar.a("pdn", Integer.valueOf(this.b));
        jaVar.a("vdn", Integer.valueOf(this.a.W0()));
        b10.a(1430000, f5.a(this.a), Integer.valueOf(a(i2)), Integer.valueOf(i), jaVar);
    }
}
