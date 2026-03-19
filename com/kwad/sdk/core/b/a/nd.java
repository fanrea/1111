package com.kwad.sdk.core.b.a;

import com.kwad.components.ct.response.model.tube.ChannelInfo;
import com.kwad.components.ct.response.model.tube.TubeChannel;
import com.kwad.components.ct.response.model.tube.TubeInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class nd implements com.kwad.sdk.core.d<TubeChannel> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((TubeChannel) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((TubeChannel) bVar, jSONObject);
    }

    private static void a(TubeChannel tubeChannel, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        tubeChannel.channelInfo = new ChannelInfo();
        tubeChannel.channelInfo.parseJson(jSONObject.optJSONObject("channelInfo"));
        tubeChannel.tubes = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("tubes");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                TubeInfo tubeInfo = new TubeInfo();
                tubeInfo.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                tubeChannel.tubes.add(tubeInfo);
            }
        }
    }

    private static JSONObject b(TubeChannel tubeChannel, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "channelInfo", tubeChannel.channelInfo);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "tubes", tubeChannel.tubes);
        return jSONObject;
    }
}
