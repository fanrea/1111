package com.kwad.sdk.core.b.a;

import com.kwad.components.ct.response.model.live.LiveInfo;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class gk implements com.kwad.sdk.core.d<LiveInfo.User.HeadUrl> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((LiveInfo.User.HeadUrl) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((LiveInfo.User.HeadUrl) bVar, jSONObject);
    }

    private static void a(LiveInfo.User.HeadUrl headUrl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        headUrl.cdn = jSONObject.optString("cdn");
        if (JSONObject.NULL.toString().equals(headUrl.cdn)) {
            headUrl.cdn = "";
        }
        headUrl.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(headUrl.url)) {
            headUrl.url = "";
        }
    }

    private static JSONObject b(LiveInfo.User.HeadUrl headUrl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (headUrl.cdn != null && !headUrl.cdn.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cdn", headUrl.cdn);
        }
        if (headUrl.url != null && !headUrl.url.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url", headUrl.url);
        }
        return jSONObject;
    }
}
