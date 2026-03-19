package com.tachikoma.lottie.a.b;

import java.util.Collections;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class p<K, A> extends a<K, A> {
    private final com.tachikoma.lottie.e.b<A> Ko;
    private final A Kp;

    @Override // com.tachikoma.lottie.a.b.a
    final float kg() {
        return 1.0f;
    }

    public p(com.tachikoma.lottie.e.c<A> cVar) {
        this(cVar, null);
    }

    public p(com.tachikoma.lottie.e.c<A> cVar, A a) {
        super(Collections.emptyList());
        this.Ko = new com.tachikoma.lottie.e.b<>();
        a(cVar);
        this.Kp = a;
    }

    @Override // com.tachikoma.lottie.a.b.a
    public final void jN() {
        if (this.JG != null) {
            super.jN();
        }
    }

    @Override // com.tachikoma.lottie.a.b.a
    public final A getValue() {
        com.tachikoma.lottie.e.c<A> cVar = this.JG;
        A a = this.Kp;
        return cVar.b(0.0f, 0.0f, a, a, getProgress(), getProgress(), getProgress());
    }

    @Override // com.tachikoma.lottie.a.b.a
    final A a(com.tachikoma.lottie.e.a<K> aVar, float f) {
        return getValue();
    }
}
