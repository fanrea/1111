package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.webview.d.b;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class kp implements com.kwad.sdk.core.d<b.a> {
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
        aVar.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(aVar.url)) {
            aVar.url = "";
        }
        aVar.method = jSONObject.optString(com.alipay.sdk.m.p.e.s);
        if (JSONObject.NULL.toString().equals(aVar.method)) {
            aVar.method = "";
        }
        aVar.params = jSONObject.optString("params");
        if (JSONObject.NULL.toString().equals(aVar.params)) {
            aVar.params = "";
        }
    }

    private static JSONObject b(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.url != null && !aVar.url.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url", aVar.url);
        }
        if (aVar.method != null && !aVar.method.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, com.alipay.sdk.m.p.e.s, aVar.method);
        }
        if (aVar.params != null && !aVar.params.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "params", aVar.params);
        }
        return jSONObject;
    }
}
