package com.kwad.sdk.live.audience.model;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KSLiveUserInfo {
    public static final String KEY_HEAD_URLS = "headurls";
    public List<KSLiveCDNUrl> mHeadUrls = new ArrayList();

    public static KSLiveUserInfo parseFromJson(JSONObject jSONObject) {
        KSLiveUserInfo kSLiveUserInfo = new KSLiveUserInfo();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(KEY_HEAD_URLS);
        if (jSONArrayOptJSONArray != null) {
            kSLiveUserInfo.mHeadUrls = KSLiveCDNUrl.parseFromJson(jSONArrayOptJSONArray);
        }
        return kSLiveUserInfo;
    }

    public static List<KSLiveUserInfo> parseFromJson(JSONArray jSONArray) {
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
