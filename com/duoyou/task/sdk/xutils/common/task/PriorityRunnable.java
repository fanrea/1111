package com.duoyou.task.sdk.xutils.common.task;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class PriorityRunnable implements Runnable {
    public long SEQ;
    public final Priority priority;
    private final Runnable runnable;

    public PriorityRunnable(Priority priority, Runnable runnable) {
        this.priority = priority == null ? Priority.DEFAULT : priority;
        this.runnable = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.runnable.run();
    }
}
