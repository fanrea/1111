package com.kwad.sdk.live.audience.api;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KSLiveResponse<T> {
    private static final String ERROR_MSG = "error_msg";
    private static final String RESULT = "result";
    private static final int SUCCESS = 1;
    private final T mBody;
    private final String mErrorMsg;
    private final int mResult;

    public KSLiveResponse(T t, int i, String str) {
        this.mBody = t;
        this.mResult = i;
        this.mErrorMsg = str;
    }

    public T body() {
        return this.mBody;
    }

    public int resultCode() {
        return this.mResult;
    }

    public String errorMsg() {
        return this.mErrorMsg;
    }

    public boolean success() {
        return this.mResult == 1;
    }

    public static KSLiveResponse<String> parseFromJson(String str) {
        JSONObject jSONObject = new JSONObject(str);
        return new KSLiveResponse<>(str, jSONObject.optInt("result", 0), jSONObject.optString("error_msg", ""));
    }
}
