package com.kwad.sdk.core.b.a;

import com.kwad.components.ct.response.model.CtPhotoInfo;
import com.kwad.components.ct.response.model.live.LiveInfo;
import com.kwad.components.ct.response.model.tube.TubeEpisode;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class dw implements com.kwad.sdk.core.d<CtPhotoInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((CtPhotoInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((CtPhotoInfo) bVar, jSONObject);
    }

    private static void a(CtPhotoInfo ctPhotoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        ctPhotoInfo.coverInfo = new CtPhotoInfo.CoverInfo();
        ctPhotoInfo.coverInfo.parseJson(jSONObject.optJSONObject("coverInfo"));
        ctPhotoInfo.authorInfo = new CtPhotoInfo.AuthorInfo();
        ctPhotoInfo.authorInfo.parseJson(jSONObject.optJSONObject("authorInfo"));
        ctPhotoInfo.tubeEpisode = new TubeEpisode();
        ctPhotoInfo.tubeEpisode.parseJson(jSONObject.optJSONObject("tubeEpisode"));
        ctPhotoInfo.wallpaperInfo = new CtPhotoInfo.WallpaperInfo();
        ctPhotoInfo.wallpaperInfo.parseJson(jSONObject.optJSONObject("wallpaperInfo"));
        ctPhotoInfo.productInfo = new CtPhotoInfo.ProductInfo();
        ctPhotoInfo.productInfo.parseJson(jSONObject.optJSONObject("productInfo"));
        ctPhotoInfo.liveInfo = new LiveInfo();
        ctPhotoInfo.liveInfo.parseJson(jSONObject.optJSONObject("liveInfo"));
    }

    private static JSONObject b(CtPhotoInfo ctPhotoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "coverInfo", ctPhotoInfo.coverInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "authorInfo", ctPhotoInfo.authorInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "tubeEpisode", ctPhotoInfo.tubeEpisode);
        com.kwad.sdk.utils.aa.a(jSONObject, "wallpaperInfo", ctPhotoInfo.wallpaperInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "productInfo", ctPhotoInfo.productInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "liveInfo", ctPhotoInfo.liveInfo);
        return jSONObject;
    }
}
