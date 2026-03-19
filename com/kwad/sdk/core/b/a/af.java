package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class af implements com.kwad.sdk.core.d<com.kwad.sdk.core.adlog.b.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.adlog.b.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.adlog.b.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.adlog.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("status");
        bVar.buM = jSONObject.optInt("ad_action_type");
        bVar.retryCount = jSONObject.optInt("retry_count");
        bVar.bvH = jSONObject.optInt("retry_error_code");
        bVar.bvI = jSONObject.optString("retry_error_msg");
        if (JSONObject.NULL.toString().equals(bVar.bvI)) {
            bVar.bvI = "";
        }
        bVar.bvS = jSONObject.optInt("cache_total_num");
        bVar.bvT = jSONObject.optInt("cache_num");
        bVar.bvU = jSONObject.optLong("cacheTimeMs");
        bVar.bvR = jSONObject.optBoolean("retry_only");
    }

    private static JSONObject b(com.kwad.sdk.core.adlog.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.status != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "status", bVar.status);
        }
        if (bVar.buM != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_action_type", bVar.buM);
        }
        if (bVar.retryCount != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "retry_count", bVar.retryCount);
        }
        if (bVar.bvH != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "retry_error_code", bVar.bvH);
        }
        if (bVar.bvI != null && !bVar.bvI.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "retry_error_msg", bVar.bvI);
        }
        if (bVar.bvS != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cache_total_num", bVar.bvS);
        }
        if (bVar.bvT != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cache_num", bVar.bvT);
        }
        if (bVar.bvU != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cacheTimeMs", bVar.bvU);
        }
        if (bVar.bvR) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "retry_only", bVar.bvR);
        }
        return jSONObject;
    }
}
