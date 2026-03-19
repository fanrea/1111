package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.tachikoma.b.u;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ma implements com.kwad.sdk.core.d<u.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((u.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((u.b) bVar, jSONObject);
    }

    private static void a(u.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("status");
        bVar.errorCode = jSONObject.optInt("errorCode");
        bVar.errorMsg = jSONObject.optString("errorMsg");
        if (JSONObject.NULL.toString().equals(bVar.errorMsg)) {
            bVar.errorMsg = "";
        }
    }

    private static JSONObject b(u.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.status != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "status", bVar.status);
        }
        if (bVar.errorCode != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "errorCode", bVar.errorCode);
        }
        if (bVar.errorMsg != null && !bVar.errorMsg.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "errorMsg", bVar.errorMsg);
        }
        return jSONObject;
    }
}
