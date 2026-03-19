package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class jz implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.q> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.tachikoma.c.q) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.tachikoma.c.q) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.tachikoma.c.q qVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        qVar.aji = jSONObject.optBoolean("isEnd");
    }

    private static JSONObject b(com.kwad.components.core.webview.tachikoma.c.q qVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (qVar.aji) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isEnd", qVar.aji);
        }
        return jSONObject;
    }
}
