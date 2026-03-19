package com.bytedance.sdk.component.hc.d.hc;

import com.sigmob.sdk.archives.tar.e;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class d implements b, hc, Cloneable, ByteChannel {
    private static final byte[] b = {e.H, e.I, e.J, e.f789K, e.L, e.M, e.N, e.O, 56, 57, 97, 98, 99, 100, 101, 102};
    an d;
    long hc;

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
    }

    @Override // java.io.Flushable
    public void flush() {
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public boolean d() {
        return this.hc == 0;
    }

    public byte hc() {
        if (this.hc == 0) {
            throw new IllegalStateException("size == 0");
        }
        an anVar = this.d;
        int i = anVar.hc;
        int i2 = anVar.b;
        int i3 = i + 1;
        byte b2 = anVar.d[i];
        this.hc--;
        if (i3 == i2) {
            this.d = anVar.hc();
            h.d(anVar);
        } else {
            anVar.hc = i3;
        }
        return b2;
    }

    public String b() {
        try {
            return d(this.hc, tc.d);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String d(long j, Charset charset) throws EOFException {
        tc.d(this.hc, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
        }
        if (j == 0) {
            return "";
        }
        an anVar = this.d;
        if (anVar.hc + j > anVar.b) {
            return new String(d(j), charset);
        }
        String str = new String(anVar.d, anVar.hc, (int) j, charset);
        anVar.hc = (int) (anVar.hc + j);
        this.hc -= j;
        if (anVar.hc == anVar.b) {
            this.d = anVar.hc();
            h.d(anVar);
        }
        return str;
    }

    public byte[] d(long j) throws EOFException {
        tc.d(this.hc, 0L, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
        }
        byte[] bArr = new byte[(int) j];
        d(bArr);
        return bArr;
    }

    public void d(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int iD = d(bArr, i, bArr.length - i);
            if (iD == -1) {
                throw new EOFException();
            }
            i += iD;
        }
    }

    public int d(byte[] bArr, int i, int i2) {
        tc.d(bArr.length, i, i2);
        an anVar = this.d;
        if (anVar == null) {
            return -1;
        }
        int iMin = Math.min(i2, anVar.b - anVar.hc);
        System.arraycopy(anVar.d, anVar.hc, bArr, i, iMin);
        anVar.hc += iMin;
        this.hc -= iMin;
        if (anVar.hc == anVar.b) {
            this.d = anVar.hc();
            h.d(anVar);
        }
        return iMin;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        an anVar = this.d;
        if (anVar == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), anVar.b - anVar.hc);
        byteBuffer.put(anVar.d, anVar.hc, iMin);
        anVar.hc += iMin;
        this.hc -= iMin;
        if (anVar.hc == anVar.b) {
            this.d = anVar.hc();
            h.d(anVar);
        }
        return iMin;
    }

    public d d(String str) {
        return d(str, 0, str.length());
    }

    public d d(String str, int i, int i2) {
        char cCharAt;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0: ".concat(String.valueOf(i)));
        }
        if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        while (i < i2) {
            char cCharAt2 = str.charAt(i);
            if (cCharAt2 < 128) {
                an anVarB = b(1);
                byte[] bArr = anVarB.d;
                int i3 = anVarB.b - i;
                int iMin = Math.min(i2, 8192 - i3);
                int i4 = i + 1;
                bArr[i + i3] = (byte) cCharAt2;
                while (true) {
                    i = i4;
                    if (i >= iMin || (cCharAt = str.charAt(i)) >= 128) {
                        break;
                    }
                    i4 = i + 1;
                    bArr[i + i3] = (byte) cCharAt;
                }
                int i5 = (i3 + i) - anVarB.b;
                anVarB.b += i5;
                this.hc += i5;
            } else {
                if (cCharAt2 < 2048) {
                    hc((cCharAt2 >> 6) | 192);
                    hc((cCharAt2 & '?') | 128);
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    hc((cCharAt2 >> '\f') | 224);
                    hc(((cCharAt2 >> 6) & 63) | 128);
                    hc((cCharAt2 & '?') | 128);
                } else {
                    int i6 = i + 1;
                    char cCharAt3 = i6 < i2 ? str.charAt(i6) : (char) 0;
                    if (cCharAt2 > 56319 || cCharAt3 < 56320 || cCharAt3 > 57343) {
                        hc(63);
                        i = i6;
                    } else {
                        int i7 = (((cCharAt2 & 10239) << 10) | (9215 & cCharAt3)) + 65536;
                        hc((i7 >> 18) | 240);
                        hc(((i7 >> 12) & 63) | 128);
                        hc(((i7 >> 6) & 63) | 128);
                        hc((i7 & 63) | 128);
                        i += 2;
                    }
                }
                i++;
            }
        }
        return this;
    }

    public d d(int i) {
        if (i < 128) {
            hc(i);
        } else if (i < 2048) {
            hc((i >> 6) | 192);
            hc((i & 63) | 128);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                hc(63);
            } else {
                hc((i >> 12) | 224);
                hc(((i >> 6) & 63) | 128);
                hc((i & 63) | 128);
            }
        } else if (i <= 1114111) {
            hc((i >> 18) | 240);
            hc(((i >> 12) & 63) | 128);
            hc(((i >> 6) & 63) | 128);
            hc((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    public d d(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: ".concat(String.valueOf(i)));
        }
        if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (charset.equals(tc.d)) {
            return d(str, i, i2);
        }
        byte[] bytes = str.substring(i, i2).getBytes(charset);
        return hc(bytes, 0, bytes.length);
    }

    public d hc(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = i2;
        tc.d(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            an anVarB = b(1);
            int iMin = Math.min(i3 - i, 8192 - anVarB.b);
            System.arraycopy(bArr, i, anVarB.d, anVarB.b, iMin);
            i += iMin;
            anVarB.b += iMin;
        }
        this.hc += j;
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining;
        while (i > 0) {
            an anVarB = b(1);
            int iMin = Math.min(i, 8192 - anVarB.b);
            byteBuffer.get(anVarB.d, anVarB.b, iMin);
            i -= iMin;
            anVarB.b += iMin;
        }
        this.hc += iRemaining;
        return iRemaining;
    }

    public d hc(int i) {
        an anVarB = b(1);
        byte[] bArr = anVarB.d;
        int i2 = anVarB.b;
        anVarB.b = i2 + 1;
        bArr[i2] = (byte) i;
        this.hc++;
        return this;
    }

    public d hc(long j) {
        if (j == 0) {
            return hc(48);
        }
        int iNumberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        an anVarB = b(iNumberOfTrailingZeros);
        byte[] bArr = anVarB.d;
        int i = anVarB.b;
        for (int i2 = (anVarB.b + iNumberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = b[(int) (15 & j)];
            j >>>= 4;
        }
        anVarB.b += iNumberOfTrailingZeros;
        this.hc += iNumberOfTrailingZeros;
        return this;
    }

    an b(int i) {
        if (i <= 0 || i > 8192) {
            throw new IllegalArgumentException();
        }
        an anVar = this.d;
        if (anVar == null) {
            an anVarD = h.d();
            this.d = anVarD;
            anVarD.h = anVarD;
            anVarD.an = anVarD;
            return anVarD;
        }
        an anVar2 = anVar.h;
        return (anVar2.b + i > 8192 || !anVar2.u) ? anVar2.d(h.d()) : anVar2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        long j = this.hc;
        if (j != dVar.hc) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        an anVar = this.d;
        an anVar2 = dVar.d;
        int i = anVar.hc;
        int i2 = anVar2.hc;
        while (j2 < this.hc) {
            long jMin = Math.min(anVar.b - i, anVar2.b - i2);
            int i3 = 0;
            while (i3 < jMin) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (anVar.d[i] != anVar2.d[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == anVar.b) {
                anVar = anVar.an;
                i = anVar.hc;
            }
            if (i2 == anVar2.b) {
                anVar2 = anVar2.an;
                i2 = anVar2.hc;
            }
            j2 += jMin;
        }
        return true;
    }

    public int hashCode() {
        an anVar = this.d;
        if (anVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = anVar.b;
            for (int i3 = anVar.hc; i3 < i2; i3++) {
                i = (i * 31) + anVar.d[i3];
            }
            anVar = anVar.an;
        } while (anVar != this.d);
        return i;
    }

    public String toString() {
        return u().toString();
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public d clone() {
        d dVar = new d();
        if (this.hc == 0) {
            return dVar;
        }
        an anVarD = this.d.d();
        dVar.d = anVarD;
        anVarD.h = anVarD;
        anVarD.an = anVarD;
        an anVar = this.d;
        while (true) {
            anVar = anVar.an;
            if (anVar != this.d) {
                dVar.d.h.d(anVar.d());
            } else {
                dVar.hc = this.hc;
                return dVar;
            }
        }
    }

    public final c u() {
        long j = this.hc;
        if (j > 2147483647L) {
            throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.hc);
        }
        return c((int) j);
    }

    public final c c(int i) {
        if (i == 0) {
            return c.b;
        }
        return new gb(this, i);
    }
}
