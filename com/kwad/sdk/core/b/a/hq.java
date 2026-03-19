package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.bm;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class hq implements com.kwad.sdk.core.d<bm.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((bm.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((bm.a) bVar, jSONObject);
    }

    private static void a(bm.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.oz = jSONObject.optInt("itemClickType");
    }

    private static JSONObject b(bm.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.oz != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "itemClickType", aVar.oz);
        }
        return jSONObject;
    }
}
