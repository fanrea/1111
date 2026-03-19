package com.kwad.sdk.core.b.a;

import com.kwad.sdk.n.a.b;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class js implements com.kwad.sdk.core.d<b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((b.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((b.a) bVar, jSONObject);
    }

    private static void a(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.ckd = jSONObject.optString("typeStr");
        if (JSONObject.NULL.toString().equals(aVar.ckd)) {
            aVar.ckd = "";
        }
        aVar.cke = jSONObject.optString("valueStr");
        if (JSONObject.NULL.toString().equals(aVar.cke)) {
            aVar.cke = "";
        }
        aVar.ckf = jSONObject.optString("listValueType");
        if (JSONObject.NULL.toString().equals(aVar.ckf)) {
            aVar.ckf = "";
        }
        aVar.ckg = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("valueStrList");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                aVar.ckg.add((String) jSONArrayOptJSONArray.opt(i));
            }
        }
        aVar.fieldName = jSONObject.optString("fieldName");
        if (JSONObject.NULL.toString().equals(aVar.fieldName)) {
            aVar.fieldName = "";
        }
        aVar.className = jSONObject.optString("className");
        if (JSONObject.NULL.toString().equals(aVar.className)) {
            aVar.className = "";
        }
        aVar.ckh = new ArrayList();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("childParamList");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                b.a aVar2 = new b.a();
                aVar2.parseJson(jSONArrayOptJSONArray2.optJSONObject(i2));
                aVar.ckh.add(aVar2);
            }
        }
    }

    private static JSONObject b(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.ckd != null && !aVar.ckd.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "typeStr", aVar.ckd);
        }
        if (aVar.cke != null && !aVar.cke.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "valueStr", aVar.cke);
        }
        if (aVar.ckf != null && !aVar.ckf.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "listValueType", aVar.ckf);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "valueStrList", aVar.ckg);
        if (aVar.fieldName != null && !aVar.fieldName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "fieldName", aVar.fieldName);
        }
        if (aVar.className != null && !aVar.className.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "className", aVar.className);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "childParamList", aVar.ckh);
        return jSONObject;
    }
}
