package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ct implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.g> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.tachikoma.c.g) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.tachikoma.c.g) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.tachikoma.c.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        gVar.QX = jSONObject.optString("payload");
        if (JSONObject.NULL.toString().equals(gVar.QX)) {
            gVar.QX = "";
        }
        gVar.actionType = jSONObject.optInt("actionType");
        gVar.adS = jSONObject.optInt("adCacheId");
        gVar.PD = jSONObject.optString("creativeId");
        if (JSONObject.NULL.toString().equals(gVar.PD)) {
            gVar.PD = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.webview.tachikoma.c.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (gVar.QX != null && !gVar.QX.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "payload", gVar.QX);
        }
        if (gVar.actionType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "actionType", gVar.actionType);
        }
        if (gVar.adS != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adCacheId", gVar.adS);
        }
        if (gVar.PD != null && !gVar.PD.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creativeId", gVar.PD);
        }
        return jSONObject;
    }
}
