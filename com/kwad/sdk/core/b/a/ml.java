package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ml implements com.kwad.sdk.core.d<AdMatrixInfo.StyleComponentInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.StyleComponentInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.StyleComponentInfo) bVar, jSONObject);
    }

    private static void a(AdMatrixInfo.StyleComponentInfo styleComponentInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        styleComponentInfo.playCardInfo = new AdMatrixInfo.ComponentTemplateInfo();
        styleComponentInfo.playCardInfo.parseJson(jSONObject.optJSONObject("playCardInfo"));
        styleComponentInfo.endCardInfo = new AdMatrixInfo.ComponentTemplateInfo();
        styleComponentInfo.endCardInfo.parseJson(jSONObject.optJSONObject("endCardInfo"));
        styleComponentInfo.styleComponentFlag = jSONObject.optBoolean("styleComponentFlag");
    }

    private static JSONObject b(AdMatrixInfo.StyleComponentInfo styleComponentInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "playCardInfo", styleComponentInfo.playCardInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "endCardInfo", styleComponentInfo.endCardInfo);
        if (styleComponentInfo.styleComponentFlag) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "styleComponentFlag", styleComponentInfo.styleComponentFlag);
        }
        return jSONObject;
    }
}
