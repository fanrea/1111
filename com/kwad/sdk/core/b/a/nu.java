package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class nu implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.y> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.tachikoma.c.y) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.tachikoma.c.y) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.tachikoma.c.y yVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        yVar.ajn = jSONObject.optString("status");
        if (JSONObject.NULL.toString().equals(yVar.ajn)) {
            yVar.ajn = "";
        }
        yVar.errorCode = jSONObject.optInt("errorCode");
        yVar.errorReason = jSONObject.optString("errorReason");
        if (JSONObject.NULL.toString().equals(yVar.errorReason)) {
            yVar.errorReason = "";
        }
        yVar.sp = jSONObject.optInt("currentTime");
    }

    private static JSONObject b(com.kwad.components.core.webview.tachikoma.c.y yVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (yVar.ajn != null && !yVar.ajn.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "status", yVar.ajn);
        }
        if (yVar.errorCode != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "errorCode", yVar.errorCode);
        }
        if (yVar.errorReason != null && !yVar.errorReason.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "errorReason", yVar.errorReason);
        }
        if (yVar.sp != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "currentTime", yVar.sp);
        }
        return jSONObject;
    }
}
