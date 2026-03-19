package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ig implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.b.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.webview.b.a.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.webview.b.a.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.webview.b.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("Status");
        bVar.contentEncoding = jSONObject.optString("Content-Encoding");
        if (JSONObject.NULL.toString().equals(bVar.contentEncoding)) {
            bVar.contentEncoding = "";
        }
        bVar.bMd = jSONObject.optString("Cache-Control");
        if (JSONObject.NULL.toString().equals(bVar.bMd)) {
            bVar.bMd = "";
        }
        bVar.bMb = jSONObject.optString("Content-Type");
        if (JSONObject.NULL.toString().equals(bVar.bMb)) {
            bVar.bMb = "";
        }
        bVar.bMe = new com.kwad.sdk.core.webview.b.a.a();
        bVar.bMe.parseJson(jSONObject.optJSONObject("headers"));
    }

    private static JSONObject b(com.kwad.sdk.core.webview.b.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.status != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "Status", bVar.status);
        }
        if (bVar.contentEncoding != null && !bVar.contentEncoding.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "Content-Encoding", bVar.contentEncoding);
        }
        if (bVar.bMd != null && !bVar.bMd.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "Cache-Control", bVar.bMd);
        }
        if (bVar.bMb != null && !bVar.bMb.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "Content-Type", bVar.bMb);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "headers", bVar.bMe);
        return jSONObject;
    }
}
