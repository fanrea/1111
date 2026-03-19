package com.kwad.lottie.model.content;

import android.graphics.PointF;
import com.kwad.lottie.model.a.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a implements b {
    private final com.kwad.lottie.model.a.f bnA;
    private final boolean bnB;
    private final m<PointF, PointF> bnu;
    private final String name;

    public a(String str, m<PointF, PointF> mVar, com.kwad.lottie.model.a.f fVar, boolean z) {
        this.name = str;
        this.bnu = mVar;
        this.bnA = fVar;
        this.bnB = z;
    }

    @Override // com.kwad.lottie.model.content.b
    public final com.kwad.lottie.a.a.b a(com.kwad.lottie.f fVar, com.kwad.lottie.model.layer.a aVar) {
        return new com.kwad.lottie.a.a.e(fVar, aVar, this);
    }

    public final String getName() {
        return this.name;
    }

    public final m<PointF, PointF> Rm() {
        return this.bnu;
    }

    public final com.kwad.lottie.model.a.f Rt() {
        return this.bnA;
    }

    public final boolean Ru() {
        return this.bnB;
    }
}
