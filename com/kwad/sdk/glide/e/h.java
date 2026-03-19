package com.kwad.sdk.glide.e;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class h extends FilterInputStream {
    private int can;

    public h(InputStream inputStream) {
        super(inputStream);
        this.can = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i) {
        super.mark(i);
        this.can = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        if (br(1L) == -1) {
            return -1;
        }
        int i = super.read();
        bs(1L);
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int iBr = (int) br(i2);
        if (iBr == -1) {
            return -1;
        }
        int i3 = super.read(bArr, i, iBr);
        bs(i3);
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() {
        super.reset();
        this.can = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j) throws IOException {
        long jBr = br(j);
        if (jBr == -1) {
            return 0L;
        }
        long jSkip = super.skip(jBr);
        bs(jSkip);
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() {
        int i = this.can;
        return i == Integer.MIN_VALUE ? super.available() : Math.min(i, super.available());
    }

    private long br(long j) {
        int i = this.can;
        if (i == 0) {
            return -1L;
        }
        return (i == Integer.MIN_VALUE || j <= ((long) i)) ? j : i;
    }

    private void bs(long j) {
        int i = this.can;
        if (i == Integer.MIN_VALUE || j == -1) {
            return;
        }
        this.can = (int) (i - j);
    }
}
