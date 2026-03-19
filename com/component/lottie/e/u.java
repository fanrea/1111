package com.component.lottie.e;

import androidx.core.location.LocationRequestCompat;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
final class u implements i {
    public final e a = new e();
    public final aa b;
    boolean c;

    u(aa aaVar) {
        if (aaVar == null) {
            throw new NullPointerException("source == null");
        }
        this.b = aaVar;
    }

    @Override // com.component.lottie.e.i
    public e c() {
        return this.a;
    }

    @Override // com.component.lottie.e.i
    public e d() {
        return this.a;
    }

    @Override // com.component.lottie.e.i
    public boolean h() {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        return this.a.h() && this.b.a(this.a, 8192L) == -1;
    }

    @Override // com.component.lottie.e.i
    public void a(long j) throws EOFException {
        if (!b(j)) {
            throw new EOFException();
        }
    }

    @Override // com.component.lottie.e.i
    public boolean b(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (this.a.c < j) {
            if (this.b.a(this.a, 8192L) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // com.component.lottie.e.i
    public byte l() throws EOFException {
        a(1L);
        return this.a.l();
    }

    @Override // com.component.lottie.e.i
    public j u() {
        this.a.a(this.b);
        return this.a.u();
    }

    @Override // com.component.lottie.e.i
    public j d(long j) throws EOFException {
        a(j);
        return this.a.d(j);
    }

    @Override // com.component.lottie.e.i
    public int a(q qVar) throws EOFException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        do {
            int iA = this.a.a(qVar, true);
            if (iA == -1) {
                return -1;
            }
            if (iA != -2) {
                this.a.i(qVar.a[iA].k());
                return iA;
            }
        } while (this.b.a(this.a, 8192L) != -1);
        return -1;
    }

    @Override // com.component.lottie.e.i
    public byte[] z() {
        this.a.a(this.b);
        return this.a.z();
    }

    @Override // com.component.lottie.e.i
    public byte[] h(long j) throws EOFException {
        a(j);
        return this.a.h(j);
    }

    @Override // com.component.lottie.e.aa
    public long a(e eVar, long j) {
        if (eVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (this.a.c == 0 && this.b.a(this.a, 8192L) == -1) {
            return -1L;
        }
        return this.a.a(eVar, Math.min(j, this.a.c));
    }

    @Override // com.component.lottie.e.i
    public int b(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    @Override // com.component.lottie.e.i
    public int a(byte[] bArr, int i, int i2) {
        long j = i2;
        k.a(bArr.length, i, j);
        if (this.a.c == 0 && this.b.a(this.a, 8192L) == -1) {
            return -1;
        }
        return this.a.a(bArr, i, (int) Math.min(j, this.a.c));
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        if (this.a.c == 0 && this.b.a(this.a, 8192L) == -1) {
            return -1;
        }
        return this.a.read(byteBuffer);
    }

    @Override // com.component.lottie.e.i
    public void a(byte[] bArr) throws EOFException {
        try {
            a(bArr.length);
            this.a.a(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (this.a.c > 0) {
                int iA = this.a.a(bArr, i, (int) this.a.c);
                if (iA == -1) {
                    throw new AssertionError();
                }
                i += iA;
            }
            throw e;
        }
    }

    @Override // com.component.lottie.e.i
    public void b(e eVar, long j) throws EOFException {
        try {
            a(j);
            this.a.b(eVar, j);
        } catch (EOFException e) {
            eVar.a((aa) this.a);
            throw e;
        }
    }

    @Override // com.component.lottie.e.i
    public long a(z zVar) {
        if (zVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        long j = 0;
        while (this.b.a(this.a, 8192L) != -1) {
            long jK = this.a.k();
            if (jK > 0) {
                j += jK;
                zVar.a_(this.a, jK);
            }
        }
        if (this.a.b() > 0) {
            long jB = j + this.a.b();
            zVar.a_(this.a, this.a.b());
            return jB;
        }
        return j;
    }

    @Override // com.component.lottie.e.i
    public String v() {
        this.a.a(this.b);
        return this.a.v();
    }

    @Override // com.component.lottie.e.i
    public String e(long j) throws EOFException {
        a(j);
        return this.a.e(j);
    }

    @Override // com.component.lottie.e.i
    public String a(Charset charset) {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        this.a.a(this.b);
        return this.a.a(charset);
    }

    @Override // com.component.lottie.e.i
    public String a(long j, Charset charset) throws EOFException {
        a(j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        return this.a.a(j, charset);
    }

    @Override // com.component.lottie.e.i
    public String w() {
        long jA = a((byte) 10);
        if (jA != -1) {
            return this.a.f(jA);
        }
        if (this.a.c != 0) {
            return e(this.a.c);
        }
        return null;
    }

    @Override // com.component.lottie.e.i
    public String x() {
        return g(LocationRequestCompat.PASSIVE_INTERVAL);
    }

    @Override // com.component.lottie.e.i
    public String g(long j) throws EOFException {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: " + j);
        }
        long j2 = j == LocationRequestCompat.PASSIVE_INTERVAL ? Long.MAX_VALUE : j + 1;
        long jA = a((byte) 10, 0L, j2);
        if (jA != -1) {
            return this.a.f(jA);
        }
        if (j2 < LocationRequestCompat.PASSIVE_INTERVAL && b(j2) && this.a.c(j2 - 1) == 13 && b(1 + j2) && this.a.c(j2) == 10) {
            return this.a.f(j2);
        }
        e eVar = new e();
        this.a.a(eVar, 0L, Math.min(32L, this.a.b()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.a.b(), j) + " content=" + eVar.u().h() + (char) 8230);
    }

    @Override // com.component.lottie.e.i
    public int y() throws EOFException {
        a(1L);
        byte bC = this.a.c(0L);
        if ((bC & 224) == 192) {
            a(2L);
        } else if ((bC & 240) == 224) {
            a(3L);
        } else if ((bC & 248) == 240) {
            a(4L);
        }
        return this.a.y();
    }

    @Override // com.component.lottie.e.i
    public short m() throws EOFException {
        a(2L);
        return this.a.m();
    }

    @Override // com.component.lottie.e.i
    public short p() throws EOFException {
        a(2L);
        return this.a.p();
    }

    @Override // com.component.lottie.e.i
    public int n() throws EOFException {
        a(4L);
        return this.a.n();
    }

    @Override // com.component.lottie.e.i
    public int q() throws EOFException {
        a(4L);
        return this.a.q();
    }

    @Override // com.component.lottie.e.i
    public long o() throws EOFException {
        a(8L);
        return this.a.o();
    }

    @Override // com.component.lottie.e.i
    public long r() throws EOFException {
        a(8L);
        return this.a.r();
    }

    @Override // com.component.lottie.e.i
    public long s() throws EOFException {
        byte bC;
        a(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!b(i2)) {
                break;
            }
            bC = this.a.c(i);
            if ((bC < 48 || bC > 57) && !(i == 0 && bC == 45)) {
                break;
            }
            i = i2;
        }
        if (i == 0) {
            throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", Byte.valueOf(bC)));
        }
        return this.a.s();
    }

    @Override // com.component.lottie.e.i
    public long t() throws EOFException {
        byte bC;
        a(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!b(i2)) {
                break;
            }
            bC = this.a.c(i);
            if ((bC < 48 || bC > 57) && ((bC < 97 || bC > 102) && (bC < 65 || bC > 70))) {
                break;
            }
            i = i2;
        }
        if (i == 0) {
            throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", Byte.valueOf(bC)));
        }
        return this.a.t();
    }

    @Override // com.component.lottie.e.i
    public void i(long j) throws EOFException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            if (this.a.c == 0 && this.b.a(this.a, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j, this.a.b());
            this.a.i(jMin);
            j -= jMin;
        }
    }

    @Override // com.component.lottie.e.i
    public long a(byte b) {
        return a(b, 0L, LocationRequestCompat.PASSIVE_INTERVAL);
    }

    @Override // com.component.lottie.e.i
    public long a(byte b, long j) {
        return a(b, j, LocationRequestCompat.PASSIVE_INTERVAL);
    }

    @Override // com.component.lottie.e.i
    public long a(byte b, long j, long j2) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j), Long.valueOf(j2)));
        }
        while (j < j2) {
            long jA = this.a.a(b, j, j2);
            if (jA != -1) {
                return jA;
            }
            long j3 = this.a.c;
            if (j3 >= j2 || this.b.a(this.a, 8192L) == -1) {
                return -1L;
            }
            j = Math.max(j, j3);
        }
        return -1L;
    }

    @Override // com.component.lottie.e.i
    public long b(j jVar) {
        return a(jVar, 0L);
    }

    @Override // com.component.lottie.e.i
    public long a(j jVar, long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long jA = this.a.a(jVar, j);
            if (jA != -1) {
                return jA;
            }
            long j2 = this.a.c;
            if (this.b.a(this.a, 8192L) == -1) {
                return -1L;
            }
            j = Math.max(j, (j2 - jVar.k()) + 1);
        }
    }

    @Override // com.component.lottie.e.i
    public long c(j jVar) {
        return b(jVar, 0L);
    }

    @Override // com.component.lottie.e.i
    public long b(j jVar, long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long jB = this.a.b(jVar, j);
            if (jB != -1) {
                return jB;
            }
            long j2 = this.a.c;
            if (this.b.a(this.a, 8192L) == -1) {
                return -1L;
            }
            j = Math.max(j, j2);
        }
    }

    @Override // com.component.lottie.e.i
    public boolean a(long j, j jVar) {
        return a(j, jVar, 0, jVar.k());
    }

    @Override // com.component.lottie.e.i
    public boolean a(long j, j jVar, int i, int i2) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || i < 0 || i2 < 0 || jVar.k() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            long j2 = i3 + j;
            if (!b(1 + j2) || this.a.c(j2) != jVar.b(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.component.lottie.e.i
    public i i() {
        return l.a(new r(this));
    }

    @Override // com.component.lottie.e.i
    public InputStream j() {
        return new v(this);
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.c;
    }

    @Override // com.component.lottie.e.aa, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.c) {
            return;
        }
        this.c = true;
        this.b.close();
        this.a.A();
    }

    @Override // com.component.lottie.e.aa
    public ab a() {
        return this.b.a();
    }

    public String toString() {
        return "buffer(" + this.b + ")";
    }
}
