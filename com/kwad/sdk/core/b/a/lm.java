package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class lm implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.u> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.tachikoma.c.u) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.tachikoma.c.u) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.tachikoma.c.u uVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        uVar.ajk = jSONObject.optBoolean("needPromopt");
        uVar.QV = jSONObject.optBoolean("needReport");
        uVar.showTime = jSONObject.optInt("showTime");
        uVar.adZ = jSONObject.optLong("playDuration");
    }

    private static JSONObject b(com.kwad.components.core.webview.tachikoma.c.u uVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (uVar.ajk) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "needPromopt", uVar.ajk);
        }
        if (uVar.QV) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "needReport", uVar.QV);
        }
        if (uVar.showTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "showTime", uVar.showTime);
        }
        if (uVar.adZ != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playDuration", uVar.adZ);
        }
        return jSONObject;
    }
}
