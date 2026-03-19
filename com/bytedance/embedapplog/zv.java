package com.bytedance.embedapplog;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class zv {
    private static final fy d = new fy();
    private static final Map<String, String> hc = new ConcurrentHashMap();

    public static String d(String str) {
        Map<String, String> map = hc;
        String str2 = map.get(str);
        if (str2 != null) {
            return str2;
        }
        String strD = d.d(str);
        if (strD != null) {
            map.put(str, strD);
        }
        return strD;
    }
}
