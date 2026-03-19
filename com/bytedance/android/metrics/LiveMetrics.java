package com.bytedance.android.metrics;

import com.bytedance.sdk.component.utils.mq;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class LiveMetrics {
    public static final String EVENT_LIVESDK_LIVE_SHOW = "tobsdk_livesdk_live_show";
    public static final String EVENT_LIVESDK_LIVE_WINDOW_DURATION_V2 = "tobsdk_livesdk_live_window_duration_v2";
    public static final String EVENT_LIVESDK_REC_LIVE_PLAY = "tobsdk_livesdk_rec_live_play";

    public static JSONObject filterParam(Params params) {
        return filterParam(params, new HashMap());
    }

    public static JSONObject filterParam(Params params, Map<String, String> map) {
        map.put("room_id", new StringBuilder().append(params.getRoomId()).toString());
        map.put("anchor_id", params.getAnchorId());
        map.put("enter_from_merge", params.getEnterFromMerge().lowerName());
        map.put("enter_method", params.getEnterMethod().lowerName());
        map.put("action_type", params.getActionType().lowerName());
        map.put("request_id", params.getRequestId());
        map.put("duration", new StringBuilder().append(params.getDuration()).toString());
        map.put("is_other_channel", "union_ad");
        return buildJsonObject(map);
    }

    private static JSONObject buildJsonObject(Map<String, String> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (Exception e) {
            mq.d(e);
        }
        return jSONObject;
    }
}
