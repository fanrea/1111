package com.kwad.sdk.core.b.a;

import com.kwad.sdk.n.b;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b implements com.kwad.sdk.core.d<b.a> {
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
        aVar.cjQ = jSONObject.optString("originalActStr");
        if (JSONObject.NULL.toString().equals(aVar.cjQ)) {
            aVar.cjQ = "";
        }
        aVar.cjR = jSONObject.optString("targetField");
        if (JSONObject.NULL.toString().equals(aVar.cjR)) {
            aVar.cjR = "";
        }
    }

    private static JSONObject b(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.cjQ != null && !aVar.cjQ.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "originalActStr", aVar.cjQ);
        }
        if (aVar.cjR != null && !aVar.cjR.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "targetField", aVar.cjR);
        }
        return jSONObject;
    }
}
