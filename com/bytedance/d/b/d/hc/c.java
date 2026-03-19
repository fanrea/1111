package com.bytedance.d.b.d.hc;

import android.text.TextUtils;
import com.bytedance.d.b.d.hc.hc;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c implements ThreadFactory {
    private static final AtomicInteger d = new AtomicInteger(1);
    private final AtomicInteger b = new AtomicInteger(1);
    private final String c;
    private final ThreadGroup hc;
    private final hc.d u;

    c(hc.d dVar, String str) {
        ThreadGroup threadGroup;
        this.u = dVar;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            threadGroup = securityManager.getThreadGroup();
        } else {
            threadGroup = Thread.currentThread().getThreadGroup();
        }
        this.hc = threadGroup;
        if (TextUtils.isEmpty(str)) {
            this.c = "ttdefault-" + d.getAndIncrement() + "-thread-";
        } else {
            this.c = str + d.getAndIncrement() + "-thread-";
        }
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        com.bytedance.sdk.component.tc.c.b bVar = new com.bytedance.sdk.component.tc.c.b(this.hc, runnable, this.c + this.b.getAndIncrement(), 0L);
        if (bVar.isDaemon()) {
            bVar.setDaemon(false);
        }
        hc.d dVar = this.u;
        if (dVar != null && dVar.d() == hc.d.LOW.d()) {
            bVar.setPriority(1);
        } else if (bVar.getPriority() != 5) {
            bVar.setPriority(3);
        } else {
            bVar.setPriority(5);
        }
        return bVar;
    }
}
