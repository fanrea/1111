package com.kwad.sdk.core.b.a;

import com.bytedance.applog.aggregation.MetricsSQLiteCacheKt;
import com.kwad.sdk.commercial.model.HybridLoadMsg;
import com.sigmob.windad.WindAds;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class gs implements com.kwad.sdk.core.d<HybridLoadMsg> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((HybridLoadMsg) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((HybridLoadMsg) bVar, jSONObject);
    }

    private static void a(HybridLoadMsg hybridLoadMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        hybridLoadMsg.sceneId = jSONObject.optString(WindAds.AD_SCENE_ID);
        if (JSONObject.NULL.toString().equals(hybridLoadMsg.sceneId)) {
            hybridLoadMsg.sceneId = "";
        }
        hybridLoadMsg.h5Version = jSONObject.optString("h5_version");
        if (JSONObject.NULL.toString().equals(hybridLoadMsg.h5Version)) {
            hybridLoadMsg.h5Version = "";
        }
        hybridLoadMsg.loadType = jSONObject.optInt("load_type");
        hybridLoadMsg.state = jSONObject.optInt("state");
        hybridLoadMsg.interval = jSONObject.optString(MetricsSQLiteCacheKt.METRICS_INTERVAL);
        if (JSONObject.NULL.toString().equals(hybridLoadMsg.interval)) {
            hybridLoadMsg.interval = "";
        }
        hybridLoadMsg.failState = jSONObject.optInt("fail_state");
        hybridLoadMsg.failReason = jSONObject.optString("fail_reason");
        if (JSONObject.NULL.toString().equals(hybridLoadMsg.failReason)) {
            hybridLoadMsg.failReason = "";
        }
        hybridLoadMsg.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(hybridLoadMsg.url)) {
            hybridLoadMsg.url = "";
        }
        hybridLoadMsg.packageUrl = jSONObject.optString("package_url");
        if (JSONObject.NULL.toString().equals(hybridLoadMsg.packageUrl)) {
            hybridLoadMsg.packageUrl = "";
        }
    }

    private static JSONObject b(HybridLoadMsg hybridLoadMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (hybridLoadMsg.sceneId != null && !hybridLoadMsg.sceneId.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, WindAds.AD_SCENE_ID, hybridLoadMsg.sceneId);
        }
        if (hybridLoadMsg.h5Version != null && !hybridLoadMsg.h5Version.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "h5_version", hybridLoadMsg.h5Version);
        }
        if (hybridLoadMsg.loadType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_type", hybridLoadMsg.loadType);
        }
        if (hybridLoadMsg.state != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "state", hybridLoadMsg.state);
        }
        if (hybridLoadMsg.interval != null && !hybridLoadMsg.interval.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, MetricsSQLiteCacheKt.METRICS_INTERVAL, hybridLoadMsg.interval);
        }
        if (hybridLoadMsg.failState != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "fail_state", hybridLoadMsg.failState);
        }
        if (hybridLoadMsg.failReason != null && !hybridLoadMsg.failReason.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "fail_reason", hybridLoadMsg.failReason);
        }
        if (hybridLoadMsg.url != null && !hybridLoadMsg.url.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url", hybridLoadMsg.url);
        }
        if (hybridLoadMsg.packageUrl != null && !hybridLoadMsg.packageUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "package_url", hybridLoadMsg.packageUrl);
        }
        return jSONObject;
    }
}
