package com.bytedance.msdk.gb;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class jh {
    private static Map<Integer, Integer> d = new ConcurrentHashMap();

    public static Integer d(int i) {
        Integer num = d.get(Integer.valueOf(i));
        if (num != null) {
            return num;
        }
        Integer numValueOf = Integer.valueOf(i);
        d.put(Integer.valueOf(i), numValueOf);
        return numValueOf;
    }
}
