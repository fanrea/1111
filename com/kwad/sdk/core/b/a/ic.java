package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ic implements com.kwad.sdk.core.d<com.kwad.components.ad.fullscreen.b.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ad.fullscreen.b.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ad.fullscreen.b.b) bVar, jSONObject);
    }

    private static void a(com.kwad.components.ad.fullscreen.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.lt = jSONObject.optLong("lastShowTimestamp");
        bVar.lu = jSONObject.optInt("currentDailyCount");
    }

    private static JSONObject b(com.kwad.components.ad.fullscreen.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.lt != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "lastShowTimestamp", bVar.lt);
        }
        if (bVar.lu != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "currentDailyCount", bVar.lu);
        }
        return jSONObject;
    }
}
