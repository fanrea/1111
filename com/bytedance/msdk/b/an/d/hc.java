package com.bytedance.msdk.b.an.d;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.msdk.api.c.mk;
import com.bytedance.msdk.core.tc.tc;
import com.bytedance.msdk.core.tc.tt;
import com.bytedance.msdk.core.u.hc.c;
import com.bytedance.msdk.d.u.an;
import com.bytedance.msdk.d.u.u;
import com.bytedance.msdk.gb.j;
import com.bytedance.msdk.gb.k;
import com.bytedance.msdk.hc.b;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    protected b an;
    private com.bytedance.msdk.b.hc.d.d cb;
    protected SoftReference<Context> d;
    private String e;
    private long j;
    private d k;
    private com.bytedance.msdk.api.d.hc mk;
    private mk mq;
    private Handler sy;
    private com.bytedance.msdk.core.tc.hc uo;
    private c.b vv;
    protected CopyOnWriteArrayList<b> hc = new CopyOnWriteArrayList<>();
    protected CopyOnWriteArrayList<b> b = new CopyOnWriteArrayList<>();
    protected CopyOnWriteArrayList<b> c = new CopyOnWriteArrayList<>();
    protected CopyOnWriteArrayList<b> u = new CopyOnWriteArrayList<>();
    private final AtomicBoolean w = new AtomicBoolean(false);
    private final AtomicBoolean yo = new AtomicBoolean(false);
    private final AtomicBoolean rf = new AtomicBoolean(false);
    private volatile boolean jh = false;
    protected Map<String, com.bytedance.msdk.b.d.d> h = new ConcurrentHashMap();
    protected long gb = 0;
    private long de = 0;
    private AtomicBoolean v = new AtomicBoolean(false);
    private boolean np = false;
    private boolean yi = false;
    private boolean he = false;
    private final AtomicInteger zw = new AtomicInteger(0);
    protected Map<String, Object> tt = new ConcurrentHashMap();
    protected tt tc = new tt();
    private int s = 0;
    private ConcurrentHashMap<String, com.bytedance.msdk.api.hc> us = new ConcurrentHashMap<>();

    private hc() {
    }

    public static hc d(SoftReference<Context> softReference, com.bytedance.msdk.api.d.hc hcVar, com.bytedance.msdk.b.hc.d.d dVar) {
        hc hcVar2 = new hc();
        com.bytedance.msdk.core.tc.hc hcVarD = com.bytedance.msdk.core.hc.hc().d(hcVar.v(), hcVar.de(), 100);
        hcVar.d(hcVarD);
        hcVar2.mk = hcVar;
        hcVar2.uo = hcVarD;
        if (hcVarD != null) {
            hcVar2.tt.put("render_control", Integer.valueOf(hcVarD.d()));
        }
        hcVar2.mk.c(com.bytedance.msdk.core.hc.hc().nv());
        hcVar2.mk.hc(com.bytedance.msdk.core.hc.hc().tt());
        hcVar2.mk.d(com.bytedance.msdk.core.h.b.c());
        hcVar2.mk.d(com.bytedance.msdk.core.h.b.b());
        hcVar2.mk.b(c.d().hc(hcVar2.mk.v(), com.bytedance.msdk.core.hc.hc().nv()));
        hcVar2.tc.b = com.bytedance.msdk.core.hc.hc().tt();
        hcVar2.d = softReference;
        hcVar2.cb = dVar;
        hcVar2.k = new d();
        return hcVar2;
    }

    public void d(int i) {
        this.s = i;
    }

    public boolean d() {
        return this.w.get();
    }

    public boolean hc() {
        return this.yo.get();
    }

    public boolean b() {
        return this.rf.get();
    }

    public void d(final String str) {
        an.c(new Runnable() { // from class: com.bytedance.msdk.b.an.d.hc.1
            @Override // java.lang.Runnable
            public void run() {
                if (hc.this.cb != null) {
                    hc.this.cb.d(str);
                }
            }
        });
    }

    public void c() {
        ArrayList arrayList;
        ArrayList arrayList2;
        Map<String, Object> map;
        com.bytedance.msdk.d.u.b.c("TTMediationSDK", u.d(this.uo) + " v2 load done..........s:" + d() + "  f:" + hc() + "     p.size" + h().size() + "   bidding.size:" + tc().size() + "   normal.size:" + gb().size() + "   underNormal.size:" + tt().size());
        if (d() || hc()) {
            return;
        }
        this.w.set(true);
        Handler handler = this.sy;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        List<b> listJh = jh();
        if ((v() || (!v() && !this.yi)) && this.uo != null && !this.mk.ra() && (this.uo.j() || this.uo.s())) {
            b bVar = listJh.size() > 0 ? listJh.get(0) : null;
            int iVv = this.mk.vv();
            if (iVv > 1) {
                arrayList = new ArrayList();
                for (int i = 1; i < iVv; i++) {
                    if (i < listJh.size()) {
                        arrayList.add(listJh.get(i));
                    }
                }
                if (listJh.size() > iVv) {
                    arrayList2 = new ArrayList();
                    while (iVv < listJh.size()) {
                        b bVar2 = listJh.get(iVv);
                        if (bVar2 != null && bVar2.oc()) {
                            arrayList2.add(bVar2);
                        }
                        iVv++;
                    }
                } else {
                    arrayList2 = null;
                }
            } else {
                arrayList = null;
                arrayList2 = null;
            }
            com.bytedance.msdk.u.an.d(bVar, this.mk, arrayList, arrayList2);
        }
        if (!this.mk.ra() && !this.yi) {
            com.bytedance.msdk.core.tt.c.d(this.uo, !j.hc(listJh) ? listJh.get(0).kb() : 0.0d, this.mk.v(), this.mk.de());
        }
        if (v()) {
            u(true);
            return;
        }
        int iVv2 = listJh.size() > this.mk.vv() ? this.mk.vv() : listJh.size();
        com.bytedance.msdk.core.tc.hc hcVar = this.uo;
        if (hcVar != null) {
            Map<String, Object> mapU = hcVar.u();
            mapU.put("has_serverBidding", Boolean.valueOf(this.uo.j()));
            map = mapU;
        } else {
            map = null;
        }
        if (!de()) {
            com.bytedance.msdk.api.d.hc hcVar2 = this.mk;
            b bVar3 = this.an;
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.gb;
            int iBc = bc();
            int iHc = hc(this.k.mk());
            com.bytedance.msdk.core.tc.hc hcVar3 = this.uo;
            com.bytedance.msdk.u.an.d(map, hcVar2, bVar3, jElapsedRealtime, iBc, iHc, 0, hcVar3 != null ? hcVar3.wl() : null, iVv2, this.s, this.uo);
        }
        com.bytedance.msdk.d.u.b.c("TTMediationSDK", u.d(this.uo) + "广告加载成功！给外部回调：invokeAdLoadSuccessOnMainUI........P.size:" + h().size() + "   bidding.size:" + tc().size() + "   normal.size:" + gb().size());
        an.b(new Runnable() { // from class: com.bytedance.msdk.b.an.d.hc.2
            @Override // java.lang.Runnable
            public void run() {
                if (hc.this.cb != null) {
                    hc.this.cb.h();
                }
            }
        });
        dc();
    }

    public void d(com.bytedance.msdk.api.d dVar) {
        Handler handler;
        if (dVar == null) {
            dVar = new com.bytedance.msdk.api.d(20005, com.bytedance.msdk.api.d.d(20005));
        }
        if ((!com.bytedance.msdk.gb.hc.d.d(this.uo) || dVar.d != 10003) && (handler = this.sy) != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (d() || hc()) {
            return;
        }
        this.yo.set(true);
        ba().u = true;
        if (!de()) {
            com.bytedance.msdk.u.an.d(this.mk, dVar, this.tc.d);
        }
        if (v()) {
            u(false);
            return;
        }
        com.bytedance.msdk.d.u.b.c("TTMediationSDK", u.d(this.uo) + "广告加载失败！给外部回调：invokeAdLoadFailCallbackOnMainUI...... error Code = " + dVar.d + " error Message = " + dVar.hc);
        final com.bytedance.msdk.api.d dVarD = k.d(this.mk, dVar, yi());
        an.b(new Runnable() { // from class: com.bytedance.msdk.b.an.d.hc.3
            @Override // java.lang.Runnable
            public void run() {
                if (hc.this.cb != null) {
                    hc.this.cb.hc(dVarD);
                }
            }
        });
    }

    public void u() {
        if (v() || hc() || b() || !d()) {
            return;
        }
        com.bytedance.msdk.api.d.hc hcVar = this.mk;
        if (hcVar != null && (hcVar.de() == 7 || this.mk.de() == 8 || this.mk.de() == 10)) {
            com.bytedance.msdk.d.u.b.b("TTMediationSDK", u.d(this.uo) + "广告缓存成功！给外部回调：invokeAdVideoCacheOnMainUI........");
            com.bytedance.msdk.u.an.d(this.mk, mk(), SystemClock.elapsedRealtime() - z());
        }
        this.rf.set(true);
        an.b(new Runnable() { // from class: com.bytedance.msdk.b.an.d.hc.4
            @Override // java.lang.Runnable
            public void run() {
                if (hc.this.cb != null) {
                    hc.this.cb.gb();
                }
            }
        });
    }

    public void d(final List<b> list, final com.bytedance.msdk.api.d dVar) {
        com.bytedance.msdk.core.tc.hc hcVar = this.uo;
        if (hcVar == null || !hcVar.mq()) {
            return;
        }
        if (an()) {
            list = null;
            dVar = new com.bytedance.msdk.api.d(41044, com.bytedance.msdk.api.d.d(41044));
        }
        if (v()) {
            return;
        }
        if (!j.d(list)) {
            com.bytedance.msdk.d.u.b.c("TTMediationSDK", u.d(this.uo) + "单个广告加载完成！给外部回调：invokeSingleAdLoadCallbackUI......");
            for (b bVar : list) {
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK", u.d(this.mk.v(), "fill") + "AdNetWorkName[" + bVar.nw() + "] AdUnitId[" + bVar.ph() + "]  请求成功 (loadSort=" + bVar.ho() + ",showSort=" + bVar.gu() + ")");
            }
        }
        if (dVar != null) {
            com.bytedance.msdk.d.u.b.c("TTMediationSDK", u.d(this.uo) + "单个广告加载失败！给外部回调：invokeSingleAdLoadCallbackUI...... errorCode:" + dVar.d + "  errorMsg:" + dVar.hc);
        }
        an.b(new Runnable() { // from class: com.bytedance.msdk.b.an.d.hc.5
            @Override // java.lang.Runnable
            public void run() {
                if (hc.this.cb != null) {
                    hc.this.cb.d(list, dVar);
                }
            }
        });
    }

    public boolean an() {
        return this.jh;
    }

    public CopyOnWriteArrayList<b> h() {
        return this.u;
    }

    public CopyOnWriteArrayList<b> gb() {
        return this.hc;
    }

    public CopyOnWriteArrayList<b> tt() {
        return this.b;
    }

    public CopyOnWriteArrayList<b> tc() {
        return this.c;
    }

    public b mk() {
        return this.an;
    }

    public void d(b bVar) {
        this.an = bVar;
    }

    public com.bytedance.msdk.core.tc.hc mq() {
        return this.uo;
    }

    public void d(com.bytedance.msdk.core.tc.hc hcVar) {
        this.uo = hcVar;
    }

    public d uo() {
        return this.k;
    }

    public void d(List<b> list) {
        b bVar;
        if (j.d(list) || (bVar = list.get(0)) == null) {
            return;
        }
        if (bVar.hr()) {
            this.u.addAll(list);
            return;
        }
        if (bVar.p()) {
            this.hc.addAll(list);
        } else if (bVar.oc() || bVar.tj() || bVar.ox()) {
            this.c.addAll(list);
        }
    }

    public boolean k() {
        int size = this.u.size();
        com.bytedance.msdk.api.d.hc hcVar = this.mk;
        return size >= (hcVar != null ? hcVar.vv() : 1);
    }

    public boolean e() {
        int size = this.u.size() + this.hc.size();
        com.bytedance.msdk.api.d.hc hcVar = this.mk;
        return size >= (hcVar != null ? hcVar.vv() : 1);
    }

    public boolean cb() {
        int size = this.u.size() + this.hc.size() + this.c.size();
        com.bytedance.msdk.api.d.hc hcVar = this.mk;
        return size >= (hcVar != null ? hcVar.vv() : 1);
    }

    public boolean w() {
        return !this.uo.s() || this.k.u(-100) || this.k.an();
    }

    private boolean hv() {
        return !this.uo.j() || this.k.u(0) || this.k.h();
    }

    public boolean yo() {
        return w() && hv();
    }

    public com.bytedance.msdk.api.d.hc rf() {
        return this.mk;
    }

    public Context getContext() {
        return this.d.get();
    }

    public List<b> jh() {
        ArrayList arrayList = new ArrayList();
        if (!j.d(this.hc)) {
            arrayList.addAll(this.hc);
        }
        if (!j.d(this.c)) {
            arrayList.addAll(this.c);
        }
        com.bytedance.msdk.core.h.b.d(arrayList, com.bytedance.msdk.core.h.b.d());
        if (!j.d(this.u)) {
            com.bytedance.msdk.core.h.b.d(this.u, (Comparator<b>) null);
            arrayList.addAll(0, this.u);
        }
        return arrayList;
    }

    public Map<String, com.bytedance.msdk.b.d.d> sy() {
        return this.h;
    }

    public boolean de() {
        return this.he;
    }

    public void d(boolean z) {
        this.he = z;
    }

    public boolean v() {
        return this.np;
    }

    public void hc(boolean z) {
        this.np = z;
    }

    public void b(boolean z) {
        this.yi = z;
    }

    public ConcurrentHashMap<String, com.bytedance.msdk.api.hc> np() {
        return this.us;
    }

    public void d(ConcurrentHashMap<String, com.bytedance.msdk.api.hc> concurrentHashMap) {
        this.us = concurrentHashMap;
    }

    public List<com.bytedance.msdk.api.hc> yi() {
        com.bytedance.msdk.api.hc value;
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, com.bytedance.msdk.api.hc> entry : np().entrySet()) {
            if (entry != null && (value = entry.getValue()) != null && !TextUtils.equals("广告加载成功", value.an()) && !TextUtils.equals("广告请求中", value.an())) {
                arrayList.add(value);
            }
        }
        return arrayList;
    }

    public void d(c.b bVar) {
        this.vv = bVar;
    }

    public int he() {
        return this.zw.get();
    }

    public void vv() {
        this.zw.incrementAndGet();
    }

    public void d(long j) {
        this.j = j;
    }

    public long zw() {
        return this.j;
    }

    public Map<String, Object> j() {
        return this.tt;
    }

    public mk s() {
        return this.mq;
    }

    public void d(mk mkVar) {
        this.mq = mkVar;
    }

    public void d(Handler handler) {
        this.sy = handler;
    }

    public long us() {
        return this.gb;
    }

    public void hc(long j) {
        this.gb = j;
    }

    public long z() {
        return this.de;
    }

    public void b(long j) {
        this.de = j;
    }

    public boolean fs() {
        return this.v.get();
    }

    public void c(boolean z) {
        this.v.set(z);
    }

    public tt ba() {
        return this.tc;
    }

    public void d(tt ttVar) {
        this.tc = ttVar;
    }

    public String mt() {
        return this.e;
    }

    public void hc(String str) {
        this.e = str;
    }

    public void r() {
        an.d(new Runnable() { // from class: com.bytedance.msdk.b.an.d.hc.6
            @Override // java.lang.Runnable
            public void run() {
                hc.this.jh = true;
                if (hc.this.hc != null) {
                    hc.this.hc.clear();
                }
                if (hc.this.b != null) {
                    hc.this.b.clear();
                }
                if (hc.this.c != null) {
                    hc.this.c.clear();
                }
                if (hc.this.u != null) {
                    hc.this.u.clear();
                }
                if (hc.this.sy != null) {
                    hc.this.sy.removeCallbacksAndMessages(null);
                }
                hc.this.k.mq();
                hc.this.mq = null;
                if (hc.this.yo.get() || hc.this.w.get()) {
                    return;
                }
                hc.this.d(new com.bytedance.msdk.api.hc.d(41044, com.bytedance.msdk.api.d.d(41044)));
            }
        });
    }

    private int bc() {
        List<tc> list;
        com.bytedance.msdk.core.tc.hc hcVar = this.uo;
        int size = 0;
        if (hcVar == null) {
            return 0;
        }
        Map<Integer, List<tc>> mapYi = hcVar.yi();
        if (mapYi != null && mapYi.size() != 0) {
            ArrayList<Integer> arrayList = new ArrayList();
            arrayList.addAll(mapYi.keySet());
            for (Integer num : arrayList) {
                if (this.k.b(num.intValue()) && (list = mapYi.get(num)) != null) {
                    size += list.size();
                }
            }
        }
        return size;
    }

    protected int hc(int i) {
        if (this.k.d() == null) {
            return -1;
        }
        return this.k.d().indexOf(Integer.valueOf(i)) + 1;
    }

    private void dc() {
        if (v() || hc() || b() || !d()) {
            return;
        }
        if (tr()) {
            u();
        } else {
            final long jD = com.bytedance.msdk.core.hc.hc().d(this.mk.de(), this.mk.v());
            an.d(new Runnable() { // from class: com.bytedance.msdk.b.an.d.hc.7
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.msdk.d.u.b.b("TTMediationSDK", u.d(hc.this.uo) + "m-sdk----设置 cacheTimeout 已到时间【" + jD + "】，给外部invokeAdVideoCache ...");
                    hc.this.u();
                }
            }, jD);
        }
    }

    private boolean tr() {
        if (h() != null) {
            Iterator<b> it = h().iterator();
            while (it.hasNext()) {
                if (it.next().xn()) {
                    return true;
                }
            }
        }
        if (tc() != null) {
            Iterator<b> it2 = tc().iterator();
            while (it2.hasNext()) {
                if (it2.next().xn()) {
                    return true;
                }
            }
        }
        if (gb() == null) {
            return false;
        }
        Iterator<b> it3 = gb().iterator();
        while (it3.hasNext()) {
            if (it3.next().xn()) {
                return true;
            }
        }
        return false;
    }

    private void u(final boolean z) {
        an.d(new Runnable() { // from class: com.bytedance.msdk.b.an.d.hc.8
            @Override // java.lang.Runnable
            public void run() {
                if (hc.this.vv != null) {
                    hc.this.vv.d(hc.this.mk.v(), z, 0, null);
                }
            }
        });
    }
}
