package com.bytedance.d.hc.u;

import aegon.chrome.net.impl.JavaUrlRequest$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an {
    private static final AtomicReference<Long> d = new AtomicReference<>(0L);

    public static void d(long j) {
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i >= 5) {
                return;
            }
            AtomicReference<Long> atomicReference = d;
            long jLongValue = atomicReference.get().longValue();
            if (JavaUrlRequest$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, Long.valueOf(jLongValue), Long.valueOf(jLongValue | j))) {
                return;
            } else {
                i = i2;
            }
        }
    }
}
