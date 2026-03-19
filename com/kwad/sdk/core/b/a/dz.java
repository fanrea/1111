package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class dz implements com.kwad.sdk.core.d<AdMatrixInfo.CycleAggregateInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.CycleAggregateInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.CycleAggregateInfo) bVar, jSONObject);
    }

    private static void a(AdMatrixInfo.CycleAggregateInfo cycleAggregateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cycleAggregateInfo.cutIconUrl = jSONObject.optString("cutIconUrl");
        if (JSONObject.NULL.toString().equals(cycleAggregateInfo.cutIconUrl)) {
            cycleAggregateInfo.cutIconUrl = "";
        }
        cycleAggregateInfo.refreshIconUrl = jSONObject.optString("refreshIconUrl");
        if (JSONObject.NULL.toString().equals(cycleAggregateInfo.refreshIconUrl)) {
            cycleAggregateInfo.refreshIconUrl = "";
        }
        cycleAggregateInfo.convertIconUrl = jSONObject.optString("convertIconUrl");
        if (JSONObject.NULL.toString().equals(cycleAggregateInfo.convertIconUrl)) {
            cycleAggregateInfo.convertIconUrl = "";
        }
    }

    private static JSONObject b(AdMatrixInfo.CycleAggregateInfo cycleAggregateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (cycleAggregateInfo.cutIconUrl != null && !cycleAggregateInfo.cutIconUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cutIconUrl", cycleAggregateInfo.cutIconUrl);
        }
        if (cycleAggregateInfo.refreshIconUrl != null && !cycleAggregateInfo.refreshIconUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "refreshIconUrl", cycleAggregateInfo.refreshIconUrl);
        }
        if (cycleAggregateInfo.convertIconUrl != null && !cycleAggregateInfo.convertIconUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "convertIconUrl", cycleAggregateInfo.convertIconUrl);
        }
        return jSONObject;
    }
}
