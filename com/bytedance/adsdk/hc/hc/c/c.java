package com.bytedance.adsdk.hc.hc.c;

import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public enum c implements u {
    LEFT_PAREN("("),
    RIGHT_PAREN(")"),
    LEFT_BRACKET("["),
    RIGHT_BRACKET("]"),
    COMMA(",");

    private static final Map<String, c> an;
    private final String h;

    static {
        HashMap map = new HashMap(128);
        an = map;
        for (c cVar : map.values()) {
            an.put(cVar.d(), cVar);
        }
    }

    c(String str) {
        this.h = str;
    }

    public static boolean d(u uVar) {
        return uVar instanceof c;
    }

    public String d() {
        return this.h;
    }
}
