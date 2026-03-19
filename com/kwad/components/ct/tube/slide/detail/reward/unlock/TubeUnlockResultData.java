package com.kwad.components.ct.tube.slide.detail.reward.unlock;

import android.text.TextUtils;
import com.kwad.sdk.core.a.d;
import com.kwad.sdk.core.response.model.BaseResultData;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class TubeUnlockResultData extends BaseResultData {
    private static final long serialVersionUID = -2462859465541891720L;
    public int unlockEpisodeNum;

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        String responseData = d.getResponseData(jSONObject.optString("data"));
        if (TextUtils.isEmpty(responseData)) {
            return;
        }
        try {
            this.unlockEpisodeNum = new JSONObject(responseData).optInt("unlockEpisodeNum");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
