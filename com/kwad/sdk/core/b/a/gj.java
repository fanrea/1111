package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class gj implements com.kwad.sdk.core.d<com.kwad.sdk.f.a.a.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.f.a.a.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.f.a.a.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.f.a.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.bPo = jSONObject.optInt("apiLevel");
        aVar.bPp = jSONObject.optInt("colorModeSupport");
        aVar.bPq = jSONObject.optInt("screenHdrAvailable");
        aVar.bPr = jSONObject.optInt("hdrSupport");
    }

    private static JSONObject b(com.kwad.sdk.f.a.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.bPo != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "apiLevel", aVar.bPo);
        }
        if (aVar.bPp != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "colorModeSupport", aVar.bPp);
        }
        if (aVar.bPq != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "screenHdrAvailable", aVar.bPq);
        }
        if (aVar.bPr != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "hdrSupport", aVar.bPr);
        }
        return jSONObject;
    }
}
