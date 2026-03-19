package com.kwad.sdk.glide.load.a;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class c extends OutputStream {
    private com.kwad.sdk.glide.load.engine.bitmap_recycle.b bPD;
    private byte[] buffer;
    private int index;
    private final OutputStream out;

    public c(OutputStream outputStream, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this(outputStream, bVar, 65536);
    }

    private c(OutputStream outputStream, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, int i) {
        this.out = outputStream;
        this.bPD = bVar;
        this.buffer = (byte[]) bVar.a(65536, byte[].class);
    }

    @Override // java.io.OutputStream
    public final void write(int i) throws IOException {
        byte[] bArr = this.buffer;
        int i2 = this.index;
        this.index = i2 + 1;
        bArr[i2] = (byte) i;
        afW();
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        do {
            int i4 = i2 - i3;
            int i5 = i + i3;
            int i6 = this.index;
            if (i6 == 0 && i4 >= this.buffer.length) {
                this.out.write(bArr, i5, i4);
                return;
            }
            int iMin = Math.min(i4, this.buffer.length - i6);
            System.arraycopy(bArr, i5, this.buffer, this.index, iMin);
            this.index += iMin;
            i3 += iMin;
            afW();
        } while (i3 < i2);
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
        flushBuffer();
        this.out.flush();
    }

    private void flushBuffer() throws IOException {
        int i = this.index;
        if (i > 0) {
            this.out.write(this.buffer, 0, i);
            this.index = 0;
        }
    }

    private void afW() throws IOException {
        if (this.index == this.buffer.length) {
            flushBuffer();
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            flush();
            com.kwad.sdk.crash.utils.b.closeQuietly(this.out);
            release();
        } catch (Throwable th) {
            com.kwad.sdk.crash.utils.b.closeQuietly(this.out);
            throw th;
        }
    }

    private void release() {
        byte[] bArr = this.buffer;
        if (bArr != null) {
            this.bPD.put(bArr);
            this.buffer = null;
        }
    }
}
