package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.config.item.h;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class gu implements com.kwad.sdk.core.d<h.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((h.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((h.a) bVar, jSONObject);
    }

    private static void a(h.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.bAx = jSONObject.optString(com.baidu.mobads.container.adrequest.g.z);
        if (JSONObject.NULL.toString().equals(aVar.bAx)) {
            aVar.bAx = "";
        }
        aVar.bAy = jSONObject.optString("oaid");
        if (JSONObject.NULL.toString().equals(aVar.bAy)) {
            aVar.bAy = "";
        }
    }

    private static JSONObject b(h.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.bAx != null && !aVar.bAx.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, com.baidu.mobads.container.adrequest.g.z, aVar.bAx);
        }
        if (aVar.bAy != null && !aVar.bAy.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "oaid", aVar.bAy);
        }
        return jSONObject;
    }
}
