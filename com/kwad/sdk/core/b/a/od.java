package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.az;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class od implements com.kwad.sdk.core.d<az.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((az.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((az.a) bVar, jSONObject);
    }

    private static void a(az.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.afY = jSONObject.optString("windowFocusEvent");
        if (JSONObject.NULL.toString().equals(aVar.afY)) {
            aVar.afY = "";
        }
    }

    private static JSONObject b(az.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.afY != null && !aVar.afY.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "windowFocusEvent", aVar.afY);
        }
        return jSONObject;
    }
}
