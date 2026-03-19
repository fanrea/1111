package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.j;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class gb implements com.kwad.sdk.core.d<j.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((j.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((j.b) bVar, jSONObject);
    }

    private static void a(j.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aeh = jSONObject.optInt("playableSrc");
        bVar.aei = jSONObject.optInt("isMiddleEnd");
        bVar.SS = jSONObject.optInt("adType");
        bVar.aej = jSONObject.optString("showTime");
        if (JSONObject.NULL.toString().equals(bVar.aej)) {
            bVar.aej = "";
        }
    }

    private static JSONObject b(j.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.aeh != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playableSrc", bVar.aeh);
        }
        if (bVar.aei != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isMiddleEnd", bVar.aei);
        }
        if (bVar.SS != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adType", bVar.SS);
        }
        if (bVar.aej != null && !bVar.aej.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "showTime", bVar.aej);
        }
        return jSONObject;
    }
}
