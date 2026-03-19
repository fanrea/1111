package com.kwad.sdk.core.b.a;

import com.kwad.components.ct.emotion.model.CDNUrl;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ch implements com.kwad.sdk.core.d<CDNUrl> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((CDNUrl) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((CDNUrl) bVar, jSONObject);
    }

    private static void a(CDNUrl cDNUrl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cDNUrl.cdn = jSONObject.optString("cdn");
        if (JSONObject.NULL.toString().equals(cDNUrl.cdn)) {
            cDNUrl.cdn = "";
        }
        cDNUrl.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(cDNUrl.url)) {
            cDNUrl.url = "";
        }
        cDNUrl.ip = jSONObject.optString("ip");
        if (JSONObject.NULL.toString().equals(cDNUrl.ip)) {
            cDNUrl.ip = "";
        }
        cDNUrl.urlPattern = jSONObject.optString("urlPattern");
        if (JSONObject.NULL.toString().equals(cDNUrl.urlPattern)) {
            cDNUrl.urlPattern = "";
        }
    }

    private static JSONObject b(CDNUrl cDNUrl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (cDNUrl.cdn != null && !cDNUrl.cdn.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cdn", cDNUrl.cdn);
        }
        if (cDNUrl.url != null && !cDNUrl.url.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url", cDNUrl.url);
        }
        if (cDNUrl.ip != null && !cDNUrl.ip.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ip", cDNUrl.ip);
        }
        if (cDNUrl.urlPattern != null && !cDNUrl.urlPattern.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "urlPattern", cDNUrl.urlPattern);
        }
        return jSONObject;
    }
}
