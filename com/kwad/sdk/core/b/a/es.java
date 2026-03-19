package com.kwad.sdk.core.b.a;

import com.kwad.components.ct.emotion.model.EmotionCode;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class es implements com.kwad.sdk.core.d<EmotionCode> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((EmotionCode) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((EmotionCode) bVar, jSONObject);
    }

    private static void a(EmotionCode emotionCode, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        emotionCode.language = jSONObject.optString("language");
        if (JSONObject.NULL.toString().equals(emotionCode.language)) {
            emotionCode.language = "";
        }
        emotionCode.codes = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("codes");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                emotionCode.codes.add((String) jSONArrayOptJSONArray.opt(i));
            }
        }
    }

    private static JSONObject b(EmotionCode emotionCode, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (emotionCode.language != null && !emotionCode.language.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "language", emotionCode.language);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "codes", emotionCode.codes);
        return jSONObject;
    }
}
