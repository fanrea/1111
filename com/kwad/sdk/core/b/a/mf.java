package com.kwad.sdk.core.b.a;

import com.kwad.sdk.p.l;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class mf implements com.kwad.sdk.core.d<l.a.C0631a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((l.a.C0631a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((l.a.C0631a) bVar, jSONObject);
    }

    private static void a(l.a.C0631a c0631a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0631a.cqN = jSONObject.optString("s_cn");
        if (JSONObject.NULL.toString().equals(c0631a.cqN)) {
            c0631a.cqN = "";
        }
        c0631a.cqO = jSONObject.optString("s_mn");
        if (JSONObject.NULL.toString().equals(c0631a.cqO)) {
            c0631a.cqO = "";
        }
    }

    private static JSONObject b(l.a.C0631a c0631a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (c0631a.cqN != null && !c0631a.cqN.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "s_cn", c0631a.cqN);
        }
        if (c0631a.cqO != null && !c0631a.cqO.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "s_mn", c0631a.cqO);
        }
        return jSONObject;
    }
}
