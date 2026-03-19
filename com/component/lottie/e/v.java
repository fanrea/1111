package com.component.lottie.e;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class v extends InputStream {
    final /* synthetic */ u a;

    v(u uVar) {
        this.a = uVar;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.a.c) {
            throw new IOException("closed");
        }
        if (this.a.a.c == 0 && this.a.b.a(this.a.a, 8192L) == -1) {
            return -1;
        }
        return this.a.a.l() & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.a.c) {
            throw new IOException("closed");
        }
        k.a(bArr.length, i, i2);
        if (this.a.a.c == 0 && this.a.b.a(this.a.a, 8192L) == -1) {
            return -1;
        }
        return this.a.a.a(bArr, i, i2);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (this.a.c) {
            throw new IOException("closed");
        }
        return (int) Math.min(this.a.a.c, 2147483647L);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.close();
    }

    public String toString() {
        return this.a + ".inputStream()";
    }
}
