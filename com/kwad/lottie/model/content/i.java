package com.kwad.lottie.model.content;

import android.graphics.Path;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class i implements b {
    private final Path.FillType bnE;
    private final com.kwad.lottie.model.a.a bnp;
    private final com.kwad.lottie.model.a.d bnx;
    private final boolean boe;
    private final String name;

    public i(String str, boolean z, Path.FillType fillType, com.kwad.lottie.model.a.a aVar, com.kwad.lottie.model.a.d dVar) {
        this.name = str;
        this.boe = z;
        this.bnE = fillType;
        this.bnp = aVar;
        this.bnx = dVar;
    }

    public final String getName() {
        return this.name;
    }

    public final com.kwad.lottie.model.a.a RV() {
        return this.bnp;
    }

    public final com.kwad.lottie.model.a.d Rp() {
        return this.bnx;
    }

    public final Path.FillType getFillType() {
        return this.bnE;
    }

    @Override // com.kwad.lottie.model.content.b
    public final com.kwad.lottie.a.a.b a(com.kwad.lottie.f fVar, com.kwad.lottie.model.layer.a aVar) {
        return new com.kwad.lottie.a.a.f(fVar, aVar, this);
    }

    public final String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.boe + '}';
    }
}
