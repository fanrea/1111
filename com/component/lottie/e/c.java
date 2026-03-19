package com.component.lottie.e;

import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class c implements aa {
    final /* synthetic */ aa a;
    final /* synthetic */ a b;

    c(a aVar, aa aaVar) {
        this.b = aVar;
        this.a = aaVar;
    }

    @Override // com.component.lottie.e.aa
    public long a(e eVar, long j) {
        this.b.a();
        try {
            try {
                long jA = this.a.a(eVar, j);
                this.b.a(true);
                return jA;
            } catch (IOException e) {
                throw this.b.a(e);
            }
        } catch (Throwable th) {
            this.b.a(false);
            throw th;
        }
    }

    @Override // com.component.lottie.e.aa, java.io.Closeable, java.lang.AutoCloseable
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

    @Override // com.component.lottie.e.aa
    public ab a() {
        return this.b;
    }

    public String toString() {
        return "AsyncTimeout.source(" + this.a + ")";
    }
}
