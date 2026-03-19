package com.kuaishou.common.concurrent;

import android.os.Process;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class DefaultThreadFactory implements ThreadFactory {
    private static final AtomicInteger poolNumber = new AtomicInteger(1);
    private final ThreadGroup group;
    private final String namePrefix;
    private final AtomicInteger threadNumber = new AtomicInteger(1);

    public DefaultThreadFactory(String str) {
        SecurityManager securityManager = System.getSecurityManager();
        this.group = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.namePrefix = str + SignatureImpl.SEP + poolNumber.getAndIncrement() + SignatureImpl.SEP;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        if (runnable == null) {
            runnable = new Runnable() { // from class: com.kuaishou.common.concurrent.DefaultThreadFactory.1
                @Override // java.lang.Runnable
                public void run() {
                }
            };
        }
        RevisePriorityRunnable revisePriorityRunnable = new RevisePriorityRunnable(runnable, 10);
        Thread thread = new Thread(this.group, revisePriorityRunnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        return thread;
    }

    class RevisePriorityRunnable implements Runnable {
        final int priority;
        final Runnable r;

        RevisePriorityRunnable(Runnable runnable, int i) {
            this.r = runnable;
            this.priority = i;
        }

        @Override // java.lang.Runnable
        public void run() throws SecurityException, IllegalArgumentException {
            Process.setThreadPriority(this.priority);
            this.r.run();
        }
    }
}
