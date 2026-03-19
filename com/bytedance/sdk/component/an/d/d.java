package com.bytedance.sdk.component.an.d;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d implements ThreadFactory {
    private final ThreadGroup d;
    private final AtomicInteger hc = new AtomicInteger(1);

    public d(String str) {
        this.d = new ThreadGroup("tt_img_".concat(String.valueOf(str)));
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        com.bytedance.sdk.component.tc.c.b bVar = new com.bytedance.sdk.component.tc.c.b(this.d, runnable, "tt_img_" + this.hc.getAndIncrement());
        if (bVar.isDaemon()) {
            bVar.setDaemon(false);
        }
        return bVar;
    }
}
