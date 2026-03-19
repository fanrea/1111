package com.kwai.middleware.azeroth.network;

import com.kwai.middleware.azeroth.interfaces.JsonAdapter;
import com.kwai.middleware.azeroth.utils.JsonUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class Response<T extends JsonAdapter> implements JsonAdapter<Response<T>> {
    public static final int API_SC_OK = 1;
    public static final String KEY_DATA = "data";
    public static final String KEY_ERROR_CODE = "result";
    public static final String KEY_ERROR_MESSAGE = "error_msg";
    private T mData;
    private Class<T> mDataClazz;
    private int mErrorCode;
    private String mErrorMessage;
    private boolean mIsFromCache;
    private String mRawResponse;

    public Response(Class<T> cls) {
        this.mDataClazz = cls;
    }

    public String rawResponse() {
        return this.mRawResponse;
    }

    public int errorCode() {
        return this.mErrorCode;
    }

    public String errorMessage() {
        return this.mErrorMessage;
    }

    public T data() {
        return this.mData;
    }

    void setData(T t) {
        this.mData = t;
    }

    public boolean isFromCache() {
        return this.mIsFromCache;
    }

    public void setIsFromCache(boolean z) {
        this.mIsFromCache = z;
    }

    public boolean isSuccessful() {
        return errorCode() == 1;
    }

    @Override // com.kwai.middleware.azeroth.interfaces.JsonAdapter
    public Response<T> fromJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Response<T> response = new Response<>(this.mDataClazz);
            response.mErrorCode = jSONObject.optInt("result", 0);
            response.mErrorMessage = jSONObject.optString("error_msg", "");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject != null) {
                jSONObject = jSONObjectOptJSONObject;
            }
            response.mRawResponse = jSONObject.toString();
            response.mData = (T) JsonUtils.fromJson(response.rawResponse(), this.mDataClazz);
            return response;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.kwai.middleware.azeroth.interfaces.JsonAdapter
    public JSONObject toJson() {
        throw new RuntimeException("Response can't to json");
    }
}
