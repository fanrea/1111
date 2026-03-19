package com.kwad.sdk.core.b.a;

import com.kwad.components.core.video.a.d;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class nt implements com.kwad.sdk.core.d<d.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((d.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((d.b) bVar, jSONObject);
    }

    private static void a(d.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.ads = jSONObject.optLong("start_play_duration_ms");
        bVar.adt = jSONObject.optLong("first_frame_duration_ms");
        bVar.adu = jSONObject.optLong("block_total_duration_ms");
        bVar.videoDuration = jSONObject.optLong("video_duration_ms");
        bVar.ada = jSONObject.optInt("block_times");
        bVar.videoUrl = jSONObject.optString("video_url");
        if (JSONObject.NULL.toString().equals(bVar.videoUrl)) {
            bVar.videoUrl = "";
        }
        bVar.llsid = jSONObject.optLong("llsid");
        bVar.creativeId = jSONObject.optLong("creative_id");
        bVar.authorId = jSONObject.optLong("ad_info_uid");
        bVar.authorName = jSONObject.optString("ad_info_user_name");
        if (JSONObject.NULL.toString().equals(bVar.authorName)) {
            bVar.authorName = "";
        }
        bVar.adStyle = jSONObject.optInt("ad_style");
        bVar.adr = jSONObject.optInt("ad_media_player_type");
    }

    private static JSONObject b(d.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.ads != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "start_play_duration_ms", bVar.ads);
        }
        if (bVar.adt != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "first_frame_duration_ms", bVar.adt);
        }
        if (bVar.adu != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "block_total_duration_ms", bVar.adu);
        }
        if (bVar.videoDuration != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "video_duration_ms", bVar.videoDuration);
        }
        if (bVar.ada != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "block_times", bVar.ada);
        }
        if (bVar.videoUrl != null && !bVar.videoUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "video_url", bVar.videoUrl);
        }
        if (bVar.llsid != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "llsid", bVar.llsid);
        }
        if (bVar.creativeId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creative_id", bVar.creativeId);
        }
        if (bVar.authorId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_info_uid", bVar.authorId);
        }
        if (bVar.authorName != null && !bVar.authorName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_info_user_name", bVar.authorName);
        }
        if (bVar.adStyle != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_style", bVar.adStyle);
        }
        if (bVar.adr != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_media_player_type", bVar.adr);
        }
        return jSONObject;
    }
}
