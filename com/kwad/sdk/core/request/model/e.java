package com.kwad.sdk.core.request.model;

import com.kwad.sdk.core.network.k;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class e implements com.kwad.sdk.core.b {
    private com.kwad.sdk.core.b bGJ;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
    }

    public static e abG() {
        e eVar = new e();
        try {
            eVar.bGJ = ((k) ServiceProvider.get(k.class)).TK();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return eVar;
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.a(jSONObject, "modeInfo", this.bGJ);
        return jSONObject;
    }
}
