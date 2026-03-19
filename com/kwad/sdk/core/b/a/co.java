package com.kwad.sdk.core.b.a;

import com.baidu.mobads.container.rewardvideo.RemoteRewardActivity;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class co implements com.kwad.sdk.core.d<com.kwad.sdk.core.report.h> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.report.h) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.report.h) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.report.h hVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        hVar.llsid = jSONObject.optLong("llsid");
        hVar.creativeId = jSONObject.optLong("creative_id");
        hVar.score = jSONObject.optInt(RemoteRewardActivity.JSON_BANNER_SCORE_ID);
        hVar.bEI = jSONObject.optInt("is_bidding");
        hVar.source = jSONObject.optString(com.sigmob.sdk.base.n.l);
        if (JSONObject.NULL.toString().equals(hVar.source)) {
            hVar.source = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.core.report.h hVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (hVar.llsid != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "llsid", hVar.llsid);
        }
        if (hVar.creativeId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creative_id", hVar.creativeId);
        }
        if (hVar.score != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, RemoteRewardActivity.JSON_BANNER_SCORE_ID, hVar.score);
        }
        if (hVar.bEI != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "is_bidding", hVar.bEI);
        }
        if (hVar.source != null && !hVar.source.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, com.sigmob.sdk.base.n.l, hVar.source);
        }
        return jSONObject;
    }
}
