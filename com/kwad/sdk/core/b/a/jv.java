package com.kwad.sdk.core.b.a;

import com.kwad.components.ct.response.model.PhotoAd;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class jv implements com.kwad.sdk.core.d<PhotoAd> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((PhotoAd) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((PhotoAd) bVar, jSONObject);
    }

    private static void a(PhotoAd photoAd, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        photoAd.requestPatchAd = jSONObject.optBoolean("requestPatchAd", new Boolean("false").booleanValue());
        photoAd.requestPatchEc = jSONObject.optBoolean("requestPatchEc", new Boolean("false").booleanValue());
        photoAd.requestWidgetAd = jSONObject.optBoolean("requestWidgetAd", new Boolean("false").booleanValue());
        photoAd.requestBannerAd = jSONObject.optBoolean("requestBannerAd", new Boolean("false").booleanValue());
        photoAd.requestDynamicRewardAd = jSONObject.optBoolean("requestDynamicRewardAd", new Boolean("true").booleanValue());
        photoAd.requestInsertScreenAd = jSONObject.optBoolean("requestInsertScreenAd", new Boolean("false").booleanValue());
    }

    private static JSONObject b(PhotoAd photoAd, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "requestPatchAd", photoAd.requestPatchAd);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "requestPatchEc", photoAd.requestPatchEc);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "requestWidgetAd", photoAd.requestWidgetAd);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "requestBannerAd", photoAd.requestBannerAd);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "requestDynamicRewardAd", photoAd.requestDynamicRewardAd);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "requestInsertScreenAd", photoAd.requestInsertScreenAd);
        return jSONObject;
    }
}
