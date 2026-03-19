package com.yxcorp.livestream.longconnection.operation;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class WaitOption implements Runnable {
    private final long mWaitDuration;

    public WaitOption(long j) {
        this.mWaitDuration = j;
    }

    @Override // java.lang.Runnable
    public void run() throws InterruptedException {
        try {
            Thread.sleep(this.mWaitDuration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
