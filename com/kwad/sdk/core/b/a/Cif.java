package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.if, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class Cif implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.i.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.commercial.i.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.commercial.i.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.commercial.i.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.buE = jSONObject.optString("origin_url");
        if (JSONObject.NULL.toString().equals(aVar.buE)) {
            aVar.buE = "";
        }
        aVar.buF = jSONObject.optString("final_url");
        if (JSONObject.NULL.toString().equals(aVar.buF)) {
            aVar.buF = "";
        }
        aVar.buw = jSONObject.optString("error_name");
        if (JSONObject.NULL.toString().equals(aVar.buw)) {
            aVar.buw = "";
        }
        aVar.buG = jSONObject.optString("macro_type");
        if (JSONObject.NULL.toString().equals(aVar.buG)) {
            aVar.buG = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.commercial.i.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.buE != null && !aVar.buE.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "origin_url", aVar.buE);
        }
        if (aVar.buF != null && !aVar.buF.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "final_url", aVar.buF);
        }
        if (aVar.buw != null && !aVar.buw.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "error_name", aVar.buw);
        }
        if (aVar.buG != null && !aVar.buG.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "macro_type", aVar.buG);
        }
        return jSONObject;
    }
}
