package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.feed.monitor.FeedErrorInfo;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class fg implements com.kwad.sdk.core.d<FeedErrorInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((FeedErrorInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((FeedErrorInfo) bVar, jSONObject);
    }

    private static void a(FeedErrorInfo feedErrorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        feedErrorInfo.materialType = jSONObject.optLong("material_type");
        feedErrorInfo.width = jSONObject.optLong("width");
        feedErrorInfo.feedType = jSONObject.optLong("feed_type");
        feedErrorInfo.errorType = jSONObject.optLong("error_type");
    }

    private static JSONObject b(FeedErrorInfo feedErrorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (feedErrorInfo.materialType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "material_type", feedErrorInfo.materialType);
        }
        if (feedErrorInfo.width != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "width", feedErrorInfo.width);
        }
        if (feedErrorInfo.feedType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "feed_type", feedErrorInfo.feedType);
        }
        if (feedErrorInfo.errorType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "error_type", feedErrorInfo.errorType);
        }
        return jSONObject;
    }
}
