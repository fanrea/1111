package com.bytedance.msdk.core.gb;

import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class k {
    private static volatile k d;
    private Map<String, ConcurrentHashMap<String, d>> b = new ConcurrentHashMap();
    private Map<String, List<hc>> hc;

    private k() {
    }

    public static k d() {
        if (d == null) {
            synchronized (k.class) {
                if (d == null) {
                    d = new k();
                }
            }
        }
        return d;
    }

    public void d(ConcurrentHashMap<String, List<hc>> concurrentHashMap) {
        this.hc = concurrentHashMap;
        if (concurrentHashMap != null) {
            com.bytedance.msdk.d.u.b.d("TTMediationSDK_RitAdnShowControl", "mRitAdnControlConfigMap = " + this.hc);
        } else {
            com.bytedance.msdk.d.u.b.d("TTMediationSDK_RitAdnShowControl", "mRitAdnControlConfigMap is null ");
        }
    }

    public void d(String str, String str2, String str3, String str4) {
        List<hc> list;
        hc next;
        boolean z;
        com.bytedance.msdk.d.u.b.d("TTMediationSDK_RitAdnShowControl", "setRitAdnError rit_level adnName = " + str2 + " slotId = " + str3 + " error = " + str4);
        Map<String, List<hc>> map = this.hc;
        if (map == null || (list = map.get(str2)) == null || list.size() == 0) {
            return;
        }
        Iterator<hc> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                next = it.next();
                if (next.b().contains(str)) {
                    break;
                }
            } else {
                next = null;
                break;
            }
        }
        if (next != null) {
            for (String str5 : next.hc()) {
                if (TextUtils.equals(str5, str4)) {
                    com.bytedance.msdk.d.u.b.d("TTMediationSDK_RitAdnShowControl", "setAdnError rit_level 命中errorCode = ".concat(String.valueOf(str5)));
                    z = true;
                    break;
                }
            }
            z = false;
        } else {
            z = false;
        }
        if (z) {
            long time = new Date().getTime() + next.d();
            com.bytedance.msdk.d.u.b.d("TTMediationSDK_RitAdnShowControl", "setRitAdnError rit_level 更新时间 = " + an.hc(time));
            d dVar = new d(str2, str3, time, str4);
            Map<String, ConcurrentHashMap<String, d>> map2 = this.b;
            if (map2 != null) {
                ConcurrentHashMap<String, d> concurrentHashMap = map2.get(str2);
                if (concurrentHashMap == null) {
                    concurrentHashMap = new ConcurrentHashMap<>();
                }
                concurrentHashMap.put(str + Config.replace + str3, dVar);
                this.b.put(str2, concurrentHashMap);
                com.bytedance.msdk.d.u.b.d("TTMediationSDK_RitAdnShowControl", "setRitAdnError rit_level mAdnControlMap = " + this.b);
            }
        }
    }

    public com.bytedance.msdk.api.d d(String str, String str2, String str3) {
        d dVar;
        ConcurrentHashMap<String, d> concurrentHashMap;
        com.bytedance.msdk.d.u.b.d("TTMediationSDK_RitAdnShowControl", "checkLoad rit_level adnName = " + str2 + " slotId = " + str3 + " primeRit = " + str);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            Map<String, ConcurrentHashMap<String, d>> map = this.b;
            if (map == null || (concurrentHashMap = map.get(str2)) == null) {
                dVar = null;
            } else {
                dVar = concurrentHashMap.get(str + Config.replace + str3);
                com.bytedance.msdk.d.u.b.d("TTMediationSDK_RitAdnShowControl", "checkLoad rit_level 取出的showBean = ".concat(String.valueOf(dVar)));
            }
            if (dVar != null && dVar.d() != 0) {
                long time = new Date().getTime();
                if (time <= dVar.d()) {
                    com.bytedance.msdk.d.u.b.d("TTMediationSDK_RitAdnShowControl", "checkLoad rit_level 当前时间 = " + an.hc(time));
                    com.bytedance.msdk.d.u.b.d("TTMediationSDK_RitAdnShowControl", "checkLoad rit_level 规则有效时间 = " + an.hc(dVar.d()));
                    return new com.bytedance.msdk.api.hc.d(40064, com.bytedance.msdk.api.d.d(40064) + ", " + dVar.hc());
                }
            }
        }
        return null;
    }

    public boolean d(String str, String str2) {
        Map<String, List<hc>> map;
        List<hc> list;
        com.bytedance.msdk.d.u.b.d("TTMediationSDK_RitAdnShowControl", "hasRitAdnConfig rit_level adnName = " + str2 + " primeRit = " + str);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && (map = this.hc) != null && map.size() != 0 && (list = this.hc.get(str2)) != null && list.size() != 0) {
            Iterator<hc> it = list.iterator();
            while (it.hasNext()) {
                List<String> listB = it.next().b();
                if (listB != null && listB.contains(str)) {
                    return true;
                }
            }
        }
        return false;
    }
}
