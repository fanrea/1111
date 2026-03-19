package com.kwad.sdk.live.audience.model;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KSLiveTopUser {
    public static final String KEY_USER_INFO = "userInfo";
    public KSLiveUserInfo mUserInfo;

    public static KSLiveTopUser parseFromJson(JSONObject jSONObject) {
        KSLiveTopUser kSLiveTopUser = new KSLiveTopUser();
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(KEY_USER_INFO);
        if (jSONObjectOptJSONObject != null) {
            kSLiveTopUser.mUserInfo = KSLiveUserInfo.parseFromJson(jSONObjectOptJSONObject);
        }
        return kSLiveTopUser;
    }

    public static List<KSLiveTopUser> parseFromJson(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                arrayList.add(parseFromJson(jSONObjectOptJSONObject));
            }
        }
        return arrayList;
    }
}
