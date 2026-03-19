package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class oc implements com.kwad.sdk.core.d<com.kwad.components.core.video.a.e> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.video.a.e) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.video.a.e) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.video.a.e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        eVar.adv = jSONObject.optString("vse_msg");
        if (JSONObject.NULL.toString().equals(eVar.adv)) {
            eVar.adv = "";
        }
        eVar.adw = jSONObject.optString("vse_simple_msg");
        if (JSONObject.NULL.toString().equals(eVar.adw)) {
            eVar.adw = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.video.a.e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (eVar.adv != null && !eVar.adv.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "vse_msg", eVar.adv);
        }
        if (eVar.adw != null && !eVar.adw.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "vse_simple_msg", eVar.adw);
        }
        return jSONObject;
    }
}
