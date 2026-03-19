package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class fe implements com.kwad.sdk.core.d<com.kwad.sdk.crash.online.monitor.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.crash.online.monitor.a.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.crash.online.monitor.a.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.crash.online.monitor.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.appId = jSONObject.optString("appId");
        if (JSONObject.NULL.toString().equals(bVar.appId)) {
            bVar.appId = "";
        }
        bVar.bOq = jSONObject.optString("pluginListenerName");
        if (JSONObject.NULL.toString().equals(bVar.bOq)) {
            bVar.bOq = "";
        }
        bVar.bOr = jSONObject.optString("reportMethodName");
        if (JSONObject.NULL.toString().equals(bVar.bOr)) {
            bVar.bOr = "";
        }
        bVar.bOs = jSONObject.optString("otherProxyClassName");
        if (JSONObject.NULL.toString().equals(bVar.bOs)) {
            bVar.bOs = "";
        }
        bVar.bOt = jSONObject.optString("otherFieldName");
        if (JSONObject.NULL.toString().equals(bVar.bOt)) {
            bVar.bOt = "";
        }
        bVar.bOu = jSONObject.optString("otherLevelFieldName");
        if (JSONObject.NULL.toString().equals(bVar.bOu)) {
            bVar.bOu = "";
        }
        bVar.bOv = jSONObject.optString("blockTag");
        if (JSONObject.NULL.toString().equals(bVar.bOv)) {
            bVar.bOv = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.crash.online.monitor.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.appId != null && !bVar.appId.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appId", bVar.appId);
        }
        if (bVar.bOq != null && !bVar.bOq.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pluginListenerName", bVar.bOq);
        }
        if (bVar.bOr != null && !bVar.bOr.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "reportMethodName", bVar.bOr);
        }
        if (bVar.bOs != null && !bVar.bOs.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "otherProxyClassName", bVar.bOs);
        }
        if (bVar.bOt != null && !bVar.bOt.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "otherFieldName", bVar.bOt);
        }
        if (bVar.bOu != null && !bVar.bOu.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "otherLevelFieldName", bVar.bOu);
        }
        if (bVar.bOv != null && !bVar.bOv.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "blockTag", bVar.bOv);
        }
        return jSONObject;
    }
}
