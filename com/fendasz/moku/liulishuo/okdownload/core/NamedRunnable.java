package com.fendasz.moku.liulishuo.okdownload.core;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class NamedRunnable implements Runnable {
    protected final String name;

    protected abstract void execute() throws InterruptedException;

    protected abstract void finished();

    protected abstract void interrupted(InterruptedException interruptedException);

    public NamedRunnable(String str) {
        this.name = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.name);
        try {
            try {
                execute();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                interrupted(e);
            }
        } finally {
            Thread.currentThread().setName(name);
            finished();
        }
    }
}
