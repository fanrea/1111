package com.bytedance.msdk.b.u;

import android.text.TextUtils;
import com.bytedance.msdk.api.d.hc;
import com.bytedance.msdk.core.u.hc.h;
import com.bytedance.msdk.gb.us;
import com.bytedance.msdk.hc.b;
import com.bytedance.sdk.openadsdk.w.b.b.hc;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private static volatile d hc;
    private final Map<Integer, CopyOnWriteArrayList<h>> d = new ConcurrentHashMap();
    private final Comparator<h> b = new Comparator<h>() { // from class: com.bytedance.msdk.b.u.d.1
        @Override // java.util.Comparator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compare(h hVar, h hVar2) {
            if (hVar != null && hVar2 != null && hVar.d != null && hVar2.d != null) {
                if (hVar.d.kb() > hVar2.d.kb()) {
                    return -1;
                }
                if (hVar.d.kb() < hVar2.d.kb()) {
                    return 1;
                }
                if (hVar.d.kb() == hVar2.d.kb() && hVar.d.t() == 1) {
                    return -1;
                }
            }
            return 0;
        }
    };

    private d() {
    }

    public static d d() {
        if (hc == null) {
            synchronized (com.bytedance.msdk.core.u.d.d.class) {
                if (hc == null) {
                    hc = new d();
                }
            }
        }
        return hc;
    }

    public synchronized void d(hc hcVar, List<b> list) {
        if (com.bytedance.msdk.core.hc.hc().an()) {
            if (hcVar == null) {
                return;
            }
            if (hcVar.ra()) {
                return;
            }
            com.bytedance.msdk.d.u.b.c("TTMediationSDK", "广告位：" + hcVar.v() + "  type:" + hcVar.de() + " show后把二价广告放入公共缓存池 数量：" + (list == null ? "没有二价" : Integer.valueOf(list.size())));
            if (hcVar != null && list != null && !list.isEmpty()) {
                CopyOnWriteArrayList<h> copyOnWriteArrayList = this.d.get(Integer.valueOf(hcVar.de()));
                if (copyOnWriteArrayList == null) {
                    copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                }
                for (b bVar : list) {
                    com.bytedance.msdk.d.u.b.c("TTMediationSDK", "广告位：" + hcVar.v() + "  代码位：" + bVar.ph() + "   adnName:" + bVar.nr() + "  loadSort:" + bVar.ho() + "  showSort:" + bVar.gu() + "  ecpm:" + bVar.kb());
                    if (!d(copyOnWriteArrayList, bVar)) {
                        copyOnWriteArrayList.add(new h(bVar, 0L, hcVar));
                    }
                }
                Iterator<h> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    h next = it.next();
                    if (!next.u()) {
                        copyOnWriteArrayList.remove(next);
                    }
                }
                us.d(copyOnWriteArrayList, this.b);
                while (3 < copyOnWriteArrayList.size()) {
                    copyOnWriteArrayList.remove(3);
                }
                com.bytedance.msdk.d.u.b.c("TTMediationSDK", "广告位：" + hcVar.v() + "  type:" + hcVar.de() + "  公共缓存池二价广告的数量：" + copyOnWriteArrayList.size());
                this.d.put(Integer.valueOf(hcVar.de()), copyOnWriteArrayList);
            }
        }
    }

    public synchronized List<h> d(hc hcVar) {
        if (hcVar == null) {
            return null;
        }
        CopyOnWriteArrayList<h> copyOnWriteArrayList = this.d.get(Integer.valueOf(hcVar.de()));
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
            int iVv = hcVar.de() == 5 ? hcVar.vv() : 1;
            ArrayList arrayList = new ArrayList();
            for (h hVar : copyOnWriteArrayList) {
                if (arrayList.size() >= iVv) {
                    break;
                }
                if (hVar.h() && hVar.d != null) {
                    com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "--==-- 公共缓存池，广告：" + hVar.hc() + "  adnName:" + hVar.d.nr() + " showSort:" + hVar.d.gu() + " 暂不可用， 已经被使用中...");
                }
                if (d(hcVar, hVar.c()) && hVar.u() && !hVar.h()) {
                    arrayList.add(hVar);
                    copyOnWriteArrayList.remove(hVar);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((h) it.next()).hc(true);
            }
            return arrayList;
        }
        return null;
    }

    public static List<b> d(hc hcVar, List<b> list, List<b> list2) {
        if (!com.bytedance.msdk.core.hc.hc().an() || hcVar == null || list == null || list.isEmpty() || list2 == null || list2.isEmpty()) {
            return null;
        }
        int iVv = hcVar.de() == 5 ? hcVar.vv() : 1;
        ArrayList arrayList = new ArrayList();
        for (b bVar : list2) {
            if (!hc(list, bVar)) {
                if (arrayList.size() >= iVv) {
                    break;
                }
                if (!bVar.wz() && !bVar.oc() && (!bVar.p() || bVar.kb() > 0.0d)) {
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    private boolean d(List<h> list, b bVar) {
        for (h hVar : list) {
            if (hVar != null && bVar != null && hVar.d == bVar) {
                return true;
            }
        }
        return false;
    }

    private static boolean hc(List<b> list, b bVar) {
        for (b bVar2 : list) {
            if (bVar != null && bVar2 == bVar) {
                return true;
            }
        }
        return false;
    }

    private boolean d(hc hcVar, hc hcVar2) {
        if (hcVar == null || hcVar2 == null || hcVar.de() != hcVar2.de()) {
            return false;
        }
        if ((hcVar.de() == 7 || hcVar.de() == 10) && hcVar.fs() == hcVar2.fs()) {
            return true;
        }
        return (hcVar.de() == 1 || hcVar.de() == 5) && hcVar.yi() == hcVar2.yi() && hcVar.he() == hcVar2.he();
    }

    public static void d(hc hcVar, String str) {
        if (TextUtils.isEmpty(str) || hcVar == null) {
            return;
        }
        if (TextUtils.isEmpty(hcVar.mq())) {
            hcVar.b(hcVar.v());
        }
        if (str.equals(hcVar.v())) {
            return;
        }
        hc.d dVar = new hc.d(new com.bytedance.sdk.openadsdk.w.b.b.hc(hcVar.bc()));
        dVar.c(str);
        hcVar.d(com.bytedance.sdk.openadsdk.mediation.hc.hc.d.d(dVar.d()));
    }
}
