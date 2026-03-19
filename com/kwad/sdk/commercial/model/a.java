package com.kwad.sdk.commercial.model;

import com.kwad.sdk.core.b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.aa;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a implements b {
    public int adOperationType;
    public int campaignType;
    public int industryFirstLevelId;
    public int ocpcActionType;
    public int webUriSourceType;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
    }

    public a(AdInfo adInfo) {
        if (adInfo != null) {
            this.campaignType = com.kwad.sdk.core.response.b.a.dC(adInfo);
            this.ocpcActionType = com.kwad.sdk.core.response.b.a.dD(adInfo);
            this.industryFirstLevelId = com.kwad.sdk.core.response.b.a.dE(adInfo);
            this.adOperationType = com.kwad.sdk.core.response.b.a.aU(adInfo);
            this.webUriSourceType = com.kwad.sdk.core.response.b.a.dF(adInfo);
        }
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "campaign_type", this.campaignType);
        aa.putValue(jSONObject, "ocpc_action_type", this.ocpcActionType);
        aa.putValue(jSONObject, "industry_first_level_id", this.industryFirstLevelId);
        aa.putValue(jSONObject, "ad_operation_type", this.adOperationType);
        aa.putValue(jSONObject, "web_uri_source_type", this.webUriSourceType);
        return jSONObject;
    }
}
