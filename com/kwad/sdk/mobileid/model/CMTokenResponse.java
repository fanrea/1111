package com.kwad.sdk.mobileid.model;

import com.kwad.sdk.core.response.a.a;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bq;
import com.kwai.middleware.azeroth.network.NetworkDefine;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class CMTokenResponse extends BaseResultData implements Serializable {
    private static final long serialVersionUID = -8501365728042530876L;
    public Header mHeader = new Header();
    public Body mBody = new Body();

    @Override // com.kwad.sdk.core.response.model.BaseResultData
    public boolean isResultOk() {
        return this.mBody.mResultCode != null && this.mBody.mResultCode.equals("103000");
    }

    public String getResultCode() {
        return this.mBody.mResultCode;
    }

    public String getResultMsg() {
        return this.mBody.mResultDesc;
    }

    public String getResultToken() {
        return this.mBody.mToken;
    }

    public String toString() {
        return "UaidTokenResponse{mHeader=" + this.mHeader + ", mBody=" + this.mBody + '}';
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            String strOptString = jSONObject.optString("header");
            String strOptString2 = jSONObject.optString("body");
            if (bq.isNullString(strOptString)) {
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(strOptString);
                Header header = new Header();
                this.mHeader = header;
                header.parseJson(jSONObject2);
                JSONObject jSONObject3 = new JSONObject(strOptString2);
                Body body = new Body();
                this.mBody = body;
                body.parseJson(jSONObject3);
            } catch (JSONException e) {
                ServiceProvider.reportSdkCaughtException(e);
            }
        } catch (Throwable unused) {
        }
    }

    public static class Header extends a implements Serializable {
        private static final long serialVersionUID = -1244494639407773564L;
        public String mAppId;
        public String mTimestamp;
        public String mTraceId;

        @Override // com.kwad.sdk.core.response.a.a
        public String toString() {
            return "Header{mTraceId='" + this.mTraceId + "', mTimestamp='" + this.mTimestamp + "', mAppId='" + this.mAppId + "'}";
        }

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.mTraceId = jSONObject.optString("traceId");
            this.mTimestamp = jSONObject.optString(com.alipay.sdk.m.t.a.k);
            this.mAppId = jSONObject.optString("appId");
        }
    }

    public static class Body extends a implements Serializable {
        private static final long serialVersionUID = -4941153252697477901L;
        public String mResultCode;
        public String mResultDesc;
        public String mToken;

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.mResultCode = jSONObject.optString("resultCode");
            this.mResultDesc = jSONObject.optString("resultDesc");
            this.mToken = jSONObject.optString(NetworkDefine.PARAM_TOKEN);
        }

        @Override // com.kwad.sdk.core.response.a.a
        public String toString() {
            return "Body{mResultCode='" + this.mResultCode + "', mResultDesc='" + this.mResultDesc + "', mToken='" + this.mToken + "'}";
        }
    }
}
