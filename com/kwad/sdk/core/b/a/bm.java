package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class bm implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.b.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.commercial.b.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.commercial.b.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.commercial.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("status");
        bVar.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(bVar.url)) {
            bVar.url = "";
        }
        bVar.bub = jSONObject.optString("url_host");
        if (JSONObject.NULL.toString().equals(bVar.bub)) {
            bVar.bub = "";
        }
        bVar.buj = jSONObject.optString("url_path");
        if (JSONObject.NULL.toString().equals(bVar.buj)) {
            bVar.buj = "";
        }
        bVar.buk = jSONObject.optString("market_pkg_name");
        if (JSONObject.NULL.toString().equals(bVar.buk)) {
            bVar.buk = "";
        }
        bVar.bul = jSONObject.optInt("store_type");
        bVar.bum = jSONObject.optInt("launch_type");
    }

    private static JSONObject b(com.kwad.sdk.commercial.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.status != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "status", bVar.status);
        }
        if (bVar.url != null && !bVar.url.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url", bVar.url);
        }
        if (bVar.bub != null && !bVar.bub.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url_host", bVar.bub);
        }
        if (bVar.buj != null && !bVar.buj.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url_path", bVar.buj);
        }
        if (bVar.buk != null && !bVar.buk.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "market_pkg_name", bVar.buk);
        }
        if (bVar.bul != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "store_type", bVar.bul);
        }
        if (bVar.bum != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "launch_type", bVar.bum);
        }
        return jSONObject;
    }
}
