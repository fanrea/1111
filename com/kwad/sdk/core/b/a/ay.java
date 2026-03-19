package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ay implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.j.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.commercial.j.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.commercial.j.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.commercial.j.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("status");
        bVar.buM = jSONObject.optInt("ad_action_type");
        bVar.buE = jSONObject.optString("origin_url");
        if (JSONObject.NULL.toString().equals(bVar.buE)) {
            bVar.buE = "";
        }
        bVar.buF = jSONObject.optString("final_url");
        if (JSONObject.NULL.toString().equals(bVar.buF)) {
            bVar.buF = "";
        }
        bVar.requestType = jSONObject.optInt("request_type");
    }

    private static JSONObject b(com.kwad.sdk.commercial.j.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.status != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "status", bVar.status);
        }
        if (bVar.buM != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_action_type", bVar.buM);
        }
        if (bVar.buE != null && !bVar.buE.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "origin_url", bVar.buE);
        }
        if (bVar.buF != null && !bVar.buF.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "final_url", bVar.buF);
        }
        if (bVar.requestType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "request_type", bVar.requestType);
        }
        return jSONObject;
    }
}
