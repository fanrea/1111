package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ny implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.c.z> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.tachikoma.c.z) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.tachikoma.c.z) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.tachikoma.c.z zVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        zVar.sp = jSONObject.optInt("currentTime");
        zVar.ajo = jSONObject.optBoolean(com.alipay.sdk.m.u.h.i);
        zVar.Yk = jSONObject.optBoolean("finished");
    }

    private static JSONObject b(com.kwad.components.core.webview.tachikoma.c.z zVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (zVar.sp != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "currentTime", zVar.sp);
        }
        if (zVar.ajo) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, com.alipay.sdk.m.u.h.i, zVar.ajo);
        }
        if (zVar.Yk) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "finished", zVar.Yk);
        }
        return jSONObject;
    }
}
