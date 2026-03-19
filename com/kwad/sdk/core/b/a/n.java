package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class n implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.d.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.commercial.d.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.commercial.d.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.commercial.d.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.methodName = jSONObject.optString("method_name");
        if (JSONObject.NULL.toString().equals(bVar.methodName)) {
            bVar.methodName = "";
        }
        bVar.bus = jSONObject.optBoolean("is_convert");
        bVar.adNum = jSONObject.optInt("ad_num");
        bVar.but = jSONObject.optBoolean("is_api_native");
        bVar.buu = jSONObject.optString("ad_request_type");
        if (JSONObject.NULL.toString().equals(bVar.buu)) {
            bVar.buu = "";
        }
        bVar.adSource = jSONObject.optString("ad_require_source");
        if (JSONObject.NULL.toString().equals(bVar.adSource)) {
            bVar.adSource = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.commercial.d.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.methodName != null && !bVar.methodName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "method_name", bVar.methodName);
        }
        if (bVar.bus) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "is_convert", bVar.bus);
        }
        if (bVar.adNum != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_num", bVar.adNum);
        }
        if (bVar.but) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "is_api_native", bVar.but);
        }
        if (bVar.buu != null && !bVar.buu.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_request_type", bVar.buu);
        }
        if (bVar.adSource != null && !bVar.adSource.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_require_source", bVar.adSource);
        }
        return jSONObject;
    }
}
