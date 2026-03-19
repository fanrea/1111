package com.kwad.components.ct.tube.channel.detail.request;

import android.text.TextUtils;
import com.kwad.components.ct.response.model.tube.TubeInfo;
import com.kwad.sdk.core.a.d;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.aa;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ChannelDetailResultData extends BaseResultData implements com.kwad.sdk.core.b {
    private static final long serialVersionUID = 3588223308169644635L;
    public boolean hasMore;
    public String host;
    public SceneImpl mSceneImpl;
    public List<TubeInfo> tubes = new ArrayList();

    public ChannelDetailResultData(SceneImpl sceneImpl) {
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
            JSONArray jSONArray = new JSONArray(responseData);
            if (jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        TubeInfo tubeInfo = new TubeInfo();
                        tubeInfo.parseJson(jSONObjectOptJSONObject);
                        this.tubes.add(tubeInfo);
                    }
                }
            }
        } catch (Exception e) {
            c.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        aa.putValue(json, "tubes", this.tubes);
        aa.putValue(json, "host", this.host);
        aa.putValue(json, "hasMore", this.hasMore);
        return json;
    }
}
