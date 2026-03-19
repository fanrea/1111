package com.kwad.sdk.core.b.a;

import com.baidu.mobstat.forbes.Config;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class fa implements com.kwad.sdk.core.d<com.kwad.sdk.crash.model.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.crash.model.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.crash.model.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.crash.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.bNN = jSONObject.optInt("funcSwitch");
        bVar.bNO = jSONObject.optString("minSdkVersion");
        if (JSONObject.NULL.toString().equals(bVar.bNO)) {
            bVar.bNO = "";
        }
        bVar.bNP = jSONObject.optString("maxSdkVersionExclude");
        if (JSONObject.NULL.toString().equals(bVar.bNP)) {
            bVar.bNP = "";
        }
        bVar.sdkType = jSONObject.optInt("sdkType");
        bVar.bNQ = jSONObject.optString("md5V7");
        if (JSONObject.NULL.toString().equals(bVar.bNQ)) {
            bVar.bNQ = "";
        }
        bVar.bNR = jSONObject.optString("md5V8");
        if (JSONObject.NULL.toString().equals(bVar.bNR)) {
            bVar.bNR = "";
        }
        bVar.version = jSONObject.optString(Config.INPUT_DEF_VERSION);
        if (JSONObject.NULL.toString().equals(bVar.version)) {
            bVar.version = "";
        }
        bVar.bNS = jSONObject.optString("v7Url");
        if (JSONObject.NULL.toString().equals(bVar.bNS)) {
            bVar.bNS = "";
        }
        bVar.bNT = jSONObject.optString("v8Url");
        if (JSONObject.NULL.toString().equals(bVar.bNT)) {
            bVar.bNT = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.crash.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.bNN != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "funcSwitch", bVar.bNN);
        }
        if (bVar.bNO != null && !bVar.bNO.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "minSdkVersion", bVar.bNO);
        }
        if (bVar.bNP != null && !bVar.bNP.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "maxSdkVersionExclude", bVar.bNP);
        }
        if (bVar.sdkType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkType", bVar.sdkType);
        }
        if (bVar.bNQ != null && !bVar.bNQ.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "md5V7", bVar.bNQ);
        }
        if (bVar.bNR != null && !bVar.bNR.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "md5V8", bVar.bNR);
        }
        if (bVar.version != null && !bVar.version.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, Config.INPUT_DEF_VERSION, bVar.version);
        }
        if (bVar.bNS != null && !bVar.bNS.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "v7Url", bVar.bNS);
        }
        if (bVar.bNT != null && !bVar.bNT.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "v8Url", bVar.bNT);
        }
        return jSONObject;
    }
}
