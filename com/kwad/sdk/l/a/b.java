package com.kwad.sdk.l.a;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bi;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    public int cjv;
    public int cjw;
    public int cjx;

    public b(int i, int i2, int i3) {
        this.cjv = i;
        this.cjw = i2;
        this.cjx = i3;
    }

    public static synchronized b ang() {
        if (!((h) ServiceProvider.get(h.class)).Ud()) {
            return null;
        }
        return bi.ang();
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        a(this, jSONObject);
        super.afterParseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        return b(this, new JSONObject());
    }

    private static void a(b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.cjv = jSONObject.optInt("cellId", -1);
        bVar.cjw = jSONObject.optInt("lac", -1);
        bVar.cjx = jSONObject.optInt("bsss", -1);
    }

    private static JSONObject b(b bVar, JSONObject jSONObject) {
        aa.putValue(jSONObject, "cellId", bVar.cjv);
        aa.putValue(jSONObject, "lac", bVar.cjw);
        aa.putValue(jSONObject, "bsss", bVar.cjx);
        return jSONObject;
    }
}
