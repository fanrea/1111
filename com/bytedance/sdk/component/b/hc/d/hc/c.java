package com.bytedance.sdk.component.b.hc.d.hc;

import com.bytedance.sdk.component.b.hc.us;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class c {
    private final Set<us> d = new LinkedHashSet();

    public synchronized void d(us usVar) {
        this.d.add(usVar);
    }

    public synchronized void hc(us usVar) {
        this.d.remove(usVar);
    }

    public synchronized boolean b(us usVar) {
        return this.d.contains(usVar);
    }
}
