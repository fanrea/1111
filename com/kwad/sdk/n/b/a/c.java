package com.kwad.sdk.n.b.a;

import com.kwad.sdk.utils.aa;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class c extends com.kwad.sdk.commercial.c.a {
    public int bHR;
    public List<b> ckq;

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        for (b bVar : this.ckq) {
            aa.putValue(jSONObject, bVar.key, bVar.value);
        }
        aa.putValue(jSONObject, "func_ratio_count", this.bHR);
        JSONObject jSONObject2 = new JSONObject();
        aa.putValue(jSONObject2, "ranger", jSONObject);
        return jSONObject2;
    }
}
