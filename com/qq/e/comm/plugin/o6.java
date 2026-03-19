package com.qq.e.comm.plugin;

import android.text.TextUtils;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class o6 {
    static void a(l6 l6Var, boolean z) {
        if (l6Var == null || l6Var.j == null) {
            return;
        }
        qg.b.submit(new a(l6Var, z));
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ l6 a;
        final /* synthetic */ boolean b;

        a(l6 l6Var, boolean z) {
            this.a = l6Var;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.a(this.a.j.booleanValue(), this.b, this.a.a().b, yw.a(this.a.B));
        }
    }

    static void a(Boolean bool, int i, l6 l6Var) {
        boolean zR1 = l6Var.B.r1();
        if (bool == null) {
            b10.a(4000001, l6Var.x, Integer.valueOf(zR1 ? 1 : 0), null, null);
        } else if (bool.booleanValue()) {
            b10.a(4000002, l6Var.x, Integer.valueOf(zR1 ? 1 : 0), Integer.valueOf(i), null);
        } else {
            b10.a(4000003, l6Var.x, Integer.valueOf(zR1 ? 1 : 0), null, null);
        }
    }

    static void a(int i, long j, l6 l6Var) {
        if (j <= 0) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - j;
        wt wtVar = new wt(i);
        wtVar.a(l6Var.x);
        wtVar.b(jCurrentTimeMillis);
        b10.a(wtVar);
    }

    static void a(boolean z, int i, l6 l6Var) {
        if (z) {
            b10.b(1101002, l6Var.x, Integer.valueOf(i));
            return;
        }
        b10.a(1101001, l6Var.x);
        h4 h4Var = l6Var.B;
        if (h4Var != null && h4Var.k1() && h4Var.z1()) {
            b10.a(1101008, l6Var.x, Integer.valueOf(h4Var.I()));
        }
    }

    static void a(int i, int i2, l6 l6Var, String str) throws JSONException {
        ja jaVar;
        if (TextUtils.isEmpty(str)) {
            jaVar = null;
        } else {
            jaVar = new ja();
            jaVar.a("msg", str);
        }
        b10.a(1101018, l6Var.x, Integer.valueOf(i2), Integer.valueOf(i), jaVar);
    }

    static void a(l6 l6Var) throws JSONException {
        a7 a7Var;
        qc qcVar = new qc(4000000);
        qcVar.a(l6Var.x);
        qcVar.c(l6Var.C);
        qcVar.d(l6Var.q.intValue());
        ja jaVar = new ja();
        jaVar.a("data", Integer.valueOf(l6Var.B.J()));
        jaVar.a("ir", Integer.valueOf(l6Var.I));
        if (z6.a && (a7Var = l6Var.D) != null) {
            jn jnVar = new jn();
            jnVar.a("id", a7Var.a());
            jnVar.a("ver", a7Var.b());
            jaVar.a("complexCompo", jnVar.toString());
        }
        qcVar.a(jaVar);
        b10.a(qcVar);
    }
}
