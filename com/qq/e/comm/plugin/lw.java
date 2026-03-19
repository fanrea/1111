package com.qq.e.comm.plugin;

import android.text.TextUtils;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class lw implements oj {
    private String a;
    private int b;

    /* compiled from: A */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            nw.a(lw.this.a, System.currentTimeMillis(), lw.this.b);
        }
    }

    @Override // com.qq.e.comm.plugin.oj
    public boolean a(l6 l6Var) {
        l3 l3VarO = l6Var.B.o();
        if (!l6Var.h || l3VarO == null) {
            return false;
        }
        String strE = l3VarO.e();
        this.a = strE;
        if (TextUtils.isEmpty(strE) || !l6Var.B.v1()) {
            return false;
        }
        int iA = xc.a("rndr", 0, l6Var.B);
        this.b = iA;
        return iA > 0;
    }

    @Override // com.qq.e.comm.plugin.oj
    public boolean a(l6 l6Var, qs qsVar) {
        qg.b.execute(new a());
        return false;
    }
}
