package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ho implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.k> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.tachikoma.c.k) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.tachikoma.c.k) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.tachikoma.c.k kVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        kVar.data = jSONObject.optString("data");
        if (JSONObject.NULL.toString().equals(kVar.data)) {
            kVar.data = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.webview.tachikoma.c.k kVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (kVar.data != null && !kVar.data.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "data", kVar.data);
        }
        return jSONObject;
    }
}
