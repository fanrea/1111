package com.bytedance.sdk.component.gb.hc.u;

import java.util.UUID;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class hc implements Comparable<hc>, Runnable {
    private String b;
    private int d = 5;
    private String hc = UUID.randomUUID().toString() + "-" + String.valueOf(System.nanoTime());

    public hc(String str) {
        this.b = str;
    }

    public void d(int i) {
        this.d = i;
    }

    public int d() {
        return this.d;
    }

    @Override // java.lang.Comparable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(hc hcVar) {
        if (d() < hcVar.d()) {
            return 1;
        }
        return d() >= hcVar.d() ? -1 : 0;
    }
}
