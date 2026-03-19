package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class jc implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.request.model.d) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.request.model.d) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.request.model.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.bGG = jSONObject.optString(com.baidu.mobads.container.adrequest.g.w);
        if (JSONObject.NULL.toString().equals(dVar.bGG)) {
            dVar.bGG = "";
        }
        dVar.bGH = jSONObject.optString("kMac");
        if (JSONObject.NULL.toString().equals(dVar.bGH)) {
            dVar.bGH = "";
        }
        dVar.bGI = jSONObject.optInt("connectionType");
        dVar.operatorType = jSONObject.optInt("operatorType");
    }

    private static JSONObject b(com.kwad.sdk.core.request.model.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (dVar.bGG != null && !dVar.bGG.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, com.baidu.mobads.container.adrequest.g.w, dVar.bGG);
        }
        if (dVar.bGH != null && !dVar.bGH.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "kMac", dVar.bGH);
        }
        if (dVar.bGI != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "connectionType", dVar.bGI);
        }
        if (dVar.operatorType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "operatorType", dVar.operatorType);
        }
        return jSONObject;
    }
}
