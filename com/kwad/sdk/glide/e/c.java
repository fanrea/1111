package com.kwad.sdk.glide.e;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class c extends FilterInputStream {
    private int caf;
    private final long contentLength;

    public static InputStream a(InputStream inputStream, long j) {
        return new c(inputStream, j);
    }

    private c(InputStream inputStream, long j) {
        super(inputStream);
        this.contentLength = j;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int available() {
        return (int) Math.max(this.contentLength - this.caf, this.in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read() {
        int i;
        i = super.read();
        gr(i >= 0 ? 1 : -1);
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read(byte[] bArr, int i, int i2) {
        return gr(super.read(bArr, i, i2));
    }

    private int gr(int i) throws IOException {
        if (i >= 0) {
            this.caf += i;
        } else if (this.contentLength - this.caf > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.contentLength + ", but read: " + this.caf);
        }
        return i;
    }
}
