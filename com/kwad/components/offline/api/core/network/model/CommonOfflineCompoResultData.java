package com.kwad.components.offline.api.core.network.model;

import com.kwad.sdk.core.a.d;
import com.kwad.sdk.core.network.EmptyResultData;
import com.kwad.sdk.core.response.model.BaseResultData;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class CommonOfflineCompoResultData extends BaseOfflineCompoResultData {
    private static final int CODE_RESULT_OK = 1;
    private static final long serialVersionUID = 7464537023322307192L;
    public String cookie;
    public String errorMsg;
    public String extra;
    public boolean hasAd;
    public long llsid;
    private boolean mKeepOriginResponse;
    public JSONObject originResponseData;
    public int result;
    private boolean mNotifyFailOnResultError = true;
    private BaseResultData mBaseResultData = new EmptyResultData();

    public boolean isDataEmpty() {
        return false;
    }

    public void parseJson(JSONObject jSONObject) throws JSONException {
        Object obj;
        String responseData;
        if (jSONObject == null) {
            return;
        }
        if (this.mBaseResultData == null) {
            this.mBaseResultData = new EmptyResultData();
        }
        this.mBaseResultData.parseJson(jSONObject);
        this.llsid = this.mBaseResultData.llsid;
        this.result = this.mBaseResultData.result;
        this.hasAd = this.mBaseResultData.hasAd;
        this.errorMsg = this.mBaseResultData.errorMsg;
        this.extra = this.mBaseResultData.extra;
        this.cookie = this.mBaseResultData.cookie;
        if (this.mKeepOriginResponse) {
            this.originResponseData = new JSONObject();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object objNextValue = null;
                try {
                    obj = jSONObject.get(next);
                } catch (JSONException unused) {
                    obj = null;
                }
                if ((obj instanceof String) && (responseData = d.getResponseData((String) obj)) != null) {
                    try {
                        objNextValue = new JSONTokener(responseData).nextValue();
                    } catch (JSONException unused2) {
                    }
                }
                if (objNextValue != null) {
                    try {
                        this.originResponseData.put(next, objNextValue);
                    } catch (JSONException unused3) {
                    }
                } else {
                    this.originResponseData.put(next, obj);
                }
            }
        }
    }

    public JSONObject toJson() {
        BaseResultData baseResultData = this.mBaseResultData;
        return baseResultData == null ? new JSONObject() : baseResultData.toJson();
    }

    public boolean isResultOk() {
        return this.result == 1;
    }

    public boolean hasData() {
        return this.hasAd;
    }

    public void setKeepOriginResponse(boolean z) {
        this.mKeepOriginResponse = z;
    }

    public void setNotifyFailOnResultError(boolean z) {
        this.mNotifyFailOnResultError = z;
    }

    public boolean notifyFailOnResultError() {
        return this.mNotifyFailOnResultError;
    }
}
