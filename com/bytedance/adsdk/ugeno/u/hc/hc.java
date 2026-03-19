package com.bytedance.adsdk.ugeno.u.hc;

import com.bytedance.adsdk.ugeno.u.an;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc extends d {
    private List<com.bytedance.adsdk.ugeno.u.d.c> tt;

    public hc(com.bytedance.adsdk.ugeno.hc.b bVar, String str, an.d dVar) {
        super(bVar, str, dVar);
        this.tt = new CopyOnWriteArrayList();
    }

    @Override // com.bytedance.adsdk.ugeno.u.hc.d
    public void d() {
        com.bytedance.adsdk.ugeno.u.d.b bVarD;
        if (this.an == null || this.an.size() <= 0) {
            return;
        }
        String str = this.an.get("name");
        com.bytedance.adsdk.ugeno.u.d.d dVarBc = this.b.bc();
        if (dVarBc == null || (bVarD = dVarBc.d(str)) == null) {
            return;
        }
        bVarD.d(str);
    }
}
