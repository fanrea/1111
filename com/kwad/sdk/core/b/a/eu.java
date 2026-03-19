package com.kwad.sdk.core.b.a;

import com.kwad.components.ct.emotion.model.CDNUrl;
import com.kwad.components.ct.emotion.model.EmotionAuthor;
import com.kwad.components.ct.emotion.model.EmotionInfo;
import com.kwad.components.ct.emotion.model.EmotionPackage;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class eu implements com.kwad.sdk.core.d<EmotionPackage> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((EmotionPackage) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((EmotionPackage) bVar, jSONObject);
    }

    private static void a(EmotionPackage emotionPackage, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        emotionPackage.id = jSONObject.optString("id");
        if (JSONObject.NULL.toString().equals(emotionPackage.id)) {
            emotionPackage.id = "";
        }
        emotionPackage.name = jSONObject.optString("name");
        if (JSONObject.NULL.toString().equals(emotionPackage.name)) {
            emotionPackage.name = "";
        }
        emotionPackage.introduction = jSONObject.optString("introduction");
        if (JSONObject.NULL.toString().equals(emotionPackage.introduction)) {
            emotionPackage.introduction = "";
        }
        emotionPackage.description = jSONObject.optString("description");
        if (JSONObject.NULL.toString().equals(emotionPackage.description)) {
            emotionPackage.description = "";
        }
        emotionPackage.type = jSONObject.optInt("type");
        emotionPackage.style = jSONObject.optString("style");
        if (JSONObject.NULL.toString().equals(emotionPackage.style)) {
            emotionPackage.style = "";
        }
        emotionPackage.packageImageSmallUrl = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("packageImageSmallUrl");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                CDNUrl cDNUrl = new CDNUrl();
                cDNUrl.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                emotionPackage.packageImageSmallUrl.add(cDNUrl);
            }
        }
        emotionPackage.packageImageMiddleUrl = new ArrayList();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("packageImageMiddleUrl");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                CDNUrl cDNUrl2 = new CDNUrl();
                cDNUrl2.parseJson(jSONArrayOptJSONArray2.optJSONObject(i2));
                emotionPackage.packageImageMiddleUrl.add(cDNUrl2);
            }
        }
        emotionPackage.packageBannerUrl = new ArrayList();
        JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("packageBannerUrl");
        if (jSONArrayOptJSONArray3 != null) {
            for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                CDNUrl cDNUrl3 = new CDNUrl();
                cDNUrl3.parseJson(jSONArrayOptJSONArray3.optJSONObject(i3));
                emotionPackage.packageBannerUrl.add(cDNUrl3);
            }
        }
        emotionPackage.packageImageBigUrl = new ArrayList();
        JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("packageImageBigUrl");
        if (jSONArrayOptJSONArray4 != null) {
            for (int i4 = 0; i4 < jSONArrayOptJSONArray4.length(); i4++) {
                CDNUrl cDNUrl4 = new CDNUrl();
                cDNUrl4.parseJson(jSONArrayOptJSONArray4.optJSONObject(i4));
                emotionPackage.packageImageBigUrl.add(cDNUrl4);
            }
        }
        emotionPackage.packageDownloadUrl = new ArrayList();
        JSONArray jSONArrayOptJSONArray5 = jSONObject.optJSONArray("packageDownloadUrl");
        if (jSONArrayOptJSONArray5 != null) {
            for (int i5 = 0; i5 < jSONArrayOptJSONArray5.length(); i5++) {
                CDNUrl cDNUrl5 = new CDNUrl();
                cDNUrl5.parseJson(jSONArrayOptJSONArray5.optJSONObject(i5));
                emotionPackage.packageDownloadUrl.add(cDNUrl5);
            }
        }
        emotionPackage.emotionAuthor = new EmotionAuthor();
        emotionPackage.emotionAuthor.parseJson(jSONObject.optJSONObject("emotionAuthor"));
        emotionPackage.emotions = new ArrayList();
        JSONArray jSONArrayOptJSONArray6 = jSONObject.optJSONArray("emotions");
        if (jSONArrayOptJSONArray6 != null) {
            for (int i6 = 0; i6 < jSONArrayOptJSONArray6.length(); i6++) {
                EmotionInfo emotionInfo = new EmotionInfo();
                emotionInfo.parseJson(jSONArrayOptJSONArray6.optJSONObject(i6));
                emotionPackage.emotions.add(emotionInfo);
            }
        }
    }

    private static JSONObject b(EmotionPackage emotionPackage, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (emotionPackage.id != null && !emotionPackage.id.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "id", emotionPackage.id);
        }
        if (emotionPackage.name != null && !emotionPackage.name.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "name", emotionPackage.name);
        }
        if (emotionPackage.introduction != null && !emotionPackage.introduction.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "introduction", emotionPackage.introduction);
        }
        if (emotionPackage.description != null && !emotionPackage.description.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "description", emotionPackage.description);
        }
        if (emotionPackage.type != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "type", emotionPackage.type);
        }
        if (emotionPackage.style != null && !emotionPackage.style.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "style", emotionPackage.style);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "packageImageSmallUrl", emotionPackage.packageImageSmallUrl);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "packageImageMiddleUrl", emotionPackage.packageImageMiddleUrl);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "packageBannerUrl", emotionPackage.packageBannerUrl);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "packageImageBigUrl", emotionPackage.packageImageBigUrl);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "packageDownloadUrl", emotionPackage.packageDownloadUrl);
        com.kwad.sdk.utils.aa.a(jSONObject, "emotionAuthor", emotionPackage.emotionAuthor);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "emotions", emotionPackage.emotions);
        return jSONObject;
    }
}
