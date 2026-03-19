package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class lw implements com.kwad.sdk.core.d<com.kwad.components.ad.splashscreen.local.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ad.splashscreen.local.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ad.splashscreen.local.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.ad.splashscreen.local.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.lt = jSONObject.optLong("lastShowTimestamp");
        aVar.lu = jSONObject.optInt("currentDailyCount");
    }

    private static JSONObject b(com.kwad.components.ad.splashscreen.local.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.lt != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "lastShowTimestamp", aVar.lt);
        }
        if (aVar.lu != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "currentDailyCount", aVar.lu);
        }
        return jSONObject;
    }
}
