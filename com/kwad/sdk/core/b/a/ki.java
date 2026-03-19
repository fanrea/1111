package com.kwad.sdk.core.b.a;

import com.kwad.components.ct.response.model.PreloadData;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ki implements com.kwad.sdk.core.d<PreloadData> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((PreloadData) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((PreloadData) bVar, jSONObject);
    }

    private static void a(PreloadData preloadData, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        preloadData.isPreload = jSONObject.optBoolean("isPreload");
        preloadData.mCacheTime = jSONObject.optLong("mCacheTime");
    }

    private static JSONObject b(PreloadData preloadData, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (preloadData.isPreload) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isPreload", preloadData.isPreload);
        }
        if (preloadData.mCacheTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mCacheTime", preloadData.mCacheTime);
        }
        return jSONObject;
    }
}
