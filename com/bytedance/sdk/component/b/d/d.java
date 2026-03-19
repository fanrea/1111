package com.bytedance.sdk.component.b.d;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d extends jh {
    private static final long c;
    static d d;
    private static final long hc;
    private d an;
    private long h;
    private boolean u;

    protected void m_() {
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        hc = millis;
        c = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public final void d() {
        if (this.u) {
            return;
        }
        long jN_ = n_();
        boolean zB = b();
        if (jN_ != 0 || zB) {
            this.u = true;
            d(this, jN_, zB);
        }
    }

    private static synchronized void d(d dVar, long j, boolean z) {
        if (d == null) {
            d = new d();
            C0272d c0272d = new C0272d();
            c0272d.setName("csj_watch_dog");
            try {
                c0272d.start();
            } catch (Throwable unused) {
            }
        }
        long jNanoTime = System.nanoTime();
        if (j != 0 && z) {
            dVar.h = Math.min(j, dVar.o_() - jNanoTime) + jNanoTime;
        } else if (j != 0) {
            dVar.h = j + jNanoTime;
        } else if (z) {
            dVar.h = dVar.o_();
        } else {
            throw new AssertionError();
        }
        long jHc = dVar.hc(jNanoTime);
        d dVar2 = d;
        while (true) {
            d dVar3 = dVar2.an;
            if (dVar3 == null || jHc < dVar3.hc(jNanoTime)) {
                break;
            } else {
                dVar2 = dVar2.an;
            }
        }
        dVar.an = dVar2.an;
        dVar2.an = dVar;
        if (dVar2 == d) {
            d.class.notify();
        }
    }

    public final boolean hc() {
        if (!this.u) {
            return false;
        }
        this.u = false;
        return d(this);
    }

    private static synchronized boolean d(d dVar) {
        d dVar2 = d;
        while (dVar2 != null) {
            d dVar3 = dVar2.an;
            if (dVar3 == dVar) {
                dVar2.an = dVar.an;
                dVar.an = null;
                return false;
            }
            dVar2 = dVar3;
        }
        return true;
    }

    private long hc(long j) {
        return this.h - j;
    }

    public final yo d(final yo yoVar) {
        return new yo() { // from class: com.bytedance.sdk.component.b.d.d.1
            @Override // com.bytedance.sdk.component.b.d.yo
            public void a_(b bVar, long j) throws IOException {
                try {
                    sy.d(bVar.hc, 0L, j);
                    while (true) {
                        long j2 = 0;
                        if (j <= 0) {
                            return;
                        }
                        e eVar = bVar.d;
                        while (true) {
                            if (j2 >= 65536) {
                                break;
                            }
                            j2 += eVar.b - eVar.hc;
                            if (j2 >= j) {
                                j2 = j;
                                break;
                            }
                            eVar = eVar.an;
                        }
                        d.this.d();
                        try {
                            try {
                                yoVar.a_(bVar, j2);
                                j -= j2;
                                d.this.d(true);
                            } catch (IOException e) {
                                throw d.this.d(e);
                            }
                        } catch (Throwable th) {
                            d.this.d(false);
                            throw th;
                        }
                    }
                } catch (Exception e2) {
                    throw new IOException(e2);
                }
            }

            @Override // com.bytedance.sdk.component.b.d.yo, java.io.Flushable
            public void flush() throws IOException {
                d.this.d();
                try {
                    try {
                        yoVar.flush();
                        d.this.d(true);
                    } catch (IOException e) {
                        throw d.this.d(e);
                    }
                } catch (Throwable th) {
                    d.this.d(false);
                    throw th;
                }
            }

            @Override // com.bytedance.sdk.component.b.d.yo, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, com.bytedance.sdk.component.b.d.rf
            public void close() throws IOException {
                d.this.d();
                try {
                    try {
                        yoVar.close();
                        d.this.d(true);
                    } catch (IOException e) {
                        throw d.this.d(e);
                    }
                } catch (Throwable th) {
                    d.this.d(false);
                    throw th;
                }
            }

            @Override // com.bytedance.sdk.component.b.d.yo, com.bytedance.sdk.component.b.d.rf
            public jh d() {
                return d.this;
            }

            public String toString() {
                return "AsyncTimeout.sink(" + yoVar + ")";
            }
        };
    }

    public final rf d(final rf rfVar) {
        return new rf() { // from class: com.bytedance.sdk.component.b.d.d.2
            @Override // com.bytedance.sdk.component.b.d.rf
            public long d(b bVar, long j) throws IOException {
                d.this.d();
                try {
                    try {
                        long jD = rfVar.d(bVar, j);
                        d.this.d(true);
                        return jD;
                    } catch (IOException e) {
                        throw d.this.d(e);
                    }
                } catch (Throwable th) {
                    d.this.d(false);
                    throw th;
                }
            }

            @Override // com.bytedance.sdk.component.b.d.rf, java.lang.AutoCloseable, java.nio.channels.Channel
            public void close() throws IOException {
                d.this.d();
                try {
                    try {
                        rfVar.close();
                        d.this.d(true);
                    } catch (IOException e) {
                        throw d.this.d(e);
                    }
                } catch (Throwable th) {
                    d.this.d(false);
                    throw th;
                }
            }

            @Override // com.bytedance.sdk.component.b.d.rf
            public jh d() {
                return d.this;
            }

            public String toString() {
                return "AsyncTimeout.source(" + rfVar + ")";
            }
        };
    }

    final void d(boolean z) throws IOException {
        if (hc() && z) {
            throw hc((IOException) null);
        }
    }

    final IOException d(IOException iOException) throws IOException {
        return !hc() ? iOException : hc(iOException);
    }

    protected IOException hc(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* renamed from: com.bytedance.sdk.component.b.d.d$d, reason: collision with other inner class name */
    private static final class C0272d extends com.bytedance.sdk.component.tc.c.b {
        C0272d() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0015, code lost:
        
            r1.m_();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r3 = this;
            L0:
                java.lang.Class<com.bytedance.sdk.component.b.d.d> r0 = com.bytedance.sdk.component.b.d.d.class
                monitor-enter(r0)     // Catch: java.lang.InterruptedException -> L0 java.lang.Throwable -> L1c
                com.bytedance.sdk.component.b.d.d r1 = com.bytedance.sdk.component.b.d.d.c()     // Catch: java.lang.Throwable -> L19
                if (r1 != 0) goto Lb
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                goto L0
            Lb:
                com.bytedance.sdk.component.b.d.d r2 = com.bytedance.sdk.component.b.d.d.d     // Catch: java.lang.Throwable -> L19
                if (r1 != r2) goto L14
                r1 = 0
                com.bytedance.sdk.component.b.d.d.d = r1     // Catch: java.lang.Throwable -> L19
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                return
            L14:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                r1.m_()     // Catch: java.lang.InterruptedException -> L0 java.lang.Throwable -> L1c
                goto L0
            L19:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                throw r1     // Catch: java.lang.InterruptedException -> L0 java.lang.Throwable -> L1c
            L1c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.b.d.d.C0272d.run():void");
        }
    }

    static d c() throws InterruptedException {
        d dVar = d.an;
        if (dVar == null) {
            long jNanoTime = System.nanoTime();
            d.class.wait(hc);
            if (d.an != null || System.nanoTime() - jNanoTime < c) {
                return null;
            }
            return d;
        }
        long jHc = dVar.hc(System.nanoTime());
        if (jHc > 0) {
            long j = jHc / 1000000;
            d.class.wait(j, (int) (jHc - (1000000 * j)));
            return null;
        }
        d.an = dVar.an;
        dVar.an = null;
        return dVar;
    }
}
