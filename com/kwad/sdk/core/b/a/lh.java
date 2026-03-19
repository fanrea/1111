package com.kwad.sdk.core.b.a;

import com.kwad.components.ct.response.model.home.PhotoShareInfo;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class lh implements com.kwad.sdk.core.d<PhotoShareInfo.ShareUrlInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((PhotoShareInfo.ShareUrlInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((PhotoShareInfo.ShareUrlInfo) bVar, jSONObject);
    }

    private static void a(PhotoShareInfo.ShareUrlInfo shareUrlInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        shareUrlInfo.shareUrl = jSONObject.optString("shareUrl");
        if (JSONObject.NULL.toString().equals(shareUrlInfo.shareUrl)) {
            shareUrlInfo.shareUrl = "";
        }
        shareUrlInfo.mediaShareItem = jSONObject.optString("mediaShareItem");
        if (JSONObject.NULL.toString().equals(shareUrlInfo.mediaShareItem)) {
            shareUrlInfo.mediaShareItem = "";
        }
    }

    private static JSONObject b(PhotoShareInfo.ShareUrlInfo shareUrlInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (shareUrlInfo.shareUrl != null && !shareUrlInfo.shareUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "shareUrl", shareUrlInfo.shareUrl);
        }
        if (shareUrlInfo.mediaShareItem != null && !shareUrlInfo.mediaShareItem.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mediaShareItem", shareUrlInfo.mediaShareItem);
        }
        return jSONObject;
    }
}
