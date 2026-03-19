package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class cu implements com.kwad.sdk.core.d<AdInfo.ComplianceInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.ComplianceInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.ComplianceInfo) bVar, jSONObject);
    }

    private static void a(AdInfo.ComplianceInfo complianceInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        complianceInfo.materialJumpType = jSONObject.optInt("materialJumpType");
        complianceInfo.actionBarType = jSONObject.optInt("actionBarType");
        complianceInfo.describeBarType = jSONObject.optInt("describeBarType");
        complianceInfo.titleBarTextSwitch = jSONObject.optInt("titleBarTextSwitch");
    }

    private static JSONObject b(AdInfo.ComplianceInfo complianceInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (complianceInfo.materialJumpType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "materialJumpType", complianceInfo.materialJumpType);
        }
        if (complianceInfo.actionBarType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "actionBarType", complianceInfo.actionBarType);
        }
        if (complianceInfo.describeBarType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "describeBarType", complianceInfo.describeBarType);
        }
        if (complianceInfo.titleBarTextSwitch != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "titleBarTextSwitch", complianceInfo.titleBarTextSwitch);
        }
        return jSONObject;
    }
}
