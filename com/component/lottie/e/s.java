package com.component.lottie.e;

import java.io.EOFException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
final class s implements h {
    public final e a = new e();
    public final z b;
    boolean c;

    s(z zVar) {
        if (zVar == null) {
            throw new NullPointerException("sink == null");
        }
        this.b = zVar;
    }

    @Override // com.component.lottie.e.h, com.component.lottie.e.i
    public e c() {
        return this.a;
    }

    @Override // com.component.lottie.e.h
    public h b(String str) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.b(str);
        return K();
    }

    @Override // com.component.lottie.e.h
    public h b(String str, int i, int i2) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.b(str, i, i2);
        return K();
    }

    @Override // com.component.lottie.e.h
    public h n(int i) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.n(i);
        return K();
    }

    @Override // com.component.lottie.e.h
    public h b(String str, Charset charset) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.b(str, charset);
        return K();
    }

    @Override // com.component.lottie.e.h
    public h b(String str, int i, int i2, Charset charset) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.b(str, i, i2, charset);
        return K();
    }

    @Override // com.component.lottie.e.z
    public void a_(e eVar, long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.a_(eVar, j);
        K();
    }

    @Override // com.component.lottie.e.h
    public h g(j jVar) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.g(jVar);
        return K();
    }

    @Override // com.component.lottie.e.h
    public h d(byte[] bArr) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.d(bArr);
        return K();
    }

    @Override // com.component.lottie.e.h
    public h c(byte[] bArr, int i, int i2) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.c(bArr, i, i2);
        return K();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.a.write(byteBuffer);
        K();
        return iWrite;
    }

    @Override // com.component.lottie.e.h
    public h a(aa aaVar, long j) throws EOFException {
        while (j > 0) {
            long jA = aaVar.a(this.a, j);
            if (jA == -1) {
                throw new EOFException();
            }
            j -= jA;
            K();
        }
        return this;
    }

    @Override // com.component.lottie.e.h
    public long a(aa aaVar) {
        if (aaVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long jA = aaVar.a(this.a, 8192L);
            if (jA != -1) {
                j += jA;
                K();
            } else {
                return j;
            }
        }
    }

    @Override // com.component.lottie.e.h
    public h m(int i) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.m(i);
        return K();
    }

    @Override // com.component.lottie.e.h
    public h l(int i) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.l(i);
        return K();
    }

    @Override // com.component.lottie.e.h
    public h k(int i) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.k(i);
        return K();
    }

    @Override // com.component.lottie.e.h
    public h j(int i) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.j(i);
        return K();
    }

    @Override // com.component.lottie.e.h
    public h i(int i) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.i(i);
        return K();
    }

    @Override // com.component.lottie.e.h
    public h q(long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.q(j);
        return K();
    }

    @Override // com.component.lottie.e.h
    public h p(long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.p(j);
        return K();
    }

    @Override // com.component.lottie.e.h
    public h o(long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.o(j);
        return K();
    }

    @Override // com.component.lottie.e.h
    public h n(long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.n(j);
        return K();
    }

    @Override // com.component.lottie.e.h
    public h K() {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        long jK = this.a.k();
        if (jK > 0) {
            this.b.a_(this.a, jK);
        }
        return this;
    }

    @Override // com.component.lottie.e.h
    public h g() {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        long jB = this.a.b();
        if (jB > 0) {
            this.b.a_(this.a, jB);
        }
        return this;
    }

    @Override // com.component.lottie.e.h
    public OutputStream e() {
        return new t(this);
    }

    @Override // com.component.lottie.e.h, com.component.lottie.e.z, java.io.Flushable
    public void flush() {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (this.a.c > 0) {
            this.b.a_(this.a, this.a.c);
        }
        this.b.flush();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.c;
    }

    @Override // com.component.lottie.e.z, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.c) {
            return;
        }
        try {
            if (this.a.c > 0) {
                this.b.a_(this.a, this.a.c);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.b.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.c = true;
        if (th != null) {
            k.a(th);
        }
    }

    @Override // com.component.lottie.e.z
    public ab a() {
        return this.b.a();
    }

    public String toString() {
        return "buffer(" + this.b + ")";
    }
}
