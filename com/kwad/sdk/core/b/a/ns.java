package com.kwad.sdk.core.b.a;

import com.kwad.components.core.video.a.d;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ns implements com.kwad.sdk.core.d<d.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((d.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((d.a) bVar, jSONObject);
    }

    private static void a(d.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.code = jSONObject.optInt("code");
        aVar.msg = jSONObject.optString("msg");
        if (JSONObject.NULL.toString().equals(aVar.msg)) {
            aVar.msg = "";
        }
        aVar.videoUrl = jSONObject.optString("video_url");
        if (JSONObject.NULL.toString().equals(aVar.videoUrl)) {
            aVar.videoUrl = "";
        }
        aVar.llsid = jSONObject.optLong("llsid");
        aVar.creativeId = jSONObject.optLong("creative_id");
        aVar.authorId = jSONObject.optLong("ad_info_uid");
        aVar.authorName = jSONObject.optString("ad_info_user_name");
        if (JSONObject.NULL.toString().equals(aVar.authorName)) {
            aVar.authorName = "";
        }
        aVar.adr = jSONObject.optInt("ad_media_player_type");
    }

    private static JSONObject b(d.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.code != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "code", aVar.code);
        }
        if (aVar.msg != null && !aVar.msg.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "msg", aVar.msg);
        }
        if (aVar.videoUrl != null && !aVar.videoUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "video_url", aVar.videoUrl);
        }
        if (aVar.llsid != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "llsid", aVar.llsid);
        }
        if (aVar.creativeId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creative_id", aVar.creativeId);
        }
        if (aVar.authorId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_info_uid", aVar.authorId);
        }
        if (aVar.authorName != null && !aVar.authorName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_info_user_name", aVar.authorName);
        }
        if (aVar.adr != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_media_player_type", aVar.adr);
        }
        return jSONObject;
    }
}
