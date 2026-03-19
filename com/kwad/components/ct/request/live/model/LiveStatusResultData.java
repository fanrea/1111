package com.kwad.components.ct.request.live.model;

import com.kwad.sdk.core.a.d;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bq;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class LiveStatusResultData extends BaseResultData {
    private static final long serialVersionUID = 4029640509861990549L;
    public LiveStatus liveStatus = new LiveStatus();

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
            this.liveStatus.parseJson(new JSONObject(d.getResponseData(strOptString)));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        aa.a(json, "data", this.liveStatus);
        return json;
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData
    public boolean isDataEmpty() {
        LiveStatus liveStatus = this.liveStatus;
        return liveStatus == null || bq.isNullString(liveStatus.liveStreamId);
    }

    public static class LiveStatus implements b, Serializable {
        private static final long serialVersionUID = -5609658944971506312L;
        public String liveStreamId;

        @Override // com.kwad.sdk.core.b
        public void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.liveStreamId = jSONObject.optString("liveStreamId");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            aa.putValue(jSONObject, "liveStreamId", this.liveStreamId);
            return jSONObject;
        }
    }
}
