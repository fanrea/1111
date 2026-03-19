package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.a.a;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ei implements com.kwad.sdk.core.d<a.C0489a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((a.C0489a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((a.C0489a) bVar, jSONObject);
    }

    private static void a(a.C0489a c0489a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0489a.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(c0489a.url)) {
            c0489a.url = "";
        }
        c0489a.packageName = jSONObject.optString("packageName");
        if (JSONObject.NULL.toString().equals(c0489a.packageName)) {
            c0489a.packageName = "";
        }
    }

    private static JSONObject b(a.C0489a c0489a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (c0489a.url != null && !c0489a.url.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url", c0489a.url);
        }
        if (c0489a.packageName != null && !c0489a.packageName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "packageName", c0489a.packageName);
        }
        return jSONObject;
    }
}
