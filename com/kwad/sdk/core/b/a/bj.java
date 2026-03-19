package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.av;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class bj implements com.kwad.sdk.core.d<av.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((av.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((av.a) bVar, jSONObject);
    }

    private static void a(av.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.afL = jSONObject.optDouble("progress");
        aVar.status = jSONObject.optInt("status");
        aVar.totalBytes = jSONObject.optLong("totalBytes");
        aVar.soFarBytes = jSONObject.optLong("soFarBytes");
        aVar.afM = jSONObject.optDouble("realProgress");
    }

    private static JSONObject b(av.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.afL != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "progress", aVar.afL);
        }
        if (aVar.status != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "status", aVar.status);
        }
        if (aVar.totalBytes != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "totalBytes", aVar.totalBytes);
        }
        if (aVar.soFarBytes != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "soFarBytes", aVar.soFarBytes);
        }
        if (aVar.afM != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "realProgress", aVar.afM);
        }
        return jSONObject;
    }
}
