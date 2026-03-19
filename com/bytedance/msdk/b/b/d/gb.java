package com.bytedance.msdk.b.b.d;

import com.bytedance.msdk.b.b.d.d;
import com.bytedance.msdk.core.u.hc.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class gb implements d {
    private int d = 0;

    @Override // com.bytedance.msdk.b.b.d.d
    public void d(d.InterfaceC0214d interfaceC0214d) {
        String strFs = interfaceC0214d.d().mq().fs();
        com.bytedance.msdk.api.d.hc hcVarRf = interfaceC0214d.d().rf();
        boolean zV = interfaceC0214d.d().v();
        if (com.bytedance.msdk.core.u.hc.c.d().b(strFs, hcVarRf.u())) {
            boolean z = com.bytedance.msdk.core.u.hc.c.d().d(strFs) == null;
            if (!zV && !z && d(strFs, hcVarRf, interfaceC0214d.d())) {
                interfaceC0214d.d().b(true);
                d(hcVarRf, strFs, interfaceC0214d.d().mq(), interfaceC0214d.d());
                return;
            }
            com.bytedance.msdk.core.u.hc.c.d().d(strFs, hcVarRf);
        }
        interfaceC0214d.d(interfaceC0214d.d());
    }

    private boolean d(String str, com.bytedance.msdk.api.d.hc hcVar, com.bytedance.msdk.b.an.d.hc hcVar2) {
        List<com.bytedance.msdk.core.u.hc.h> listC;
        com.bytedance.msdk.core.tc.hc hcVarMq = hcVar2.mq();
        if (com.bytedance.msdk.core.u.hc.c.d().d(str, hcVar, hcVarMq != null ? hcVarMq.wl() : null) && (listC = com.bytedance.msdk.core.u.hc.c.d().c(str)) != null && listC.size() > 0) {
            for (com.bytedance.msdk.core.u.hc.h hVar : listC) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(hVar.d);
                hcVar2.d(arrayList);
            }
            if (hcVar2.h().size() > 0 || hcVar2.tc().size() > 0 || hcVar2.gb().size() > 0) {
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK", com.bytedance.msdk.d.u.u.d(str) + "--==-- hit cache!!! -----");
                return true;
            }
        }
        com.bytedance.msdk.d.u.b.hc("TTMediationSDK", com.bytedance.msdk.d.u.u.d(str) + "--==-- not hit cache!!! -----");
        return false;
    }

    private void d(com.bytedance.msdk.api.d.hc hcVar, String str, com.bytedance.msdk.core.tc.hc hcVar2, final com.bytedance.msdk.b.an.d.hc hcVar3) {
        com.bytedance.msdk.api.d.hc hcVarHc = com.bytedance.msdk.core.u.hc.c.d().hc(str);
        if (hcVarHc != null) {
            hcVar.d(hcVarHc.d());
            hcVar.hc(hcVarHc.b());
        }
        com.bytedance.msdk.core.u.hc.c.d().d(str, hcVar);
        com.bytedance.msdk.u.an.d(hcVar3.rf(), hcVar2.wl(), !hcVar3.v(), hcVar3.ba().d, 0, (Map<String, Object>) null);
        com.bytedance.msdk.hc.b bVar = null;
        com.bytedance.msdk.b.gb.d.d(hcVar3, null, false);
        com.bytedance.msdk.core.u.hc.hc hcVarB = com.bytedance.msdk.core.u.hc.c.d().b(str);
        if (hcVarB != null) {
            hcVar3.d(hcVarB.c() != null ? hcVarB.c().ba() : null);
            hcVar3.d(hcVarB.b());
        }
        final int iHc = com.bytedance.msdk.core.u.hc.c.d().hc(str, hcVar.u());
        if (iHc == 2) {
            this.d = 1;
            hcVar3.d(1);
            hcVar3.c();
            return;
        }
        if (iHc == 3 || iHc == 4) {
            if (hcVar.gb() == 1) {
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "--==-- 激励再得情况，不进行预缓存补充，直接对外给出回调");
                this.d = 2;
                hcVar3.d(2);
                hcVar3.c();
                return;
            }
            long jU = com.bytedance.msdk.core.u.hc.c.u(str);
            long jCurrentTimeMillis = System.currentTimeMillis() - jU;
            if (jU != -1 && jCurrentTimeMillis < hcVar2.c()) {
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "--==-- 预缓存补充请求无需发起，时间间隔不够，interval：" + jCurrentTimeMillis + ", config interval: " + hcVar2.c());
                this.d = 3;
                hcVar3.d(3);
                hcVar3.c();
                return;
            }
            List<com.bytedance.msdk.hc.b> listJh = hcVar3.jh();
            if (listJh != null && listJh.size() > 0) {
                bVar = listJh.get(0);
            }
            com.bytedance.msdk.hc.b bVar2 = bVar;
            final double d = d(str, hcVar.de());
            if (bVar2 != null && !bVar2.hr() && bVar2.kb() < d) {
                com.bytedance.msdk.core.u.hc.c.d().d(hcVar3.getContext(), str, iHc, hcVar, bVar2, new c.b() { // from class: com.bytedance.msdk.b.b.d.gb.1
                    @Override // com.bytedance.msdk.core.u.hc.c.b
                    public void d(String str2, boolean z, int i, List<com.bytedance.msdk.hc.b> list) {
                        gb.this.d(str2, z, i, list, iHc, d, hcVar3);
                    }
                });
                return;
            }
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "--==-- 预缓存补充请求无需发起，已经命中最优");
            this.d = 4;
            hcVar3.d(4);
            hcVar3.c();
            return;
        }
        com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "--==-- 预缓存reqType错误：reqType = ".concat(String.valueOf(iHc)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, boolean z, int i, List<com.bytedance.msdk.hc.b> list, int i2, double d, com.bytedance.msdk.b.an.d.hc hcVar) {
        if (z) {
            if (i2 == 4) {
                com.bytedance.msdk.hc.b bVar = (list == null || list.size() <= 0) ? null : list.get(0);
                if (bVar != null && bVar.kb() >= d) {
                    this.d = 6;
                } else {
                    this.d = 7;
                }
            } else if (i2 == 3) {
                this.d = 5;
            }
        } else if (i == 10003) {
            this.d = 9;
        } else if (i == 10086) {
            this.d = 8;
        }
        hcVar.d(this.d);
        hcVar.d(list);
        com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "--==-- 预缓存补充请求结束，对外给出回调");
        hcVar.c();
    }

    private double d(String str, int i) {
        com.bytedance.msdk.core.tc.hc hcVarD = com.bytedance.msdk.h.d.b.d().d(str, i, 102);
        double dV = 0.0d;
        if (hcVarD == null) {
            return 0.0d;
        }
        for (com.bytedance.msdk.core.tc.tc tcVar : hcVarD.y()) {
            if (tcVar.mt() && tcVar.v() > dV) {
                dV = tcVar.v();
            }
        }
        return dV;
    }

    @Override // com.bytedance.msdk.b.b.d.d
    public void hc(d.InterfaceC0214d interfaceC0214d) {
        interfaceC0214d.d((String) null);
    }
}
