package com.kwad.sdk.live.audience.model.response;

import com.kwad.sdk.live.audience.model.KSLiveTopUser;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KSLiveTopUsersResponse {
    private static final String NO_GIFT = "noGift";
    private static final String NO_GIFT_TIPS = "noGiftTips";
    private static final String TOP_USERS = "topUsers";
    public boolean mNoGift;
    public String mNoGiftTips = "";
    public List<KSLiveTopUser> mTopUsers;

    public static KSLiveTopUsersResponse parseFromJson(String str) {
        JSONObject jSONObject = new JSONObject(str);
        KSLiveTopUsersResponse kSLiveTopUsersResponse = new KSLiveTopUsersResponse();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(TOP_USERS);
        if (jSONArrayOptJSONArray != null) {
            kSLiveTopUsersResponse.mTopUsers = KSLiveTopUser.parseFromJson(jSONArrayOptJSONArray);
        }
        kSLiveTopUsersResponse.mNoGift = jSONObject.optBoolean(NO_GIFT);
        kSLiveTopUsersResponse.mNoGiftTips = jSONObject.optString(NO_GIFT_TIPS);
        return kSLiveTopUsersResponse;
    }
}
