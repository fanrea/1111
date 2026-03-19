package com.qq.e.comm.plugin;

import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class t8 implements rk {
    private float a;
    private iz b;
    private iz c;
    private iz d;
    private iz e;
    private iz f;
    private iz g;
    private iz i;
    private iz j;
    private iz k;
    private iz l;
    private boolean m;
    private boolean o;
    private int h = -1;
    private r8 n = new r8(0, 0, 0, 0);

    private int a(iz izVar) {
        if (izVar == null) {
            return 0;
        }
        int iB = (int) izVar.b();
        if (iB >= 0) {
            return Math.max(izVar.a(this.n), 0);
        }
        if (iB == -1 || iB == -2) {
            return iB;
        }
        return 0;
    }

    @Override // com.qq.e.comm.plugin.rk
    public final float e() {
        return this.a;
    }

    @Override // com.qq.e.comm.plugin.rk
    public final int g() {
        return a(this.b);
    }

    @Override // com.qq.e.comm.plugin.rk
    public final int h() {
        return a(this.c);
    }

    @Override // com.qq.e.comm.plugin.rk
    public final int m() {
        iz izVar = this.d;
        if (izVar == null) {
            return 0;
        }
        return izVar.a(this.n);
    }

    @Override // com.qq.e.comm.plugin.rk
    public final int q() {
        iz izVar = this.f;
        if (izVar == null) {
            return 0;
        }
        return izVar.a(this.n);
    }

    @Override // com.qq.e.comm.plugin.rk
    public final int k() {
        iz izVar = this.g;
        if (izVar == null) {
            return 0;
        }
        return izVar.a(this.n);
    }

    @Override // com.qq.e.comm.plugin.rk
    public final int n() {
        return this.h;
    }

    @Override // com.qq.e.comm.plugin.rk
    public final int c() {
        iz izVar = this.i;
        if (izVar == null) {
            return 0;
        }
        return izVar.a(this.n);
    }

    @Override // com.qq.e.comm.plugin.rk
    public final int p() {
        iz izVar = this.j;
        if (izVar == null) {
            return 0;
        }
        return izVar.a(this.n);
    }

    @Override // com.qq.e.comm.plugin.rk
    public final int b() {
        iz izVar = this.k;
        if (izVar == null) {
            return 0;
        }
        return izVar.a(this.n);
    }

    @Override // com.qq.e.comm.plugin.rk
    public final int j() {
        iz izVar = this.l;
        if (izVar == null) {
            return 0;
        }
        return izVar.a(this.n);
    }

    @Override // com.qq.e.comm.plugin.rk
    public int o() {
        return this.n.b();
    }

    @Override // com.qq.e.comm.plugin.rk
    public int l() {
        return this.n.a();
    }

    @Override // com.qq.e.comm.plugin.rk
    public r8 i() {
        return this.n;
    }

    @Override // com.qq.e.comm.plugin.rk
    public final boolean f() {
        return this.m;
    }

    @Override // com.qq.e.comm.plugin.rk
    public final void d() {
        this.m = false;
    }

    @Override // com.qq.e.comm.plugin.rk
    public final int a() {
        iz izVar = this.e;
        if (izVar == null) {
            return 0;
        }
        return izVar.a(this.n);
    }

    @Override // com.qq.e.comm.plugin.rk
    public final boolean a(r8 r8Var) {
        this.n = r8Var;
        return this.o;
    }

    @Override // com.qq.e.comm.plugin.rk
    public boolean a(String str, cm cmVar) {
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "3":
                iz izVarC = cmVar.c(new JSONObject[0]);
                this.b = izVarC;
                this.o = this.o || izVarC.c() || this.b.d();
                break;
            case "4":
                iz izVarC2 = cmVar.c(new JSONObject[0]);
                this.c = izVarC2;
                this.o = this.o || izVarC2.c() || this.c.d();
                break;
            case "5":
                iz izVarC3 = cmVar.c(new JSONObject[0]);
                this.d = izVarC3;
                this.o = this.o || izVarC3.c() || this.d.d();
                break;
            case "6":
                iz izVarC4 = cmVar.c(new JSONObject[0]);
                this.e = izVarC4;
                this.o = this.o || izVarC4.c() || this.e.d();
                break;
            case "7":
                iz izVarC5 = cmVar.c(new JSONObject[0]);
                this.f = izVarC5;
                this.o = this.o || izVarC5.c() || this.f.d();
                break;
            case "8":
                iz izVarC6 = cmVar.c(new JSONObject[0]);
                this.g = izVarC6;
                this.o = this.o || izVarC6.c() || this.g.d();
                break;
            case "13":
                this.h = v30.c(cmVar);
                break;
            case "46":
                this.a = cmVar.b(new JSONObject[0]);
                break;
            case "76":
                iz izVarC7 = cmVar.c(new JSONObject[0]);
                this.i = izVarC7;
                this.o = this.o || izVarC7.c() || this.i.d();
                break;
            case "77":
                iz izVarC8 = cmVar.c(new JSONObject[0]);
                this.j = izVarC8;
                this.o = this.o || izVarC8.c() || this.j.d();
                break;
            case "78":
                iz izVarC9 = cmVar.c(new JSONObject[0]);
                this.k = izVarC9;
                this.o = this.o || izVarC9.c() || this.k.d();
                break;
            case "79":
                iz izVarC10 = cmVar.c(new JSONObject[0]);
                this.l = izVarC10;
                this.o = this.o || izVarC10.c() || this.l.d();
                break;
            default:
                return false;
        }
        this.m = true;
        return true;
    }
}
