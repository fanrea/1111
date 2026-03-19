package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ap implements com.kwad.sdk.core.d<AdInfo.AdShowVideoH5Info> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.AdShowVideoH5Info) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.AdShowVideoH5Info) bVar, jSONObject);
    }

    private static void a(AdInfo.AdShowVideoH5Info adShowVideoH5Info, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adShowVideoH5Info.showPageType = jSONObject.optInt("showPageType");
        adShowVideoH5Info.videoAutoLoopAtH5 = jSONObject.optBoolean("videoAutoLoopAtH5");
        adShowVideoH5Info.videoMutedAtH5 = jSONObject.optBoolean("videoMutedAtH5");
        adShowVideoH5Info.videoClickAtH5 = jSONObject.optBoolean("videoClickAtH5");
    }

    private static JSONObject b(AdInfo.AdShowVideoH5Info adShowVideoH5Info, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (adShowVideoH5Info.showPageType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "showPageType", adShowVideoH5Info.showPageType);
        }
        if (adShowVideoH5Info.videoAutoLoopAtH5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "videoAutoLoopAtH5", adShowVideoH5Info.videoAutoLoopAtH5);
        }
        if (adShowVideoH5Info.videoMutedAtH5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "videoMutedAtH5", adShowVideoH5Info.videoMutedAtH5);
        }
        if (adShowVideoH5Info.videoClickAtH5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "videoClickAtH5", adShowVideoH5Info.videoClickAtH5);
        }
        return jSONObject;
    }
}
