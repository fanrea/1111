package com.component.lottie;

import com.component.lottie.k;
import com.component.lottie.k.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class n implements ay<t> {
    final /* synthetic */ k.b a;
    final /* synthetic */ k b;

    n(k kVar, k.b bVar) {
        this.b = kVar;
        this.a = bVar;
    }

    @Override // com.component.lottie.ay
    public void a(t tVar) {
        try {
            this.b.k = tVar;
            this.b.d(this.a);
            if (!this.b.c(this.a)) {
                this.b.a(this.b.new c(this.a), this.a);
            }
        } catch (Throwable th) {
            this.b.a(this.a, th.getMessage());
        }
    }
}
