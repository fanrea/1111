package com.qq.e.comm.plugin;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ho {
    private final AtomicInteger a = new AtomicInteger();
    private final int b;

    public ho(String str) {
        this.b = xc.a("rewardVideoLoadRetryTimes", str, 2);
        b();
    }

    public void b() {
        this.a.set(this.b - 1);
    }

    public boolean a() {
        return this.a.decrementAndGet() >= 0;
    }
}
