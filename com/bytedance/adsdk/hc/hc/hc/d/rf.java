package com.bytedance.adsdk.hc.hc.hc.d;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class rf implements com.bytedance.adsdk.hc.hc.hc.hc {
    private com.bytedance.adsdk.hc.hc.hc.d b;
    private com.bytedance.adsdk.hc.hc.hc.d d;
    private com.bytedance.adsdk.hc.hc.hc.d hc;

    @Override // com.bytedance.adsdk.hc.hc.hc.d
    public Object d(Map<String, JSONObject> map) {
        Object objD = this.d.d(map);
        if (objD == null) {
            return null;
        }
        if (((Boolean) objD).booleanValue()) {
            return this.hc.d(map);
        }
        return this.b.d(map);
    }

    @Override // com.bytedance.adsdk.hc.hc.hc.d
    public com.bytedance.adsdk.hc.hc.c.u d() {
        return com.bytedance.adsdk.hc.hc.c.an.OPERATOR_RESULT;
    }

    @Override // com.bytedance.adsdk.hc.hc.hc.hc
    public void d(com.bytedance.adsdk.hc.hc.hc.d dVar) {
        this.d = dVar;
    }

    @Override // com.bytedance.adsdk.hc.hc.hc.hc
    public void hc(com.bytedance.adsdk.hc.hc.hc.d dVar) {
        this.hc = dVar;
    }

    @Override // com.bytedance.adsdk.hc.hc.hc.hc
    public void b(com.bytedance.adsdk.hc.hc.hc.d dVar) {
        this.b = dVar;
    }

    @Override // com.bytedance.adsdk.hc.hc.hc.d
    public String hc() {
        return this.d.hc() + "?" + this.hc.hc() + ":" + this.b.hc();
    }

    public String toString() {
        return hc();
    }
}
