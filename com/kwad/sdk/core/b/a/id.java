package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class id implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.d.b.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.webview.d.b.d) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.webview.d.b.d) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.webview.d.b.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.aja = jSONObject.optInt("convertType");
        dVar.QX = jSONObject.optString("payload");
        if (JSONObject.NULL.toString().equals(dVar.QX)) {
            dVar.QX = "";
        }
        dVar.bMw = new com.kwad.sdk.core.webview.d.b.c();
        dVar.bMw.parseJson(jSONObject.optJSONObject("clickInfo"));
    }

    private static JSONObject b(com.kwad.sdk.core.webview.d.b.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (dVar.aja != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "convertType", dVar.aja);
        }
        if (dVar.QX != null && !dVar.QX.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "payload", dVar.QX);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "clickInfo", dVar.bMw);
        return jSONObject;
    }
}
