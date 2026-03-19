package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class au implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.d.b.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.webview.d.b.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.webview.d.b.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.webview.d.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.adTemplate = new AdTemplate();
        bVar.adTemplate.parseJson(jSONObject.optJSONObject("adTemplate"));
        bVar.bMv = jSONObject.optString("llsid");
        if (JSONObject.NULL.toString().equals(bVar.bMv)) {
            bVar.bMv = "";
        }
        bVar.extra = jSONObject.optString("extra");
        if (JSONObject.NULL.toString().equals(bVar.extra)) {
            bVar.extra = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.core.webview.d.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "adTemplate", bVar.adTemplate);
        if (bVar.bMv != null && !bVar.bMv.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "llsid", bVar.bMv);
        }
        if (bVar.extra != null && !bVar.extra.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "extra", bVar.extra);
        }
        return jSONObject;
    }
}
