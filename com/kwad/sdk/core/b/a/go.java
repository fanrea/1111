package com.kwad.sdk.core.b.a;

import com.kwad.components.ct.home.download.HomeApkBannerData;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class go implements com.kwad.sdk.core.d<HomeApkBannerData> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((HomeApkBannerData) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((HomeApkBannerData) bVar, jSONObject);
    }

    private static void a(HomeApkBannerData homeApkBannerData, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        homeApkBannerData.appPackageName = jSONObject.optString("appPackageName");
        if (JSONObject.NULL.toString().equals(homeApkBannerData.appPackageName)) {
            homeApkBannerData.appPackageName = "";
        }
        homeApkBannerData.mAdTemplateUniqueId = jSONObject.optString("mAdTemplateUniqueId");
        if (JSONObject.NULL.toString().equals(homeApkBannerData.mAdTemplateUniqueId)) {
            homeApkBannerData.mAdTemplateUniqueId = "";
        }
        homeApkBannerData.mDownloadFilePath = jSONObject.optString("mDownloadFilePath");
        if (JSONObject.NULL.toString().equals(homeApkBannerData.mDownloadFilePath)) {
            homeApkBannerData.mDownloadFilePath = "";
        }
        homeApkBannerData.mTimeStamp = jSONObject.optLong("mTimeStamp");
    }

    private static JSONObject b(HomeApkBannerData homeApkBannerData, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (homeApkBannerData.appPackageName != null && !homeApkBannerData.appPackageName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appPackageName", homeApkBannerData.appPackageName);
        }
        if (homeApkBannerData.mAdTemplateUniqueId != null && !homeApkBannerData.mAdTemplateUniqueId.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mAdTemplateUniqueId", homeApkBannerData.mAdTemplateUniqueId);
        }
        if (homeApkBannerData.mDownloadFilePath != null && !homeApkBannerData.mDownloadFilePath.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mDownloadFilePath", homeApkBannerData.mDownloadFilePath);
        }
        if (homeApkBannerData.mTimeStamp != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mTimeStamp", homeApkBannerData.mTimeStamp);
        }
        return jSONObject;
    }
}
