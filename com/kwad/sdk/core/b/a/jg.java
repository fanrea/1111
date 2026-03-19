package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class jg implements com.kwad.sdk.core.d<com.kwad.components.core.p.c.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.p.c.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.p.c.b) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.p.c.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.UH = jSONObject.optString("load_module");
        if (JSONObject.NULL.toString().equals(bVar.UH)) {
            bVar.UH = "";
        }
        bVar.UI = jSONObject.optLong("load_status");
        bVar.UJ = jSONObject.optLong("load_duration_ms");
        bVar.UK = jSONObject.optLong("thread_core_size", new Long("0").longValue());
        bVar.UL = jSONObject.optString("load_source");
        if (JSONObject.NULL.toString().equals(bVar.UL)) {
            bVar.UL = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.p.c.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.UH != null && !bVar.UH.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_module", bVar.UH);
        }
        if (bVar.UI != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_status", bVar.UI);
        }
        if (bVar.UJ != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_duration_ms", bVar.UJ);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "thread_core_size", bVar.UK);
        if (bVar.UL != null && !bVar.UL.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_source", bVar.UL);
        }
        return jSONObject;
    }
}
