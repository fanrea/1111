package com.bytedance.msdk.u.b;

import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.mobads.container.util.bu;
import com.bytedance.applog.aggregation.MetricsSQLiteCacheKt;
import com.bytedance.msdk.an.b;
import com.bytedance.msdk.api.d.hc;
import com.bytedance.msdk.core.tc.tc;
import com.bytedance.msdk.gb.j;
import com.bytedance.msdk.gb.rf;
import com.bytedance.msdk.u.an;
import com.bytedance.msdk.u.c;
import com.bytedance.msdk.u.gb;
import com.bytedance.sdk.component.utils.mq;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private static volatile d d;

    public static d d() {
        if (d == null) {
            synchronized (d.class) {
                if (d == null) {
                    d = new d();
                }
            }
        }
        return d;
    }

    public void d(c cVar, hc hcVar, String str, boolean z, String str2, int i, Map<String, Object> map) {
        String strD;
        if (i > 0) {
            strD = com.bytedance.msdk.api.d.d(i);
        } else {
            strD = "";
            i = 0;
        }
        cVar.d("mediation_request").d("server_bidding_extra", str2).d("mediation_req_type", Integer.valueOf(i != 0 ? z ? 2 : 3 : !z ? 1 : 0)).d(PointParamKey.AD_COUNT, Integer.valueOf(hcVar != null ? hcVar.vv() : 0)).hc(i).tc(strD);
        HashMap map2 = new HashMap();
        if (map != null && map.size() > 0) {
            map2.putAll(map);
        }
        if (hcVar != null && hcVar.b() == 5) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("parallel_num", com.bytedance.msdk.core.u.hc.c.d().b());
                jSONObject.put(MetricsSQLiteCacheKt.METRICS_INTERVAL, com.bytedance.msdk.core.u.hc.c.d().c());
                jSONObject.put("primerit_list", com.bytedance.msdk.core.u.hc.c.d().hc());
                map2.put("preload_info", jSONObject);
            } catch (JSONException e) {
                mq.d(e);
            }
        }
        if (hcVar != null && hcVar.de() == 3 && (com.bytedance.msdk.h.hc.d.d().mk() || com.bytedance.msdk.h.hc.d.d().mq())) {
            map2.put("init_splash_request_duration", Long.valueOf(com.bytedance.msdk.h.hc.d.d().tt()));
        }
        map2.put("csj_plugin_version", b.b());
        an.d(cVar, hcVar, (tc) null, (com.bytedance.msdk.hc.b) null, map2);
        com.bytedance.msdk.u.b.d(com.bytedance.msdk.core.hc.getContext(), cVar, map2);
    }

    public void d(c cVar, com.bytedance.msdk.hc.b bVar, hc hcVar, com.bytedance.msdk.core.tc.hc hcVar2, long j, String str, boolean z, int i, boolean z2, boolean z3) {
        cVar.d("mediation_fill").d(j).d("server_bidding_extra", str).d("mediation_req_type", Integer.valueOf(!z ? 1 : 0)).d(PointParamKey.AD_COUNT, Integer.valueOf(i)).hc(0).tc("");
        HashMap map = new HashMap();
        if (hcVar != null && hcVar.de() == 3) {
            if (com.bytedance.msdk.h.hc.d.d().mk()) {
                com.bytedance.msdk.h.hc.d.d().d(com.bytedance.msdk.u.d.b);
                map.put("init_splash_fill_duration", Long.valueOf(com.bytedance.msdk.h.hc.d.d().tc()));
            } else if (com.bytedance.msdk.h.hc.d.d().mq()) {
                map.put("init_splash_fill_duration", Long.valueOf(com.bytedance.msdk.h.hc.d.d().tc()));
            }
        }
        an.d(cVar, hcVar, (tc) null, bVar, map);
        map.put("timeout_req", Integer.valueOf(z2 ? 1 : 0));
        map.put("is_callback", Integer.valueOf(z3 ? 1 : 0));
        com.bytedance.msdk.u.b.d(com.bytedance.msdk.core.hc.getContext(), cVar, map);
    }

    public void d(c cVar, hc hcVar, com.bytedance.msdk.hc.b bVar, long j, int i, int i2, int i3, String str, int i4, int i5, com.bytedance.msdk.core.tc.hc hcVar2, JSONObject jSONObject) {
        JSONObject jSONObjectTc;
        cVar.d("mediation_request_end").d(j).d(PointParamKey.AD_COUNT, Integer.valueOf(i4)).d("reason", Integer.valueOf(i5)).hc(i3);
        HashMap map = new HashMap();
        an.d(cVar, hcVar, (tc) null, bVar, map);
        map.put("requested_adn_count", Integer.valueOf(i));
        map.put("requested_level_count", Integer.valueOf(i2));
        if (jSONObject != null) {
            map.put("auto_detail", jSONObject);
        }
        if (hcVar2 != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("layer_time_rate", String.format(Locale.getDefault(), "%.2f", Double.valueOf(hcVar2.hc())));
                jSONObject2.putOpt("req_interval", Long.valueOf(hcVar2.c()));
                jSONObject2.putOpt("total_time_rate", String.format(Locale.getDefault(), "%.2f", Double.valueOf(hcVar2.b())));
                map.put("preload_req", jSONObject2);
            } catch (Throwable th) {
                mq.d(th);
            }
        }
        if (hcVar != null && (jSONObjectTc = hcVar.tc()) != null) {
            map.put("behavior", jSONObjectTc);
        }
        com.bytedance.msdk.u.b.d(com.bytedance.msdk.core.hc.getContext(), cVar, map);
    }

    public void d(c cVar, hc hcVar, com.bytedance.msdk.api.d dVar, String str) {
        JSONObject jSONObjectTc;
        cVar.d("total_load_fail").d("server_bidding_extra", str);
        if (dVar.d == 10003) {
            cVar.hc(10010).tc("延长瀑布流总超时时长或者缩短层超时并添加兜底代码位");
            d(cVar);
        } else if (dVar.d == 810085) {
            cVar.hc(dVar.d).tc(dVar.hc);
            d(cVar);
        } else if (dVar instanceof com.bytedance.msdk.api.hc.b) {
            com.bytedance.msdk.api.hc.b bVar = (com.bytedance.msdk.api.hc.b) dVar;
            cVar.hc(dVar.d).tc(dVar.hc);
            cVar.d("block_pacing", bVar.d());
            cVar.d("waterfall_show_rule_id", bVar.hc());
        } else if (dVar instanceof com.bytedance.msdk.api.hc.hc) {
            com.bytedance.msdk.api.hc.hc hcVar2 = (com.bytedance.msdk.api.hc.hc) dVar;
            cVar.hc(dVar.d).tc(dVar.hc);
            cVar.d("block_show_count", hcVar2.d());
            cVar.d("waterfall_show_rule_id", hcVar2.hc());
        } else if (dVar instanceof com.bytedance.msdk.api.hc.d) {
            cVar.hc(dVar.d).tc(dVar.hc);
            d(cVar);
        } else {
            cVar.hc(bu.aQ).tc("Ad load fail all loadsorts! ");
            d(cVar);
        }
        HashMap map = new HashMap();
        if (hcVar != null && (jSONObjectTc = hcVar.tc()) != null) {
            map.put("behavior", jSONObjectTc);
        }
        cVar.d(PointParamKey.AD_COUNT, Integer.valueOf(hcVar != null ? hcVar.vv() : 0));
        an.d(cVar, hcVar, (tc) null, (com.bytedance.msdk.hc.b) null, map);
        com.bytedance.msdk.u.b.d(com.bytedance.msdk.core.hc.getContext(), cVar, map);
    }

    public void d(c cVar, tc tcVar, hc hcVar, String str, boolean z, int i, int i2, int i3, int i4, com.bytedance.msdk.api.d dVar, long j, boolean z2, boolean z3, String str2) {
        int iD;
        if ((dVar instanceof com.bytedance.msdk.api.hc.b) || (dVar instanceof com.bytedance.msdk.api.hc.hc) || (dVar instanceof com.bytedance.msdk.api.hc.d)) {
            cVar.hc(dVar.d).tc(dVar.hc);
        }
        cVar.d("media_request").an(str).d(PointParamKey.AD_COUNT, Integer.valueOf(hcVar != null ? hcVar.vv() : 0)).d("adn_count", Integer.valueOf(i2)).d("mediationrit_req_type", Integer.valueOf(i3)).d("mediationrit_req_type_src", Integer.valueOf(i4)).d("mediation_req_type", Integer.valueOf(!z ? 1 : 0)).d("media_req_type", Integer.valueOf(i));
        HashMap map = new HashMap();
        map.put("timeout_req", Integer.valueOf(z2 ? 1 : 0));
        map.put("is_callback", Integer.valueOf(z3 ? 1 : 0));
        if (hcVar != null && hcVar.ra() && !TextUtils.isEmpty(str2)) {
            map.put("origin_link_id", str2);
        }
        if (hcVar != null && hcVar.dc() != null && tcVar != null && "pangle".equals(tcVar.e()) && tcVar.uo() == 5 && (iD = hcVar.dc().d()) == 1) {
            map.put("support_render_control", Integer.valueOf(iD));
        }
        if (j != -1) {
            map.put(MetricsSQLiteCacheKt.METRICS_START_TIME, Long.valueOf(SystemClock.elapsedRealtime() - j));
        }
        an.d(cVar, hcVar, tcVar, (com.bytedance.msdk.hc.b) null, map);
        com.bytedance.msdk.u.b.d(com.bytedance.msdk.core.hc.getContext(), cVar, map);
    }

    public void d(c cVar, com.bytedance.msdk.hc.b bVar, int i, String str, long j, hc hcVar, int i2, int i3, int i4, String str2, long j2, long j3) {
        cVar.d("media_fill").d(j).hc(i).tc(str).d("adn_count", Integer.valueOf(i2)).d("adn_preload", Integer.valueOf((bVar == null || !bVar.tr()) ? 0 : 1)).d(PointParamKey.AD_COUNT, Integer.valueOf(i3));
        cVar.d("fill_type", Integer.valueOf(i4));
        if (str2 != null) {
            cVar.d("sub_adn_name", str2);
        }
        HashMap map = new HashMap();
        boolean z = j2 >= 0;
        if (bVar != null && bVar.wz()) {
            map.put("custom_adn_sample_ratio", Double.valueOf(rf.b()));
            map.put("custom_adn_sample_ratio_result", Boolean.valueOf(z));
            if (z) {
                map.put("custom_adn_rec_time", Long.valueOf(j2));
            }
        }
        if (j3 != -1) {
            map.put(MetricsSQLiteCacheKt.METRICS_END_TIME, Long.valueOf(j3));
        }
        if (bVar != null && "pangle".equals(bVar.nw()) && bVar.el() == 5 && bVar.yi() == 1) {
            map.put("if_to_express", Integer.valueOf(bVar.yi()));
        }
        if (com.bytedance.msdk.core.hc.hc().wl() && bVar != null && 5 == bVar.el()) {
            cVar.d("ex_info", gb.d().d(bVar));
        }
        an.d(cVar, hcVar, (tc) null, bVar, map);
        com.bytedance.msdk.u.b.d(com.bytedance.msdk.core.hc.getContext(), cVar, map);
    }

    public void d(c cVar, com.bytedance.msdk.api.d dVar, hc hcVar, tc tcVar, int i, int i2, int i3, String str, long j, String str2, String str3, String str4, long j2) {
        if (dVar instanceof com.bytedance.msdk.api.hc.b) {
            com.bytedance.msdk.api.hc.b bVar = (com.bytedance.msdk.api.hc.b) dVar;
            cVar.hc(dVar.d).tc(dVar.hc);
            cVar.d("block_pacing", bVar.d());
            cVar.d("adn_rit_show_rule_id", bVar.hc());
        } else if (dVar instanceof com.bytedance.msdk.api.hc.hc) {
            com.bytedance.msdk.api.hc.hc hcVar2 = (com.bytedance.msdk.api.hc.hc) dVar;
            cVar.hc(dVar.d).tc(dVar.hc);
            cVar.d("block_show_count", hcVar2.d());
            cVar.d("adn_rit_show_rule_id", hcVar2.hc());
        } else if (dVar instanceof com.bytedance.msdk.api.hc.d) {
            cVar.hc(dVar.d);
            cVar.tc(dVar.hc);
            hc(cVar);
        } else {
            cVar.hc(dVar != null ? dVar.b : -1).tc(dVar != null ? dVar.c : "unknown error");
            hc(cVar);
        }
        cVar.d("media_fill_fail").d(j).an(str).d("adn_count", Integer.valueOf(i)).d("adn_preload", 0).d("mediationrit_req_type", Integer.valueOf(i2)).d("mediationrit_req_type_src", Integer.valueOf(i3));
        HashMap map = new HashMap();
        boolean z = j2 >= 0;
        if (tcVar != null && tcVar.hv()) {
            map.put("custom_adn_sample_ratio", Double.valueOf(rf.b()));
            map.put("custom_adn_sample_ratio_result", Boolean.valueOf(z));
            if (z) {
                map.put("custom_adn_rec_time", Long.valueOf(j2));
            }
        }
        an.d(cVar, hcVar, tcVar, (com.bytedance.msdk.hc.b) null, map);
        if (!TextUtils.isEmpty(str2)) {
            cVar.tt(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            cVar.d("level_tag", str3);
        }
        if (str4 != null) {
            cVar.d("sub_adn_name", str4);
        }
        com.bytedance.msdk.u.b.d(com.bytedance.msdk.core.hc.getContext(), cVar, map);
    }

    public void d(c cVar, tc tcVar, hc hcVar, int i, int i2) {
        cVar.d("adapter_request_fail").d(0L).an((String) null).hc(-99999).tc("adapter create fail !").d("mediationrit_req_type", Integer.valueOf(i)).d("mediationrit_req_type_src", Integer.valueOf(i2));
        HashMap map = new HashMap();
        an.d(cVar, hcVar, tcVar, (com.bytedance.msdk.hc.b) null, map);
        com.bytedance.msdk.u.b.d(com.bytedance.msdk.core.hc.getContext(), cVar, map);
    }

    public void d(c cVar, hc hcVar, int i) {
        cVar.d("get_config_error").hc(i);
        HashMap map = new HashMap();
        an.d(cVar, hcVar, (tc) null, (com.bytedance.msdk.hc.b) null, map);
        com.bytedance.msdk.u.b.d(com.bytedance.msdk.core.hc.getContext(), cVar, map);
    }

    public void d(c cVar, com.bytedance.msdk.hc.b bVar, hc hcVar, List<com.bytedance.msdk.hc.b> list, List<com.bytedance.msdk.hc.b> list2) {
        Iterator<com.bytedance.msdk.hc.b> it;
        HashMap map;
        Iterator<com.bytedance.msdk.hc.b> it2;
        cVar.d("bidding_win_event");
        HashMap map2 = new HashMap();
        an.d(cVar, hcVar, (tc) null, bVar, map2);
        JSONArray jSONArray = new JSONArray();
        if (!j.d(list)) {
            Iterator<com.bytedance.msdk.hc.b> it3 = list.iterator();
            while (it3.hasNext()) {
                com.bytedance.msdk.hc.b next = it3.next();
                if (next != null) {
                    it2 = it3;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        map = map2;
                        try {
                            jSONObject.putOpt("mediation_rit", next.ph());
                            jSONObject.putOpt("adn_name", next.nw());
                            jSONObject.putOpt("load_sort", Integer.valueOf(next.ho()));
                            jSONObject.putOpt("show_sort", Integer.valueOf(next.gu()));
                            jSONObject.putOpt("exchange_rate", next.ia());
                            jSONObject.putOpt("rit_cpm", Double.valueOf(next.kb()));
                            jSONObject.putOpt("m_aid", next.bc());
                            jSONObject.putOpt("req_bidding_type", Integer.valueOf(next.hg()));
                            jSONObject.putOpt("win_state", 1);
                            jSONObject.putOpt("ad_extra", next.dc());
                            jSONObject.putOpt("win_callback", next.r());
                            jSONObject.putOpt("loss_callback", next.hv());
                            if (next.oc()) {
                                jSONObject.putOpt("pricing_type", Integer.valueOf(next.ba()));
                            }
                            jSONArray.put(jSONObject);
                        } catch (Exception unused) {
                        }
                    } catch (Exception unused2) {
                        map = map2;
                    }
                } else {
                    map = map2;
                    it2 = it3;
                }
                it3 = it2;
                map2 = map;
            }
        }
        HashMap map3 = map2;
        if (!j.d(list2)) {
            Iterator<com.bytedance.msdk.hc.b> it4 = list2.iterator();
            while (it4.hasNext()) {
                com.bytedance.msdk.hc.b next2 = it4.next();
                if (next2 != null) {
                    it = it4;
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        JSONArray jSONArray2 = jSONArray;
                        try {
                            jSONObject2.putOpt("mediation_rit", next2.ph());
                            jSONObject2.putOpt("adn_name", next2.nw());
                            jSONObject2.putOpt("load_sort", Integer.valueOf(next2.ho()));
                            jSONObject2.putOpt("show_sort", Integer.valueOf(next2.gu()));
                            jSONObject2.putOpt("exchange_rate", next2.ia());
                            jSONObject2.putOpt("rit_cpm", Double.valueOf(next2.kb()));
                            jSONObject2.putOpt("m_aid", next2.bc());
                            jSONObject2.putOpt("req_bidding_type", Integer.valueOf(next2.hg()));
                            jSONObject2.putOpt("win_state", 0);
                            jSONObject2.putOpt("ad_extra", next2.dc());
                            jSONObject2.putOpt("win_callback", next2.r());
                            jSONObject2.putOpt("loss_callback", next2.hv());
                            if (next2.oc()) {
                                jSONObject2.putOpt("pricing_type", Integer.valueOf(next2.ba()));
                            }
                            jSONArray = jSONArray2;
                            jSONArray.put(jSONObject2);
                        } catch (Exception unused3) {
                            jSONArray = jSONArray2;
                        }
                    } catch (Exception unused4) {
                    }
                } else {
                    it = it4;
                }
                it4 = it;
            }
        }
        map3.put(ILogConst.DRAW_ENTER_TYPE_OTHER, jSONArray);
        com.bytedance.msdk.u.b.d(com.bytedance.msdk.core.hc.getContext(), cVar, map3);
    }

    public void d(c cVar, hc hcVar, JSONObject jSONObject) {
        cVar.d("start_bidding_request").d(2).d(PointParamKey.AD_COUNT, Integer.valueOf(hcVar != null ? hcVar.vv() : 0));
        HashMap map = new HashMap();
        if (jSONObject != null) {
            map.put("token_time", jSONObject);
        }
        an.d(cVar, hcVar, (tc) null, (com.bytedance.msdk.hc.b) null, map);
        com.bytedance.msdk.u.b.d(com.bytedance.msdk.core.hc.getContext(), cVar, map);
    }

    public void d(c cVar, hc hcVar, com.bytedance.msdk.core.c.hc hcVar2, int i) {
        if (hcVar2 == null) {
            return;
        }
        cVar.d("return_bidding_result").d(hcVar2.h).setResult(hcVar2.an).hc(hcVar2.gb == null ? 0 : hcVar2.gb.d).tc(hcVar2.gb == null ? "" : hcVar2.gb.hc).d(2).d("fill_type", Integer.valueOf(i)).d("server_bidding_extra", hcVar2.c).d(PointParamKey.AD_COUNT, Integer.valueOf(hcVar2.tt));
        HashMap map = new HashMap();
        com.bytedance.msdk.core.tt.c.d(hcVar2.tc, hcVar2.d, map);
        if (hcVar2.mk != null) {
            map.put("token_time", hcVar2.mk);
        }
        an.d(cVar, hcVar, (tc) null, (com.bytedance.msdk.hc.b) null, map);
        com.bytedance.msdk.u.b.d(com.bytedance.msdk.core.hc.getContext(), cVar, map);
    }

    public void d(c cVar, tc tcVar, hc hcVar, String str) {
        cVar.d("get_bidding_adm_to_adn").an(str);
        HashMap map = new HashMap();
        an.d(cVar, hcVar, tcVar, (com.bytedance.msdk.hc.b) null, map);
        com.bytedance.msdk.u.b.d(com.bytedance.msdk.core.hc.getContext(), cVar, map);
    }

    public void d(c cVar, com.bytedance.msdk.hc.b bVar, hc hcVar, tc tcVar, long j) {
        cVar.d("bidding_adm_load").d(j);
        HashMap map = new HashMap();
        if (com.bytedance.msdk.core.hc.hc().wl() && bVar != null && 5 == bVar.el()) {
            cVar.d("ex_info", gb.d().d(bVar));
        }
        an.d(cVar, hcVar, tcVar, bVar, map);
        com.bytedance.msdk.u.b.d(com.bytedance.msdk.core.hc.getContext(), cVar, map);
    }

    public void d(c cVar, com.bytedance.msdk.hc.b bVar, hc hcVar, tc tcVar) {
        cVar.d("bidding_adm_cache");
        HashMap map = new HashMap();
        an.d(cVar, hcVar, tcVar, bVar, map);
        com.bytedance.msdk.u.b.d(com.bytedance.msdk.core.hc.getContext(), cVar, map);
    }

    public void d(c cVar, hc hcVar, com.bytedance.msdk.hc.b bVar, tc tcVar) {
        cVar.d("media_cache_success");
        HashMap map = new HashMap();
        an.d(cVar, hcVar, tcVar, bVar, map);
        com.bytedance.msdk.u.b.d(com.bytedance.msdk.core.hc.getContext(), cVar, map);
    }

    public void d(c cVar, hc hcVar, com.bytedance.msdk.hc.b bVar, long j) {
        cVar.d("mediation_video_cached").d(j);
        HashMap map = new HashMap();
        an.d(cVar, hcVar, (tc) null, bVar, map);
        com.bytedance.msdk.u.b.d(com.bytedance.msdk.core.hc.getContext(), cVar, map);
    }

    private static void d(c cVar) {
        cVar.d("block_pacing", "-1");
        cVar.d("waterfall_show_rule_id", "-1");
        cVar.d("block_show_count", "-1");
    }

    private static void hc(c cVar) {
        cVar.d("block_pacing", "-1");
        cVar.d("rit_adn_show_rule_id", "-1");
        cVar.d("block_show_count", "-1");
    }
}
