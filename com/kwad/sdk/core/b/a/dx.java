package com.kwad.sdk.core.b.a;

import com.ss.texturerender.TextureRenderKeys;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class dx implements com.kwad.sdk.core.d<com.kwad.components.ct.e.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ct.e.c) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ct.e.c) bVar, jSONObject);
    }

    private static void a(com.kwad.components.ct.e.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.aTv = jSONObject.optLong("startDuration");
        cVar.aTw = jSONObject.optLong("stayDuration");
        cVar.aTx = jSONObject.optLong("stayLength");
        cVar.tabName = jSONObject.optString("tabName");
        if (JSONObject.NULL.toString().equals(cVar.tabName)) {
            cVar.tabName = "";
        }
        cVar.aTy = jSONObject.optInt("nextPageType");
        cVar.aTz = jSONObject.optInt("enterType");
        cVar.aTA = jSONObject.optInt("leaveType");
        cVar.aTC = jSONObject.optInt("likeStatus");
        cVar.aTD = jSONObject.optInt("playEnd");
        cVar.aTE = jSONObject.optInt("dragProgressType");
        cVar.aTF = jSONObject.optLong("dragProgressPhotoDuration");
        cVar.aTG = jSONObject.optLong("dragProgressVideoTime");
        cVar.aTH = jSONObject.optInt("likeType");
        cVar.aTJ = jSONObject.optInt("shareResult");
        cVar.coverUrl = jSONObject.optString("coverUrl");
        if (JSONObject.NULL.toString().equals(cVar.coverUrl)) {
            cVar.coverUrl = "";
        }
        cVar.aTK = jSONObject.optString("videoCurrentUrl");
        if (JSONObject.NULL.toString().equals(cVar.aTK)) {
            cVar.aTK = "";
        }
        cVar.entryId = jSONObject.optString("entryId");
        if (JSONObject.NULL.toString().equals(cVar.entryId)) {
            cVar.entryId = "";
        }
        cVar.aTL = jSONObject.optString("pushUrl");
        if (JSONObject.NULL.toString().equals(cVar.aTL)) {
            cVar.aTL = "";
        }
        cVar.aTM = jSONObject.optLong("commentId");
        cVar.aTN = jSONObject.optLong("seenCount");
        cVar.aTO = jSONObject.optInt("clickType");
        cVar.aTP = jSONObject.optInt("buttonPictureClick");
        cVar.recoExt = jSONObject.optString("recoExt");
        if (JSONObject.NULL.toString().equals(cVar.recoExt)) {
            cVar.recoExt = "";
        }
        cVar.tubeName = jSONObject.optString("tubeName");
        if (JSONObject.NULL.toString().equals(cVar.tubeName)) {
            cVar.tubeName = "";
        }
        cVar.tubeId = jSONObject.optLong("tubeId");
        cVar.aTQ = jSONObject.optBoolean("tubeLocked");
        cVar.aTR = jSONObject.optInt("contentAdSource");
        cVar.episodeName = jSONObject.optString("episodeName");
        if (JSONObject.NULL.toString().equals(cVar.episodeName)) {
            cVar.episodeName = "";
        }
        cVar.episodeNumber = jSONObject.optInt("episodeNumber");
        cVar.aTS = jSONObject.optString("trendName");
        if (JSONObject.NULL.toString().equals(cVar.aTS)) {
            cVar.aTS = "";
        }
        cVar.aTT = jSONObject.optString("channelType");
        if (JSONObject.NULL.toString().equals(cVar.aTT)) {
            cVar.aTT = "";
        }
        cVar.aTU = jSONObject.optInt("orderId");
        cVar.aTV = jSONObject.optInt("deployId");
        cVar.aTW = jSONObject.optLong("albumId");
        cVar.aTX = jSONObject.optInt("albumNum");
        cVar.trendId = jSONObject.optLong("trendId");
        cVar.aTZ = jSONObject.optLong("relatedContentSourceType");
        cVar.aUa = jSONObject.optInt("adHorizontalFeedType");
        cVar.aUb = jSONObject.optInt("videoPlayMode");
        cVar.aUc = jSONObject.optInt("autoReplayTimes");
        cVar.closeType = jSONObject.optInt("closeType");
        cVar.preloadType = jSONObject.optInt("preloadType");
        cVar.aUd = jSONObject.optJSONArray("preloadPhotoList");
        cVar.aUe = jSONObject.optString(TextureRenderKeys.KEY_MODULE_NAME);
        if (JSONObject.NULL.toString().equals(cVar.aUe)) {
            cVar.aUe = "";
        }
        cVar.aUf = jSONObject.optInt("playAgainControlledType");
        cVar.aUg = jSONObject.optString("mediaShareStr");
        if (JSONObject.NULL.toString().equals(cVar.aUg)) {
            cVar.aUg = "";
        }
        cVar.aUh = jSONObject.optInt("entryRealRefresh");
        cVar.aUi = jSONObject.optInt("couponStatus");
        cVar.aUj = jSONObject.optDouble("readPct");
        cVar.aUk = jSONObject.optString("lostReason");
        if (JSONObject.NULL.toString().equals(cVar.aUk)) {
            cVar.aUk = "";
        }
        cVar.aUl = jSONObject.optInt("photoType");
        cVar.aUm = jSONObject.optInt("tubeRenderType");
    }

    private static JSONObject b(com.kwad.components.ct.e.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (cVar.aTv != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "startDuration", cVar.aTv);
        }
        if (cVar.aTw != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "stayDuration", cVar.aTw);
        }
        if (cVar.aTx != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "stayLength", cVar.aTx);
        }
        if (cVar.tabName != null && !cVar.tabName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "tabName", cVar.tabName);
        }
        if (cVar.aTy != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "nextPageType", cVar.aTy);
        }
        if (cVar.aTz != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "enterType", cVar.aTz);
        }
        if (cVar.aTA != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "leaveType", cVar.aTA);
        }
        if (cVar.aTC != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "likeStatus", cVar.aTC);
        }
        if (cVar.aTD != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playEnd", cVar.aTD);
        }
        if (cVar.aTE != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "dragProgressType", cVar.aTE);
        }
        if (cVar.aTF != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "dragProgressPhotoDuration", cVar.aTF);
        }
        if (cVar.aTG != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "dragProgressVideoTime", cVar.aTG);
        }
        if (cVar.aTH != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "likeType", cVar.aTH);
        }
        if (cVar.aTJ != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "shareResult", cVar.aTJ);
        }
        if (cVar.coverUrl != null && !cVar.coverUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "coverUrl", cVar.coverUrl);
        }
        if (cVar.aTK != null && !cVar.aTK.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "videoCurrentUrl", cVar.aTK);
        }
        if (cVar.entryId != null && !cVar.entryId.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "entryId", cVar.entryId);
        }
        if (cVar.aTL != null && !cVar.aTL.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pushUrl", cVar.aTL);
        }
        if (cVar.aTM != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "commentId", cVar.aTM);
        }
        if (cVar.aTN != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "seenCount", cVar.aTN);
        }
        if (cVar.aTO != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "clickType", cVar.aTO);
        }
        if (cVar.aTP != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "buttonPictureClick", cVar.aTP);
        }
        if (cVar.recoExt != null && !cVar.recoExt.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "recoExt", cVar.recoExt);
        }
        if (cVar.tubeName != null && !cVar.tubeName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "tubeName", cVar.tubeName);
        }
        if (cVar.tubeId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "tubeId", cVar.tubeId);
        }
        if (cVar.aTQ) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "tubeLocked", cVar.aTQ);
        }
        if (cVar.aTR != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "contentAdSource", cVar.aTR);
        }
        if (cVar.episodeName != null && !cVar.episodeName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "episodeName", cVar.episodeName);
        }
        if (cVar.episodeNumber != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "episodeNumber", cVar.episodeNumber);
        }
        if (cVar.aTS != null && !cVar.aTS.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "trendName", cVar.aTS);
        }
        if (cVar.aTT != null && !cVar.aTT.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "channelType", cVar.aTT);
        }
        if (cVar.aTU != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "orderId", cVar.aTU);
        }
        if (cVar.aTV != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deployId", cVar.aTV);
        }
        if (cVar.aTW != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "albumId", cVar.aTW);
        }
        if (cVar.aTX != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "albumNum", cVar.aTX);
        }
        if (cVar.trendId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "trendId", cVar.trendId);
        }
        if (cVar.aTZ != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "relatedContentSourceType", cVar.aTZ);
        }
        if (cVar.aUa != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adHorizontalFeedType", cVar.aUa);
        }
        if (cVar.aUb != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "videoPlayMode", cVar.aUb);
        }
        if (cVar.aUc != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "autoReplayTimes", cVar.aUc);
        }
        if (cVar.closeType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "closeType", cVar.closeType);
        }
        if (cVar.preloadType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "preloadType", cVar.preloadType);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "preloadPhotoList", cVar.aUd);
        if (cVar.aUe != null && !cVar.aUe.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, TextureRenderKeys.KEY_MODULE_NAME, cVar.aUe);
        }
        if (cVar.aUf != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playAgainControlledType", cVar.aUf);
        }
        if (cVar.aUg != null && !cVar.aUg.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mediaShareStr", cVar.aUg);
        }
        if (cVar.aUh != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "entryRealRefresh", cVar.aUh);
        }
        if (cVar.aUi != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "couponStatus", cVar.aUi);
        }
        if (cVar.aUj != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "readPct", cVar.aUj);
        }
        if (cVar.aUk != null && !cVar.aUk.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "lostReason", cVar.aUk);
        }
        if (cVar.aUl != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "photoType", cVar.aUl);
        }
        if (cVar.aUm != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "tubeRenderType", cVar.aUm);
        }
        return jSONObject;
    }
}
