package com.kwad.sdk.core.b.a;

import androidx.core.app.NotificationCompat;
import com.kwad.components.ad.reward.monitor.RewardWebViewInfo;
import com.sigmob.windad.WindAds;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ky implements com.kwad.sdk.core.d<RewardWebViewInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((RewardWebViewInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((RewardWebViewInfo) bVar, jSONObject);
    }

    private static void a(RewardWebViewInfo rewardWebViewInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rewardWebViewInfo.event = jSONObject.optString(NotificationCompat.CATEGORY_EVENT);
        if (JSONObject.NULL.toString().equals(rewardWebViewInfo.event)) {
            rewardWebViewInfo.event = "";
        }
        rewardWebViewInfo.status = jSONObject.optInt("status");
        rewardWebViewInfo.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(rewardWebViewInfo.url)) {
            rewardWebViewInfo.url = "";
        }
        rewardWebViewInfo.source = jSONObject.optString(com.sigmob.sdk.base.n.l);
        if (JSONObject.NULL.toString().equals(rewardWebViewInfo.source)) {
            rewardWebViewInfo.source = "";
        }
        rewardWebViewInfo.sceneId = jSONObject.optString(WindAds.AD_SCENE_ID);
        if (JSONObject.NULL.toString().equals(rewardWebViewInfo.sceneId)) {
            rewardWebViewInfo.sceneId = "";
        }
        rewardWebViewInfo.pageType = jSONObject.optString("page_type");
        if (JSONObject.NULL.toString().equals(rewardWebViewInfo.pageType)) {
            rewardWebViewInfo.pageType = "";
        }
        rewardWebViewInfo.durationMs = jSONObject.optLong("duration_ms");
        rewardWebViewInfo.timeType = jSONObject.optInt("time_type");
    }

    private static JSONObject b(RewardWebViewInfo rewardWebViewInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (rewardWebViewInfo.event != null && !rewardWebViewInfo.event.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, NotificationCompat.CATEGORY_EVENT, rewardWebViewInfo.event);
        }
        if (rewardWebViewInfo.status != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "status", rewardWebViewInfo.status);
        }
        if (rewardWebViewInfo.url != null && !rewardWebViewInfo.url.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url", rewardWebViewInfo.url);
        }
        if (rewardWebViewInfo.source != null && !rewardWebViewInfo.source.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, com.sigmob.sdk.base.n.l, rewardWebViewInfo.source);
        }
        if (rewardWebViewInfo.sceneId != null && !rewardWebViewInfo.sceneId.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, WindAds.AD_SCENE_ID, rewardWebViewInfo.sceneId);
        }
        if (rewardWebViewInfo.pageType != null && !rewardWebViewInfo.pageType.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "page_type", rewardWebViewInfo.pageType);
        }
        if (rewardWebViewInfo.durationMs != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "duration_ms", rewardWebViewInfo.durationMs);
        }
        if (rewardWebViewInfo.timeType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "time_type", rewardWebViewInfo.timeType);
        }
        return jSONObject;
    }
}
