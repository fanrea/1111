package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class eb implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.h> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.tachikoma.c.h) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.tachikoma.c.h) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.tachikoma.c.h hVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        hVar.aiY = jSONObject.optInt("hasDeepReward");
    }

    private static JSONObject b(com.kwad.components.core.webview.tachikoma.c.h hVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (hVar.aiY != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "hasDeepReward", hVar.aiY);
        }
        return jSONObject;
    }
}
