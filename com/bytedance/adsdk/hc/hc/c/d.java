package com.bytedance.adsdk.hc.hc.c;

import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public enum d implements u {
    TRUE,
    FALSE,
    NULL;

    private static final Map<String, d> c = new HashMap(128);

    static {
        for (d dVar : values()) {
            c.put(dVar.name().toLowerCase(), dVar);
        }
    }

    public static d d(String str) {
        return c.get(str.toLowerCase());
    }
}
