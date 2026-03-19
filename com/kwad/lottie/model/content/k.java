package com.kwad.lottie.model.content;

import com.kwad.lottie.a.a.p;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class k implements b {
    private final com.kwad.lottie.model.a.h bog;
    private final int index;
    private final String name;

    public k(String str, int i, com.kwad.lottie.model.a.h hVar) {
        this.name = str;
        this.index = i;
        this.bog = hVar;
    }

    public final String getName() {
        return this.name;
    }

    public final com.kwad.lottie.model.a.h RW() {
        return this.bog;
    }

    @Override // com.kwad.lottie.model.content.b
    public final com.kwad.lottie.a.a.b a(com.kwad.lottie.f fVar, com.kwad.lottie.model.layer.a aVar) {
        return new p(fVar, aVar, this);
    }

    public final String toString() {
        return "ShapePath{name=" + this.name + ", index=" + this.index + '}';
    }
}
