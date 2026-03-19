package com.kwad.sdk.core.videocache;

import com.kwad.sdk.utils.ax;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
class k {
    private final m bJC;
    private final com.kwad.sdk.core.videocache.a bJD;
    private volatile Thread bJH;
    private volatile boolean oX;
    private final Object bJE = new Object();
    private final Object bJF = new Object();
    private volatile int bJI = -1;
    private final AtomicInteger bJG = new AtomicInteger();

    protected void fC(int i) {
    }

    public k(m mVar, com.kwad.sdk.core.videocache.a aVar) {
        this.bJC = (m) ax.checkNotNull(mVar);
        this.bJD = (com.kwad.sdk.core.videocache.a) ax.checkNotNull(aVar);
    }

    public final int a(byte[] bArr, long j, int i) throws ProxyCacheException {
        l.b(bArr, j, 1024);
        while (!this.bJD.isCompleted() && this.bJD.acU() < 1024 + j && !this.oX) {
            adh();
            adi();
            adg();
        }
        int iA = this.bJD.a(bArr, j, 1024);
        if (this.bJD.isCompleted() && this.bJI != 100) {
            this.bJI = 100;
            fC(100);
        }
        return iA;
    }

    private void adg() throws ProxyCacheException {
        int i = this.bJG.get();
        if (i <= 0) {
            return;
        }
        this.bJG.set(0);
        throw new ProxyCacheException("Error reading source " + i + " times");
    }

    public final void shutdown() {
        synchronized (this.bJF) {
            com.kwad.sdk.core.d.c.d("ProxyCache", "Shutdown proxy for " + this.bJC);
            try {
                this.oX = true;
                if (this.bJH != null) {
                    this.bJH.interrupt();
                }
                this.bJD.close();
            } catch (ProxyCacheException e) {
                onError(e);
            }
        }
    }

    private synchronized void adh() {
        byte b = 0;
        boolean z = (this.bJH == null || this.bJH.getState() == Thread.State.TERMINATED) ? false : true;
        if (!this.oX && !this.bJD.isCompleted() && !z) {
            this.bJH = new Thread(new a(this, b), "Source reader for " + this.bJC);
            this.bJH.start();
        }
    }

    private void adi() {
        synchronized (this.bJE) {
            try {
                try {
                    this.bJE.wait(1000L);
                } catch (InterruptedException e) {
                    throw new ProxyCacheException("Waiting source data is interrupted!", e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void s(long j, long j2) {
        t(j, j2);
        synchronized (this.bJE) {
            this.bJE.notifyAll();
        }
    }

    private void t(long j, long j2) {
        int i = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1)) == 0 ? 100 : (int) ((j / j2) * 100.0f);
        boolean z = i != this.bJI;
        if ((j2 >= 0) && z) {
            fC(i);
        }
        this.bJI = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0039, code lost:
    
        r2 = r2 + r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void adj() {
        /*
            r8 = this;
            r0 = -1
            r2 = 0
            com.kwad.sdk.core.videocache.a r4 = r8.bJD     // Catch: java.lang.Throwable -> L49
            long r2 = r4.acU()     // Catch: java.lang.Throwable -> L49
            com.kwad.sdk.core.videocache.m r4 = r8.bJC     // Catch: java.lang.Throwable -> L49
            r4.bj(r2)     // Catch: java.lang.Throwable -> L49
            com.kwad.sdk.core.videocache.m r4 = r8.bJC     // Catch: java.lang.Throwable -> L49
            long r0 = r4.length()     // Catch: java.lang.Throwable -> L49
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L49
        L19:
            com.kwad.sdk.core.videocache.m r5 = r8.bJC     // Catch: java.lang.Throwable -> L49
            int r5 = r5.read(r4)     // Catch: java.lang.Throwable -> L49
            r6 = -1
            if (r5 == r6) goto L42
            java.lang.Object r6 = r8.bJF     // Catch: java.lang.Throwable -> L49
            monitor-enter(r6)     // Catch: java.lang.Throwable -> L49
            boolean r7 = r8.isStopped()     // Catch: java.lang.Throwable -> L3f
            if (r7 == 0) goto L33
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L3f
        L2c:
            r8.adl()
            r8.s(r2, r0)
            return
        L33:
            com.kwad.sdk.core.videocache.a r7 = r8.bJD     // Catch: java.lang.Throwable -> L3f
            r7.d(r4, r5)     // Catch: java.lang.Throwable -> L3f
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L3f
            long r5 = (long) r5
            long r2 = r2 + r5
            r8.s(r2, r0)     // Catch: java.lang.Throwable -> L49
            goto L19
        L3f:
            r4 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L3f
            throw r4     // Catch: java.lang.Throwable -> L49
        L42:
            r8.tryComplete()     // Catch: java.lang.Throwable -> L49
            r8.adk()     // Catch: java.lang.Throwable -> L49
            goto L2c
        L49:
            r4 = move-exception
            java.util.concurrent.atomic.AtomicInteger r5 = r8.bJG     // Catch: java.lang.Throwable -> L53
            r5.incrementAndGet()     // Catch: java.lang.Throwable -> L53
            onError(r4)     // Catch: java.lang.Throwable -> L53
            goto L2c
        L53:
            r4 = move-exception
            r8.adl()
            r8.s(r2, r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.videocache.k.adj():void");
    }

    private void adk() {
        this.bJI = 100;
        fC(this.bJI);
    }

    private void tryComplete() {
        synchronized (this.bJF) {
            if (!isStopped() && this.bJD.acU() == this.bJC.length()) {
                this.bJD.complete();
            }
        }
    }

    private boolean isStopped() {
        return Thread.currentThread().isInterrupted() || this.oX;
    }

    private void adl() {
        try {
            this.bJC.close();
        } catch (ProxyCacheException e) {
            onError(new ProxyCacheException("Error closing source " + this.bJC, e));
        }
    }

    private static void onError(Throwable th) {
        if (th instanceof InterruptedProxyCacheException) {
            com.kwad.sdk.core.d.c.d("ProxyCache", "ProxyCache is interrupted");
        } else {
            com.kwad.sdk.core.d.c.e("ProxyCache", "ProxyCache error");
        }
    }

    class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(k kVar, byte b) {
            this();
        }

        @Override // java.lang.Runnable
        public final void run() {
            k.this.adj();
        }
    }
}
