package com.bytedance.msdk.b.b.hc;

import com.bytedance.msdk.b.b.hc.d;
import com.bytedance.msdk.core.tc.tc;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc implements d {
    @Override // com.bytedance.msdk.b.b.hc.d
    public void d(d.InterfaceC0215d interfaceC0215d) {
        com.bytedance.msdk.b.an.hc.hc hcVarD = interfaceC0215d.d();
        com.bytedance.msdk.b.an.d.hc hcVarHc = interfaceC0215d.hc();
        tc tcVarGb = hcVarD.gb();
        if (tcVarGb == null) {
            com.bytedance.msdk.api.d dVar = new com.bytedance.msdk.api.d(840040, com.bytedance.msdk.api.d.d(840040));
            com.bytedance.msdk.u.an.d(tcVarGb, hcVarHc.rf(), "", hcVarD.u(), 2, hcVarD.b(), hcVarD.h(), hcVarD.an(), dVar, -1L, hcVarHc.ba().u, false);
            com.bytedance.msdk.u.an.d(dVar, hcVarHc.rf(), tcVarGb, hcVarD.b(), hcVarD.h(), hcVarD.an(), "", 0L, (String) null, (String) null, (String) null, 0L);
            hcVarD.d(dVar, tcVarGb);
            return;
        }
        interfaceC0215d.d(this);
    }
}
