package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.h.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class mq implements com.kwad.sdk.core.d<a.C0588a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((a.C0588a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((a.C0588a) bVar, jSONObject);
    }

    private static void a(a.C0588a c0588a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0588a.bIe = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("sdk_version");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                c0588a.bIe.add((String) jSONArrayOptJSONArray.opt(i));
            }
        }
        c0588a.bIf = jSONObject.optInt("os_version");
        c0588a.bIg = new ArrayList();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("abi");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                c0588a.bIg.add((String) jSONArrayOptJSONArray2.opt(i2));
            }
        }
        c0588a.bIh = new ArrayList();
        JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("brand");
        if (jSONArrayOptJSONArray3 != null) {
            for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                c0588a.bIh.add((String) jSONArrayOptJSONArray3.opt(i3));
            }
        }
    }

    private static JSONObject b(a.C0588a c0588a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "sdk_version", c0588a.bIe);
        if (c0588a.bIf != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "os_version", c0588a.bIf);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "abi", c0588a.bIg);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "brand", c0588a.bIh);
        return jSONObject;
    }
}
