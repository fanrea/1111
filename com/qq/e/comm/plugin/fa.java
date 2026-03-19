package com.qq.e.comm.plugin;

import com.qq.e.comm.plugin.ut;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class fa implements ut {
    fa() {
    }

    @Override // com.qq.e.comm.plugin.ut
    public ut.a[] a(long j, int i) {
        long j2 = j / i;
        ut.a[] aVarArr = new ut.a[i];
        int i2 = 0;
        while (true) {
            int i3 = i - 1;
            if (i2 < i3) {
                aVarArr[i2] = new ut.a(i2 * j2, j2);
                i2++;
            } else {
                long j3 = i3 * j2;
                aVarArr[i3] = new ut.a(j3, j - j3);
                return aVarArr;
            }
        }
    }
}
