package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.a;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class al implements com.kwad.sdk.core.d<a.C0490a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((a.C0490a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((a.C0490a) bVar, jSONObject);
    }

    private static void a(a.C0490a c0490a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0490a.PD = jSONObject.optString("creativeId");
        if (JSONObject.NULL.toString().equals(c0490a.PD)) {
            c0490a.PD = "";
        }
        c0490a.adW = jSONObject.optString("targetMethod");
        if (JSONObject.NULL.toString().equals(c0490a.adW)) {
            c0490a.adW = "";
        }
        c0490a.adX = jSONObject.optString("methodParams");
        if (JSONObject.NULL.toString().equals(c0490a.adX)) {
            c0490a.adX = "";
        }
    }

    private static JSONObject b(a.C0490a c0490a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (c0490a.PD != null && !c0490a.PD.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creativeId", c0490a.PD);
        }
        if (c0490a.adW != null && !c0490a.adW.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "targetMethod", c0490a.adW);
        }
        if (c0490a.adX != null && !c0490a.adX.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "methodParams", c0490a.adX);
        }
        return jSONObject;
    }
}
