package com.kwad.sdk.core.webview.c;

import com.kwad.sdk.utils.aa;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class f implements com.kwad.sdk.core.b {
    public final com.kwad.sdk.core.b bMk;
    public final int result = 1;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
    }

    public f(com.kwad.sdk.core.b bVar) {
        this.bMk = bVar;
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "result", this.result);
        aa.a(jSONObject, "data", this.bMk);
        return jSONObject;
    }
}
