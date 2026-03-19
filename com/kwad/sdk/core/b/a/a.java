package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.ABParams;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a implements com.kwad.sdk.core.d<ABParams> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((ABParams) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((ABParams) bVar, jSONObject);
    }

    private static void a(ABParams aBParams, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aBParams.videoBlackAreaClick = jSONObject.optInt("videoBlackAreaClick");
        aBParams.videoBlackAreaNewStyle = jSONObject.optInt("videoBlackAreaNewStyle");
        aBParams.drawActionBarTimes = jSONObject.optString("drawActionBarTimes");
        if (JSONObject.NULL.toString().equals(aBParams.drawActionBarTimes)) {
            aBParams.drawActionBarTimes = "";
        }
        aBParams.showVideoAtH5 = jSONObject.optInt("showVideoAtH5");
        aBParams.playableStyle = jSONObject.optInt("playableStyle");
    }

    private static JSONObject b(ABParams aBParams, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aBParams.videoBlackAreaClick != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "videoBlackAreaClick", aBParams.videoBlackAreaClick);
        }
        if (aBParams.videoBlackAreaNewStyle != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "videoBlackAreaNewStyle", aBParams.videoBlackAreaNewStyle);
        }
        if (aBParams.drawActionBarTimes != null && !aBParams.drawActionBarTimes.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "drawActionBarTimes", aBParams.drawActionBarTimes);
        }
        if (aBParams.showVideoAtH5 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "showVideoAtH5", aBParams.showVideoAtH5);
        }
        if (aBParams.playableStyle != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playableStyle", aBParams.playableStyle);
        }
        return jSONObject;
    }
}
