package com.kwad.sdk.core.b.a;

import com.kwad.sdk.mobileid.UaidInfo;
import com.kwai.middleware.azeroth.network.NetworkDefine;
import com.sigmob.sdk.base.mta.PointParamKey;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ni implements com.kwad.sdk.core.d<UaidInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((UaidInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((UaidInfo) bVar, jSONObject);
    }

    private static void a(UaidInfo uaidInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        uaidInfo.status = jSONObject.optInt("status");
        uaidInfo.canRequest = jSONObject.optString("can_request");
        if (JSONObject.NULL.toString().equals(uaidInfo.canRequest)) {
            uaidInfo.canRequest = "";
        }
        uaidInfo.traceId = jSONObject.optString(PointParamKey.TRACE_ID);
        if (JSONObject.NULL.toString().equals(uaidInfo.traceId)) {
            uaidInfo.traceId = "";
        }
        uaidInfo.operatorType = jSONObject.optInt("operator_type");
        uaidInfo.networkType = jSONObject.optInt("network_type");
        uaidInfo.dcontrollerEnableNetwork = jSONObject.optBoolean("dcontroller_enable_network");
        uaidInfo.dcontrollerEnablePhoneState = jSONObject.optBoolean("dcontroller_enable_phone_state");
        uaidInfo.imsiNotEmpty = jSONObject.optBoolean("imsi_not_empty");
        uaidInfo.uaid = jSONObject.optString("uaid");
        if (JSONObject.NULL.toString().equals(uaidInfo.uaid)) {
            uaidInfo.uaid = "";
        }
        uaidInfo.result = jSONObject.optInt("result");
        uaidInfo.token = jSONObject.optString(NetworkDefine.PARAM_TOKEN);
        if (JSONObject.NULL.toString().equals(uaidInfo.token)) {
            uaidInfo.token = "";
        }
        uaidInfo.errorCode = jSONObject.optString("error_code");
        if (JSONObject.NULL.toString().equals(uaidInfo.errorCode)) {
            uaidInfo.errorCode = "";
        }
        uaidInfo.errorMsg = jSONObject.optString("error_msg");
        if (JSONObject.NULL.toString().equals(uaidInfo.errorMsg)) {
            uaidInfo.errorMsg = "";
        }
    }

    private static JSONObject b(UaidInfo uaidInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (uaidInfo.status != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "status", uaidInfo.status);
        }
        if (uaidInfo.canRequest != null && !uaidInfo.canRequest.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "can_request", uaidInfo.canRequest);
        }
        if (uaidInfo.traceId != null && !uaidInfo.traceId.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, PointParamKey.TRACE_ID, uaidInfo.traceId);
        }
        if (uaidInfo.operatorType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "operator_type", uaidInfo.operatorType);
        }
        if (uaidInfo.networkType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "network_type", uaidInfo.networkType);
        }
        if (uaidInfo.dcontrollerEnableNetwork) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "dcontroller_enable_network", uaidInfo.dcontrollerEnableNetwork);
        }
        if (uaidInfo.dcontrollerEnablePhoneState) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "dcontroller_enable_phone_state", uaidInfo.dcontrollerEnablePhoneState);
        }
        if (uaidInfo.imsiNotEmpty) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "imsi_not_empty", uaidInfo.imsiNotEmpty);
        }
        if (uaidInfo.uaid != null && !uaidInfo.uaid.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "uaid", uaidInfo.uaid);
        }
        if (uaidInfo.result != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "result", uaidInfo.result);
        }
        if (uaidInfo.token != null && !uaidInfo.token.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, NetworkDefine.PARAM_TOKEN, uaidInfo.token);
        }
        if (uaidInfo.errorCode != null && !uaidInfo.errorCode.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "error_code", uaidInfo.errorCode);
        }
        if (uaidInfo.errorMsg != null && !uaidInfo.errorMsg.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "error_msg", uaidInfo.errorMsg);
        }
        return jSONObject;
    }
}
