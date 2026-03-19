package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class hv implements com.kwad.sdk.core.d<com.kwad.sdk.utils.b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.utils.b.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.utils.b.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.utils.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.cpo = jSONObject.optInt("put_count");
        aVar.cpp = jSONObject.optInt("get_failed_count");
        aVar.cpq = jSONObject.optInt("get_success_count");
    }

    private static JSONObject b(com.kwad.sdk.utils.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.cpo != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "put_count", aVar.cpo);
        }
        if (aVar.cpp != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "get_failed_count", aVar.cpp);
        }
        if (aVar.cpq != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "get_success_count", aVar.cpq);
        }
        return jSONObject;
    }
}
