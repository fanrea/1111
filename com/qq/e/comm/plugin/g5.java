package com.qq.e.comm.plugin;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.qq.e.comm.pi.ACTD;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class g5 implements oj {
    g5() {
    }

    @Override // com.qq.e.comm.plugin.oj
    public boolean a(l6 l6Var) {
        return l6Var.B.r() > 0;
    }

    private void b(l6 l6Var) throws JSONException {
        Context context = l6Var.v;
        Intent intent = new Intent();
        intent.setClassName(context, wx.a());
        intent.putExtra(ACTD.DELEGATE_NAME_KEY, wm.BLOCK_CLICK_ACTIVITY);
        intent.putExtra("appid", r1.d().b().a());
        intent.addFlags(268435456);
        try {
            context.startActivity(intent);
            a(l6Var, 1, null);
        } catch (Exception e) {
            a(l6Var, 100, e);
        }
    }

    @Override // com.qq.e.comm.plugin.oj
    public boolean a(l6 l6Var, qs qsVar) throws JSONException {
        int iU0;
        h4 h4Var = l6Var.B;
        if (l6Var.L == 2) {
            iU0 = h4Var.l();
        } else {
            iU0 = h4Var.U0();
        }
        boolean z = iU0 >= h4Var.r();
        if (z) {
            b(l6Var);
        } else {
            a(l6Var, 0, null);
        }
        return z;
    }

    private void a(l6 l6Var, int i, Exception exc) throws JSONException {
        qc qcVar = new qc(9120046);
        qcVar.c(i);
        qcVar.d(l6Var.L);
        ja jaVar = new ja();
        if (exc != null) {
            jaVar.a("ot", Log.getStackTraceString(exc));
        }
        h4 h4Var = l6Var.B;
        jaVar.a("mn", Integer.valueOf(h4Var.r()));
        jaVar.a("vc", Integer.valueOf(h4Var.T0()));
        jaVar.a("cn", Integer.valueOf(h4Var.U0()));
        qcVar.a(jaVar);
        qcVar.a(l6Var.x);
        b10.a(qcVar);
    }
}
