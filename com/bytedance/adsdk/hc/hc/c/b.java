package com.bytedance.adsdk.hc.hc.c;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public enum b implements u {
    QUESTION("?", 0),
    COLON(":", 0),
    DOUBLE_AMP("&&", 1),
    DOUBLE_BAR("||", 1),
    EQ("==", 2),
    GT(">", 2),
    LT("<", 2),
    LT_EQ("<=", 2),
    GT_EQ(">=", 2),
    NOT_EQ("!=", 2),
    PLUS("+", 3),
    MINUS("-", 3),
    MULTI("*", 4),
    DIVISION("/", 4),
    MOD("%", 4);

    private final int rf;
    private final String yo;
    private static final Map<String, b> cb = new HashMap(128);
    private static final Set<b> w = new HashSet();

    static {
        for (b bVar : values()) {
            cb.put(bVar.d(), bVar);
            w.add(bVar);
        }
    }

    b(String str, int i) {
        this.yo = str;
        this.rf = i;
    }

    public static b d(String str) {
        return cb.get(str);
    }

    public static boolean d(u uVar) {
        return uVar instanceof b;
    }

    public String d() {
        return this.yo;
    }

    public int hc() {
        return this.rf;
    }
}
