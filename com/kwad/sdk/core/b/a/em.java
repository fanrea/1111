package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class em implements com.kwad.sdk.core.d<AdMatrixInfo.DownloadTexts> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.DownloadTexts) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.DownloadTexts) bVar, jSONObject);
    }

    private static void a(AdMatrixInfo.DownloadTexts downloadTexts, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        downloadTexts.adActionDescription = jSONObject.optString("adActionDescription");
        if (JSONObject.NULL.toString().equals(downloadTexts.adActionDescription)) {
            downloadTexts.adActionDescription = "";
        }
        downloadTexts.installAppLabel = jSONObject.optString("installAppLabel");
        if (JSONObject.NULL.toString().equals(downloadTexts.installAppLabel)) {
            downloadTexts.installAppLabel = "";
        }
        downloadTexts.openAppLabel = jSONObject.optString("openAppLabel");
        if (JSONObject.NULL.toString().equals(downloadTexts.openAppLabel)) {
            downloadTexts.openAppLabel = "";
        }
    }

    private static JSONObject b(AdMatrixInfo.DownloadTexts downloadTexts, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (downloadTexts.adActionDescription != null && !downloadTexts.adActionDescription.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adActionDescription", downloadTexts.adActionDescription);
        }
        if (downloadTexts.installAppLabel != null && !downloadTexts.installAppLabel.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "installAppLabel", downloadTexts.installAppLabel);
        }
        if (downloadTexts.openAppLabel != null && !downloadTexts.openAppLabel.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "openAppLabel", downloadTexts.openAppLabel);
        }
        return jSONObject;
    }
}
