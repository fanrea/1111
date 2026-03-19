package com.bytedance.adsdk.hc.hc.hc.d;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class e implements com.bytedance.adsdk.hc.hc.hc.d {
    private Number d;

    public e(String str) throws NumberFormatException {
        if (str.indexOf(46) >= 0) {
            Float fValueOf = Float.valueOf(str);
            this.d = fValueOf;
            if (Float.isInfinite(fValueOf.floatValue())) {
                this.d = Double.valueOf(str);
                return;
            }
            return;
        }
        try {
            this.d = Integer.valueOf(str);
        } catch (NumberFormatException unused) {
            this.d = Long.valueOf(str);
        }
    }

    @Override // com.bytedance.adsdk.hc.hc.hc.d
    public Object d(Map<String, JSONObject> map) {
        return this.d;
    }

    @Override // com.bytedance.adsdk.hc.hc.hc.d
    public com.bytedance.adsdk.hc.hc.c.u d() {
        return com.bytedance.adsdk.hc.hc.c.an.NUMBER;
    }

    @Override // com.bytedance.adsdk.hc.hc.hc.d
    public String hc() {
        return this.d.toString();
    }

    public String toString() {
        return hc();
    }
}
