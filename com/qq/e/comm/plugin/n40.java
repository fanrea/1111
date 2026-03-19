package com.qq.e.comm.plugin;

import android.util.Pair;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class n40 {
    private volatile int a;
    private volatile int b;

    n40() {
    }

    Pair<Integer, Integer> a(int i, int i2, int i3, int i4) {
        if (this.a != 0 && this.b != 0) {
            if (i == 1073741824 && i2 == 1073741824) {
                if (this.a * i4 < this.b * i3) {
                    i3 = (this.a * i4) / this.b;
                } else if (this.a * i4 > this.b * i3) {
                    i4 = (this.b * i3) / this.a;
                }
            } else if (i == 1073741824) {
                int i5 = (this.b * i3) / this.a;
                if (i2 != Integer.MIN_VALUE || i5 <= i4) {
                    i4 = i5;
                }
            } else if (i2 == 1073741824) {
                int i6 = (this.a * i4) / this.b;
                if (i != Integer.MIN_VALUE || i6 <= i3) {
                    i3 = i6;
                }
            } else {
                int i7 = this.a;
                int i8 = this.b;
                if (i2 != Integer.MIN_VALUE || i8 <= i4) {
                    i4 = i8;
                } else {
                    i7 = (this.a * i4) / this.b;
                }
                if (i != Integer.MIN_VALUE || i7 <= i3) {
                    i3 = i7;
                } else {
                    i4 = (this.b * i3) / this.a;
                }
            }
            return new Pair<>(Integer.valueOf(i3), Integer.valueOf(i4));
        }
        return new Pair<>(0, 0);
    }

    void a(int i, int i2) {
        this.a = i;
        this.b = i2;
    }
}
