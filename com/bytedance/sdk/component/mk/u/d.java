package com.bytedance.sdk.component.mk.u;

import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private static volatile d d;
    private static Map<String, Map<String, Object>> hc = new HashMap();

    private d() {
    }

    public static d d() {
        if (d != null) {
            return d;
        }
        synchronized (d.class) {
            if (d != null) {
                return d;
            }
            d dVar = new d();
            d = dVar;
            return dVar;
        }
    }

    public Map<String, Object> d(String str) {
        Map<String, Object> map = hc.get(str);
        if (map != null) {
            return map;
        }
        HashMap map2 = new HashMap();
        hc.put(str, map2);
        return map2;
    }
}
