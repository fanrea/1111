package com.bytedance.bdtracker;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class a5 {
    public static final z4 a = new z4();
    public static final Map<String, String> b = new ConcurrentHashMap();

    public static String a(String str) {
        Map<String, String> map = b;
        String str2 = map.get(str);
        if (str2 != null) {
            return str2;
        }
        String strA = a.a(str);
        if (strA != null) {
            map.put(str, strA);
        }
        return strA;
    }
}
