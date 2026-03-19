package com.component.lottie.e;

import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class g extends InputStream {
    final /* synthetic */ e a;

    g(e eVar) {
        this.a = eVar;
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.a.c > 0) {
            return this.a.l() & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        return this.a.a(bArr, i, i2);
    }

    @Override // java.io.InputStream
    public int available() {
        return (int) Math.min(this.a.c, 2147483647L);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public String toString() {
        return this.a + ".inputStream()";
    }
}
