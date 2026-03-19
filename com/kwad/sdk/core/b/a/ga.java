package com.kwad.sdk.core.b.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.kwad.components.core.webview.jshandler.j;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ga implements com.kwad.sdk.core.d<j.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((j.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((j.a) bVar, jSONObject);
    }

    private static void a(j.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aeg = jSONObject.optString(TypedValues.AttributesType.S_TARGET);
        if (JSONObject.NULL.toString().equals(aVar.aeg)) {
            aVar.aeg = "";
        }
    }

    private static JSONObject b(j.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.aeg != null && !aVar.aeg.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, TypedValues.AttributesType.S_TARGET, aVar.aeg);
        }
        return jSONObject;
    }
}
