package com.bytedance.adsdk.hc.hc.hc.d;

import com.bytedance.sdk.djx.core.log.ILogConst;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class h implements com.bytedance.adsdk.hc.hc.hc.d {
    private final Object d;

    public h(String str) {
        if (str.equalsIgnoreCase("true")) {
            this.d = Boolean.TRUE;
        } else if (str.equalsIgnoreCase("false")) {
            this.d = Boolean.FALSE;
        } else {
            if (str.equalsIgnoreCase(ILogConst.CACHE_PLAY_REASON_NULL)) {
                this.d = null;
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    @Override // com.bytedance.adsdk.hc.hc.hc.d
    public Object d(Map<String, JSONObject> map) {
        return this.d;
    }

    @Override // com.bytedance.adsdk.hc.hc.hc.d
    public com.bytedance.adsdk.hc.hc.c.u d() {
        return com.bytedance.adsdk.hc.hc.c.an.CONSTANT;
    }

    public String toString() {
        return "KeywordNode [keywordValue=" + this.d + "]";
    }

    @Override // com.bytedance.adsdk.hc.hc.hc.d
    public String hc() {
        Object obj = this.d;
        return obj != null ? obj.toString() : "NULL";
    }
}
