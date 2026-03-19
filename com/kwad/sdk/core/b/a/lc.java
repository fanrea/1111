package com.kwad.sdk.core.b.a;

import com.kwad.sdk.j.a;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class lc implements com.kwad.sdk.core.d<a.C0617a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((a.C0617a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((a.C0617a) bVar, jSONObject);
    }

    private static void a(a.C0617a c0617a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0617a.cgi = jSONObject.optInt("ds");
        c0617a.sdkVersion = jSONObject.optString("sv");
        if (JSONObject.NULL.toString().equals(c0617a.sdkVersion)) {
            c0617a.sdkVersion = "";
        }
        c0617a.bMW = jSONObject.optString("spv");
        if (JSONObject.NULL.toString().equals(c0617a.bMW)) {
            c0617a.bMW = "";
        }
    }

    private static JSONObject b(a.C0617a c0617a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (c0617a.cgi != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ds", c0617a.cgi);
        }
        if (c0617a.sdkVersion != null && !c0617a.sdkVersion.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sv", c0617a.sdkVersion);
        }
        if (c0617a.bMW != null && !c0617a.bMW.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "spv", c0617a.bMW);
        }
        return jSONObject;
    }
}
