package com.component.lottie.e;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class n implements aa {
    final /* synthetic */ ab a;
    final /* synthetic */ InputStream b;

    n(ab abVar, InputStream inputStream) {
        this.a = abVar;
        this.b = inputStream;
    }

    @Override // com.component.lottie.e.aa
    public long a(e eVar, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (j == 0) {
            return 0L;
        }
        try {
            this.a.j();
            w wVarG = eVar.g(1);
            int i = this.b.read(wVarG.c, wVarG.e, (int) Math.min(j, 8192 - wVarG.e));
            if (i == -1) {
                return -1L;
            }
            wVarG.e += i;
            long j2 = i;
            eVar.c += j2;
            return j2;
        } catch (AssertionError e) {
            if (l.a(e)) {
                throw new IOException(e);
            }
            throw e;
        }
    }

    @Override // com.component.lottie.e.aa, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.b.close();
    }

    @Override // com.component.lottie.e.aa
    public ab a() {
        return this.a;
    }

    public String toString() {
        return "source(" + this.b + ")";
    }
}
