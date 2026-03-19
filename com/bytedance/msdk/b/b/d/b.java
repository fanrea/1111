package com.bytedance.msdk.b.b.d;

import com.bytedance.msdk.b.b.d.d;
import java.util.Map;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b implements d {
    @Override // com.bytedance.msdk.b.b.d.d
    public void d(d.InterfaceC0214d interfaceC0214d) throws JSONException {
        com.bytedance.msdk.b.an.d.hc hcVarD = interfaceC0214d.d();
        com.bytedance.msdk.api.d.hc hcVarRf = hcVarD.rf();
        com.bytedance.msdk.core.tc.hc hcVarMq = hcVarD.mq();
        com.bytedance.msdk.core.tc.hc hcVarD2 = com.bytedance.msdk.core.b.b.d(hcVarRf, hcVarMq);
        if (hcVarD2 != null) {
            if (hcVarRf.b() == 2 || hcVarRf.b() == 4 || hcVarRf.b() == 5) {
                com.bytedance.msdk.core.u.hc.c.d().d(hcVarRf.v(), hcVarRf);
            }
            hcVarMq = hcVarD2;
        }
        if (hcVarMq.y() == null || hcVarMq.y().size() == 0) {
            com.bytedance.msdk.u.an.d(hcVarRf, hcVarD.mq() != null ? hcVarD.mq().wl() : null, !hcVarD.v(), hcVarD.ba().d, 810085, (Map<String, Object>) null);
            hcVarD.d(new com.bytedance.msdk.api.d(810085, com.bytedance.msdk.api.d.d(810085)));
        } else {
            hcVarD.d(hcVarMq);
            interfaceC0214d.d(interfaceC0214d.d());
        }
    }

    @Override // com.bytedance.msdk.b.b.d.d
    public void hc(d.InterfaceC0214d interfaceC0214d) {
        interfaceC0214d.d((String) null);
    }
}
