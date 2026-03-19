package com.tachikoma.lottie.model.content;

import com.tachikoma.lottie.model.content.ShapeStroke;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class e implements b {
    private final boolean IO;
    private final ShapeStroke.LineCapType LA;
    private final ShapeStroke.LineJoinType LB;
    private final float LC;
    private final List<com.tachikoma.lottie.model.a.b> LD;
    private final com.tachikoma.lottie.model.a.b LE;
    private final com.tachikoma.lottie.model.a.d Lj;
    private final GradientType Ls;
    private final com.tachikoma.lottie.model.a.c Lu;
    private final com.tachikoma.lottie.model.a.f Lv;
    private final com.tachikoma.lottie.model.a.f Lw;
    private final com.tachikoma.lottie.model.a.b Lz;
    private final String name;

    public e(String str, GradientType gradientType, com.tachikoma.lottie.model.a.c cVar, com.tachikoma.lottie.model.a.d dVar, com.tachikoma.lottie.model.a.f fVar, com.tachikoma.lottie.model.a.f fVar2, com.tachikoma.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<com.tachikoma.lottie.model.a.b> list, com.tachikoma.lottie.model.a.b bVar2, boolean z) {
        this.name = str;
        this.Ls = gradientType;
        this.Lu = cVar;
        this.Lj = dVar;
        this.Lv = fVar;
        this.Lw = fVar2;
        this.Lz = bVar;
        this.LA = lineCapType;
        this.LB = lineJoinType;
        this.LC = f;
        this.LD = list;
        this.LE = bVar2;
        this.IO = z;
    }

    public final String getName() {
        return this.name;
    }

    public final GradientType kS() {
        return this.Ls;
    }

    public final com.tachikoma.lottie.model.a.c kT() {
        return this.Lu;
    }

    public final com.tachikoma.lottie.model.a.d kJ() {
        return this.Lj;
    }

    public final com.tachikoma.lottie.model.a.f kU() {
        return this.Lv;
    }

    public final com.tachikoma.lottie.model.a.f kV() {
        return this.Lw;
    }

    public final com.tachikoma.lottie.model.a.b kW() {
        return this.Lz;
    }

    public final ShapeStroke.LineCapType kX() {
        return this.LA;
    }

    public final ShapeStroke.LineJoinType kY() {
        return this.LB;
    }

    public final List<com.tachikoma.lottie.model.a.b> kZ() {
        return this.LD;
    }

    public final com.tachikoma.lottie.model.a.b la() {
        return this.LE;
    }

    public final float lb() {
        return this.LC;
    }

    public final boolean isHidden() {
        return this.IO;
    }

    @Override // com.tachikoma.lottie.model.content.b
    public final com.tachikoma.lottie.a.a.c a(com.tachikoma.lottie.g gVar, com.tachikoma.lottie.model.layer.a aVar) {
        return new com.tachikoma.lottie.a.a.i(gVar, aVar, this);
    }
}
