package com.kwad.sdk.core.b.a;

import com.kwad.components.ct.coupon.bridge.d;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class jr implements com.kwad.sdk.core.d<d.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((d.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((d.b) bVar, jSONObject);
    }

    private static void a(d.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.ang = jSONObject.optInt("titlebarShow");
        bVar.anh = jSONObject.optString("titleText");
        if (JSONObject.NULL.toString().equals(bVar.anh)) {
            bVar.anh = "";
        }
        bVar.ani = jSONObject.optString("rightBtnText");
        if (JSONObject.NULL.toString().equals(bVar.ani)) {
            bVar.ani = "";
        }
    }

    private static JSONObject b(d.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.ang != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "titlebarShow", bVar.ang);
        }
        if (bVar.anh != null && !bVar.anh.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "titleText", bVar.anh);
        }
        if (bVar.ani != null && !bVar.ani.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "rightBtnText", bVar.ani);
        }
        return jSONObject;
    }
}
