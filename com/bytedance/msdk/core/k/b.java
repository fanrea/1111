package com.bytedance.msdk.core.k;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.msdk.an.hc.u;
import com.bytedance.msdk.api.c.cb;
import com.bytedance.msdk.core.gb.k;
import com.bytedance.msdk.core.tc.c;
import com.bytedance.msdk.core.tc.tc;
import com.bytedance.msdk.d.u.an;
import com.bytedance.msdk.gb.zw;
import com.bytedance.sdk.component.utils.mq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b implements d {
    private String an;
    private String b;
    private String bc;
    private long c;
    private int dc;
    private boolean dz;
    private String gb;
    private String h;
    private int hv;
    private int j;
    private com.bytedance.msdk.core.b.hc l;
    private String mk;
    private String mq;
    private com.bytedance.msdk.core.an.hc nr;
    private com.bytedance.msdk.core.hc.hc nv;
    private int tc;
    private int tr;
    private String tt;
    private long u;
    private int uo;
    private long w;
    private int yn;
    private long yo;
    private int d = 259200000;
    private final List<Object> hc = new CopyOnWriteArrayList();
    private String k = null;
    private int e = 0;
    private String cb = "log-api.pangolin-sdk-toutiao.com/service/2/app_log/";
    private int rf = Integer.MAX_VALUE;
    private final List<cb> jh = new CopyOnWriteArrayList();
    private Map<String, Boolean> sy = new HashMap();
    private final AtomicBoolean de = new AtomicBoolean(false);
    private final AtomicBoolean v = new AtomicBoolean(false);
    private int np = 0;
    private Map<String, String> yi = new ConcurrentHashMap();
    private Map<String, List<String>> he = new ConcurrentHashMap();
    private double vv = 0.0d;
    private boolean zw = false;
    private Map<String, com.bytedance.msdk.core.tc.b> s = new ConcurrentHashMap();
    private int us = 0;
    private final Map<String, List<com.bytedance.msdk.core.tc.b>> z = new ConcurrentHashMap();
    private final Map<String, c> fs = new ConcurrentHashMap();
    private final Map<String, Integer> ba = new ConcurrentHashMap();
    private final Map<String, Integer> mt = new ConcurrentHashMap();
    private int r = 0;
    private int y = 0;
    private int wl = 0;
    private int q = 0;
    private int ru = 0;
    private int fu = 0;
    private int xp = 0;
    private boolean to = false;
    private boolean ra = false;
    private boolean rw = false;
    private boolean ia = false;
    private int nw = 0;

    public int d() {
        return this.xp;
    }

    public boolean hc() {
        return this.to;
    }

    public boolean b() {
        return this.ra;
    }

    public boolean c() {
        return this.rw;
    }

    public void hc(boolean z) {
        this.rw = z;
    }

    public boolean u() {
        return this.ia;
    }

    public boolean an() {
        return this.nw == 1;
    }

    public boolean h() {
        return this.de.get();
    }

    public com.bytedance.msdk.core.tc.hc d(String str, int i, int i2) {
        return com.bytedance.msdk.h.d.b.d().d(str, i, i2);
    }

    public long d(int i, String str) {
        com.bytedance.msdk.core.tc.hc hcVarD = d(str, i, 101);
        return hcVarD != null ? hcVarD.bc() : com.alipay.sdk.m.u.b.a;
    }

    public com.bytedance.msdk.core.tc.d d(String str) {
        return com.bytedance.msdk.h.d.hc.d().d(str);
    }

    public com.bytedance.msdk.core.tc.d hc(String str) {
        return com.bytedance.msdk.h.d.hc.d().d(str);
    }

    public boolean b(String str) {
        return com.bytedance.msdk.h.d.hc.d().hc(str);
    }

    public boolean d(String str, String str2, int i) {
        List<tc> listY;
        com.bytedance.msdk.core.tc.hc hcVarD = com.bytedance.msdk.h.d.b.d().d(str, i, 101);
        if (hcVarD == null || (listY = hcVarD.y()) == null) {
            return false;
        }
        for (tc tcVar : listY) {
            if (tcVar != null && TextUtils.equals(tcVar.yo(), str2)) {
                return tcVar.hv();
            }
        }
        return false;
    }

    public boolean d(String str, int i) {
        com.bytedance.msdk.core.tc.hc hcVarD;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.bytedance.msdk.h.d.b.d().b() || (hcVarD = com.bytedance.msdk.h.d.b.d().d(str, i, 101)) == null || hcVarD.ba() == i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.bytedance.msdk.core.an.hc, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v16 */
    @Override // com.bytedance.msdk.core.k.d
    public void d(JSONObject jSONObject, final boolean z) {
        boolean z2;
        ?? r2;
        b bVar;
        final String strB;
        final String str;
        if (jSONObject == null) {
            return;
        }
        try {
            String strOptString = jSONObject.optString("app_abtest");
            this.k = strOptString;
            gb(strOptString);
            this.xp = jSONObject.optInt("is_trusteeship_monetize");
            this.nw = jSONObject.optInt("share_cache_enable");
            this.b = jSONObject.optString("etag");
            this.c = jSONObject.optLong("max_age");
            this.u = System.currentTimeMillis() + this.c;
            this.an = jSONObject.optString("ab_version");
            this.h = jSONObject.optString("ab_params");
            this.gb = jSONObject.optString("country");
            this.tt = jSONObject.optString("transparent_params");
            this.j = jSONObject.optInt("if_test");
            this.tc = jSONObject.optInt("if_get_detail_return");
            this.mk = jSONObject.optString("ecpm_precision_level");
            this.mq = jSONObject.optString("fetch_primerit_level");
            final String strOptString2 = jSONObject.optString("url");
            this.e = jSONObject.optInt("innerLog", 0);
            this.cb = jSONObject.optString("app_log_url", "log-api.pangolin-sdk-toutiao.com/service/2/app_log/");
            this.w = jSONObject.optLong("break_request_times", 0L);
            this.yo = jSONObject.optLong("break_request_hold_time", ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
            this.hv = jSONObject.optInt("ex_info", 0);
            this.bc = jSONObject.optString("ex_");
            this.us = jSONObject.optInt("if_enable_label", 0);
            this.d = jSONObject.optInt("ecpm_ttl", 259200000);
            int iOptInt = jSONObject.optInt("support_tnc", Integer.MAX_VALUE);
            this.rf = iOptInt;
            if (iOptInt != 0 && iOptInt != 1) {
                this.rf = 1;
            }
            this.vv = jSONObject.optDouble("custom_adn_sample_ratio", 0.0d);
            int iOptInt2 = jSONObject.optInt("enable_label_return", 0);
            this.dc = iOptInt2;
            if (iOptInt2 != 0 && iOptInt2 != 1) {
                this.dc = 0;
            }
            this.tr = jSONObject.optInt("dynamic_policy_enable", 0);
            com.bytedance.msdk.d.u.b.hc("DynamicPolicy", "mDynamicPolicyEnable=" + this.tr);
            int i = this.tr;
            if (i != 0 && i != 1) {
                this.tr = 0;
            }
            int i2 = this.y;
            int i3 = this.wl;
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("p_c");
            if (jSONObjectOptJSONObject != null) {
                this.y = jSONObjectOptJSONObject.optInt("l_p_a", 0);
                this.wl = jSONObjectOptJSONObject.optInt("l_p_r", 0);
            } else {
                this.y = 0;
                this.wl = 0;
            }
            if (i2 != this.y || i3 != this.wl) {
                u.d();
            }
            com.bytedance.msdk.core.h.d.d().d(this.w, this.yo);
            this.q = jSONObject.optInt("enable_bid_result_return", 0);
            this.ru = jSONObject.optInt("enable_bid_result_return_for_baidu", 0);
            this.fu = jSONObject.optInt("enable_bid_result_return_for_ks", 0);
            final JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("supervisor_feature");
            if (jSONObjectOptJSONObject2 != null) {
                com.bytedance.msdk.gb.cb.d(true);
                com.bytedance.msdk.gb.cb.d(jSONObjectOptJSONObject2);
            } else {
                com.bytedance.msdk.gb.cb.d(false);
            }
            final JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ra_info");
            if (jSONArrayOptJSONArray != null) {
                com.bytedance.msdk.core.admanager.reward.rewardagain.b.d(jSONArrayOptJSONArray);
            }
            com.bytedance.msdk.h.d.d.d().d(jSONObject.optJSONObject("app_common_config"));
            com.bytedance.msdk.h.d.hc.d().d(jSONObject.optJSONObject("adn_init_conf"));
            final String strHc = hc(jSONObject.optJSONArray("adn_control_conf"));
            final String strB2 = b(jSONObject.optJSONArray("rit_adn_control_conf"));
            final String strAn = an(jSONObject.optJSONObject("poor_network_config"));
            com.bytedance.msdk.h.d.b.d().d(jSONObject.optJSONArray("rit_conf"));
            final String strTt = tt(jSONObject.optJSONObject("module_disable_control"));
            final JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("call_stack_conf");
            h(jSONObjectOptJSONObject3);
            final JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("custom_adn_feature");
            gb(jSONObjectOptJSONObject4);
            final JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("timeout_req");
            tc(jSONObjectOptJSONObject5);
            final JSONObject jSONObjectOptJSONObject6 = jSONObject.optJSONObject("is_callback");
            mk(jSONObjectOptJSONObject6);
            final String strU = u(jSONObject.optJSONObject("label_outputs"));
            final String strC = c(jSONObject.optJSONObject("label_group_infos"));
            final String strD = d(jSONObject.optJSONArray("dynamic_rules"));
            final String strHc2 = hc(jSONObject.optJSONObject("dynamic_policy"));
            this.yn = jSONObject.optInt("behavior_policy_enable", 0);
            try {
                com.bytedance.msdk.d.u.b.hc("BehaviorPolicy", "mBehaviorPolicyConfigEnable=" + this.yn);
                strB = b(jSONObject.optJSONObject("behavior_policy"));
                JSONObject jSONObjectOptJSONObject7 = jSONObject.optJSONObject("inter_full_refresh_cfg");
                String string = jSONObjectOptJSONObject7 != null ? jSONObjectOptJSONObject7.toString() : null;
                com.bytedance.msdk.core.admanager.d.d(string);
                com.bytedance.msdk.b.gb.c.d(jSONObject.optJSONObject("csj_code_mapping_conf"));
                str = string;
            } catch (Throwable th) {
                th = th;
                r2 = 0;
                bVar = this;
                z2 = false;
            }
            try {
                an.c(new Runnable() { // from class: com.bytedance.msdk.core.k.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String strD2;
                        String strD3;
                        String strD4;
                        String strD5;
                        String strD6;
                        String strD7;
                        String strD8;
                        String strD9;
                        String strD10;
                        zw zwVarD = com.bytedance.msdk.h.d.d();
                        zwVarD.d("is_trusteeship_monetize", b.this.xp);
                        zwVarD.d("share_cache_enable", b.this.nw);
                        zwVarD.d("etag", b.this.b);
                        zwVarD.d("max_age", b.this.c);
                        zwVarD.d("max_expire_time", b.this.u);
                        zwVarD.d("ab_version", b.this.an);
                        zwVarD.d("ab_params", b.this.h);
                        zwVarD.d("country", b.this.gb);
                        zwVarD.d("transparent_params", b.this.tt);
                        zwVarD.d("if_test", b.this.j);
                        zwVarD.d("network_permission", b.this.tc);
                        zwVarD.d("ecpm_precision_level", b.this.mk);
                        zwVarD.d("fetch_primerit_level", b.this.mq);
                        zwVarD.d("app_abtest", b.this.k);
                        zwVarD.d("module_control", strTt);
                        zwVarD.d("tt_app_log_url", b.this.cb);
                        zwVarD.d("break_request_times", b.this.w);
                        zwVarD.d("break_request_hold_time", b.this.yo);
                        zwVarD.d("ex_info", b.this.hv);
                        zwVarD.d("if_enable_label", b.this.us);
                        zwVarD.d("cpm_expire_time", b.this.d);
                        JSONObject jSONObject2 = jSONObjectOptJSONObject2;
                        zwVarD.d("key_supervisor_feature", jSONObject2 != null ? jSONObject2.toString() : "");
                        zwVarD.d("custom_adn_sample_ratio", (float) b.this.vv);
                        zwVarD.d("enable_label_return", b.this.dc);
                        zwVarD.d("dynamic_policy_enable", b.this.tr);
                        zwVarD.d("behavior_policy_enable", b.this.yn);
                        zwVarD.d("limit_p_a", b.this.y);
                        zwVarD.d("limit_p_r", b.this.wl);
                        zwVarD.d("enable_bid_result_return", b.this.q);
                        zwVarD.d("enable_bid_result_return_for_baidu", b.this.ru);
                        zwVarD.d("enable_bid_result_return_for_ks", b.this.fu);
                        JSONObject jSONObject3 = jSONObjectOptJSONObject3;
                        if (jSONObject3 != null) {
                            zwVarD.d("call_stack", jSONObject3.toString());
                        } else {
                            zwVarD.d("call_stack", "");
                        }
                        JSONObject jSONObject4 = jSONObjectOptJSONObject4;
                        if (jSONObject4 != null) {
                            zwVarD.d("custom_adn_feature", jSONObject4.toString());
                        } else {
                            zwVarD.d("custom_adn_feature", "");
                        }
                        JSONObject jSONObject5 = jSONObjectOptJSONObject5;
                        if (jSONObject5 != null) {
                            zwVarD.d("timeout_req", jSONObject5.toString());
                        } else {
                            zwVarD.d("timeout_req", "");
                        }
                        JSONObject jSONObject6 = jSONObjectOptJSONObject6;
                        if (jSONObject6 != null) {
                            zwVarD.d("is_callback", jSONObject6.toString());
                        } else {
                            zwVarD.d("is_callback", "");
                        }
                        String str2 = strOptString2;
                        if (str2 != null && !TextUtils.isEmpty(str2)) {
                            String strD11 = com.bytedance.msdk.gb.d.d(strOptString2, com.bytedance.msdk.gb.hc.d());
                            if (strD11 != null) {
                                zwVarD.d("server_dist_host", strD11);
                            }
                        } else {
                            zwVarD.an("server_dist_host");
                        }
                        String str3 = strHc;
                        if (str3 != null && (strD10 = com.bytedance.msdk.gb.d.d(str3, com.bytedance.msdk.gb.hc.d())) != null) {
                            zwVarD.d("adn_control_conf", strD10);
                        }
                        if (!TextUtils.isEmpty(strB2)) {
                            zwVarD.d("rit_adn_control_conf", strB2);
                        } else {
                            zwVarD.an("rit_adn_control_conf");
                        }
                        String str4 = strAn;
                        if (str4 != null) {
                            zwVarD.d("network_conf", str4);
                        }
                        if (!TextUtils.isEmpty(strU) && (strD9 = com.bytedance.msdk.gb.d.d(strU, com.bytedance.msdk.gb.hc.d())) != null) {
                            zwVarD.d("label_outputs", strD9);
                        }
                        if (!TextUtils.isEmpty(strC) && (strD8 = com.bytedance.msdk.gb.d.d(strC, com.bytedance.msdk.gb.hc.d())) != null) {
                            zwVarD.d("label_group_infos", strD8);
                        }
                        if (!TextUtils.isEmpty(strD) && (strD7 = com.bytedance.msdk.gb.d.d(strD, com.bytedance.msdk.gb.hc.d())) != null) {
                            zwVarD.d("dynamic_rules", strD7);
                        }
                        if (!TextUtils.isEmpty(b.this.bc) && (strD6 = com.bytedance.msdk.gb.d.d(b.this.bc, com.bytedance.msdk.gb.hc.d())) != null) {
                            zwVarD.d("ex_", strD6);
                        }
                        JSONArray jSONArray = jSONArrayOptJSONArray;
                        if (jSONArray != null) {
                            String string2 = jSONArray.toString();
                            if (!TextUtils.isEmpty(string2) && (strD5 = com.bytedance.msdk.gb.d.d(string2, com.bytedance.msdk.gb.hc.d())) != null) {
                                zwVarD.d("reward_again_styles", strD5);
                            }
                        }
                        if (!TextUtils.isEmpty(strHc2) && (strD4 = com.bytedance.msdk.gb.d.d(strHc2, com.bytedance.msdk.gb.hc.d())) != null) {
                            zwVarD.d("dynamic_policy", strD4);
                        }
                        if (!TextUtils.isEmpty(strB) && (strD3 = com.bytedance.msdk.gb.d.d(strB, com.bytedance.msdk.gb.hc.d())) != null) {
                            zwVarD.d("behavior_policy", strD3);
                        }
                        if (!TextUtils.isEmpty(str) && (strD2 = com.bytedance.msdk.gb.d.d(str, com.bytedance.msdk.gb.hc.d())) != null) {
                            zwVarD.d("inter_full_refresh_cfg", strD2);
                        }
                        zwVarD.d("is_config_from_assert", z);
                        zwVarD.d("has_config_in_sp", true);
                    }
                });
                d(false, (JSONObject) null, (com.bytedance.msdk.core.an.hc) null);
            } catch (Throwable th2) {
                th = th2;
                r2 = 0;
                z2 = false;
                bVar = this;
                try {
                    mq.d(th);
                } finally {
                    bVar.d(z2, (JSONObject) r2, (com.bytedance.msdk.core.an.hc) r2);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            z2 = false;
            r2 = 0;
            bVar = this;
        }
    }

    private String hc(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        this.nv = new com.bytedance.msdk.core.hc.hc(jSONObject);
        return jSONObject.toString();
    }

    private String b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        this.l = new com.bytedance.msdk.core.b.hc(jSONObject);
        return jSONObject.toString();
    }

    private String d(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                c.d(jSONArray.optJSONObject(i), this.fs);
            } catch (Exception e) {
                com.bytedance.msdk.d.u.b.b("TTMediationSDK", "maybe some rit parse dynamic rules fail .....");
                mq.d(e);
            }
        }
        return jSONArray.toString();
    }

    private String c(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null || jSONObject.length() == 0) {
            return "";
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                JSONArray jSONArray = jSONObject.getJSONArray(next);
                if (jSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(com.bytedance.msdk.core.tc.b.d(next, jSONArray.optJSONObject(i)));
                    }
                    this.z.put(next, arrayList);
                }
            } catch (Exception e) {
                mq.d(e);
            }
        }
        return jSONObject.toString();
    }

    private String u(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            this.s.put(next, com.bytedance.msdk.core.tc.b.d(next, jSONObject.optJSONObject(next)));
        }
        return jSONObject.toString();
    }

    public void d(com.bytedance.msdk.core.an.hc hcVar) {
        this.nr = hcVar;
    }

    public void d(final boolean z, final JSONObject jSONObject, com.bytedance.msdk.core.an.hc hcVar) {
        if (hcVar != null) {
            this.nr = hcVar;
        }
        final boolean zZw = zw();
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        com.bytedance.msdk.an.hc.d.hc().d(com.bytedance.msdk.core.hc.getContext(), z, zZw, new com.bytedance.msdk.core.an.hc() { // from class: com.bytedance.msdk.core.k.b.2
            @Override // com.bytedance.msdk.core.an.hc
            public void d() {
                com.bytedance.msdk.d.u.b.c("TTMediationSDK_SDK_Init", "MSDK init finish.........hasConfig:" + zZw);
                if (zZw) {
                    b.this.de.set(true);
                    b.this.i();
                    if (b.this.nr != null) {
                        b.this.nr.d();
                    }
                    an.c(new Runnable() { // from class: com.bytedance.msdk.core.k.b.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!b.this.v.get()) {
                                b.this.v.set(true);
                                int iD = com.bytedance.msdk.an.hc.d.d();
                                long jElapsedRealtime2 = SystemClock.elapsedRealtime() - com.bytedance.msdk.an.b.d();
                                long jElapsedRealtime3 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                                try {
                                    if (jSONObject != null) {
                                        jSONObject.put("adn_time", jElapsedRealtime3);
                                    }
                                } catch (Throwable unused) {
                                }
                                HashMap map = new HashMap();
                                map.put("csj_init_time", Long.valueOf(com.bytedance.sdk.gromore.init.u.c - com.bytedance.sdk.gromore.init.u.d));
                                if (b.this.dz) {
                                    map.put("is_import_cfg", Boolean.valueOf(b.this.dz));
                                }
                                if (!com.bytedance.msdk.an.c.d()) {
                                    com.bytedance.msdk.d.u.b.d("TMe", "-----==---- 延时上报sdk_init_end");
                                    com.bytedance.msdk.an.c.d(jElapsedRealtime2, iD, z ? 1 : 0, jSONObject, map);
                                } else {
                                    com.bytedance.msdk.d.u.b.d("TMe", "-----==---- 正常上报sdk_init_end");
                                    com.bytedance.msdk.an.c.d(jElapsedRealtime2, iD, z ? 1 : 0, -1L, jSONObject, map);
                                }
                                com.bytedance.msdk.core.hc.d.d();
                                com.bytedance.msdk.d.u.b.d("TTMediationSDK", "sdk init end, duration: " + jElapsedRealtime2 + ", initAdnCount: " + iD + ", isFromLocalConfig: " + z);
                            }
                            hc.d(com.bytedance.msdk.core.hc.hc()).d(new com.bytedance.msdk.api.c.u() { // from class: com.bytedance.msdk.core.k.b.2.1.1
                                @Override // com.bytedance.msdk.api.c.u
                                public void d(List<String> list) {
                                    com.bytedance.msdk.d.u.b.d("TMe", "初始化更新pangle配置成功");
                                }
                            });
                        }
                    });
                }
            }
        });
    }

    @Override // com.bytedance.msdk.core.k.d
    public void d(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.optInt("state_code") != 30004) {
            return;
        }
        zw zwVarD = com.bytedance.msdk.h.d.d();
        this.c = jSONObject.optLong("max_age");
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.c;
        this.u = jCurrentTimeMillis + j;
        zwVarD.d("max_age", j);
        zwVarD.d("max_expire_time", this.u);
    }

    public boolean hc(String str, int i) {
        return (com.bytedance.msdk.h.d.hc.d().b() || com.bytedance.msdk.h.d.b.d().b() || com.bytedance.msdk.h.d.b.d().d(str, i, 101) == null) ? false : true;
    }

    public String gb() {
        return this.gb;
    }

    public String tt() {
        return this.tt;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x010d A[Catch: all -> 0x047d, TryCatch #2 {all -> 0x047d, blocks: (B:3:0x0007, B:5:0x0013, B:7:0x001d, B:10:0x002d, B:25:0x009d, B:28:0x00ad, B:30:0x00b7, B:32:0x00d0, B:41:0x0107, B:42:0x010d, B:15:0x0043, B:17:0x005c, B:22:0x008b, B:24:0x0093, B:43:0x0129, B:45:0x0233, B:46:0x023b, B:48:0x0247, B:49:0x0252, B:52:0x0262, B:54:0x0268, B:56:0x026e, B:57:0x0276, B:58:0x027e, B:60:0x028a, B:61:0x0292, B:63:0x029e, B:64:0x02a6, B:66:0x02ae, B:67:0x02b9, B:69:0x02c5, B:70:0x02cd, B:72:0x02d9, B:73:0x02e1, B:75:0x02ed, B:76:0x02f5, B:78:0x0301, B:79:0x0309, B:81:0x0315, B:83:0x0324, B:85:0x0330, B:87:0x0336, B:89:0x033c, B:90:0x0344, B:92:0x034a, B:93:0x0352, B:95:0x035e, B:97:0x0364, B:99:0x036a, B:100:0x0372, B:102:0x0378, B:103:0x0380, B:105:0x038c, B:107:0x0392, B:109:0x0398, B:110:0x03a0, B:112:0x03a6, B:113:0x03ae, B:115:0x03ba, B:117:0x03c0, B:119:0x03c6, B:120:0x03ce, B:122:0x03d4, B:123:0x03dc, B:125:0x03e8, B:127:0x03ee, B:129:0x03f4, B:130:0x03fc, B:132:0x0402, B:133:0x040a, B:135:0x0416, B:137:0x0424, B:138:0x0427, B:140:0x0433, B:142:0x0439, B:144:0x043f, B:145:0x0449, B:147:0x0453, B:82:0x0321, B:12:0x003b, B:19:0x006e), top: B:168:0x0007, inners: #0, #1 }] */
    @Override // com.bytedance.msdk.core.k.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d(boolean r13) {
        /*
            Method dump skipped, instructions count: 1182
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.k.b.d(boolean):void");
    }

    private String an(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        this.uo = jSONObject.optInt("fetch_ad_type", 0);
        return jSONObject.toString();
    }

    private void h(String str) {
        try {
            com.bytedance.msdk.core.admanager.reward.rewardagain.b.d(new JSONArray(str));
        } catch (JSONException e) {
            mq.d(e);
        }
    }

    private String hc(JSONArray jSONArray) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONArray != null) {
            ConcurrentHashMap<String, com.bytedance.msdk.core.gb.hc> concurrentHashMap = new ConcurrentHashMap<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("break_request_error_code")) != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        arrayList.add(jSONArrayOptJSONArray.optString(i2));
                    }
                    com.bytedance.msdk.core.gb.hc hcVar = new com.bytedance.msdk.core.gb.hc();
                    hcVar.d(jSONObjectOptJSONObject.optLong("break_request_duration"));
                    hcVar.d(arrayList);
                    concurrentHashMap.put(jSONObjectOptJSONObject.optString("adn_name"), hcVar);
                }
            }
            com.bytedance.msdk.core.gb.b.d().d(concurrentHashMap);
            return jSONArray.toString();
        }
        com.bytedance.msdk.core.gb.b.d().d(null);
        return null;
    }

    private String b(JSONArray jSONArray) {
        JSONArray jSONArrayOptJSONArray;
        JSONArray jSONArrayOptJSONArray2;
        if (jSONArray != null) {
            ConcurrentHashMap<String, List<com.bytedance.msdk.core.gb.hc>> concurrentHashMap = new ConcurrentHashMap<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("adn_name");
                    if (!TextUtils.isEmpty(strOptString) && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("break_request_error_code")) != null && (jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("rit_list")) != null) {
                        ArrayList arrayList = new ArrayList();
                        for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                            arrayList.add(jSONArrayOptJSONArray.optString(i2));
                        }
                        com.bytedance.msdk.core.gb.hc hcVar = new com.bytedance.msdk.core.gb.hc();
                        hcVar.d(jSONObjectOptJSONObject.optLong("break_request_duration"));
                        hcVar.d(arrayList);
                        ArrayList arrayList2 = new ArrayList();
                        for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                            arrayList2.add(jSONArrayOptJSONArray2.optString(i3));
                        }
                        hcVar.hc(arrayList2);
                        List<com.bytedance.msdk.core.gb.hc> arrayList3 = concurrentHashMap.get(strOptString);
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList<>();
                        }
                        arrayList3.add(hcVar);
                        concurrentHashMap.put(strOptString, arrayList3);
                    }
                }
            }
            k.d().d(concurrentHashMap);
            return jSONArray.toString();
        }
        k.d().d(null);
        return null;
    }

    private void gb(String str) {
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(new JSONObject(str).optString("app_ab_params")).optJSONObject("mediation_settings");
            if (jSONObjectOptJSONObject != null) {
                this.r = jSONObjectOptJSONObject.optInt("ad_request_optmize");
                boolean z = true;
                this.to = jSONObjectOptJSONObject.optInt("applog_cypher") == 2;
                this.ra = jSONObjectOptJSONObject.optInt("reward_cypher") == 2;
                this.rw = jSONObjectOptJSONObject.optInt("config_cypher") == 2;
                if (jSONObjectOptJSONObject.optInt("exchange_cypher") != 2) {
                    z = false;
                }
                this.ia = z;
            }
        } catch (Throwable unused) {
        }
    }

    private void h(JSONObject jSONObject) {
        this.yi.clear();
        this.np = 0;
        if (jSONObject == null) {
            return;
        }
        this.np = jSONObject.optInt("if_sample", 0);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("call_stack_path");
        if (jSONObjectOptJSONObject != null) {
            try {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                if (itKeys != null) {
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        String strOptString = jSONObjectOptJSONObject.optString(next);
                        if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(strOptString)) {
                            this.yi.put(next, strOptString);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private void gb(JSONObject jSONObject) {
        this.he.clear();
        if (jSONObject != null) {
            try {
                Iterator<String> itKeys = jSONObject.keys();
                if (itKeys != null) {
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(next);
                        ArrayList arrayList = new ArrayList();
                        if (jSONArrayOptJSONArray != null) {
                            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                                if (jSONArrayOptJSONArray.get(i) != null) {
                                    arrayList.add(jSONArrayOptJSONArray.get(i).toString());
                                }
                            }
                        }
                        if (!TextUtils.isEmpty(next) && !arrayList.isEmpty()) {
                            this.he.put(next, arrayList);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private String tt(JSONObject jSONObject) {
        this.sy.clear();
        if (jSONObject == null) {
            return null;
        }
        try {
            if (jSONObject.optBoolean("ad_event_control")) {
                this.sy.put("ad_event_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_banner_control")) {
                this.sy.put("type_banner_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_interaction_control")) {
                this.sy.put("type_interaction_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_interactionfull_control")) {
                this.sy.put("type_interactionfull_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_splash_control")) {
                this.sy.put("type_splash_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_feed_control")) {
                this.sy.put("type_feed_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_reward_control")) {
                this.sy.put("type_reward_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_full_control")) {
                this.sy.put("type_full_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_native_control")) {
                this.sy.put("type_native_control", Boolean.TRUE);
            }
            return jSONObject.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    private void tc(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.ba.clear();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            this.ba.put(next, Integer.valueOf(jSONObject.optInt(next)));
        }
    }

    private void mk(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.mt.clear();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            this.mt.put(next, Integer.valueOf(jSONObject.optInt(next)));
        }
    }

    public String tc() {
        if (this.b == null) {
            this.b = com.bytedance.msdk.h.d.d().hc("etag");
        }
        return this.b;
    }

    public String mk() {
        return this.cb;
    }

    public boolean mq() {
        return this.uo == 1;
    }

    public String uo() {
        return this.k;
    }

    public void c(String str) {
        try {
            zw zwVarD = com.bytedance.msdk.h.d.d();
            if ("2".equals(str)) {
                this.sy.put("active_control", Boolean.TRUE);
                zwVarD.d("all_active_control", true);
            } else {
                this.sy.put("active_control", Boolean.FALSE);
                zwVarD.d("all_active_control", false);
            }
        } catch (Exception e) {
            mq.d(e);
        }
    }

    private boolean nr() {
        Boolean bool = this.sy.get("active_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean k() {
        if (!nr()) {
            return false;
        }
        Boolean bool = this.sy.get("ad_event_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean d(int i) {
        if (!nr()) {
            return false;
        }
        if (i == 1) {
            return e();
        }
        if (i == 2) {
            return cb();
        }
        if (i == 3) {
            return yo();
        }
        if (i == 5) {
            return rf() && de();
        }
        if (i == 10) {
            return w();
        }
        if (i == 7) {
            return jh();
        }
        if (i != 8) {
            return true;
        }
        return sy();
    }

    public boolean e() {
        if (!nr()) {
            return false;
        }
        Boolean bool = this.sy.get("type_banner_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean cb() {
        if (!nr()) {
            return false;
        }
        Boolean bool = this.sy.get("type_interaction_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean w() {
        if (!nr()) {
            return false;
        }
        Boolean bool = this.sy.get("type_interactionfull_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean yo() {
        if (!nr()) {
            return false;
        }
        Boolean bool = this.sy.get("type_splash_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean rf() {
        if (!nr()) {
            return false;
        }
        Boolean bool = this.sy.get("type_feed_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean jh() {
        if (!nr()) {
            return false;
        }
        Boolean bool = this.sy.get("type_reward_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean sy() {
        if (!nr()) {
            return false;
        }
        Boolean bool = this.sy.get("type_full_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean de() {
        if (!nr()) {
            return false;
        }
        Boolean bool = this.sy.get("type_native_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean v() {
        return this.tc > 0;
    }

    public boolean np() {
        try {
            return Integer.valueOf(this.mk).intValue() > 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean yi() {
        return Integer.valueOf(this.mk).intValue() > 1;
    }

    public int he() {
        return com.bytedance.msdk.h.d.d.d().hc();
    }

    public long vv() {
        return com.bytedance.msdk.h.d.d.d().b();
    }

    public boolean zw() {
        return (com.bytedance.msdk.h.d.b.d().b() || com.bytedance.msdk.h.d.hc.d().b()) ? false : true;
    }

    public boolean j() {
        if (TextUtils.isEmpty(com.bytedance.msdk.core.d.mk().mq())) {
            return false;
        }
        com.bytedance.msdk.d.u.b.hc("TTMediationSDK_SDK_Init", "--==----- isConfigLoadAndAdnInit: " + h());
        if (!com.bytedance.msdk.h.d.b.d().b() && h()) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK_SDK_Init", "--==----- isConfigLoadAndAdnInit 1");
            return true;
        }
        com.bytedance.msdk.d.u.b.hc("TTMediationSDK_SDK_Init", "--==----- isConfigLoadAndAdnInit 2");
        return false;
    }

    public List<String> d(List<String> list) {
        if (list != null && list.size() > 0) {
            if (com.bytedance.msdk.h.d.b.d().b()) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                if (com.bytedance.msdk.h.d.b.d().d(str, 0, 101) == null) {
                    arrayList.add(str);
                }
            }
            if (arrayList.size() > 0) {
                return arrayList;
            }
        }
        return null;
    }

    public void d(cb cbVar) {
        if (cbVar == null) {
            return;
        }
        if (j()) {
            cbVar.d();
            return;
        }
        synchronized (this.jh) {
            if (!this.jh.contains(cbVar)) {
                this.jh.add(cbVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        com.bytedance.msdk.core.mk.d.d().u();
        if (j()) {
            Iterator<cb> it = this.jh.iterator();
            while (it.hasNext()) {
                it.next().d();
            }
            this.jh.clear();
        }
    }

    public void hc(int i) {
        this.rf = i;
    }

    public boolean s() {
        if (this.rf == Integer.MAX_VALUE) {
            this.rf = 1;
        }
        return this.rf == 1;
    }

    public boolean us() {
        return this.np == 1;
    }

    public Map<String, String> z() {
        return this.yi;
    }

    public Map<String, List<String>> fs() {
        return this.he;
    }

    public double ba() {
        return this.vv;
    }

    public boolean mt() {
        return this.dc == 1;
    }

    public boolean r() {
        return this.tr == 1;
    }

    public boolean hv() {
        return this.yn == 1;
    }

    public com.bytedance.msdk.core.hc.hc bc() {
        return this.nv;
    }

    public com.bytedance.msdk.core.b.hc dc() {
        if (hv()) {
            return this.l;
        }
        return null;
    }

    public boolean tr() {
        return this.j == 1;
    }

    public int nv() {
        return this.j;
    }

    public void b(int i) {
        this.j = i;
    }

    public Map<String, com.bytedance.msdk.core.tc.b> y() {
        return this.s;
    }

    public boolean wl() {
        return this.hv == 1;
    }

    public String q() {
        return this.bc;
    }

    public boolean ru() {
        return this.us == 1;
    }

    public boolean d(long j) {
        return j < ((long) this.d);
    }

    public int yn() {
        return this.d;
    }

    public c u(String str) {
        return this.fs.get(str);
    }

    public List<com.bytedance.msdk.core.tc.b> an(String str) {
        return this.z.get(str);
    }

    public int l() {
        com.bytedance.msdk.core.hc.hc hcVar = this.nv;
        if (hcVar != null) {
            return hcVar.d();
        }
        return 0;
    }

    public Map<String, Integer> fu() {
        return this.ba;
    }

    public Map<String, Integer> xp() {
        return this.mt;
    }

    public int to() {
        return this.y;
    }

    public int ra() {
        return this.wl;
    }

    public boolean rw() {
        com.bytedance.msdk.d.u.b.hc("TMe", "enable_bid_result_return = " + this.q);
        com.bytedance.msdk.d.u.b.hc("TMe", "enable_bid_result_return_for_baidu = " + this.ru);
        return ia() || nw();
    }

    public boolean ia() {
        return this.q == 1 && this.ru == 1;
    }

    public boolean nw() {
        return this.q == 1 && this.ru == 2;
    }

    public boolean dz() {
        com.bytedance.msdk.d.u.b.hc("TMe", "enable_bid_result_return = " + this.q);
        com.bytedance.msdk.d.u.b.hc("TMe", "enable_bid_result_return_for_ks = " + this.fu);
        return this.q == 1 && this.fu == 1;
    }
}
