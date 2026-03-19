package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class eh implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.request.model.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.request.model.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.request.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.bAx = jSONObject.optString(com.baidu.mobads.container.adrequest.g.z);
        if (JSONObject.NULL.toString().equals(bVar.bAx)) {
            bVar.bAx = "";
        }
        bVar.bGi = jSONObject.optString("imei1");
        if (JSONObject.NULL.toString().equals(bVar.bGi)) {
            bVar.bGi = "";
        }
        bVar.bGj = jSONObject.optString(com.baidu.mobads.container.adrequest.g.A);
        if (JSONObject.NULL.toString().equals(bVar.bGj)) {
            bVar.bGj = "";
        }
        bVar.bGk = jSONObject.optString("meid");
        if (JSONObject.NULL.toString().equals(bVar.bGk)) {
            bVar.bGk = "";
        }
        bVar.bAy = jSONObject.optString("oaid");
        if (JSONObject.NULL.toString().equals(bVar.bAy)) {
            bVar.bAy = "";
        }
        bVar.bGl = jSONObject.optString("appMkt");
        if (JSONObject.NULL.toString().equals(bVar.bGl)) {
            bVar.bGl = "";
        }
        bVar.bGm = jSONObject.optString("appMktParam");
        if (JSONObject.NULL.toString().equals(bVar.bGm)) {
            bVar.bGm = "";
        }
        bVar.NI = jSONObject.optString("romName");
        if (JSONObject.NULL.toString().equals(bVar.NI)) {
            bVar.NI = "";
        }
        bVar.afa = jSONObject.optInt("osType");
        bVar.afc = jSONObject.optInt("osApi");
        bVar.NH = jSONObject.optString("osVersion");
        if (JSONObject.NULL.toString().equals(bVar.NH)) {
            bVar.NH = "";
        }
        bVar.language = jSONObject.optString("language");
        if (JSONObject.NULL.toString().equals(bVar.language)) {
            bVar.language = "";
        }
        bVar.Sk = jSONObject.optInt("screenWidth");
        bVar.Sj = jSONObject.optInt("screenHeight");
        bVar.bGn = jSONObject.optInt("deviceWidth");
        bVar.bGo = jSONObject.optInt("deviceHeight");
        bVar.bGp = jSONObject.optString("androidId");
        if (JSONObject.NULL.toString().equals(bVar.bGp)) {
            bVar.bGp = "";
        }
        bVar.NJ = jSONObject.optString("deviceId");
        if (JSONObject.NULL.toString().equals(bVar.NJ)) {
            bVar.NJ = "";
        }
        bVar.bGq = jSONObject.optString("deviceVendor");
        if (JSONObject.NULL.toString().equals(bVar.bGq)) {
            bVar.bGq = "";
        }
        bVar.bGr = jSONObject.optInt("platform");
        bVar.NF = jSONObject.optString("deviceModel");
        if (JSONObject.NULL.toString().equals(bVar.NF)) {
            bVar.NF = "";
        }
        bVar.NG = jSONObject.optString("deviceBrand");
        if (JSONObject.NULL.toString().equals(bVar.NG)) {
            bVar.NG = "";
        }
        bVar.bGs = jSONObject.optString("deviceSig");
        if (JSONObject.NULL.toString().equals(bVar.bGs)) {
            bVar.bGs = "";
        }
        bVar.bGt = jSONObject.optString("eGid");
        if (JSONObject.NULL.toString().equals(bVar.bGt)) {
            bVar.bGt = "";
        }
        bVar.bGu = jSONObject.optJSONArray("appPackageName");
        bVar.bGv = jSONObject.optString("uaidToken");
        if (JSONObject.NULL.toString().equals(bVar.bGv)) {
            bVar.bGv = "";
        }
        bVar.uaid = jSONObject.optString("uaid");
        if (JSONObject.NULL.toString().equals(bVar.uaid)) {
            bVar.uaid = "";
        }
        bVar.bGw = jSONObject.optString("arch");
        if (JSONObject.NULL.toString().equals(bVar.bGw)) {
            bVar.bGw = "";
        }
        bVar.bGx = jSONObject.optInt("screenDirection");
        bVar.bGy = jSONObject.optString("kwaiVersionName");
        if (JSONObject.NULL.toString().equals(bVar.bGy)) {
            bVar.bGy = "";
        }
        bVar.bGz = jSONObject.optString("kwaiNebulaVersionName");
        if (JSONObject.NULL.toString().equals(bVar.bGz)) {
            bVar.bGz = "";
        }
        bVar.bGA = jSONObject.optString("wechatVersionName");
        if (JSONObject.NULL.toString().equals(bVar.bGA)) {
            bVar.bGA = "";
        }
        bVar.bGB = jSONObject.optLong("sourceFlag");
        bVar.bGC = jSONObject.optString("systemBootTime");
        if (JSONObject.NULL.toString().equals(bVar.bGC)) {
            bVar.bGC = "";
        }
        bVar.bGD = jSONObject.optString("systemUpdateTime");
        if (JSONObject.NULL.toString().equals(bVar.bGD)) {
            bVar.bGD = "";
        }
        bVar.bGE = jSONObject.optInt("probeBatch");
    }

    private static JSONObject b(com.kwad.sdk.core.request.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.bAx != null && !bVar.bAx.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, com.baidu.mobads.container.adrequest.g.z, bVar.bAx);
        }
        if (bVar.bGi != null && !bVar.bGi.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "imei1", bVar.bGi);
        }
        if (bVar.bGj != null && !bVar.bGj.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, com.baidu.mobads.container.adrequest.g.A, bVar.bGj);
        }
        if (bVar.bGk != null && !bVar.bGk.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "meid", bVar.bGk);
        }
        if (bVar.bAy != null && !bVar.bAy.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "oaid", bVar.bAy);
        }
        if (bVar.bGl != null && !bVar.bGl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appMkt", bVar.bGl);
        }
        if (bVar.bGm != null && !bVar.bGm.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appMktParam", bVar.bGm);
        }
        if (bVar.NI != null && !bVar.NI.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "romName", bVar.NI);
        }
        if (bVar.afa != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "osType", bVar.afa);
        }
        if (bVar.afc != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "osApi", bVar.afc);
        }
        if (bVar.NH != null && !bVar.NH.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "osVersion", bVar.NH);
        }
        if (bVar.language != null && !bVar.language.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "language", bVar.language);
        }
        if (bVar.Sk != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "screenWidth", bVar.Sk);
        }
        if (bVar.Sj != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "screenHeight", bVar.Sj);
        }
        if (bVar.bGn != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deviceWidth", bVar.bGn);
        }
        if (bVar.bGo != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deviceHeight", bVar.bGo);
        }
        if (bVar.bGp != null && !bVar.bGp.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "androidId", bVar.bGp);
        }
        if (bVar.NJ != null && !bVar.NJ.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deviceId", bVar.NJ);
        }
        if (bVar.bGq != null && !bVar.bGq.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deviceVendor", bVar.bGq);
        }
        if (bVar.bGr != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "platform", bVar.bGr);
        }
        if (bVar.NF != null && !bVar.NF.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deviceModel", bVar.NF);
        }
        if (bVar.NG != null && !bVar.NG.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deviceBrand", bVar.NG);
        }
        if (bVar.bGs != null && !bVar.bGs.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deviceSig", bVar.bGs);
        }
        if (bVar.bGt != null && !bVar.bGt.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "eGid", bVar.bGt);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "appPackageName", bVar.bGu);
        if (bVar.bGv != null && !bVar.bGv.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "uaidToken", bVar.bGv);
        }
        if (bVar.uaid != null && !bVar.uaid.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "uaid", bVar.uaid);
        }
        if (bVar.bGw != null && !bVar.bGw.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "arch", bVar.bGw);
        }
        if (bVar.bGx != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "screenDirection", bVar.bGx);
        }
        if (bVar.bGy != null && !bVar.bGy.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "kwaiVersionName", bVar.bGy);
        }
        if (bVar.bGz != null && !bVar.bGz.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "kwaiNebulaVersionName", bVar.bGz);
        }
        if (bVar.bGA != null && !bVar.bGA.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "wechatVersionName", bVar.bGA);
        }
        if (bVar.bGB != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sourceFlag", bVar.bGB);
        }
        if (bVar.bGC != null && !bVar.bGC.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "systemBootTime", bVar.bGC);
        }
        if (bVar.bGD != null && !bVar.bGD.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "systemUpdateTime", bVar.bGD);
        }
        if (bVar.bGE != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "probeBatch", bVar.bGE);
        }
        return jSONObject;
    }
}
