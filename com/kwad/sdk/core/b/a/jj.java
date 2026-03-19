package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class jj implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.a.c) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.a.c) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.adQ = jSONObject.optString("originalID");
        if (JSONObject.NULL.toString().equals(cVar.adQ)) {
            cVar.adQ = "";
        }
        cVar.adR = jSONObject.optString("path");
        if (JSONObject.NULL.toString().equals(cVar.adR)) {
            cVar.adR = "";
        }
        cVar.adS = jSONObject.optInt("adCacheId");
        cVar.PD = jSONObject.optString("creativeId");
        if (JSONObject.NULL.toString().equals(cVar.PD)) {
            cVar.PD = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.webview.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (cVar.adQ != null && !cVar.adQ.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "originalID", cVar.adQ);
        }
        if (cVar.adR != null && !cVar.adR.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "path", cVar.adR);
        }
        if (cVar.adS != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adCacheId", cVar.adS);
        }
        if (cVar.PD != null && !cVar.PD.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creativeId", cVar.PD);
        }
        return jSONObject;
    }
}
