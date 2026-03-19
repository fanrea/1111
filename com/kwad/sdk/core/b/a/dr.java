package com.kwad.sdk.core.b.a;

import com.kwad.components.ct.response.model.CtPhotoInfo;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class dr implements com.kwad.sdk.core.d<CtPhotoInfo.CoverInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((CtPhotoInfo.CoverInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((CtPhotoInfo.CoverInfo) bVar, jSONObject);
    }

    private static void a(CtPhotoInfo.CoverInfo coverInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        coverInfo.coverUrl = jSONObject.optString("coverUrl");
        if (JSONObject.NULL.toString().equals(coverInfo.coverUrl)) {
            coverInfo.coverUrl = "";
        }
        coverInfo.width = jSONObject.optInt("width");
        coverInfo.height = jSONObject.optInt("height");
        coverInfo.webpCoverUrl = jSONObject.optString("webpCoverUrl");
        if (JSONObject.NULL.toString().equals(coverInfo.webpCoverUrl)) {
            coverInfo.webpCoverUrl = "";
        }
        coverInfo.blurCoverUrl = jSONObject.optString("blurCoverUrl");
        if (JSONObject.NULL.toString().equals(coverInfo.blurCoverUrl)) {
            coverInfo.blurCoverUrl = "";
        }
        coverInfo.blurBackgroundUrl = jSONObject.optString("blurBackgroundUrl");
        if (JSONObject.NULL.toString().equals(coverInfo.blurBackgroundUrl)) {
            coverInfo.blurBackgroundUrl = "";
        }
    }

    private static JSONObject b(CtPhotoInfo.CoverInfo coverInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (coverInfo.coverUrl != null && !coverInfo.coverUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "coverUrl", coverInfo.coverUrl);
        }
        if (coverInfo.width != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "width", coverInfo.width);
        }
        if (coverInfo.height != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "height", coverInfo.height);
        }
        if (coverInfo.webpCoverUrl != null && !coverInfo.webpCoverUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "webpCoverUrl", coverInfo.webpCoverUrl);
        }
        if (coverInfo.blurCoverUrl != null && !coverInfo.blurCoverUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "blurCoverUrl", coverInfo.blurCoverUrl);
        }
        if (coverInfo.blurBackgroundUrl != null && !coverInfo.blurBackgroundUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "blurBackgroundUrl", coverInfo.blurBackgroundUrl);
        }
        return jSONObject;
    }
}
