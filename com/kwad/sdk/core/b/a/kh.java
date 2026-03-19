package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.splashscreen.SplashPreloadManager;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class kh implements com.kwad.sdk.core.d<SplashPreloadManager.PreLoadItem> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((SplashPreloadManager.PreLoadItem) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((SplashPreloadManager.PreLoadItem) bVar, jSONObject);
    }

    private static void a(SplashPreloadManager.PreLoadItem preLoadItem, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        preLoadItem.cacheTime = jSONObject.optLong("cacheTime");
        preLoadItem.expiredTime = jSONObject.optLong("expiredTime");
        preLoadItem.preloadId = jSONObject.optString("preloadId");
        if (JSONObject.NULL.toString().equals(preLoadItem.preloadId)) {
            preLoadItem.preloadId = "";
        }
        preLoadItem.materialType = jSONObject.optInt("materialType");
    }

    private static JSONObject b(SplashPreloadManager.PreLoadItem preLoadItem, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (preLoadItem.cacheTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cacheTime", preLoadItem.cacheTime);
        }
        if (preLoadItem.expiredTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "expiredTime", preLoadItem.expiredTime);
        }
        if (preLoadItem.preloadId != null && !preLoadItem.preloadId.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "preloadId", preLoadItem.preloadId);
        }
        if (preLoadItem.materialType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "materialType", preLoadItem.materialType);
        }
        return jSONObject;
    }
}
