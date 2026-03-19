package com.kwad.lottie.model.content;

import android.graphics.Path;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d implements b {
    private final GradientType bnD;
    private final Path.FillType bnE;
    private final com.kwad.lottie.model.a.c bnF;
    private final com.kwad.lottie.model.a.f bnG;
    private final com.kwad.lottie.model.a.f bnH;
    private final com.kwad.lottie.model.a.b bnI = null;
    private final com.kwad.lottie.model.a.b bnJ = null;
    private final com.kwad.lottie.model.a.d bnx;
    private final String name;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.kwad.lottie.model.a.c cVar, com.kwad.lottie.model.a.d dVar, com.kwad.lottie.model.a.f fVar, com.kwad.lottie.model.a.f fVar2, com.kwad.lottie.model.a.b bVar, com.kwad.lottie.model.a.b bVar2) {
        this.bnD = gradientType;
        this.bnE = fillType;
        this.bnF = cVar;
        this.bnx = dVar;
        this.bnG = fVar;
        this.bnH = fVar2;
        this.name = str;
    }

    public final String getName() {
        return this.name;
    }

    public final GradientType Rw() {
        return this.bnD;
    }

    public final Path.FillType getFillType() {
        return this.bnE;
    }

    public final com.kwad.lottie.model.a.c Rx() {
        return this.bnF;
    }

    public final com.kwad.lottie.model.a.d Rp() {
        return this.bnx;
    }

    public final com.kwad.lottie.model.a.f Ry() {
        return this.bnG;
    }

    public final com.kwad.lottie.model.a.f Rz() {
        return this.bnH;
    }

    @Override // com.kwad.lottie.model.content.b
    public final com.kwad.lottie.a.a.b a(com.kwad.lottie.f fVar, com.kwad.lottie.model.layer.a aVar) {
        return new com.kwad.lottie.a.a.g(fVar, aVar, this);
    }
}
