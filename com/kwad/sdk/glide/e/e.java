package com.kwad.sdk.glide.e;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class e {
    private static final Executor caj = new Executor() { // from class: com.kwad.sdk.glide.e.e.1
        private final Handler handler = new Handler(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.handler.post(runnable);
        }
    };
    private static final Executor cak = new Executor() { // from class: com.kwad.sdk.glide.e.e.2
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            runnable.run();
        }
    };

    public static Executor ajy() {
        return caj;
    }

    public static Executor ajz() {
        return cak;
    }
}
