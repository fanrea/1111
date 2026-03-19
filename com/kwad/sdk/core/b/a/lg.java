package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class lg implements com.kwad.sdk.core.d<AdMatrixInfo.ShakeInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.ShakeInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.ShakeInfo) bVar, jSONObject);
    }

    private static void a(AdMatrixInfo.ShakeInfo shakeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        shakeInfo.title = jSONObject.optString("title");
        if (JSONObject.NULL.toString().equals(shakeInfo.title)) {
            shakeInfo.title = "";
        }
        shakeInfo.subtitle = jSONObject.optString("subtitle");
        if (JSONObject.NULL.toString().equals(shakeInfo.subtitle)) {
            shakeInfo.subtitle = "";
        }
        shakeInfo.acceleration = jSONObject.optInt("acceleration");
        shakeInfo.clickDisabled = jSONObject.optBoolean("clickDisabled");
        shakeInfo.componentIndex = jSONObject.optInt("componentIndex");
        shakeInfo.enable = jSONObject.optBoolean("enable");
    }

    private static JSONObject b(AdMatrixInfo.ShakeInfo shakeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (shakeInfo.title != null && !shakeInfo.title.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "title", shakeInfo.title);
        }
        if (shakeInfo.subtitle != null && !shakeInfo.subtitle.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "subtitle", shakeInfo.subtitle);
        }
        if (shakeInfo.acceleration != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "acceleration", shakeInfo.acceleration);
        }
        if (shakeInfo.clickDisabled) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "clickDisabled", shakeInfo.clickDisabled);
        }
        if (shakeInfo.componentIndex != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "componentIndex", shakeInfo.componentIndex);
        }
        if (shakeInfo.enable) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "enable", shakeInfo.enable);
        }
        return jSONObject;
    }
}
