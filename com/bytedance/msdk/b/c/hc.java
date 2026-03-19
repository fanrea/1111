package com.bytedance.msdk.b.c;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.SplashAd;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.msdk.gb.j;
import com.bytedance.msdk.gb.k;
import com.bytedance.msdk.gb.np;
import com.bytedance.msdk.gb.rf;
import com.bytedance.msdk.gb.sy;
import com.bytedance.msdk.gb.w;
import com.kwad.sdk.api.model.AdnName;
import java.lang.ref.SoftReference;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class hc implements com.bytedance.msdk.b.hc.d.d {
    protected com.bytedance.msdk.api.d.hc an;
    protected com.bytedance.msdk.b.an.d.hc b;
    protected com.bytedance.msdk.hc.b c;
    protected SoftReference<Context> gb;
    protected com.bytedance.msdk.core.tc.hc h;
    protected com.bytedance.sdk.openadsdk.w.b.d.hc k;
    protected com.bytedance.msdk.d.hc.an tt;
    protected String u;
    protected com.bytedance.msdk.api.c.d.hc uo;
    protected boolean tc = false;
    protected int mk = 0;
    protected volatile boolean mq = false;
    private final Comparator<com.bytedance.msdk.core.tc.tc> d = new Comparator<com.bytedance.msdk.core.tc.tc>() { // from class: com.bytedance.msdk.b.c.hc.1
        @Override // java.util.Comparator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compare(com.bytedance.msdk.core.tc.tc tcVar, com.bytedance.msdk.core.tc.tc tcVar2) {
            int iNp;
            int iNp2;
            if (tcVar.np() == tcVar2.np()) {
                iNp = tcVar.yi();
                iNp2 = tcVar2.yi();
            } else {
                iNp = tcVar.np();
                iNp2 = tcVar2.np();
            }
            return iNp - iNp2;
        }
    };
    protected final Comparator<com.bytedance.msdk.core.tc.tc> e = new Comparator<com.bytedance.msdk.core.tc.tc>() { // from class: com.bytedance.msdk.b.c.hc.2
        @Override // java.util.Comparator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compare(com.bytedance.msdk.core.tc.tc tcVar, com.bytedance.msdk.core.tc.tc tcVar2) {
            if (tcVar.v() > tcVar2.v()) {
                return -1;
            }
            return tcVar.v() < tcVar2.v() ? 1 : 0;
        }
    };

    @Override // com.bytedance.msdk.b.hc.d.d
    public void d(String str) {
    }

    @Override // com.bytedance.msdk.b.hc.d.d
    public void d(List<com.bytedance.msdk.hc.b> list, com.bytedance.msdk.api.d dVar) {
    }

    @Override // com.bytedance.msdk.b.hc.d.d
    public void gb() {
    }

    @Override // com.bytedance.msdk.b.hc.d.d
    public void h() {
    }

    @Override // com.bytedance.msdk.b.hc.d.d
    public void hc(com.bytedance.msdk.api.d dVar) {
    }

    public hc(Context context) {
        this.gb = new SoftReference<>(context);
    }

    protected void d(com.bytedance.msdk.api.d.hc hcVar) {
        com.bytedance.msdk.b.an.d.hc hcVarD = com.bytedance.msdk.b.an.d.hc.d(this.gb, hcVar, this);
        this.b = hcVarD;
        com.bytedance.msdk.api.d.hc hcVarRf = hcVarD.rf();
        this.an = hcVarRf;
        this.u = hcVarRf.v();
        this.b.j().put("allow_show_close_btn", Boolean.valueOf(hcVar.yo()));
        this.h = this.b.mq();
    }

    protected com.bytedance.msdk.b.b.d.h tt() {
        com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "ad load start.....");
        if (com.bytedance.msdk.core.hc.hc().us()) {
            com.bytedance.msdk.u.an.d((com.bytedance.msdk.hc.b) null, this.b.rf(), rf.d(), 3);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.bytedance.msdk.b.b.d.mk());
        arrayList.add(new com.bytedance.msdk.b.b.d.mq());
        arrayList.add(new com.bytedance.msdk.b.b.d.u());
        arrayList.add(new com.bytedance.msdk.b.b.d.b());
        arrayList.add(new com.bytedance.msdk.b.b.d.uo());
        arrayList.add(new com.bytedance.msdk.b.b.d.an());
        arrayList.add(new com.bytedance.msdk.b.b.d.gb());
        arrayList.add(new com.bytedance.msdk.b.b.d.hc());
        arrayList.add(new com.bytedance.msdk.b.b.d.c());
        com.bytedance.msdk.b.b.d.h hVar = new com.bytedance.msdk.b.b.d.h(arrayList);
        hVar.d(this.b);
        return hVar;
    }

    public void d() {
        com.bytedance.msdk.hc.b bVar = this.c;
        if (bVar != null) {
            bVar.yo();
        }
        this.b.r();
        this.tt = null;
    }

    public List<com.bytedance.msdk.api.hc> tc() {
        return this.b.yi();
    }

    public List<com.bytedance.msdk.api.b> mk() {
        if (!com.bytedance.msdk.core.hc.hc().np()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<com.bytedance.msdk.hc.b> it = this.b.tc().iterator();
        while (it.hasNext()) {
            com.bytedance.msdk.hc.b next = it.next();
            if (next != null) {
                arrayList.add(k.d(this.an, next, false));
            }
        }
        return arrayList;
    }

    public List<com.bytedance.msdk.api.b> mq() {
        if (!com.bytedance.msdk.core.hc.hc().np()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (com.bytedance.msdk.hc.b bVar : this.b.jh()) {
            if (bVar != null) {
                arrayList.add(k.d(this.an, bVar, false));
            }
        }
        return arrayList;
    }

    public void d(com.bytedance.msdk.hc.b bVar) {
        if (com.bytedance.msdk.core.hc.hc().us()) {
            com.bytedance.msdk.u.an.d(bVar, this.an, rf.d(), 2);
        }
    }

    public static int hc(String str) {
        if (!com.bytedance.msdk.core.gb.uo.d().gb(str)) {
            com.bytedance.msdk.d.u.b.d("TTMediationSDK", "--==--: 命中展示频次");
            return 840041;
        }
        if (com.bytedance.msdk.core.gb.uo.d().b(str)) {
            return 0;
        }
        com.bytedance.msdk.d.u.b.d("TTMediationSDK", "--==--: 命中展示间隔");
        return 840042;
    }

    protected boolean uo() {
        boolean zB = np.b(com.bytedance.msdk.core.hc.getContext());
        boolean zHc = np.hc(com.bytedance.msdk.core.hc.getContext());
        com.bytedance.msdk.d.u.b.hc("TTMediationSDK", com.bytedance.msdk.d.u.u.d(this.u) + "setting 下发是否为弱网执行：" + com.bytedance.msdk.core.hc.hc().mq() + "，当前网络环境：2G-type=" + zB + ",3G-type=" + zHc);
        if (com.bytedance.msdk.core.hc.hc().mq()) {
            return zB || zHc;
        }
        return false;
    }

    @DungeonFlag
    public void d(List<com.bytedance.msdk.hc.b> list) {
        boolean z;
        if (list == null || list.size() == 0) {
            return;
        }
        com.bytedance.msdk.core.c.d.d(this.an, this.h, list, this.b.tc());
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            c((com.bytedance.msdk.hc.b) it.next());
        }
        if (this.b.tc().size() == 0) {
            return;
        }
        ArrayList<com.bytedance.msdk.hc.b> arrayList2 = new ArrayList();
        arrayList2.addAll(this.b.tc());
        com.bytedance.msdk.hc.b bVarB = b(list);
        for (com.bytedance.msdk.hc.b bVar : arrayList2) {
            Iterator<com.bytedance.msdk.hc.b> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z = true;
                    break;
                }
                com.bytedance.msdk.hc.b next = it2.next();
                if (next != null && bVar != null && next == bVar) {
                    z = false;
                    break;
                }
            }
            if (z) {
                d(bVarB, bVar, 1);
            }
        }
    }

    private com.bytedance.msdk.hc.b b(com.bytedance.msdk.hc.b bVar) {
        LinkedList<com.bytedance.msdk.hc.b> linkedList = new LinkedList();
        com.bytedance.msdk.b.an.d.hc hcVar = this.b;
        if (hcVar != null) {
            if (hcVar.tc() != null && this.b.tc().size() != 0) {
                linkedList.addAll(this.b.tc());
            }
            if (this.b.gb() != null && this.b.gb().size() != 0) {
                linkedList.addAll(this.b.gb());
            }
            if (this.b.h() != null && this.b.h().size() != 0) {
                linkedList.addAll(this.b.h());
            }
        }
        com.bytedance.msdk.hc.b bVar2 = null;
        if (linkedList.size() != 0 && bVar != null) {
            double dKb = Double.MIN_NORMAL;
            for (com.bytedance.msdk.hc.b bVar3 : linkedList) {
                if (bVar3.kb() < bVar.kb() && bVar3.kb() > dKb) {
                    dKb = bVar3.kb();
                    bVar2 = bVar3;
                }
            }
        }
        return bVar2;
    }

    private com.bytedance.msdk.hc.b b(List<com.bytedance.msdk.hc.b> list) {
        com.bytedance.msdk.hc.b bVar = null;
        if (list != null && list.size() != 0) {
            if (list.size() == 1) {
                return list.get(0);
            }
            double dKb = Double.MIN_NORMAL;
            for (com.bytedance.msdk.hc.b bVar2 : list) {
                if (bVar2.kb() > dKb) {
                    dKb = bVar2.kb();
                    bVar = bVar2;
                }
            }
        }
        return bVar;
    }

    @DungeonFlag
    private void c(com.bytedance.msdk.hc.b bVar) {
        if (bVar == null || this.an == null) {
            return;
        }
        if (TextUtils.equals(bVar.nr(), "xiaomi")) {
            HashMap map = new HashMap();
            map.put(SplashAd.KEY_BIDFAIL_ECPM, Long.valueOf((long) bVar.kb()));
            bVar.hc(map);
            return;
        }
        if (this.an.r()) {
            if (bVar.ox() || bVar.tj() || bVar.oc()) {
                HashMap map2 = null;
                if (TextUtils.equals(bVar.nr(), AdnName.BAIDU)) {
                    map2 = new HashMap();
                    if (com.bytedance.msdk.core.hc.hc().ia()) {
                        com.bytedance.msdk.hc.b bVarB = b(bVar);
                        map2.put(SplashAd.KEY_BIDFAIL_ECPM, Integer.valueOf(bVarB != null ? (int) bVarB.kb() : 0));
                        map2.put(SplashAd.KEY_BIDFAIL_ADN, 10);
                        map2.put("ad_t", 7);
                        map2.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                        map2.put("bid_t", 3);
                    } else if (com.bytedance.msdk.core.hc.hc().nw()) {
                        com.bytedance.msdk.hc.b bVarB2 = b(bVar);
                        int iKb = bVarB2 != null ? (int) bVarB2.kb() : 0;
                        int iKb2 = (int) bVar.kb();
                        int iNextInt = new SecureRandom().nextInt(21) + 10;
                        com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "-------baidu_bid_win firstAdEcpm = " + iKb2 + " secondAdEcpm =" + iKb + " randomNumber = " + iNextInt);
                        map2.put(SplashAd.KEY_BIDFAIL_ECPM, Integer.valueOf(Math.max(iKb2 - iNextInt, iKb)));
                        map2.put(SplashAd.KEY_BIDFAIL_ADN, 10);
                        map2.put("ad_t", 7);
                        map2.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                        map2.put("bid_t", 4);
                    } else {
                        map2.put(SplashAd.KEY_BIDFAIL_ECPM, 0);
                        map2.put(SplashAd.KEY_BIDFAIL_ADN, 10);
                        map2.put("ad_t", 7);
                        map2.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                        map2.put("bid_t", 4);
                    }
                } else if (TextUtils.equals(bVar.nr(), "ks")) {
                    map2 = new HashMap();
                    if (com.bytedance.msdk.core.hc.hc().dz()) {
                        com.bytedance.msdk.hc.b bVarB3 = b(bVar);
                        map2.put("bidEcpm", Double.valueOf(bVar.kb()));
                        map2.put("lossBidEcpm", Double.valueOf(bVarB3 != null ? bVarB3.kb() : 0.0d));
                    } else {
                        map2.put("bidEcpm", 0);
                        map2.put("lossBidEcpm", 0);
                    }
                }
                bVar.hc(map2);
            }
        }
    }

    @DungeonFlag
    protected void d(com.bytedance.msdk.hc.b bVar, com.bytedance.msdk.hc.b bVar2, int i) {
        if (bVar2 == null || this.an == null || i <= 0) {
            return;
        }
        if (TextUtils.equals(bVar2.nr(), "xiaomi")) {
            HashMap map = new HashMap();
            map.put(SplashAd.KEY_BIDFAIL_ECPM, Long.valueOf(bVar != null ? (long) bVar.kb() : 0L));
            map.put("reason", "其他");
            map.put("adn_id", 1);
            bVar2.d((Map<String, Object>) map);
            return;
        }
        if (this.an.r()) {
            HashMap map2 = new HashMap();
            map2.put("bidding_lose_reason", com.bytedance.sdk.openadsdk.core.ba.d.hc.d(i));
            map2.put("bidding_lose_reason_NUM", Integer.valueOf(i));
            if (TextUtils.equals(bVar2.nr(), AdnName.BAIDU)) {
                if (com.bytedance.msdk.core.hc.hc().ia()) {
                    map2.put(SplashAd.KEY_BIDFAIL_ECPM, Integer.valueOf(bVar != null ? (int) bVar.kb() : 0));
                    map2.put(SplashAd.KEY_BIDFAIL_ADN, 10);
                    map2.put("ad_t", 7);
                    map2.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                    map2.put("bid_t", 3);
                    map2.put("reason", 203);
                    map2.put("is_s", 1);
                    map2.put("is_c", 2);
                } else if (com.bytedance.msdk.core.hc.hc().nw()) {
                    map2.put(SplashAd.KEY_BIDFAIL_ECPM, Integer.valueOf(bVar != null ? (int) bVar.kb() : 0));
                    map2.put(SplashAd.KEY_BIDFAIL_ADN, 10);
                    map2.put("ad_t", 7);
                    map2.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                    map2.put("bid_t", 4);
                    map2.put("reason", 203);
                    map2.put("is_s", 1);
                    map2.put("is_c", 2);
                } else {
                    map2.put(SplashAd.KEY_BIDFAIL_ECPM, 0);
                    map2.put(SplashAd.KEY_BIDFAIL_ADN, 10);
                    map2.put("ad_t", 7);
                    map2.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                    map2.put("bid_t", 4);
                    map2.put("reason", 203);
                    map2.put("is_s", 1);
                    map2.put("is_c", 2);
                }
            } else if (TextUtils.equals(bVar2.nr(), "ks")) {
                if (com.bytedance.msdk.core.hc.hc().dz()) {
                    map2.put("failureCode", 2);
                    map2.put("bidEcpm", Double.valueOf(bVar != null ? bVar.kb() : 0.0d));
                    map2.put("adType", 2);
                    map2.put("adnName", "other");
                } else {
                    map2.put("failureCode", 0);
                    map2.put("bidEcpm", 0);
                    map2.put("adType", 2);
                    map2.put("adnName", "other");
                }
            }
            bVar2.d((Map<String, Object>) map2);
        }
    }

    public HashMap<String, com.bytedance.msdk.hc.b> hc(List<com.bytedance.msdk.hc.b> list) {
        HashMap<String, com.bytedance.msdk.hc.b> map = new HashMap<>();
        if (list != null && list.size() > 0) {
            for (com.bytedance.msdk.hc.b bVar : list) {
                if (bVar != null) {
                    map.put(bVar.ph(), bVar);
                }
            }
        }
        return map;
    }

    public void hc(com.bytedance.msdk.hc.b bVar) {
        com.bytedance.msdk.api.d.hc hcVar = this.an;
        int iGb = bVar.gb(hcVar != null ? hcVar.d() : null);
        bVar.tt(3);
        bVar.tc(iGb);
    }

    public List<com.bytedance.msdk.core.tc.tc> hc() {
        boolean z;
        List<com.bytedance.msdk.core.tc.tc> arrayList = new ArrayList<>();
        com.bytedance.msdk.b.an.d.hc hcVar = this.b;
        if (hcVar == null || this.h == null || hcVar.an()) {
            return arrayList;
        }
        Map<Integer, List<com.bytedance.msdk.core.tc.tc>> mapYi = this.h.yi();
        ArrayList arrayList2 = new ArrayList();
        for (Integer num : mapYi.keySet()) {
            if (num != null) {
                arrayList2.add(num);
            }
        }
        com.bytedance.msdk.core.h.hc.d(arrayList2);
        int i = 0;
        if (arrayList2.size() > 0) {
            int i2 = 0;
            z = false;
            while (i < arrayList2.size()) {
                Integer num2 = (Integer) arrayList2.get(i);
                if (num2 != null) {
                    int iIntValue = num2.intValue();
                    if (iIntValue == -100) {
                        i2 = 1;
                    }
                    if (iIntValue < -100) {
                        z = true;
                    }
                    if (mapYi.get(Integer.valueOf(iIntValue)) != null) {
                        arrayList.addAll(mapYi.get(Integer.valueOf(iIntValue)));
                    }
                }
                i++;
            }
            i = i2;
        } else {
            z = false;
        }
        if (i == 0 && this.h.s() && !j.hc(this.b.tc())) {
            Iterator<com.bytedance.msdk.hc.b> it = this.b.tc().iterator();
            while (it.hasNext()) {
                com.bytedance.msdk.hc.b next = it.next();
                if (this.h != null && (next.ox() || next.tj())) {
                    com.bytedance.msdk.core.tc.tc tcVarAn = this.h.an(next.ph());
                    if (tcVarAn != null) {
                        arrayList.add(tcVarAn);
                    }
                }
            }
        }
        if (!z) {
            List<com.bytedance.msdk.core.tc.tc> listK = k();
            if (!j.d(listK)) {
                arrayList.addAll(listK);
            }
        }
        Iterator<com.bytedance.msdk.core.tc.tc> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            if (it2.next() == null) {
                it2.remove();
            }
        }
        if (this.h.j() || this.h.s()) {
            return c(arrayList);
        }
        Collections.sort(arrayList, this.d);
        return arrayList;
    }

    private List<com.bytedance.msdk.core.tc.tc> c(List<com.bytedance.msdk.core.tc.tc> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<com.bytedance.msdk.core.tc.tc> it = list.iterator();
        while (it.hasNext()) {
            com.bytedance.msdk.core.tc.tc next = it.next();
            if (next.z()) {
                it.remove();
                arrayList2.add(next);
            } else if (next.s() || next.fs() || next.us()) {
                it.remove();
                com.bytedance.msdk.core.tc.tc tcVar = new com.bytedance.msdk.core.tc.tc();
                tcVar.u(next.yo());
                tcVar.tc(next.rf());
                tcVar.b(next.e());
                tcVar.c(next.gb());
                tcVar.d(next.h());
                tcVar.mk(next.np());
                tcVar.mq(next.yi());
                tcVar.tt(next.uo());
                tcVar.an(new StringBuilder().append(next.v()).toString());
                tcVar.hc(next.k());
                tcVar.h(next.he());
                tcVar.gb(next.vv());
                tcVar.d(next.zw());
                com.bytedance.msdk.hc.b bVarD = d(tcVar);
                if (bVarD != null) {
                    tcVar.an(new StringBuilder().append(bVarD.js()).toString());
                }
                arrayList.add(tcVar);
            }
        }
        list.addAll(arrayList);
        Collections.sort(list, this.e);
        Collections.sort(arrayList2, this.d);
        list.addAll(0, arrayList2);
        return list;
    }

    private com.bytedance.msdk.hc.b d(com.bytedance.msdk.core.tc.tc tcVar) {
        if (tcVar == null) {
            return null;
        }
        String strYo = tcVar.yo();
        String strB = tcVar.zw() != null ? tcVar.zw().b() : null;
        if (TextUtils.isEmpty(strYo)) {
            return null;
        }
        Iterator<com.bytedance.msdk.hc.b> it = this.b.h().iterator();
        while (it.hasNext()) {
            com.bytedance.msdk.hc.b next = it.next();
            if (next != null && strYo.equals(next.ph())) {
                return next;
            }
        }
        Iterator<com.bytedance.msdk.hc.b> it2 = this.b.gb().iterator();
        while (it2.hasNext()) {
            com.bytedance.msdk.hc.b next2 = it2.next();
            if (next2 != null && strYo.equals(next2.ph())) {
                return next2;
            }
        }
        Iterator<com.bytedance.msdk.hc.b> it3 = this.b.tc().iterator();
        while (it3.hasNext()) {
            com.bytedance.msdk.hc.b next3 = it3.next();
            if (next3 != null) {
                if (next3.oc() && !TextUtils.isEmpty(strB) && !TextUtils.isEmpty(next3.bc())) {
                    if (strYo.equals(next3.ph()) && strB.equals(next3.bc())) {
                        return next3;
                    }
                } else if (strYo.equals(next3.ph())) {
                    return next3;
                }
            }
        }
        return null;
    }

    protected List<com.bytedance.msdk.core.tc.tc> k() {
        com.bytedance.msdk.core.tc.hc hcVar = this.h;
        if (hcVar == null || hcVar.y() == null || this.h.y().size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (com.bytedance.msdk.core.tc.tc tcVar : this.h.y()) {
            if (tcVar != null && tcVar.rf() == 100) {
                arrayList.add(tcVar);
            }
        }
        return arrayList;
    }

    public com.bytedance.msdk.api.b e() {
        if (this.c == null || w.d()) {
            return null;
        }
        return k.d(this.an, this.c, true);
    }

    public com.bytedance.msdk.api.b cb() {
        List<com.bytedance.msdk.hc.b> listJh;
        com.bytedance.msdk.api.d.hc hcVar = this.an;
        if ((hcVar != null && !hcVar.ra() && !com.bytedance.msdk.core.hc.hc().np()) || (listJh = this.b.jh()) == null || listJh.size() == 0) {
            return null;
        }
        return k.d(this.an, listJh.get(0), false);
    }

    public int w() {
        com.bytedance.msdk.hc.b bVar = this.c;
        if (bVar != null) {
            return bVar.qr();
        }
        return -1;
    }

    public Map<String, Object> yo() {
        com.bytedance.msdk.hc.b bVar = this.c;
        Map<String, Object> mapJ = bVar != null ? bVar.j() : null;
        if (mapJ == null) {
            mapJ = b(this.u);
        }
        com.bytedance.msdk.hc.b bVar2 = this.c;
        if (bVar2 != null && bVar2.yn() != null) {
            mapJ.putAll(this.c.yn());
        }
        if (w.d()) {
            String strD = w.d(k.d(this.an, this.c, true));
            if (!TextUtils.isEmpty(strD)) {
                mapJ.put("get_show_ecpm_info", strD);
            }
        }
        return mapJ;
    }

    public static Map<String, Object> b(String str) {
        sy syVar = new sy();
        syVar.put("prime_rit", str);
        return syVar;
    }

    public int rf() {
        com.bytedance.msdk.api.d.hc hcVar = this.an;
        if (hcVar != null) {
            return hcVar.u();
        }
        return 0;
    }

    public com.bytedance.msdk.api.d.hc jh() {
        return this.an;
    }

    public void d(com.bytedance.msdk.api.c.d.hc hcVar) {
        this.uo = hcVar;
    }

    public void d(com.bytedance.sdk.openadsdk.w.b.d.hc hcVar) {
        this.k = hcVar;
    }
}
