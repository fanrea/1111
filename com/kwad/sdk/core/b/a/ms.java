package com.kwad.sdk.core.b.a;

import com.kwad.sdk.n.a.b;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ms implements com.kwad.sdk.core.d<b.C0629b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((b.C0629b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((b.C0629b) bVar, jSONObject);
    }

    private static void a(b.C0629b c0629b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0629b.name = jSONObject.optString("name");
        if (JSONObject.NULL.toString().equals(c0629b.name)) {
            c0629b.name = "";
        }
        c0629b.cki = jSONObject.optBoolean("isStatic");
        c0629b.ckj = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("paramList");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                b.a aVar = new b.a();
                aVar.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                c0629b.ckj.add(aVar);
            }
        }
    }

    private static JSONObject b(b.C0629b c0629b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (c0629b.name != null && !c0629b.name.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "name", c0629b.name);
        }
        if (c0629b.cki) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isStatic", c0629b.cki);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "paramList", c0629b.ckj);
        return jSONObject;
    }
}
