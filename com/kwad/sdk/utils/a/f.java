package com.kwad.sdk.utils.a;

import java.util.concurrent.Executor;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class f implements Executor {
    private Runnable cpj;
    private Runnable mActive;

    @Override // java.util.concurrent.Executor
    public final synchronized void execute(Runnable runnable) {
        if (this.mActive == null) {
            this.mActive = e(runnable);
            d.getExecutor().execute(this.mActive);
        } else {
            if (this.cpj == null) {
                this.cpj = e(runnable);
            }
        }
    }

    private Runnable e(final Runnable runnable) {
        return new Runnable() { // from class: com.kwad.sdk.utils.a.f.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    runnable.run();
                } finally {
                    f.this.scheduleNext();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void scheduleNext() {
        Runnable runnable = this.cpj;
        this.mActive = runnable;
        this.cpj = null;
        if (runnable != null) {
            d.getExecutor().execute(this.mActive);
        }
    }
}
