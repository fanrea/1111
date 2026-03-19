package com.bytedance.adsdk.hc.hc.hc.d;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class gb extends w {
    public gb() {
        super(com.bytedance.adsdk.hc.hc.c.b.LT_EQ);
    }

    @Override // com.bytedance.adsdk.hc.hc.hc.d
    public Object d(Map<String, JSONObject> map) {
        Object objD;
        if (this.d.d(map) == null || (objD = this.hc.d(map)) == null) {
            return null;
        }
        return Boolean.valueOf(!((Boolean) com.bytedance.adsdk.hc.hc.u.d.b.d(r0, (Number) objD)).booleanValue());
    }
}
