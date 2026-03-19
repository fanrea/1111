package com.kwad.sdk.core.b.a;

import com.kwad.components.ct.response.model.live.LiveInfo;
import com.kwad.sdk.live.audience.model.KSLiveUserInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class no implements com.kwad.sdk.core.d<LiveInfo.User> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((LiveInfo.User) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((LiveInfo.User) bVar, jSONObject);
    }

    private static void a(LiveInfo.User user, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        user.headurls = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(KSLiveUserInfo.KEY_HEAD_URLS);
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                LiveInfo.User.HeadUrl headUrl = new LiveInfo.User.HeadUrl();
                headUrl.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                user.headurls.add(headUrl);
            }
        }
        user.user_id = jSONObject.optLong("user_id");
        user.user_name = jSONObject.optString("user_name");
        if (JSONObject.NULL.toString().equals(user.user_name)) {
            user.user_name = "";
        }
    }

    private static JSONObject b(LiveInfo.User user, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, KSLiveUserInfo.KEY_HEAD_URLS, user.headurls);
        if (user.user_id != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "user_id", user.user_id);
        }
        if (user.user_name != null && !user.user_name.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "user_name", user.user_name);
        }
        return jSONObject;
    }
}
