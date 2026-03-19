package com.kwad.sdk.core.b.a;

import com.kwad.sdk.n.a.b;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class bf implements com.kwad.sdk.core.d<com.kwad.sdk.n.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.n.a.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.n.a.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.n.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.cjX = jSONObject.optString("nodeClassName");
        if (JSONObject.NULL.toString().equals(bVar.cjX)) {
            bVar.cjX = "";
        }
        bVar.cjY = jSONObject.optString("childFieldName");
        if (JSONObject.NULL.toString().equals(bVar.cjY)) {
            bVar.cjY = "";
        }
        bVar.cjZ = jSONObject.optBoolean("childFieldIsStatic");
        bVar.cka = jSONObject.optString("reportKey");
        if (JSONObject.NULL.toString().equals(bVar.cka)) {
            bVar.cka = "";
        }
        bVar.ckb = new b.C0629b();
        bVar.ckb.parseJson(jSONObject.optJSONObject("childMethod"));
        bVar.ckc = new com.kwad.sdk.n.a.b();
        bVar.ckc.parseJson(jSONObject.optJSONObject("deepNode"));
    }

    private static JSONObject b(com.kwad.sdk.n.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.cjX != null && !bVar.cjX.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "nodeClassName", bVar.cjX);
        }
        if (bVar.cjY != null && !bVar.cjY.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "childFieldName", bVar.cjY);
        }
        if (bVar.cjZ) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "childFieldIsStatic", bVar.cjZ);
        }
        if (bVar.cka != null && !bVar.cka.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "reportKey", bVar.cka);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "childMethod", bVar.ckb);
        com.kwad.sdk.utils.aa.a(jSONObject, "deepNode", bVar.ckc);
        return jSONObject;
    }
}
