package com.bytedance.adsdk.hc;

import com.bytedance.adsdk.ugeno.c.d;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b implements com.bytedance.adsdk.ugeno.c.d {
    @Override // com.bytedance.adsdk.ugeno.c.d
    public d.InterfaceC0173d d(String str) {
        return d.d(str);
    }

    static class d implements d.InterfaceC0173d {
        private com.bytedance.adsdk.hc.hc.d d;
        private String hc;

        private d(String str) {
            this.hc = str;
            this.d = com.bytedance.adsdk.hc.hc.d.d(str);
        }

        public static d d(String str) {
            return new d(str);
        }

        @Override // com.bytedance.adsdk.ugeno.c.d.InterfaceC0173d
        public Object d(JSONObject jSONObject) {
            com.bytedance.adsdk.hc.hc.d dVar = this.d;
            if (dVar == null) {
                return this.hc;
            }
            Object objD = dVar.d(jSONObject);
            if (objD instanceof String) {
                return objD;
            }
            if (objD instanceof com.bytedance.adsdk.hc.hc.d.d) {
                return String.valueOf(mk.d((com.bytedance.adsdk.hc.hc.d.d) objD));
            }
            return String.valueOf(objD);
        }
    }
}
