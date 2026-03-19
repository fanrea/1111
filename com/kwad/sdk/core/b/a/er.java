package com.kwad.sdk.core.b.a;

import com.kwad.components.ct.emotion.model.EmotionAuthor;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class er implements com.kwad.sdk.core.d<EmotionAuthor> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((EmotionAuthor) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((EmotionAuthor) bVar, jSONObject);
    }

    private static void a(EmotionAuthor emotionAuthor, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        emotionAuthor.id = jSONObject.optString("id");
        if (JSONObject.NULL.toString().equals(emotionAuthor.id)) {
            emotionAuthor.id = "";
        }
        emotionAuthor.name = jSONObject.optString("name");
        if (JSONObject.NULL.toString().equals(emotionAuthor.name)) {
            emotionAuthor.name = "";
        }
        emotionAuthor.userHead = jSONObject.optString("userHead");
        if (JSONObject.NULL.toString().equals(emotionAuthor.userHead)) {
            emotionAuthor.userHead = "";
        }
        emotionAuthor.userDesc = jSONObject.optString("userDesc");
        if (JSONObject.NULL.toString().equals(emotionAuthor.userDesc)) {
            emotionAuthor.userDesc = "";
        }
        emotionAuthor.followed = jSONObject.optString("followed");
        if (JSONObject.NULL.toString().equals(emotionAuthor.followed)) {
            emotionAuthor.followed = "";
        }
    }

    private static JSONObject b(EmotionAuthor emotionAuthor, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (emotionAuthor.id != null && !emotionAuthor.id.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "id", emotionAuthor.id);
        }
        if (emotionAuthor.name != null && !emotionAuthor.name.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "name", emotionAuthor.name);
        }
        if (emotionAuthor.userHead != null && !emotionAuthor.userHead.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "userHead", emotionAuthor.userHead);
        }
        if (emotionAuthor.userDesc != null && !emotionAuthor.userDesc.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "userDesc", emotionAuthor.userDesc);
        }
        if (emotionAuthor.followed != null && !emotionAuthor.followed.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "followed", emotionAuthor.followed);
        }
        return jSONObject;
    }
}
