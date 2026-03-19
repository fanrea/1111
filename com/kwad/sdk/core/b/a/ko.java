package com.kwad.sdk.core.b.a;

import com.kwad.components.ct.response.model.home.ReportInfo;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ko implements com.kwad.sdk.core.d<ReportInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((ReportInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((ReportInfo) bVar, jSONObject);
    }

    private static void a(ReportInfo reportInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        reportInfo.reportId = jSONObject.optInt("reportId");
        reportInfo.content = jSONObject.optString("content");
        if (JSONObject.NULL.toString().equals(reportInfo.content)) {
            reportInfo.content = "";
        }
    }

    private static JSONObject b(ReportInfo reportInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (reportInfo.reportId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "reportId", reportInfo.reportId);
        }
        if (reportInfo.content != null && !reportInfo.content.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "content", reportInfo.content);
        }
        return jSONObject;
    }
}
