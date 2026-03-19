package com.kwad.sdk.live.audience.net;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class KSLiveThreadFactory implements ThreadFactory {
    private static final String THREAD_NAME_PREFIX = "KSLiveThreadPool-thread-";
    private final AtomicInteger mThreadNumber = new AtomicInteger(1);
    private final ThreadGroup mThreadGroup = Thread.currentThread().getThreadGroup();

    KSLiveThreadFactory() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.mThreadGroup, runnable, THREAD_NAME_PREFIX + this.mThreadNumber.getAndIncrement());
        thread.setDaemon(false);
        return thread;
    }
}
