package com.kwad.lottie.model.content;

import com.kwad.lottie.a.a.o;
import com.kwad.lottie.model.a.l;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class g implements b {
    private final com.kwad.lottie.model.a.b bnZ;
    private final com.kwad.lottie.model.a.b boa;
    private final l bob;
    private final String name;

    public g(String str, com.kwad.lottie.model.a.b bVar, com.kwad.lottie.model.a.b bVar2, l lVar) {
        this.name = str;
        this.bnZ = bVar;
        this.boa = bVar2;
        this.bob = lVar;
    }

    public final String getName() {
        return this.name;
    }

    public final com.kwad.lottie.model.a.b RQ() {
        return this.bnZ;
    }

    public final com.kwad.lottie.model.a.b RR() {
        return this.boa;
    }

    public final l RS() {
        return this.bob;
    }

    @Override // com.kwad.lottie.model.content.b
    public final com.kwad.lottie.a.a.b a(com.kwad.lottie.f fVar, com.kwad.lottie.model.layer.a aVar) {
        return new o(fVar, aVar, this);
    }
}
