package com.kwad.sdk.core.b.a;

import com.kwad.components.ct.response.model.tube.ChannelInfo;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class cj implements com.kwad.sdk.core.d<ChannelInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((ChannelInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((ChannelInfo) bVar, jSONObject);
    }

    private static void a(ChannelInfo channelInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        channelInfo.channelId = jSONObject.optInt("channelId");
        channelInfo.channelName = jSONObject.optString("channelName");
        if (JSONObject.NULL.toString().equals(channelInfo.channelName)) {
            channelInfo.channelName = "";
        }
        channelInfo.channelAlias = jSONObject.optString("channelAlias");
        if (JSONObject.NULL.toString().equals(channelInfo.channelAlias)) {
            channelInfo.channelAlias = "";
        }
        channelInfo.channelLevel = jSONObject.optInt("channelLevel");
        channelInfo.parentId = jSONObject.optInt("parentId");
        channelInfo.channelIconUrl = jSONObject.optString("channelIconUrl");
        if (JSONObject.NULL.toString().equals(channelInfo.channelIconUrl)) {
            channelInfo.channelIconUrl = "";
        }
    }

    private static JSONObject b(ChannelInfo channelInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (channelInfo.channelId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "channelId", channelInfo.channelId);
        }
        if (channelInfo.channelName != null && !channelInfo.channelName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "channelName", channelInfo.channelName);
        }
        if (channelInfo.channelAlias != null && !channelInfo.channelAlias.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "channelAlias", channelInfo.channelAlias);
        }
        if (channelInfo.channelLevel != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "channelLevel", channelInfo.channelLevel);
        }
        if (channelInfo.parentId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "parentId", channelInfo.parentId);
        }
        if (channelInfo.channelIconUrl != null && !channelInfo.channelIconUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "channelIconUrl", channelInfo.channelIconUrl);
        }
        return jSONObject;
    }
}
