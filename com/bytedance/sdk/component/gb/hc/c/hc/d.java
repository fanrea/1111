package com.bytedance.sdk.component.gb.hc.c.hc;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private int d;
    private int hc;

    public int d() {
        return this.d;
    }

    public int hc() {
        return this.hc;
    }

    d(int i, int i2, long j) {
        if (i2 < i) {
            throw new IllegalStateException("atMostBatchSendCount should meet a condition (atMostBatchSendCount >= maxCacheCount)");
        }
        this.d = i;
        this.hc = i2;
    }

    public static d d(int i, int i2) {
        return new d(i, i2, 172800000L);
    }

    public static d d(int i, int i2, long j) {
        return new d(i, i2, j);
    }

    public static d b() {
        return new d(1, 100, 172800000L);
    }
}
