package com.kwad.sdk.core.b.a;

import com.baidu.mobads.container.rewardvideo.RemoteRewardActivity;
import com.kwad.components.ad.reward.h;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class cr implements com.kwad.sdk.core.d<h.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((h.c) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((h.c) bVar, jSONObject);
    }

    private static void a(h.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.style = jSONObject.optInt("style");
        cVar.title = jSONObject.optString("title");
        if (JSONObject.NULL.toString().equals(cVar.title)) {
            cVar.title = "";
        }
        cVar.uI = jSONObject.optString("closeBtnText");
        if (JSONObject.NULL.toString().equals(cVar.uI)) {
            cVar.uI = "";
        }
        cVar.uJ = jSONObject.optString("continueBtnText");
        if (JSONObject.NULL.toString().equals(cVar.uJ)) {
            cVar.uJ = "";
        }
        cVar.uK = jSONObject.optString("viewDetailText");
        if (JSONObject.NULL.toString().equals(cVar.uK)) {
            cVar.uK = "";
        }
        cVar.uL = jSONObject.optString("unWatchedVideoTime");
        if (JSONObject.NULL.toString().equals(cVar.uL)) {
            cVar.uL = "";
        }
        cVar.iconUrl = jSONObject.optString("iconUrl");
        if (JSONObject.NULL.toString().equals(cVar.iconUrl)) {
            cVar.iconUrl = "";
        }
        cVar.uM = jSONObject.optString(RemoteRewardActivity.JSON_BANNER_DESC_ID);
        if (JSONObject.NULL.toString().equals(cVar.uM)) {
            cVar.uM = "";
        }
        cVar.uN = jSONObject.optString("descTxt");
        if (JSONObject.NULL.toString().equals(cVar.uN)) {
            cVar.uN = "";
        }
        cVar.uO = jSONObject.optString("currentPlayTime");
        if (JSONObject.NULL.toString().equals(cVar.uO)) {
            cVar.uO = "";
        }
    }

    private static JSONObject b(h.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (cVar.style != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "style", cVar.style);
        }
        if (cVar.title != null && !cVar.title.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "title", cVar.title);
        }
        if (cVar.uI != null && !cVar.uI.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "closeBtnText", cVar.uI);
        }
        if (cVar.uJ != null && !cVar.uJ.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "continueBtnText", cVar.uJ);
        }
        if (cVar.uK != null && !cVar.uK.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "viewDetailText", cVar.uK);
        }
        if (cVar.uL != null && !cVar.uL.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "unWatchedVideoTime", cVar.uL);
        }
        if (cVar.iconUrl != null && !cVar.iconUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "iconUrl", cVar.iconUrl);
        }
        if (cVar.uM != null && !cVar.uM.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, RemoteRewardActivity.JSON_BANNER_DESC_ID, cVar.uM);
        }
        if (cVar.uN != null && !cVar.uN.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "descTxt", cVar.uN);
        }
        if (cVar.uO != null && !cVar.uO.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "currentPlayTime", cVar.uO);
        }
        return jSONObject;
    }
}
