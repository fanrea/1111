package com.kwad.lottie.model.content;

import com.kwad.lottie.model.content.ShapeStroke;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e implements b {
    private final GradientType bnD;
    private final com.kwad.lottie.model.a.c bnF;
    private final com.kwad.lottie.model.a.f bnG;
    private final com.kwad.lottie.model.a.f bnH;
    private final com.kwad.lottie.model.a.b bnK;
    private final ShapeStroke.LineCapType bnL;
    private final ShapeStroke.LineJoinType bnM;
    private final float bnN;
    private final List<com.kwad.lottie.model.a.b> bnO;
    private final com.kwad.lottie.model.a.b bnP;
    private final com.kwad.lottie.model.a.d bnx;
    private final String name;

    public e(String str, GradientType gradientType, com.kwad.lottie.model.a.c cVar, com.kwad.lottie.model.a.d dVar, com.kwad.lottie.model.a.f fVar, com.kwad.lottie.model.a.f fVar2, com.kwad.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<com.kwad.lottie.model.a.b> list, com.kwad.lottie.model.a.b bVar2) {
        this.name = str;
        this.bnD = gradientType;
        this.bnF = cVar;
        this.bnx = dVar;
        this.bnG = fVar;
        this.bnH = fVar2;
        this.bnK = bVar;
        this.bnL = lineCapType;
        this.bnM = lineJoinType;
        this.bnN = f;
        this.bnO = list;
        this.bnP = bVar2;
    }

    public final String getName() {
        return this.name;
    }

    public final GradientType Rw() {
        return this.bnD;
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

    public final com.kwad.lottie.model.a.b RA() {
        return this.bnK;
    }

    public final ShapeStroke.LineCapType RB() {
        return this.bnL;
    }

    public final ShapeStroke.LineJoinType RC() {
        return this.bnM;
    }

    public final List<com.kwad.lottie.model.a.b> RD() {
        return this.bnO;
    }

    public final com.kwad.lottie.model.a.b RE() {
        return this.bnP;
    }

    public final float RF() {
        return this.bnN;
    }

    @Override // com.kwad.lottie.model.content.b
    public final com.kwad.lottie.a.a.b a(com.kwad.lottie.f fVar, com.kwad.lottie.model.layer.a aVar) {
        return new com.kwad.lottie.a.a.h(fVar, aVar, this);
    }
}
