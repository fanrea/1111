package com.kwad.sdk.core.b.a;

import com.kwad.components.ct.response.model.tube.TubeInfo;
import com.kwad.sdk.core.scene.URLPackage;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class nf implements com.kwad.sdk.core.d<TubeInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((TubeInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((TubeInfo) bVar, jSONObject);
    }

    private static void a(TubeInfo tubeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        tubeInfo.pcursor = jSONObject.optInt("pcursor");
        tubeInfo.name = jSONObject.optString("name");
        if (JSONObject.NULL.toString().equals(tubeInfo.name)) {
            tubeInfo.name = "";
        }
        tubeInfo.tubeId = jSONObject.optLong("tubeId");
        tubeInfo.authorId = jSONObject.optLong(URLPackage.KEY_AUTHOR_ID);
        tubeInfo.authorName = jSONObject.optString("authorName");
        if (JSONObject.NULL.toString().equals(tubeInfo.authorName)) {
            tubeInfo.authorName = "";
        }
        tubeInfo.tagList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("tagList");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                tubeInfo.tagList.add((String) jSONArrayOptJSONArray.opt(i));
            }
        }
        tubeInfo.lastEpisodeNum = jSONObject.optInt("lastEpisodeNum");
        tubeInfo.totalEpisodeSize = jSONObject.optInt("totalEpisodeSize");
        tubeInfo.lastEpisodeName = jSONObject.optString("lastEpisodeName");
        if (JSONObject.NULL.toString().equals(tubeInfo.lastEpisodeName)) {
            tubeInfo.lastEpisodeName = "";
        }
        tubeInfo.viewCount = jSONObject.optInt("viewCount");
        tubeInfo.coverUrl = jSONObject.optString("coverUrl");
        if (JSONObject.NULL.toString().equals(tubeInfo.coverUrl)) {
            tubeInfo.coverUrl = "";
        }
        tubeInfo.recoReason = jSONObject.optString("recoReason");
        if (JSONObject.NULL.toString().equals(tubeInfo.recoReason)) {
            tubeInfo.recoReason = "";
        }
        tubeInfo.isFinished = jSONObject.optBoolean("isFinished");
        tubeInfo.summary = jSONObject.optString("summary");
        if (JSONObject.NULL.toString().equals(tubeInfo.summary)) {
            tubeInfo.summary = "";
        }
        tubeInfo.lastWatchTime = jSONObject.optLong("lastWatchTime");
        tubeInfo.watchEpisodeNum = jSONObject.optInt("watchEpisodeNum");
        tubeInfo.nextLockedEpisodeNum = jSONObject.optInt("unlockEpisodeNum");
        tubeInfo.freeEpisodeCount = jSONObject.optInt("freeEpisodeCount");
        tubeInfo.unlockEpisodeCount = jSONObject.optInt("unlockEpisodeCount");
        tubeInfo.viewCountHide = jSONObject.optBoolean("viewCountHide");
        tubeInfo.secondChannelName = jSONObject.optString("secondChannelName");
        if (JSONObject.NULL.toString().equals(tubeInfo.secondChannelName)) {
            tubeInfo.secondChannelName = "";
        }
        tubeInfo.episodeNumberList = new ArrayList();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("episodeNumberList");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                tubeInfo.episodeNumberList.add((Integer) jSONArrayOptJSONArray2.opt(i2));
            }
        }
    }

    private static JSONObject b(TubeInfo tubeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (tubeInfo.pcursor != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pcursor", tubeInfo.pcursor);
        }
        if (tubeInfo.name != null && !tubeInfo.name.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "name", tubeInfo.name);
        }
        if (tubeInfo.tubeId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "tubeId", tubeInfo.tubeId);
        }
        if (tubeInfo.authorId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, URLPackage.KEY_AUTHOR_ID, tubeInfo.authorId);
        }
        if (tubeInfo.authorName != null && !tubeInfo.authorName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "authorName", tubeInfo.authorName);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "tagList", tubeInfo.tagList);
        if (tubeInfo.lastEpisodeNum != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "lastEpisodeNum", tubeInfo.lastEpisodeNum);
        }
        if (tubeInfo.totalEpisodeSize != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "totalEpisodeSize", tubeInfo.totalEpisodeSize);
        }
        if (tubeInfo.lastEpisodeName != null && !tubeInfo.lastEpisodeName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "lastEpisodeName", tubeInfo.lastEpisodeName);
        }
        if (tubeInfo.viewCount != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "viewCount", tubeInfo.viewCount);
        }
        if (tubeInfo.coverUrl != null && !tubeInfo.coverUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "coverUrl", tubeInfo.coverUrl);
        }
        if (tubeInfo.recoReason != null && !tubeInfo.recoReason.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "recoReason", tubeInfo.recoReason);
        }
        if (tubeInfo.isFinished) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isFinished", tubeInfo.isFinished);
        }
        if (tubeInfo.summary != null && !tubeInfo.summary.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "summary", tubeInfo.summary);
        }
        if (tubeInfo.lastWatchTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "lastWatchTime", tubeInfo.lastWatchTime);
        }
        if (tubeInfo.watchEpisodeNum != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "watchEpisodeNum", tubeInfo.watchEpisodeNum);
        }
        if (tubeInfo.nextLockedEpisodeNum != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "unlockEpisodeNum", tubeInfo.nextLockedEpisodeNum);
        }
        if (tubeInfo.freeEpisodeCount != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "freeEpisodeCount", tubeInfo.freeEpisodeCount);
        }
        if (tubeInfo.unlockEpisodeCount != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "unlockEpisodeCount", tubeInfo.unlockEpisodeCount);
        }
        if (tubeInfo.viewCountHide) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "viewCountHide", tubeInfo.viewCountHide);
        }
        if (tubeInfo.secondChannelName != null && !tubeInfo.secondChannelName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "secondChannelName", tubeInfo.secondChannelName);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "episodeNumberList", tubeInfo.episodeNumberList);
        return jSONObject;
    }
}
