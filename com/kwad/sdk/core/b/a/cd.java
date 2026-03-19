package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class cd implements com.kwad.sdk.core.d<com.kwad.sdk.crash.online.monitor.block.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.crash.online.monitor.block.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.crash.online.monitor.block.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.crash.online.monitor.block.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.bOe = jSONObject.optString("printerName");
        if (JSONObject.NULL.toString().equals(aVar.bOe)) {
            aVar.bOe = "";
        }
        aVar.errorMsg = jSONObject.optString("errorMsg");
        if (JSONObject.NULL.toString().equals(aVar.errorMsg)) {
            aVar.errorMsg = "";
        }
        aVar.bOf = jSONObject.optBoolean("isDisable");
        aVar.bOg = jSONObject.optBoolean("hasMatrix");
    }

    private static JSONObject b(com.kwad.sdk.crash.online.monitor.block.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.bOe != null && !aVar.bOe.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "printerName", aVar.bOe);
        }
        if (aVar.errorMsg != null && !aVar.errorMsg.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "errorMsg", aVar.errorMsg);
        }
        if (aVar.bOf) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isDisable", aVar.bOf);
        }
        if (aVar.bOg) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "hasMatrix", aVar.bOg);
        }
        return jSONObject;
    }
}
