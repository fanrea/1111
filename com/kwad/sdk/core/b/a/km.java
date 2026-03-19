package com.kwad.sdk.core.b.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class km implements com.kwad.sdk.core.d<com.kwad.sdk.n.b.a.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.n.b.a.c) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.n.b.a.c) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.n.b.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.bHR = jSONObject.optInt("func_ratio_count");
        cVar.ckq = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("func_values");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                com.kwad.sdk.n.b.a.b bVar = new com.kwad.sdk.n.b.a.b();
                bVar.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                cVar.ckq.add(bVar);
            }
        }
    }

    private static JSONObject b(com.kwad.sdk.n.b.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (cVar.bHR != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "func_ratio_count", cVar.bHR);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "func_values", cVar.ckq);
        return jSONObject;
    }
}
