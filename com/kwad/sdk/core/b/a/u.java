package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class u implements com.kwad.sdk.core.d<com.kwad.components.core.m.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.m.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.m.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.m.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.Tf = jSONObject.optInt("currentActiveCount");
        aVar.Tg = jSONObject.optLong("lastForceActiveTimestamp");
    }

    private static JSONObject b(com.kwad.components.core.m.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.Tf != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "currentActiveCount", aVar.Tf);
        }
        if (aVar.Tg != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "lastForceActiveTimestamp", aVar.Tg);
        }
        return jSONObject;
    }
}
