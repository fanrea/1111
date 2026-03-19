package com.kwad.sdk.core.b.a;

import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.PhotoAd;
import com.kwad.components.ct.response.model.PreloadData;
import com.kwad.components.ct.response.model.hotspot.NewsInfo;
import com.kwad.components.ct.response.model.live.LiveInfo;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class dv implements com.kwad.sdk.core.d<CtAdTemplate> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((CtAdTemplate) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((CtAdTemplate) bVar, jSONObject);
    }

    private static void a(CtAdTemplate ctAdTemplate, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        ctAdTemplate.photoAd = new PhotoAd();
        ctAdTemplate.photoAd.parseJson(jSONObject.optJSONObject("photoAd"));
        ctAdTemplate.newsInfo = new NewsInfo();
        ctAdTemplate.newsInfo.parseJson(jSONObject.optJSONObject("newsInfo"));
        ctAdTemplate.needHide = jSONObject.optBoolean("needHide");
        ctAdTemplate.mLiveInfo = new LiveInfo();
        ctAdTemplate.mLiveInfo.parseJson(jSONObject.optJSONObject("liveInfo"));
        ctAdTemplate.isDrawAdHasLook = jSONObject.optBoolean("isDrawAdHasLook");
        ctAdTemplate.mPreloadData = new PreloadData();
        ctAdTemplate.mPreloadData.parseJson(jSONObject.optJSONObject("mPreloadData"));
        ctAdTemplate.mPcursor = jSONObject.optString("mPcursor");
        if (JSONObject.NULL.toString().equals(ctAdTemplate.mPcursor)) {
            ctAdTemplate.mPcursor = "";
        }
        ctAdTemplate.mHasEntryAdClick = jSONObject.optBoolean("mHasEntryAdClick");
        ctAdTemplate.mIsNotNeedAvatarGuider = jSONObject.optBoolean("mIsNotNeedAvatarGuider");
    }

    private static JSONObject b(CtAdTemplate ctAdTemplate, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "photoAd", ctAdTemplate.photoAd);
        com.kwad.sdk.utils.aa.a(jSONObject, "newsInfo", ctAdTemplate.newsInfo);
        if (ctAdTemplate.needHide) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "needHide", ctAdTemplate.needHide);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "liveInfo", ctAdTemplate.mLiveInfo);
        if (ctAdTemplate.isDrawAdHasLook) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isDrawAdHasLook", ctAdTemplate.isDrawAdHasLook);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "mPreloadData", ctAdTemplate.mPreloadData);
        if (ctAdTemplate.mPcursor != null && !ctAdTemplate.mPcursor.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mPcursor", ctAdTemplate.mPcursor);
        }
        if (ctAdTemplate.mHasEntryAdClick) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mHasEntryAdClick", ctAdTemplate.mHasEntryAdClick);
        }
        if (ctAdTemplate.mIsNotNeedAvatarGuider) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mIsNotNeedAvatarGuider", ctAdTemplate.mIsNotNeedAvatarGuider);
        }
        return jSONObject;
    }
}
