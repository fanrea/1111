package com.android.gdt.qone.c;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class e {
    public static final int b = Math.max(2, Runtime.getRuntime().availableProcessors());
    public static final e c = new e();
    public final ExecutorService a = Executors.newFixedThreadPool(b, new c());

    public final void a(Runnable runnable) {
        d dVar = new d(runnable);
        ExecutorService executorService = this.a;
        if (executorService != null) {
            try {
                executorService.execute(dVar);
            } catch (Throwable unused) {
            }
        }
    }
}
