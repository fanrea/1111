package com.baidu.mobads.container.adrequest;

import com.baidu.mobstat.forbes.Config;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class u implements k {
    private String a;
    private JSONObject b;
    private JSONArray c;
    private String d;

    public u(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.b = jSONObject;
            this.d = jSONObject.optString("qk", "");
            this.a = this.d + Config.replace + new Random().nextLong() + System.currentTimeMillis() + "|";
            this.c = jSONObject.optJSONArray("no_ad_lurl");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.baidu.mobads.container.adrequest.k
    public String a() {
        return this.a;
    }

    @Override // com.baidu.mobads.container.adrequest.k
    public JSONArray b() {
        return this.c;
    }

    @Override // com.baidu.mobads.container.adrequest.k
    public JSONObject c() {
        return this.b;
    }
}
