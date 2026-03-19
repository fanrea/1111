package com.bytedance.d.b.d.hc;

import com.bytedance.d.b.d.hc.hc;
import java.util.UUID;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class b implements hc, Comparable<b>, Runnable {
    private hc.d d = hc.d.NORMAL;
    private String hc = UUID.randomUUID().toString() + "-" + String.valueOf(System.nanoTime());

    public hc.d d() {
        return this.d;
    }

    @Override // java.lang.Comparable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(b bVar) {
        if (d().d() < bVar.d().d()) {
            return 1;
        }
        return d().d() > bVar.d().d() ? -1 : 0;
    }
}
