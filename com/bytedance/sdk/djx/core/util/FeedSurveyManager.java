package com.bytedance.sdk.djx.core.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class FeedSurveyManager {
    public static final String KEY_AGE = "age";
    public static final String KEY_GENDER = "gender";
    private final JSONObject mCliQExtra;
    private final JSONObject mQExtra;

    public static FeedSurveyManager getInstance() {
        return InnerHolder.instance;
    }

    private static class InnerHolder {
        private static final FeedSurveyManager instance = new FeedSurveyManager();

        private InnerHolder() {
        }
    }

    private FeedSurveyManager() {
        this.mQExtra = new JSONObject();
        this.mCliQExtra = new JSONObject();
    }

    public void put(long j, int i) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(i);
        try {
            this.mQExtra.put(String.valueOf(j), jSONArray);
        } catch (JSONException unused) {
        }
    }

    public void putClient(String str, String str2) throws JSONException {
        try {
            this.mCliQExtra.put(str, str2);
        } catch (JSONException unused) {
        }
    }

    public String getQExtraString() {
        return this.mQExtra.toString();
    }

    public String getCliQExtraString() {
        return this.mCliQExtra.toString();
    }
}
