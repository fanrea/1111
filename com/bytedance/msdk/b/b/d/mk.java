package com.bytedance.msdk.b.b.d;

import com.bytedance.msdk.b.b.d.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class mk implements d {
    @Override // com.bytedance.msdk.b.b.d.d
    public void d(d.InterfaceC0214d interfaceC0214d) {
        com.bytedance.msdk.b.an.d.hc hcVarD = interfaceC0214d.d();
        com.bytedance.msdk.api.d.hc hcVarRf = hcVarD.rf();
        hcVarRf.v();
        if (hcVarRf != null && hcVarRf.ra()) {
            String str = "TTMediationSDK";
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", com.bytedance.msdk.d.u.u.d(hcVarRf.v()) + "V2 公共缓存池广告请求......");
            String strWl = hcVarD.mq() != null ? hcVarD.mq().wl() : null;
            boolean z = !hcVarD.v();
            if (com.bytedance.msdk.core.hc.hc().an()) {
                List<com.bytedance.msdk.core.u.hc.h> listD = com.bytedance.msdk.b.u.d.d().d(hcVarRf);
                if (listD != null && !listD.isEmpty()) {
                    com.bytedance.msdk.u.an.d(listD.get(0).d, hcVarRf, hcVarD.mq(), 0L, hcVarD.ba().d, z, listD != null ? listD.size() : 0, hcVarD.ba().u, false);
                    int size = listD.size() - 1;
                    String strAn = null;
                    while (size >= 0) {
                        com.bytedance.msdk.core.u.hc.h hVar = listD.get(size);
                        com.bytedance.msdk.hc.b bVar = hVar.d;
                        bVar.d(hVar.an());
                        bVar.hc(hVar.c() != null ? hVar.c().d() : null);
                        if (size == 0) {
                            strAn = hVar.an();
                        }
                        String str2 = strAn;
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(bVar);
                        com.bytedance.msdk.b.u.d.d(hcVarRf, hVar.an());
                        com.bytedance.msdk.u.an.d(com.bytedance.msdk.core.hc.hc().d(hVar.an(), hcVarRf.de(), 102).an(bVar.ph()), hcVarRf, com.bytedance.msdk.core.u.d.d.d().d(bVar.ph()), true, 1, 0, 3, 3, null, -1L, false, false, hVar.c() != null ? hVar.c().d() : null);
                        hcVarD.d(arrayList);
                        com.bytedance.msdk.u.an.d(bVar, 0, "adn cache命中", 0L, hcVarRf, 0, arrayList.size(), 2, (String) null, 0L, -1L);
                        size--;
                        strAn = str2;
                        listD = listD;
                        str = str;
                    }
                    com.bytedance.msdk.b.u.d.d(hcVarRf, strAn);
                    com.bytedance.msdk.d.u.b.hc(str, com.bytedance.msdk.d.u.u.d(hcVarRf.v()) + "V2 resetAdLinkInfo......");
                    com.bytedance.msdk.u.an.d(hcVarRf, strWl, z, hcVarD.ba().d, 0, (Map<String, Object>) null);
                    hcVarD.c();
                    return;
                }
                com.bytedance.msdk.b.u.d.d(hcVarRf, "-1");
                com.bytedance.msdk.api.hc.d dVar = new com.bytedance.msdk.api.hc.d(41008, com.bytedance.msdk.api.d.d(41008));
                com.bytedance.msdk.u.an.d(hcVarRf, strWl, z, hcVarD.ba().d, dVar.d, (Map<String, Object>) null);
                hcVarD.d(dVar);
                return;
            }
            com.bytedance.msdk.b.u.d.d(hcVarRf, "-2");
            com.bytedance.msdk.api.hc.d dVar2 = new com.bytedance.msdk.api.hc.d(41007, com.bytedance.msdk.api.d.d(41007));
            com.bytedance.msdk.u.an.d(hcVarRf, strWl, z, hcVarD.ba().d, dVar2.d, (Map<String, Object>) null);
            hcVarD.d(dVar2);
            return;
        }
        interfaceC0214d.d(interfaceC0214d.d());
    }

    @Override // com.bytedance.msdk.b.b.d.d
    public void hc(d.InterfaceC0214d interfaceC0214d) {
        interfaceC0214d.d((String) null);
    }
}
