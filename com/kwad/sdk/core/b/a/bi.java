package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class bi implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.commercial.a.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.commercial.a.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.commercial.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("status");
        bVar.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(bVar.url)) {
            bVar.url = "";
        }
        bVar.bub = jSONObject.optString("url_host");
        if (JSONObject.NULL.toString().equals(bVar.bub)) {
            bVar.bub = "";
        }
        bVar.downloadId = jSONObject.optString("download_id");
        if (JSONObject.NULL.toString().equals(bVar.downloadId)) {
            bVar.downloadId = "";
        }
        bVar.buc = jSONObject.optString("apk_package");
        if (JSONObject.NULL.toString().equals(bVar.buc)) {
            bVar.buc = "";
        }
        bVar.bud = jSONObject.optString("apk_name");
        if (JSONObject.NULL.toString().equals(bVar.bud)) {
            bVar.bud = "";
        }
        bVar.bue = jSONObject.optLong("apk_size");
        bVar.downloadTime = jSONObject.optLong("download_time");
        bVar.bug = jSONObject.optLong("apk_cur_size");
        bVar.buh = jSONObject.optInt("apk_install_type");
        bVar.bui = jSONObject.optInt("apk_install_source");
    }

    private static JSONObject b(com.kwad.sdk.commercial.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.status != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "status", bVar.status);
        }
        if (bVar.url != null && !bVar.url.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url", bVar.url);
        }
        if (bVar.bub != null && !bVar.bub.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url_host", bVar.bub);
        }
        if (bVar.downloadId != null && !bVar.downloadId.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "download_id", bVar.downloadId);
        }
        if (bVar.buc != null && !bVar.buc.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "apk_package", bVar.buc);
        }
        if (bVar.bud != null && !bVar.bud.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "apk_name", bVar.bud);
        }
        if (bVar.bue != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "apk_size", bVar.bue);
        }
        if (bVar.downloadTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "download_time", bVar.downloadTime);
        }
        if (bVar.bug != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "apk_cur_size", bVar.bug);
        }
        if (bVar.buh != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "apk_install_type", bVar.buh);
        }
        if (bVar.bui != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "apk_install_source", bVar.bui);
        }
        return jSONObject;
    }
}
