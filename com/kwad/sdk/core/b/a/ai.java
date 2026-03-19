package com.kwad.sdk.core.b.a;

import com.sigmob.sdk.base.mta.PointType;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ai implements com.kwad.sdk.core.d<com.kwad.sdk.core.adlog.a.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.adlog.a.c) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.adlog.a.c) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.adlog.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.bvN = jSONObject.optBoolean("retrySwitch");
        cVar.bvO = jSONObject.optInt("retryCountConfig", new Integer("1").intValue());
        cVar.bvP = jSONObject.optLong("cacheExpireTime", new Long("600").longValue());
        cVar.bvQ = jSONObject.optInt("retryQueueSize", new Integer(PointType.SIGMOB_APP).intValue());
        cVar.bvR = jSONObject.optBoolean("retryCountFeeOnly");
    }

    private static JSONObject b(com.kwad.sdk.core.adlog.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (cVar.bvN) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "retrySwitch", cVar.bvN);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "retryCountConfig", cVar.bvO);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "cacheExpireTime", cVar.bvP);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "retryQueueSize", cVar.bvQ);
        if (cVar.bvR) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "retryCountFeeOnly", cVar.bvR);
        }
        return jSONObject;
    }
}
