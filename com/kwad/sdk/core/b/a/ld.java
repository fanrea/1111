package com.kwad.sdk.core.b.a;

import com.kwad.sdk.j.a;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ld implements com.kwad.sdk.core.d<a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((a.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((a.b) bVar, jSONObject);
    }

    private static void a(a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.cgj = jSONObject.optInt("enable_monitor");
        bVar.cgk = jSONObject.optString("c_sc_name");
        if (JSONObject.NULL.toString().equals(bVar.cgk)) {
            bVar.cgk = "";
        }
        bVar.cgl = jSONObject.optString("c_pcl_name");
        if (JSONObject.NULL.toString().equals(bVar.cgl)) {
            bVar.cgl = "";
        }
        bVar.cgm = jSONObject.optString("m_gam_name");
        if (JSONObject.NULL.toString().equals(bVar.cgm)) {
            bVar.cgm = "";
        }
        bVar.cgn = jSONObject.optString("m_gsv_name");
        if (JSONObject.NULL.toString().equals(bVar.cgn)) {
            bVar.cgn = "";
        }
        bVar.cgo = jSONObject.optString("m_gpv_name");
        if (JSONObject.NULL.toString().equals(bVar.cgo)) {
            bVar.cgo = "";
        }
    }

    private static JSONObject b(a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.cgj != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "enable_monitor", bVar.cgj);
        }
        if (bVar.cgk != null && !bVar.cgk.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "c_sc_name", bVar.cgk);
        }
        if (bVar.cgl != null && !bVar.cgl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "c_pcl_name", bVar.cgl);
        }
        if (bVar.cgm != null && !bVar.cgm.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "m_gam_name", bVar.cgm);
        }
        if (bVar.cgn != null && !bVar.cgn.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "m_gsv_name", bVar.cgn);
        }
        if (bVar.cgo != null && !bVar.cgo.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "m_gpv_name", bVar.cgo);
        }
        return jSONObject;
    }
}
