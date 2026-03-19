package com.bytedance.adsdk.ugeno.u.hc;

import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.u.an;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c extends d {
    @Override // com.bytedance.adsdk.ugeno.u.hc.d
    public void hc() {
    }

    public c(com.bytedance.adsdk.ugeno.hc.b bVar, String str, an.d dVar) {
        super(bVar, str, dVar);
    }

    @Override // com.bytedance.adsdk.ugeno.u.hc.d
    public void d() {
        com.bytedance.adsdk.ugeno.hc.b bVarHc;
        com.bytedance.adsdk.ugeno.d.d dVarTc;
        if (this.an == null || this.an.size() <= 0) {
            return;
        }
        String str = this.an.get("name");
        if (TextUtils.isEmpty(str) || (bVarHc = this.b.hc(this.b)) == null || (dVarTc = bVarHc.an(str).tc(str)) == null) {
            return;
        }
        dVarTc.hc();
        dVarTc.d(new com.bytedance.adsdk.ugeno.d.hc() { // from class: com.bytedance.adsdk.ugeno.u.hc.c.1
            @Override // com.bytedance.adsdk.ugeno.d.hc
            public void d() {
            }

            @Override // com.bytedance.adsdk.ugeno.d.hc
            public void hc() {
                c.this.b();
            }
        });
    }
}
