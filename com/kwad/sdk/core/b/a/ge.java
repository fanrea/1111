package com.kwad.sdk.core.b.a;

import com.kwad.components.ct.coupon.bridge.b;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ge implements com.kwad.sdk.core.d<b.a> {
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
        aVar.amZ = jSONObject.optString("fromPageName");
        if (JSONObject.NULL.toString().equals(aVar.amZ)) {
            aVar.amZ = "";
        }
    }

    private static JSONObject b(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.amZ != null && !aVar.amZ.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "fromPageName", aVar.amZ);
        }
        return jSONObject;
    }
}
