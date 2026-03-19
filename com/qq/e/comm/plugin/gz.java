package com.qq.e.comm.plugin;

import android.text.TextUtils;
import com.qq.e.comm.plugin.ad;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class gz extends hz {
    private final f5 a;
    private final h4 b;

    public gz(ad.a aVar, h4 h4Var, f5 f5Var) {
        this.a = f5Var;
        this.b = h4Var;
    }

    @Override // com.qq.e.comm.plugin.hz
    public void a(aw awVar, int i, Exception exc) throws JSONException {
        vv.b(this.b, awVar, i);
        a(i, exc);
    }

    @Override // com.qq.e.comm.plugin.qr
    public void a(aw awVar, hw hwVar) throws Throwable {
        String strC;
        int iA = hwVar == null ? 0 : hwVar.a();
        if (iA != 200 && iA != 204) {
            vv.b(this.b, awVar, iA);
            a(iA, (Exception) null);
        } else {
            String strF = this.b.F();
            if (!TextUtils.isEmpty(strF)) {
                zt.a(strF);
            }
            vv.i();
            a();
        }
        if (iA != 200) {
            strC = iA != 204 ? "res == null,no errorMessage" : "http code 204,no content";
        } else {
            try {
                strC = hwVar.c();
            } catch (Exception e) {
                e.toString();
                strC = "";
            }
        }
        p20.a("#exposureRes#", strC, new Object[0]);
        tb.a(4, this.b);
    }

    private void a(int i, Exception exc) throws JSONException {
        this.b.e(i);
        ja jaVar = new ja();
        if (exc != null) {
            jaVar.a("msg", exc.getMessage());
        }
        b10.b(1402002, this.a, Integer.valueOf(i), jaVar);
    }

    private void a() {
        this.b.G1();
        b10.a(1402001, this.a);
    }
}
