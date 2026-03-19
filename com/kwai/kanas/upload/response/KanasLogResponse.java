package com.kwai.kanas.upload.response;

import com.kwai.middleware.azeroth.interfaces.JsonAdapter;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KanasLogResponse implements JsonAdapter<KanasLogResponse>, Serializable {
    private static final String KEY_CONNECTED = "connected";
    private static final String KEY_NEXT_REQUEST_MS = "nextRequestPeriodInMs";
    private static final long MIN_NEXT_REQUEST_PERIOD_MS = 100;
    private static final long serialVersionUID = -1746290249409750361L;
    private long mNextRequestPeriodInMs = MIN_NEXT_REQUEST_PERIOD_MS;
    private boolean mDebugLoggerConfigEnable = false;

    public long getNextRequestPeriodInMs() {
        return this.mNextRequestPeriodInMs;
    }

    public boolean isDebugLoggerConfigEnable() {
        return this.mDebugLoggerConfigEnable;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.kwai.middleware.azeroth.interfaces.JsonAdapter
    public KanasLogResponse fromJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            KanasLogResponse kanasLogResponse = new KanasLogResponse();
            kanasLogResponse.mNextRequestPeriodInMs = Math.max(MIN_NEXT_REQUEST_PERIOD_MS, jSONObject.optLong(KEY_NEXT_REQUEST_MS, MIN_NEXT_REQUEST_PERIOD_MS));
            kanasLogResponse.mDebugLoggerConfigEnable = jSONObject.optBoolean(KEY_CONNECTED, false);
            return kanasLogResponse;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.kwai.middleware.azeroth.interfaces.JsonAdapter
    public JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_NEXT_REQUEST_MS, this.mNextRequestPeriodInMs);
            jSONObject.put(KEY_CONNECTED, this.mDebugLoggerConfigEnable);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
