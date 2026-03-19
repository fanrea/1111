package com.bytedance.msdk.core.tc;

import android.text.TextUtils;
import com.bytedance.msdk.gb.mk;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class tc implements Comparable<tc> {
    private int an;
    private String b;
    private int cb;
    private String d;
    private int de;
    private int e;
    private int gb;
    private int h;
    private String hc;
    private int jh;
    private int k;
    private String mk;
    private String mq;
    private com.bytedance.msdk.core.gb.h np;
    private Map<String, String> rf;
    private String sy;
    private String tc;
    private int tt;
    private int uo;
    private com.bytedance.msdk.core.gb.tt v;
    private int w;
    private int yi;
    private gb yo;
    private String c = "1";
    private String u = "0";

    public void d(int i) {
        this.yi = i;
    }

    public int d() {
        return this.yi;
    }

    public com.bytedance.msdk.core.gb.h hc() {
        return this.np;
    }

    public void d(com.bytedance.msdk.core.gb.h hVar) {
        this.np = hVar;
    }

    public com.bytedance.msdk.core.gb.tt b() {
        return this.v;
    }

    public void d(com.bytedance.msdk.core.gb.tt ttVar) {
        this.v = ttVar;
    }

    public void hc(int i) {
        this.de = i;
    }

    public boolean c() {
        return this.de == 1;
    }

    public tc u() {
        ConcurrentHashMap concurrentHashMap;
        List<String> listHc = mk.hc();
        tc tcVar = new tc();
        tcVar.d = this.d;
        mk.d(listHc, "mAdnetworkName");
        tcVar.b = this.b;
        mk.d(listHc, "mAdnetwokrSlotId");
        tcVar.c = this.c;
        mk.d(listHc, "mExchangeRate");
        tcVar.u = this.u;
        mk.d(listHc, "mEcpm");
        tcVar.an = this.an;
        mk.d(listHc, "mAdnetworkSlotType");
        tcVar.h = this.h;
        mk.d(listHc, "mLoadSort");
        tcVar.gb = this.gb;
        mk.d(listHc, "mShowSort");
        tcVar.tt = this.tt;
        mk.d(listHc, "mRitType");
        tcVar.e = this.e;
        mk.d(listHc, "originType");
        tcVar.jh = this.jh;
        mk.d(listHc, "mSubAdType");
        tcVar.tc = this.tc;
        mk.d(listHc, "mLoaderAdapterName");
        tcVar.mk = this.mk;
        mk.d(listHc, "mWaterfallAbTestParam");
        tcVar.mq = this.mq;
        mk.d(listHc, "mServerBiddingExtra");
        tcVar.uo = this.uo;
        mk.d(listHc, "adExpiredTime");
        tcVar.k = this.k;
        mk.d(listHc, "ifReuseAds");
        tcVar.cb = this.cb;
        mk.d(listHc, "ifPreRequest");
        tcVar.w = this.w;
        mk.d(listHc, "ifIsReady");
        tcVar.yi = this.yi;
        mk.d(listHc, "isRefresh");
        tcVar.hc = this.hc;
        mk.d(listHc, "mCustomAdnetworkName");
        Map<String, String> map = this.rf;
        if (map == null || map.size() <= 0) {
            concurrentHashMap = null;
        } else {
            concurrentHashMap = new ConcurrentHashMap();
            concurrentHashMap.putAll(this.rf);
        }
        tcVar.rf = concurrentHashMap;
        mk.d(listHc, "mMultilevelSlotCpm");
        tcVar.sy = this.sy;
        mk.d(listHc, "mCustomAdapterJson");
        tcVar.de = this.de;
        mk.d(listHc, "mAdnRitTimingMode");
        tcVar.np = this.np;
        mk.d(listHc, "mIntervalFreqctlBean");
        tcVar.v = this.v;
        mk.d(listHc, "mIntervalPacingBean");
        mk.hc(listHc, "WaterFallConfig");
        return tcVar;
    }

    public int an() {
        return this.jh;
    }

    public void b(int i) {
        this.jh = i;
    }

    public String h() {
        return this.tc;
    }

    public void d(String str) {
        this.tc = str;
    }

    public int gb() {
        return this.uo;
    }

    public void c(int i) {
        this.uo = i;
    }

    public int tt() {
        return this.k;
    }

    public void u(int i) {
        this.k = i;
    }

    public int tc() {
        return this.e;
    }

    public void an(int i) {
        this.e = i;
    }

    public int mk() {
        return this.cb;
    }

    public void h(int i) {
        this.cb = i;
    }

    public int mq() {
        return this.w;
    }

    public void gb(int i) {
        this.w = i;
    }

    public int uo() {
        return this.tt;
    }

    public void tt(int i) {
        this.tt = i;
    }

    public String k() {
        return this.c;
    }

    public void hc(String str) {
        this.c = str;
    }

    public String e() {
        return this.d;
    }

    public void b(String str) {
        this.d = str;
    }

    public String cb() {
        return this.hc;
    }

    public void c(String str) {
        this.hc = str;
    }

    public String w() {
        return TextUtils.isEmpty(this.d) ? this.hc : this.d;
    }

    public String yo() {
        return this.b;
    }

    public void u(String str) {
        this.b = str;
    }

    public int rf() {
        return this.an;
    }

    public void tc(int i) {
        this.an = i;
    }

    public boolean jh() {
        int i = this.an;
        return i == 0 || i == 100;
    }

    public double sy() {
        gb gbVar = this.yo;
        if (gbVar != null && !TextUtils.isEmpty(gbVar.u())) {
            try {
                return Double.valueOf(this.yo.u()).doubleValue();
            } catch (Exception e) {
                com.bytedance.msdk.d.u.b.c("WaterFallConfig", "getServerBiddingShowEcpm error " + e.toString());
            }
        }
        return -1.0d;
    }

    public double de() {
        gb gbVar = this.yo;
        if (gbVar != null && !TextUtils.isEmpty(gbVar.an())) {
            try {
                return Double.valueOf(this.yo.an()).doubleValue();
            } catch (Exception e) {
                com.bytedance.msdk.d.u.b.c("WaterFallConfig", "getServerBiddingLoadEcpm error " + e.toString());
            }
        }
        return -1.0d;
    }

    public double v() {
        try {
            return Double.valueOf(this.u).doubleValue() * Double.valueOf(this.c).doubleValue();
        } catch (Exception e) {
            com.bytedance.msdk.d.u.b.c("WaterFallConfig", "getEcpm error " + e.toString());
            return 0.0d;
        }
    }

    public void an(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        this.u = str;
    }

    public int np() {
        return this.h;
    }

    public void mk(int i) {
        this.h = i;
    }

    public int yi() {
        return this.gb;
    }

    public void mq(int i) {
        this.gb = i;
    }

    public String he() {
        return this.mk;
    }

    public void h(String str) {
        this.mk = str;
    }

    public String vv() {
        return this.mq;
    }

    public void gb(String str) {
        this.mq = str;
    }

    public void d(gb gbVar) {
        this.yo = gbVar;
    }

    public gb zw() {
        return this.yo;
    }

    public Map<String, String> j() {
        return this.rf;
    }

    public void d(Map<String, String> map) {
        this.rf = map;
    }

    public String toString() {
        return "WaterFallConfig{mAdnetworkName='" + this.d + "', mCustomAdnetworkName='" + this.hc + "', mAdnetwokrSlotId='" + this.b + "', mExchangeRate=" + this.c + ", mSlotEcpm=" + this.u + ", mAdnetworkSlotType=" + this.an + ", mLoadSort=" + this.h + ", mShowSort=" + this.gb + '}';
    }

    public boolean s() {
        return this.an == 2;
    }

    public boolean us() {
        return this.an == 1;
    }

    public boolean z() {
        return this.an == 100;
    }

    public boolean fs() {
        return this.an == 3;
    }

    public boolean ba() {
        return s() || us() || fs();
    }

    public boolean mt() {
        return this.an == 0;
    }

    @Override // java.lang.Comparable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(tc tcVar) {
        if (tcVar == null || this.h > tcVar.np()) {
            return 1;
        }
        if (this.h < tcVar.np()) {
            return -1;
        }
        if (this.gb > tcVar.yi()) {
            return 1;
        }
        return this.gb < tcVar.yi() ? -1 : 0;
    }

    public void tt(String str) {
        this.sy = str;
    }

    public String r() {
        return this.sy;
    }

    public boolean hv() {
        return com.bytedance.msdk.core.hc.hc().b(this.d);
    }
}
