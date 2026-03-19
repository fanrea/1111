package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdStatusInfo;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ar implements com.kwad.sdk.core.d<AdStatusInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdStatusInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdStatusInfo) bVar, jSONObject);
    }

    private static void a(AdStatusInfo adStatusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adStatusInfo.loadFromCache = jSONObject.optBoolean("loadFromCache");
        adStatusInfo.loadDataTime = jSONObject.optLong("loadDataTime");
        adStatusInfo.downloadFinishTime = jSONObject.optLong("downloadFinishTime");
        adStatusInfo.downloadType = jSONObject.optInt("downloadType");
        adStatusInfo.downloadSize = jSONObject.optLong("downloadSize");
        adStatusInfo.downloadStatus = jSONObject.optInt("downloadStatus");
    }

    private static JSONObject b(AdStatusInfo adStatusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (adStatusInfo.loadFromCache) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "loadFromCache", adStatusInfo.loadFromCache);
        }
        if (adStatusInfo.loadDataTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "loadDataTime", adStatusInfo.loadDataTime);
        }
        if (adStatusInfo.downloadFinishTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadFinishTime", adStatusInfo.downloadFinishTime);
        }
        if (adStatusInfo.downloadType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadType", adStatusInfo.downloadType);
        }
        if (adStatusInfo.downloadSize != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadSize", adStatusInfo.downloadSize);
        }
        if (adStatusInfo.downloadStatus != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadStatus", adStatusInfo.downloadStatus);
        }
        return jSONObject;
    }
}
