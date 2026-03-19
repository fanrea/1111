package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.ai;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class kd implements com.kwad.sdk.core.d<ai.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((ai.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((ai.a) bVar, jSONObject);
    }

    private static void a(ai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.SDKVersion = jSONObject.optString("SDKVersion");
        if (JSONObject.NULL.toString().equals(aVar.SDKVersion)) {
            aVar.SDKVersion = "";
        }
        aVar.SDKVersionCode = jSONObject.optInt("SDKVersionCode");
        aVar.sdkApiVersion = jSONObject.optString("sdkApiVersion");
        if (JSONObject.NULL.toString().equals(aVar.sdkApiVersion)) {
            aVar.sdkApiVersion = "";
        }
        aVar.sdkApiVersionCode = jSONObject.optInt("sdkApiVersionCode");
        aVar.sdkType = jSONObject.optInt("sdkType");
        aVar.appVersion = jSONObject.optString("appVersion");
        if (JSONObject.NULL.toString().equals(aVar.appVersion)) {
            aVar.appVersion = "";
        }
        aVar.appName = jSONObject.optString("appName");
        if (JSONObject.NULL.toString().equals(aVar.appName)) {
            aVar.appName = "";
        }
        aVar.appId = jSONObject.optString("appId");
        if (JSONObject.NULL.toString().equals(aVar.appId)) {
            aVar.appId = "";
        }
        aVar.aeY = jSONObject.optString("networkType");
        if (JSONObject.NULL.toString().equals(aVar.aeY)) {
            aVar.aeY = "";
        }
        aVar.aeZ = jSONObject.optString("manufacturer");
        if (JSONObject.NULL.toString().equals(aVar.aeZ)) {
            aVar.aeZ = "";
        }
        aVar.model = jSONObject.optString("model");
        if (JSONObject.NULL.toString().equals(aVar.model)) {
            aVar.model = "";
        }
        aVar.NG = jSONObject.optString("deviceBrand");
        if (JSONObject.NULL.toString().equals(aVar.NG)) {
            aVar.NG = "";
        }
        aVar.afa = jSONObject.optInt("osType");
        aVar.afb = jSONObject.optString("systemVersion");
        if (JSONObject.NULL.toString().equals(aVar.afb)) {
            aVar.afb = "";
        }
        aVar.afc = jSONObject.optInt("osApi");
        aVar.language = jSONObject.optString("language");
        if (JSONObject.NULL.toString().equals(aVar.language)) {
            aVar.language = "";
        }
        aVar.afd = jSONObject.optString("locale");
        if (JSONObject.NULL.toString().equals(aVar.afd)) {
            aVar.afd = "";
        }
        aVar.Sk = jSONObject.optInt("screenWidth");
        aVar.Sj = jSONObject.optInt("screenHeight");
        aVar.afe = jSONObject.optInt("statusBarHeight");
        aVar.aff = jSONObject.optInt("titleBarHeight");
    }

    private static JSONObject b(ai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.SDKVersion != null && !aVar.SDKVersion.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "SDKVersion", aVar.SDKVersion);
        }
        if (aVar.SDKVersionCode != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "SDKVersionCode", aVar.SDKVersionCode);
        }
        if (aVar.sdkApiVersion != null && !aVar.sdkApiVersion.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkApiVersion", aVar.sdkApiVersion);
        }
        if (aVar.sdkApiVersionCode != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkApiVersionCode", aVar.sdkApiVersionCode);
        }
        if (aVar.sdkType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkType", aVar.sdkType);
        }
        if (aVar.appVersion != null && !aVar.appVersion.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appVersion", aVar.appVersion);
        }
        if (aVar.appName != null && !aVar.appName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appName", aVar.appName);
        }
        if (aVar.appId != null && !aVar.appId.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appId", aVar.appId);
        }
        if (aVar.aeY != null && !aVar.aeY.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "networkType", aVar.aeY);
        }
        if (aVar.aeZ != null && !aVar.aeZ.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "manufacturer", aVar.aeZ);
        }
        if (aVar.model != null && !aVar.model.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "model", aVar.model);
        }
        if (aVar.NG != null && !aVar.NG.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deviceBrand", aVar.NG);
        }
        if (aVar.afa != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "osType", aVar.afa);
        }
        if (aVar.afb != null && !aVar.afb.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "systemVersion", aVar.afb);
        }
        if (aVar.afc != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "osApi", aVar.afc);
        }
        if (aVar.language != null && !aVar.language.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "language", aVar.language);
        }
        if (aVar.afd != null && !aVar.afd.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "locale", aVar.afd);
        }
        if (aVar.Sk != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "screenWidth", aVar.Sk);
        }
        if (aVar.Sj != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "screenHeight", aVar.Sj);
        }
        if (aVar.afe != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "statusBarHeight", aVar.afe);
        }
        if (aVar.aff != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "titleBarHeight", aVar.aff);
        }
        return jSONObject;
    }
}
