package com.component.lottie.e;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a extends ab {
    static a a = null;
    private static final int b = 65536;
    private static final long d = TimeUnit.SECONDS.toMillis(60);
    private static final long e = TimeUnit.MILLISECONDS.toNanos(d);
    private boolean f;
    private a g;
    private long h;

    public final void a() {
        if (this.f) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long jE = e();
        boolean zF = f();
        if (jE == 0 && !zF) {
            return;
        }
        this.f = true;
        a(this, jE, zF);
    }

    private static synchronized void a(a aVar, long j, boolean z) {
        if (a == null) {
            a = new a();
            new C0323a().start();
        }
        long jNanoTime = System.nanoTime();
        if (j != 0 && z) {
            aVar.h = Math.min(j, aVar.g() - jNanoTime) + jNanoTime;
        } else if (j != 0) {
            aVar.h = j + jNanoTime;
        } else if (z) {
            aVar.h = aVar.g();
        } else {
            throw new AssertionError();
        }
        long jB = aVar.b(jNanoTime);
        a aVar2 = a;
        while (aVar2.g != null && jB >= aVar2.g.b(jNanoTime)) {
            aVar2 = aVar2.g;
        }
        aVar.g = aVar2.g;
        aVar2.g = aVar;
        if (aVar2 == a) {
            a.class.notifyAll();
        }
    }

    private static synchronized boolean a(a aVar) {
        for (a aVar2 = a; aVar2 != null; aVar2 = aVar2.g) {
            if (aVar2.g == aVar) {
                aVar2.g = aVar.g;
                aVar.g = null;
                return false;
            }
        }
        return true;
    }

    private long b(long j) {
        return this.h - j;
    }

    protected void b() {
    }

    public final z a(z zVar) {
        return new b(this, zVar);
    }

    public final aa a(aa aaVar) {
        return new c(this, aaVar);
    }

    public final boolean c() {
        if (!this.f) {
            return false;
        }
        this.f = false;
        return a(this);
    }

    final void a(boolean z) {
        if (c() && z) {
            throw b((IOException) null);
        }
    }

    final IOException a(IOException iOException) {
        if (!c()) {
            return iOException;
        }
        return b(iOException);
    }

    protected IOException b(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* renamed from: com.component.lottie.e.a$a, reason: collision with other inner class name */
    private static final class C0323a extends Thread {
        C0323a() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0016, code lost:
        
            r1.b();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r3 = this;
            L1:
                java.lang.Class<com.component.lottie.e.a> r0 = com.component.lottie.e.a.class
                monitor-enter(r0)     // Catch: java.lang.InterruptedException -> L1d
                com.component.lottie.e.a r1 = com.component.lottie.e.a.d()     // Catch: java.lang.Throwable -> L1a
                if (r1 != 0) goto Lc
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L1a
                goto L1
            Lc:
                com.component.lottie.e.a r2 = com.component.lottie.e.a.a     // Catch: java.lang.Throwable -> L1a
                if (r1 != r2) goto L15
                r1 = 0
                com.component.lottie.e.a.a = r1     // Catch: java.lang.Throwable -> L1a
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L1a
                return
            L15:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L1a
                r1.b()     // Catch: java.lang.InterruptedException -> L1d
                goto L1e
            L1a:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L1a
                throw r1     // Catch: java.lang.InterruptedException -> L1d
            L1d:
                r0 = move-exception
            L1e:
                goto L1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.component.lottie.e.a.C0323a.run():void");
        }
    }

    static a d() throws InterruptedException {
        a aVar = a.g;
        if (aVar == null) {
            long jNanoTime = System.nanoTime();
            a.class.wait(d);
            if (a.g != null || System.nanoTime() - jNanoTime < e) {
                return null;
            }
            return a;
        }
        long jB = aVar.b(System.nanoTime());
        if (jB > 0) {
            long j = jB / 1000000;
            a.class.wait(j, (int) (jB - (1000000 * j)));
            return null;
        }
        a.g = aVar.g;
        aVar.g = null;
        return aVar;
    }
}
