package com.bytedance.adsdk.hc.hc.hc.d;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class jh implements com.bytedance.adsdk.hc.hc.hc.d {
    private final String d;

    public jh(String str) {
        this.d = str;
    }

    @Override // com.bytedance.adsdk.hc.hc.hc.d
    public Object d(Map<String, JSONObject> map) {
        return this.d;
    }

    @Override // com.bytedance.adsdk.hc.hc.hc.d
    public com.bytedance.adsdk.hc.hc.c.u d() {
        return com.bytedance.adsdk.hc.hc.c.an.STRING;
    }

    @Override // com.bytedance.adsdk.hc.hc.hc.d
    public String hc() {
        return "'" + this.d + "'";
    }

    public String toString() {
        return hc();
    }
}
