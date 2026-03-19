package com.bytedance.msdk.gb.hc;

import com.bytedance.msdk.core.tc.hc;
import com.bytedance.msdk.core.tc.tc;
import com.bytedance.msdk.core.u.hc.h;
import com.bytedance.msdk.d.u.b;
import com.bytedance.msdk.d.u.u;
import com.bytedance.msdk.u.an;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    public static boolean d(hc hcVar) {
        if (hcVar == null) {
            return false;
        }
        int iBa = hcVar.ba();
        Map<String, Integer> mapFu = com.bytedance.msdk.core.hc.hc().fu();
        if (mapFu == null) {
            return false;
        }
        Integer num = mapFu.get(String.valueOf(iBa));
        if (num != null) {
            return num.intValue() == 1;
        }
        Integer num2 = mapFu.get("-1");
        return num2 != null && num2.intValue() == 1;
    }

    public static boolean hc(hc hcVar) {
        if (hcVar == null) {
            return false;
        }
        int iBa = hcVar.ba();
        Map<String, Integer> mapXp = com.bytedance.msdk.core.hc.hc().xp();
        if (mapXp == null) {
            return false;
        }
        Integer num = mapXp.get(String.valueOf(iBa));
        if (num != null) {
            return num.intValue() == 1;
        }
        Integer num2 = mapXp.get("-1");
        return num2 != null && num2.intValue() == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0137 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0054 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean d(com.bytedance.msdk.b.an.d.hc r10, java.util.List<java.lang.Integer> r11, java.util.Map<java.lang.Integer, java.util.List<com.bytedance.msdk.core.tc.tc>> r12) {
        /*
            Method dump skipped, instructions count: 398
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.gb.hc.d.d(com.bytedance.msdk.b.an.d.hc, java.util.List, java.util.Map):boolean");
    }

    public static void d(com.bytedance.msdk.b.an.d.hc hcVar, tc tcVar, int i) {
        if (hcVar == null || hcVar.rf() == null || tcVar == null) {
            return;
        }
        com.bytedance.msdk.api.d.hc hcVarRf = hcVar.rf();
        String strV = hcVarRf.v();
        b.hc("TTMediationSDK", u.d(strV) + "----------总超时后尝试从复用池中查找广告：id:" + tcVar.yo() + "   loadSort:" + tcVar.np() + "  showSort:" + tcVar.yi() + "   adnName:" + tcVar.e());
        String strYo = tcVar.yo();
        if (tcVar.jh() && com.bytedance.msdk.core.u.d.d.d().c(strV, strYo, hcVarRf.u()) && com.bytedance.msdk.core.u.d.d.d().d(strYo, hcVarRf, true) == 3) {
            b.hc("TTMediationSDK", u.d(strV) + "----------可复用：id:" + tcVar.yo() + "   loadSort:" + tcVar.np() + "  showSort:" + tcVar.yi() + "   adnName:" + tcVar.e());
            com.bytedance.msdk.core.u.d.d.d().d(strV, strYo, tcVar, i);
            List<h> listD = com.bytedance.msdk.core.u.d.d.d().d(strYo, hcVarRf, hcVarRf.u());
            if (listD == null || listD.size() <= 0) {
                return;
            }
            int iGb = listD.get(0).d.gb(hcVarRf != null ? hcVarRf.d() : null);
            an.d(tcVar, hcVarRf, com.bytedance.msdk.core.u.d.d.d().d(strYo), !hcVar.v(), 4, i, 3, iGb, (com.bytedance.msdk.api.d) null, -1L, hcVar.hc(), true);
            ArrayList arrayList = new ArrayList();
            for (h hVar : listD) {
                hVar.d.tt(3);
                hVar.d.tc(iGb);
                hVar.d.b(hcVar.hc());
                hVar.d.hc(true);
                d(strV, hVar.d, strYo);
                arrayList.add(hVar.d);
            }
            an.d(listD.get(0).d, 0, "adn cache命中", 0L, hcVarRf, i, arrayList.size(), 4, (String) null, 0L, -1L);
            com.bytedance.msdk.b.gb.d.d(hcVar, arrayList, true);
            com.bytedance.msdk.hc.b bVar = arrayList.get(0);
            if (bVar.hr()) {
                hcVar.d(arrayList);
                for (com.bytedance.msdk.hc.b bVar2 : arrayList) {
                    b.d("TTMediationSDK", u.d(strV) + "复用池回溯成功...........回溯到了P层广告_当前P层广告缓存池数量：" + hcVar.h().size() + ",slotId：" + bVar2.ph() + ",广告类型：" + bVar2.nw() + ",loadSort=" + bVar2.ho() + ",showSort=" + bVar2.gu() + ",CPM=" + bVar2.kb());
                }
                return;
            }
            if (bVar.p()) {
                hcVar.d(arrayList);
                for (com.bytedance.msdk.hc.b bVar3 : arrayList) {
                    b.d("TTMediationSDK", u.d(strV) + "复用池回溯成功...........回溯到了普通层广告_当前普通广告缓存池数量：" + hcVar.gb().size() + ",slotId：" + bVar3.ph() + ",广告类型：" + bVar3.nw() + ",loadSort=" + bVar3.ho() + ",showSort=" + bVar3.gu() + ",CPM=" + bVar3.kb());
                }
            }
        }
    }

    private static void d(String str, com.bytedance.msdk.hc.b bVar, String str2) {
        tc tcVarU = com.bytedance.msdk.core.u.d.d.d().u(str, str2);
        if (bVar == null || tcVarU == null) {
            return;
        }
        bVar.w(tcVarU.np());
        bVar.cb(tcVarU.yi());
        bVar.e(tcVarU.k());
        bVar.e(tcVarU.rf());
        bVar.d(tcVarU.v());
        bVar.u(tcVarU.an());
    }
}
