package com.bytedance.sdk.component.b.d;

import androidx.core.location.LocationRequestCompat;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import okhttp3.internal.connection.RealConnection;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class b implements c, u, Cloneable, ByteChannel {
    private static final byte[] b = {com.sigmob.sdk.archives.tar.e.H, com.sigmob.sdk.archives.tar.e.I, com.sigmob.sdk.archives.tar.e.J, com.sigmob.sdk.archives.tar.e.f789K, com.sigmob.sdk.archives.tar.e.L, com.sigmob.sdk.archives.tar.e.M, com.sigmob.sdk.archives.tar.e.N, com.sigmob.sdk.archives.tar.e.O, 56, 57, 97, 98, 99, 100, 101, 102};
    e d;
    long hc;

    @Override // com.bytedance.sdk.component.b.d.c, com.bytedance.sdk.component.b.d.u
    public b b() {
        return this;
    }

    @Override // com.bytedance.sdk.component.b.d.c
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b sy() {
        return this;
    }

    @Override // com.bytedance.sdk.component.b.d.yo, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, com.bytedance.sdk.component.b.d.rf
    public void close() {
    }

    @Override // com.bytedance.sdk.component.b.d.c, com.bytedance.sdk.component.b.d.yo, java.io.Flushable
    public void flush() {
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public final long hc() {
        return this.hc;
    }

    @Override // com.bytedance.sdk.component.b.d.u
    public boolean u() {
        return this.hc == 0;
    }

    @Override // com.bytedance.sdk.component.b.d.u
    public void d(long j) throws EOFException {
        if (this.hc < j) {
            throw new EOFException();
        }
    }

    @Override // com.bytedance.sdk.component.b.d.u
    public InputStream an() {
        return new InputStream() { // from class: com.bytedance.sdk.component.b.d.b.1
            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                if (b.this.hc > 0) {
                    return b.this.gb() & 255;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) {
                return b.this.d(bArr, i, i2);
            }

            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(b.this.hc, 2147483647L);
            }

            public String toString() {
                return b.this + ".inputStream()";
            }
        };
    }

    public final b d(b bVar, long j, long j2) {
        if (bVar == null) {
            throw new IllegalArgumentException("out == null");
        }
        sy.d(this.hc, j, j2);
        if (j2 == 0) {
            return this;
        }
        bVar.hc += j2;
        e eVar = this.d;
        while (j >= eVar.b - eVar.hc) {
            j -= eVar.b - eVar.hc;
            eVar = eVar.an;
        }
        while (j2 > 0) {
            e eVarD = eVar.d();
            eVarD.hc = (int) (eVarD.hc + j);
            eVarD.b = Math.min(eVarD.hc + ((int) j2), eVarD.b);
            e eVar2 = bVar.d;
            if (eVar2 == null) {
                eVarD.h = eVarD;
                eVarD.an = eVarD;
                bVar.d = eVarD;
            } else {
                eVar2.h.d(eVarD);
            }
            j2 -= eVarD.b - eVarD.hc;
            eVar = eVar.an;
            j = 0;
        }
        return this;
    }

    public final long h() {
        long j = this.hc;
        if (j == 0) {
            return 0L;
        }
        e eVar = this.d.h;
        return (eVar.b >= 8192 || !eVar.u) ? j : j - (eVar.b - eVar.hc);
    }

    @Override // com.bytedance.sdk.component.b.d.u
    public byte gb() {
        if (this.hc == 0) {
            throw new IllegalStateException("size == 0");
        }
        e eVar = this.d;
        int i = eVar.hc;
        int i2 = eVar.b;
        int i3 = i + 1;
        byte b2 = eVar.d[i];
        this.hc--;
        if (i3 == i2) {
            this.d = eVar.hc();
            cb.d(eVar);
        } else {
            eVar.hc = i3;
        }
        return b2;
    }

    public final byte hc(long j) {
        sy.d(this.hc, j, 1L);
        long j2 = this.hc;
        if (j2 - j > j) {
            e eVar = this.d;
            while (true) {
                long j3 = eVar.b - eVar.hc;
                if (j >= j3) {
                    j -= j3;
                    eVar = eVar.an;
                } else {
                    return eVar.d[eVar.hc + ((int) j)];
                }
            }
        } else {
            long j4 = j - j2;
            try {
                e eVar2 = this.d;
                do {
                    eVar2 = eVar2.h;
                    j4 += eVar2.b - eVar2.hc;
                } while (j4 < 0);
                return eVar2.d[eVar2.hc + ((int) j4)];
            } catch (NullPointerException unused) {
                return (byte) 0;
            }
        }
    }

    @Override // com.bytedance.sdk.component.b.d.u
    public short tt() {
        if (this.hc < 2) {
            throw new IllegalStateException("size < 2: " + this.hc);
        }
        e eVar = this.d;
        int i = eVar.hc;
        int i2 = eVar.b;
        if (i2 - i < 2) {
            return (short) (((gb() & 255) << 8) | (gb() & 255));
        }
        byte[] bArr = eVar.d;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
        this.hc -= 2;
        if (i4 == i2) {
            this.d = eVar.hc();
            cb.d(eVar);
        } else {
            eVar.hc = i4;
        }
        return (short) i5;
    }

    @Override // com.bytedance.sdk.component.b.d.u
    public int tc() {
        if (this.hc < 4) {
            throw new IllegalStateException("size < 4: " + this.hc);
        }
        e eVar = this.d;
        int i = eVar.hc;
        int i2 = eVar.b;
        if (i2 - i < 4) {
            return ((gb() & 255) << 24) | ((gb() & 255) << 16) | ((gb() & 255) << 8) | (gb() & 255);
        }
        byte[] bArr = eVar.d;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & 255) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & 255);
        this.hc -= 4;
        if (i8 == i2) {
            this.d = eVar.hc();
            cb.d(eVar);
        } else {
            eVar.hc = i8;
        }
        return i9;
    }

    @Override // com.bytedance.sdk.component.b.d.u
    public short mk() {
        return sy.d(tt());
    }

    @Override // com.bytedance.sdk.component.b.d.u
    public int mq() {
        return sy.d(tc());
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a1 A[EDGE_INSN: B:44:0x00a1->B:38:0x00a1 BREAK  A[LOOP:0: B:5:0x000b->B:46:?], SYNTHETIC] */
    @Override // com.bytedance.sdk.component.b.d.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long uo() {
        /*
            r14 = this;
            long r0 = r14.hc
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto La8
            r0 = 0
            r1 = r0
            r4 = r2
        Lb:
            com.bytedance.sdk.component.b.d.e r6 = r14.d
            byte[] r7 = r6.d
            int r8 = r6.hc
            int r9 = r6.b
        L13:
            if (r8 >= r9) goto L8d
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L22
            r11 = 57
            if (r10 > r11) goto L22
            int r11 = r10 + (-48)
            goto L3a
        L22:
            r11 = 97
            if (r10 < r11) goto L2f
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L2f
            int r11 = r10 + (-97)
        L2c:
            int r11 = r11 + 10
            goto L3a
        L2f:
            r11 = 65
            if (r10 < r11) goto L70
            r11 = 70
            if (r10 > r11) goto L70
            int r11 = r10 + (-65)
            goto L2c
        L3a:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L4a
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L13
        L4a:
            com.bytedance.sdk.component.b.d.b r0 = new com.bytedance.sdk.component.b.d.b
            r0.<init>()
            com.bytedance.sdk.component.b.d.b r0 = r0.mk(r4)
            com.bytedance.sdk.component.b.d.b r0 = r0.tt(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Number too large: "
            r2.<init>(r3)
            java.lang.String r0 = r0.e()
            java.lang.StringBuilder r0 = r2.append(r0)
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L70:
            if (r0 == 0) goto L74
            r1 = 1
            goto L8d
        L74:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.<init>(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L8d:
            if (r8 != r9) goto L99
            com.bytedance.sdk.component.b.d.e r7 = r6.hc()
            r14.d = r7
            com.bytedance.sdk.component.b.d.cb.d(r6)
            goto L9b
        L99:
            r6.hc = r8
        L9b:
            if (r1 != 0) goto La1
            com.bytedance.sdk.component.b.d.e r6 = r14.d
            if (r6 != 0) goto Lb
        La1:
            long r1 = r14.hc
            long r6 = (long) r0
            long r1 = r1 - r6
            r14.hc = r1
            return r4
        La8:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.b.d.b.uo():long");
    }

    public an k() throws EOFException {
        return new an(w());
    }

    @Override // com.bytedance.sdk.component.b.d.u
    public an b(long j) throws EOFException {
        return new an(h(j));
    }

    public String e() {
        try {
            return d(this.hc, sy.d);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String c(long j) throws EOFException {
        return d(j, sy.d);
    }

    @Override // com.bytedance.sdk.component.b.d.u
    public String d(Charset charset) {
        try {
            return d(this.hc, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String d(long j, Charset charset) throws EOFException {
        sy.d(this.hc, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
        }
        if (j == 0) {
            return "";
        }
        e eVar = this.d;
        if (eVar.hc + j > eVar.b) {
            return new String(h(j), charset);
        }
        String str = new String(eVar.d, eVar.hc, (int) j, charset);
        eVar.hc = (int) (eVar.hc + j);
        this.hc -= j;
        if (eVar.hc == eVar.b) {
            this.d = eVar.hc();
            cb.d(eVar);
        }
        return str;
    }

    @Override // com.bytedance.sdk.component.b.d.u
    public String cb() throws EOFException {
        return u(LocationRequestCompat.PASSIVE_INTERVAL);
    }

    @Override // com.bytedance.sdk.component.b.d.u
    public String u(long j) throws EOFException {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: ".concat(String.valueOf(j)));
        }
        long j2 = LocationRequestCompat.PASSIVE_INTERVAL;
        if (j != LocationRequestCompat.PASSIVE_INTERVAL) {
            j2 = j + 1;
        }
        long jD = d((byte) 10, 0L, j2);
        if (jD != -1) {
            return an(jD);
        }
        if (j2 < hc() && hc(j2 - 1) == 13 && hc(j2) == 10) {
            return an(j2);
        }
        b bVar = new b();
        d(bVar, 0L, Math.min(32L, hc()));
        throw new EOFException("\\n not found: limit=" + Math.min(hc(), j) + " content=" + bVar.k().u() + (char) 8230);
    }

    String an(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (hc(j2) == 13) {
                String strC = c(j2);
                gb(2L);
                return strC;
            }
        }
        String strC2 = c(j);
        gb(1L);
        return strC2;
    }

    @Override // com.bytedance.sdk.component.b.d.u
    public byte[] w() throws EOFException {
        try {
            return h(this.hc);
        } catch (EOFException e) {
            throw e;
        }
    }

    @Override // com.bytedance.sdk.component.b.d.u
    public byte[] h(long j) throws EOFException {
        sy.d(this.hc, 0L, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
        }
        byte[] bArr = new byte[(int) j];
        d(bArr);
        return bArr;
    }

    @Override // com.bytedance.sdk.component.b.d.u
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
        sy.d(bArr.length, i, i2);
        e eVar = this.d;
        if (eVar == null) {
            return -1;
        }
        int iMin = Math.min(i2, eVar.b - eVar.hc);
        System.arraycopy(eVar.d, eVar.hc, bArr, i, iMin);
        eVar.hc += iMin;
        this.hc -= iMin;
        if (eVar.hc == eVar.b) {
            this.d = eVar.hc();
            cb.d(eVar);
        }
        return iMin;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        e eVar = this.d;
        if (eVar == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), eVar.b - eVar.hc);
        byteBuffer.put(eVar.d, eVar.hc, iMin);
        eVar.hc += iMin;
        this.hc -= iMin;
        if (eVar.hc == eVar.b) {
            this.d = eVar.hc();
            cb.d(eVar);
        }
        return iMin;
    }

    public final void yo() {
        try {
            gb(this.hc);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.bytedance.sdk.component.b.d.u
    public void gb(long j) throws EOFException {
        e eVar;
        while (j > 0 && (eVar = this.d) != null) {
            int iMin = (int) Math.min(j, eVar.b - this.d.hc);
            long j2 = iMin;
            this.hc -= j2;
            j -= j2;
            this.d.hc += iMin;
            if (this.d.hc == this.d.b) {
                e eVar2 = this.d;
                this.d = eVar2.hc();
                cb.d(eVar2);
            }
        }
    }

    @Override // com.bytedance.sdk.component.b.d.c
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public b hc(an anVar) {
        if (anVar == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        anVar.d(this);
        return this;
    }

    @Override // com.bytedance.sdk.component.b.d.c
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public b hc(String str) {
        return d(str, 0, str.length());
    }

    public b d(String str, int i, int i2) {
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
                e eVarU = u(1);
                byte[] bArr = eVarU.d;
                int i3 = eVarU.b - i;
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
                int i5 = (i3 + i) - eVarU.b;
                eVarU.b += i5;
                this.hc += i5;
            } else {
                if (cCharAt2 < 2048) {
                    tt((cCharAt2 >> 6) | 192);
                    tt((cCharAt2 & '?') | 128);
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    tt((cCharAt2 >> '\f') | 224);
                    tt(((cCharAt2 >> 6) & 63) | 128);
                    tt((cCharAt2 & '?') | 128);
                } else {
                    int i6 = i + 1;
                    char cCharAt3 = i6 < i2 ? str.charAt(i6) : (char) 0;
                    if (cCharAt2 > 56319 || cCharAt3 < 56320 || cCharAt3 > 57343) {
                        tt(63);
                        i = i6;
                    } else {
                        int i7 = (((cCharAt2 & 10239) << 10) | (9215 & cCharAt3)) + 65536;
                        tt((i7 >> 18) | 240);
                        tt(((i7 >> 12) & 63) | 128);
                        tt(((i7 >> 6) & 63) | 128);
                        tt((i7 & 63) | 128);
                        i += 2;
                    }
                }
                i++;
            }
        }
        return this;
    }

    public b d(int i) {
        if (i < 128) {
            tt(i);
        } else if (i < 2048) {
            tt((i >> 6) | 192);
            tt((i & 63) | 128);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                tt(63);
            } else {
                tt((i >> 12) | 224);
                tt(((i >> 6) & 63) | 128);
                tt((i & 63) | 128);
            }
        } else if (i <= 1114111) {
            tt((i >> 18) | 240);
            tt(((i >> 12) & 63) | 128);
            tt(((i >> 6) & 63) | 128);
            tt((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    public b d(String str, int i, int i2, Charset charset) {
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
        if (charset.equals(sy.d)) {
            return d(str, i, i2);
        }
        byte[] bytes = str.substring(i, i2).getBytes(charset);
        return b(bytes, 0, bytes.length);
    }

    @Override // com.bytedance.sdk.component.b.d.c
    /* renamed from: hc, reason: merged with bridge method [inline-methods] */
    public b b(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        return b(bArr, 0, bArr.length);
    }

    @Override // com.bytedance.sdk.component.b.d.c
    /* renamed from: hc, reason: merged with bridge method [inline-methods] */
    public b b(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = i2;
        sy.d(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            e eVarU = u(1);
            int iMin = Math.min(i3 - i, 8192 - eVarU.b);
            System.arraycopy(bArr, i, eVarU.d, eVarU.b, iMin);
            i += iMin;
            eVarU.b += iMin;
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
            e eVarU = u(1);
            int iMin = Math.min(i, 8192 - eVarU.b);
            byteBuffer.get(eVarU.d, eVarU.b, iMin);
            i -= iMin;
            eVarU.b += iMin;
        }
        this.hc += iRemaining;
        return iRemaining;
    }

    public long d(rf rfVar) throws IOException {
        if (rfVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long jD = rfVar.d(this, 8192L);
            if (jD == -1) {
                return j;
            }
            j += jD;
        }
    }

    @Override // com.bytedance.sdk.component.b.d.c
    /* renamed from: hc, reason: merged with bridge method [inline-methods] */
    public b tt(int i) {
        e eVarU = u(1);
        byte[] bArr = eVarU.d;
        int i2 = eVarU.b;
        eVarU.b = i2 + 1;
        bArr[i2] = (byte) i;
        this.hc++;
        return this;
    }

    @Override // com.bytedance.sdk.component.b.d.c
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b gb(int i) {
        e eVarU = u(2);
        byte[] bArr = eVarU.d;
        int i2 = eVarU.b;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        eVarU.b = i3 + 1;
        this.hc += 2;
        return this;
    }

    @Override // com.bytedance.sdk.component.b.d.c
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b h(int i) {
        e eVarU = u(4);
        byte[] bArr = eVarU.d;
        int i2 = eVarU.b;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        eVarU.b = i5 + 1;
        this.hc += 4;
        return this;
    }

    @Override // com.bytedance.sdk.component.b.d.c
    /* renamed from: tt, reason: merged with bridge method [inline-methods] */
    public b mq(long j) {
        if (j == 0) {
            return tt(48);
        }
        boolean z = false;
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return hc("-9223372036854775808");
            }
            z = true;
        }
        if (j >= 100000000) {
            i = j < 1000000000000L ? j < RealConnection.IDLE_CONNECTION_HEALTHY_NS ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            i = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i = 2;
        }
        if (z) {
            i++;
        }
        e eVarU = u(i);
        byte[] bArr = eVarU.d;
        int i2 = eVarU.b + i;
        while (j != 0) {
            i2--;
            bArr[i2] = b[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        eVarU.b += i;
        this.hc += i;
        return this;
    }

    @Override // com.bytedance.sdk.component.b.d.c
    /* renamed from: tc, reason: merged with bridge method [inline-methods] */
    public b mk(long j) {
        if (j == 0) {
            return tt(48);
        }
        int iNumberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        e eVarU = u(iNumberOfTrailingZeros);
        byte[] bArr = eVarU.d;
        int i = eVarU.b;
        for (int i2 = (eVarU.b + iNumberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = b[(int) (15 & j)];
            j >>>= 4;
        }
        eVarU.b += iNumberOfTrailingZeros;
        this.hc += iNumberOfTrailingZeros;
        return this;
    }

    e u(int i) {
        if (i <= 0 || i > 8192) {
            throw new IllegalArgumentException();
        }
        e eVar = this.d;
        if (eVar == null) {
            e eVarD = cb.d();
            this.d = eVarD;
            eVarD.h = eVarD;
            eVarD.an = eVarD;
            return eVarD;
        }
        e eVar2 = eVar.h;
        return (eVar2.b + i > 8192 || !eVar2.u) ? eVar2.d(cb.d()) : eVar2;
    }

    @Override // com.bytedance.sdk.component.b.d.yo
    public void a_(b bVar, long j) {
        e eVar;
        if (bVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (bVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        sy.d(bVar.hc, 0L, j);
        while (j > 0 && (eVar = bVar.d) != null) {
            if (j < eVar.b - eVar.hc) {
                e eVar2 = this.d;
                e eVar3 = eVar2 != null ? eVar2.h : null;
                if (eVar3 != null && eVar3.u) {
                    if ((eVar3.b + j) - (eVar3.c ? 0 : eVar3.hc) <= 8192) {
                        bVar.d.d(eVar3, (int) j);
                        bVar.hc -= j;
                        this.hc += j;
                        return;
                    }
                }
                bVar.d = bVar.d.d((int) j);
            }
            e eVar4 = bVar.d;
            long j2 = eVar4.b - eVar4.hc;
            bVar.d = eVar4.hc();
            e eVar5 = this.d;
            if (eVar5 == null) {
                this.d = eVar4;
                eVar4.h = eVar4;
                eVar4.an = eVar4;
            } else {
                eVar5.h.d(eVar4).b();
            }
            bVar.hc -= j2;
            this.hc += j2;
            j -= j2;
        }
    }

    @Override // com.bytedance.sdk.component.b.d.rf
    public long d(b bVar, long j) {
        if (bVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        long j2 = this.hc;
        if (j2 == 0) {
            return -1L;
        }
        if (j > j2) {
            j = j2;
        }
        bVar.a_(this, j);
        return j;
    }

    @Override // com.bytedance.sdk.component.b.d.u
    public long d(byte b2) {
        return d(b2, 0L, LocationRequestCompat.PASSIVE_INTERVAL);
    }

    public long d(byte b2, long j, long j2) {
        e eVar;
        long j3 = 0;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.hc), Long.valueOf(j), Long.valueOf(j2)));
        }
        long j4 = this.hc;
        long j5 = j2 > j4 ? j4 : j2;
        if (j == j5 || (eVar = this.d) == null) {
            return -1L;
        }
        if (j4 - j < j) {
            while (j4 > j) {
                eVar = eVar.h;
                j4 -= eVar.b - eVar.hc;
            }
        } else {
            while (true) {
                long j6 = (eVar.b - eVar.hc) + j3;
                if (j6 >= j) {
                    break;
                }
                eVar = eVar.an;
                j3 = j6;
            }
            j4 = j3;
        }
        long j7 = j;
        while (j4 < j5) {
            byte[] bArr = eVar.d;
            int iMin = (int) Math.min(eVar.b, (eVar.hc + j5) - j4);
            for (int i = (int) ((eVar.hc + j7) - j4); i < iMin; i++) {
                if (bArr[i] == b2) {
                    return (i - eVar.hc) + j4;
                }
            }
            j4 += eVar.b - eVar.hc;
            eVar = eVar.an;
            j7 = j4;
        }
        return -1L;
    }

    @Override // com.bytedance.sdk.component.b.d.u
    public boolean d(long j, an anVar) {
        return d(j, anVar, 0, anVar.h());
    }

    public boolean d(long j, an anVar, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.hc - j < i2 || anVar.h() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (hc(i3 + j) != anVar.d(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.b.d.yo, com.bytedance.sdk.component.b.d.rf
    public jh d() {
        return jh.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        long j = this.hc;
        if (j != bVar.hc) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        e eVar = this.d;
        e eVar2 = bVar.d;
        int i = eVar.hc;
        int i2 = eVar2.hc;
        while (j2 < this.hc) {
            long jMin = Math.min(eVar.b - i, eVar2.b - i2);
            int i3 = 0;
            while (i3 < jMin) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (eVar.d[i] != eVar2.d[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == eVar.b) {
                eVar = eVar.an;
                i = eVar.hc;
            }
            if (i2 == eVar2.b) {
                eVar2 = eVar2.an;
                i2 = eVar2.hc;
            }
            j2 += jMin;
        }
        return true;
    }

    public int hashCode() {
        e eVar = this.d;
        if (eVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = eVar.b;
            for (int i3 = eVar.hc; i3 < i2; i3++) {
                i = (i * 31) + eVar.d[i3];
            }
            eVar = eVar.an;
        } while (eVar != this.d);
        return i;
    }

    public String toString() {
        return jh().toString();
    }

    /* renamed from: rf, reason: merged with bridge method [inline-methods] */
    public b clone() {
        b bVar = new b();
        if (this.hc == 0) {
            return bVar;
        }
        e eVarD = this.d.d();
        bVar.d = eVarD;
        eVarD.h = eVarD;
        eVarD.an = eVarD;
        e eVar = this.d;
        while (true) {
            eVar = eVar.an;
            if (eVar != this.d) {
                bVar.d.h.d(eVar.d());
            } else {
                bVar.hc = this.hc;
                return bVar;
            }
        }
    }

    public final an jh() {
        long j = this.hc;
        if (j > 2147483647L) {
            throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.hc);
        }
        return an((int) j);
    }

    public final an an(int i) {
        if (i == 0) {
            return an.hc;
        }
        return new w(this, i);
    }
}
