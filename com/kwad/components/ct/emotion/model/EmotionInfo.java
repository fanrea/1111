package com.kwad.components.ct.emotion.model;

import com.kwad.sdk.utils.aa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class EmotionInfo extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b, Serializable {
    public static final String KEY_EMOTION_INFO_EXTRA_INFO = "extraInfo";
    private static final long serialVersionUID = 8005337986172532989L;
    public List<EmotionCode> emotionCodes = new ArrayList();
    public List<CDNUrl> emotionImageBigUrl;
    public List<CDNUrl> emotionImageSmallUrl;
    public Map<String, String> extraInfo;
    public int height;
    public String id;
    public int mIndex;
    public int mPageIndex;
    public String name;
    public String packageId;
    public int type;
    public int width;

    @Override // com.kwad.sdk.core.response.a.a
    public void afterParseJson(JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.extraInfo = aa.parseJSON2MapString(jSONObject.optString("extraInfo"));
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        aa.putValue(jSONObject, "extraInfo", aa.parseMap2JSON(this.extraInfo));
    }
}
