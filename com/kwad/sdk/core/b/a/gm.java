package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class gm implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.b.a.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.webview.b.a.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.webview.b.a.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.webview.b.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.bLZ = jSONObject.optString("Access-Control-Allow-Origin");
        if (JSONObject.NULL.toString().equals(aVar.bLZ)) {
            aVar.bLZ = "";
        }
        aVar.bMa = jSONObject.optString("Timing-Allow-Origin");
        if (JSONObject.NULL.toString().equals(aVar.bMa)) {
            aVar.bMa = "";
        }
        aVar.bMb = jSONObject.optString(com.alipay.sdk.m.p.e.f);
        if (JSONObject.NULL.toString().equals(aVar.bMb)) {
            aVar.bMb = "";
        }
        aVar.bMc = jSONObject.optString("Date");
        if (JSONObject.NULL.toString().equals(aVar.bMc)) {
            aVar.bMc = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.core.webview.b.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.bLZ != null && !aVar.bLZ.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "Access-Control-Allow-Origin", aVar.bLZ);
        }
        if (aVar.bMa != null && !aVar.bMa.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "Timing-Allow-Origin", aVar.bMa);
        }
        if (aVar.bMb != null && !aVar.bMb.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, com.alipay.sdk.m.p.e.f, aVar.bMb);
        }
        if (aVar.bMc != null && !aVar.bMc.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "Date", aVar.bMc);
        }
        return jSONObject;
    }
}
