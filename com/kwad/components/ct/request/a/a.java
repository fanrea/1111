package com.kwad.components.ct.request.a;

import com.kwad.sdk.core.b;
import com.kwad.sdk.utils.aa;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a implements b {
    public int aUY;
    public int contentType = 0;
    public int aUW = 0;
    public int nm = 0;
    public int aUX = 0;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "contentType", this.contentType);
        aa.putValue(jSONObject, "allowInsertThirdAd", this.aUW);
        aa.putValue(jSONObject, "slideType", this.nm);
        aa.putValue(jSONObject, "requestCount", this.aUX);
        aa.putValue(jSONObject, "loadedCount", this.aUY);
        return jSONObject;
    }
}
