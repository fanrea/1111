package com.kwad.sdk.core.b.a;

import com.kwad.components.ct.response.model.live.LiveInfo;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ib implements com.kwad.sdk.core.d<LiveInfo.LiveStreamPlayCDNNode> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((LiveInfo.LiveStreamPlayCDNNode) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((LiveInfo.LiveStreamPlayCDNNode) bVar, jSONObject);
    }

    private static void a(LiveInfo.LiveStreamPlayCDNNode liveStreamPlayCDNNode, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        liveStreamPlayCDNNode.cdn = jSONObject.optString("cdn");
        if (JSONObject.NULL.toString().equals(liveStreamPlayCDNNode.cdn)) {
            liveStreamPlayCDNNode.cdn = "";
        }
        liveStreamPlayCDNNode.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(liveStreamPlayCDNNode.url)) {
            liveStreamPlayCDNNode.url = "";
        }
    }

    private static JSONObject b(LiveInfo.LiveStreamPlayCDNNode liveStreamPlayCDNNode, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (liveStreamPlayCDNNode.cdn != null && !liveStreamPlayCDNNode.cdn.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cdn", liveStreamPlayCDNNode.cdn);
        }
        if (liveStreamPlayCDNNode.url != null && !liveStreamPlayCDNNode.url.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url", liveStreamPlayCDNNode.url);
        }
        return jSONObject;
    }
}
