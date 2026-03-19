package com.kwad.sdk.glide.e;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class d extends InputStream {
    private static final Queue<d> cag = j.gt(0);
    private InputStream cah;
    private IOException cai;

    public static d l(InputStream inputStream) {
        d dVarPoll;
        Queue<d> queue = cag;
        synchronized (queue) {
            dVarPoll = queue.poll();
        }
        if (dVarPoll == null) {
            dVarPoll = new d();
        }
        dVarPoll.setInputStream(inputStream);
        return dVarPoll;
    }

    d() {
    }

    private void setInputStream(InputStream inputStream) {
        this.cah = inputStream;
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.cah.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.cah.close();
    }

    @Override // java.io.InputStream
    public final void mark(int i) {
        this.cah.mark(i);
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.cah.markSupported();
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) {
        try {
            return this.cah.read(bArr);
        } catch (IOException e) {
            this.cai = e;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) {
        try {
            return this.cah.read(bArr, i, i2);
        } catch (IOException e) {
            this.cai = e;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        this.cah.reset();
    }

    @Override // java.io.InputStream
    public final long skip(long j) {
        try {
            return this.cah.skip(j);
        } catch (IOException e) {
            this.cai = e;
            return 0L;
        }
    }

    @Override // java.io.InputStream
    public final int read() {
        try {
            return this.cah.read();
        } catch (IOException e) {
            this.cai = e;
            return -1;
        }
    }

    public final IOException ajx() {
        return this.cai;
    }

    public final void release() {
        this.cai = null;
        this.cah = null;
        Queue<d> queue = cag;
        synchronized (queue) {
            queue.offer(this);
        }
    }
}
