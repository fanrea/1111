package com.kwad.sdk.i;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class d implements b {
    public List<e> cft;
    public long intervalTime;

    @Override // com.kwad.sdk.i.b
    public final JSONObject toJson() {
        return null;
    }

    d() {
    }

    public final long alo() {
        long j = this.intervalTime;
        if (j > 0) {
            return j;
        }
        return 5000L;
    }

    public final void parseJson(JSONObject jSONObject) {
        this.intervalTime = jSONObject.optInt("intervalTime", 5000);
        this.cft = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("configList");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                e eVar = new e();
                eVar.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                this.cft.add(eVar);
            }
        }
    }
}
