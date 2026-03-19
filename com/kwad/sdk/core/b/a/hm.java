package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.aq;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class hm implements com.kwad.sdk.core.d<aq.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((aq.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((aq.a) bVar, jSONObject);
    }

    private static void a(aq.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.afE = jSONObject.optString("adTemplate");
        if (JSONObject.NULL.toString().equals(aVar.afE)) {
            aVar.afE = "";
        }
    }

    private static JSONObject b(aq.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.afE != null && !aVar.afE.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adTemplate", aVar.afE);
        }
        return jSONObject;
    }
}
