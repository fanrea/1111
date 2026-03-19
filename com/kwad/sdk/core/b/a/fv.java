package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class fv implements com.kwad.sdk.core.d<com.kwad.sdk.n.b.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.n.b.a.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.n.b.a.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.n.b.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.key = jSONObject.optString("key");
        if (JSONObject.NULL.toString().equals(bVar.key)) {
            bVar.key = "";
        }
        bVar.value = jSONObject.optInt(com.alipay.sdk.m.p0.b.d);
    }

    private static JSONObject b(com.kwad.sdk.n.b.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.key != null && !bVar.key.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "key", bVar.key);
        }
        if (bVar.value != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, com.alipay.sdk.m.p0.b.d, bVar.value);
        }
        return jSONObject;
    }
}
