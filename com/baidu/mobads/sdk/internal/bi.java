package com.baidu.mobads.sdk.internal;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
class bi implements RejectedExecutionHandler {
    bi() {
    }

    @Override // java.util.concurrent.RejectedExecutionHandler
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        az.h("ThreadPoolFactory").e("Exceeded ThreadPoolExecutor pool size");
        synchronized (this) {
            if (bf.d == null) {
                LinkedBlockingQueue unused = bf.e = new LinkedBlockingQueue();
                ThreadPoolExecutor unused2 = bf.d = new ThreadPoolExecutor(2, 2, 60L, TimeUnit.SECONDS, bf.e, bf.f);
            }
        }
        bf.d.execute(runnable);
    }
}
