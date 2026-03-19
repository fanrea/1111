package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class kx implements com.kwad.sdk.core.d<AdMatrixInfo.RewardWebTaskCloseInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.RewardWebTaskCloseInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.RewardWebTaskCloseInfo) bVar, jSONObject);
    }

    private static void a(AdMatrixInfo.RewardWebTaskCloseInfo rewardWebTaskCloseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rewardWebTaskCloseInfo.templateId = jSONObject.optString("templateId");
        if (JSONObject.NULL.toString().equals(rewardWebTaskCloseInfo.templateId)) {
            rewardWebTaskCloseInfo.templateId = "";
        }
        rewardWebTaskCloseInfo.webConfirmCardType = jSONObject.optInt("webConfirmCardType");
    }

    private static JSONObject b(AdMatrixInfo.RewardWebTaskCloseInfo rewardWebTaskCloseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (rewardWebTaskCloseInfo.templateId != null && !rewardWebTaskCloseInfo.templateId.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "templateId", rewardWebTaskCloseInfo.templateId);
        }
        if (rewardWebTaskCloseInfo.webConfirmCardType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "webConfirmCardType", rewardWebTaskCloseInfo.webConfirmCardType);
        }
        return jSONObject;
    }
}
