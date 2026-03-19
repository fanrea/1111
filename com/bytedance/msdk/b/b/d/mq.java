package com.bytedance.msdk.b.b.d;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.msdk.b.b.d.d;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class mq implements d {
    private final long d = 500;

    @Override // com.bytedance.msdk.b.b.d.d
    public void d(d.InterfaceC0214d interfaceC0214d) {
        com.bytedance.msdk.b.an.d.hc hcVarD = interfaceC0214d.d();
        if (hcVarD.mq() == null && hcVarD.rf().de() == 3 && !com.bytedance.msdk.core.hc.hc().zw() && hcVarD.s() != null) {
            com.bytedance.msdk.d.u.b.c("TTMediationSDK", "执行开启开屏兜底...............");
            d(interfaceC0214d, hcVarD, hcVarD.rf(), hcVarD.s());
        } else {
            interfaceC0214d.d(hcVarD);
        }
    }

    protected void d(final d.InterfaceC0214d interfaceC0214d, final com.bytedance.msdk.b.an.d.hc hcVar, com.bytedance.msdk.api.d.hc hcVar2, com.bytedance.msdk.api.c.mk mkVar) {
        if (mkVar != null && hcVar2 != null) {
            com.bytedance.msdk.d.u.b.c("TTMediationSDK", com.bytedance.msdk.d.u.u.d(hcVar2.v()) + "settings config.......AdUnitId = " + hcVar2.v() + "  开屏广告走了开发者自定义兜底方案   adnName:" + com.bytedance.msdk.hc.d.d(mkVar.d()));
        }
        com.bytedance.msdk.u.an.hc(hcVar2, -4);
        com.bytedance.msdk.d.u.b.c("TTMediationSDK", "开屏广告走了开发者自定义开屏兜底，数据为: getAdNetworkFlatFromId = " + mkVar.d() + " getAppId = " + mkVar.b() + " getAppKey = " + mkVar.c() + " getAdNetworkSlotId = " + mkVar.hc());
        if (mkVar == null || TextUtils.isEmpty(mkVar.hc()) || (TextUtils.isEmpty(mkVar.b()) && TextUtils.isEmpty(mkVar.c()))) {
            d(hcVar, 840027);
            hcVar.d(new com.bytedance.msdk.api.d(840027, com.bytedance.msdk.api.d.d(840027)));
            return;
        }
        int iD = mkVar.d();
        final String strD = com.bytedance.msdk.hc.d.d(iD);
        final String strHc = mkVar.hc();
        if (TextUtils.isEmpty(strD)) {
            d(hcVar, 840027);
            hcVar.d(new com.bytedance.msdk.api.d(840027, com.bytedance.msdk.api.d.d(840027)));
            return;
        }
        if (iD == 3) {
            new com.bytedance.msdk.an.d.u(mkVar).d(mkVar);
            Looper looperHc = com.bytedance.msdk.d.u.an.hc();
            if (looperHc != null) {
                new Handler(looperHc).postDelayed(new Runnable() { // from class: com.bytedance.msdk.b.b.d.mq.1
                    @Override // java.lang.Runnable
                    public void run() {
                        mq.this.d(interfaceC0214d, hcVar, strD, strHc);
                    }
                }, 500L);
                return;
            }
            return;
        }
        if (iD == 1) {
            com.bytedance.msdk.an.d.tc.hc(mkVar).d(mkVar, new com.bytedance.msdk.d.d.b() { // from class: com.bytedance.msdk.b.b.d.mq.2
                @Override // com.bytedance.msdk.d.d.b
                public void d() {
                    mq.this.d(interfaceC0214d, hcVar, strD, strHc);
                }

                @Override // com.bytedance.msdk.d.d.b
                public void d(com.bytedance.msdk.api.d dVar) {
                    mq.this.d(hcVar, 840027);
                    hcVar.d(new com.bytedance.msdk.api.d(840027, com.bytedance.msdk.api.d.d(840027)));
                }
            });
            return;
        }
        if (iD == 7) {
            new com.bytedance.msdk.an.d.h(mkVar).d(mkVar);
            d(interfaceC0214d, hcVar, strD, strHc);
            return;
        }
        if (iD == 6) {
            new com.bytedance.msdk.an.d.hc(mkVar).d(mkVar);
            d(interfaceC0214d, hcVar, strD, strHc);
            return;
        }
        if (iD == 4) {
            new com.bytedance.msdk.an.d.gb(mkVar).d(mkVar);
            d(interfaceC0214d, hcVar, strD, strHc);
        } else if (iD == 8) {
            new com.bytedance.msdk.an.d.mq(mkVar).d(mkVar);
            d(interfaceC0214d, hcVar, strD, strHc);
        } else if (iD == 9) {
            new com.bytedance.msdk.an.d.an(mkVar).d(mkVar, new com.bytedance.msdk.d.d.b() { // from class: com.bytedance.msdk.b.b.d.mq.3
                @Override // com.bytedance.msdk.d.d.b
                public void d() {
                    mq.this.d(interfaceC0214d, hcVar, strD, strHc);
                }

                @Override // com.bytedance.msdk.d.d.b
                public void d(com.bytedance.msdk.api.d dVar) {
                    mq.this.d(hcVar, 840027);
                    hcVar.d(new com.bytedance.msdk.api.d(840027, com.bytedance.msdk.api.d.d(840027)));
                }
            });
        } else {
            d(hcVar, 840027);
            hcVar.d(new com.bytedance.msdk.api.d(840027, com.bytedance.msdk.api.d.d(840027)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.bytedance.msdk.b.an.d.hc hcVar, int i) {
        com.bytedance.msdk.u.an.d(hcVar.rf(), (String) null, !hcVar.v(), hcVar.ba().d, i, (Map<String, Object>) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(d.InterfaceC0214d interfaceC0214d, com.bytedance.msdk.b.an.d.hc hcVar, String str, String str2) {
        hcVar.d(d(hcVar.rf().v(), str, str2));
        interfaceC0214d.d(hcVar);
    }

    @Override // com.bytedance.msdk.b.b.d.d
    public void hc(d.InterfaceC0214d interfaceC0214d) {
        interfaceC0214d.d((String) null);
    }

    private com.bytedance.msdk.core.tc.hc d(String str, String str2, String str3) {
        com.bytedance.msdk.core.tc.tc tcVarD = com.bytedance.msdk.core.h.b.d(str3, str2, -4, -4);
        if (tcVarD == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(tcVarD);
        com.bytedance.msdk.core.tc.hc hcVar = new com.bytedance.msdk.core.tc.hc();
        hcVar.c(str);
        hcVar.k(3);
        hcVar.c(400L);
        hcVar.u(2000L);
        hcVar.an(5000L);
        hcVar.h(com.alipay.sdk.m.u.b.a);
        hcVar.d(arrayList);
        return hcVar;
    }
}
