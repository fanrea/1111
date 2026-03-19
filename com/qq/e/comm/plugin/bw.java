package com.qq.e.comm.plugin;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class bw {
    private static String a = "req_cost_ratio";
    private static float b = 1.0f;

    private static Map<String, String> a(aw awVar) {
        Map<String, String> mapP = awVar.p();
        if (mapP != null) {
            return mapP;
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        awVar.a(concurrentHashMap);
        return concurrentHashMap;
    }

    public static float b(aw awVar) {
        Map<String, String> mapP = awVar.p();
        if (mapP == null) {
            return b;
        }
        return m10.a(mapP.get(a), b);
    }

    public static void a(aw awVar, float f) {
        a(awVar).put(a, String.valueOf(f));
    }
}
