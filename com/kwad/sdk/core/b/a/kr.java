package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class kr implements com.kwad.sdk.core.d<AdInfo.RewardFraudVerifyInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.RewardFraudVerifyInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.RewardFraudVerifyInfo) bVar, jSONObject);
    }

    private static void a(AdInfo.RewardFraudVerifyInfo rewardFraudVerifyInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rewardFraudVerifyInfo.fraudVerifyAdvanceMs = jSONObject.optInt("fraudVerifyAdvanceMs", new Integer("2000").intValue());
        rewardFraudVerifyInfo.fraudVerifySwitch = jSONObject.optBoolean("fraudVerifySwitch");
    }

    private static JSONObject b(AdInfo.RewardFraudVerifyInfo rewardFraudVerifyInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "fraudVerifyAdvanceMs", rewardFraudVerifyInfo.fraudVerifyAdvanceMs);
        if (rewardFraudVerifyInfo.fraudVerifySwitch) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "fraudVerifySwitch", rewardFraudVerifyInfo.fraudVerifySwitch);
        }
        return jSONObject;
    }
}
