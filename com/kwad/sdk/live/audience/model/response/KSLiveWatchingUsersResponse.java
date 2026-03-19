package com.kwad.sdk.live.audience.model.response;

import com.kwad.sdk.live.audience.model.KSLiveUserInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KSLiveWatchingUsersResponse {
    private static final String CURRENT_USERS = "currentWatchingUsers";
    private static final int MIN_PENDING_DURATION_SEC = 3;
    private static final String PENDING_DURATION = "pendingDuration";
    private static final String P_CURSOR = "pcursor";
    private static final String SEQUENCE_ID = "sequenceId";
    private static final String WATCHING_COUNT = "watchingCount";
    public List<KSLiveUserInfo> mCurrentWatchingUsers = new ArrayList();
    public String mPCursor = "";
    public int mPendingDurationSec = 3;
    public String mSequenceId;
    public int mWatchingCount;

    public static KSLiveWatchingUsersResponse parseFromJson(String str) {
        JSONObject jSONObject = new JSONObject(str);
        KSLiveWatchingUsersResponse kSLiveWatchingUsersResponse = new KSLiveWatchingUsersResponse();
        kSLiveWatchingUsersResponse.mWatchingCount = jSONObject.optInt(WATCHING_COUNT);
        kSLiveWatchingUsersResponse.mPCursor = jSONObject.optString(P_CURSOR);
        kSLiveWatchingUsersResponse.mPendingDurationSec = Math.max(jSONObject.optInt(PENDING_DURATION), 3);
        kSLiveWatchingUsersResponse.mSequenceId = jSONObject.optString(SEQUENCE_ID);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(CURRENT_USERS);
        if (jSONArrayOptJSONArray != null) {
            kSLiveWatchingUsersResponse.mCurrentWatchingUsers = KSLiveUserInfo.parseFromJson(jSONArrayOptJSONArray);
        }
        return kSLiveWatchingUsersResponse;
    }
}
