package com.android.gdt.qone.v;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class d implements ThreadFactory {
    public final AtomicInteger a = new AtomicInteger(1);

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        try {
            return new Thread(runnable, "qm-thread-" + this.a.getAndIncrement());
        } catch (Exception e) {
            com.android.gdt.qone.af.c.a(e);
            return null;
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }
}
