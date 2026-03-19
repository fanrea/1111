package com.kwad.components.ct.emotion.model;

import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.aa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class EmotionResponse extends BaseResultData implements com.kwad.sdk.core.b, Serializable {
    public static final String KEY_EMOTION_RESPONSE_LIST = "emotionPackageList";
    private static final long serialVersionUID = -5365732599060399342L;
    public List<EmotionPackage> mEmotionPackageList = new ArrayList();

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(KEY_EMOTION_RESPONSE_LIST);
        this.mEmotionPackageList.clear();
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                EmotionPackage emotionPackage = new EmotionPackage();
                emotionPackage.parseJson(jSONObjectOptJSONObject);
                this.mEmotionPackageList.add(emotionPackage);
            }
        }
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        aa.putValue(json, KEY_EMOTION_RESPONSE_LIST, this.mEmotionPackageList);
        return json;
    }
}
