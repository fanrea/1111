package com.kwad.sdk.core.b.a;

import com.bytedance.applog.aggregation.MetricsSQLiteCacheKt;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class mz implements com.kwad.sdk.core.d<com.kwad.sdk.core.threads.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.threads.d) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.threads.d) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.threads.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.bHV = jSONObject.optInt("rate_reciprocal");
        dVar.bHW = jSONObject.optInt("threshold");
        dVar.interval = jSONObject.optLong(MetricsSQLiteCacheKt.METRICS_INTERVAL);
    }

    private static JSONObject b(com.kwad.sdk.core.threads.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (dVar.bHV != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "rate_reciprocal", dVar.bHV);
        }
        if (dVar.bHW != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "threshold", dVar.bHW);
        }
        if (dVar.interval != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, MetricsSQLiteCacheKt.METRICS_INTERVAL, dVar.interval);
        }
        return jSONObject;
    }
}
