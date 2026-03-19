package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class mh implements com.kwad.sdk.core.d<com.kwad.sdk.n.b.a.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.n.b.a.d) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.n.b.a.d) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.n.b.a.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.name = jSONObject.optString("name");
        if (JSONObject.NULL.toString().equals(dVar.name)) {
            dVar.name = "";
        }
        dVar.ckr = jSONObject.optString("detect_info");
        if (JSONObject.NULL.toString().equals(dVar.ckr)) {
            dVar.ckr = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.n.b.a.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (dVar.name != null && !dVar.name.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "name", dVar.name);
        }
        if (dVar.ckr != null && !dVar.ckr.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "detect_info", dVar.ckr);
        }
        return jSONObject;
    }
}
