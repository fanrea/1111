package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.tachikoma.b.x;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class bn implements com.kwad.sdk.core.d<x.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((x.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((x.a) bVar, jSONObject);
    }

    private static void a(x.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aiO = jSONObject.optBoolean("hasLoseAudioFocus");
        aVar.aiP = jSONObject.optInt("audioFocusStatus");
    }

    private static JSONObject b(x.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.aiO) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "hasLoseAudioFocus", aVar.aiO);
        }
        if (aVar.aiP != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "audioFocusStatus", aVar.aiP);
        }
        return jSONObject;
    }
}
