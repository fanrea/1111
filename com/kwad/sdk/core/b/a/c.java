package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class c implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.ActionBarInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdStyleInfo.PlayDetailInfo.ActionBarInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdStyleInfo.PlayDetailInfo.ActionBarInfo) bVar, jSONObject);
    }

    private static void a(AdStyleInfo.PlayDetailInfo.ActionBarInfo actionBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        actionBarInfo.translateBtnShowTime = jSONObject.optLong("translateBtnShowTime");
        actionBarInfo.lightBtnShowTime = jSONObject.optLong("lightBtnShowTime");
        actionBarInfo.cardShowTime = jSONObject.optLong("cardShowTime");
    }

    private static JSONObject b(AdStyleInfo.PlayDetailInfo.ActionBarInfo actionBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (actionBarInfo.translateBtnShowTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "translateBtnShowTime", actionBarInfo.translateBtnShowTime);
        }
        if (actionBarInfo.lightBtnShowTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "lightBtnShowTime", actionBarInfo.lightBtnShowTime);
        }
        if (actionBarInfo.cardShowTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cardShowTime", actionBarInfo.cardShowTime);
        }
        return jSONObject;
    }
}
