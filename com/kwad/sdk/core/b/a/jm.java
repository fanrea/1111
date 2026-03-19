package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class jm implements com.kwad.sdk.core.d<com.kwad.sdk.core.config.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.config.d) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.config.d) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.config.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.bAp = jSONObject.optInt("enableDialog", new Integer("0").intValue());
        dVar.bAq = jSONObject.optInt("delayTime", new Integer("800").intValue());
        dVar.bAr = jSONObject.optInt("showTimesPerDay", new Integer("3").intValue());
        dVar.bAs = jSONObject.optInt("maxShowTimes", new Integer("100000").intValue());
    }

    private static JSONObject b(com.kwad.sdk.core.config.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "enableDialog", dVar.bAp);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "delayTime", dVar.bAq);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "showTimesPerDay", dVar.bAr);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "maxShowTimes", dVar.bAs);
        return jSONObject;
    }
}
