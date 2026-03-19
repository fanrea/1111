package com.qq.e.comm.plugin;

import android.app.Activity;
import android.view.Choreographer;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class md extends g0 implements Choreographer.FrameCallback {
    private static final String m = "md";
    private final AtomicInteger i;
    private final Choreographer j;
    private long k;
    private ScheduledExecutorService l;

    private void d() {
    }

    @Override // com.qq.e.comm.plugin.g0
    String b() {
        return m;
    }

    public md(Activity activity, long j) {
        super(activity, j);
        this.i = new AtomicInteger();
        this.j = Choreographer.getInstance();
    }

    @Override // com.qq.e.comm.plugin.g0, com.qq.e.comm.plugin.jk
    public void start() {
        super.start();
        d();
        this.j.postFrameCallback(this);
    }

    @Override // com.qq.e.comm.plugin.g0
    protected void c() {
        ScheduledExecutorService scheduledExecutorService = this.l;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
        this.i.set(0);
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.h.get()) {
            if (this.k == 0) {
                this.k = j;
            }
            a((int) ((j - this.k) / this.b));
            this.k = j;
            this.i.getAndIncrement();
            this.j.postFrameCallback(this);
        }
    }
}
