package com.kwad.sdk.live.audience.model;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KSLiveEndInfo {
    private static final String DISPLAY_LIKE_USER_COUNT = "likeUserCount";
    private static final String DISPLAY_WATCHING_USER_COUNT = "displayWatchingUserCount";
    private static final String LIKE_USER_COUNT = "likeUserCount";
    private static final String LIVE_DURATION = "liveDuration";
    private static final String TOTAL_WATCHING_DURATION = "totalWatchingDuration";
    private static final String WATCHING_USER_COUNT = "watchingUserCount";
    public String mDisplayLikeUserCount;
    public String mDisplayWatchingUserCount;
    public int mLikeUserCount;
    public long mLiveDuration;
    public long mTotalWatchingDuration;
    public int mWatchingUserCount;

    public static KSLiveEndInfo parseFromJson(String str) {
        JSONObject jSONObject = new JSONObject(str);
        KSLiveEndInfo kSLiveEndInfo = new KSLiveEndInfo();
        kSLiveEndInfo.mTotalWatchingDuration = jSONObject.optLong("totalWatchingDuration");
        kSLiveEndInfo.mWatchingUserCount = jSONObject.optInt("watchingUserCount");
        kSLiveEndInfo.mDisplayWatchingUserCount = jSONObject.optString("displayWatchingUserCount");
        kSLiveEndInfo.mLiveDuration = jSONObject.optLong("liveDuration");
        kSLiveEndInfo.mLikeUserCount = jSONObject.optInt("likeUserCount");
        kSLiveEndInfo.mDisplayLikeUserCount = jSONObject.optString("likeUserCount");
        return kSLiveEndInfo;
    }
}
