package com.sigmob.sdk.downloader.core.file;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class c {
    private static final String a = "FileLock";
    private static final long d = TimeUnit.MILLISECONDS.toNanos(100);
    private final Map<String, AtomicInteger> b;
    private final Map<String, Thread> c;

    c() {
        this(new HashMap(), new HashMap());
    }

    c(Map<String, AtomicInteger> fileLockCountMap, Map<String, Thread> waitThreadForFileLockMap) {
        this.b = fileLockCountMap;
        this.c = waitThreadForFileLockMap;
    }

    void a() {
        LockSupport.park(Long.valueOf(d));
    }

    public void a(String path) {
        AtomicInteger atomicInteger;
        synchronized (this.b) {
            atomicInteger = this.b.get(path);
        }
        if (atomicInteger == null) {
            atomicInteger = new AtomicInteger(0);
            synchronized (this.b) {
                this.b.put(path, atomicInteger);
            }
        }
        com.sigmob.sdk.downloader.core.c.b(a, "increaseLock increase lock-count to " + atomicInteger.incrementAndGet() + path);
    }

    void a(Thread lockedThread) {
        LockSupport.unpark(lockedThread);
    }

    boolean a(AtomicInteger lockCount) {
        return lockCount.get() <= 0;
    }

    public void b(String path) {
        AtomicInteger atomicInteger;
        Thread thread;
        synchronized (this.b) {
            atomicInteger = this.b.get(path);
        }
        if (atomicInteger == null || atomicInteger.decrementAndGet() != 0) {
            return;
        }
        com.sigmob.sdk.downloader.core.c.b(a, "decreaseLock decrease lock-count to 0 " + path);
        synchronized (this.c) {
            thread = this.c.get(path);
            if (thread != null) {
                this.c.remove(path);
            }
        }
        if (thread != null) {
            com.sigmob.sdk.downloader.core.c.b(a, "decreaseLock " + path + " unpark locked thread " + atomicInteger);
            a(thread);
        }
        synchronized (this.b) {
            this.b.remove(path);
        }
    }

    public void c(String filePath) {
        AtomicInteger atomicInteger;
        synchronized (this.b) {
            atomicInteger = this.b.get(filePath);
        }
        if (atomicInteger == null || atomicInteger.get() <= 0) {
            return;
        }
        synchronized (this.c) {
            this.c.put(filePath, Thread.currentThread());
        }
        com.sigmob.sdk.downloader.core.c.b(a, "waitForRelease start " + filePath);
        while (!a(atomicInteger)) {
            a();
        }
        com.sigmob.sdk.downloader.core.c.b(a, "waitForRelease finish " + filePath);
    }
}
