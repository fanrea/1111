package com.kwad.components.ct.horizontal.news;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class d {
    private static volatile d aNB;
    private final Map<Long, Integer> aNC = new HashMap();
    private final Set<Long> aND = new HashSet();

    private d() {
    }

    public static d HU() {
        if (aNB == null) {
            synchronized (d.class) {
                if (aNB == null) {
                    aNB = new d();
                }
            }
        }
        return aNB;
    }

    public final void d(long j, int i) {
        this.aNC.put(Long.valueOf(j), Integer.valueOf(i));
    }

    public final int ai(long j) {
        Integer num = this.aNC.get(Long.valueOf(j));
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public final void aj(long j) {
        this.aND.add(Long.valueOf(j));
    }

    public final boolean ak(long j) {
        return this.aND.contains(Long.valueOf(j));
    }
}
