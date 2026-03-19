package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.PhotoInfo;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class jx implements com.kwad.sdk.core.d<PhotoInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((PhotoInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((PhotoInfo) bVar, jSONObject);
    }

    private static void a(PhotoInfo photoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        photoInfo.mOriginJString = jSONObject.optString("mOriginJString");
        if (JSONObject.NULL.toString().equals(photoInfo.mOriginJString)) {
            photoInfo.mOriginJString = "";
        }
        photoInfo.baseInfo = new PhotoInfo.BaseInfo();
        photoInfo.baseInfo.parseJson(jSONObject.optJSONObject("baseInfo"));
        photoInfo.videoInfo = new PhotoInfo.VideoInfo();
        photoInfo.videoInfo.parseJson(jSONObject.optJSONObject("videoInfo"));
    }

    private static JSONObject b(PhotoInfo photoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (photoInfo.mOriginJString != null && !photoInfo.mOriginJString.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mOriginJString", photoInfo.mOriginJString);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "baseInfo", photoInfo.baseInfo);
        com.kwad.sdk.utils.aa.a(jSONObject, "videoInfo", photoInfo.videoInfo);
        return jSONObject;
    }
}
