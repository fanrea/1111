package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.webview.d.a;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class gh implements com.kwad.sdk.core.d<a.C0595a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((a.C0595a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((a.C0595a) bVar, jSONObject);
    }

    private static void a(a.C0595a c0595a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0595a.SDKVersion = jSONObject.optString("SDKVersion");
        if (JSONObject.NULL.toString().equals(c0595a.SDKVersion)) {
            c0595a.SDKVersion = "";
        }
        c0595a.SDKVersionCode = jSONObject.optInt("SDKVersionCode");
        c0595a.bFF = jSONObject.optString("tkVersion");
        if (JSONObject.NULL.toString().equals(c0595a.bFF)) {
            c0595a.bFF = "";
        }
        c0595a.sdkApiVersion = jSONObject.optString("sdkApiVersion");
        if (JSONObject.NULL.toString().equals(c0595a.sdkApiVersion)) {
            c0595a.sdkApiVersion = "";
        }
        c0595a.sdkApiVersionCode = jSONObject.optInt("sdkApiVersionCode");
        c0595a.sdkType = jSONObject.optInt("sdkType");
        c0595a.appVersion = jSONObject.optString("appVersion");
        if (JSONObject.NULL.toString().equals(c0595a.appVersion)) {
            c0595a.appVersion = "";
        }
        c0595a.appName = jSONObject.optString("appName");
        if (JSONObject.NULL.toString().equals(c0595a.appName)) {
            c0595a.appName = "";
        }
        c0595a.appId = jSONObject.optString("appId");
        if (JSONObject.NULL.toString().equals(c0595a.appId)) {
            c0595a.appId = "";
        }
        c0595a.bMl = jSONObject.optString("globalId");
        if (JSONObject.NULL.toString().equals(c0595a.bMl)) {
            c0595a.bMl = "";
        }
        c0595a.bGt = jSONObject.optString("eGid");
        if (JSONObject.NULL.toString().equals(c0595a.bGt)) {
            c0595a.bGt = "";
        }
        c0595a.bGs = jSONObject.optString("deviceSig");
        if (JSONObject.NULL.toString().equals(c0595a.bGs)) {
            c0595a.bGs = "";
        }
        c0595a.aeY = jSONObject.optString("networkType");
        if (JSONObject.NULL.toString().equals(c0595a.aeY)) {
            c0595a.aeY = "";
        }
        c0595a.aeZ = jSONObject.optString("manufacturer");
        if (JSONObject.NULL.toString().equals(c0595a.aeZ)) {
            c0595a.aeZ = "";
        }
        c0595a.model = jSONObject.optString("model");
        if (JSONObject.NULL.toString().equals(c0595a.model)) {
            c0595a.model = "";
        }
        c0595a.NG = jSONObject.optString("deviceBrand");
        if (JSONObject.NULL.toString().equals(c0595a.NG)) {
            c0595a.NG = "";
        }
        c0595a.afa = jSONObject.optInt("osType");
        c0595a.afb = jSONObject.optString("systemVersion");
        if (JSONObject.NULL.toString().equals(c0595a.afb)) {
            c0595a.afb = "";
        }
        c0595a.afc = jSONObject.optInt("osApi");
        c0595a.language = jSONObject.optString("language");
        if (JSONObject.NULL.toString().equals(c0595a.language)) {
            c0595a.language = "";
        }
        c0595a.afd = jSONObject.optString("locale");
        if (JSONObject.NULL.toString().equals(c0595a.afd)) {
            c0595a.afd = "";
        }
        c0595a.bMm = jSONObject.optString("uuid");
        if (JSONObject.NULL.toString().equals(c0595a.bMm)) {
            c0595a.bMm = "";
        }
        c0595a.bMn = jSONObject.optBoolean("isDynamic");
        c0595a.Sk = jSONObject.optInt("screenWidth");
        c0595a.Sj = jSONObject.optInt("screenHeight");
        c0595a.bAx = jSONObject.optString(com.baidu.mobads.container.adrequest.g.z);
        if (JSONObject.NULL.toString().equals(c0595a.bAx)) {
            c0595a.bAx = "";
        }
        c0595a.bAy = jSONObject.optString("oaid");
        if (JSONObject.NULL.toString().equals(c0595a.bAy)) {
            c0595a.bAy = "";
        }
        c0595a.bGp = jSONObject.optString("androidId");
        if (JSONObject.NULL.toString().equals(c0595a.bGp)) {
            c0595a.bGp = "";
        }
        c0595a.bGG = jSONObject.optString(com.baidu.mobads.container.adrequest.g.w);
        if (JSONObject.NULL.toString().equals(c0595a.bGG)) {
            c0595a.bGG = "";
        }
        c0595a.afe = jSONObject.optInt("statusBarHeight");
        c0595a.aff = jSONObject.optInt("titleBarHeight");
        c0595a.bMo = jSONObject.optString("bridgeVersion");
        if (JSONObject.NULL.toString().equals(c0595a.bMo)) {
            c0595a.bMo = "";
        }
    }

    private static JSONObject b(a.C0595a c0595a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (c0595a.SDKVersion != null && !c0595a.SDKVersion.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "SDKVersion", c0595a.SDKVersion);
        }
        if (c0595a.SDKVersionCode != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "SDKVersionCode", c0595a.SDKVersionCode);
        }
        if (c0595a.bFF != null && !c0595a.bFF.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "tkVersion", c0595a.bFF);
        }
        if (c0595a.sdkApiVersion != null && !c0595a.sdkApiVersion.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkApiVersion", c0595a.sdkApiVersion);
        }
        if (c0595a.sdkApiVersionCode != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkApiVersionCode", c0595a.sdkApiVersionCode);
        }
        if (c0595a.sdkType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkType", c0595a.sdkType);
        }
        if (c0595a.appVersion != null && !c0595a.appVersion.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appVersion", c0595a.appVersion);
        }
        if (c0595a.appName != null && !c0595a.appName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appName", c0595a.appName);
        }
        if (c0595a.appId != null && !c0595a.appId.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appId", c0595a.appId);
        }
        if (c0595a.bMl != null && !c0595a.bMl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "globalId", c0595a.bMl);
        }
        if (c0595a.bGt != null && !c0595a.bGt.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "eGid", c0595a.bGt);
        }
        if (c0595a.bGs != null && !c0595a.bGs.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deviceSig", c0595a.bGs);
        }
        if (c0595a.aeY != null && !c0595a.aeY.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "networkType", c0595a.aeY);
        }
        if (c0595a.aeZ != null && !c0595a.aeZ.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "manufacturer", c0595a.aeZ);
        }
        if (c0595a.model != null && !c0595a.model.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "model", c0595a.model);
        }
        if (c0595a.NG != null && !c0595a.NG.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deviceBrand", c0595a.NG);
        }
        if (c0595a.afa != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "osType", c0595a.afa);
        }
        if (c0595a.afb != null && !c0595a.afb.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "systemVersion", c0595a.afb);
        }
        if (c0595a.afc != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "osApi", c0595a.afc);
        }
        if (c0595a.language != null && !c0595a.language.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "language", c0595a.language);
        }
        if (c0595a.afd != null && !c0595a.afd.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "locale", c0595a.afd);
        }
        if (c0595a.bMm != null && !c0595a.bMm.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "uuid", c0595a.bMm);
        }
        if (c0595a.bMn) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isDynamic", c0595a.bMn);
        }
        if (c0595a.Sk != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "screenWidth", c0595a.Sk);
        }
        if (c0595a.Sj != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "screenHeight", c0595a.Sj);
        }
        if (c0595a.bAx != null && !c0595a.bAx.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, com.baidu.mobads.container.adrequest.g.z, c0595a.bAx);
        }
        if (c0595a.bAy != null && !c0595a.bAy.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "oaid", c0595a.bAy);
        }
        if (c0595a.bGp != null && !c0595a.bGp.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "androidId", c0595a.bGp);
        }
        if (c0595a.bGG != null && !c0595a.bGG.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, com.baidu.mobads.container.adrequest.g.w, c0595a.bGG);
        }
        if (c0595a.afe != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "statusBarHeight", c0595a.afe);
        }
        if (c0595a.aff != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "titleBarHeight", c0595a.aff);
        }
        if (c0595a.bMo != null && !c0595a.bMo.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "bridgeVersion", c0595a.bMo);
        }
        return jSONObject;
    }
}
