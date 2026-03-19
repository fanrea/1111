package com.bytedance.msdk.u;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.alipay.sdk.m.t.a;
import com.baidu.mobads.container.adrequest.g;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.msdk.gb.fs;
import com.bytedance.msdk.gb.np;
import com.bytedance.msdk.gb.v;
import com.bytedance.msdk.gb.zw;
import com.bytedance.sdk.djx.core.log.ILogConst;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d implements com.bytedance.sdk.component.gb.hc.c.d.hc {
    public static final String b = UUID.randomUUID().toString();
    public final String d;
    public final JSONObject hc;

    public d(String str, JSONObject jSONObject) {
        this.d = str;
        this.hc = jSONObject;
    }

    @Override // com.bytedance.sdk.component.gb.hc.c.d.hc
    public JSONObject d(String str) {
        return this.hc;
    }

    @Override // com.bytedance.sdk.component.gb.hc.c.d.hc
    public long d() {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObject = this.hc;
        if (jSONObject != null) {
            if (jSONObject.has("params")) {
                jSONObjectOptJSONObject = this.hc.optJSONObject("params");
            } else {
                jSONObjectOptJSONObject = this.hc;
            }
            if (jSONObjectOptJSONObject != null) {
                return jSONObjectOptJSONObject.optLong(a.k);
            }
        }
        return 0L;
    }

    @Override // com.bytedance.sdk.component.gb.hc.c.d.hc
    public long hc() {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObject = this.hc;
        if (jSONObject != null) {
            if (jSONObject.has("params")) {
                jSONObjectOptJSONObject = this.hc.optJSONObject("params");
            } else {
                jSONObjectOptJSONObject = this.hc;
            }
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString("event_extra");
                if (!TextUtils.isEmpty(strOptString)) {
                    try {
                        return new JSONObject(strOptString).optLong("eventIndex");
                    } catch (JSONException unused) {
                    }
                }
            }
        }
        return 0L;
    }

    public static JSONObject d(c cVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("device_info", v.d());
            if (cVar != null) {
                jSONObject2.putOpt("type", cVar.d);
                jSONObject2.putOpt("link_id", cVar.hc);
                jSONObject2.putOpt("adn_name", cVar.b);
                jSONObject2.putOpt("ad_sdk_version", cVar.c);
                jSONObject2.putOpt("rit_cpm", cVar.h);
                jSONObject2.putOpt("mediation_rit", cVar.an);
                jSONObject2.putOpt("adtype", Integer.valueOf(cVar.w));
                jSONObject2.putOpt("error_msg", cVar.mk);
                jSONObject2.putOpt("error_code", Integer.valueOf(cVar.k));
                jSONObject2.putOpt("creative_id", cVar.mq);
                jSONObject2.putOpt("exchange_rate", cVar.sy);
                jSONObject2.putOpt("msdk_session_id", b);
                jSONObject2.putOpt("is_trusteeship_monetize", Integer.valueOf(com.bytedance.msdk.core.hc.hc().d()));
                String strHc = com.bytedance.msdk.core.mk.d.d().hc(com.bytedance.msdk.core.hc.hc().uo());
                if (strHc != null) {
                    jSONObject2.putOpt("app_abtest", strHc);
                }
                d(jSONObject2, cVar);
                b(jSONObject2, cVar);
                hc(cVar, jSONObject);
                if (!"total_load_fail".equalsIgnoreCase(cVar.d) && !"adapter_request_fail".equalsIgnoreCase(cVar.d)) {
                    jSONObject2.putOpt(g.o, TextUtils.isEmpty(cVar.u) ? cVar.hc + Config.replace + cVar.an : cVar.u);
                }
                jSONObject2.putOpt("country", com.bytedance.msdk.core.hc.hc().gb());
                com.bytedance.msdk.core.tc.d dVarD = com.bytedance.msdk.core.hc.hc().d("pangle");
                if (dVarD != null) {
                    jSONObject2.putOpt(com.alipay.sdk.m.k.b.D0, dVarD.d());
                } else {
                    jSONObject2.putOpt(com.alipay.sdk.m.k.b.D0, com.bytedance.msdk.core.d.mk().mq());
                }
                if (cVar.tt != 0) {
                    jSONObject2.putOpt("waterfall_id", Long.valueOf(cVar.tt));
                }
                if (!TextUtils.isEmpty(cVar.tc)) {
                    jSONObject2.putOpt(Config.INPUT_DEF_VERSION, cVar.tc);
                }
                if (cVar.de != null && cVar.de.size() > 0) {
                    for (String str : cVar.de.keySet()) {
                        Object obj = cVar.de.get(str);
                        if (!TextUtils.isEmpty(str) && obj != null) {
                            jSONObject2.putOpt(str, obj);
                        }
                    }
                }
            }
            jSONObject2.putOpt("event_extra", jSONObject != null ? jSONObject.toString() : null);
            jSONObject2.putOpt("app_version", fs.b());
            jSONObject2.putOpt("conn_type", Integer.valueOf(np.u()));
            hc(jSONObject2, cVar);
            jSONObject2.putOpt("mediation_sdk_version", com.bytedance.msdk.hc.hc.hc());
            jSONObject2.putOpt(ILogConst.Keys.KEY_PLUGIN_VERSION, com.bytedance.msdk.hc.hc.c());
            try {
                jSONObject2.put("device_score", Double.parseDouble(com.bytedance.sdk.openadsdk.core.yi.d.d().d("DeviceRate", "bytebench_value")));
            } catch (NumberFormatException unused) {
                jSONObject2.put("device_score", -1);
            }
        } catch (Throwable th) {
            try {
                d(jSONObject2, th, cVar);
            } catch (Throwable unused2) {
            }
        }
        return jSONObject2;
    }

    private static void d(JSONObject jSONObject, c cVar) throws JSONException {
        if (jSONObject == null || cVar == null) {
            return;
        }
        if (cVar.rf != -1) {
            jSONObject.putOpt("result", Integer.valueOf(cVar.rf));
        }
        if (cVar.jh != -1) {
            jSONObject.putOpt("status_code", Integer.valueOf(cVar.jh));
        }
        if (cVar.cb != null) {
            jSONObject.putOpt("show_sort", cVar.cb);
        }
        if (cVar.e != null) {
            jSONObject.putOpt("load_sort", cVar.e);
        }
        if (cVar.uo != null) {
            jSONObject.putOpt("req_bidding_type", cVar.uo);
        }
        jSONObject.putOpt("prime_rit", cVar.gb);
    }

    private static void hc(JSONObject jSONObject, c cVar) throws JSONException {
        if (jSONObject != null && cVar != null) {
            if (TextUtils.equals(cVar.d, "sdk_init")) {
                jSONObject.putOpt(a.k, Long.valueOf(com.bytedance.msdk.api.c.tc.hc()));
                return;
            }
            if (TextUtils.equals(cVar.d, "start_up")) {
                jSONObject.putOpt(a.k, Long.valueOf(com.bytedance.msdk.api.c.tc.b()));
                return;
            } else if (cVar.d() != -1) {
                jSONObject.putOpt(a.k, Long.valueOf(cVar.d()));
                return;
            } else {
                jSONObject.putOpt(a.k, Long.valueOf(System.currentTimeMillis()));
                return;
            }
        }
        jSONObject.putOpt(a.k, Long.valueOf(System.currentTimeMillis()));
    }

    private static void hc(c cVar, JSONObject jSONObject) {
        if (cVar != null) {
            if ("media_request".equals(cVar.d) || "media_fill".equals(cVar.d) || "media_fill_fail".equals(cVar.d) || "get_bidding_adm_to_adn".equals(cVar.d) || "bidding_adm_load".equals(cVar.d) || "bidding_adm_load_fail".equals(cVar.d) || "bidding_win_event".equals(cVar.d) || "media_show_is_ready".equals(cVar.d) || "media_will_show".equals(cVar.d) || "media_show".equals(cVar.d) || "media_show_fail".equals(cVar.d) || "media_show_listen".equals(cVar.d) || "media_show_fail_listen".equals(cVar.d) || "media_click_listen".equals(cVar.d) || "sdk_init".equals(cVar.d) || ILogConst.EVENT_SDK_INIT_END.equals(cVar.d) || "get_config_start".equals(cVar.d) || "get_config_final".equals(cVar.d) || "mediation_request".equals(cVar.d) || "mediation_fill".equals(cVar.d) || "mediation_request_end".equals(cVar.d) || "total_load_fail".equals(cVar.d)) {
                cVar.d("grouping_params", com.bytedance.msdk.core.k.hc.hc());
                JSONObject jSONObjectB = com.bytedance.msdk.core.k.hc.b();
                if (jSONObjectB != null) {
                    cVar.d("user_defined_grouping_params", jSONObjectB.toString());
                } else {
                    cVar.d("user_defined_grouping_params", null);
                }
                com.bytedance.msdk.core.tt.c.d(cVar.gb, cVar.d, cVar.w, jSONObject);
            }
        }
    }

    private static void b(JSONObject jSONObject, c cVar) throws JSONException {
        if (jSONObject == null || cVar == null) {
            return;
        }
        if ("media_fill_fail".equals(cVar.d) || "media_fill".equals(cVar.d) || "bidding_adm_load".equals(cVar.d) || "bidding_adm_load_fail".equals(cVar.d) || "mediation_fill".equals(cVar.d) || "mediation_request_end".equals(cVar.d) || "mediation_video_cached".equals(cVar.d) || "get_config_final".equals(cVar.d) || ILogConst.EVENT_SDK_INIT_END.equals(cVar.d) || "sdk_backstage".equals(cVar.d) || "mediation_request".equals(cVar.d) || "rit_map_query".equals(cVar.d) || "return_bidding_result".equals(cVar.d)) {
            jSONObject.putOpt("duration", Long.valueOf(cVar.yo));
        }
    }

    private static void d(JSONObject jSONObject, Throwable th, c cVar) throws JSONException {
        if (jSONObject != null && th != null) {
            String strOptString = jSONObject.optString("event_extra");
            if (!TextUtils.isEmpty(strOptString)) {
                JSONObject jSONObject2 = new JSONObject(strOptString);
                jSONObject2.putOpt("err_msg_comm", th.toString());
                jSONObject.putOpt("event_extra", jSONObject2.toString());
            }
        }
        if (cVar == null || th == null) {
            return;
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.putOpt("comm_eventId", cVar.de.get("event_id"));
        jSONObject3.putOpt("err_msg_comm", th.toString());
        zw.d(jSONObject3);
    }

    public String b() {
        if (TextUtils.isEmpty(this.d) || this.hc == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("localId", this.d);
            jSONObject.putOpt(NotificationCompat.CATEGORY_EVENT, this.hc);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "AdEvent{localId='" + this.d + "', event=" + this.hc + '}';
    }
}
