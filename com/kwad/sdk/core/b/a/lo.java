package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class lo implements com.kwad.sdk.core.d<AdInfo.SmallAppJumpInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.SmallAppJumpInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.SmallAppJumpInfo) bVar, jSONObject);
    }

    private static void a(AdInfo.SmallAppJumpInfo smallAppJumpInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        smallAppJumpInfo.smallAppJumpUrl = jSONObject.optString("smallAppJumpUrl");
        if (JSONObject.NULL.toString().equals(smallAppJumpInfo.smallAppJumpUrl)) {
            smallAppJumpInfo.smallAppJumpUrl = "";
        }
        smallAppJumpInfo.originId = jSONObject.optString("originId");
        if (JSONObject.NULL.toString().equals(smallAppJumpInfo.originId)) {
            smallAppJumpInfo.originId = "";
        }
        smallAppJumpInfo.mediaSmallAppId = jSONObject.optString("mediaSmallAppId");
        if (JSONObject.NULL.toString().equals(smallAppJumpInfo.mediaSmallAppId)) {
            smallAppJumpInfo.mediaSmallAppId = "";
        }
    }

    private static JSONObject b(AdInfo.SmallAppJumpInfo smallAppJumpInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (smallAppJumpInfo.smallAppJumpUrl != null && !smallAppJumpInfo.smallAppJumpUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "smallAppJumpUrl", smallAppJumpInfo.smallAppJumpUrl);
        }
        if (smallAppJumpInfo.originId != null && !smallAppJumpInfo.originId.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "originId", smallAppJumpInfo.originId);
        }
        if (smallAppJumpInfo.mediaSmallAppId != null && !smallAppJumpInfo.mediaSmallAppId.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mediaSmallAppId", smallAppJumpInfo.mediaSmallAppId);
        }
        return jSONObject;
    }
}
