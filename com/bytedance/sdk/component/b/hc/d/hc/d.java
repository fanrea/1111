package com.bytedance.sdk.component.b.hc.d.hc;

import com.bytedance.sdk.component.b.hc.he;
import com.bytedance.sdk.component.b.hc.j;
import com.bytedance.sdk.component.b.hc.jh;
import com.bytedance.sdk.component.b.hc.v;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class d implements jh {
    public final v d;

    public d(v vVar) {
        this.d = vVar;
    }

    @Override // com.bytedance.sdk.component.b.hc.jh
    public j d(jh.d dVar) throws IOException {
        com.bytedance.sdk.component.b.hc.d.b.h hVar = (com.bytedance.sdk.component.b.hc.d.b.h) dVar;
        he heVarD = hVar.d();
        if (heVarD != null && heVarD.an != null) {
            heVarD.an.hc();
        }
        h hVarAn = hVar.an();
        com.bytedance.sdk.component.b.hc.d.b.b bVarD = hVarAn.d(this.d, dVar, !heVarD.hc().equals("GET"));
        b bVarHc = hVarAn.hc();
        if (heVarD != null && heVarD.an != null) {
            heVarD.an.b();
        }
        return hVar.d(heVarD, hVarAn, bVarD, bVarHc);
    }
}
