package com.bytedance.adsdk.hc.hc.hc.d;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class uo extends w {
    public uo() {
        super(com.bytedance.adsdk.hc.hc.c.b.MULTI);
    }

    @Override // com.bytedance.adsdk.hc.hc.hc.d
    public Object d(Map<String, JSONObject> map) {
        Object objD;
        Object objD2 = this.d.d(map);
        if (objD2 == null || (objD = this.hc.d(map)) == null) {
            return null;
        }
        return com.bytedance.adsdk.hc.hc.u.d.h.d((Number) objD2, (Number) objD);
    }
}
