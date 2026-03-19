package com.component.lottie.e;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class ab {
    public static final ab c = new ac();
    private boolean a;
    private long b;
    private long d;

    public ab a(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0: " + j);
        }
        if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        }
        this.d = timeUnit.toNanos(j);
        return this;
    }

    public long e() {
        return this.d;
    }

    public boolean f() {
        return this.a;
    }

    public long g() {
        if (!this.a) {
            throw new IllegalStateException("No deadline");
        }
        return this.b;
    }

    public ab a(long j) {
        this.a = true;
        this.b = j;
        return this;
    }

    public final ab b(long j, TimeUnit timeUnit) {
        if (j <= 0) {
            throw new IllegalArgumentException("duration <= 0: " + j);
        }
        if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        }
        return a(System.nanoTime() + timeUnit.toNanos(j));
    }

    public ab h() {
        this.d = 0L;
        return this;
    }

    public ab i() {
        this.a = false;
        return this;
    }

    public void j() throws InterruptedIOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
        if (this.a && this.b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public final void a(Object obj) throws InterruptedException, InterruptedIOException {
        try {
            boolean zF = f();
            long jE = e();
            long jNanoTime = 0;
            if (!zF && jE == 0) {
                obj.wait();
                return;
            }
            long jNanoTime2 = System.nanoTime();
            if (zF && jE != 0) {
                jE = Math.min(jE, g() - jNanoTime2);
            } else if (zF) {
                jE = g() - jNanoTime2;
            }
            if (jE > 0) {
                long j = jE / 1000000;
                Long.signum(j);
                obj.wait(j, (int) (jE - (1000000 * j)));
                jNanoTime = System.nanoTime() - jNanoTime2;
            }
            if (jNanoTime >= jE) {
                throw new InterruptedIOException("timeout");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    static long a(long j, long j2) {
        if (j == 0) {
            return j2;
        }
        if (j2 == 0 || j < j2) {
            return j;
        }
        return j2;
    }
}
