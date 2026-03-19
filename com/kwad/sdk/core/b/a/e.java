package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class e implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.d.b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.webview.d.b.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.webview.d.b.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.webview.d.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.afD = jSONObject.optBoolean("clickActionButton");
        aVar.afF = jSONObject.optInt("area");
        aVar.oz = jSONObject.optInt("itemClickType");
        aVar.bMr = jSONObject.optInt("convertPageType", new Integer("-1").intValue());
        aVar.afG = new com.kwad.sdk.core.webview.d.b.d();
        aVar.afG.parseJson(jSONObject.optJSONObject("logParam"));
        aVar.QV = jSONObject.optBoolean("needReport", new Boolean("true").booleanValue());
        aVar.creativeId = jSONObject.optLong("creativeId", new Long("-1").longValue());
        aVar.Rj = jSONObject.optString("liveItemId");
        if (JSONObject.NULL.toString().equals(aVar.Rj)) {
            aVar.Rj = "";
        }
        aVar.bMs = jSONObject.optInt("sceneType");
        aVar.adStyle = jSONObject.optInt("adStyle", new Integer("-1").intValue());
        aVar.bMt = jSONObject.optBoolean("isCallbackOnly");
        aVar.bMu = jSONObject.optBoolean("disableCallback");
    }

    private static JSONObject b(com.kwad.sdk.core.webview.d.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.afD) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "clickActionButton", aVar.afD);
        }
        if (aVar.afF != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "area", aVar.afF);
        }
        if (aVar.oz != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "itemClickType", aVar.oz);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "convertPageType", aVar.bMr);
        com.kwad.sdk.utils.aa.a(jSONObject, "logParam", aVar.afG);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "needReport", aVar.QV);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "creativeId", aVar.creativeId);
        if (aVar.Rj != null && !aVar.Rj.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "liveItemId", aVar.Rj);
        }
        if (aVar.bMs != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sceneType", aVar.bMs);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "adStyle", aVar.adStyle);
        if (aVar.bMt) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isCallbackOnly", aVar.bMt);
        }
        if (aVar.bMu) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "disableCallback", aVar.bMu);
        }
        return jSONObject;
    }
}
