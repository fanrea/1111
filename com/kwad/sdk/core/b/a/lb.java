package com.kwad.sdk.core.b.a;

import com.kwad.sdk.commercial.model.SDKInitMsg;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class lb implements com.kwad.sdk.core.d<SDKInitMsg> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((SDKInitMsg) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((SDKInitMsg) bVar, jSONObject);
    }

    private static void a(SDKInitMsg sDKInitMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        sDKInitMsg.launchIntervalTime = jSONObject.optLong("init_launch_interval_time");
        sDKInitMsg.totalDurationTime = jSONObject.optLong("init_total_duration_time");
        sDKInitMsg.initStatus = jSONObject.optInt("init_status", new Integer("0").intValue());
        sDKInitMsg.errorReason = jSONObject.optString("error_reason");
        if (JSONObject.NULL.toString().equals(sDKInitMsg.errorReason)) {
            sDKInitMsg.errorReason = "";
        }
        sDKInitMsg.initCount = jSONObject.optInt("init_count");
        sDKInitMsg.initProcess = jSONObject.optInt("init_process");
        sDKInitMsg.initThread = jSONObject.optInt("init_thread");
        sDKInitMsg.intDynamicSDK = jSONObject.optInt("init_dynamic_sdk");
        sDKInitMsg.intBuildNumber = jSONObject.optInt("init_build_number");
    }

    private static JSONObject b(SDKInitMsg sDKInitMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (sDKInitMsg.launchIntervalTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "init_launch_interval_time", sDKInitMsg.launchIntervalTime);
        }
        if (sDKInitMsg.totalDurationTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "init_total_duration_time", sDKInitMsg.totalDurationTime);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "init_status", sDKInitMsg.initStatus);
        if (sDKInitMsg.errorReason != null && !sDKInitMsg.errorReason.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "error_reason", sDKInitMsg.errorReason);
        }
        if (sDKInitMsg.initCount != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "init_count", sDKInitMsg.initCount);
        }
        if (sDKInitMsg.initProcess != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "init_process", sDKInitMsg.initProcess);
        }
        if (sDKInitMsg.initThread != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "init_thread", sDKInitMsg.initThread);
        }
        if (sDKInitMsg.intDynamicSDK != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "init_dynamic_sdk", sDKInitMsg.intDynamicSDK);
        }
        if (sDKInitMsg.intBuildNumber != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "init_build_number", sDKInitMsg.intBuildNumber);
        }
        return jSONObject;
    }
}
