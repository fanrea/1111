package com.kwad.lottie.model.content;

import android.graphics.PointF;
import com.kwad.lottie.a.a.n;
import com.kwad.lottie.model.a.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class f implements b {
    private final com.kwad.lottie.model.a.f bnA;
    private final com.kwad.lottie.model.a.b bnY;
    private final m<PointF, PointF> bnu;
    private final String name;

    public f(String str, m<PointF, PointF> mVar, com.kwad.lottie.model.a.f fVar, com.kwad.lottie.model.a.b bVar) {
        this.name = str;
        this.bnu = mVar;
        this.bnA = fVar;
        this.bnY = bVar;
    }

    public final String getName() {
        return this.name;
    }

    public final com.kwad.lottie.model.a.b RP() {
        return this.bnY;
    }

    public final com.kwad.lottie.model.a.f Rt() {
        return this.bnA;
    }

    public final m<PointF, PointF> Rm() {
        return this.bnu;
    }

    @Override // com.kwad.lottie.model.content.b
    public final com.kwad.lottie.a.a.b a(com.kwad.lottie.f fVar, com.kwad.lottie.model.layer.a aVar) {
        return new n(fVar, aVar, this);
    }

    public final String toString() {
        return "RectangleShape{position=" + this.bnu + ", size=" + this.bnA + '}';
    }
}
