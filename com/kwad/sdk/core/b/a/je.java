package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class je implements com.kwad.sdk.core.d<com.kwad.sdk.core.network.j> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.network.j) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.network.j) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jVar.bCR = jSONObject.optLong("request_prepare_cost");
        jVar.bCS = jSONObject.optLong("request_add_params_cost");
        jVar.bCT = jSONObject.optLong("request_create_cost");
        jVar.bCU = jSONObject.optInt("keep_alive");
        jVar.bCV = jSONObject.optLong("dns_start");
        jVar.bCW = jSONObject.optLong("dns_cost");
        jVar.bCX = jSONObject.optLong("connect_establish_start");
        jVar.bCY = jSONObject.optLong("connect_establish_cost");
        jVar.bCZ = jSONObject.optLong("request_start");
        jVar.bDa = jSONObject.optLong("request_cost");
        jVar.bDb = jSONObject.optLong("request_size");
        jVar.bDc = jSONObject.optLong("response_start");
        jVar.bDd = jSONObject.optLong("response_cost");
        jVar.bDe = jSONObject.optLong("response_parse_cost");
        jVar.bDf = jSONObject.optLong("response_size");
        jVar.bDg = jSONObject.optLong("waiting_response_cost");
        jVar.bDh = jSONObject.optLong("total_cost");
        jVar.bDi = jSONObject.optInt("proxy_used");
        jVar.bDj = jSONObject.optString("request_id");
        if (JSONObject.NULL.toString().equals(jVar.bDj)) {
            jVar.bDj = "";
        }
        jVar.bDk = jSONObject.optInt("has_data_v2");
        jVar.result = jSONObject.optInt("result");
        jVar.bDl = jSONObject.optLong("response_done_cost");
        jVar.bDm = jSONObject.optString("host_ip");
        if (JSONObject.NULL.toString().equals(jVar.bDm)) {
            jVar.bDm = "";
        }
        jVar.bDn = jSONObject.optInt("ip_type");
        jVar.bDo = jSONObject.optInt("recommend_ping_time");
        jVar.bDp = jSONObject.optInt("backup_ping_time");
        jVar.bDq = jSONObject.optInt("other_ping_time");
    }

    private static JSONObject b(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (jVar.bCR != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "request_prepare_cost", jVar.bCR);
        }
        if (jVar.bCS != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "request_add_params_cost", jVar.bCS);
        }
        if (jVar.bCT != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "request_create_cost", jVar.bCT);
        }
        if (jVar.bCU != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "keep_alive", jVar.bCU);
        }
        if (jVar.bCV != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "dns_start", jVar.bCV);
        }
        if (jVar.bCW != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "dns_cost", jVar.bCW);
        }
        if (jVar.bCX != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "connect_establish_start", jVar.bCX);
        }
        if (jVar.bCY != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "connect_establish_cost", jVar.bCY);
        }
        if (jVar.bCZ != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "request_start", jVar.bCZ);
        }
        if (jVar.bDa != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "request_cost", jVar.bDa);
        }
        if (jVar.bDb != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "request_size", jVar.bDb);
        }
        if (jVar.bDc != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "response_start", jVar.bDc);
        }
        if (jVar.bDd != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "response_cost", jVar.bDd);
        }
        if (jVar.bDe != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "response_parse_cost", jVar.bDe);
        }
        if (jVar.bDf != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "response_size", jVar.bDf);
        }
        if (jVar.bDg != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "waiting_response_cost", jVar.bDg);
        }
        if (jVar.bDh != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "total_cost", jVar.bDh);
        }
        if (jVar.bDi != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "proxy_used", jVar.bDi);
        }
        if (jVar.bDj != null && !jVar.bDj.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "request_id", jVar.bDj);
        }
        if (jVar.bDk != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "has_data_v2", jVar.bDk);
        }
        if (jVar.result != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "result", jVar.result);
        }
        if (jVar.bDl != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "response_done_cost", jVar.bDl);
        }
        if (jVar.bDm != null && !jVar.bDm.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "host_ip", jVar.bDm);
        }
        if (jVar.bDn != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ip_type", jVar.bDn);
        }
        if (jVar.bDo != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "recommend_ping_time", jVar.bDo);
        }
        if (jVar.bDp != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "backup_ping_time", jVar.bDp);
        }
        if (jVar.bDq != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "other_ping_time", jVar.bDq);
        }
        return jSONObject;
    }
}
