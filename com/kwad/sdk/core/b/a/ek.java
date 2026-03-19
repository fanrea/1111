package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ek implements com.kwad.sdk.core.d<AdInfo.DownloadSafeInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.DownloadSafeInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.DownloadSafeInfo) bVar, jSONObject);
    }

    private static void a(AdInfo.DownloadSafeInfo downloadSafeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        downloadSafeInfo.permissionInfo = jSONObject.optString("permissionInfo");
        if (JSONObject.NULL.toString().equals(downloadSafeInfo.permissionInfo)) {
            downloadSafeInfo.permissionInfo = "";
        }
        downloadSafeInfo.appName = jSONObject.optString("appName");
        if (JSONObject.NULL.toString().equals(downloadSafeInfo.appName)) {
            downloadSafeInfo.appName = "";
        }
        downloadSafeInfo.corporationName = jSONObject.optString("corporationName");
        if (JSONObject.NULL.toString().equals(downloadSafeInfo.corporationName)) {
            downloadSafeInfo.corporationName = "";
        }
        downloadSafeInfo.packageSize = jSONObject.optLong("packageSize");
        downloadSafeInfo.appVersion = jSONObject.optString("appVersion");
        if (JSONObject.NULL.toString().equals(downloadSafeInfo.appVersion)) {
            downloadSafeInfo.appVersion = "";
        }
        downloadSafeInfo.appPrivacyUrl = jSONObject.optString("appPrivacyUrl");
        if (JSONObject.NULL.toString().equals(downloadSafeInfo.appPrivacyUrl)) {
            downloadSafeInfo.appPrivacyUrl = "";
        }
        downloadSafeInfo.appPermissionInfoUrl = jSONObject.optString("appPermissionInfoUrl");
        if (JSONObject.NULL.toString().equals(downloadSafeInfo.appPermissionInfoUrl)) {
            downloadSafeInfo.appPermissionInfoUrl = "";
        }
        downloadSafeInfo.introductionInfo = jSONObject.optString("introductionInfo");
        if (JSONObject.NULL.toString().equals(downloadSafeInfo.introductionInfo)) {
            downloadSafeInfo.introductionInfo = "";
        }
        downloadSafeInfo.introductionInfoUrl = jSONObject.optString("introductionInfoUrl");
        if (JSONObject.NULL.toString().equals(downloadSafeInfo.introductionInfoUrl)) {
            downloadSafeInfo.introductionInfoUrl = "";
        }
        downloadSafeInfo.secWindowPopNoWifiSwitch = jSONObject.optBoolean("secWindowPopNoWifiSwitch");
        downloadSafeInfo.secWindowPopSwitch = jSONObject.optBoolean("secWindowPopSwitch");
        downloadSafeInfo.downloadPauseEnable = jSONObject.optBoolean("downloadPauseEnable", new Boolean("false").booleanValue());
        downloadSafeInfo.windowPopUrl = jSONObject.optString("windowPopUrl");
        if (JSONObject.NULL.toString().equals(downloadSafeInfo.windowPopUrl)) {
            downloadSafeInfo.windowPopUrl = "";
        }
        downloadSafeInfo.webPageTipbarSwitch = jSONObject.optBoolean("webPageTipbarSwitch", new Boolean("false").booleanValue());
        downloadSafeInfo.webPageTipbarText = jSONObject.optString("webPageTipbarText");
        if (JSONObject.NULL.toString().equals(downloadSafeInfo.webPageTipbarText)) {
            downloadSafeInfo.webPageTipbarText = "";
        }
        downloadSafeInfo.autoDownloadUrl = jSONObject.optString("autoDownloadUrl");
        if (JSONObject.NULL.toString().equals(downloadSafeInfo.autoDownloadUrl)) {
            downloadSafeInfo.autoDownloadUrl = "";
        }
        downloadSafeInfo.complianceInfo = new AdInfo.ComplianceInfo();
        downloadSafeInfo.complianceInfo.parseJson(jSONObject.optJSONObject("complianceInfo"));
        downloadSafeInfo.recordNumber = jSONObject.optString("recordNumber");
        if (JSONObject.NULL.toString().equals(downloadSafeInfo.recordNumber)) {
            downloadSafeInfo.recordNumber = "";
        }
    }

    private static JSONObject b(AdInfo.DownloadSafeInfo downloadSafeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (downloadSafeInfo.permissionInfo != null && !downloadSafeInfo.permissionInfo.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "permissionInfo", downloadSafeInfo.permissionInfo);
        }
        if (downloadSafeInfo.appName != null && !downloadSafeInfo.appName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appName", downloadSafeInfo.appName);
        }
        if (downloadSafeInfo.corporationName != null && !downloadSafeInfo.corporationName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "corporationName", downloadSafeInfo.corporationName);
        }
        if (downloadSafeInfo.packageSize != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "packageSize", downloadSafeInfo.packageSize);
        }
        if (downloadSafeInfo.appVersion != null && !downloadSafeInfo.appVersion.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appVersion", downloadSafeInfo.appVersion);
        }
        if (downloadSafeInfo.appPrivacyUrl != null && !downloadSafeInfo.appPrivacyUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appPrivacyUrl", downloadSafeInfo.appPrivacyUrl);
        }
        if (downloadSafeInfo.appPermissionInfoUrl != null && !downloadSafeInfo.appPermissionInfoUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appPermissionInfoUrl", downloadSafeInfo.appPermissionInfoUrl);
        }
        if (downloadSafeInfo.introductionInfo != null && !downloadSafeInfo.introductionInfo.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "introductionInfo", downloadSafeInfo.introductionInfo);
        }
        if (downloadSafeInfo.introductionInfoUrl != null && !downloadSafeInfo.introductionInfoUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "introductionInfoUrl", downloadSafeInfo.introductionInfoUrl);
        }
        if (downloadSafeInfo.secWindowPopNoWifiSwitch) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "secWindowPopNoWifiSwitch", downloadSafeInfo.secWindowPopNoWifiSwitch);
        }
        if (downloadSafeInfo.secWindowPopSwitch) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "secWindowPopSwitch", downloadSafeInfo.secWindowPopSwitch);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadPauseEnable", downloadSafeInfo.downloadPauseEnable);
        if (downloadSafeInfo.windowPopUrl != null && !downloadSafeInfo.windowPopUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "windowPopUrl", downloadSafeInfo.windowPopUrl);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "webPageTipbarSwitch", downloadSafeInfo.webPageTipbarSwitch);
        if (downloadSafeInfo.webPageTipbarText != null && !downloadSafeInfo.webPageTipbarText.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "webPageTipbarText", downloadSafeInfo.webPageTipbarText);
        }
        if (downloadSafeInfo.autoDownloadUrl != null && !downloadSafeInfo.autoDownloadUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "autoDownloadUrl", downloadSafeInfo.autoDownloadUrl);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "complianceInfo", downloadSafeInfo.complianceInfo);
        if (downloadSafeInfo.recordNumber != null && !downloadSafeInfo.recordNumber.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "recordNumber", downloadSafeInfo.recordNumber);
        }
        return jSONObject;
    }
}
