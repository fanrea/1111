package com.component.lottie.a.b;

import java.util.Collections;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class t<K, A> extends a<K, A> {
    private final A d;

    public t(com.component.lottie.h.j<A> jVar) {
        this(jVar, null);
    }

    public t(com.component.lottie.h.j<A> jVar, A a) {
        super(Collections.emptyList());
        a(jVar);
        this.d = a;
    }

    @Override // com.component.lottie.a.b.a
    public void a(float f) {
        this.b = f;
    }

    @Override // com.component.lottie.a.b.a
    float f() {
        return 1.0f;
    }

    @Override // com.component.lottie.a.b.a
    public void b() {
        if (this.c != null) {
            super.b();
        }
    }

    @Override // com.component.lottie.a.b.a
    public A g() {
        return this.c.a(0.0f, 0.0f, this.d, this.d, h(), h(), h());
    }

    @Override // com.component.lottie.a.b.a
    A a(com.component.lottie.h.a<K> aVar, float f) {
        return g();
    }
}
