package com.bytedance.sdk.component.h.d;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    public Map<String, Object> d(Map<String, Object> map, com.bytedance.sdk.component.c.d.d dVar, boolean z) {
        if (dVar == null) {
            return map;
        }
        Map<String, Object> concurrentHashMap = z ? new ConcurrentHashMap<>() : map;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (z) {
                key = (String) dVar.hc(key);
            }
            concurrentHashMap.put(key, dVar.hc(value.toString()));
        }
        return concurrentHashMap;
    }

    public Map<String, Object> hc(Map<String, Object> map, com.bytedance.sdk.component.c.d.d dVar, boolean z) {
        if (dVar == null) {
            return map;
        }
        Map<String, Object> concurrentHashMap = z ? new ConcurrentHashMap<>() : map;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (z) {
                key = dVar.d(key);
            }
            concurrentHashMap.put(key, dVar.d(value.toString()));
        }
        return concurrentHashMap;
    }
}
