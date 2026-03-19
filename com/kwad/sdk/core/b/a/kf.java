package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class kf implements com.kwad.sdk.core.d<com.kwad.sdk.core.response.model.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.response.model.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.response.model.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.posId = jSONObject.optLong("posId");
        aVar.bGV = jSONObject.optInt("adPhotoCountForMedia");
        aVar.bGW = jSONObject.optBoolean("enablePreload");
        aVar.bGX = jSONObject.optLong("increaseAdLoadTime", new Long("10000").longValue());
        aVar.bGY = jSONObject.optInt("adLoadStrategy");
        aVar.bGZ = jSONObject.optInt("drawAdForcedWatchTimes", new Integer("3").intValue());
    }

    private static JSONObject b(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.posId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "posId", aVar.posId);
        }
        if (aVar.bGV != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adPhotoCountForMedia", aVar.bGV);
        }
        if (aVar.bGW) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "enablePreload", aVar.bGW);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "increaseAdLoadTime", aVar.bGX);
        if (aVar.bGY != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adLoadStrategy", aVar.bGY);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "drawAdForcedWatchTimes", aVar.bGZ);
        return jSONObject;
    }
}
