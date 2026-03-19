package com.bytedance.sdk.component.b.hc.d.u;

import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class k {
    private int d;
    private final int[] hc = new int[10];

    void d() {
        this.d = 0;
        Arrays.fill(this.hc, 0);
    }

    k d(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.hc;
            if (i < iArr.length) {
                this.d = (1 << i) | this.d;
                iArr[i] = i2;
            }
        }
        return this;
    }

    boolean d(int i) {
        return ((1 << i) & this.d) != 0;
    }

    int hc(int i) {
        return this.hc[i];
    }

    int hc() {
        return Integer.bitCount(this.d);
    }

    int b() {
        if ((this.d & 2) != 0) {
            return this.hc[1];
        }
        return -1;
    }

    int b(int i) {
        return (this.d & 16) != 0 ? this.hc[4] : i;
    }

    int c(int i) {
        return (this.d & 32) != 0 ? this.hc[5] : i;
    }

    int c() {
        if ((this.d & 128) != 0) {
            return this.hc[7];
        }
        return 65535;
    }

    void d(k kVar) {
        for (int i = 0; i < 10; i++) {
            if (kVar.d(i)) {
                d(i, kVar.hc(i));
            }
        }
    }
}
