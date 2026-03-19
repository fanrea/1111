package com.component.lottie.e;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class t extends OutputStream {
    final /* synthetic */ s a;

    t(s sVar) {
        this.a = sVar;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        if (this.a.c) {
            throw new IOException("closed");
        }
        this.a.a.m((int) ((byte) i));
        this.a.K();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.a.c) {
            throw new IOException("closed");
        }
        this.a.a.c(bArr, i, i2);
        this.a.K();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        if (!this.a.c) {
            this.a.flush();
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        this.a.close();
    }

    public String toString() {
        return this.a + ".outputStream()";
    }
}
