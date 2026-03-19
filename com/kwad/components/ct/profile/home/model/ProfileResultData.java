package com.kwad.components.ct.profile.home.model;

import com.kwad.sdk.core.a.d;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.aa;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ProfileResultData extends BaseResultData implements b {
    private static final long serialVersionUID = 5593104938742949008L;
    public UserProfile userProfile = new UserProfile();

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            this.userProfile.parseJson(new JSONObject(d.getResponseData(jSONObject.optString("data"))));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        aa.a(json, "data", this.userProfile);
        return json;
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData
    public boolean isDataEmpty() {
        UserProfile userProfile = this.userProfile;
        return userProfile == null || userProfile.tabList.isEmpty();
    }
}
