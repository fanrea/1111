package com.kwad.sdk.core.b.a;

import com.kwad.components.ct.response.model.CtPhotoInfo;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class oa implements com.kwad.sdk.core.d<CtPhotoInfo.WallpaperInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((CtPhotoInfo.WallpaperInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((CtPhotoInfo.WallpaperInfo) bVar, jSONObject);
    }

    private static void a(CtPhotoInfo.WallpaperInfo wallpaperInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        wallpaperInfo.isWallpaperPhoto = jSONObject.optBoolean("isWallpaperPhoto");
    }

    private static JSONObject b(CtPhotoInfo.WallpaperInfo wallpaperInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (wallpaperInfo.isWallpaperPhoto) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isWallpaperPhoto", wallpaperInfo.isWallpaperPhoto);
        }
        return jSONObject;
    }
}
