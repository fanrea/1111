package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class iz implements com.kwad.sdk.core.d<AdGlobalConfigInfo.NeoScanAggregationSceneInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdGlobalConfigInfo.NeoScanAggregationSceneInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdGlobalConfigInfo.NeoScanAggregationSceneInfo) bVar, jSONObject);
    }

    private static void a(AdGlobalConfigInfo.NeoScanAggregationSceneInfo neoScanAggregationSceneInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        neoScanAggregationSceneInfo.neoCountDownNeedSwipeTrigger = jSONObject.optBoolean("neoCountDownNeedSwipeTrigger");
        neoScanAggregationSceneInfo.neoCountDownTime = jSONObject.optInt("neoCountDownTime");
        neoScanAggregationSceneInfo.noActionStopCountDown = jSONObject.optBoolean("noActionStopCountDown");
        neoScanAggregationSceneInfo.noActionTime = jSONObject.optInt("noActionTime");
        neoScanAggregationSceneInfo.guidSwipezShowMore = jSONObject.optBoolean("guidSwipezShowMore");
        neoScanAggregationSceneInfo.mute = jSONObject.optBoolean(com.sigmob.sdk.base.common.a.D);
    }

    private static JSONObject b(AdGlobalConfigInfo.NeoScanAggregationSceneInfo neoScanAggregationSceneInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (neoScanAggregationSceneInfo.neoCountDownNeedSwipeTrigger) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "neoCountDownNeedSwipeTrigger", neoScanAggregationSceneInfo.neoCountDownNeedSwipeTrigger);
        }
        if (neoScanAggregationSceneInfo.neoCountDownTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "neoCountDownTime", neoScanAggregationSceneInfo.neoCountDownTime);
        }
        if (neoScanAggregationSceneInfo.noActionStopCountDown) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "noActionStopCountDown", neoScanAggregationSceneInfo.noActionStopCountDown);
        }
        if (neoScanAggregationSceneInfo.noActionTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "noActionTime", neoScanAggregationSceneInfo.noActionTime);
        }
        if (neoScanAggregationSceneInfo.guidSwipezShowMore) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "guidSwipezShowMore", neoScanAggregationSceneInfo.guidSwipezShowMore);
        }
        if (neoScanAggregationSceneInfo.mute) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, com.sigmob.sdk.base.common.a.D, neoScanAggregationSceneInfo.mute);
        }
        return jSONObject;
    }
}
