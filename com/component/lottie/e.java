package com.component.lottie;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class e implements ay<Throwable> {
    e() {
    }

    @Override // com.component.lottie.ay
    public void a(Throwable th) {
        if (com.component.lottie.g.g.a(th)) {
            com.component.lottie.g.c.b("Unable to load composition.", th);
            return;
        }
        throw new IllegalStateException("Unable to parse composition", th);
    }
}
