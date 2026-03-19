package com.kwad.components.ct.emotion.model;

import com.kwad.sdk.utils.aa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class EmotionPackage extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b, Serializable {
    public static final String KEY_EMOTION_PACKAGE_EXTRA_INFO = "extraInfo";
    private static final long serialVersionUID = 1381491558995019696L;
    public String description;
    public EmotionAuthor emotionAuthor;
    public List<EmotionInfo> emotions = new ArrayList();
    public Map<String, String> extraInfo;
    public String id;
    public String introduction;
    public String name;
    public List<CDNUrl> packageBannerUrl;
    public List<CDNUrl> packageDownloadUrl;
    public List<CDNUrl> packageImageBigUrl;
    public List<CDNUrl> packageImageMiddleUrl;
    public List<CDNUrl> packageImageSmallUrl;
    public String style;
    public int type;

    public String getId() {
        return this.id;
    }

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
