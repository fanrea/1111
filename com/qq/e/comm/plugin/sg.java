package com.qq.e.comm.plugin;

import com.bytedance.sdk.djx.core.log.ILogConst;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class sg {
    private String a;
    private JSONObject b;

    public sg(String str, JSONObject jSONObject) {
        this.a = str;
        this.b = jSONObject;
    }

    public String a() {
        StringBuilder sb = new StringBuilder("try {bridge.dispatch({'type':'");
        sb.append(this.a);
        sb.append("','param':");
        JSONObject jSONObject = this.b;
        sb.append(jSONObject == null ? ILogConst.CACHE_PLAY_REASON_NULL : JSONObject.quote(jSONObject.toString()));
        sb.append("})} catch(e) { console.log(e) }");
        return sb.toString();
    }
}
