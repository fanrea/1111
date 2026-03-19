package com.bytedance.adsdk.ugeno.u;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c {
    private static Map<String, hc> d = new HashMap();

    public static void d(List<hc> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (hc hcVar : list) {
            if (hcVar != null) {
                d.put(hcVar.d(), hcVar);
            }
        }
    }

    public static hc d(String str) {
        return d.get(str);
    }
}
