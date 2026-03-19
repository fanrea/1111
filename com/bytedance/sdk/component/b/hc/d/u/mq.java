package com.bytedance.sdk.component.b.hc.d.u;

import java.util.concurrent.CountDownLatch;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
final class mq {
    private final CountDownLatch d = new CountDownLatch(1);
    private long hc = -1;
    private long b = -1;

    mq() {
    }

    void d() {
        if (this.hc != -1) {
            throw new IllegalStateException();
        }
        this.hc = System.nanoTime();
    }

    void hc() {
        if (this.b != -1 || this.hc == -1) {
            throw new IllegalStateException();
        }
        this.b = System.nanoTime();
        this.d.countDown();
    }

    void b() {
        if (this.b == -1) {
            long j = this.hc;
            if (j != -1) {
                this.b = j - 1;
                this.d.countDown();
                return;
            }
        }
        throw new IllegalStateException();
    }
}
