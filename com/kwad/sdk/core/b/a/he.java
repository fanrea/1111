package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.j.b;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class he implements com.kwad.sdk.core.d<b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((b.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((b.a) bVar, jSONObject);
    }

    private static void a(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.NF = jSONObject.optString("device_model");
        if (JSONObject.NULL.toString().equals(aVar.NF)) {
            aVar.NF = "";
        }
        aVar.NG = jSONObject.optString("device_brand");
        if (JSONObject.NULL.toString().equals(aVar.NG)) {
            aVar.NG = "";
        }
        aVar.NH = jSONObject.optString("os_version");
        if (JSONObject.NULL.toString().equals(aVar.NH)) {
            aVar.NH = "";
        }
        aVar.NI = jSONObject.optString("rom_name");
        if (JSONObject.NULL.toString().equals(aVar.NI)) {
            aVar.NI = "";
        }
        aVar.NJ = jSONObject.optString(com.baidu.mobads.upgrade.remote.gray.c.l);
        if (JSONObject.NULL.toString().equals(aVar.NJ)) {
            aVar.NJ = "";
        }
        aVar.status = jSONObject.optInt("status");
        aVar.NK = jSONObject.optString("install_check_record");
        if (JSONObject.NULL.toString().equals(aVar.NK)) {
            aVar.NK = "";
        }
        aVar.NL = jSONObject.optString("local_installer_pkgs");
        if (JSONObject.NULL.toString().equals(aVar.NL)) {
            aVar.NL = "";
        }
    }

    private static JSONObject b(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.NF != null && !aVar.NF.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "device_model", aVar.NF);
        }
        if (aVar.NG != null && !aVar.NG.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "device_brand", aVar.NG);
        }
        if (aVar.NH != null && !aVar.NH.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "os_version", aVar.NH);
        }
        if (aVar.NI != null && !aVar.NI.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "rom_name", aVar.NI);
        }
        if (aVar.NJ != null && !aVar.NJ.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, com.baidu.mobads.upgrade.remote.gray.c.l, aVar.NJ);
        }
        if (aVar.status != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "status", aVar.status);
        }
        if (aVar.NK != null && !aVar.NK.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "install_check_record", aVar.NK);
        }
        if (aVar.NL != null && !aVar.NL.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "local_installer_pkgs", aVar.NL);
        }
        return jSONObject;
    }
}
