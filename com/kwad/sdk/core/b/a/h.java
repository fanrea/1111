package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class h implements com.kwad.sdk.core.d<AdInfo.AdAggregateInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.AdAggregateInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.AdAggregateInfo) bVar, jSONObject);
    }

    private static void a(AdInfo.AdAggregateInfo adAggregateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adAggregateInfo.aggregateAdType = jSONObject.optInt("aggregateAdType");
        adAggregateInfo.upperTab = jSONObject.optString("upperTab");
        if (JSONObject.NULL.toString().equals(adAggregateInfo.upperTab)) {
            adAggregateInfo.upperTab = "";
        }
        adAggregateInfo.hotTagUrl = jSONObject.optString("hotTagUrl");
        if (JSONObject.NULL.toString().equals(adAggregateInfo.hotTagUrl)) {
            adAggregateInfo.hotTagUrl = "";
        }
    }

    private static JSONObject b(AdInfo.AdAggregateInfo adAggregateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (adAggregateInfo.aggregateAdType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "aggregateAdType", adAggregateInfo.aggregateAdType);
        }
        if (adAggregateInfo.upperTab != null && !adAggregateInfo.upperTab.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "upperTab", adAggregateInfo.upperTab);
        }
        if (adAggregateInfo.hotTagUrl != null && !adAggregateInfo.hotTagUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "hotTagUrl", adAggregateInfo.hotTagUrl);
        }
        return jSONObject;
    }
}
