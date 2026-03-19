package com.bytedance.msdk.b.b.d;

import android.util.Pair;
import com.bytedance.msdk.b.b.d.d;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an implements d {
    @Override // com.bytedance.msdk.b.b.d.d
    public void d(d.InterfaceC0214d interfaceC0214d) {
        com.bytedance.msdk.b.an.d.hc hcVarD = interfaceC0214d.d();
        String strV = hcVarD.rf().v();
        com.bytedance.msdk.core.tc.hc hcVarMq = hcVarD.mq();
        if (hcVarMq != null && hcVarMq.tc()) {
            if (!com.bytedance.msdk.core.gb.uo.d().gb(String.valueOf(strV))) {
                com.bytedance.msdk.d.u.b.hc("TMe", "广告位 请求触发次数拦截............");
                Pair<String, String> pairAn = com.bytedance.msdk.core.gb.uo.d().an(strV);
                com.bytedance.msdk.api.hc.hc hcVar = new com.bytedance.msdk.api.hc.hc(840041, com.bytedance.msdk.api.d.d(840041), pairAn != null ? (String) pairAn.second : "", pairAn != null ? (String) pairAn.first : "");
                d(hcVarD, hcVar.d);
                hcVarD.d(hcVar);
                return;
            }
            if (!com.bytedance.msdk.core.gb.uo.d().b(String.valueOf(strV)) && !hcVarD.v()) {
                com.bytedance.msdk.d.u.b.hc("TMe", "广告位 请求触发时间间隔拦截............");
                com.bytedance.msdk.core.gb.tt ttVarU = com.bytedance.msdk.core.gb.uo.d().u(String.valueOf(strV));
                com.bytedance.msdk.api.hc.b bVar = new com.bytedance.msdk.api.hc.b(840042, com.bytedance.msdk.api.d.d(840042), new StringBuilder().append(com.bytedance.msdk.core.gb.uo.d().d(strV)).toString(), ttVarU != null ? ttVarU.tc() : "");
                d(hcVarD, bVar.d);
                hcVarD.d(bVar);
                return;
            }
        }
        interfaceC0214d.d(interfaceC0214d.d());
    }

    private void d(com.bytedance.msdk.b.an.d.hc hcVar, int i) {
        com.bytedance.msdk.u.an.d(hcVar.rf(), (String) null, !hcVar.v(), hcVar.ba().d, i, (Map<String, Object>) null);
    }

    @Override // com.bytedance.msdk.b.b.d.d
    public void hc(d.InterfaceC0214d interfaceC0214d) {
        interfaceC0214d.d((String) null);
    }
}
