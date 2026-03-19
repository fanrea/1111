package com.kwad.lottie.a.b;

import java.util.Collections;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class p<K, A> extends a<K, A> {
    private final com.kwad.lottie.e.b<A> bmI;

    @Override // com.kwad.lottie.a.b.a
    final float QR() {
        return 1.0f;
    }

    public p(com.kwad.lottie.e.c<A> cVar) {
        super(Collections.emptyList());
        this.bmI = new com.kwad.lottie.e.b<>();
        a(cVar);
    }

    @Override // com.kwad.lottie.a.b.a
    public final void kL() {
        if (this.bmn != null) {
            super.kL();
        }
    }

    @Override // com.kwad.lottie.a.b.a
    public final A getValue() {
        return this.bmn.b(0.0f, 0.0f, null, null, getProgress(), getProgress(), getProgress());
    }

    @Override // com.kwad.lottie.a.b.a
    final A a(com.kwad.lottie.e.a<K> aVar, float f) {
        return getValue();
    }
}
