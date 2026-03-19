package com.kwad.sdk.core.network;

import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.bh;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class a<R extends f> {
    private static final ExecutorService sExecutors = GlobalThreadPools.ach();
    private Future<?> mTask;

    protected abstract R createRequest();

    protected abstract void fetchImpl();

    protected abstract void onResponse(R r, c cVar);

    protected ExecutorService getExecutor() {
        return sExecutors;
    }

    protected void fetch() {
        this.mTask = getExecutor().submit(new bh() { // from class: com.kwad.sdk.core.network.a.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                a.this.fetchImpl();
            }
        });
    }

    protected void cancel() {
        Future<?> future = this.mTask;
        if (future != null) {
            future.cancel(true);
        }
    }
}
