package com.android.gdt.qone.c;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class c implements ThreadFactory {
    public static final AtomicInteger a = new AtomicInteger(0);

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        try {
            return new Thread(runnable, "oaid_thread_" + a.getAndIncrement());
        } catch (Exception e) {
            com.android.gdt.qone.af.b.a(e.toString());
            return null;
        } catch (OutOfMemoryError unused) {
            com.android.gdt.qone.af.b.a("[task] memory not enough, create thread failed.");
            return null;
        }
    }
}
