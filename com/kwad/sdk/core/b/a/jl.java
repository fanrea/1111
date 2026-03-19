package com.kwad.sdk.core.b.a;

import com.baidu.mobstat.forbes.Config;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class jl implements com.kwad.sdk.core.d<com.kwad.sdk.h.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.h.a.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.h.a.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.h.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.packageId = jSONObject.optString("packageId");
        if (JSONObject.NULL.toString().equals(bVar.packageId)) {
            bVar.packageId = "";
        }
        bVar.cbm = jSONObject.optString("zipFileName");
        if (JSONObject.NULL.toString().equals(bVar.cbm)) {
            bVar.cbm = "";
        }
        bVar.cbn = jSONObject.optString("zipPath");
        if (JSONObject.NULL.toString().equals(bVar.cbn)) {
            bVar.cbn = "";
        }
        bVar.packageUrl = jSONObject.optString("packageUrl");
        if (JSONObject.NULL.toString().equals(bVar.packageUrl)) {
            bVar.packageUrl = "";
        }
        bVar.version = jSONObject.optString(Config.INPUT_DEF_VERSION);
        if (JSONObject.NULL.toString().equals(bVar.version)) {
            bVar.version = "";
        }
        bVar.biL = jSONObject.optString("checksum");
        if (JSONObject.NULL.toString().equals(bVar.biL)) {
            bVar.biL = "";
        }
        bVar.loadType = jSONObject.optInt("loadType");
        bVar.packageType = jSONObject.optInt("packageType");
        bVar.cbp = jSONObject.optBoolean("public");
    }

    private static JSONObject b(com.kwad.sdk.h.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.packageId != null && !bVar.packageId.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "packageId", bVar.packageId);
        }
        if (bVar.cbm != null && !bVar.cbm.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "zipFileName", bVar.cbm);
        }
        if (bVar.cbn != null && !bVar.cbn.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "zipPath", bVar.cbn);
        }
        if (bVar.packageUrl != null && !bVar.packageUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "packageUrl", bVar.packageUrl);
        }
        if (bVar.version != null && !bVar.version.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, Config.INPUT_DEF_VERSION, bVar.version);
        }
        if (bVar.biL != null && !bVar.biL.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "checksum", bVar.biL);
        }
        if (bVar.loadType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "loadType", bVar.loadType);
        }
        if (bVar.packageType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "packageType", bVar.packageType);
        }
        if (bVar.cbp) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "public", bVar.cbp);
        }
        return jSONObject;
    }
}
