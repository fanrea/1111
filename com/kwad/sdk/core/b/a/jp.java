package com.kwad.sdk.core.b.a;

import com.kwad.components.ct.coupon.bridge.c;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class jp implements com.kwad.sdk.core.d<c.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((c.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((c.a) bVar, jSONObject);
    }

    private static void a(c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.afZ = jSONObject.optString("lifeStatus");
        if (JSONObject.NULL.toString().equals(aVar.afZ)) {
            aVar.afZ = "";
        }
    }

    private static JSONObject b(c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.afZ != null && !aVar.afZ.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "lifeStatus", aVar.afZ);
        }
        return jSONObject;
    }
}
