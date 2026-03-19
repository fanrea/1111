package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ag implements com.kwad.sdk.core.d<com.kwad.sdk.core.adlog.b.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.adlog.b.d) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.adlog.b.d) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.adlog.b.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.status = jSONObject.optInt("status");
        dVar.buF = jSONObject.optString("final_url");
        if (JSONObject.NULL.toString().equals(dVar.buF)) {
            dVar.buF = "";
        }
        dVar.buM = jSONObject.optInt("ad_action_type");
        dVar.bvV = jSONObject.optInt("cache_type", new Integer("0").intValue());
        dVar.retryCount = jSONObject.optInt("retry_count", new Integer("0").intValue());
    }

    private static JSONObject b(com.kwad.sdk.core.adlog.b.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (dVar.status != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "status", dVar.status);
        }
        if (dVar.buF != null && !dVar.buF.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "final_url", dVar.buF);
        }
        if (dVar.buM != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_action_type", dVar.buM);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "cache_type", dVar.bvV);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "retry_count", dVar.retryCount);
        return jSONObject;
    }
}
