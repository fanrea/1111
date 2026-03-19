package com.component.lottie;

import com.component.lottie.k;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class p implements ay<t> {
    final /* synthetic */ k.b a;
    final /* synthetic */ k b;

    p(k kVar, k.b bVar) {
        this.b = kVar;
        this.a = bVar;
    }

    @Override // com.component.lottie.ay
    public void a(t tVar) {
        try {
            this.b.k = tVar;
            this.b.d(this.a);
            this.b.k.a(this.b.d);
            this.b.c(this.a);
        } catch (Throwable th) {
            this.b.a(this.a, th.getMessage());
        }
    }
}
