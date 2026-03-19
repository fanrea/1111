package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class eo implements com.kwad.sdk.core.d<com.kwad.components.ad.draw.a.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ad.draw.a.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ad.draw.a.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.ad.draw.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.status = jSONObject.optInt("status");
        aVar.methodName = jSONObject.optString("method_name");
        if (JSONObject.NULL.toString().equals(aVar.methodName)) {
            aVar.methodName = "";
        }
        aVar.materialType = jSONObject.optInt("material_type");
        aVar.materialUrl = jSONObject.optString("material_url");
        if (JSONObject.NULL.toString().equals(aVar.materialUrl)) {
            aVar.materialUrl = "";
        }
        aVar.adNum = jSONObject.optInt("ad_num");
        aVar.loadTime = jSONObject.optLong("load_ad_duration_ms");
        aVar.renderTime = jSONObject.optLong("render_duration_ms");
        aVar.fj = jSONObject.optLong("request_ad_duration_ms");
        aVar.renderType = jSONObject.optInt("render_type");
        aVar.fk = jSONObject.optInt("expect_render_type");
        aVar.adStyle = jSONObject.optInt("ad_style");
    }

    private static JSONObject b(com.kwad.components.ad.draw.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.status != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "status", aVar.status);
        }
        if (aVar.methodName != null && !aVar.methodName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "method_name", aVar.methodName);
        }
        if (aVar.materialType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "material_type", aVar.materialType);
        }
        if (aVar.materialUrl != null && !aVar.materialUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "material_url", aVar.materialUrl);
        }
        if (aVar.adNum != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_num", aVar.adNum);
        }
        if (aVar.loadTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_ad_duration_ms", aVar.loadTime);
        }
        if (aVar.renderTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "render_duration_ms", aVar.renderTime);
        }
        if (aVar.fj != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "request_ad_duration_ms", aVar.fj);
        }
        if (aVar.renderType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "render_type", aVar.renderType);
        }
        if (aVar.fk != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "expect_render_type", aVar.fk);
        }
        if (aVar.adStyle != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_style", aVar.adStyle);
        }
        return jSONObject;
    }
}
