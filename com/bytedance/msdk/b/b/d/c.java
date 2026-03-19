package com.bytedance.msdk.b.b.d;

import com.bytedance.msdk.b.b.d.d;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c implements d {
    @Override // com.bytedance.msdk.b.b.d.d
    public void d(d.InterfaceC0214d interfaceC0214d) {
        com.bytedance.msdk.b.an.d.hc hcVarD = interfaceC0214d.d();
        hcVarD.uo().d(0);
        int iB = hcVarD.rf().b();
        List<com.bytedance.msdk.core.tc.tc> list = hcVarD.mq().yi().get(0);
        JSONObject jSONObject = new JSONObject();
        String strD = com.bytedance.msdk.core.uo.d.d().d(hcVarD.sy(), hcVarD.getContext(), hcVarD.rf(), list, hcVarD.mq(), iB, !hcVarD.v(), jSONObject);
        com.bytedance.msdk.u.an.d(hcVarD.rf(), jSONObject);
        hcVarD.d(strD);
    }

    @Override // com.bytedance.msdk.b.b.d.d
    public void hc(d.InterfaceC0214d interfaceC0214d) {
        interfaceC0214d.d((String) null);
    }
}
