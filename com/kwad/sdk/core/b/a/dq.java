package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.ao;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class dq implements com.kwad.sdk.core.d<ao.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((ao.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((ao.a) bVar, jSONObject);
    }

    private static void a(ao.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.afD = jSONObject.optBoolean("clickActionButton");
        aVar.afE = jSONObject.optString("adTemplate");
        if (JSONObject.NULL.toString().equals(aVar.afE)) {
            aVar.afE = "";
        }
        aVar.afF = jSONObject.optInt("area");
        aVar.afG = new com.kwad.sdk.core.webview.d.b.d();
        aVar.afG.parseJson(jSONObject.optJSONObject("logParam"));
    }

    private static JSONObject b(ao.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.afD) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "clickActionButton", aVar.afD);
        }
        if (aVar.afE != null && !aVar.afE.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adTemplate", aVar.afE);
        }
        if (aVar.afF != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "area", aVar.afF);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "logParam", aVar.afG);
        return jSONObject;
    }
}
