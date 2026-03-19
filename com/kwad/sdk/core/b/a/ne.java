package com.kwad.sdk.core.b.a;

import com.kwad.components.ct.response.model.tube.TubeEpisode;
import com.kwad.components.ct.response.model.tube.TubeInfo;
import com.sigmob.sdk.base.mta.PointCategory;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ne implements com.kwad.sdk.core.d<TubeEpisode> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((TubeEpisode) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((TubeEpisode) bVar, jSONObject);
    }

    private static void a(TubeEpisode tubeEpisode, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        tubeEpisode.episodeName = jSONObject.optString("episodeName");
        if (JSONObject.NULL.toString().equals(tubeEpisode.episodeName)) {
            tubeEpisode.episodeName = "";
        }
        tubeEpisode.caption = jSONObject.optString("caption");
        if (JSONObject.NULL.toString().equals(tubeEpisode.caption)) {
            tubeEpisode.caption = "";
        }
        tubeEpisode.playCount = jSONObject.optLong("playCount");
        tubeEpisode.episodeNumber = jSONObject.optInt("episodeNumber");
        tubeEpisode.pcursor = jSONObject.optInt("pcursor");
        tubeEpisode.locked = jSONObject.optBoolean(PointCategory.LOCKED);
        tubeEpisode.tubeInfo = new TubeInfo();
        tubeEpisode.tubeInfo.parseJson(jSONObject.optJSONObject("tubeInfo"));
    }

    private static JSONObject b(TubeEpisode tubeEpisode, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (tubeEpisode.episodeName != null && !tubeEpisode.episodeName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "episodeName", tubeEpisode.episodeName);
        }
        if (tubeEpisode.caption != null && !tubeEpisode.caption.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "caption", tubeEpisode.caption);
        }
        if (tubeEpisode.playCount != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playCount", tubeEpisode.playCount);
        }
        if (tubeEpisode.episodeNumber != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "episodeNumber", tubeEpisode.episodeNumber);
        }
        if (tubeEpisode.pcursor != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pcursor", tubeEpisode.pcursor);
        }
        if (tubeEpisode.locked) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, PointCategory.LOCKED, tubeEpisode.locked);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "tubeInfo", tubeEpisode.tubeInfo);
        return jSONObject;
    }
}
