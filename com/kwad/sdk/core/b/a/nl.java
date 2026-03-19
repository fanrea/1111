package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class nl implements com.kwad.sdk.core.d<com.kwad.components.core.p.c.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.p.c.d) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.p.c.d) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.p.c.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.UH = jSONObject.optString("load_module");
        if (JSONObject.NULL.toString().equals(dVar.UH)) {
            dVar.UH = "";
        }
        dVar.UI = jSONObject.optLong("load_status");
        dVar.UJ = jSONObject.optLong("load_duration_ms");
        dVar.UM = jSONObject.optLong("update_duration_ms");
        dVar.UL = jSONObject.optString("load_source");
        if (JSONObject.NULL.toString().equals(dVar.UL)) {
            dVar.UL = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.p.c.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (dVar.UH != null && !dVar.UH.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_module", dVar.UH);
        }
        if (dVar.UI != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_status", dVar.UI);
        }
        if (dVar.UJ != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_duration_ms", dVar.UJ);
        }
        if (dVar.UM != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "update_duration_ms", dVar.UM);
        }
        if (dVar.UL != null && !dVar.UL.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_source", dVar.UL);
        }
        return jSONObject;
    }
}
