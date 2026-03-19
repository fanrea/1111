package com.component.lottie.e;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class m implements z {
    final /* synthetic */ ab a;
    final /* synthetic */ OutputStream b;

    m(ab abVar, OutputStream outputStream) {
        this.a = abVar;
        this.b = outputStream;
    }

    @Override // com.component.lottie.e.z
    public void a_(e eVar, long j) throws IOException {
        k.a(eVar.c, 0L, j);
        while (j > 0) {
            this.a.j();
            w wVar = eVar.b;
            int iMin = (int) Math.min(j, wVar.e - wVar.d);
            this.b.write(wVar.c, wVar.d, iMin);
            wVar.d += iMin;
            long j2 = iMin;
            j -= j2;
            eVar.c -= j2;
            if (wVar.d == wVar.e) {
                eVar.b = wVar.c();
                x.a(wVar);
            }
        }
    }

    @Override // com.component.lottie.e.z, java.io.Flushable
    public void flush() throws IOException {
        this.b.flush();
    }

    @Override // com.component.lottie.e.z, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.b.close();
    }

    @Override // com.component.lottie.e.z
    public ab a() {
        return this.a;
    }

    public String toString() {
        return "sink(" + this.b + ")";
    }
}
