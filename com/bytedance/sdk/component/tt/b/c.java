package com.bytedance.sdk.component.tt.b;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.mq;
import com.bytedance.sdk.djx.core.log.ILogConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c {
    private static final Object c = new Object();
    private boolean b;
    private Context d;
    private b hc = new b();
    private int u;

    public c(Context context, boolean z, int i) {
        this.d = context;
        this.b = z;
        this.u = i;
    }

    public void d(JSONObject jSONObject) {
        if (!this.b) {
            com.bytedance.sdk.component.tt.c.b.hc("TNCConfigHandler", "handleConfigChanged: no mainProc");
            return;
        }
        h.d().d(this.u).u();
        try {
            boolean z = jSONObject.optInt("ttnet_url_dispatcher_enabled", 0) > 0;
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ttnet_dispatch_actions");
            JSONObject jSONObject2 = null;
            if (h.d().d(this.u).b() && z && jSONArrayOptJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObject3 = ((JSONObject) jSONArrayOptJSONArray.get(i)).getJSONObject("param");
                    if (jSONObject3.optString("service_name", "").equals("idc_selection")) {
                        arrayList.add(jSONObject3.getJSONObject("strategy_info"));
                    }
                }
                if (!arrayList.isEmpty()) {
                    jSONObject2 = new JSONObject();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        JSONObject jSONObject4 = (JSONObject) it.next();
                        Iterator<String> itKeys = jSONObject4.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            jSONObject2.put(next, jSONObject4.getString(next));
                        }
                    }
                }
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("tnc_config");
            if (jSONObjectOptJSONObject == null && jSONObject2 == null) {
                com.bytedance.sdk.component.tt.c.b.d("TNCConfigHandler", " tnc host_replace_map config is null");
            } else if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = new JSONObject();
                jSONObjectOptJSONObject.put("host_replace_map", jSONObject2);
            } else if (jSONObject2 != null) {
                jSONObjectOptJSONObject.put("host_replace_map", jSONObject2);
            }
            b bVarHc = hc(jSONObjectOptJSONObject);
            com.bytedance.sdk.component.tt.c.b.hc("TNCConfigHandler", "handleConfigChanged, newConfig: " + (bVarHc == null ? ILogConst.CACHE_PLAY_REASON_NULL : bVarHc.toString()));
            if (bVarHc == null) {
                synchronized (c) {
                    com.bytedance.sdk.openadsdk.api.plugin.hc.hc(this.d, h.d().d(this.u).d(), 0).edit().putString("tnc_config_str", "").apply();
                    com.bytedance.sdk.component.tt.c.c.d(this.d, 1, "", this.u);
                }
            } else {
                this.hc = bVarHc;
                String string = jSONObjectOptJSONObject.toString();
                synchronized (c) {
                    com.bytedance.sdk.openadsdk.api.plugin.hc.hc(this.d, h.d().d(this.u).d(), 0).edit().putString("tnc_config_str", string).apply();
                    com.bytedance.sdk.component.tt.c.c.d(this.d, 1, string, this.u);
                }
            }
        } catch (Throwable th) {
            try {
                mq.d(th);
                this.hc = new b();
                synchronized (c) {
                    com.bytedance.sdk.openadsdk.api.plugin.hc.hc(this.d, h.d().d(this.u).d(), 0).edit().putString("tnc_config_str", "").apply();
                    com.bytedance.sdk.component.tt.c.c.d(this.d, 1, "", this.u);
                }
            } catch (Throwable th2) {
                synchronized (c) {
                    com.bytedance.sdk.openadsdk.api.plugin.hc.hc(this.d, h.d().d(this.u).d(), 0).edit().putString("tnc_config_str", "").apply();
                    com.bytedance.sdk.component.tt.c.c.d(this.d, 1, "", this.u);
                    throw th2;
                }
            }
        }
    }

    public void d() {
        if (this.b) {
            String string = com.bytedance.sdk.openadsdk.api.plugin.hc.hc(this.d, h.d().d(this.u).d(), 0).getString("tnc_config_str", null);
            if (TextUtils.isEmpty(string)) {
                com.bytedance.sdk.component.tt.c.b.hc("TNCConfigHandler", "loadLocalConfig: no existed");
                return;
            }
            try {
                b bVarHc = hc(new JSONObject(string));
                if (bVarHc != null) {
                    this.hc = bVarHc;
                }
                com.bytedance.sdk.component.tt.c.b.hc("TNCConfigHandler", "loadLocalConfig: " + (bVarHc == null ? ILogConst.CACHE_PLAY_REASON_NULL : bVarHc.toString()));
            } catch (Throwable th) {
                mq.d(th);
                com.bytedance.sdk.component.tt.c.b.hc("TNCConfigHandler", "loadLocalConfig: except: " + th.getMessage());
            }
        }
    }

    public void hc() {
        try {
            String strD = com.bytedance.sdk.component.tt.c.c.d(this.d, 1, this.u);
            if (TextUtils.isEmpty(strD)) {
                com.bytedance.sdk.component.tt.c.b.hc("TNCConfigHandler", "loadLocalConfigForOtherProcess, data empty");
                return;
            }
            b bVarHc = hc(new JSONObject(strD));
            com.bytedance.sdk.component.tt.c.b.hc("TNCConfigHandler", "loadLocalConfigForOtherProcess, config: " + (bVarHc == null ? ILogConst.CACHE_PLAY_REASON_NULL : bVarHc.toString()));
            if (bVarHc != null) {
                this.hc = bVarHc;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.tt.c.b.hc("TNCConfigHandler", "loadLocalConfigForOtherProcess, except: " + th.getMessage());
        }
    }

    public b b() {
        return this.hc;
    }

    private b hc(JSONObject jSONObject) {
        try {
            b bVar = new b();
            if (jSONObject.has("local_enable")) {
                bVar.d = jSONObject.getInt("local_enable") != 0;
            }
            if (jSONObject.has("probe_enable")) {
                bVar.hc = jSONObject.getInt("probe_enable") != 0;
            }
            if (jSONObject.has("local_host_filter")) {
                JSONArray jSONArray = jSONObject.getJSONArray("local_host_filter");
                HashMap map = new HashMap();
                if (jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string)) {
                            map.put(string, 0);
                        }
                    }
                }
                bVar.b = map;
            } else {
                bVar.b = null;
            }
            if (jSONObject.has("host_replace_map")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("host_replace_map");
                HashMap map2 = new HashMap();
                if (jSONObject2.length() > 0) {
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        String string2 = jSONObject2.getString(next);
                        if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(string2)) {
                            map2.put(next, string2);
                        }
                    }
                }
                bVar.c = map2;
            } else {
                bVar.c = null;
            }
            bVar.u = jSONObject.optInt("req_to_cnt", bVar.u);
            bVar.an = jSONObject.optInt("req_to_api_cnt", bVar.an);
            bVar.h = jSONObject.optInt("req_to_ip_cnt", bVar.h);
            bVar.gb = jSONObject.optInt("req_err_cnt", bVar.gb);
            bVar.tt = jSONObject.optInt("req_err_api_cnt", bVar.tt);
            bVar.tc = jSONObject.optInt("req_err_ip_cnt", bVar.tc);
            bVar.mk = jSONObject.optInt("update_interval", bVar.mk);
            bVar.mq = jSONObject.optInt("update_random_range", bVar.mq);
            bVar.uo = jSONObject.optString("http_code_black", bVar.uo);
            return bVar;
        } catch (Throwable th) {
            mq.d(th);
            return null;
        }
    }
}
