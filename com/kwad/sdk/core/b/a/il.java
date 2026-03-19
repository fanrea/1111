package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class il implements com.kwad.sdk.core.d<AdMatrixInfo.MatrixTemplate> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.MatrixTemplate) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.MatrixTemplate) bVar, jSONObject);
    }

    private static void a(AdMatrixInfo.MatrixTemplate matrixTemplate, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        matrixTemplate.templateUrl = jSONObject.optString("templateUrl");
        if (JSONObject.NULL.toString().equals(matrixTemplate.templateUrl)) {
            matrixTemplate.templateUrl = "";
        }
        matrixTemplate.templateVersion = jSONObject.optString("templateVersion");
        if (JSONObject.NULL.toString().equals(matrixTemplate.templateVersion)) {
            matrixTemplate.templateVersion = "";
        }
        matrixTemplate.templateVersionCode = jSONObject.optLong("templateVersionCode");
        matrixTemplate.templateMd5 = jSONObject.optString("templateMd5");
        if (JSONObject.NULL.toString().equals(matrixTemplate.templateMd5)) {
            matrixTemplate.templateMd5 = "";
        }
    }

    private static JSONObject b(AdMatrixInfo.MatrixTemplate matrixTemplate, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (matrixTemplate.templateUrl != null && !matrixTemplate.templateUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "templateUrl", matrixTemplate.templateUrl);
        }
        if (matrixTemplate.templateVersion != null && !matrixTemplate.templateVersion.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "templateVersion", matrixTemplate.templateVersion);
        }
        if (matrixTemplate.templateVersionCode != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "templateVersionCode", matrixTemplate.templateVersionCode);
        }
        if (matrixTemplate.templateMd5 != null && !matrixTemplate.templateMd5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "templateMd5", matrixTemplate.templateMd5);
        }
        return jSONObject;
    }
}
