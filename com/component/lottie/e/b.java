package com.component.lottie.e;

import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class b implements z {
    final /* synthetic */ z a;
    final /* synthetic */ a b;

    b(a aVar, z zVar) {
        this.b = aVar;
        this.a = zVar;
    }

    @Override // com.component.lottie.e.z
    public void a_(e eVar, long j) {
        k.a(eVar.c, 0L, j);
        while (true) {
            long j2 = 0;
            if (j > 0) {
                w wVar = eVar.b;
                while (true) {
                    if (j2 >= 65536) {
                        break;
                    }
                    j2 += wVar.e - wVar.d;
                    if (j2 < j) {
                        wVar = wVar.h;
                    } else {
                        j2 = j;
                        break;
                    }
                }
                this.b.a();
                try {
                    try {
                        this.a.a_(eVar, j2);
                        j -= j2;
                        this.b.a(true);
                    } catch (IOException e) {
                        throw this.b.a(e);
                    }
                } catch (Throwable th) {
                    this.b.a(false);
                    throw th;
                }
            } else {
                return;
            }
        }
    }

    @Override // com.component.lottie.e.z, java.io.Flushable
    public void flush() {
        this.b.a();
        try {
            try {
                this.a.flush();
                this.b.a(true);
            } catch (IOException e) {
                throw this.b.a(e);
            }
        } catch (Throwable th) {
            this.b.a(false);
            throw th;
        }
    }

    @Override // com.component.lottie.e.z, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.b.a();
        try {
            try {
                this.a.close();
                this.b.a(true);
            } catch (IOException e) {
                throw this.b.a(e);
            }
        } catch (Throwable th) {
            this.b.a(false);
            throw th;
        }
    }

    @Override // com.component.lottie.e.z
    public ab a() {
        return this.b;
    }

    public String toString() {
        return "AsyncTimeout.sink(" + this.a + ")";
    }
}
