package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.a;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class iy implements com.kwad.sdk.core.d<a.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((a.c) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((a.c) bVar, jSONObject);
    }

    private static void a(a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.errorCode = jSONObject.optInt("errorCode");
        cVar.adY = jSONObject.optInt("extra");
        cVar.adZ = jSONObject.optLong("playDuration");
        cVar.aea = jSONObject.optBoolean("clickRewardDialog");
    }

    private static JSONObject b(a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (cVar.errorCode != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "errorCode", cVar.errorCode);
        }
        if (cVar.adY != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "extra", cVar.adY);
        }
        if (cVar.adZ != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playDuration", cVar.adZ);
        }
        if (cVar.aea) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "clickRewardDialog", cVar.aea);
        }
        return jSONObject;
    }
}
