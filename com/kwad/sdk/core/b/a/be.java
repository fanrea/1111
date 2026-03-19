package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class be implements com.kwad.sdk.core.d<com.kwad.sdk.n.b.a.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.n.b.a.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.n.b.a.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.n.b.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.ckk = jSONObject.optInt("aggregation_sdk_type");
        aVar.ckl = jSONObject.optString("aggregation_version");
        if (JSONObject.NULL.toString().equals(aVar.ckl)) {
            aVar.ckl = "";
        }
        aVar.ckm = jSONObject.optInt("crash_times");
        aVar.ckn = jSONObject.optInt("call_ks_union_times");
        aVar.cko = jSONObject.optLong("ks_launch_delay");
        aVar.ckp = jSONObject.optLong("aggregation_launch_delay");
    }

    private static JSONObject b(com.kwad.sdk.n.b.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.ckk != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "aggregation_sdk_type", aVar.ckk);
        }
        if (aVar.ckl != null && !aVar.ckl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "aggregation_version", aVar.ckl);
        }
        if (aVar.ckm != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "crash_times", aVar.ckm);
        }
        if (aVar.ckn != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "call_ks_union_times", aVar.ckn);
        }
        if (aVar.cko != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ks_launch_delay", aVar.cko);
        }
        if (aVar.ckp != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "aggregation_launch_delay", aVar.ckp);
        }
        return jSONObject;
    }
}
