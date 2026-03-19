package com.qq.e.comm.plugin;

import com.kuaishou.android.live.network.ApiStatus;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class h0 implements ij {
    private final hj a = new x2();

    protected abstract w2 a();

    protected abstract w2 b(int i);

    private String a(w2 w2Var, int i) {
        hj hjVar = this.a;
        return (hjVar == null || w2Var == null) ? "" : hjVar.a(w2Var, i);
    }

    @Override // com.qq.e.comm.plugin.ij
    public String a(int i) throws JSONException {
        w2 w2VarA = a(b(i), a());
        String strA = a(w2VarA, i);
        if (i == 2 && w2VarA != null && "1".equals(w2VarA.z)) {
            ja jaVar = new ja();
            jaVar.a("msg", strA);
            b10.a(9300004, null, 0, jaVar);
        }
        return strA;
    }

    private w2 a(w2 w2Var, w2 w2Var2) {
        hj hjVar = this.a;
        if (hjVar != null) {
            return hjVar.a(w2Var, w2Var2, String.valueOf(ApiStatus.SC_RESTRICT_FREQ_BY_KEY_CONFIG));
        }
        return null;
    }
}
