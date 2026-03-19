package com.bytedance.sdk.component.b.d;

import androidx.core.location.LocationRequestCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
final class k implements u {
    boolean b;
    public final b d = new b();
    public final rf hc;

    k(rf rfVar) {
        if (rfVar == null) {
            throw new NullPointerException("source == null");
        }
        this.hc = rfVar;
    }

    @Override // com.bytedance.sdk.component.b.d.u
    public b b() {
        return this.d;
    }

    @Override // com.bytedance.sdk.component.b.d.rf
    public long d(b bVar, long j) throws IOException {
        if (bVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        if (this.b) {
            throw new IllegalStateException("closed");
        }
        if (this.d.hc == 0 && this.hc.d(this.d, 8192L) == -1) {
            return -1L;
        }
        return this.d.d(bVar, Math.min(j, this.d.hc));
    }

    @Override // com.bytedance.sdk.component.b.d.u
    public boolean u() throws IOException {
        if (this.b) {
            throw new IllegalStateException("closed");
        }
        return this.d.u() && this.hc.d(this.d, 8192L) == -1;
    }

    @Override // com.bytedance.sdk.component.b.d.u
    public void d(long j) throws IOException {
        if (!hc(j)) {
            throw new EOFException();
        }
    }

    public boolean hc(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        if (this.b) {
            throw new IllegalStateException("closed");
        }
        while (this.d.hc < j) {
            if (this.hc.d(this.d, 8192L) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.b.d.u
    public byte gb() throws IOException {
        d(1L);
        return this.d.gb();
    }

    @Override // com.bytedance.sdk.component.b.d.u
    public an b(long j) throws IOException {
        d(j);
        return this.d.b(j);
    }

    @Override // com.bytedance.sdk.component.b.d.u
    public byte[] w() throws IOException {
        this.d.d(this.hc);
        return this.d.w();
    }

    @Override // com.bytedance.sdk.component.b.d.u
    public byte[] h(long j) throws IOException {
        d(j);
        return this.d.h(j);
    }

    @Override // com.bytedance.sdk.component.b.d.u
    public void d(byte[] bArr) throws IOException {
        try {
            d(bArr.length);
            this.d.d(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (this.d.hc > 0) {
                b bVar = this.d;
                int iD = bVar.d(bArr, i, (int) bVar.hc);
                if (iD == -1) {
                    throw new AssertionError();
                }
                i += iD;
            }
            throw e;
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        if (this.d.hc == 0 && this.hc.d(this.d, 8192L) == -1) {
            return -1;
        }
        return this.d.read(byteBuffer);
    }

    @Override // com.bytedance.sdk.component.b.d.u
    public String d(Charset charset) throws IOException {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        this.d.d(this.hc);
        return this.d.d(charset);
    }

    @Override // com.bytedance.sdk.component.b.d.u
    public String cb() throws IOException {
        return u(LocationRequestCompat.PASSIVE_INTERVAL);
    }

    @Override // com.bytedance.sdk.component.b.d.u
    public String u(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: ".concat(String.valueOf(j)));
        }
        long j2 = j == LocationRequestCompat.PASSIVE_INTERVAL ? Long.MAX_VALUE : j + 1;
        long jD = d((byte) 10, 0L, j2);
        if (jD != -1) {
            return this.d.an(jD);
        }
        if (j2 < LocationRequestCompat.PASSIVE_INTERVAL && hc(j2) && this.d.hc(j2 - 1) == 13 && hc(1 + j2) && this.d.hc(j2) == 10) {
            return this.d.an(j2);
        }
        b bVar = new b();
        b bVar2 = this.d;
        bVar2.d(bVar, 0L, Math.min(32L, bVar2.hc()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.d.hc(), j) + " content=" + bVar.k().u() + (char) 8230);
    }

    @Override // com.bytedance.sdk.component.b.d.u
    public short tt() throws IOException {
        d(2L);
        return this.d.tt();
    }

    @Override // com.bytedance.sdk.component.b.d.u
    public short mk() throws IOException {
        d(2L);
        return this.d.mk();
    }

    @Override // com.bytedance.sdk.component.b.d.u
    public int tc() throws IOException {
        d(4L);
        return this.d.tc();
    }

    @Override // com.bytedance.sdk.component.b.d.u
    public int mq() throws IOException {
        d(4L);
        return this.d.mq();
    }

    @Override // com.bytedance.sdk.component.b.d.u
    public long uo() throws IOException {
        byte bHc;
        d(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!hc(i2)) {
                break;
            }
            bHc = this.d.hc(i);
            if ((bHc < 48 || bHc > 57) && ((bHc < 97 || bHc > 102) && (bHc < 65 || bHc > 70))) {
                break;
            }
            i = i2;
        }
        if (i == 0) {
            throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", Byte.valueOf(bHc)));
        }
        return this.d.uo();
    }

    @Override // com.bytedance.sdk.component.b.d.u
    public void gb(long j) throws IOException {
        if (this.b) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            if (this.d.hc == 0 && this.hc.d(this.d, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j, this.d.hc());
            this.d.gb(jMin);
            j -= jMin;
        }
    }

    @Override // com.bytedance.sdk.component.b.d.u
    public long d(byte b) throws IOException {
        return d(b, 0L, LocationRequestCompat.PASSIVE_INTERVAL);
    }

    public long d(byte b, long j, long j2) throws IOException {
        if (this.b) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j), Long.valueOf(j2)));
        }
        while (j < j2) {
            long jD = this.d.d(b, j, j2);
            if (jD != -1) {
                return jD;
            }
            long j3 = this.d.hc;
            if (j3 >= j2 || this.hc.d(this.d, 8192L) == -1) {
                break;
            }
            j = Math.max(j, j3);
        }
        return -1L;
    }

    @Override // com.bytedance.sdk.component.b.d.u
    public boolean d(long j, an anVar) throws IOException {
        return d(j, anVar, 0, anVar.h());
    }

    public boolean d(long j, an anVar, int i, int i2) throws IOException {
        if (this.b) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || i < 0 || i2 < 0 || anVar.h() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            long j2 = i3 + j;
            if (!hc(1 + j2) || this.d.hc(j2) != anVar.d(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.b.d.u
    public InputStream an() {
        return new InputStream() { // from class: com.bytedance.sdk.component.b.d.k.1
            @Override // java.io.InputStream
            public int read() throws IOException {
                if (k.this.b) {
                    throw new IOException("closed");
                }
                if (k.this.d.hc == 0 && k.this.hc.d(k.this.d, 8192L) == -1) {
                    return -1;
                }
                return k.this.d.gb() & 255;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                if (k.this.b) {
                    throw new IOException("closed");
                }
                sy.d(bArr.length, i, i2);
                if (k.this.d.hc == 0 && k.this.hc.d(k.this.d, 8192L) == -1) {
                    return -1;
                }
                return k.this.d.d(bArr, i, i2);
            }

            @Override // java.io.InputStream
            public int available() throws IOException {
                if (k.this.b) {
                    throw new IOException("closed");
                }
                return (int) Math.min(k.this.d.hc, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                k.this.close();
            }

            public String toString() {
                return k.this + ".inputStream()";
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.b;
    }

    @Override // com.bytedance.sdk.component.b.d.rf, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() throws IOException {
        if (this.b) {
            return;
        }
        this.b = true;
        this.hc.close();
        this.d.yo();
    }

    @Override // com.bytedance.sdk.component.b.d.rf
    public jh d() {
        return this.hc.d();
    }

    public String toString() {
        return "buffer(" + this.hc + ")";
    }
}
