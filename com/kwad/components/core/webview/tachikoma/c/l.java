package com.kwad.components.core.webview.tachikoma.c;

import com.kwad.sdk.utils.aa;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class l extends com.kwad.sdk.core.response.a.a {
    public int ajc;
    public int ajd = -1;
    public int aje;

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "insertScreenAdShowStrategy", this.ajc);
        aa.putValue(jSONObject, "isAutoShow", this.aje);
        int i = this.ajd;
        if (i != -1) {
            aa.putValue(jSONObject, "triggerType", i);
        }
        return jSONObject;
    }
}
