package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class fi implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.i> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.tachikoma.c.i) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.tachikoma.c.i) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.tachikoma.c.i iVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        iVar.aiZ = jSONObject.optInt("motionType");
        iVar.aja = jSONObject.optInt("convertType");
        iVar.ajb = jSONObject.optString("convertSensitivity");
        if (JSONObject.NULL.toString().equals(iVar.ajb)) {
            iVar.ajb = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.webview.tachikoma.c.i iVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (iVar.aiZ != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "motionType", iVar.aiZ);
        }
        if (iVar.aja != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "convertType", iVar.aja);
        }
        if (iVar.ajb != null && !iVar.ajb.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "convertSensitivity", iVar.ajb);
        }
        return jSONObject;
    }
}
