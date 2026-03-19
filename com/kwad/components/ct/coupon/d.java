package com.kwad.components.ct.coupon;

import java.util.HashSet;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d {
    private static Set<String> amW = new HashSet();

    public static void bv(String str) {
        amW.add(str);
    }

    public static boolean contains(String str) {
        return amW.contains(str);
    }
}
