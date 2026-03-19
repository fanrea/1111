package com.component.lottie.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
final class r implements aa {
    private final i a;
    private final e b;
    private w c;
    private int d;
    private boolean e;
    private long f;

    r(i iVar) {
        this.a = iVar;
        this.b = iVar.d();
        this.c = this.b.b;
        this.d = this.c != null ? this.c.d : -1;
    }

    @Override // com.component.lottie.e.aa
    public long a(e eVar, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.e) {
            throw new IllegalStateException("closed");
        }
        if (this.c != null && (this.c != this.b.b || this.d != this.b.b.d)) {
            throw new IllegalStateException("Peek source is invalid because upstream source was used");
        }
        if (j == 0) {
            return 0L;
        }
        if (!this.a.b(this.f + 1)) {
            return -1L;
        }
        if (this.c == null && this.b.b != null) {
            this.c = this.b.b;
            this.d = this.b.b.d;
        }
        long jMin = Math.min(j, this.b.c - this.f);
        this.b.a(eVar, this.f, jMin);
        this.f += jMin;
        return jMin;
    }

    @Override // com.component.lottie.e.aa
    public ab a() {
        return this.a.a();
    }

    @Override // com.component.lottie.e.aa, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.e = true;
    }
}
