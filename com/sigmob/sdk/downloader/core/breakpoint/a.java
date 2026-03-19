package com.sigmob.sdk.downloader.core.breakpoint;

import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class a {
    private final long a;
    private final long b;
    private final AtomicLong c;

    public a(long startOffset, long contentLength) {
        this(startOffset, contentLength, 0L);
    }

    public a(long startOffset, long contentLength, long currentOffset) {
        if (startOffset < 0 || ((contentLength < 0 && contentLength != -1) || currentOffset < 0)) {
            throw new IllegalArgumentException();
        }
        this.a = startOffset;
        this.b = contentLength;
        this.c = new AtomicLong(currentOffset);
    }

    public long a() {
        return this.c.get();
    }

    public void a(long increaseLength) {
        this.c.addAndGet(increaseLength);
    }

    public long b() {
        return this.a;
    }

    public long c() {
        return this.a + this.c.get();
    }

    public long d() {
        return this.b;
    }

    public long e() {
        long j = this.b;
        if (j == -1) {
            return -1L;
        }
        return (this.a + j) - 1;
    }

    public void f() {
        this.c.set(0L);
    }

    public a g() {
        return new a(this.a, this.b, this.c.get());
    }

    public String toString() {
        return "[" + this.a + ", " + e() + ")-current:" + this.c;
    }
}
