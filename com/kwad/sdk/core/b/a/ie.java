package com.kwad.sdk.core.b.a;

import com.ss.texturerender.TextureRenderKeys;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ie implements com.kwad.sdk.core.d<com.kwad.components.ct.c.a.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ct.c.a.c) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ct.c.a.c) bVar, jSONObject);
    }

    private static void a(com.kwad.components.ct.c.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.anf = jSONObject.optString("action");
        if (JSONObject.NULL.toString().equals(cVar.anf)) {
            cVar.anf = "";
        }
        cVar.params = jSONObject.optString("params");
        if (JSONObject.NULL.toString().equals(cVar.params)) {
            cVar.params = "";
        }
        cVar.aQX = jSONObject.optString(TextureRenderKeys.KEY_IS_CALLBACK);
        if (JSONObject.NULL.toString().equals(cVar.aQX)) {
            cVar.aQX = "";
        }
    }

    private static JSONObject b(com.kwad.components.ct.c.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (cVar.anf != null && !cVar.anf.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "action", cVar.anf);
        }
        if (cVar.params != null && !cVar.params.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "params", cVar.params);
        }
        if (cVar.aQX != null && !cVar.aQX.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, TextureRenderKeys.KEY_IS_CALLBACK, cVar.aQX);
        }
        return jSONObject;
    }
}
