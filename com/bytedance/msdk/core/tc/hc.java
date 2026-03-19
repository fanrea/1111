package com.bytedance.msdk.core.tc;

import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.msdk.gb.mk;
import com.bytedance.sdk.component.utils.mq;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    private long an;
    private int b;
    private int ba;
    private com.bytedance.msdk.core.gb.h bc;
    private long c;
    private int cb;
    private String d;
    private int dc;
    private int de;
    private int e;
    private int fs;
    private String gb;
    private long h;
    private int hc;
    private long he;
    private com.bytedance.msdk.core.gb.tt hv;
    private int j;
    private String jh;
    private int mt;
    private String np;
    private int nv;
    private double q;
    private int r;
    private String rf;
    private long ru;
    private double s;
    private int sy;
    private JSONObject tr;
    private long u;
    private int us;
    private int v;
    private boolean vv;
    private long w;
    private double wl;
    private int yi;
    private int yn;
    private int yo;
    private int z;
    private boolean zw;
    private List<tc> tt = new CopyOnWriteArrayList();
    private Map<Integer, List<tc>> tc = new HashMap();
    private Map<Integer, List<tc>> mk = new HashMap();
    private List<Integer> mq = new ArrayList();
    private double uo = -1.0d;
    private double k = -1.0d;
    private int y = 1000;
    private int l = 0;
    private int fu = 2;
    private int xp = 0;
    private Map<String, Object> to = new HashMap();

    public int d() {
        return this.yn;
    }

    public void d(int i) {
        this.yn = i;
    }

    public void d(double d) {
        if (d < 0.1d || d > 1.0d) {
            d = 0.1d;
        }
        this.q = d;
    }

    public double hc() {
        return this.q;
    }

    public void hc(double d) {
        if (d < 0.01d || d > 1.0d) {
            d = 0.01d;
        }
        this.wl = d;
    }

    public double b() {
        return this.wl;
    }

    public void d(long j) {
        if (j < 1000) {
            j = 1000;
        }
        this.ru = j;
    }

    public long c() {
        return this.ru;
    }

    public Map<String, Object> u() {
        return this.to;
    }

    public int an() {
        return this.nv;
    }

    public void hc(int i) {
        this.nv = i;
    }

    public int h() {
        int iMin = Math.min(this.y, 1000);
        if (iMin <= 0) {
            return 1000;
        }
        return iMin;
    }

    public void b(int i) {
        this.y = i;
    }

    public void c(int i) {
        this.dc = i;
    }

    public com.bytedance.msdk.core.gb.h gb() {
        return this.bc;
    }

    public void d(com.bytedance.msdk.core.gb.h hVar) {
        this.bc = hVar;
    }

    public com.bytedance.msdk.core.gb.tt tt() {
        return this.hv;
    }

    public void d(com.bytedance.msdk.core.gb.tt ttVar) {
        this.hv = ttVar;
    }

    public void u(int i) {
        this.r = i;
    }

    public boolean tc() {
        return this.r == 1;
    }

    public boolean mk() {
        return this.fs == 3;
    }

    public boolean mq() {
        return this.dc == 1;
    }

    public void an(int i) {
        this.l = i;
    }

    public int uo() {
        return this.l;
    }

    public void h(int i) {
        this.fu = i;
    }

    public int k() {
        int i = this.fu;
        if (i < 2) {
            return 2;
        }
        return i;
    }

    public hc e() {
        List<String> listD = mk.d();
        hc hcVar = new hc();
        hcVar.d = this.d;
        mk.d(listD, "mRitId");
        hcVar.hc = this.hc;
        mk.d(listD, "mRitType");
        hcVar.b = this.b;
        mk.d(listD, "mLookType");
        hcVar.c = this.c;
        mk.d(listD, "mMinWaitTime");
        hcVar.u = this.u;
        mk.d(listD, "mLayerTimeOut");
        hcVar.an = this.an;
        mk.d(listD, "mTotalTimeOut");
        hcVar.h = this.h;
        mk.d(listD, "mCacheTimeOut");
        hcVar.gb = this.gb;
        mk.d(listD, "mVersion");
        hcVar.w = this.w;
        mk.d(listD, "mWaterFallId");
        hcVar.v = this.v;
        mk.d(listD, "reqType");
        hcVar.jh = this.jh;
        mk.d(listD, "mWaterfallAbTestParam");
        hcVar.yo = this.yo;
        mk.d(listD, "segmentId");
        hcVar.rf = this.rf;
        mk.d(listD, "segmentVersion");
        hcVar.sy = this.sy;
        mk.d(listD, "preLoadSortControl");
        hcVar.de = this.de;
        mk.d(listD, "preShowSortControl");
        hcVar.np = this.np;
        mk.d(listD, "waterfallExtra");
        hcVar.yi = this.yi;
        mk.d(listD, "mMultilevelAfterP");
        hcVar.he = this.he;
        mk.d(listD, "mMultilevelTimeOut");
        hcVar.j = this.j;
        mk.d(listD, "mRefreshTime");
        hcVar.s = this.s;
        mk.d(listD, "mBidFloor");
        hcVar.fs = this.fs;
        mk.d(listD, "mParallelType");
        hcVar.ba = this.ba;
        mk.d(listD, "mReqParallelNum");
        hcVar.mt = this.mt;
        mk.d(listD, "mAdCount");
        hcVar.us = this.us;
        mk.d(listD, "serverSideVerifyPreRequestTime");
        hcVar.z = this.z;
        mk.d(listD, "serverSideRewardType");
        hcVar.dc = this.dc;
        mk.d(listD, "mAdPrime");
        hcVar.fu = this.fu;
        mk.d(listD, "mRefreshNum");
        hcVar.l = this.l;
        mk.d(listD, "mIsRefresh");
        hcVar.bc = this.bc;
        mk.d(listD, "mIntervalFreqctlBean");
        hcVar.hv = this.hv;
        mk.d(listD, "mIntervalPacingBean");
        hcVar.r = this.r;
        mk.d(listD, "mWaterFallTimingMode");
        hcVar.ru = this.ru;
        mk.d(listD, "mReqInterval");
        hcVar.wl = this.wl;
        mk.d(listD, "mTotalTimeoutRate");
        hcVar.q = this.q;
        mk.d(listD, "mLayerTimeoutRate");
        hcVar.to = new HashMap(this.to);
        hcVar.nv = this.nv;
        hcVar.y = this.y;
        hcVar.k = this.k;
        hcVar.mk = new HashMap(this.mk);
        mk.hc(listD, "AdsenseRitConfig");
        hcVar.xp = this.xp;
        mk.d(listD, "mBehaviorTTL");
        return hcVar;
    }

    /* renamed from: cb, reason: merged with bridge method [inline-methods] */
    public hc clone() {
        hc hcVar = new hc();
        hcVar.d = this.d;
        hcVar.hc = this.hc;
        hcVar.b = this.b;
        hcVar.c = this.c;
        hcVar.u = this.u;
        hcVar.an = this.an;
        hcVar.h = this.h;
        hcVar.gb = this.gb;
        hcVar.w = this.w;
        hcVar.v = this.v;
        hcVar.jh = this.jh;
        hcVar.yo = this.yo;
        hcVar.rf = this.rf;
        hcVar.sy = this.sy;
        hcVar.de = this.de;
        hcVar.np = this.np;
        hcVar.yi = this.yi;
        hcVar.he = this.he;
        hcVar.j = this.j;
        hcVar.s = this.s;
        hcVar.fs = this.fs;
        hcVar.ba = this.ba;
        hcVar.mt = this.mt;
        hcVar.us = this.us;
        hcVar.z = this.z;
        hcVar.dc = this.dc;
        hcVar.bc = this.bc;
        hcVar.hv = this.hv;
        hcVar.r = this.r;
        hcVar.vv = this.vv;
        hcVar.zw = this.zw;
        hcVar.tr = this.tr;
        hcVar.uo = this.uo;
        hcVar.cb = this.cb;
        hcVar.tt = new CopyOnWriteArrayList(this.tt);
        hcVar.tc = new HashMap(this.tc);
        hcVar.e = this.e;
        hcVar.mq = new ArrayList(this.mq);
        hcVar.to = new HashMap(this.to);
        hcVar.mk = new HashMap(this.mk);
        hcVar.nv = this.nv;
        hcVar.y = this.y;
        hcVar.k = this.k;
        hcVar.ru = this.ru;
        hcVar.wl = this.wl;
        hcVar.q = this.q;
        hcVar.l = this.l;
        hcVar.fu = this.fu;
        hcVar.xp = this.xp;
        return hcVar;
    }

    public int w() {
        return this.mt;
    }

    public void gb(int i) {
        this.mt = i;
    }

    public double yo() {
        return this.s;
    }

    public void b(double d) {
        this.s = d;
    }

    public int tt(int i) {
        if (an() == 2) {
            int iD = com.bytedance.msdk.core.tt.c.d(this.d, i, u());
            if (this.j != 0 && iD != 0) {
                return iD;
            }
        }
        return this.j;
    }

    public void tc(int i) {
        this.j = i;
    }

    public String rf() {
        return this.np;
    }

    public void d(String str) {
        this.np = str;
    }

    public void mk(int i) {
        this.yi = i;
    }

    public long jh() {
        return this.he;
    }

    public void hc(long j) {
        this.he = j;
    }

    public int sy() {
        return this.v;
    }

    public void mq(int i) {
        this.v = i;
    }

    public int de() {
        return this.cb;
    }

    public double v() {
        return this.uo;
    }

    public void c(double d) {
        this.uo = d;
    }

    public double np() {
        return this.k;
    }

    public void u(double d) {
        this.k = d;
    }

    public Map<Integer, List<tc>> yi() {
        HashMap map = new HashMap();
        Map<Integer, List<tc>> map2 = this.tc;
        if (map2 != null) {
            for (Map.Entry<Integer, List<tc>> entry : map2.entrySet()) {
                map.put(Integer.valueOf(entry.getKey().intValue()), new ArrayList(entry.getValue()));
            }
        }
        return map;
    }

    public long he() {
        return this.w;
    }

    public void b(long j) {
        this.w = j;
    }

    public void uo(int i) {
        this.yo = i;
    }

    public int vv() {
        return this.yo;
    }

    public void hc(String str) {
        this.rf = str;
    }

    public String zw() {
        return this.rf;
    }

    public boolean j() {
        return this.vv;
    }

    public void d(boolean z) {
        this.vv = z;
    }

    public boolean s() {
        return this.zw;
    }

    public void hc(boolean z) {
        this.zw = z;
    }

    public String us() {
        return this.gb;
    }

    public void b(String str) {
        this.gb = str;
    }

    public List<Integer> z() {
        return this.mq;
    }

    public String fs() {
        return this.d;
    }

    public void c(String str) {
        this.d = str;
    }

    public int ba() {
        return this.hc;
    }

    public void k(int i) {
        this.hc = i;
    }

    public void e(int i) {
        this.b = i;
    }

    public long mt() {
        return this.c;
    }

    public void c(long j) {
        this.c = j;
    }

    public long r() {
        return this.u;
    }

    public void u(long j) {
        this.u = j;
    }

    public long hv() {
        return this.an;
    }

    public void an(long j) {
        this.an = j;
    }

    public long bc() {
        return this.h;
    }

    public void h(long j) {
        this.h = j;
    }

    public void cb(int i) {
        this.us = i;
    }

    public int dc() {
        return this.us;
    }

    public void w(int i) {
        this.z = i;
    }

    public int tr() {
        return this.z;
    }

    public Map<Integer, List<tc>> nv() {
        return this.mk;
    }

    public List<tc> y() {
        return this.tt;
    }

    private void b(List<tc> list) {
        int iNp;
        List<tc> arrayList;
        if (list == null) {
            return;
        }
        this.mk.clear();
        int i = -1000;
        for (int i2 = 0; i2 < list.size(); i2++) {
            tc tcVar = list.get(i2);
            if (tcVar != null) {
                if (tcVar.rf() == 0) {
                    arrayList = new ArrayList<>();
                    iNp = tcVar.yi();
                } else if (tcVar.np() != i) {
                    arrayList = new ArrayList<>();
                    iNp = tcVar.np();
                } else {
                    iNp = i;
                    arrayList = this.mk.get(Integer.valueOf(i));
                }
                if (arrayList != null) {
                    arrayList.add(tcVar);
                    this.mk.put(Integer.valueOf(iNp), arrayList);
                }
                i = iNp;
            }
        }
    }

    private void c(List<tc> list) {
        int iNp;
        List<tc> arrayList;
        if (list == null) {
            return;
        }
        this.mk.clear();
        int i = -1000;
        for (int i2 = 0; i2 < list.size(); i2++) {
            tc tcVar = list.get(i2);
            if (tcVar != null) {
                if (tcVar.np() != i) {
                    arrayList = new ArrayList<>();
                    iNp = tcVar.np();
                } else {
                    iNp = i;
                    arrayList = this.mk.get(Integer.valueOf(i));
                }
                if (arrayList != null) {
                    arrayList.add(tcVar);
                    this.mk.put(Integer.valueOf(iNp), arrayList);
                }
                i = iNp;
            }
        }
    }

    public void d(List<tc> list) {
        int iNp;
        List<tc> arrayList;
        c(list);
        this.tt = list;
        if (list == null) {
            return;
        }
        this.e = 0;
        this.tc.clear();
        this.mq.clear();
        this.cb = this.tt.size();
        int i = -1000;
        for (int i2 = 0; i2 < this.tt.size(); i2++) {
            tc tcVar = list.get(i2);
            if (tcVar != null) {
                if (tcVar.np() != i) {
                    this.e++;
                    arrayList = new ArrayList<>();
                    iNp = tcVar.np();
                } else {
                    iNp = i;
                    arrayList = this.tc.get(Integer.valueOf(i));
                }
                if (arrayList != null) {
                    arrayList.add(tcVar);
                    this.tc.put(Integer.valueOf(iNp), arrayList);
                }
                i = iNp;
            }
        }
        this.mq.addAll(this.tc.keySet());
    }

    public void hc(List<tc> list) {
        int iNp;
        List<tc> arrayList;
        b(list);
        this.tt = list;
        if (list == null) {
            return;
        }
        this.e = 0;
        this.tc.clear();
        this.mq.clear();
        this.cb = this.tt.size();
        int i = -1000;
        for (int i2 = 0; i2 < this.tt.size(); i2++) {
            tc tcVar = list.get(i2);
            if (tcVar != null) {
                if (tcVar.rf() == 0) {
                    this.e++;
                    arrayList = new ArrayList<>();
                    iNp = tcVar.yi();
                } else if (tcVar.np() != i) {
                    this.e++;
                    arrayList = new ArrayList<>();
                    iNp = tcVar.np();
                } else {
                    iNp = i;
                    arrayList = this.tc.get(Integer.valueOf(i));
                }
                if (arrayList != null) {
                    arrayList.add(tcVar);
                    this.tc.put(Integer.valueOf(iNp), arrayList);
                }
                i = iNp;
            }
        }
        this.mq.addAll(this.tc.keySet());
    }

    public String wl() {
        return this.jh;
    }

    public void u(String str) {
        this.jh = str;
    }

    public tc an(String str) {
        List<tc> list;
        if (!TextUtils.isEmpty(str) && (list = this.tt) != null && list.size() != 0) {
            for (tc tcVar : this.tt) {
                if (str.equals(tcVar.yo())) {
                    return tcVar;
                }
            }
        }
        return null;
    }

    public int q() {
        return this.fs;
    }

    public void yo(int i) {
        this.fs = i;
    }

    public int ru() {
        return this.ba;
    }

    public void rf(int i) {
        this.ba = i;
    }

    public void d(JSONObject jSONObject) {
        this.tr = jSONObject;
    }

    public static hc h(String str) {
        if (TextUtils.isEmpty(str)) {
            com.bytedance.msdk.d.u.b.d("AdsenseRitConfig", "TMe jsonStr is null or empty");
            return null;
        }
        try {
            return d(new JSONObject(str), true);
        } catch (JSONException e) {
            mq.d(e);
            return null;
        }
    }

    public static hc d(JSONObject jSONObject, boolean z) throws JSONException {
        JSONObject jSONObject2;
        tc tcVar;
        String str;
        String str2 = null;
        if (jSONObject == null) {
            return null;
        }
        hc hcVar = new hc();
        hcVar.d(jSONObject);
        hcVar.b(jSONObject.optDouble("bid_floor", 0.0d));
        hcVar.c(jSONObject.optString("rit_id"));
        hcVar.b(jSONObject.optString(Config.INPUT_DEF_VERSION));
        hcVar.b(jSONObject.optLong("waterfall_id", -1L));
        hcVar.k(jSONObject.optInt("rit_type"));
        hcVar.e(jSONObject.optInt("look_type", 1));
        hcVar.c(jSONObject.optLong("time_min", sy(hcVar.ba()).longValue()));
        hcVar.u(jSONObject.optLong("layer_time_out", 2000L));
        hcVar.an(jSONObject.optLong("total_time_out", de(hcVar.ba()).longValue()));
        hcVar.hc(jSONObject.optLong("multilevel_time_out", 2000L));
        hcVar.h(jSONObject.optLong("cache_time_out", com.alipay.sdk.m.u.b.a));
        hcVar.mq(jSONObject.optInt("req_type", 0));
        com.bytedance.msdk.core.u.hc.c.d().d(hcVar.fs(), hcVar.sy());
        hcVar.uo(jSONObject.optInt("segment_id"));
        hcVar.hc(jSONObject.optString("segment_version"));
        hcVar.d(jSONObject.optString("waterfall_extra"));
        hcVar.mk(jSONObject.optInt("multilevel_after_p", 1));
        hcVar.tc(jSONObject.optInt("refresh_time", 0));
        hcVar.an(jSONObject.optInt("is_refresh", 0));
        hcVar.h(jSONObject.optInt("refresh_num", 2));
        hcVar.yo(jSONObject.optInt("parallel_type", 1));
        hcVar.c(jSONObject.optInt("is_adprime", 0));
        hcVar.rf(jSONObject.optInt("req_parallel_num", 2));
        hcVar.cb(jSONObject.optInt("reward_start_time", 15000));
        hcVar.w(jSONObject.optInt("reward_callback_type"));
        hcVar.d(jSONObject.optLong("req_interval", 1000L));
        hcVar.hc(jSONObject.optDouble("total_time_rate", 0.01d));
        hcVar.d(jSONObject.optDouble("layer_time_rate", 0.1d));
        hcVar.d(jSONObject.optInt("support_render_control", 0));
        hcVar.jh(jSONObject.optInt("behavior_ttl"));
        int iOptInt = jSONObject.optInt(PointParamKey.AD_COUNT, 0);
        if (iOptInt < 0) {
            iOptInt = 0;
        } else if (iOptInt > 3) {
            iOptInt = 3;
        }
        hcVar.gb(iOptInt);
        hcVar.hc(jSONObject.optInt("group_type"));
        hcVar.b(jSONObject.optInt("bidding_time_out", 1000));
        String strOptString = jSONObject.optString("waterfall_abtest");
        if (strOptString != null) {
            hcVar.u(strOptString);
        }
        int iOptInt2 = jSONObject.optInt("waterfall_timing_mode");
        hcVar.u(iOptInt2);
        if (hcVar.tc()) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("waterfall_show_pacing_rule");
            if (jSONObjectOptJSONObject != null) {
                str = "waterfall_show_rules_version";
                hcVar.d(new com.bytedance.msdk.core.gb.tt(hcVar.fs(), "", jSONObject.optString("waterfall_show_rules_version"), "", iOptInt2, jSONObjectOptJSONObject.optString("waterfall_show_pacing"), jSONObjectOptJSONObject.optString("waterfall_show_pacing_rule_id")));
            } else {
                str = "waterfall_show_rules_version";
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("waterfall_show_freqctl_rules");
            hcVar.d(new com.bytedance.msdk.core.gb.h(hcVar.fs(), "", jSONObject.optString(str), "", iOptInt2, jSONArrayOptJSONArray == null ? HttpUrl.PATH_SEGMENT_ENCODE_SET_URI : jSONArrayOptJSONArray.toString()));
        }
        if (jSONObject.optInt("is_ra") == 1) {
            com.bytedance.msdk.core.admanager.reward.rewardagain.d dVar = new com.bytedance.msdk.core.admanager.reward.rewardagain.d();
            dVar.d(jSONObject.optString("ra_id"));
            dVar.hc(jSONObject.optInt("ra_max", 0));
            dVar.hc(jSONObject.optDouble("ra_ecpm"));
            dVar.d(jSONObject.optLong("ra_in", 0L));
            dVar.d(jSONObject.optInt("ra_h_max", 0));
            dVar.d(jSONObject.optDouble("ra_ra"));
            com.bytedance.msdk.core.admanager.reward.rewardagain.b.d(hcVar.fs(), dVar);
        } else {
            com.bytedance.msdk.core.admanager.reward.rewardagain.b.tc(hcVar.fs());
        }
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("adn_rit_conf");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray2 != null) {
            int i = 0;
            while (i < jSONArrayOptJSONArray2.length()) {
                try {
                    jSONObject2 = jSONArrayOptJSONArray2.getJSONObject(i);
                    tcVar = new tc();
                    tcVar.b(jSONObject2.optString("adn_name"));
                    if (com.bytedance.msdk.core.hc.hc().b(jSONObject2.optString("adn_name"))) {
                        tcVar.c(jSONObject2.optString("custom_adn_name"));
                    } else {
                        tcVar.c(str2);
                    }
                    tcVar.h(hcVar.wl());
                    String strOptString2 = jSONObject2.optString("adn_slot_id");
                    tcVar.u(strOptString2);
                    if (!z && !TextUtils.isEmpty(strOptString2) && !TextUtils.isEmpty(hcVar.fs())) {
                        com.bytedance.msdk.b.gb.c.hc.put(strOptString2, hcVar.fs());
                    }
                    tcVar.d(jSONObject2.optInt("is_refresh", 0));
                    int iOptInt3 = jSONObject2.optInt("freqctl_timing_mode");
                    tcVar.hc(iOptInt3);
                    if (tcVar.c()) {
                        JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("show_pacing_rule");
                        if (jSONObjectOptJSONObject2 != null) {
                            tcVar.d(new com.bytedance.msdk.core.gb.tt(hcVar.fs(), strOptString2, "", "", iOptInt3, jSONObjectOptJSONObject2.optString("pacing"), jSONObjectOptJSONObject2.optString("rule_id")));
                        }
                        JSONArray jSONArrayOptJSONArray3 = jSONObject2.optJSONArray("show_freqctl_rules");
                        tcVar.d(new com.bytedance.msdk.core.gb.h(hcVar.fs(), strOptString2, "", jSONObject2.optString("show_freqctl_rules_version"), iOptInt3, jSONArrayOptJSONArray3 == null ? HttpUrl.PATH_SEGMENT_ENCODE_SET_URI : jSONArrayOptJSONArray3.toString()));
                    }
                    tcVar.tc(jSONObject2.optInt("req_bidding_type"));
                    tcVar.an(jSONObject2.optString("slot_cpm", "0"));
                    tcVar.hc(jSONObject2.optString("exchange_rate"));
                    tcVar.mk(jSONObject2.optInt("load_sort"));
                    tcVar.mq(jSONObject2.optInt("show_sort"));
                    tcVar.c(jSONObject2.optInt("ad_expired_time", 1800000));
                    com.bytedance.msdk.core.u.hc.c.d().d(hcVar.fs(), tcVar.yo(), tcVar.gb());
                    com.bytedance.msdk.core.u.d.d.d().d(hcVar.fs(), tcVar.yo(), tcVar.gb());
                    tcVar.gb(jSONObject2.optInt("if_is_ready", 1));
                    com.bytedance.msdk.core.u.hc.c.d().hc(hcVar.fs(), tcVar.yo(), tcVar.mq());
                    com.bytedance.msdk.core.u.d.d.d().hc(hcVar.fs(), tcVar.yo(), tcVar.mq());
                    tcVar.u(jSONObject2.optInt("if_reuse_ads", 0));
                    com.bytedance.msdk.core.u.d.d.d().b(hcVar.fs(), tcVar.yo(), tcVar.tt());
                    tcVar.h(jSONObject2.optInt("if_pre_request", 0));
                    com.bytedance.msdk.core.u.d.d.d().an(hcVar.fs(), tcVar.yo(), tcVar.mk());
                    tcVar.tt(hcVar.ba());
                    tcVar.d("%1$s%2$sAdapter");
                    tcVar.an(jSONObject2.optInt("origin_type"));
                    tcVar.b(jSONObject2.optInt("sub_adtype"));
                    tcVar.d(hc(jSONObject2.optJSONObject("multilevel_slot_cpm")));
                } catch (JSONException e) {
                    e = e;
                }
                if (tcVar.rf() == 1) {
                    hcVar.hc(true);
                } else if (tcVar.rf() == 2) {
                    try {
                        hcVar.d(true);
                    } catch (JSONException e2) {
                        e = e2;
                        mq.d(e);
                        i++;
                        str2 = null;
                    }
                } else {
                    if (tcVar.rf() == 3) {
                        try {
                            hcVar.hc(true);
                        } catch (JSONException e3) {
                            e = e3;
                            mq.d(e);
                            i++;
                            str2 = null;
                        }
                    } else if (tcVar.rf() != 100) {
                        if (hcVar.v() == -1.0d || hcVar.v() < tcVar.v()) {
                            hcVar.c(tcVar.v());
                        }
                        if (hcVar.np() == -1.0d || hcVar.np() > tcVar.v()) {
                            hcVar.u(tcVar.v());
                        }
                    }
                    tcVar.tt(jSONObject2.optString("customer_adapter_json"));
                    arrayList.add(tcVar);
                    i++;
                    str2 = null;
                }
                tcVar.tt(jSONObject2.optString("customer_adapter_json"));
                arrayList.add(tcVar);
                i++;
                str2 = null;
            }
        }
        Collections.sort(arrayList);
        if (hcVar.mk()) {
            hcVar.hc(arrayList);
        } else {
            hcVar.d(arrayList);
        }
        return hcVar;
    }

    private static Long sy(int i) {
        if (i != 1) {
            if (i != 2 && i != 3) {
                if (i != 5) {
                    if (i != 7 && i != 8) {
                        return 0L;
                    }
                }
            }
            return 0L;
        }
        return 1000L;
    }

    private static Long de(int i) {
        if (i != 1 && i != 2) {
            if (i == 3) {
                return 5000L;
            }
            if (i != 5) {
                if (i == 7 || i == 8) {
                    return 600000L;
                }
                return Long.valueOf(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
            }
        }
        return Long.valueOf(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }

    private static Map<String, String> hc(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap map = new HashMap();
        try {
            Iterator<String> itKeys = jSONObject.keys();
            if (itKeys == null) {
                return null;
            }
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                String strOptString = jSONObject.optString(next);
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(strOptString)) {
                    map.put(next, strOptString);
                }
            }
            if (map.size() == 0) {
                return null;
            }
            return map;
        } catch (Exception unused) {
            return null;
        }
    }

    public int yn() {
        return this.xp;
    }

    public void jh(int i) {
        this.xp = i;
    }

    public String toString() {
        return "AdsenseRitConfig{mRitId='" + this.d + "', mIsSpeed=" + mk() + ", mHasServerbidding=" + this.vv + ", mHasClientOrMultiLevel=" + this.zw + ", mRitType=" + this.hc + ", mLookType=" + this.b + ", mMinWaitTime=" + this.c + ", mLayerTimeOut=" + this.u + ", mTotalTimeOut=" + this.an + ", mWaterFallConfigList=" + this.tt + ", mWaterFallConfMap=" + this.tc + ", mLoadSortLevelList=" + this.mq + ", mCurrentCommonAdMaxCpm=" + this.uo + ", mTotalLoadLevelCount=" + this.e + ", mTotalWaterFallCount=" + this.cb + ", mWaterfallAbTestParam=" + this.jh + ", mServerSideVerifyPreRequestTime=" + this.us + ", mServerSideVerifyRewardType=" + this.z + '}';
    }
}
