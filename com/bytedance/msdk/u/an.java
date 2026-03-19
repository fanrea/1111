package com.bytedance.msdk.u;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.SplashAd;
import com.bytedance.msdk.gb.rf;
import com.bytedance.msdk.gb.zw;
import com.bytedance.sdk.component.utils.mq;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an {
    private static int b;
    private static int d;
    private static int hc;

    public static void d(com.bytedance.msdk.hc.b bVar, com.bytedance.msdk.api.d.hc hcVar, int i, String str, long j, int i2, int i3, String str2) {
        com.bytedance.msdk.core.k.b bVarHc;
        com.bytedance.msdk.core.tc.hc hcVarD;
        c cVarHc = c.hc();
        cVarHc.d("media_reward_verify").d("adn_preload", Integer.valueOf((bVar == null || !bVar.tr()) ? 0 : 1)).d("reason", Integer.valueOf(i2)).d("play_again", Integer.valueOf(i));
        if (i3 != 0 && i3 != 20000) {
            cVarHc.hc(i3).tc(str2);
        }
        HashMap map = new HashMap();
        boolean z = j >= 0;
        if (bVar != null && bVar.wz()) {
            map.put("custom_adn_sample_ratio", Double.valueOf(rf.b()));
            map.put("custom_adn_sample_ratio_result", Boolean.valueOf(z));
            if (z) {
                map.put("custom_adn_rec_time", Long.valueOf(j));
            }
        }
        if (hcVar != null && (bVarHc = com.bytedance.msdk.core.hc.hc()) != null && (hcVarD = bVarHc.d(hcVar.v(), hcVar.de(), 101)) != null) {
            map.put("reward_callback_type", Integer.valueOf(hcVarD.tr()));
            map.put("reward_start_time", Integer.valueOf(hcVarD.dc()));
        }
        if (str != null) {
            cVarHc.d("sub_adn_name", str);
        }
        d(cVarHc, hcVar, (com.bytedance.msdk.core.tc.tc) null, bVar, map);
        b.d(com.bytedance.msdk.core.hc.getContext(), cVarHc, map);
    }

    public static void d(com.bytedance.msdk.hc.b bVar, com.bytedance.msdk.api.d.hc hcVar, int i, String str, long j, boolean z) {
        d(bVar, hcVar, i, str, j, (String) null, z);
    }

    public static void d() {
        c cVarHc = c.hc();
        cVarHc.d("mediation_sdk_init");
        HashMap map = new HashMap();
        map.put("call_init_time", Long.valueOf(com.bytedance.sdk.gromore.init.u.d));
        map.put("call_init_csj_start_time", Long.valueOf(com.bytedance.sdk.gromore.init.u.hc));
        map.put("call_init_csj_end_time", Long.valueOf(com.bytedance.sdk.gromore.init.u.b));
        map.put("call_init_csj_duration", Long.valueOf(com.bytedance.sdk.gromore.init.u.hc - com.bytedance.sdk.gromore.init.u.d));
        map.put("init_csj_duration", Long.valueOf(com.bytedance.sdk.gromore.init.u.b - com.bytedance.sdk.gromore.init.u.hc));
        map.put("call_init_gromore_start_time", Long.valueOf(com.bytedance.sdk.gromore.init.u.c));
        map.put("call_init_gromore_end_time", Long.valueOf(com.bytedance.sdk.gromore.init.u.u));
        map.put("call_init_gromore_duration", Long.valueOf(com.bytedance.sdk.gromore.init.u.c - com.bytedance.sdk.gromore.init.u.d));
        map.put("init_gromore_duration", Long.valueOf(com.bytedance.sdk.gromore.init.u.u - com.bytedance.sdk.gromore.init.u.c));
        map.put("init_total_duration", Long.valueOf(com.bytedance.sdk.gromore.init.u.u - com.bytedance.sdk.gromore.init.u.d));
        try {
            d(cVarHc, (com.bytedance.msdk.api.d.hc) null, (com.bytedance.msdk.core.tc.tc) null, (com.bytedance.msdk.hc.b) null, map);
            b.d(com.bytedance.msdk.core.hc.getContext(), cVarHc, map);
        } catch (Throwable th) {
            mq.d(th);
        }
    }

    public static void d(com.bytedance.msdk.hc.b bVar, com.bytedance.msdk.api.d.hc hcVar, int i, String str, long j, String str2, boolean z) {
        c cVarHc = c.hc();
        cVarHc.d("media_show_listen").d("adn_preload", Integer.valueOf((bVar == null || !bVar.tr()) ? 0 : 1)).d("play_again", Integer.valueOf(i)).d("is_repeat", Integer.valueOf(z ? 1 : 0));
        if (str != null) {
            cVarHc.d("sub_adn_name", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            cVarHc.d("callstack_message", str2);
        }
        HashMap map = new HashMap();
        map.put("enable_label_return", Integer.valueOf(com.bytedance.msdk.core.hc.hc().mt() ? 1 : 0));
        map.put("if_labelapi_call", Integer.valueOf(com.bytedance.msdk.core.d.mk().d() ? 1 : 0));
        com.bytedance.msdk.core.hc.b.d(bVar, hcVar, map);
        boolean z2 = j >= 0;
        if (bVar != null && bVar.wz()) {
            map.put("custom_adn_sample_ratio", Double.valueOf(rf.b()));
            map.put("custom_adn_sample_ratio_result", Boolean.valueOf(z2));
            if (z2) {
                map.put("custom_adn_rec_time", Long.valueOf(j));
            }
        }
        d(cVarHc, hcVar, (com.bytedance.msdk.core.tc.tc) null, bVar, map);
        b.d(com.bytedance.msdk.core.hc.getContext(), cVarHc, map);
    }

    public static void d(com.bytedance.msdk.hc.b bVar, com.bytedance.msdk.api.d.hc hcVar, String str) {
        c cVarHc = c.hc();
        cVarHc.d("media_show_dislike").tc(str);
        HashMap map = new HashMap();
        d(cVarHc, hcVar, (com.bytedance.msdk.core.tc.tc) null, bVar, map);
        b.d(com.bytedance.msdk.core.hc.getContext(), cVarHc, map);
    }

    public static void hc(com.bytedance.msdk.hc.b bVar, com.bytedance.msdk.api.d.hc hcVar, int i, String str, long j, boolean z) {
        hc(bVar, hcVar, i, str, j, null, z);
    }

    public static void hc(com.bytedance.msdk.hc.b bVar, com.bytedance.msdk.api.d.hc hcVar, int i, String str, long j, String str2, boolean z) {
        c cVarHc = c.hc();
        cVarHc.d("media_click_listen").d("adn_preload", Integer.valueOf((bVar == null || !bVar.tr()) ? 0 : 1)).d("play_again", Integer.valueOf(i)).d("is_repeat", Integer.valueOf(z ? 1 : 0));
        if (str != null) {
            cVarHc.d("sub_adn_name", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            cVarHc.d("callstack_message", str2);
        }
        HashMap map = new HashMap();
        boolean z2 = j >= 0;
        if (bVar != null && bVar.wz()) {
            map.put("custom_adn_sample_ratio", Double.valueOf(rf.b()));
            map.put("custom_adn_sample_ratio_result", Boolean.valueOf(z2));
            if (z2) {
                map.put("custom_adn_rec_time", Long.valueOf(j));
            }
        }
        d(cVarHc, hcVar, (com.bytedance.msdk.core.tc.tc) null, bVar, map);
        b.d(com.bytedance.msdk.core.hc.getContext(), cVarHc, map);
    }

    public static void d(com.bytedance.msdk.hc.b bVar, com.bytedance.msdk.api.d.hc hcVar, boolean z, int i) {
        d(bVar, hcVar, z, i, (Map<String, Object>) null);
    }

    public static void d(com.bytedance.msdk.hc.b bVar, com.bytedance.msdk.api.d.hc hcVar, boolean z, int i, Map<String, Object> map) {
        c cVarHc = c.hc();
        cVarHc.d("media_show").d("adn_preload", Integer.valueOf((bVar == null || !bVar.tr()) ? 0 : 1)).d("play_again", Integer.valueOf(i)).d("is_repeat", Integer.valueOf(z ? 1 : 0));
        HashMap map2 = new HashMap();
        if (map != null && !map.isEmpty()) {
            map2.putAll(map);
        }
        d(cVarHc, hcVar, (com.bytedance.msdk.core.tc.tc) null, bVar, map2);
        b.d(com.bytedance.msdk.core.hc.getContext(), cVarHc, map2);
    }

    public static void d(List<com.bytedance.msdk.hc.b> list, List<com.bytedance.msdk.hc.b> list2, List<com.bytedance.msdk.hc.b> list3, com.bytedance.msdk.api.d.hc hcVar, int i) throws JSONException {
        boolean zBa;
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            arrayList.addAll(list);
        }
        if (list2 != null && list2.size() > 0) {
            arrayList.addAll(list2);
        }
        if (list3 != null && list3.size() > 0) {
            arrayList.addAll(list3);
        }
        int i2 = 0;
        com.bytedance.msdk.hc.b bVar = arrayList.size() > 0 ? (com.bytedance.msdk.hc.b) arrayList.get(0) : null;
        c cVarHc = c.hc();
        cVarHc.d("media_show_is_ready");
        if (i == 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                Iterator it = arrayList.iterator();
                loop0: while (true) {
                    zBa = false;
                    while (it.hasNext()) {
                        com.bytedance.msdk.hc.b bVar2 = (com.bytedance.msdk.hc.b) it.next();
                        if (bVar2 != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(SplashAd.KEY_BIDFAIL_ADN, bVar2.nw());
                            jSONObject.put("type", com.bytedance.msdk.hc.d.d(bVar2.el(), bVar2.nv()));
                            jSONObject.put("adnSlotId", bVar2.ph());
                            jSONObject.put("loadSort", bVar2.ho());
                            jSONObject.put("showSort", bVar2.gu());
                            if (hcVar != null) {
                                jSONObject.put("isReady", bVar2.ba(hcVar.v()) ? 1 : 0);
                            }
                            jSONObject.put("hasShown", bVar2.xp() ? 1 : 0);
                            if (bVar2.cw()) {
                                jSONObject.put("is_video_cache_success", bVar2.xn() ? 1 : 0);
                            }
                            jSONObject.put("mediationrit_req_type", bVar2.gb(hcVar != null ? hcVar.d() : null));
                            jSONObject.put("mediationrit_req_type_src", bVar2.tt(hcVar != null ? hcVar.d() : null));
                            jSONArray.put(jSONObject);
                            if (!zBa && hcVar != null) {
                                if (hcVar.de() == 5) {
                                    zBa = bVar2.ba(hcVar.v());
                                } else if (!bVar2.ba(hcVar.v()) || bVar2.xp()) {
                                    break;
                                } else {
                                    zBa = true;
                                }
                            }
                        }
                    }
                }
                if (!zBa) {
                    i2 = -1;
                }
                cVarHc.hc(i2);
                cVarHc.tc(jSONArray.toString());
            } catch (JSONException e) {
                mq.d(e);
            }
        } else {
            cVarHc.hc(2);
            cVarHc.tc(com.bytedance.msdk.api.d.d(i));
        }
        HashMap map = new HashMap();
        d(cVarHc, hcVar, (com.bytedance.msdk.core.tc.tc) null, bVar, map);
        b.d(com.bytedance.msdk.core.hc.getContext(), cVarHc, map);
    }

    public static void d(List<com.bytedance.msdk.hc.b> list, com.bytedance.msdk.api.d.hc hcVar, int i) throws JSONException {
        com.bytedance.msdk.hc.b bVar = (list == null || list.size() <= 0) ? null : list.get(0);
        c cVarHc = c.hc();
        cVarHc.d("media_show_fail");
        if (i == 0) {
            cVarHc.hc(40052);
            if (bVar != null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (com.bytedance.msdk.hc.b bVar2 : list) {
                        if (bVar2 != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(SplashAd.KEY_BIDFAIL_ADN, bVar2.nw());
                            jSONObject.put("type", com.bytedance.msdk.hc.d.d(bVar2.el(), bVar2.nv()));
                            jSONObject.put("adnSlotId", bVar2.ph());
                            jSONObject.put("loadSort", bVar2.ho());
                            jSONObject.put("showSort", bVar2.gu());
                            int i2 = 1;
                            if (hcVar != null) {
                                jSONObject.put("isReady", bVar2.ba(hcVar.v()) ? 1 : 0);
                            }
                            if (!bVar2.xp()) {
                                i2 = 0;
                            }
                            jSONObject.put("hasShown", i2);
                            jSONArray.put(jSONObject);
                        }
                    }
                    cVarHc.tc(jSONArray.toString());
                } catch (JSONException e) {
                    mq.d(e);
                }
            }
        } else {
            cVarHc.hc(i);
            cVarHc.tc(com.bytedance.msdk.api.d.d(i));
        }
        HashMap map = new HashMap();
        d(cVarHc, hcVar, (com.bytedance.msdk.core.tc.tc) null, bVar, map);
        cVarHc.d("is_video_cache_success", 0);
        b.d(com.bytedance.msdk.core.hc.getContext(), cVarHc, map);
    }

    public static void d(com.bytedance.msdk.api.d.hc hcVar, int i) {
        c cVarHc = c.hc();
        cVarHc.d("media_carousel_fail").hc(i).tc(com.bytedance.msdk.api.d.d(i));
        HashMap map = new HashMap();
        d(cVarHc, hcVar, (com.bytedance.msdk.core.tc.tc) null, (com.bytedance.msdk.hc.b) null, map);
        cVarHc.d("is_video_cache_success", 0);
        b.d(com.bytedance.msdk.core.hc.getContext(), cVarHc, map);
    }

    public static void d(final int i, final int i2, final long j, final String str, final String str2) {
        final c cVarB = c.b();
        com.bytedance.msdk.d.u.an.c(new Runnable() { // from class: com.bytedance.msdk.u.an.1
            @Override // java.lang.Runnable
            public void run() {
                cVarB.d("rit_map_query").setResult(i2).d(j).u(i);
                HashMap map = new HashMap();
                if (!TextUtils.isEmpty(str)) {
                    cVarB.gb(str);
                    map.put("origin_rit", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    cVarB.hc(str2);
                    map.put("prime_rit", str2);
                }
                b.d(com.bytedance.msdk.core.hc.getContext(), cVarB, map);
            }
        });
    }

    public static void d(final com.bytedance.msdk.core.tc.tc tcVar, final com.bytedance.msdk.api.d.hc hcVar, final String str, final boolean z, final int i, final int i2, final int i3, final int i4, final com.bytedance.msdk.api.d dVar, final long j, final boolean z2, final boolean z3) {
        final c cVarB = c.b();
        com.bytedance.msdk.d.u.an.c(new Runnable() { // from class: com.bytedance.msdk.u.an.12
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.u.b.d.d().d(cVarB, tcVar, hcVar, str, z, i, i2, i3, i4, dVar, j, z2, z3, null);
            }
        });
    }

    public static void d(final com.bytedance.msdk.core.tc.tc tcVar, final com.bytedance.msdk.api.d.hc hcVar, final String str, final boolean z, final int i, final int i2, final int i3, final int i4, final com.bytedance.msdk.api.d dVar, final long j, final boolean z2, final boolean z3, final String str2) {
        final c cVarB = c.b();
        com.bytedance.msdk.d.u.an.c(new Runnable() { // from class: com.bytedance.msdk.u.an.16
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.u.b.d.d().d(cVarB, tcVar, hcVar, str, z, i, i2, i3, i4, dVar, j, z2, z3, str2);
            }
        });
    }

    public static void d(com.bytedance.msdk.core.tc.tc tcVar, com.bytedance.msdk.api.d.hc hcVar, com.bytedance.msdk.hc.b bVar, int i, String str) {
        c cVarHc = c.hc();
        c cVarD = cVarHc.d("bidding_info_invalid").hc(i).tc(str).d(PointParamKey.AD_COUNT, Integer.valueOf(hcVar != null ? hcVar.vv() : 0));
        com.bytedance.msdk.core.k.hc.d(com.bytedance.msdk.core.hc.hc());
        cVarD.d("grouping_params", com.bytedance.msdk.core.k.hc.hc()).d("log_source", 2);
        HashMap map = new HashMap();
        d(cVarHc, hcVar, tcVar, bVar, map);
        b.d(com.bytedance.msdk.core.hc.getContext(), cVarHc, map);
    }

    public static void d(final com.bytedance.msdk.hc.b bVar, final int i, final String str, final long j, final com.bytedance.msdk.api.d.hc hcVar, final int i2, final int i3, final int i4, final String str2, final long j2, final long j3) {
        final c cVarB = c.b();
        com.bytedance.msdk.d.u.an.c(new Runnable() { // from class: com.bytedance.msdk.u.an.17
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.u.b.d.d().d(cVarB, bVar, i, str, j, hcVar, i2, i3, i4, str2, j2, j3);
            }
        });
    }

    public static void d(final com.bytedance.msdk.api.d dVar, final com.bytedance.msdk.api.d.hc hcVar, final com.bytedance.msdk.core.tc.tc tcVar, final int i, final int i2, final int i3, final String str, final long j, final String str2, final String str3, final String str4, final long j2) {
        final c cVarB = c.b();
        com.bytedance.msdk.d.u.an.c(new Runnable() { // from class: com.bytedance.msdk.u.an.18
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.u.b.d.d().d(cVarB, dVar, hcVar, tcVar, i, i2, i3, str, j, str2, str3, str4, j2);
            }
        });
    }

    public static void d(com.bytedance.msdk.api.d dVar, com.bytedance.msdk.api.d.hc hcVar, com.bytedance.msdk.core.tc.tc tcVar, int i, int i2, int i3, String str, long j) {
        c cVarHc = c.hc();
        cVarHc.d("bidding_adm_load_fail").d(j).an(str).hc(dVar != null ? dVar.b : -1).tc(dVar != null ? dVar.c : "unknown error").d("adn_count", Integer.valueOf(i)).d("adn_preload", 0).d("mediationrit_req_type", Integer.valueOf(i2)).d("mediationrit_req_type_src", Integer.valueOf(i3));
        if (dVar instanceof com.bytedance.msdk.api.hc.d) {
            cVarHc.k = dVar.d;
            cVarHc.mk = dVar.hc;
        }
        HashMap map = new HashMap();
        d(cVarHc, hcVar, tcVar, (com.bytedance.msdk.hc.b) null, map);
        b.d(com.bytedance.msdk.core.hc.getContext(), cVarHc, map);
    }

    public static void d(final com.bytedance.msdk.api.d.hc hcVar, final com.bytedance.msdk.api.d dVar, final String str) {
        final c cVarB = c.b();
        com.bytedance.msdk.d.u.an.c(new Runnable() { // from class: com.bytedance.msdk.u.an.19
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.u.b.d.d().d(cVarB, hcVar, dVar, str);
            }
        });
    }

    public static void d(final com.bytedance.msdk.core.tc.tc tcVar, final com.bytedance.msdk.api.d.hc hcVar, final int i, final int i2) {
        final c cVarB = c.b();
        com.bytedance.msdk.d.u.an.c(new Runnable() { // from class: com.bytedance.msdk.u.an.20
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.u.b.d.d().d(cVarB, tcVar, hcVar, i, i2);
            }
        });
    }

    public static void d(final com.bytedance.msdk.api.d.hc hcVar, final String str, final boolean z, final String str2, final int i, final Map<String, Object> map) {
        if (hcVar != null) {
            com.bytedance.sdk.gromore.hc.d.d().d(hcVar.d(), d.b);
        }
        final c cVarB = c.b();
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.bytedance.msdk.d.u.an.c(new Runnable() { // from class: com.bytedance.msdk.u.an.21
            @Override // java.lang.Runnable
            public void run() {
                cVarB.d(System.currentTimeMillis() - jCurrentTimeMillis);
                com.bytedance.msdk.u.b.d.d().d(cVarB, hcVar, str, z, str2, i, map);
            }
        });
    }

    public static void d(Map<String, Object> map, final com.bytedance.msdk.api.d.hc hcVar, final com.bytedance.msdk.hc.b bVar, final long j, final int i, final int i2, final int i3, final String str, final int i4, final int i5, final com.bytedance.msdk.core.tc.hc hcVar2) {
        final JSONObject jSONObject;
        int i6;
        final c cVarB = c.b();
        if (map != null) {
            int iIntValue = map.get("group_type") instanceof Integer ? ((Integer) map.get("group_type")).intValue() : 0;
            double dDoubleValue = map.get(SplashAd.KEY_BIDFAIL_ECPM) instanceof Double ? ((Double) map.get(SplashAd.KEY_BIDFAIL_ECPM)).doubleValue() : 0.0d;
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("price_from", map.get("price_from"));
                jSONObject2.put("grout_type", iIntValue);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("target_ecpm_origin", dDoubleValue);
                jSONObject3.put("target_ecpm_upper", map.get("upper_cpm_x"));
                jSONObject2.put("price", jSONObject3);
                if (map.get("price_source") != null) {
                    jSONObject2.put("price_source", map.get("price_source"));
                }
                int iIntValue2 = map.get("rule_in_use") instanceof Integer ? ((Integer) map.get("rule_in_use")).intValue() : 0;
                boolean zBooleanValue = map.get("has_serverBidding") instanceof Boolean ? ((Boolean) map.get("has_serverBidding")).booleanValue() : false;
                if (iIntValue != 3 && iIntValue != 4) {
                    i6 = 0;
                } else if (!zBooleanValue) {
                    i6 = 1;
                } else if (dDoubleValue == 0.0d) {
                    i6 = 2;
                } else if (iIntValue2 == 0) {
                    i6 = 5;
                } else {
                    i6 = (iIntValue != 4 || (map.get("serverBidding_timeout") instanceof Boolean ? ((Boolean) map.get("serverBidding_timeout")).booleanValue() : false)) ? 4 : 3;
                }
                jSONObject2.put("pos_state", i6);
                jSONObject2.put("rule_id", map.get("rule_id"));
                jSONObject2.put("rule_inuse", iIntValue2);
            } catch (JSONException unused) {
            }
            jSONObject = jSONObject2;
        } else {
            jSONObject = null;
        }
        com.bytedance.msdk.d.u.an.c(new Runnable() { // from class: com.bytedance.msdk.u.an.22
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.u.b.d.d().d(cVarB, hcVar, bVar, j, i, i2, i3, str, i4, i5, hcVar2, jSONObject);
            }
        });
    }

    public static void d(final com.bytedance.msdk.api.d.hc hcVar, final com.bytedance.msdk.hc.b bVar, final long j) {
        final c cVarB = c.b();
        com.bytedance.msdk.d.u.an.c(new Runnable() { // from class: com.bytedance.msdk.u.an.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.u.b.d.d().d(cVarB, hcVar, bVar, j);
            }
        });
    }

    public static void d(final com.bytedance.msdk.api.d.hc hcVar, final com.bytedance.msdk.hc.b bVar, final com.bytedance.msdk.core.tc.tc tcVar) {
        final c cVarB = c.b();
        com.bytedance.msdk.d.u.an.c(new Runnable() { // from class: com.bytedance.msdk.u.an.3
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.u.b.d.d().d(cVarB, hcVar, bVar, tcVar);
            }
        });
    }

    public static void d(final com.bytedance.msdk.hc.b bVar, final com.bytedance.msdk.api.d.hc hcVar, final com.bytedance.msdk.core.tc.hc hcVar2, final long j, final String str, final boolean z, final int i, final boolean z2, final boolean z3) {
        final c cVarB = c.b();
        com.bytedance.msdk.d.u.an.c(new Runnable() { // from class: com.bytedance.msdk.u.an.4
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.u.b.d.d().d(cVarB, bVar, hcVar, hcVar2, j, str, z, i, z2, z3);
            }
        });
    }

    public static void hc(final com.bytedance.msdk.api.d.hc hcVar, final int i) {
        final c cVarB = c.b();
        com.bytedance.msdk.d.u.an.c(new Runnable() { // from class: com.bytedance.msdk.u.an.5
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.u.b.d.d().d(cVarB, hcVar, i);
            }
        });
    }

    public static void d(final boolean z) {
        final c cVarB = c.b();
        com.bytedance.msdk.d.u.an.c(new Runnable() { // from class: com.bytedance.msdk.u.an.6
            @Override // java.lang.Runnable
            public void run() {
                cVarB.d("get_config_start").d("reason", Integer.valueOf(z ? com.bytedance.msdk.h.d.d().u("is_config_from_assert") ? 2 : 1 : 0));
                b.d(com.bytedance.msdk.core.hc.getContext(), cVarB, (Map<String, Object>) null);
            }
        });
    }

    public static void hc() {
        c cVarHc = c.hc();
        cVarHc.d("start_up");
        b.d(com.bytedance.msdk.core.hc.getContext(), cVarHc, (Map<String, Object>) null);
    }

    public static void d(long j) {
        String str;
        c cVarHc = c.hc();
        cVarHc.d("sdk_init").b(j);
        zw zwVarAn = com.bytedance.msdk.h.d.an();
        boolean zU = zwVarAn.u("check_unity3d");
        long jC = zwVarAn.c("check_unity3d_time");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (zU && jCurrentTimeMillis - jC > 2592000000L) {
            try {
                Class.forName("com.unity3d.player.UnityPlayer");
                str = "unity_pure";
                try {
                    Class.forName("com.bytedance.android.NativeAdManager");
                    str = "unity";
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                str = null;
            }
            if (str != null) {
                cVarHc.d("develop_type", str);
            }
            zwVarAn.d("check_unity3d", true);
            zwVarAn.d("check_unity3d_time", jCurrentTimeMillis);
        }
        HashMap map = new HashMap();
        int iC = com.bytedance.msdk.h.hc.d.d().c();
        if (iC > 0) {
            com.bytedance.msdk.h.hc.d.d().u();
            map.put("discard_num", Integer.valueOf(iC));
        }
        map.put("csj_plugin_version", com.bytedance.msdk.an.b.b());
        JSONObject jSONObjectU = zw.u();
        if (jSONObjectU != null) {
            map.put("init_time", jSONObjectU);
        }
        zw.d(map);
        zw.hc(map);
        b.d(com.bytedance.msdk.core.hc.getContext(), cVarHc, map);
    }

    public static void hc(long j) {
        c cVarHc = c.hc();
        cVarHc.d("sdk_backstage").d(j);
        HashMap map = new HashMap();
        if (com.bytedance.msdk.h.hc.d.d().mk()) {
            if (com.bytedance.msdk.h.hc.d.d().gb() > 0) {
                com.bytedance.msdk.h.hc.d.d().d(d.b);
                map.put("call_init_method_duration", Long.valueOf(com.bytedance.msdk.h.hc.d.d().gb()));
            }
        } else if (com.bytedance.msdk.h.hc.d.d().mq()) {
            map.put("call_init_method_duration", Long.valueOf(com.bytedance.msdk.h.hc.d.d().gb()));
        }
        map.put("v3", zw.h("v3"));
        map.put(com.alipay.sdk.m.x.c.c, zw.h(com.alipay.sdk.m.x.c.c));
        map.put("v2Enc_config", zw.h("v2Enc_config"));
        map.put("v4Enc_config", zw.h("v4Enc_config"));
        map.put("v2Enc_exchange", zw.h("v2Enc_exchange"));
        map.put("v4Enc_exchange", zw.h("v4Enc_exchange"));
        map.put("v2Enc_reward", zw.h("v2Enc_reward"));
        map.put("v4Enc_reward", zw.h("v4Enc_reward"));
        map.put("enable_label_return", Integer.valueOf(com.bytedance.msdk.core.hc.hc().mt() ? 1 : 0));
        map.put("if_labelapi_call", Integer.valueOf(com.bytedance.msdk.core.d.mk().d() ? 1 : 0));
        map.put("adn_init_duration", com.bytedance.msdk.an.hc.u.hc());
        com.bytedance.msdk.core.d.d.u.d(map);
        JSONArray jSONArrayC = zw.c();
        if (jSONArrayC != null) {
            jSONArrayC.length();
            map.put("sp_v3_bug", jSONArrayC);
        }
        b.d(com.bytedance.msdk.core.hc.getContext(), cVarHc, map);
    }

    public static void d(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        final c cVarB = c.b();
        com.bytedance.msdk.d.u.an.c(new Runnable() { // from class: com.bytedance.msdk.u.an.7
            @Override // java.lang.Runnable
            public void run() {
                cVarB.d("callstack_dynamic");
                cVarB.d("callstack_message", str);
                cVarB.d("callstack_report_time", 1);
                b.d(com.bytedance.msdk.core.hc.getContext(), cVarB, (Map<String, Object>) null);
            }
        });
    }

    public static void d(final com.bytedance.msdk.hc.b bVar, final com.bytedance.msdk.api.d.hc hcVar, final String str, final int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        final c cVarB = c.b();
        com.bytedance.msdk.d.u.an.c(new Runnable() { // from class: com.bytedance.msdk.u.an.8
            @Override // java.lang.Runnable
            public void run() {
                cVarB.d("callstack_static").d("callstack_message", str).d("callstack_report_time", Integer.valueOf(i));
                HashMap map = new HashMap();
                an.d(cVarB, hcVar, (com.bytedance.msdk.core.tc.tc) null, bVar, map);
                b.d(com.bytedance.msdk.core.hc.getContext(), cVarB, map);
            }
        });
    }

    public static void d(long j, int i, int i2, long j2, JSONObject jSONObject, Map<String, Object> map) {
        c cVarHc = c.hc();
        cVarHc.d(ILogConst.EVENT_SDK_INIT_END);
        cVarHc.d(j);
        cVarHc.b(j2);
        cVarHc.d("adn_count", Integer.valueOf(i));
        HashMap map2 = new HashMap();
        if (map != null && map.size() > 0) {
            map2.putAll(map);
        }
        map2.put("is_from_local_config", Integer.valueOf(i2));
        map2.put("adapter_version_list", com.bytedance.msdk.gb.h.d());
        if (jSONObject != null) {
            map2.put("local_init_time", jSONObject);
        }
        b.d(com.bytedance.msdk.core.hc.getContext(), cVarHc, map2);
    }

    public static void d(int i, int i2, long j, boolean z, boolean z2, JSONObject jSONObject, long j2, JSONObject jSONObject2) {
        c cVarHc = c.hc();
        boolean zU = com.bytedance.msdk.h.d.d().u("is_config_from_assert");
        if (i != 1) {
            i = (z || (i == 0 && zU)) ? 2 : 0;
        }
        cVarHc.setResult(i).d(j).d("get_config_final").an(i2).hc(i2).d("transparent_params", com.bytedance.msdk.core.hc.hc().tt());
        HashMap map = new HashMap();
        com.bytedance.msdk.core.tt.c.d(z2, cVarHc, jSONObject, map);
        if (jSONObject2 != null) {
            map.put("cfg_handle_time", jSONObject2);
        }
        map.put("config_size", Long.valueOf(j2));
        b.d(com.bytedance.msdk.core.hc.getContext(), cVarHc, map);
    }

    public static void d(final com.bytedance.msdk.api.d.hc hcVar, final JSONObject jSONObject) {
        final c cVarB = c.b();
        com.bytedance.msdk.d.u.an.c(new Runnable() { // from class: com.bytedance.msdk.u.an.9
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.u.b.d.d().d(cVarB, hcVar, jSONObject);
            }
        });
    }

    public static void d(final com.bytedance.msdk.api.d.hc hcVar, final com.bytedance.msdk.core.c.hc hcVar2, final int i) {
        final c cVarB = c.b();
        com.bytedance.msdk.d.u.an.c(new Runnable() { // from class: com.bytedance.msdk.u.an.10
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.u.b.d.d().d(cVarB, hcVar, hcVar2, i);
            }
        });
    }

    public static void d(final com.bytedance.msdk.hc.b bVar, final com.bytedance.msdk.api.d.hc hcVar, final List<com.bytedance.msdk.hc.b> list, final List<com.bytedance.msdk.hc.b> list2) {
        final c cVarB = c.b();
        com.bytedance.msdk.d.u.an.c(new Runnable() { // from class: com.bytedance.msdk.u.an.11
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.u.b.d.d().d(cVarB, bVar, hcVar, list, list2);
            }
        });
    }

    public static void d(final com.bytedance.msdk.core.tc.tc tcVar, final com.bytedance.msdk.api.d.hc hcVar, final String str) {
        final c cVarB = c.b();
        com.bytedance.msdk.d.u.an.c(new Runnable() { // from class: com.bytedance.msdk.u.an.13
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.u.b.d.d().d(cVarB, tcVar, hcVar, str);
            }
        });
    }

    public static void d(final com.bytedance.msdk.hc.b bVar, final com.bytedance.msdk.api.d.hc hcVar, final com.bytedance.msdk.core.tc.tc tcVar, final long j) {
        final c cVarB = c.b();
        com.bytedance.msdk.d.u.an.c(new Runnable() { // from class: com.bytedance.msdk.u.an.14
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.u.b.d.d().d(cVarB, bVar, hcVar, tcVar, j);
            }
        });
    }

    public static void d(final com.bytedance.msdk.hc.b bVar, final com.bytedance.msdk.api.d.hc hcVar, final com.bytedance.msdk.core.tc.tc tcVar) {
        final c cVarB = c.b();
        com.bytedance.msdk.d.u.an.c(new Runnable() { // from class: com.bytedance.msdk.u.an.15
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.u.b.d.d().d(cVarB, bVar, hcVar, tcVar);
            }
        });
    }

    public static void d(com.bytedance.msdk.api.d.hc hcVar, String str) {
        c cVarHc = c.hc();
        cVarHc.d("cache_cannot_use").d("cache_invalid_info", str);
        HashMap map = new HashMap();
        d(cVarHc, hcVar, (com.bytedance.msdk.core.tc.tc) null, (com.bytedance.msdk.hc.b) null, map);
        b.d(com.bytedance.msdk.core.hc.getContext(), cVarHc, map);
    }

    public static void d(com.bytedance.msdk.api.d.hc hcVar, com.bytedance.msdk.hc.b bVar, String str) {
        c cVarHc = c.hc();
        cVarHc.d("rit_cache_cannot_use").d("cache_invalid_info", str);
        HashMap map = new HashMap();
        d(cVarHc, hcVar, (com.bytedance.msdk.core.tc.tc) null, bVar, map);
        cVarHc.d("mediationrit_req_type", 2);
        b.d(com.bytedance.msdk.core.hc.getContext(), cVarHc, map);
    }

    public static void d(com.bytedance.msdk.api.d.hc hcVar) {
        c cVarHc = c.hc();
        cVarHc.d("media_will_show");
        HashMap map = new HashMap();
        d(cVarHc, hcVar, (com.bytedance.msdk.core.tc.tc) null, (com.bytedance.msdk.hc.b) null, map);
        b.d(com.bytedance.msdk.core.hc.getContext(), cVarHc, map);
    }

    public static void d(com.bytedance.msdk.hc.b bVar, com.bytedance.msdk.api.d.hc hcVar, com.bytedance.msdk.api.d dVar, int i, int i2, String str, long j) {
        d(bVar, hcVar, dVar, i, i2, str, j, (String) null);
    }

    public static void d(com.bytedance.msdk.hc.b bVar, com.bytedance.msdk.api.d.hc hcVar, com.bytedance.msdk.api.d dVar, int i, int i2, String str, long j, String str2) {
        c cVarHc = c.hc();
        cVarHc.setResult(i).hc(dVar != null ? dVar.b : 0).tc(dVar != null ? dVar.c : null).d("media_show_fail_listen").d("play_again", Integer.valueOf(i2));
        if (str != null) {
            cVarHc.d("sub_adn_name", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            cVarHc.d("callstack_message", str2);
        }
        HashMap map = new HashMap();
        boolean z = j >= 0;
        if (bVar != null && bVar.wz()) {
            map.put("custom_adn_sample_ratio", Double.valueOf(rf.b()));
            map.put("custom_adn_sample_ratio_result", Boolean.valueOf(z));
            if (z) {
                map.put("custom_adn_rec_time", Long.valueOf(j));
            }
        }
        d(cVarHc, hcVar, (com.bytedance.msdk.core.tc.tc) null, bVar, map);
        b.d(com.bytedance.msdk.core.hc.getContext(), cVarHc, map);
    }

    public static void d(com.bytedance.msdk.hc.b bVar, com.bytedance.msdk.api.d.hc hcVar, int i, int i2, int i3, String str) {
        c cVarHc = c.hc();
        cVarHc.setResult(i2).d("media_show_after").d("play_again", Integer.valueOf(i3)).d("reason", Integer.valueOf(i));
        if (!TextUtils.isEmpty(str)) {
            cVarHc.d("callstack_message", str);
        }
        HashMap map = new HashMap();
        d(cVarHc, hcVar, (com.bytedance.msdk.core.tc.tc) null, bVar, map);
        b.d(com.bytedance.msdk.core.hc.getContext(), cVarHc, map);
    }

    public static void d(String str, com.bytedance.msdk.hc.b bVar, com.bytedance.msdk.api.d.hc hcVar, com.bytedance.msdk.core.tc.tc tcVar, com.bytedance.msdk.api.d dVar) {
        c cVarHc = c.hc();
        c cVarTc = cVarHc.hc(dVar != null ? dVar.d : 0).tc(dVar != null ? dVar.hc : null);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        cVarTc.u(str).d("custom_adn_init_fail");
        HashMap map = new HashMap();
        d(cVarHc, hcVar, tcVar, bVar, map);
        b.d(com.bytedance.msdk.core.hc.getContext(), cVarHc, map);
    }

    public static void d(com.bytedance.msdk.api.d.hc hcVar, int i, int i2) {
        c cVarHc = c.hc();
        cVarHc.d("mt_ra_s").hc(i);
        HashMap map = new HashMap();
        map.put("pre_req", Integer.valueOf(i2));
        d(cVarHc, hcVar, (com.bytedance.msdk.core.tc.tc) null, (com.bytedance.msdk.hc.b) null, map);
        b.d(com.bytedance.msdk.core.hc.getContext(), cVarHc, map);
    }

    public static void b(com.bytedance.msdk.api.d.hc hcVar, int i) {
        c cVarHc = c.hc();
        cVarHc.d("mt_ra_c").hc(i);
        HashMap map = new HashMap();
        d(cVarHc, hcVar, (com.bytedance.msdk.core.tc.tc) null, (com.bytedance.msdk.hc.b) null, map);
        b.d(com.bytedance.msdk.core.hc.getContext(), cVarHc, map);
    }

    public static void hc(com.bytedance.msdk.api.d.hc hcVar) {
        c cVarHc = c.hc();
        cVarHc.d("mt_ra_cc");
        HashMap map = new HashMap();
        d(cVarHc, hcVar, (com.bytedance.msdk.core.tc.tc) null, (com.bytedance.msdk.hc.b) null, map);
        b.d(com.bytedance.msdk.core.hc.getContext(), cVarHc, map);
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0421  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x04af  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x04e2  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0504  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x051b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0266  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void d(com.bytedance.msdk.u.c r16, com.bytedance.msdk.api.d.hc r17, com.bytedance.msdk.core.tc.tc r18, com.bytedance.msdk.hc.b r19, java.util.Map<java.lang.String, java.lang.Object> r20) {
        /*
            Method dump skipped, instructions count: 1322
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.u.an.d(com.bytedance.msdk.u.c, com.bytedance.msdk.api.d.hc, com.bytedance.msdk.core.tc.tc, com.bytedance.msdk.hc.b, java.util.Map):void");
    }
}
