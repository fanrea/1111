package com.bytedance.msdk.an.d;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class h extends c {
    private String d;

    @Override // com.bytedance.msdk.an.d.b
    protected String hc() {
        return "ks";
    }

    public h() {
        super(null);
        com.bytedance.msdk.core.tc.d dVarH = h();
        if (dVarH != null) {
            this.d = dVarH.d();
        }
    }

    public h(com.bytedance.msdk.api.c.mk mkVar) {
        super(mkVar);
        if (mkVar != null) {
            this.d = mkVar.b();
        }
    }

    @Override // com.bytedance.msdk.an.d.b
    protected Map<String, Object> d() {
        HashMap map = new HashMap();
        map.put(com.alipay.sdk.m.k.b.D0, this.d);
        map.put("app_name", com.bytedance.msdk.core.d.mk().sy());
        return map;
    }

    @Override // com.bytedance.msdk.an.d.b
    protected String b() {
        if (!TextUtils.isEmpty(this.d)) {
            return "";
        }
        com.bytedance.msdk.core.tc.d dVarH = h();
        if (dVarH != null) {
            this.d = dVarH.d();
        }
        return TextUtils.isEmpty(this.d) ? "appId为空" : "";
    }
}
