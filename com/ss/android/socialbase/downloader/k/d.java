package com.ss.android.socialbase.downloader.k;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d implements ThreadFactory {
    private final boolean b;
    private final String d;
    private final AtomicInteger hc;

    public d(String str) {
        this(str, false);
    }

    public d(String str, boolean z) {
        this.hc = new AtomicInteger();
        this.d = str;
        this.b = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        com.bytedance.sdk.component.tc.c.b bVar = new com.bytedance.sdk.component.tc.c.b(runnable, this.d + "-" + this.hc.incrementAndGet());
        if (!this.b) {
            if (bVar.isDaemon()) {
                bVar.setDaemon(false);
            }
            if (bVar.getPriority() != 5) {
                bVar.setPriority(5);
            }
        }
        return bVar;
    }
}
