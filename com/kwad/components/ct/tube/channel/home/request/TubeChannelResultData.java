package com.kwad.components.ct.tube.channel.home.request;

import android.text.TextUtils;
import com.kwad.components.ct.response.model.tube.TubeChannel;
import com.kwad.components.ct.response.model.tube.TubeInfo;
import com.kwad.sdk.core.a.d;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ab;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class TubeChannelResultData extends BaseResultData implements com.kwad.sdk.core.b {
    private static final long serialVersionUID = 4200733339719277993L;
    public boolean hasMore;
    public String host;
    public SceneImpl mSceneImpl;
    public String title;
    public List<TubeInfo> lastWatchInfoList = new ArrayList();
    public List<TubeChannel> tubeChannelList = new ArrayList();
    public TubeChannel recommendTubeChannel = new TubeChannel();

    public TubeChannelResultData(SceneImpl sceneImpl) {
        this.mSceneImpl = sceneImpl;
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            this.host = jSONObject.optString("host");
            this.hasMore = jSONObject.optBoolean("hasMore");
            String responseData = d.getResponseData(jSONObject.optString("data"));
            if (TextUtils.isEmpty(responseData)) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject(responseData);
            this.title = jSONObject2.optString("title");
            this.lastWatchInfoList = ab.a("lastWatchInfoList", jSONObject2, new com.kwad.sdk.g.b<JSONObject, TubeInfo>() { // from class: com.kwad.components.ct.tube.channel.home.request.TubeChannelResultData.1
                @Override // com.kwad.sdk.g.b
                public final /* synthetic */ TubeInfo apply(JSONObject jSONObject3) {
                    return h(jSONObject3);
                }

                private static TubeInfo h(JSONObject jSONObject3) {
                    TubeInfo tubeInfo = new TubeInfo();
                    tubeInfo.parseJson(jSONObject3);
                    return tubeInfo;
                }
            });
            this.tubeChannelList = ab.a("tubeChannelList", jSONObject2, new com.kwad.sdk.g.b<JSONObject, TubeChannel>() { // from class: com.kwad.components.ct.tube.channel.home.request.TubeChannelResultData.2
                @Override // com.kwad.sdk.g.b
                public final /* synthetic */ TubeChannel apply(JSONObject jSONObject3) {
                    return i(jSONObject3);
                }

                private static TubeChannel i(JSONObject jSONObject3) {
                    TubeChannel tubeChannel = new TubeChannel();
                    tubeChannel.parseJson(jSONObject3);
                    return tubeChannel;
                }
            });
            this.recommendTubeChannel.parseJson(jSONObject2.optJSONObject("recommendTubeChannel"));
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        aa.putValue(json, "lastWatchInfoList", this.lastWatchInfoList);
        aa.putValue(json, "tubeChannelList", this.tubeChannelList);
        aa.a(json, "recommendTubeChannel", this.recommendTubeChannel);
        aa.putValue(json, "host", this.host);
        aa.putValue(json, "title", this.title);
        return json;
    }
}
