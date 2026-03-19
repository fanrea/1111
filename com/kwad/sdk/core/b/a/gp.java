package com.kwad.sdk.core.b.a;

import com.kwad.components.ct.response.model.hotspot.HotspotInfo;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class gp implements com.kwad.sdk.core.d<HotspotInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((HotspotInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((HotspotInfo) bVar, jSONObject);
    }

    private static void a(HotspotInfo hotspotInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        hotspotInfo.trendId = jSONObject.optLong("trendId");
        hotspotInfo.name = jSONObject.optString("name");
        if (JSONObject.NULL.toString().equals(hotspotInfo.name)) {
            hotspotInfo.name = "";
        }
        hotspotInfo.viewCount = jSONObject.optLong("viewCount");
        hotspotInfo.offlineTime = jSONObject.optLong("offlineTime");
        hotspotInfo.photoCount = jSONObject.optInt("photoCount");
        hotspotInfo.coverUrl = jSONObject.optString("coverUrl");
        if (JSONObject.NULL.toString().equals(hotspotInfo.coverUrl)) {
            hotspotInfo.coverUrl = "";
        }
        hotspotInfo.iconUrl = jSONObject.optString("iconUrl");
        if (JSONObject.NULL.toString().equals(hotspotInfo.iconUrl)) {
            hotspotInfo.iconUrl = "";
        }
        hotspotInfo.rank = jSONObject.optInt("rank");
    }

    private static JSONObject b(HotspotInfo hotspotInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (hotspotInfo.trendId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "trendId", hotspotInfo.trendId);
        }
        if (hotspotInfo.name != null && !hotspotInfo.name.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "name", hotspotInfo.name);
        }
        if (hotspotInfo.viewCount != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "viewCount", hotspotInfo.viewCount);
        }
        if (hotspotInfo.offlineTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "offlineTime", hotspotInfo.offlineTime);
        }
        if (hotspotInfo.photoCount != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "photoCount", hotspotInfo.photoCount);
        }
        if (hotspotInfo.coverUrl != null && !hotspotInfo.coverUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "coverUrl", hotspotInfo.coverUrl);
        }
        if (hotspotInfo.iconUrl != null && !hotspotInfo.iconUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "iconUrl", hotspotInfo.iconUrl);
        }
        if (hotspotInfo.rank != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "rank", hotspotInfo.rank);
        }
        return jSONObject;
    }
}
