package com.kwad.components.ad.reward.model;

import com.kwad.sdk.core.a.e;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bq;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class RewardFraudVerifyRespInfo extends BaseResultData {
    private static final long serialVersionUID = -8657363515914699792L;
    private FraudDataInfo data = new FraudDataInfo();

    public boolean isFraud() {
        return this.data.isFraud();
    }

    public int getCode() {
        return this.data.getCode();
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        try {
            String strOptString = jSONObject.optString("data");
            if (!bq.isNullString(strOptString)) {
                strOptString = ((e) com.kwad.sdk.components.d.g(e.class)).getResponseData(strOptString);
            }
            this.data.parseJson(new JSONObject(strOptString));
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData
    public JSONObject baseToJson() {
        JSONObject json = super.toJson();
        aa.a(json, "data", this.data);
        return json;
    }

    public static class FraudDataInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = -8657363515914699792L;
        public int code;
        public boolean fraud;

        public boolean isFraud() {
            return this.fraud;
        }

        public int getCode() {
            return this.code;
        }
    }
}
