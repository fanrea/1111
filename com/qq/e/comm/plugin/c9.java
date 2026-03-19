package com.qq.e.comm.plugin;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class c9 {
    public static void a(e2 e2Var, yq yqVar, int i, Exception exc) throws JSONException {
        qc qcVar = new qc(1190022);
        f5 f5Var = new f5();
        f5Var.a(e2Var);
        f5Var.d(yqVar.m());
        qcVar.a(f5Var);
        qcVar.d(i);
        if (exc != null) {
            ja jaVar = new ja();
            jaVar.a("ot", exc.getMessage());
            qcVar.a(jaVar);
        }
        b10.a(qcVar);
    }

    static void b(e2 e2Var, int i, String str, int i2) {
        qc qcVar = new qc(i2 == 0 ? 1190102 : 1190101);
        qcVar.c(i);
        qcVar.d(i2);
        f5 f5Var = new f5();
        f5Var.a(e2Var);
        f5Var.d(str);
        qcVar.a(f5Var);
        b10.a(qcVar);
    }

    static void a(e2 e2Var, int i, String str, int i2) {
        qc qcVar = new qc(i2 == 0 ? 1190104 : 1190103);
        qcVar.c(i);
        qcVar.d(i2);
        f5 f5Var = new f5();
        f5Var.a(e2Var);
        f5Var.d(str);
        qcVar.a(f5Var);
        b10.a(qcVar);
    }

    public static void a(int i, h4 h4Var, yq yqVar) {
        if (yqVar == null) {
            return;
        }
        boolean z = i != 0;
        int iN = yqVar.n();
        qc qcVar = new qc((iN == 1 || iN == 4) ? z ? 1190010 : 1190011 : z ? 1190020 : 1190021);
        f5 f5Var = new f5();
        f5Var.c(h4Var.y0());
        f5Var.a(h4Var.k());
        f5Var.d(yqVar.m());
        qcVar.a(f5Var);
        qcVar.c(iN);
        if (z) {
            qcVar.d(i);
        }
        b10.a(qcVar);
    }

    public static void a(e2 e2Var, String str, boolean z, boolean z2) throws JSONException {
        qc qcVar = new qc(1190105);
        f5 f5Var = new f5();
        f5Var.a(e2Var);
        f5Var.d(str);
        qcVar.a(f5Var);
        qcVar.c(z ? 2 : 1);
        qcVar.d(z2 ? 2 : 1);
        b10.a(qcVar);
    }

    public static void a(String str, int i, int i2, JSONObject jSONObject) throws JSONException {
        qc qcVar = new qc(1190204);
        f5 f5Var = new f5();
        f5Var.d(str);
        ja jaVar = new ja();
        jaVar.a("data", Integer.valueOf(i));
        if (jSONObject != null) {
            jaVar.a("msg", jSONObject.toString());
        }
        qcVar.a(f5Var);
        qcVar.d(i2);
        qcVar.a(jaVar);
        b10.a(qcVar);
    }

    static void a(e2 e2Var, int i) throws JSONException {
        qc qcVar = new qc(1190007);
        f5 f5Var = new f5();
        f5Var.a(e2Var);
        qcVar.a(f5Var);
        qcVar.c(3);
        qcVar.d(i);
        b10.a(qcVar);
    }

    public static void a(e2 e2Var, String str, int i) {
        qc qcVar = new qc(1190023);
        f5 f5Var = new f5();
        f5Var.a(e2Var);
        f5Var.d(str);
        qcVar.a(f5Var);
        qcVar.d(i);
        b10.a(qcVar);
    }
}
