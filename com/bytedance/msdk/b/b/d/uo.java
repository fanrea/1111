package com.bytedance.msdk.b.b.d;

import android.text.TextUtils;
import com.bytedance.msdk.b.b.d.d;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class uo implements d {
    @Override // com.bytedance.msdk.b.b.d.d
    public void d(d.InterfaceC0214d interfaceC0214d) {
        com.bytedance.msdk.b.an.d.hc hcVarD = interfaceC0214d.d();
        com.bytedance.msdk.api.d.hc hcVarRf = hcVarD.rf();
        String strD = com.bytedance.msdk.core.e.d.d(hcVarRf.mt());
        if (!TextUtils.isEmpty(strD)) {
            hcVarRf.c(2);
            com.bytedance.msdk.core.tc.hc hcVarD2 = com.bytedance.msdk.core.e.d.d(hcVarD.mq(), strD);
            if (hcVarD2 != null) {
                hcVarD.d(hcVarD2);
                com.bytedance.msdk.d.u.b.c("TTMediationSDK", com.bytedance.msdk.d.u.u.d(hcVarD2) + "测试工具加载广告........rit_id:" + hcVarRf.v() + " ,slot_id:" + strD);
            } else {
                com.bytedance.msdk.u.an.d(hcVarD.rf(), (String) null, !hcVarD.v(), hcVarD.ba().d, 81012, (Map<String, Object>) null);
                hcVarD.d(new com.bytedance.msdk.api.hc.d(81012, com.bytedance.msdk.api.d.d(81012)));
                return;
            }
        }
        interfaceC0214d.d(interfaceC0214d.d());
    }

    @Override // com.bytedance.msdk.b.b.d.d
    public void hc(d.InterfaceC0214d interfaceC0214d) {
        interfaceC0214d.d((String) null);
    }
}
