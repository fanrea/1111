package com.bytedance.msdk.core.c;

import android.text.TextUtils;
import com.bytedance.msdk.core.tc.tc;
import com.kwad.sdk.api.model.AdnName;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    public static Map<String, C0235d> d = new ConcurrentHashMap();

    public static void d(com.bytedance.msdk.api.d.hc hcVar, tc tcVar, Map<String, Object> map) {
        C0235d c0235d;
        if (hcVar == null || tcVar == null || map == null || !tcVar.us() || !AdnName.BAIDU.equals(tcVar.e()) || (c0235d = d.get(hcVar.v())) == null) {
            return;
        }
        map.put("bidding_win_adn", c0235d.d);
        map.put("bidding_win_price", Double.valueOf(c0235d.b));
        Boolean boolValueOf = Boolean.valueOf(com.bytedance.msdk.core.hc.hc().rw());
        map.put("bidding_is_open_ecpm", boolValueOf);
        if (boolValueOf.booleanValue()) {
            map.put("bidding_request_id_map", c0235d.c);
            map.put("bidding_win_adn_id", c0235d.hc);
        }
    }

    public static void d(com.bytedance.msdk.api.d.hc hcVar, com.bytedance.msdk.core.tc.hc hcVar2, List<com.bytedance.msdk.hc.b> list, List<com.bytedance.msdk.hc.b> list2) {
        HashMap map;
        com.bytedance.msdk.hc.b next;
        if (hcVar == null || hcVar2 == null || list == null || list.size() == 0 || !hcVar.r() || !d(hcVar2)) {
            return;
        }
        Iterator<com.bytedance.msdk.hc.b> it = list.iterator();
        while (true) {
            map = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next != null && AdnName.BAIDU.equals(next.nw())) {
                break;
            }
        }
        if (next == null) {
            next = list.get(0);
        }
        if (next != null) {
            if (com.bytedance.msdk.core.hc.hc().rw() && (list2 != null || list2.size() != 0)) {
                map = new HashMap();
                for (com.bytedance.msdk.hc.b bVar : list2) {
                    map.put(bVar.ph(), bVar.ai());
                }
            }
            d.put(hcVar2.fs(), new C0235d(next.ph(), next.nw(), next.kb(), map));
        }
    }

    private static boolean d(com.bytedance.msdk.core.tc.hc hcVar) {
        if (hcVar == null) {
            return false;
        }
        for (tc tcVar : hcVar.y()) {
            if (TextUtils.equals(tcVar.e(), AdnName.BAIDU) && tcVar.us()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: com.bytedance.msdk.core.c.d$d, reason: collision with other inner class name */
    static class C0235d {
        double b;
        Map<String, String> c;
        String d;
        String hc;

        public C0235d(String str, String str2, double d, Map<String, String> map) {
            this.d = str2;
            this.b = d;
            this.c = map;
            this.hc = str;
        }
    }
}
