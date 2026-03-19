package com.bytedance.sdk.component.b.d;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class jh {
    public static final jh b = new jh() { // from class: com.bytedance.sdk.component.b.d.jh.1
        @Override // com.bytedance.sdk.component.b.d.jh
        public jh d(long j) {
            return this;
        }

        @Override // com.bytedance.sdk.component.b.d.jh
        public jh d(long j, TimeUnit timeUnit) {
            return this;
        }

        @Override // com.bytedance.sdk.component.b.d.jh
        public void h() throws IOException {
        }
    };
    private long c;
    private boolean d;
    private long hc;

    public jh d(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0: ".concat(String.valueOf(j)));
        }
        if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        }
        this.c = timeUnit.toNanos(j);
        return this;
    }

    public long n_() {
        return this.c;
    }

    public boolean b() {
        return this.d;
    }

    public long o_() {
        if (!this.d) {
            throw new IllegalStateException("No deadline");
        }
        return this.hc;
    }

    public jh d(long j) {
        this.d = true;
        this.hc = j;
        return this;
    }

    public jh u() {
        this.c = 0L;
        return this;
    }

    public jh an() {
        this.d = false;
        return this;
    }

    public void h() throws IOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
        if (this.d && this.hc - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
