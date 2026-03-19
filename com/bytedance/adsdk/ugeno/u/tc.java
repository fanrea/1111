package com.bytedance.adsdk.ugeno.u;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class tc {
    private static Map<String, h> d = new HashMap();

    public static void d(List<h> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (h hVar : list) {
            if (hVar != null) {
                d.put(hVar.d(), hVar);
            }
        }
    }

    public static h d(String str) {
        return d.get(str);
    }
}
