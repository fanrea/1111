package com.kwad.sdk.core.b.a;

import com.kwad.components.ct.emotion.model.CDNUrl;
import com.kwad.components.ct.emotion.model.EmotionCode;
import com.kwad.components.ct.emotion.model.EmotionInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class et implements com.kwad.sdk.core.d<EmotionInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((EmotionInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((EmotionInfo) bVar, jSONObject);
    }

    private static void a(EmotionInfo emotionInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        emotionInfo.id = jSONObject.optString("id");
        if (JSONObject.NULL.toString().equals(emotionInfo.id)) {
            emotionInfo.id = "";
        }
        emotionInfo.name = jSONObject.optString("name");
        if (JSONObject.NULL.toString().equals(emotionInfo.name)) {
            emotionInfo.name = "";
        }
        emotionInfo.type = jSONObject.optInt("type");
        emotionInfo.packageId = jSONObject.optString("packageId");
        if (JSONObject.NULL.toString().equals(emotionInfo.packageId)) {
            emotionInfo.packageId = "";
        }
        emotionInfo.emotionImageSmallUrl = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("emotionImageSmallUrl");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                CDNUrl cDNUrl = new CDNUrl();
                cDNUrl.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                emotionInfo.emotionImageSmallUrl.add(cDNUrl);
            }
        }
        emotionInfo.emotionImageBigUrl = new ArrayList();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("emotionImageBigUrl");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                CDNUrl cDNUrl2 = new CDNUrl();
                cDNUrl2.parseJson(jSONArrayOptJSONArray2.optJSONObject(i2));
                emotionInfo.emotionImageBigUrl.add(cDNUrl2);
            }
        }
        emotionInfo.emotionCodes = new ArrayList();
        JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("emotionCodes");
        if (jSONArrayOptJSONArray3 != null) {
            for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                EmotionCode emotionCode = new EmotionCode();
                emotionCode.parseJson(jSONArrayOptJSONArray3.optJSONObject(i3));
                emotionInfo.emotionCodes.add(emotionCode);
            }
        }
        emotionInfo.width = jSONObject.optInt("width");
        emotionInfo.height = jSONObject.optInt("height");
        emotionInfo.mPageIndex = jSONObject.optInt("mPageIndex");
        emotionInfo.mIndex = jSONObject.optInt("mIndex");
    }

    private static JSONObject b(EmotionInfo emotionInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (emotionInfo.id != null && !emotionInfo.id.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "id", emotionInfo.id);
        }
        if (emotionInfo.name != null && !emotionInfo.name.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "name", emotionInfo.name);
        }
        if (emotionInfo.type != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "type", emotionInfo.type);
        }
        if (emotionInfo.packageId != null && !emotionInfo.packageId.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "packageId", emotionInfo.packageId);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "emotionImageSmallUrl", emotionInfo.emotionImageSmallUrl);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "emotionImageBigUrl", emotionInfo.emotionImageBigUrl);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "emotionCodes", emotionInfo.emotionCodes);
        if (emotionInfo.width != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "width", emotionInfo.width);
        }
        if (emotionInfo.height != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "height", emotionInfo.height);
        }
        if (emotionInfo.mPageIndex != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mPageIndex", emotionInfo.mPageIndex);
        }
        if (emotionInfo.mIndex != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mIndex", emotionInfo.mIndex);
        }
        return jSONObject;
    }
}
