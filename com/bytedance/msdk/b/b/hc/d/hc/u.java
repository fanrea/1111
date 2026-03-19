package com.bytedance.msdk.b.b.hc.d.hc;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.z;
import com.bytedance.sdk.openadsdk.w.b.b.hc;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u extends hc {
    private com.bytedance.msdk.b.an.hc.hc b;
    private com.bytedance.msdk.api.d.hc hc;

    public u(com.bytedance.msdk.b.d.hc hcVar) {
        super(hcVar);
    }

    @Override // com.bytedance.msdk.b.b.hc.d.hc
    public void hc(Context context, com.bytedance.msdk.b.an.hc.hc hcVar, com.bytedance.msdk.api.d.hc hcVar2, Map<String, Object> map) {
        z zVarD;
        this.b = hcVar;
        this.hc = hcVar2;
        if (hcVar2 == null) {
            d(new com.bytedance.msdk.api.d("load ad fail adSlot is null"));
            return;
        }
        if (map == null || (zVarD = d(context.getApplicationContext())) == null) {
            return;
        }
        hc.d dVarD = com.bytedance.msdk.d.b.hc.d(this.hc, this.b, false);
        int iYi = this.hc.yi();
        int iHe = this.hc.he();
        if (iYi > 0 && iHe > 0) {
            dVarD.d(iYi).hc(iHe);
        }
        Object obj = map.get("tt_ad_origin_type");
        if (obj != null) {
            int iIntValue = ((Integer) obj).intValue();
            if (iIntValue == 1) {
                d(zVarD, dVarD);
                return;
            } else if (iIntValue == 2) {
                hc(zVarD, dVarD);
                return;
            } else {
                d(new com.bytedance.msdk.api.d("渲染类型错误"));
                return;
            }
        }
        d(new com.bytedance.msdk.api.d("渲染类型错误"));
    }

    private void d(z zVar, hc.d dVar) {
        if (this.hc.e() > 0.0f) {
            dVar.d(this.hc.k()).hc(this.hc.e());
        } else {
            dVar.d(this.hc.k()).hc(0.0f);
        }
        new c().d(this.b.d(), zVar, dVar.d(), this);
    }

    private void hc(z zVar, hc.d dVar) {
        new b().d(this.b.d(), zVar, dVar.d(), this);
    }
}
