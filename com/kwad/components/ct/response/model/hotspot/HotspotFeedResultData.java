package com.kwad.components.ct.response.model.hotspot;

import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.core.a.d;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.aa;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class HotspotFeedResultData extends BaseResultData implements b {
    private static final String TAG = "TrendsResultData";
    private static final long serialVersionUID = -1619392774105464372L;
    public List<CtAdTemplate> adTemplateList = new ArrayList();
    private final HotspotInfo mHotspotInfo;
    private final SceneImpl mScene;

    public HotspotFeedResultData(SceneImpl sceneImpl, HotspotInfo hotspotInfo) {
        this.mScene = sceneImpl;
        this.mHotspotInfo = hotspotInfo;
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(d.getResponseData(jSONObject.optString("data")));
            long jOptLong = jSONObject2.optLong("llsid");
            String strOptString = jSONObject2.optString("extra");
            JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray("feeds");
            if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                return;
            }
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    CtAdTemplate ctAdTemplate = new CtAdTemplate();
                    ctAdTemplate.parseJson(jSONObjectOptJSONObject);
                    ctAdTemplate.llsid = jOptLong;
                    ctAdTemplate.extra = strOptString;
                    ctAdTemplate.photoInfo.mHotspotInfo = this.mHotspotInfo;
                    ctAdTemplate.mAdScene = this.mScene;
                    this.adTemplateList.add(ctAdTemplate);
                }
            }
        } catch (Exception e) {
            c.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        aa.putValue(json, "impAdInfo", this.adTemplateList);
        return json;
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData
    public boolean isDataEmpty() {
        if (!this.adTemplateList.isEmpty()) {
            return false;
        }
        c.e(TAG, "adTemplateList is empty");
        return true;
    }
}
