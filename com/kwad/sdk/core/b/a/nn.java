package com.kwad.sdk.core.b.a;

import com.baidu.mobads.container.rewardvideo.RemoteRewardActivity;
import com.baidu.mobstat.forbes.Config;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class nn implements com.kwad.sdk.core.d<ak.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((ak.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((ak.a) bVar, jSONObject);
    }

    private static void a(ak.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.type = jSONObject.optInt("type");
        aVar.appName = jSONObject.optString("appName");
        if (JSONObject.NULL.toString().equals(aVar.appName)) {
            aVar.appName = "";
        }
        aVar.pkgName = jSONObject.optString("pkgName");
        if (JSONObject.NULL.toString().equals(aVar.pkgName)) {
            aVar.pkgName = "";
        }
        aVar.version = jSONObject.optString(Config.INPUT_DEF_VERSION);
        if (JSONObject.NULL.toString().equals(aVar.version)) {
            aVar.version = "";
        }
        aVar.versionCode = jSONObject.optInt("versionCode");
        aVar.afi = jSONObject.optInt("appSize");
        aVar.md5 = jSONObject.optString(TKDownloadReason.KSAD_TK_MD5);
        if (JSONObject.NULL.toString().equals(aVar.md5)) {
            aVar.md5 = "";
        }
        aVar.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(aVar.url)) {
            aVar.url = "";
        }
        aVar.afj = jSONObject.optString("appLink");
        if (JSONObject.NULL.toString().equals(aVar.afj)) {
            aVar.afj = "";
        }
        aVar.icon = jSONObject.optString("icon");
        if (JSONObject.NULL.toString().equals(aVar.icon)) {
            aVar.icon = "";
        }
        aVar.uM = jSONObject.optString(RemoteRewardActivity.JSON_BANNER_DESC_ID);
        if (JSONObject.NULL.toString().equals(aVar.uM)) {
            aVar.uM = "";
        }
        aVar.appId = jSONObject.optString("appId");
        if (JSONObject.NULL.toString().equals(aVar.appId)) {
            aVar.appId = "";
        }
        aVar.afk = jSONObject.optString("marketUri");
        if (JSONObject.NULL.toString().equals(aVar.afk)) {
            aVar.afk = "";
        }
        aVar.afl = jSONObject.optBoolean("disableLandingPageDeepLink");
        aVar.afm = jSONObject.optBoolean("isLandscapeSupported");
        aVar.afn = jSONObject.optBoolean("isFromLive");
    }

    private static JSONObject b(ak.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.type != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "type", aVar.type);
        }
        if (aVar.appName != null && !aVar.appName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appName", aVar.appName);
        }
        if (aVar.pkgName != null && !aVar.pkgName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pkgName", aVar.pkgName);
        }
        if (aVar.version != null && !aVar.version.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, Config.INPUT_DEF_VERSION, aVar.version);
        }
        if (aVar.versionCode != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "versionCode", aVar.versionCode);
        }
        if (aVar.afi != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appSize", aVar.afi);
        }
        if (aVar.md5 != null && !aVar.md5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, TKDownloadReason.KSAD_TK_MD5, aVar.md5);
        }
        if (aVar.url != null && !aVar.url.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url", aVar.url);
        }
        if (aVar.afj != null && !aVar.afj.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appLink", aVar.afj);
        }
        if (aVar.icon != null && !aVar.icon.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "icon", aVar.icon);
        }
        if (aVar.uM != null && !aVar.uM.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, RemoteRewardActivity.JSON_BANNER_DESC_ID, aVar.uM);
        }
        if (aVar.appId != null && !aVar.appId.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appId", aVar.appId);
        }
        if (aVar.afk != null && !aVar.afk.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "marketUri", aVar.afk);
        }
        if (aVar.afl) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "disableLandingPageDeepLink", aVar.afl);
        }
        if (aVar.afm) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isLandscapeSupported", aVar.afm);
        }
        if (aVar.afn) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isFromLive", aVar.afn);
        }
        return jSONObject;
    }
}
