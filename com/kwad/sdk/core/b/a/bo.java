package com.kwad.sdk.core.b.a;

import com.kwad.components.core.request.model.b;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class bo implements com.kwad.sdk.core.d<b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((b.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((b.a) bVar, jSONObject);
    }

    private static void a(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.streamType = jSONObject.optInt("streamType");
        aVar.Zr = jSONObject.optInt("maxVolume");
        aVar.Zs = jSONObject.optInt("minVolume");
        aVar.Zt = jSONObject.optInt("currentVolume");
    }

    private static JSONObject b(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.streamType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "streamType", aVar.streamType);
        }
        if (aVar.Zr != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "maxVolume", aVar.Zr);
        }
        if (aVar.Zs != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "minVolume", aVar.Zs);
        }
        if (aVar.Zt != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "currentVolume", aVar.Zt);
        }
        return jSONObject;
    }
}
