package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.aq;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class hn implements com.kwad.sdk.core.d<aq.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((aq.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((aq.b) bVar, jSONObject);
    }

    private static void a(aq.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.afL = jSONObject.optDouble("progress");
        bVar.status = jSONObject.optInt("status");
        bVar.totalBytes = jSONObject.optLong("totalBytes");
        bVar.soFarBytes = jSONObject.optLong("soFarBytes");
        bVar.afM = jSONObject.optDouble("realProgress");
    }

    private static JSONObject b(aq.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.afL != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "progress", bVar.afL);
        }
        if (bVar.status != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "status", bVar.status);
        }
        if (bVar.totalBytes != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "totalBytes", bVar.totalBytes);
        }
        if (bVar.soFarBytes != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "soFarBytes", bVar.soFarBytes);
        }
        if (bVar.afM != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "realProgress", bVar.afM);
        }
        return jSONObject;
    }
}
