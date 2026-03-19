package com.bytedance.msdk.core.u.hc;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.api.c.uo;
import com.bytedance.msdk.core.tc.tc;
import com.bytedance.msdk.gb.zw;
import com.bytedance.sdk.component.utils.mq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c extends com.bytedance.msdk.core.u.d {
    private static volatile c d;
    private List<String> mk;
    private int mq;
    private int uo;
    private final Map<String, Integer> hc = new HashMap();
    private final Map<String, Long> b = new HashMap();
    private final Map<String, com.bytedance.msdk.api.d.hc> c = new HashMap();
    private final Map<String, ConcurrentHashMap<String, List<h>>> u = new HashMap();
    private final Map<String, Map<String, com.bytedance.msdk.api.d>> an = new HashMap();
    private final Map<String, Boolean> h = new HashMap();
    private final Map<String, com.bytedance.msdk.core.u.hc.hc> gb = new HashMap();
    private boolean tt = false;
    private int tc = 20;

    public interface b {
        void d(String str, boolean z, int i, List<com.bytedance.msdk.hc.b> list);
    }

    public interface hc {
        void d(boolean z);
    }

    private c() {
    }

    public static c d() {
        if (d == null) {
            synchronized (c.class) {
                if (d == null) {
                    d = new c();
                }
            }
        }
        return d;
    }

    public void d(String str, int i) {
        this.hc.put(str, Integer.valueOf(i));
    }

    public int hc(String str, int i) {
        Integer num;
        if (i == 2 || (num = this.hc.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public boolean b(String str, int i) {
        int iHc = hc(str, i);
        return iHc == 2 || iHc == 3 || iHc == 4;
    }

    public void d(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.b.put(str, Long.valueOf(j));
    }

    public Long d(String str) {
        return this.b.get(str);
    }

    public void d(String str, com.bytedance.msdk.api.d.hc hcVar) {
        if (hcVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.c.put(str, hcVar);
    }

    public com.bytedance.msdk.api.d.hc hc(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.c.get(str);
    }

    public com.bytedance.msdk.core.u.hc.hc b(String str) {
        return this.gb.get(str);
    }

    public void d(String str, h hVar) {
        if (d(str) == null || d(str).longValue() == hVar.d()) {
            ConcurrentHashMap<String, List<h>> concurrentHashMap = this.u.get(str);
            String strPh = hVar.d.ph();
            if (TextUtils.isEmpty(strPh)) {
                return;
            }
            if (concurrentHashMap == null) {
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                copyOnWriteArrayList.add(hVar);
                ConcurrentHashMap<String, List<h>> concurrentHashMap2 = new ConcurrentHashMap<>();
                concurrentHashMap2.put(strPh, copyOnWriteArrayList);
                this.u.put(str, concurrentHashMap2);
                return;
            }
            List<h> list = concurrentHashMap.get(strPh);
            if (list == null) {
                CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
                copyOnWriteArrayList2.add(hVar);
                concurrentHashMap.put(strPh, copyOnWriteArrayList2);
                return;
            }
            list.add(hVar);
        }
    }

    public double hc(String str, com.bytedance.msdk.api.d.hc hcVar) {
        String key;
        List<h> list;
        ConcurrentHashMap<String, List<h>> concurrentHashMap = this.u.get(str);
        double dKb = -1.0d;
        if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
            for (Map.Entry<String, List<h>> entry : concurrentHashMap.entrySet()) {
                if (entry != null && (key = entry.getKey()) != null && (list = concurrentHashMap.get(key)) != null && list.size() > 0) {
                    for (h hVar : list) {
                        if (hVar != null && d(hVar, hVar.c(), hcVar, "聚合预缓存-ra") == -1 && hVar.d.kb() > dKb) {
                            dKb = hVar.d.kb();
                        }
                    }
                }
            }
        }
        return dKb;
    }

    public boolean d(String str, com.bytedance.msdk.api.d.hc hcVar, String str2) {
        boolean z;
        this.h.put(str, Boolean.FALSE);
        com.bytedance.msdk.core.u.hc.hc hcVar2 = this.gb.get(str);
        if (hcVar2 == null) {
            return false;
        }
        List<tc> listHc = hcVar2.hc();
        if (com.bytedance.msdk.d.u.b.hc()) {
            for (tc tcVar : listHc) {
                com.bytedance.msdk.d.u.b.d("TTMediationSDK", com.bytedance.msdk.d.u.u.d(str) + "waterfall: " + tcVar.e() + ", loadSort: " + tcVar.np() + ", showSort: " + tcVar.yi() + ", eCpm: " + tcVar.v());
            }
        }
        boolean[] zArr = {true};
        String strD = d(listHc, str, hcVar, hcVar2, zArr);
        b(str, hcVar);
        ConcurrentHashMap<String, List<h>> concurrentHashMap = this.u.get(str);
        if (concurrentHashMap != null) {
            for (int i = 0; i < listHc.size(); i++) {
                List<h> list = concurrentHashMap.get(listHc.get(i).yo());
                if (list != null && list.size() > 0) {
                    z = true;
                    break;
                }
            }
            z = false;
        } else {
            z = false;
        }
        if (strD != null) {
            if (z) {
                com.bytedance.msdk.u.an.d(this.c.get(str), strD);
            } else {
                hcVar.hc(3);
                if (zArr[0]) {
                    hcVar.hc(1);
                }
                com.bytedance.msdk.u.an.d(hcVar, strD);
            }
        }
        return z;
    }

    private String d(List<tc> list, String str, com.bytedance.msdk.api.d.hc hcVar, com.bytedance.msdk.core.u.hc.hc hcVar2, boolean[] zArr) {
        List<h> list2;
        if (list.size() <= 0) {
            return null;
        }
        ConcurrentHashMap<String, List<h>> concurrentHashMap = this.u.get(str);
        if (concurrentHashMap != null && (list2 = concurrentHashMap.get(list.get(0).yo())) != null && list2.size() > 0 && list2.get(0) != null) {
            h hVar = list2.get(0);
            if (d(hVar, hVar.c(), hcVar, "聚合预请求") == -1) {
                com.bytedance.msdk.d.u.b.d("TTMediationSDK", com.bytedance.msdk.d.u.u.d(str) + "--==-- 命中最优广告： " + hVar.d.nw() + ", loadSort: " + hVar.d.ho() + ", showSort: " + hVar.d.gu());
                return null;
            }
        }
        List<com.bytedance.msdk.core.u.hc.d> listD = d(list, str, concurrentHashMap, hcVar, hcVar2, zArr);
        if (listD.size() > 0) {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < listD.size(); i++) {
                sb.append(listD.get(i).d());
                if (i == listD.size() - 1) {
                    sb.append("]");
                } else {
                    sb.append(",");
                }
            }
            try {
                String string = new JSONArray(sb.toString()).toString();
                com.bytedance.msdk.d.u.b.d("TTMediationSDK", com.bytedance.msdk.d.u.u.d(str) + "adCannotUseInfo: " + string);
                return string;
            } catch (JSONException e) {
                com.bytedance.msdk.d.u.b.d("TTMediationSDK", com.bytedance.msdk.d.u.u.d(str) + "adCannotUseInfo json err: " + e.getMessage());
            }
        }
        return null;
    }

    private void b(String str, com.bytedance.msdk.api.d.hc hcVar) {
        ConcurrentHashMap<String, List<h>> concurrentHashMap = this.u.get(str);
        if (concurrentHashMap != null) {
            for (String str2 : concurrentHashMap.keySet()) {
                List<h> list = concurrentHashMap.get(str2);
                if (list != null && list.size() > 0 && list.get(0) != null) {
                    h hVar = list.get(0);
                    if (d(hVar, hVar.c(), hcVar, "聚合预缓存") != -1) {
                        concurrentHashMap.remove(str2);
                    }
                }
            }
        }
    }

    private List<com.bytedance.msdk.core.u.hc.d> d(List<tc> list, String str, Map<String, List<h>> map, com.bytedance.msdk.api.d.hc hcVar, com.bytedance.msdk.core.u.hc.hc hcVar2, boolean[] zArr) {
        List<h> list2;
        ArrayList arrayList = new ArrayList();
        int iE_ = hcVar2.e_();
        for (int i = 0; i < list.size() && i < iE_; i++) {
            String strYo = list.get(i).yo();
            com.bytedance.msdk.core.u.hc.d dVar = new com.bytedance.msdk.core.u.hc.d();
            dVar.hc(strYo);
            dVar.u(list.get(i).yi());
            dVar.c(list.get(i).np());
            h hVar = (map == null || (list2 = map.get(strYo)) == null || list2.size() <= 0) ? null : list2.get(0);
            if (hVar == null || hVar.d == null) {
                Map<String, com.bytedance.msdk.api.d> map2 = this.an.get(str);
                com.bytedance.msdk.api.d dVar2 = map2 != null ? map2.get(strYo) : null;
                if (dVar2 != null) {
                    dVar.hc(3);
                    dVar.b(dVar2.b);
                    dVar.d(dVar2.c);
                } else {
                    dVar.hc(4);
                }
                arrayList.add(dVar);
            } else {
                dVar.d(hVar.d.xp() ? 1 : 0);
                zArr[0] = false;
                int iD = d(hVar, this.c.get(str), hcVar, "预缓存");
                if (iD != -1) {
                    dVar.hc(iD);
                    arrayList.add(dVar);
                }
            }
        }
        return arrayList;
    }

    public List<h> c(String str) {
        ArrayList arrayList = new ArrayList();
        ConcurrentHashMap<String, List<h>> concurrentHashMap = this.u.get(str);
        if (concurrentHashMap != null) {
            Iterator<String> it = concurrentHashMap.keySet().iterator();
            while (it.hasNext()) {
                List<h> list = concurrentHashMap.get(it.next());
                if (list != null && list.size() > 0) {
                    arrayList.addAll(list);
                }
            }
        }
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
        Map<String, com.bytedance.msdk.api.d> map = this.an.get(str);
        if (map != null) {
            map.clear();
        }
        return arrayList;
    }

    public void d(final Context context, final String str, final int i) {
        com.bytedance.msdk.d.u.an.d(new Runnable() { // from class: com.bytedance.msdk.core.u.hc.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.d(context, str, 2, i, (b) null);
            }
        });
    }

    public void hc(final Context context, final String str, final int i) {
        com.bytedance.msdk.d.u.an.d(new Runnable() { // from class: com.bytedance.msdk.core.u.hc.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.d(context, str, 4, i, (b) null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Context context, String str, int i, int i2, b bVar) {
        int iHc = hc(str, i2);
        if (!b(str, i2)) {
            com.bytedance.msdk.d.u.b.d("TTMediationSDK", com.bytedance.msdk.d.u.u.d(str) + "--==-- 配置未开启预加载缓存，req_type: " + iHc);
            if (bVar != null) {
                bVar.d(str, false, 0, null);
                return;
            }
            return;
        }
        Boolean bool = this.h.get(str);
        if (bool != null && bool.booleanValue()) {
            com.bytedance.msdk.d.u.b.d("TTMediationSDK", com.bytedance.msdk.d.u.u.d(str) + "--==-- 已发起过预缓存，还未使用掉，此次不发起");
            if (bVar != null) {
                bVar.d(str, true, 0, null);
                return;
            }
            return;
        }
        com.bytedance.msdk.api.d.hc hcVar = this.c.get(str);
        if (hcVar == null) {
            com.bytedance.msdk.d.u.b.d("TTMediationSDK", com.bytedance.msdk.d.u.u.d(str) + "--==-- 预缓存取消，adslot为null，rit：" + str);
            return;
        }
        com.bytedance.msdk.api.d.hc hcVar2 = new com.bytedance.msdk.api.d.hc(hcVar);
        com.bytedance.msdk.d.u.b.d("TTMediationSDK", com.bytedance.msdk.d.u.u.d(str) + "--==-- 预缓存开始请求, req_type: " + iHc);
        com.bytedance.msdk.core.u.hc.hc hcVarD = u.d(context, str, hcVar2.de());
        this.gb.put(str, hcVarD);
        this.h.put(str, Boolean.TRUE);
        hcVar2.c(str);
        hcVar2.hc(i);
        hcVar2.an(3);
        hcVarD.d(context, hcVar2, bVar);
        an(str);
    }

    private static void an(String str) {
        JSONObject jSONObject;
        zw zwVarD = zw.d((String) null, com.bytedance.msdk.core.hc.getContext());
        String strHc = zwVarD.hc("preload_rit_ts");
        try {
            if (TextUtils.isEmpty(strHc)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(strHc);
            }
            jSONObject.put(str, System.currentTimeMillis());
            zwVarD.d("preload_rit_ts", jSONObject.toString());
        } catch (Throwable th) {
            mq.d(th);
        }
    }

    public static long u(String str) {
        String strHc = zw.d((String) null, com.bytedance.msdk.core.hc.getContext()).hc("preload_rit_ts");
        try {
            if (!TextUtils.isEmpty(strHc)) {
                return new JSONObject(strHc).optLong(str, -1L);
            }
        } catch (Throwable th) {
            mq.d(th);
        }
        return -1L;
    }

    public List<String> hc() {
        return this.mk;
    }

    public int b() {
        return this.mq;
    }

    public int c() {
        return this.uo;
    }

    public void d(int i) {
        this.tc = i;
    }

    public void d(final Activity activity, final List<uo> list, final int i, final int i2) {
        com.bytedance.msdk.d.u.an.d(new Runnable() { // from class: com.bytedance.msdk.core.u.hc.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.tt) {
                    com.bytedance.msdk.d.u.b.d("TTMediationSDK", "注意：预加载preload只能调用一次");
                    return;
                }
                if (activity == null) {
                    com.bytedance.msdk.d.u.b.d("TTMediationSDK", "预加载preload传入的activity不能是null");
                    return;
                }
                List list2 = list;
                if (list2 != null && list2.size() > 0) {
                    c.this.tt = true;
                    c.this.mq = i;
                    c.this.uo = i2;
                    c.this.mk = new ArrayList();
                    for (uo uoVar : list) {
                        if (uoVar != null && uoVar.hc() != null) {
                            c.this.mk.addAll(uoVar.hc());
                        }
                    }
                    int i3 = i;
                    int i4 = (i3 <= 0 || i3 > 20) ? 2 : i3;
                    int i5 = i2;
                    int i6 = (i5 <= 0 || i5 > 10) ? 2 : i5;
                    List listD = c.this.d((List<uo>) list);
                    if (listD.isEmpty()) {
                        return;
                    }
                    c.this.new d(activity, listD, i4, i6, new hc() { // from class: com.bytedance.msdk.core.u.hc.c.3.1
                        @Override // com.bytedance.msdk.core.u.hc.c.hc
                        public void d(boolean z) {
                            if (z) {
                                return;
                            }
                            com.bytedance.msdk.core.tt.u.c().d(c.this.u);
                        }
                    }).d();
                    return;
                }
                com.bytedance.msdk.d.u.b.d("TTMediationSDK", "预加载preload传入的requestInfos不能是null或者size为0");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<uo> d(List<uo> list) {
        ArrayList arrayList = new ArrayList();
        int i = this.tc;
        HashSet hashSet = new HashSet();
        for (uo uoVar : list) {
            if (arrayList.size() >= i) {
                break;
            }
            if (uoVar != null && uoVar.hc() != null) {
                for (String str : uoVar.hc()) {
                    if (arrayList.size() < i) {
                        if (!TextUtils.isEmpty(str) && !hashSet.contains(str)) {
                            hashSet.add(str);
                            ArrayList arrayList2 = new ArrayList(1);
                            arrayList2.add(str);
                            arrayList.add(new uo(uoVar.d(), arrayList2));
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private class d {
        private final hc an;
        private final int b;
        private final int c;
        private int gb;
        private int h;
        private final Activity hc;
        private final List<uo> u;

        static /* synthetic */ int b(d dVar) {
            int i = dVar.gb;
            dVar.gb = i - 1;
            return i;
        }

        static /* synthetic */ int hc(d dVar) {
            int i = dVar.h;
            dVar.h = i - 1;
            return i;
        }

        d(Activity activity, List<uo> list, int i, int i2, hc hcVar) {
            this.hc = activity;
            this.u = list;
            this.b = i;
            this.c = i2;
            this.an = hcVar;
            this.h = list.size();
            this.gb = list.size();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            uo uoVarRemove;
            for (int i = 0; i < this.b; i++) {
                if (this.u.size() > 0 && (uoVarRemove = this.u.remove(0)) != null) {
                    com.bytedance.msdk.api.d.hc hcVarD = uoVarRemove.d();
                    String str = uoVarRemove.hc().get(0);
                    if (hcVarD != null) {
                        if (hcVarD.de() == 1) {
                            com.bytedance.msdk.d.u.b.d("TTMediationSDK", "预加载preload传入的GMAdSlotBase为banner类型，不支持该类型预加载，广告位: ".concat(String.valueOf(str)));
                        } else if (hcVarD.de() == 2) {
                            com.bytedance.msdk.d.u.b.d("TTMediationSDK", "预加载preload传入的GMAdSlotBase为插屏类型，不支持该类型预加载，广告位: ".concat(String.valueOf(str)));
                        } else if (hcVarD.de() == 9) {
                            com.bytedance.msdk.d.u.b.d("TTMediationSDK", "预加载preload传入的GMAdSlotBase为Draw类型，不支持该类型预加载，广告位: ".concat(String.valueOf(str)));
                        } else {
                            c.this.d(str, hcVarD);
                            hcVarD.c(str);
                            com.bytedance.msdk.core.tc.hc hcVarD2 = com.bytedance.msdk.h.d.b.d().d(str, 0, 101);
                            if (hcVarD2 != null) {
                                hcVarD.tt(hcVarD2.ba());
                            } else if (hcVarD.de() == 8) {
                                hcVarD.tt(10);
                            }
                            c.this.d(this.hc, str, 5, 0, new b() { // from class: com.bytedance.msdk.core.u.hc.c.d.1
                                @Override // com.bytedance.msdk.core.u.hc.c.b
                                public void d(String str2, boolean z, int i2, List<com.bytedance.msdk.hc.b> list) {
                                    d.hc(d.this);
                                    if (!z) {
                                        d.b(d.this);
                                    }
                                    com.bytedance.msdk.d.u.b.d("TTMediationSDK", "--==-- pendingLoadNum: " + d.this.h);
                                    if (d.this.h > 0 || d.this.an == null) {
                                        return;
                                    }
                                    d.this.an.d(d.this.gb <= 0);
                                }
                            });
                        }
                    } else {
                        com.bytedance.msdk.d.u.b.d("TTMediationSDK", "预加载preload传入的GMAdSlotBase为空，广告位：".concat(String.valueOf(str)));
                    }
                }
            }
            if (this.u.size() > 0) {
                com.bytedance.msdk.d.u.an.d(new Runnable() { // from class: com.bytedance.msdk.core.u.hc.c.d.2
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.d();
                    }
                }, this.c * 1000);
            }
        }
    }

    public void d(Context context, String str, int i, com.bytedance.msdk.api.d.hc hcVar, com.bytedance.msdk.hc.b bVar, b bVar2) {
        com.bytedance.msdk.core.u.hc.b bVarD = an.d(i, context, str, hcVar == null ? 0 : hcVar.de());
        if (bVarD != null) {
            com.bytedance.msdk.d.u.b.d("TTMediationSDK", "--==-- 预缓存补充请求发起 reqType: " + i);
            bVarD.d(hcVar, bVar, bVar2);
        }
    }
}
