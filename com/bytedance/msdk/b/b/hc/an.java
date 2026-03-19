package com.bytedance.msdk.b.b.hc;

import com.bytedance.msdk.b.b.hc.d;
import com.bytedance.msdk.core.tc.tc;
import com.bytedance.msdk.core.u.hc.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an implements d {
    @Override // com.bytedance.msdk.b.b.hc.d
    public void d(d.InterfaceC0215d interfaceC0215d) {
        List<h> listD;
        tc tcVarGb = interfaceC0215d.d().gb();
        com.bytedance.msdk.api.d.hc hcVarRf = interfaceC0215d.hc().rf();
        if (tcVarGb != null) {
            String strYo = tcVarGb.yo();
            if (tcVarGb.jh() && com.bytedance.msdk.core.u.d.d.d().c(hcVarRf.v(), strYo, hcVarRf.u())) {
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "--==-- 广告复用，模式：" + com.bytedance.msdk.core.u.d.d.d().u(hcVarRf.v(), strYo, hcVarRf.u()));
                int iD = com.bytedance.msdk.core.u.d.d.d().d(strYo, hcVarRf, true);
                interfaceC0215d.d().b(iD);
                if (iD == 3) {
                    interfaceC0215d.d().d(2);
                    if (d(interfaceC0215d.hc(), interfaceC0215d.d(), hcVarRf, strYo, tcVarGb, 2)) {
                        return;
                    }
                } else if (iD == 2 && (listD = com.bytedance.msdk.core.u.d.d.d().d(strYo, hcVarRf, hcVarRf.u())) != null && listD.size() > 0) {
                    interfaceC0215d.d().hc(listD.get(0).d.gb(hcVarRf.d()));
                }
            }
        }
        interfaceC0215d.d(this);
    }

    private boolean d(com.bytedance.msdk.b.an.d.hc hcVar, com.bytedance.msdk.b.an.hc.hc hcVar2, com.bytedance.msdk.api.d.hc hcVar3, String str, tc tcVar, int i) {
        com.bytedance.msdk.core.u.d.d.d().d(hcVar3.v(), str, tcVar, i);
        List<h> listD = com.bytedance.msdk.core.u.d.d.d().d(str, hcVar3, hcVar3.u());
        if (listD == null || listD.size() <= 0) {
            return false;
        }
        int iGb = listD.get(0).d.gb(hcVar3.d());
        com.bytedance.msdk.u.an.d(tcVar, hcVar3, com.bytedance.msdk.core.u.d.d.d().d(str), !hcVar.v(), 1, i, 3, iGb, (com.bytedance.msdk.api.d) null, -1L, false, false);
        ArrayList arrayList = new ArrayList();
        for (h hVar : listD) {
            hVar.d.tt(3);
            hVar.d.tc(iGb);
            hVar.d.b(false);
            hVar.d.hc(false);
            com.bytedance.msdk.b.gb.u.d(hVar.d, hcVar3.v(), str);
            arrayList.add(hVar.d);
        }
        com.bytedance.msdk.u.an.d(listD.get(0).d, 0, "adn cache命中", 0L, hcVar3, i, arrayList.size(), 2, (String) null, 0L, -1L);
        hcVar2.d(arrayList, tcVar);
        return true;
    }
}
