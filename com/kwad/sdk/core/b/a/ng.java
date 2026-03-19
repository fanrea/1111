package com.kwad.sdk.core.b.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ng implements com.kwad.sdk.core.d<com.kwad.components.ct.tube.channel.home.request.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ct.tube.channel.home.request.c) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ct.tube.channel.home.request.c) bVar, jSONObject);
    }

    private static void a(com.kwad.components.ct.tube.channel.home.request.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.tubeId = jSONObject.optLong("tubeId");
        cVar.aWM = jSONObject.optInt("pcount");
        cVar.pcursor = jSONObject.optInt("pcursor");
        cVar.freeEpisodeCount = jSONObject.optInt("freeEpisodeCount");
        cVar.unlockEpisodeCount = jSONObject.optInt("unlockEpisodeCount");
        cVar.watchEpisodeNum = jSONObject.optInt("watchEpisodeNum");
        cVar.unlockEpisodeNum = jSONObject.optInt("unlockEpisodeNum");
        cVar.aWN = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("tubeIdList");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                cVar.aWN.add((Long) jSONArrayOptJSONArray.opt(i));
            }
        }
        cVar.aUm = jSONObject.optInt("tubeRenderType");
    }

    private static JSONObject b(com.kwad.components.ct.tube.channel.home.request.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (cVar.tubeId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "tubeId", cVar.tubeId);
        }
        if (cVar.aWM != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pcount", cVar.aWM);
        }
        if (cVar.pcursor != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pcursor", cVar.pcursor);
        }
        if (cVar.freeEpisodeCount != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "freeEpisodeCount", cVar.freeEpisodeCount);
        }
        if (cVar.unlockEpisodeCount != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "unlockEpisodeCount", cVar.unlockEpisodeCount);
        }
        if (cVar.watchEpisodeNum != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "watchEpisodeNum", cVar.watchEpisodeNum);
        }
        if (cVar.unlockEpisodeNum != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "unlockEpisodeNum", cVar.unlockEpisodeNum);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "tubeIdList", cVar.aWN);
        if (cVar.aUm != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "tubeRenderType", cVar.aUm);
        }
        return jSONObject;
    }
}
