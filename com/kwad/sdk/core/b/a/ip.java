package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ip implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.n> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.tachikoma.c.n) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.tachikoma.c.n) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.tachikoma.c.n nVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        nVar.ajg = jSONObject.optBoolean("muted");
    }

    private static JSONObject b(com.kwad.components.core.webview.tachikoma.c.n nVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (nVar.ajg) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "muted", nVar.ajg);
        }
        return jSONObject;
    }
}
