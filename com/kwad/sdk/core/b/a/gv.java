package com.kwad.sdk.core.b.a;

import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.kwad.components.ct.response.model.hotspot.NewsInfo;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class gv implements com.kwad.sdk.core.d<NewsInfo.ImageInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((NewsInfo.ImageInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((NewsInfo.ImageInfo) bVar, jSONObject);
    }

    private static void a(NewsInfo.ImageInfo imageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        imageInfo.width = jSONObject.optInt("width");
        imageInfo.height = jSONObject.optInt("height");
        imageInfo.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(imageInfo.url)) {
            imageInfo.url = "";
        }
        imageInfo.origin = jSONObject.optString(LiveConfigKey.ORIGIN);
        if (JSONObject.NULL.toString().equals(imageInfo.origin)) {
            imageInfo.origin = "";
        }
    }

    private static JSONObject b(NewsInfo.ImageInfo imageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (imageInfo.width != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "width", imageInfo.width);
        }
        if (imageInfo.height != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "height", imageInfo.height);
        }
        if (imageInfo.url != null && !imageInfo.url.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url", imageInfo.url);
        }
        if (imageInfo.origin != null && !imageInfo.origin.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, LiveConfigKey.ORIGIN, imageInfo.origin);
        }
        return jSONObject;
    }
}
