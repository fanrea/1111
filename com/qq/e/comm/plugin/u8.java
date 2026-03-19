package com.qq.e.comm.plugin;

import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class u8 {
    private iz a;
    private iz b;
    private iz c;
    private iz d;
    private boolean e;
    private r8 f = new r8(0, 0, 0, 0);
    private boolean g;

    public int c() {
        iz izVar = this.a;
        if (izVar == null) {
            return 0;
        }
        return izVar.a(this.f);
    }

    public int d() {
        iz izVar = this.b;
        if (izVar == null) {
            return 0;
        }
        return izVar.a(this.f);
    }

    public int e() {
        iz izVar = this.c;
        if (izVar == null) {
            return 0;
        }
        return izVar.a(this.f);
    }

    public int b() {
        iz izVar = this.d;
        if (izVar == null) {
            return 0;
        }
        return izVar.a(this.f);
    }

    public boolean f() {
        return this.e;
    }

    public void a() {
        this.e = false;
    }

    public final boolean a(r8 r8Var) {
        this.f = r8Var;
        return this.g;
    }

    public boolean a(String str, cm cmVar) {
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "9":
                iz izVarC = cmVar.c(new JSONObject[0]);
                this.a = izVarC;
                this.g = this.g || izVarC.c() || this.a.d();
                break;
            case "10":
                iz izVarC2 = cmVar.c(new JSONObject[0]);
                this.b = izVarC2;
                this.g = this.g || izVarC2.c() || this.b.d();
                break;
            case "11":
                iz izVarC3 = cmVar.c(new JSONObject[0]);
                this.c = izVarC3;
                this.g = this.g || izVarC3.c() || this.c.d();
                break;
            case "12":
                iz izVarC4 = cmVar.c(new JSONObject[0]);
                this.d = izVarC4;
                this.g = this.g || izVarC4.c() || this.d.d();
                break;
            default:
                return false;
        }
        this.e = true;
        return true;
    }
}
