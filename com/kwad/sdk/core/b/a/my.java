package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class my implements com.kwad.sdk.core.d<com.kwad.sdk.core.threads.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.threads.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.threads.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.threads.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.bHI = jSONObject.optString("pool_name");
        if (JSONObject.NULL.toString().equals(bVar.bHI)) {
            bVar.bHI = "";
        }
        bVar.bHJ = jSONObject.optInt("core_pool_size");
        bVar.bHK = jSONObject.optInt("max_pool_size");
        bVar.bHL = jSONObject.optInt("current_pool_size");
        bVar.bHM = jSONObject.optInt("active_count");
        bVar.bHN = jSONObject.optLong("task_wait_avg_ms");
        bVar.bHO = jSONObject.optLong("task_succ_count");
        bVar.interval = jSONObject.optLong("interval_ms");
        bVar.bHP = jSONObject.optInt("queue_size");
        bVar.bHQ = jSONObject.optLong("pass_timestamp");
        bVar.bHR = jSONObject.optInt("func_ratio_count");
    }

    private static JSONObject b(com.kwad.sdk.core.threads.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.bHI != null && !bVar.bHI.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pool_name", bVar.bHI);
        }
        if (bVar.bHJ != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "core_pool_size", bVar.bHJ);
        }
        if (bVar.bHK != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "max_pool_size", bVar.bHK);
        }
        if (bVar.bHL != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "current_pool_size", bVar.bHL);
        }
        if (bVar.bHM != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "active_count", bVar.bHM);
        }
        if (bVar.bHN != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "task_wait_avg_ms", bVar.bHN);
        }
        if (bVar.bHO != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "task_succ_count", bVar.bHO);
        }
        if (bVar.interval != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "interval_ms", bVar.interval);
        }
        if (bVar.bHP != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "queue_size", bVar.bHP);
        }
        if (bVar.bHQ != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pass_timestamp", bVar.bHQ);
        }
        if (bVar.bHR != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "func_ratio_count", bVar.bHR);
        }
        return jSONObject;
    }
}
