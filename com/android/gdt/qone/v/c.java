package com.android.gdt.qone.v;

import android.util.SparseArray;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class c extends a {
    public static final int c = Math.max(2, Runtime.getRuntime().availableProcessors());
    public final ScheduledExecutorService b = Executors.newScheduledThreadPool(c, new d());

    static {
        new AtomicInteger(0);
    }

    public c() {
        new SparseArray();
        new SparseArray();
    }

    @Override // com.android.gdt.qone.v.a
    public final synchronized void a(long j, Runnable runnable) {
        b bVar = new b(runnable);
        if (j <= 0) {
            j = 0;
        }
        this.b.schedule(bVar, j, TimeUnit.MILLISECONDS);
    }

    @Override // com.android.gdt.qone.v.a
    public final synchronized void a(Runnable runnable) {
        try {
            this.b.execute(new b(runnable));
        } catch (Throwable unused) {
        }
    }
}
