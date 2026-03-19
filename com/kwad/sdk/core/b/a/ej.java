package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.download.DownloadParams;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ej implements com.kwad.sdk.core.d<DownloadParams> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((DownloadParams) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((DownloadParams) bVar, jSONObject);
    }

    private static void a(DownloadParams downloadParams, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        downloadParams.mDownloadid = jSONObject.optString("mDownloadid");
        if (JSONObject.NULL.toString().equals(downloadParams.mDownloadid)) {
            downloadParams.mDownloadid = "";
        }
        downloadParams.mAppName = jSONObject.optString("mAppName");
        if (JSONObject.NULL.toString().equals(downloadParams.mAppName)) {
            downloadParams.mAppName = "";
        }
        downloadParams.mPkgname = jSONObject.optString("mPkgname");
        if (JSONObject.NULL.toString().equals(downloadParams.mPkgname)) {
            downloadParams.mPkgname = "";
        }
        downloadParams.mVersion = jSONObject.optString("mVersion");
        if (JSONObject.NULL.toString().equals(downloadParams.mVersion)) {
            downloadParams.mVersion = "";
        }
        downloadParams.mVersionCode = jSONObject.optString("mVersionCode");
        if (JSONObject.NULL.toString().equals(downloadParams.mVersionCode)) {
            downloadParams.mVersionCode = "";
        }
        downloadParams.mAppSize = jSONObject.optLong("mAppSize");
        downloadParams.mFileMd5 = jSONObject.optString("mFileMd5");
        if (JSONObject.NULL.toString().equals(downloadParams.mFileMd5)) {
            downloadParams.mFileMd5 = "";
        }
        downloadParams.mFileUrl = jSONObject.optString("mFileUrl");
        if (JSONObject.NULL.toString().equals(downloadParams.mFileUrl)) {
            downloadParams.mFileUrl = "";
        }
        downloadParams.mAppIcon = jSONObject.optString("mAppIcon");
        if (JSONObject.NULL.toString().equals(downloadParams.mAppIcon)) {
            downloadParams.mAppIcon = "";
        }
        downloadParams.mShortDesc = jSONObject.optString("mShortDesc");
        if (JSONObject.NULL.toString().equals(downloadParams.mShortDesc)) {
            downloadParams.mShortDesc = "";
        }
        downloadParams.mTaskId = jSONObject.optInt("mTaskId");
        downloadParams.filePath = jSONObject.optString("filePath");
        if (JSONObject.NULL.toString().equals(downloadParams.filePath)) {
            downloadParams.filePath = "";
        }
        downloadParams.requestInstallPermission = jSONObject.optBoolean("requestInstallPermission");
        downloadParams.downloadEnablePause = jSONObject.optBoolean("downloadEnablePause");
        downloadParams.downloadPlace = jSONObject.optInt("downloadPlace");
    }

    private static JSONObject b(DownloadParams downloadParams, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (downloadParams.mDownloadid != null && !downloadParams.mDownloadid.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mDownloadid", downloadParams.mDownloadid);
        }
        if (downloadParams.mAppName != null && !downloadParams.mAppName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mAppName", downloadParams.mAppName);
        }
        if (downloadParams.mPkgname != null && !downloadParams.mPkgname.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mPkgname", downloadParams.mPkgname);
        }
        if (downloadParams.mVersion != null && !downloadParams.mVersion.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mVersion", downloadParams.mVersion);
        }
        if (downloadParams.mVersionCode != null && !downloadParams.mVersionCode.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mVersionCode", downloadParams.mVersionCode);
        }
        if (downloadParams.mAppSize != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mAppSize", downloadParams.mAppSize);
        }
        if (downloadParams.mFileMd5 != null && !downloadParams.mFileMd5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mFileMd5", downloadParams.mFileMd5);
        }
        if (downloadParams.mFileUrl != null && !downloadParams.mFileUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mFileUrl", downloadParams.mFileUrl);
        }
        if (downloadParams.mAppIcon != null && !downloadParams.mAppIcon.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mAppIcon", downloadParams.mAppIcon);
        }
        if (downloadParams.mShortDesc != null && !downloadParams.mShortDesc.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mShortDesc", downloadParams.mShortDesc);
        }
        if (downloadParams.mTaskId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mTaskId", downloadParams.mTaskId);
        }
        if (downloadParams.filePath != null && !downloadParams.filePath.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "filePath", downloadParams.filePath);
        }
        if (downloadParams.requestInstallPermission) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "requestInstallPermission", downloadParams.requestInstallPermission);
        }
        if (downloadParams.downloadEnablePause) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadEnablePause", downloadParams.downloadEnablePause);
        }
        if (downloadParams.downloadPlace != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "downloadPlace", downloadParams.downloadPlace);
        }
        return jSONObject;
    }
}
