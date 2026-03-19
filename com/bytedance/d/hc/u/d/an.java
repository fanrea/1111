package com.bytedance.d.hc.u.d;

import android.content.Context;
import android.content.pm.PackageManager;
import com.bytedance.d.hc.gb;
import org.json.JSONException;

@Deprecated
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class an extends b {
    an(Context context, hc hcVar, c cVar) {
        super(com.bytedance.d.hc.b.CUSTOM_JAVA, context, hcVar, cVar);
    }

    @Override // com.bytedance.d.hc.u.d.b
    public com.bytedance.d.hc.b.d d(com.bytedance.d.hc.b.d dVar) throws JSONException, PackageManager.NameNotFoundException {
        com.bytedance.d.hc.b.d dVarD = super.d(dVar);
        com.bytedance.d.hc.b.hc hcVarD = com.bytedance.d.hc.b.hc.d(this.hc);
        hcVarD.d(gb.d().d());
        hcVarD.d(gb.b().d());
        hcVarD.hc(this.b.b());
        dVarD.d(hcVarD);
        return dVarD;
    }
}
