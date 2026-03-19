package com.kwad.components.ct.coupon.request;

import com.kwad.components.ct.coupon.model.CouponStatusInfo;
import com.kwad.sdk.core.a.d;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bq;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class CouponStatusResponse extends BaseResultData implements com.kwad.sdk.core.b, Serializable {
    private static final long serialVersionUID = 1354584682055275618L;
    public CouponStatusInfo couponStatusInfo = new CouponStatusInfo();

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            String strOptString = jSONObject.optString("data");
            if (bq.isNullString(strOptString)) {
                return;
            }
            this.couponStatusInfo.parseJson(new JSONObject(d.getResponseData(strOptString)));
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        aa.a(json, "data", this.couponStatusInfo);
        return json;
    }

    public boolean isNewUser() {
        return this.couponStatusInfo.isNewUser;
    }

    public int getCouponStatusCode() {
        return this.couponStatusInfo.statusCode;
    }

    public int getCouponLeftTimes() {
        return this.couponStatusInfo.couponLeftTimes;
    }
}
