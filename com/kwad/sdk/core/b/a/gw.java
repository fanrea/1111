package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.imageloader.ImageLoaderInfo;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class gw implements com.kwad.sdk.core.d<ImageLoaderInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((ImageLoaderInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((ImageLoaderInfo) bVar, jSONObject);
    }

    private static void a(ImageLoaderInfo imageLoaderInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        imageLoaderInfo.totalCount = jSONObject.optInt("total_count");
        imageLoaderInfo.failedCount = jSONObject.optInt("failed_count");
        imageLoaderInfo.successCount = jSONObject.optInt("success_count");
        imageLoaderInfo.duration = jSONObject.optDouble("duration");
    }

    private static JSONObject b(ImageLoaderInfo imageLoaderInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (imageLoaderInfo.totalCount != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "total_count", imageLoaderInfo.totalCount);
        }
        if (imageLoaderInfo.failedCount != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "failed_count", imageLoaderInfo.failedCount);
        }
        if (imageLoaderInfo.successCount != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "success_count", imageLoaderInfo.successCount);
        }
        if (imageLoaderInfo.duration != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "duration", imageLoaderInfo.duration);
        }
        return jSONObject;
    }
}
