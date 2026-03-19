package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class hw implements com.kwad.sdk.core.d<com.kwad.components.core.page.b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.page.b.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.page.b.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.page.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.adStyle = jSONObject.optInt("ad_style");
        aVar.Vl = jSONObject.optInt("neo_tk_render_type");
    }

    private static JSONObject b(com.kwad.components.core.page.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.adStyle != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_style", aVar.adStyle);
        }
        if (aVar.Vl != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "neo_tk_render_type", aVar.Vl);
        }
        return jSONObject;
    }
}
