package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.a.a;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ck implements com.kwad.sdk.core.d<a.C0491a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((a.C0491a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((a.C0491a) bVar, jSONObject);
    }

    private static void a(a.C0491a c0491a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0491a.agH = jSONObject.optString("android");
        if (JSONObject.NULL.toString().equals(c0491a.agH)) {
            c0491a.agH = "";
        }
    }

    private static JSONObject b(a.C0491a c0491a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (c0491a.agH != null && !c0491a.agH.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "android", c0491a.agH);
        }
        return jSONObject;
    }
}
