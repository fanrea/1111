package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.feed.monitor.FeedPageInfo;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ii implements com.kwad.sdk.core.d<FeedPageInfo.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((FeedPageInfo.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((FeedPageInfo.a) bVar, jSONObject);
    }

    private static void a(FeedPageInfo.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.materialType = jSONObject.optInt("material_type");
        aVar.materialUrl = jSONObject.optString("material_url");
        if (JSONObject.NULL.toString().equals(aVar.materialUrl)) {
            aVar.materialUrl = "";
        }
        aVar.creativeId = jSONObject.optLong("creative_id");
    }

    private static JSONObject b(FeedPageInfo.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.materialType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "material_type", aVar.materialType);
        }
        if (aVar.materialUrl != null && !aVar.materialUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "material_url", aVar.materialUrl);
        }
        if (aVar.creativeId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creative_id", aVar.creativeId);
        }
        return jSONObject;
    }
}
