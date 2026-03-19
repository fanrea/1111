package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.request.model.StatusInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class mj implements com.kwad.sdk.core.d<StatusInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((StatusInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((StatusInfo) bVar, jSONObject);
    }

    private static void a(StatusInfo statusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        statusInfo.bGK = jSONObject.optInt("personalRecommend");
        statusInfo.bGL = jSONObject.optInt("programmaticRecommend");
        statusInfo.bGM = new StatusInfo.SplashAdInfo();
        statusInfo.bGM.parseJson(jSONObject.optJSONObject("splashAdInfo"));
        statusInfo.bGN = new StatusInfo.NativeAdRequestInfo();
        statusInfo.bGN.parseJson(jSONObject.optJSONObject("nativeAdInfo"));
        statusInfo.bGO = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("taskStats");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                com.kwad.sdk.core.request.model.f fVar = new com.kwad.sdk.core.request.model.f();
                fVar.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                statusInfo.bGO.add(fVar);
            }
        }
    }

    private static JSONObject b(StatusInfo statusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (statusInfo.bGK != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "personalRecommend", statusInfo.bGK);
        }
        if (statusInfo.bGL != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "programmaticRecommend", statusInfo.bGL);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "splashAdInfo", statusInfo.bGM);
        com.kwad.sdk.utils.aa.a(jSONObject, "nativeAdInfo", statusInfo.bGN);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "taskStats", statusInfo.bGO);
        return jSONObject;
    }
}
