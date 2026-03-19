package com.kwad.sdk.core.request.model;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.be;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class c implements com.kwad.sdk.core.b {
    private static c bGF;
    private double latitude;
    private double longitude;
    private int type;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "latitude", this.latitude);
        aa.putValue(jSONObject, "longitude", this.longitude);
        aa.putValue(jSONObject, "type", this.type);
        return jSONObject;
    }

    public static c abD() {
        c cVar = bGF;
        if (cVar != null) {
            return cVar;
        }
        try {
            bGF = new c();
            com.kwad.sdk.utils.c.a aVarDj = be.dj(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext());
            if (aVarDj != null && aVarDj.cpr != null) {
                bGF.latitude = aVarDj.cpr.getLatitude();
                bGF.longitude = aVarDj.cpr.getLongitude();
                bGF.type = aVarDj.type;
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return bGF;
    }
}
