package com.bytedance.adsdk.ugeno.u.b;

import android.content.Context;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b extends hc implements com.bytedance.adsdk.ugeno.u.d.c {
    private com.bytedance.adsdk.ugeno.u.d.b mk;

    public b(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.u.b.hc
    public boolean d(Object... objArr) {
        com.bytedance.adsdk.ugeno.u.d.d dVarBc = this.hc.bc();
        if (dVarBc == null) {
            return false;
        }
        com.bytedance.adsdk.ugeno.u.d.b bVarD = dVarBc.d(this.an);
        this.mk = bVarD;
        if (bVarD != null) {
            bVarD.d(this);
            return false;
        }
        dVarBc.d(this.an, new com.bytedance.adsdk.ugeno.u.d.hc());
        return false;
    }

    @Override // com.bytedance.adsdk.ugeno.u.d.c
    public void d(String str) {
        this.d.d(this.hc, this.an, this.b.hc());
    }
}
