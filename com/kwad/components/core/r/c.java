package com.kwad.components.core.r;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends InputStream {
    private InputStream ZB;
    private int ZC;
    private volatile float ZE;
    private volatile long ZF;
    private int Zz = -1;
    private int ZA = 10000;
    private long lastSampleTime = -1;
    private long ZD = -1;
    private int ZG = 20480;

    c(InputStream inputStream, int i) {
        i = i < 20480 ? 20480 : i;
        this.ZB = inputStream;
        this.ZE = i / 1000.0f;
    }

    public final long sQ() {
        return this.ZF;
    }

    @Override // java.io.InputStream
    public final int read() throws InterruptedException, IOException {
        if (this.ZD <= 0) {
            this.ZD = System.currentTimeMillis();
        }
        this.ZC++;
        if (!(b.Zx && b.Zw)) {
            return this.ZB.read();
        }
        if (this.Zz < 0) {
            sR();
        }
        int i = this.ZB.read();
        this.Zz++;
        sS();
        return i;
    }

    @Override // java.io.InputStream
    public final long skip(long j) {
        return this.ZB.skip(j);
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.ZB.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.ZB.close();
        b.a(this);
        this.ZD = -1L;
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int i) {
        this.ZB.mark(i);
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        this.ZB.reset();
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.ZB.markSupported();
    }

    private void sR() {
        this.Zz = 0;
        this.lastSampleTime = System.currentTimeMillis();
    }

    private void sS() throws InterruptedException {
        if (this.Zz < this.ZA) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - this.lastSampleTime;
        float f = this.Zz / this.ZE;
        this.ZF = g(this.ZC, jCurrentTimeMillis - this.ZD);
        float f2 = j;
        if (f > f2) {
            N((long) (f - f2));
        }
        sR();
    }

    private static long g(long j, long j2) {
        if (j <= 0) {
            return 0L;
        }
        if (j2 <= 0) {
            return -1L;
        }
        return j / j2;
    }

    private static void N(long j) throws InterruptedException {
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
