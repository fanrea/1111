package com.kwad.sdk.core.b.a;

import com.kwad.sdk.n.b;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class kl implements com.kwad.sdk.core.d<com.kwad.sdk.n.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.n.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.n.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.n.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.funcSwitch = jSONObject.optLong("funcSwitch");
        bVar.cjN = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("urlList");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                bVar.cjN.add((String) jSONArrayOptJSONArray.opt(i));
            }
        }
        bVar.cjO = new ArrayList();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("actConfigList");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                b.a aVar = new b.a();
                aVar.parseJson(jSONArrayOptJSONArray2.optJSONObject(i2));
                bVar.cjO.add(aVar);
            }
        }
        bVar.byteCount = jSONObject.optLong("byteCount");
        bVar.sampleRate = jSONObject.optDouble("sampleRate");
        bVar.cjP = new ArrayList();
        JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("anchorNodeList");
        if (jSONArrayOptJSONArray3 != null) {
            for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                com.kwad.sdk.n.a.b bVar2 = new com.kwad.sdk.n.a.b();
                bVar2.parseJson(jSONArrayOptJSONArray3.optJSONObject(i3));
                bVar.cjP.add(bVar2);
            }
        }
        bVar.cjI = new ArrayList();
        JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("aggregationCheckConfigList");
        if (jSONArrayOptJSONArray4 != null) {
            for (int i4 = 0; i4 < jSONArrayOptJSONArray4.length(); i4++) {
                com.kwad.sdk.n.a.a aVar2 = new com.kwad.sdk.n.a.a();
                aVar2.parseJson(jSONArrayOptJSONArray4.optJSONObject(i4));
                bVar.cjI.add(aVar2);
            }
        }
    }

    private static JSONObject b(com.kwad.sdk.n.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.funcSwitch != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "funcSwitch", bVar.funcSwitch);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "urlList", bVar.cjN);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "actConfigList", bVar.cjO);
        if (bVar.byteCount != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "byteCount", bVar.byteCount);
        }
        if (bVar.sampleRate != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sampleRate", bVar.sampleRate);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "anchorNodeList", bVar.cjP);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "aggregationCheckConfigList", bVar.cjI);
        return jSONObject;
    }
}
