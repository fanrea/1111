package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.bb;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ia implements com.kwad.sdk.core.d<bb.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((bb.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((bb.a) bVar, jSONObject);
    }

    private static void a(bb.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.status = jSONObject.optInt("status");
        aVar.totalWatchingDuration = jSONObject.optLong("totalWatchingDuration");
        aVar.watchingUserCount = jSONObject.optInt("watchingUserCount");
        aVar.displayWatchingUserCount = jSONObject.optString("displayWatchingUserCount");
        if (JSONObject.NULL.toString().equals(aVar.displayWatchingUserCount)) {
            aVar.displayWatchingUserCount = "";
        }
        aVar.liveDuration = jSONObject.optLong("liveDuration");
        aVar.likeUserCount = jSONObject.optInt("likeUserCount");
        aVar.displayLikeUserCount = jSONObject.optString("displayLikeUserCount");
        if (JSONObject.NULL.toString().equals(aVar.displayLikeUserCount)) {
            aVar.displayLikeUserCount = "";
        }
    }

    private static JSONObject b(bb.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.status != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "status", aVar.status);
        }
        if (aVar.totalWatchingDuration != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "totalWatchingDuration", aVar.totalWatchingDuration);
        }
        if (aVar.watchingUserCount != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "watchingUserCount", aVar.watchingUserCount);
        }
        if (aVar.displayWatchingUserCount != null && !aVar.displayWatchingUserCount.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "displayWatchingUserCount", aVar.displayWatchingUserCount);
        }
        if (aVar.liveDuration != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "liveDuration", aVar.liveDuration);
        }
        if (aVar.likeUserCount != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "likeUserCount", aVar.likeUserCount);
        }
        if (aVar.displayLikeUserCount != null && !aVar.displayLikeUserCount.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "displayLikeUserCount", aVar.displayLikeUserCount);
        }
        return jSONObject;
    }
}
