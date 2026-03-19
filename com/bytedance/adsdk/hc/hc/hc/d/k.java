package com.bytedance.adsdk.hc.hc.hc.d;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class k extends w {
    public k() {
        super(com.bytedance.adsdk.hc.hc.c.b.NOT_EQ);
    }

    @Override // com.bytedance.adsdk.hc.hc.hc.d
    public Object d(Map<String, JSONObject> map) {
        Object objD = this.d.d(map);
        Object objD2 = this.hc.d(map);
        if (objD == null && objD2 == null) {
            return Boolean.FALSE;
        }
        if (objD == null && objD2 != null) {
            return Boolean.TRUE;
        }
        if (objD != null && objD2 == null) {
            return Boolean.TRUE;
        }
        if ((objD instanceof Number) && (objD2 instanceof Number)) {
            return Boolean.valueOf(!com.bytedance.adsdk.hc.hc.u.d.hc.d((Number) objD, (Number) objD2));
        }
        return Boolean.valueOf(!objD.equals(objD2));
    }
}
